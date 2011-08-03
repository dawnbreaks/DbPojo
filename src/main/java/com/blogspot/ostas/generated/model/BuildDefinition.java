package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.sql.Timestamp;


public class BuildDefinition {
    private long buildDefinitionId;
    private String buildDefinitionType;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private String xmlDefinitionData;
    private long buildId;

    public void setBuildDefinitionId(long buildDefinitionId) {
        this.buildDefinitionId = buildDefinitionId;
    }

    public long getBuildDefinitionId() {
        return this.buildDefinitionId;
    }

    public void setBuildDefinitionType(String buildDefinitionType) {
        this.buildDefinitionType = buildDefinitionType;
    }

    public String getBuildDefinitionType() {
        return this.buildDefinitionType;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getCreatedDate() {
        return this.createdDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Timestamp getUpdatedDate() {
        return this.updatedDate;
    }

    public void setXmlDefinitionData(String xmlDefinitionData) {
        this.xmlDefinitionData = xmlDefinitionData;
    }

    public String getXmlDefinitionData() {
        return this.xmlDefinitionData;
    }

    public void setBuildId(long buildId) {
        this.buildId = buildId;
    }

    public long getBuildId() {
        return this.buildId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BuildDefinition)) {
            return false;
        }

        BuildDefinition rhs = (BuildDefinition) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(buildDefinitionId,
            rhs.buildDefinitionId)
                                  .append(buildDefinitionType,
            rhs.buildDefinitionType).append(createdDate, rhs.createdDate)
                                  .append(updatedDate, rhs.updatedDate)
                                  .append(xmlDefinitionData,
            rhs.xmlDefinitionData).append(buildId, rhs.buildId).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(buildDefinitionId)
                                          .append(buildDefinitionType)
                                          .append(createdDate)
                                          .append(updatedDate)
                                          .append(xmlDefinitionData)
                                          .append(buildId).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("buildDefinitionId",
            buildDefinitionId).append("buildDefinitionType", buildDefinitionType)
                                        .append("createdDate", createdDate)
                                        .append("updatedDate", updatedDate)
                                        .append("xmlDefinitionData",
            xmlDefinitionData).append("buildId", buildId).toString();
    }
}
