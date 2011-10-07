package com.blogspot.ostas.dbpojo;

import com.blogspot.ostas.dbpojo.gen.PojoWriter;
import com.blogspot.ostas.dbpojo.model.PojoPrototype;
import org.apache.log4j.Logger;

import java.util.List;

public class PojoGeneratorMainApp
{
    private static final Logger logger = Logger.getLogger(PojoGenerator.class);

    public static void main(String[] args)
    {
        PojoGenerator pojoGenerator = new PojoGenerator();
        //String schemaName = "SYS";
        //String schemaName = "SYSMAN";
        String schemaName = "APEX_030200";
        //String schemaName = "SYSTEM";

        List<String> inSchema = pojoGenerator.getAllTablesInSchema(schemaName);

        PojoWriter pojoWriter = new PojoWriter();
        pojoWriter.setPath("src/main/java/generated/");
        pojoWriter.setTemplateName("pojo.vm");

        PojoPrototype prototype;
        for(String table : inSchema)
        {
            prototype = pojoGenerator.readTableMetadata(table,schemaName);

            pojoWriter.setFileName(prototype.getName()+".java");
            pojoWriter.write(prototype);

            logger.debug("Prototype : "+prototype);
        }
        pojoGenerator.releaseConnection();

        logger.info(inSchema.size()+" tables processed");
    }
}
