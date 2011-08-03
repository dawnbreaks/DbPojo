package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class CapabilitySet {
    private long capabilitySetId;
    private String capabilityType;
    private String capabilityScope;

    public void setCapabilitySetId(long capabilitySetId) {
        this.capabilitySetId = capabilitySetId;
    }

    public long getCapabilitySetId() {
        return this.capabilitySetId;
    }

    public void setCapabilityType(String capabilityType) {
        this.capabilityType = capabilityType;
    }

    public String getCapabilityType() {
        return this.capabilityType;
    }

    public void setCapabilityScope(String capabilityScope) {
        this.capabilityScope = capabilityScope;
    }

    public String getCapabilityScope() {
        return this.capabilityScope;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CapabilitySet)) {
            return false;
        }

        CapabilitySet rhs = (CapabilitySet) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(capabilitySetId, rhs.capabilitySetId)
                                  .append(capabilityType, rhs.capabilityType)
                                  .append(capabilityScope, rhs.capabilityScope)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(capabilitySetId)
                                          .append(capabilityType)
                                          .append(capabilityScope).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("capabilitySetId",
            capabilitySetId).append("capabilityType", capabilityType)
                                        .append("capabilityScope",
            capabilityScope).toString();
    }
}
