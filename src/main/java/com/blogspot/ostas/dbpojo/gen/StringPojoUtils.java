package com.blogspot.ostas.dbpojo.gen;

import com.blogspot.ostas.dbpojo.model.PojoPrototype;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.io.Writer;

public class StringPojoUtils {
    private VelocityEngine ve;
    private VelocityContext ctx;
    private Template t;
    public StringPojoUtils()
    {
        ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
    }
    public StringPojoUtils(String templateName)
    {
        this();
        t = ve.getTemplate(templateName);
    }
    public String pojoAsStringFromTemplate(PojoPrototype pojoPrototype) {
        Writer writer = null;
        try {
            ctx = new VelocityContext();
            ctx.put("pojo",pojoPrototype);
            writer = new StringWriter();
            t.merge(ctx, writer);
            writer.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return writer.toString();
    }
}
