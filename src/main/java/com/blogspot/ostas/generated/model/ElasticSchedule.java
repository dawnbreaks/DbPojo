package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class ElasticSchedule {
    private long scheduleId;
    private String cronExp;
    private int numberActive;
    private boolean enabled;
    private long elasticImage;
    private long comparison;

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public long getScheduleId() {
        return this.scheduleId;
    }

    public void setCronExp(String cronExp) {
        this.cronExp = cronExp;
    }

    public String getCronExp() {
        return this.cronExp;
    }

    public void setNumberActive(int numberActive) {
        this.numberActive = numberActive;
    }

    public int getNumberActive() {
        return this.numberActive;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setElasticImage(long elasticImage) {
        this.elasticImage = elasticImage;
    }

    public long getElasticImage() {
        return this.elasticImage;
    }

    public void setComparison(long comparison) {
        this.comparison = comparison;
    }

    public long getComparison() {
        return this.comparison;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ElasticSchedule)) {
            return false;
        }

        ElasticSchedule rhs = (ElasticSchedule) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(scheduleId, rhs.scheduleId)
                                  .append(cronExp, rhs.cronExp)
                                  .append(numberActive, rhs.numberActive)
                                  .append(enabled, rhs.enabled)
                                  .append(elasticImage, rhs.elasticImage)
                                  .append(comparison, rhs.comparison).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(scheduleId).append(cronExp)
                                          .append(numberActive).append(enabled)
                                          .append(elasticImage)
                                          .append(comparison).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("scheduleId", scheduleId)
                                        .append("cronExp", cronExp)
                                        .append("numberActive", numberActive)
                                        .append("enabled", enabled)
                                        .append("elasticImage", elasticImage)
                                        .append("comparison", comparison)
                                        .toString();
    }
}
