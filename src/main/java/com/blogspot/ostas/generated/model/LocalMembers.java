package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class LocalMembers {
    private long userid;
    private long groupid;

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getUserid() {
        return this.userid;
    }

    public void setGroupid(long groupid) {
        this.groupid = groupid;
    }

    public long getGroupid() {
        return this.groupid;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LocalMembers)) {
            return false;
        }

        LocalMembers rhs = (LocalMembers) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(userid, rhs.userid)
                                  .append(groupid, rhs.groupid).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(userid).append(groupid)
                                          .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("userid", userid)
                                        .append("groupid", groupid).toString();
    }
}
