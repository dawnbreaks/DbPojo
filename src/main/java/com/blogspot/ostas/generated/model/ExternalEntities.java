package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class ExternalEntities {
    private long id;
    private String name;
    private String type;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ExternalEntities)) {
            return false;
        }

        ExternalEntities rhs = (ExternalEntities) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(id, rhs.id).append(name, rhs.name)
                                  .append(type, rhs.type).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(id).append(name).append(type)
                                          .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("id", id).append("name", name)
                                        .append("type", type).toString();
    }
}
