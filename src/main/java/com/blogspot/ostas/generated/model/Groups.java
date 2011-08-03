package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class Groups {
    private long id;
    private String groupname;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getGroupname() {
        return this.groupname;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Groups)) {
            return false;
        }

        Groups rhs = (Groups) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(id, rhs.id)
                                  .append(groupname, rhs.groupname).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(id).append(groupname)
                                          .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("id", id)
                                        .append("groupname", groupname)
                                        .toString();
    }
}
