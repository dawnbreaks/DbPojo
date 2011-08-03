package com.blogspot.ostas.dbpojo.gen;

import com.blogspot.ostas.dbpojo.model.PojoPrototype;

import java.io.File;

public class PojoWriter {
    private String fileName;
    private String path;
    private String templateName;
    private StringPojoUtils stringPojoUtils;
    private PojoFileUtils pojoFileUtils;
    private boolean performFormat;

    public boolean isPerformFormat() {
        return performFormat;
    }

    public void setPerformFormat(boolean performFormat) {
        this.performFormat = performFormat;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
        pojoFileUtils = new PojoFileUtils(this.path);
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
        stringPojoUtils = new StringPojoUtils(templateName);
    }

    public void write(PojoPrototype pojoPrototype)
    {
        String velocityTemplateGeneratedString = stringPojoUtils.pojoAsStringFromTemplate(pojoPrototype);
        if(fileName!=null)
        {
            pojoFileUtils.writeStringToFile(velocityTemplateGeneratedString,fileName,path);
        }
        else
        {
            pojoFileUtils.writeStringToFile(velocityTemplateGeneratedString,pojoPrototype.getName(),path);
        }
    }

    public static String packageToDirectoryStructure(String javaPackage) {
        return javaPackage.replace('.', File.separatorChar)+File.separatorChar;
    }
}
