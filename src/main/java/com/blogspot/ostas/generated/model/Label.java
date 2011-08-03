package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.sql.Timestamp;


public class Label {
    private long labelId;
    private String name;
    private String namespace;
    private Timestamp createdDate;
    private Timestamp updatedDate;

    public void setLabelId(long labelId) {
        this.labelId = labelId;
    }

    public long getLabelId() {
        return this.labelId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getNamespace() {
        return this.namespace;
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
        if (!(o instanceof Label)) {
            return false;
        }

        Label rhs = (Label) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(labelId, rhs.labelId)
                                  .append(name, rhs.name)
                                  .append(namespace, rhs.namespace)
                                  .append(createdDate, rhs.createdDate)
                                  .append(updatedDate, rhs.updatedDate)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(labelId).append(name)
                                          .append(namespace).append(createdDate)
                                          .append(updatedDate).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("labelId", labelId)
                                        .append("name", name)
                                        .append("namespace", namespace)
                                        .append("createdDate", createdDate)
                                        .append("updatedDate", updatedDate)
                                        .toString();
    }
}
