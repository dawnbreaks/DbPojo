package com.blogspot.ostas.dbpojo;

import com.blogspot.ostas.dbpojo.gen.PojoWriter;
import com.blogspot.ostas.dbpojo.model.PojoPrototype;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

public class PojoGeneratorMainApp
{
    private static final Logger logger = Logger.getLogger(PojoGenerator.class);

    public static void main(String[] args)
    {
    	
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-oracle.xml");
        PojoGenerator pojoGenerator = (PojoGenerator) context.getBean("pojoGenerator");
        String schemaName = "crmadmin";
        String packageForModel = "com.blogspot.ostas.generated.model";
        
        List<String> inSchema = pojoGenerator.getAllTablesInSchemaBySQL("SHOW TABLES FROM "+schemaName);
        
        PojoWriter pojoWriter = new PojoWriter();
        pojoWriter.setPath("src/main/java/generated/");
        pojoWriter.setTemplateName("pojo.vm");

        PojoPrototype prototype;
        for(String table : inSchema)
        {
            prototype = pojoGenerator.readTableMetadata(table,schemaName);

            prototype.setJavaPackage(packageForModel);
            pojoWriter.setFileName(prototype.getName()+".java");
            pojoWriter.write(prototype);

            logger.debug("Prototype : "+prototype);
        }
        pojoGenerator.releaseConnection();

        logger.info(inSchema.size()+" tables processed");
    }
}
