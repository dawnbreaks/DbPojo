package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class BuildAssociation {
    private long childBuildId;
    private long parentBuildId;

    public void setChildBuildId(long childBuildId) {
        this.childBuildId = childBuildId;
    }

    public long getChildBuildId() {
        return this.childBuildId;
    }

    public void setParentBuildId(long parentBuildId) {
        this.parentBuildId = parentBuildId;
    }

    public long getParentBuildId() {
        return this.parentBuildId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BuildAssociation)) {
            return false;
        }

        BuildAssociation rhs = (BuildAssociation) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(childBuildId, rhs.childBuildId)
                                  .append(parentBuildId, rhs.parentBuildId)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(childBuildId)
                                          .append(parentBuildId).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("childBuildId", childBuildId)
                                        .append("parentBuildId", parentBuildId)
                                        .toString();
    }
}
