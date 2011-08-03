package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.sql.Timestamp;


public class Queue {
    private long queueId;
    private String agentType;
    private String title;
    private String agentDescription;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private boolean enabled;
    private long capabilitySet;
    private Timestamp lastStartTime;
    private Timestamp lastStopTime;
    private String elasticInstanceId;
    private long elasticImage;

    public void setQueueId(long queueId) {
        this.queueId = queueId;
    }

    public long getQueueId() {
        return this.queueId;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    public String getAgentType() {
        return this.agentType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAgentDescription(String agentDescription) {
        this.agentDescription = agentDescription;
    }

    public String getAgentDescription() {
        return this.agentDescription;
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

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setCapabilitySet(long capabilitySet) {
        this.capabilitySet = capabilitySet;
    }

    public long getCapabilitySet() {
        return this.capabilitySet;
    }

    public void setLastStartTime(Timestamp lastStartTime) {
        this.lastStartTime = lastStartTime;
    }

    public Timestamp getLastStartTime() {
        return this.lastStartTime;
    }

    public void setLastStopTime(Timestamp lastStopTime) {
        this.lastStopTime = lastStopTime;
    }

    public Timestamp getLastStopTime() {
        return this.lastStopTime;
    }

    public void setElasticInstanceId(String elasticInstanceId) {
        this.elasticInstanceId = elasticInstanceId;
    }

    public String getElasticInstanceId() {
        return this.elasticInstanceId;
    }

    public void setElasticImage(long elasticImage) {
        this.elasticImage = elasticImage;
    }

    public long getElasticImage() {
        return this.elasticImage;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Queue)) {
            return false;
        }

        Queue rhs = (Queue) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(queueId, rhs.queueId)
                                  .append(agentType, rhs.agentType)
                                  .append(title, rhs.title)
                                  .append(agentDescription, rhs.agentDescription)
                                  .append(createdDate, rhs.createdDate)
                                  .append(updatedDate, rhs.updatedDate)
                                  .append(enabled, rhs.enabled)
                                  .append(capabilitySet, rhs.capabilitySet)
                                  .append(lastStartTime, rhs.lastStartTime)
                                  .append(lastStopTime, rhs.lastStopTime)
                                  .append(elasticInstanceId,
            rhs.elasticInstanceId).append(elasticImage, rhs.elasticImage)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(queueId).append(agentType)
                                          .append(title).append(agentDescription)
                                          .append(createdDate)
                                          .append(updatedDate).append(enabled)
                                          .append(capabilitySet)
                                          .append(lastStartTime)
                                          .append(lastStopTime)
                                          .append(elasticInstanceId)
                                          .append(elasticImage).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("queueId", queueId)
                                        .append("agentType", agentType)
                                        .append("title", title)
                                        .append("agentDescription",
            agentDescription).append("createdDate", createdDate)
                                        .append("updatedDate", updatedDate)
                                        .append("enabled", enabled)
                                        .append("capabilitySet", capabilitySet)
                                        .append("lastStartTime", lastStartTime)
                                        .append("lastStopTime", lastStopTime)
                                        .append("elasticInstanceId",
            elasticInstanceId).append("elasticImage", elasticImage).toString();
    }
}
