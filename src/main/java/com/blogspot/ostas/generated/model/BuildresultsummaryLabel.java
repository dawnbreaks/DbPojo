package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.sql.Timestamp;


public class BuildresultsummaryLabel {
    private long id;
    private long labelId;
    private long buildresultsummaryId;
    private long buildId;
    private long projectId;
    private String userName;
    private Timestamp createdDate;
    private Timestamp updatedDate;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setLabelId(long labelId) {
        this.labelId = labelId;
    }

    public long getLabelId() {
        return this.labelId;
    }

    public void setBuildresultsummaryId(long buildresultsummaryId) {
        this.buildresultsummaryId = buildresultsummaryId;
    }

    public long getBuildresultsummaryId() {
        return this.buildresultsummaryId;
    }

    public void setBuildId(long buildId) {
        this.buildId = buildId;
    }

    public long getBuildId() {
        return this.buildId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getProjectId() {
        return this.projectId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BuildresultsummaryLabel)) {
            return false;
        }

        BuildresultsummaryLabel rhs = (BuildresultsummaryLabel) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(id, rhs.id)
                                  .append(labelId, rhs.labelId)
                                  .append(buildresultsummaryId,
            rhs.buildresultsummaryId).append(buildId, rhs.buildId)
                                  .append(projectId, rhs.projectId)
                                  .append(userName, rhs.userName)
                                  .append(createdDate, rhs.createdDate)
                                  .append(updatedDate, rhs.updatedDate)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(id).append(labelId)
                                          .append(buildresultsummaryId)
                                          .append(buildId).append(projectId)
                                          .append(userName).append(createdDate)
                                          .append(updatedDate).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("id", id)
                                        .append("labelId", labelId)
                                        .append("buildresultsummaryId",
            buildresultsummaryId).append("buildId", buildId)
                                        .append("projectId", projectId)
                                        .append("userName", userName)
                                        .append("createdDate", createdDate)
                                        .append("updatedDate", updatedDate)
                                        .toString();
    }
}
