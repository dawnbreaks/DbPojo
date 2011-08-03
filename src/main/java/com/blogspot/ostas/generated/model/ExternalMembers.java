package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class ExternalMembers {
    private long extentityid;
    private long groupid;

    public void setExtentityid(long extentityid) {
        this.extentityid = extentityid;
    }

    public long getExtentityid() {
        return this.extentityid;
    }

    public void setGroupid(long groupid) {
        this.groupid = groupid;
    }

    public long getGroupid() {
        return this.groupid;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ExternalMembers)) {
            return false;
        }

        ExternalMembers rhs = (ExternalMembers) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(extentityid, rhs.extentityid)
                                  .append(groupid, rhs.groupid).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(extentityid).append(groupid)
                                          .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("extentityid", extentityid)
                                        .append("groupid", groupid).toString();
    }
}
