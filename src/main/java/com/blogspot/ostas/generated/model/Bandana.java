package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class Bandana {
    private long bandanaId;
    private long buildId;
    private String bandanaKey;
    private String serializedData;

    public void setBandanaId(long bandanaId) {
        this.bandanaId = bandanaId;
    }

    public long getBandanaId() {
        return this.bandanaId;
    }

    public void setBuildId(long buildId) {
        this.buildId = buildId;
    }

    public long getBuildId() {
        return this.buildId;
    }

    public void setBandanaKey(String bandanaKey) {
        this.bandanaKey = bandanaKey;
    }

    public String getBandanaKey() {
        return this.bandanaKey;
    }

    public void setSerializedData(String serializedData) {
        this.serializedData = serializedData;
    }

    public String getSerializedData() {
        return this.serializedData;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Bandana)) {
            return false;
        }

        Bandana rhs = (Bandana) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(bandanaId, rhs.bandanaId)
                                  .append(buildId, rhs.buildId)
                                  .append(bandanaKey, rhs.bandanaKey)
                                  .append(serializedData, rhs.serializedData)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(bandanaId).append(buildId)
                                          .append(bandanaKey)
                                          .append(serializedData).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("bandanaId", bandanaId)
                                        .append("buildId", buildId)
                                        .append("bandanaKey", bandanaKey)
                                        .append("serializedData", serializedData)
                                        .toString();
    }
}
