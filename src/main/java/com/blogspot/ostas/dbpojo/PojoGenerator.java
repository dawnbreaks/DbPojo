package com.blogspot.ostas.dbpojo;

import com.blogspot.ostas.dbpojo.model.PojoFieldPrototype;
import com.blogspot.ostas.dbpojo.model.PojoPrototype;
import com.blogspot.ostas.dbpojo.utils.NameConversionHelper;
import com.blogspot.ostas.dbpojo.utils.SqlTypesConversionHelper;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

//@Component
public class PojoGenerator
{
    private static Logger logger = Logger.getLogger(PojoGenerator.class);
    private Connection connection;
    //@Autowired
    private DataSource dataSource;
    private SqlTypesConversionHelper sqlTypesConversionHelper;
    private NameConversionHelper nameConversionHelper;

    public void setNameConversionHelper(NameConversionHelper nameConversionHelper) {
        this.nameConversionHelper = nameConversionHelper;
    }

    public void setSqlTypesConversionHelper(SqlTypesConversionHelper sqlTypesConversionHelper) {
        this.sqlTypesConversionHelper = sqlTypesConversionHelper;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void initConnection(){
        try {
            logger.info("Trying to obtain connection from dataSource");
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @PreDestroy
    public final void releaseConnection(){
        try {
            if(connection!=null && !connection.isClosed()){
                logger.info("Release connection....");
                connection.close();
            }
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    public final String metadataQuerySQL(String tableName)
    {
        return String.format("select * from %s where 1=2",tableName);
    }
    public PojoPrototype readTableMetadata(String tableName, String schema)
    {
        logger.info("Table : " + tableName + " Java Class : " + nameConversionHelper.tableNameToClassName(tableName));
        final String sql = metadataQuerySQL(schema+"."+tableName);
        Statement statement = null;
        ResultSet rs = null;
        ResultSetMetaData metaData;
        PojoPrototype pojoPrototype = new PojoPrototype();
        pojoPrototype.setTableName(tableName);
        pojoPrototype.setName(nameConversionHelper.tableNameToClassName(tableName));
        String imp;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            if(rs!=null){
                metaData = rs.getMetaData();
                if(metaData!=null){
                    PojoFieldPrototype pojoFieldPrototype;
                    for(int i=1;i<metaData.getColumnCount()+1;i++){
                        pojoFieldPrototype = new PojoFieldPrototype();

                        pojoFieldPrototype.setColumnName(metaData.getColumnName(i));
                        pojoFieldPrototype.setName(nameConversionHelper.columnNameToIdentifier(metaData.getColumnName(i)));
                        pojoFieldPrototype.setSqlType(metaData.getColumnTypeName(i));
                        pojoFieldPrototype.setJavaType(sqlTypesConversionHelper.sqlTypeToJavaType(metaData.getColumnTypeName(i)));
                        imp = sqlTypesConversionHelper.importStringForSqlType(metaData.getColumnTypeName(i));
                        if(imp!=null){
                            pojoPrototype.getImports().add(imp);
                        }
                        pojoPrototype.getFields().add(pojoFieldPrototype);

                        if(logger.isDebugEnabled()){
                            logger.debug(metaData.getColumnName(i) +" => "+pojoFieldPrototype.getName()+
                                    " => "+pojoFieldPrototype.getGetter()+" => "+pojoFieldPrototype.getSetter()
                                    +" => "+pojoFieldPrototype.getSqlType()
                                    +" => "+pojoFieldPrototype.getJavaType()
                                    +" => "+metaData.getScale(i)
                                    +" => "+metaData.getPrecision(i));
                        }
                    }
                }
            }
            else{
                logger.error("Metadata empty. Probably wrong table name.");
                //return null;
            }
        } catch (SQLException e) {
            logger.error("Working with table "+ tableName+" caused error : ",e);
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
        }
        return pojoPrototype;
    }
    public List<String> getAllTablesInSchema(String shemaName)
    {
        final String tablesInSchemaSQL = "select table_name from all_tables where owner=\'"+shemaName+"\'";
        List<String> tables = null;
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(tablesInSchemaSQL);
            if(resultSet!=null)
            {
                tables = new LinkedList<String>();
                String tableName;
                while (resultSet.next())
                {
                    tableName = resultSet.getString(1);
                    if(tableName!=null){
                        tables.add(tableName);
                    }
                }
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return tables;
    }

    public List<String> getAllTablesInSchemaBySQL(String sql)
    {
        List<String> tables = null;
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            if(resultSet!=null)
            {
                tables = new LinkedList<String>();
                String tableName;
                while (resultSet.next())
                {
                    tableName = resultSet.getString(1);
                    if(tableName!=null){
                        tables.add(tableName);
                    }
                }
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return tables;
    }
}
