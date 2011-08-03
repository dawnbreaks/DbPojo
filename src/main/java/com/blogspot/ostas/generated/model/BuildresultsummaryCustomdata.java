package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class BuildresultsummaryCustomdata {
    private long buildresultsummaryId;
    private String customInfoValue;
    private String customInfoKey;

    public void setBuildresultsummaryId(long buildresultsummaryId) {
        this.buildresultsummaryId = buildresultsummaryId;
    }

    public long getBuildresultsummaryId() {
        return this.buildresultsummaryId;
    }

    public void setCustomInfoValue(String customInfoValue) {
        this.customInfoValue = customInfoValue;
    }

    public String getCustomInfoValue() {
        return this.customInfoValue;
    }

    public void setCustomInfoKey(String customInfoKey) {
        this.customInfoKey = customInfoKey;
    }

    public String getCustomInfoKey() {
        return this.customInfoKey;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BuildresultsummaryCustomdata)) {
            return false;
        }

        BuildresultsummaryCustomdata rhs = (BuildresultsummaryCustomdata) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(buildresultsummaryId,
            rhs.buildresultsummaryId)
                                  .append(customInfoValue, rhs.customInfoValue)
                                  .append(customInfoKey, rhs.customInfoKey)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(buildresultsummaryId)
                                          .append(customInfoValue)
                                          .append(customInfoKey).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("buildresultsummaryId",
            buildresultsummaryId).append("customInfoValue", customInfoValue)
                                        .append("customInfoKey", customInfoKey)
                                        .toString();
    }
}
