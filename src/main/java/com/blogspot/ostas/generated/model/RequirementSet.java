package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class RequirementSet {
    private long requirementSetId;

    public void setRequirementSetId(long requirementSetId) {
        this.requirementSetId = requirementSetId;
    }

    public long getRequirementSetId() {
        return this.requirementSetId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RequirementSet)) {
            return false;
        }

        RequirementSet rhs = (RequirementSet) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(requirementSetId, rhs.requirementSetId)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(requirementSetId).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("requirementSetId",
            requirementSetId).toString();
    }
}
