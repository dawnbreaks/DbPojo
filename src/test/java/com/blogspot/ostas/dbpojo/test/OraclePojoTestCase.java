package com.blogspot.ostas.dbpojo.test;

import com.blogspot.ostas.dbpojo.PojoGenerator;
import com.blogspot.ostas.dbpojo.gen.PojoWriter;
import com.blogspot.ostas.dbpojo.model.PojoPrototype;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-oracle.xml"})
public class OraclePojoTestCase {
	private static final Logger logger = Logger.getLogger(OraclePojoTestCase.class);
    @Autowired
    private PojoGenerator pojoGenerator;

    @Test
    public void contextTest() throws Exception
    {
	    assertNotNull(pojoGenerator);
    }

    @Ignore @Test
    public void listOfTablesInSchema()
    {
        String schemaName = "APEX_030200";
        List<String> inSchema = pojoGenerator.getAllTablesInSchema(schemaName);
        logger.debug("List of tables : "+inSchema);
        assertNotNull(inSchema);
    }

    //oracle test
    @Ignore @Test public void testPojoPrototypes()
    {
        String schemaName = "APEX_030200";
        List<String> inSchema = pojoGenerator.getAllTablesInSchema(schemaName);

        String packageForModel = "com.blogspot.ostas.generated.model";

        PojoWriter pojoWriter = new PojoWriter();
        pojoWriter.setPath("src/main/java/"+PojoWriter.packageToDirectoryStructure(packageForModel));
        pojoWriter.setTemplateName("pojo.vm");

        PojoPrototype prototype = new PojoPrototype();
        for(String table : inSchema){
            prototype = pojoGenerator.readTableMetadata(table,schemaName);
            assertNotNull(prototype);
            prototype.setJavaPackage(packageForModel);

            pojoWriter.setFileName(prototype.getName()+".java");
            pojoWriter.write(prototype);

            logger.debug("Prototype : "+prototype);
        }
    }
    //mysql test
    //@Ignore
    @Test public void testPojoMYSQLPrototypes()
    {
        String schemaName = "bamboo";
        //String schemaName = "opencms";
        List<String> inSchema = pojoGenerator.getAllTablesInSchemaBySQL("SHOW TABLES FROM "+schemaName);

        String packageForModel = "com.blogspot.ostas.generated.model";
        String packageForDao = "com.blogspot.ostas.generated.dao";

        PojoWriter javaObj = new PojoWriter();
        javaObj.setPath("src/main/java/"+PojoWriter.packageToDirectoryStructure(packageForModel));
        javaObj.setTemplateName("pojo.vm");
        javaObj.setPerformFormat(true);

        PojoWriter javaDao = new PojoWriter();
        javaDao.setPath("src/main/java/"+PojoWriter.packageToDirectoryStructure(packageForDao));
        javaDao.setTemplateName("jdbcDao.vm");
        javaDao.setPerformFormat(true);

        PojoPrototype prototype;
        for(String table : inSchema)
        {
            prototype = pojoGenerator.readTableMetadata(table,schemaName);
            assertNotNull(prototype);
            prototype.setJavaPackage(packageForModel);

            javaObj.setFileName(prototype.getName()+".java");
            javaObj.write(prototype);

            //dao generation
            prototype.setModelItem(prototype.getName());// not changed name yet
            prototype.getImports().add(prototype.getJavaPackage()+"."+prototype.getName());

            prototype.setName(prototype.getName()+"Dao");
            prototype.setJavaPackage(packageForDao);

            javaDao.setFileName(prototype.getName()+".java");
            javaDao.write(prototype);

            logger.debug("Prototype : "+prototype);
        }
    }
    @Test public void testGeneratedApplicationConfig()
    {
        String packageForDao = "com.blogspot.ostas.generated.dao";
        PojoWriter writer = new PojoWriter();
        writer.setTemplateName("applicationContext-generated.xml.vm");
        writer.setPath("src\\test\\resources\\");
        writer.setFileName("applicationContext-generated.xml");
        writer.setPerformFormat(false);

        PojoPrototype prototypeAppContextForDaos = new PojoPrototype();
        prototypeAppContextForDaos.setJavaPackage(packageForDao);

        writer.write(prototypeAppContextForDaos);
    }
}
 