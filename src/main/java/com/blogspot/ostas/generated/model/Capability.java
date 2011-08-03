package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class Capability {
    private long capabilityId;
    private String keyIdentifier;
    private String value;
    private long capabilitySet;

    public void setCapabilityId(long capabilityId) {
        this.capabilityId = capabilityId;
    }

    public long getCapabilityId() {
        return this.capabilityId;
    }

    public void setKeyIdentifier(String keyIdentifier) {
        this.keyIdentifier = keyIdentifier;
    }

    public String getKeyIdentifier() {
        return this.keyIdentifier;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setCapabilitySet(long capabilitySet) {
        this.capabilitySet = capabilitySet;
    }

    public long getCapabilitySet() {
        return this.capabilitySet;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Capability)) {
            return false;
        }

        Capability rhs = (Capability) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(capabilityId, rhs.capabilityId)
                                  .append(keyIdentifier, rhs.keyIdentifier)
                                  .append(value, rhs.value)
                                  .append(capabilitySet, rhs.capabilitySet)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(capabilityId)
                                          .append(keyIdentifier).append(value)
                                          .append(capabilitySet).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("capabilityId", capabilityId)
                                        .append("keyIdentifier", keyIdentifier)
                                        .append("value", value)
                                        .append("capabilitySet", capabilitySet)
                                        .toString();
    }
}
