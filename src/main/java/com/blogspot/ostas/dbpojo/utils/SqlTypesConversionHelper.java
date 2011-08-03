package com.blogspot.ostas.dbpojo.utils;

public interface SqlTypesConversionHelper {
    public String sqlTypeToJavaType(String sqlType);
    public String importStringForSqlType(String sqlType);
}
