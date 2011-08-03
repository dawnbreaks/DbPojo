package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.sql.Timestamp;


public class Project {
    private long projectId;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private String projectKey;
    private String title;

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getProjectId() {
        return this.projectId;
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

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public String getProjectKey() {
        return this.projectKey;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Project)) {
            return false;
        }

        Project rhs = (Project) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(projectId, rhs.projectId)
                                  .append(createdDate, rhs.createdDate)
                                  .append(updatedDate, rhs.updatedDate)
                                  .append(projectKey, rhs.projectKey)
                                  .append(title, rhs.title).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(projectId).append(createdDate)
                                          .append(updatedDate).append(projectKey)
                                          .append(title).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("projectId", projectId)
                                        .append("createdDate", createdDate)
                                        .append("updatedDate", updatedDate)
                                        .append("projectKey", projectKey)
                                        .append("title", title).toString();
    }
}
