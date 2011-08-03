package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.sql.Timestamp;


public class Buildresultsummary {
    private long buildresultsummaryId;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private String buildKey;
    private int buildNumber;
    private String buildState;
    private long successfulTestCount;
    private long failedTestCount;
    private Timestamp buildDate;
    private Timestamp buildCompletedDate;
    private Timestamp vcsUpdateTime;
    private Timestamp queueTime;
    private long duration;
    private long timeToFix;
    private String triggerReason;
    private String revisionKey;
    private String deltaState;
    private long buildAgentId;

    public void setBuildresultsummaryId(long buildresultsummaryId) {
        this.buildresultsummaryId = buildresultsummaryId;
    }

    public long getBuildresultsummaryId() {
        return this.buildresultsummaryId;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getCreatedDate() {
        return this.createdDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Timestamp getUpdatedDate() {
        return this.updatedDate;
    }

    public void setBuildKey(String buildKey) {
        this.buildKey = buildKey;
    }

    public String getBuildKey() {
        return this.buildKey;
    }

    public void setBuildNumber(int buildNumber) {
        this.buildNumber = buildNumber;
    }

    public int getBuildNumber() {
        return this.buildNumber;
    }

    public void setBuildState(String buildState) {
        this.buildState = buildState;
    }

    public String getBuildState() {
        return this.buildState;
    }

    public void setSuccessfulTestCount(long successfulTestCount) {
        this.successfulTestCount = successfulTestCount;
    }

    public long getSuccessfulTestCount() {
        return this.successfulTestCount;
    }

    public void setFailedTestCount(long failedTestCount) {
        this.failedTestCount = failedTestCount;
    }

    public long getFailedTestCount() {
        return this.failedTestCount;
    }

    public void setBuildDate(Timestamp buildDate) {
        this.buildDate = buildDate;
    }

    public Timestamp getBuildDate() {
        return this.buildDate;
    }

    public void setBuildCompletedDate(Timestamp buildCompletedDate) {
        this.buildCompletedDate = buildCompletedDate;
    }

    public Timestamp getBuildCompletedDate() {
        return this.buildCompletedDate;
    }

    public void setVcsUpdateTime(Timestamp vcsUpdateTime) {
        this.vcsUpdateTime = vcsUpdateTime;
    }

    public Timestamp getVcsUpdateTime() {
        return this.vcsUpdateTime;
    }

    public void setQueueTime(Timestamp queueTime) {
        this.queueTime = queueTime;
    }

    public Timestamp getQueueTime() {
        return this.queueTime;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setTimeToFix(long timeToFix) {
        this.timeToFix = timeToFix;
    }

    public long getTimeToFix() {
        return this.timeToFix;
    }

    public void setTriggerReason(String triggerReason) {
        this.triggerReason = triggerReason;
    }

    public String getTriggerReason() {
        return this.triggerReason;
    }

    public void setRevisionKey(String revisionKey) {
        this.revisionKey = revisionKey;
    }

    public String getRevisionKey() {
        return this.revisionKey;
    }

    public void setDeltaState(String deltaState) {
        this.deltaState = deltaState;
    }

    public String getDeltaState() {
        return this.deltaState;
    }

    public void setBuildAgentId(long buildAgentId) {
        this.buildAgentId = buildAgentId;
    }

    public long getBuildAgentId() {
        return this.buildAgentId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Buildresultsummary)) {
            return false;
        }

        Buildresultsummary rhs = (Buildresultsummary) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(buildresultsummaryId,
            rhs.buildresultsummaryId).append(createdDate, rhs.createdDate)
                                  .append(updatedDate, rhs.updatedDate)
                                  .append(buildKey, rhs.buildKey)
                                  .append(buildNumber, rhs.buildNumber)
                                  .append(buildState, rhs.buildState)
                                  .append(successfulTestCount,
            rhs.successfulTestCount).append(failedTestCount, rhs.failedTestCount)
                                  .append(buildDate, rhs.buildDate)
                                  .append(buildCompletedDate,
            rhs.buildCompletedDate).append(vcsUpdateTime, rhs.vcsUpdateTime)
                                  .append(queueTime, rhs.queueTime)
                                  .append(duration, rhs.duration)
                                  .append(timeToFix, rhs.timeToFix)
                                  .append(triggerReason, rhs.triggerReason)
                                  .append(revisionKey, rhs.revisionKey)
                                  .append(deltaState, rhs.deltaState)
                                  .append(buildAgentId, rhs.buildAgentId)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(buildresultsummaryId)
                                          .append(createdDate)
                                          .append(updatedDate).append(buildKey)
                                          .append(buildNumber).append(buildState)
                                          .append(successfulTestCount)
                                          .append(failedTestCount)
                                          .append(buildDate)
                                          .append(buildCompletedDate)
                                          .append(vcsUpdateTime)
                                          .append(queueTime).append(duration)
                                          .append(timeToFix)
                                          .append(triggerReason)
                                          .append(revisionKey).append(deltaState)
                                          .append(buildAgentId).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("buildresultsummaryId",
            buildresultsummaryId).append("createdDate", createdDate)
                                        .append("updatedDate", updatedDate)
                                        .append("buildKey", buildKey)
                                        .append("buildNumber", buildNumber)
                                        .append("buildState", buildState)
                                        .append("successfulTestCount",
            successfulTestCount).append("failedTestCount", failedTestCount)
                                        .append("buildDate", buildDate)
                                        .append("buildCompletedDate",
            buildCompletedDate).append("vcsUpdateTime", vcsUpdateTime)
                                        .append("queueTime", queueTime)
                                        .append("duration", duration)
                                        .append("timeToFix", timeToFix)
                                        .append("triggerReason", triggerReason)
                                        .append("revisionKey", revisionKey)
                                        .append("deltaState", deltaState)
                                        .append("buildAgentId", buildAgentId)
                                        .toString();
    }
}
