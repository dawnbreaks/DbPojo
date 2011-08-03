package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.sql.Timestamp;


public class OsPropertyentry {
    private String entityName;
    private long entityId;
    private String entityKey;
    private int keyType;
    private boolean booleanVal;
    private double doubleVal;
    private String stringVal;
    private String textVal;
    private long longVal;
    private int intVal;
    private Timestamp dateVal;

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityName() {
        return this.entityName;
    }

    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }

    public long getEntityId() {
        return this.entityId;
    }

    public void setEntityKey(String entityKey) {
        this.entityKey = entityKey;
    }

    public String getEntityKey() {
        return this.entityKey;
    }

    public void setKeyType(int keyType) {
        this.keyType = keyType;
    }

    public int getKeyType() {
        return this.keyType;
    }

    public void setBooleanVal(boolean booleanVal) {
        this.booleanVal = booleanVal;
    }

    public boolean getBooleanVal() {
        return this.booleanVal;
    }

    public void setDoubleVal(double doubleVal) {
        this.doubleVal = doubleVal;
    }

    public double getDoubleVal() {
        return this.doubleVal;
    }

    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }

    public String getStringVal() {
        return this.stringVal;
    }

    public void setTextVal(String textVal) {
        this.textVal = textVal;
    }

    public String getTextVal() {
        return this.textVal;
    }

    public void setLongVal(long longVal) {
        this.longVal = longVal;
    }

    public long getLongVal() {
        return this.longVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    public int getIntVal() {
        return this.intVal;
    }

    public void setDateVal(Timestamp dateVal) {
        this.dateVal = dateVal;
    }

    public Timestamp getDateVal() {
        return this.dateVal;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OsPropertyentry)) {
            return false;
        }

        OsPropertyentry rhs = (OsPropertyentry) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(entityName, rhs.entityName)
                                  .append(entityId, rhs.entityId)
                                  .append(entityKey, rhs.entityKey)
                                  .append(keyType, rhs.keyType)
                                  .append(booleanVal, rhs.booleanVal)
                                  .append(doubleVal, rhs.doubleVal)
                                  .append(stringVal, rhs.stringVal)
                                  .append(textVal, rhs.textVal)
                                  .append(longVal, rhs.longVal)
                                  .append(intVal, rhs.intVal)
                                  .append(dateVal, rhs.dateVal).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(entityName).append(entityId)
                                          .append(entityKey).append(keyType)
                                          .append(booleanVal).append(doubleVal)
                                          .append(stringVal).append(textVal)
                                          .append(longVal).append(intVal)
                                          .append(dateVal).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("entityName", entityName)
                                        .append("entityId", entityId)
                                        .append("entityKey", entityKey)
                                        .append("keyType", keyType)
                                        .append("booleanVal", booleanVal)
                                        .append("doubleVal", doubleVal)
                                        .append("stringVal", stringVal)
                                        .append("textVal", textVal)
                                        .append("longVal", longVal)
                                        .append("intVal", intVal)
                                        .append("dateVal", dateVal).toString();
    }
}
