package com.blogspot.ostas.dbpojo.model;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.util.LinkedList;
import java.util.List;

public class PojoPrototype {
    private String name;
    private String javaPackage;
    private String tableName;
    private List<PojoFieldPrototype> fields;
    private List<String> imports;

    public PojoPrototype()
    {
        fields = new LinkedList<PojoFieldPrototype>();
        imports = new LinkedList<String>();
    }

    public List<String> getImports() {
        return imports;
    }

    public void setImports(List<String> imports) {
        this.imports = imports;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJavaPackage() {
        return javaPackage;
    }

    public void setJavaPackage(String javaPackage) {
        this.javaPackage = javaPackage;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<PojoFieldPrototype> getFields() {
        return fields;
    }

    public void setFields(List<PojoFieldPrototype> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
