package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.sql.Timestamp;


public class Build {
    private long buildId;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private String fullKey;
    private String buildkey;
    private String title;
    private String revisionKey;
    private int firstBuildNumber;
    private int latestBuildNumber;
    private int nextBuildNumber;
    private boolean suspendedFromBuilding;
    private boolean markedForDeletion;
    private long projectId;
    private long notificationSet;
    private long requirementSet;

    public void setBuildId(long buildId) {
        this.buildId = buildId;
    }

    public long getBuildId() {
        return this.buildId;
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

    public void setFullKey(String fullKey) {
        this.fullKey = fullKey;
    }

    public String getFullKey() {
        return this.fullKey;
    }

    public void setBuildkey(String buildkey) {
        this.buildkey = buildkey;
    }

    public String getBuildkey() {
        return this.buildkey;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setRevisionKey(String revisionKey) {
        this.revisionKey = revisionKey;
    }

    public String getRevisionKey() {
        return this.revisionKey;
    }

    public void setFirstBuildNumber(int firstBuildNumber) {
        this.firstBuildNumber = firstBuildNumber;
    }

    public int getFirstBuildNumber() {
        return this.firstBuildNumber;
    }

    public void setLatestBuildNumber(int latestBuildNumber) {
        this.latestBuildNumber = latestBuildNumber;
    }

    public int getLatestBuildNumber() {
        return this.latestBuildNumber;
    }

    public void setNextBuildNumber(int nextBuildNumber) {
        this.nextBuildNumber = nextBuildNumber;
    }

    public int getNextBuildNumber() {
        return this.nextBuildNumber;
    }

    public void setSuspendedFromBuilding(boolean suspendedFromBuilding) {
        this.suspendedFromBuilding = suspendedFromBuilding;
    }

    public boolean getSuspendedFromBuilding() {
        return this.suspendedFromBuilding;
    }

    public void setMarkedForDeletion(boolean markedForDeletion) {
        this.markedForDeletion = markedForDeletion;
    }

    public boolean getMarkedForDeletion() {
        return this.markedForDeletion;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getProjectId() {
        return this.projectId;
    }

    public void setNotificationSet(long notificationSet) {
        this.notificationSet = notificationSet;
    }

    public long getNotificationSet() {
        return this.notificationSet;
    }

    public void setRequirementSet(long requirementSet) {
        this.requirementSet = requirementSet;
    }

    public long getRequirementSet() {
        return this.requirementSet;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Build)) {
            return false;
        }

        Build rhs = (Build) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(buildId, rhs.buildId)
                                  .append(createdDate, rhs.createdDate)
                                  .append(updatedDate, rhs.updatedDate)
                                  .append(fullKey, rhs.fullKey)
                                  .append(buildkey, rhs.buildkey)
                                  .append(title, rhs.title)
                                  .append(revisionKey, rhs.revisionKey)
                                  .append(firstBuildNumber, rhs.firstBuildNumber)
                                  .append(latestBuildNumber,
            rhs.latestBuildNumber).append(nextBuildNumber, rhs.nextBuildNumber)
                                  .append(suspendedFromBuilding,
            rhs.suspendedFromBuilding)
                                  .append(markedForDeletion,
            rhs.markedForDeletion).append(projectId, rhs.projectId)
                                  .append(notificationSet, rhs.notificationSet)
                                  .append(requirementSet, rhs.requirementSet)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(buildId).append(createdDate)
                                          .append(updatedDate).append(fullKey)
                                          .append(buildkey).append(title)
                                          .append(revisionKey)
                                          .append(firstBuildNumber)
                                          .append(latestBuildNumber)
                                          .append(nextBuildNumber)
                                          .append(suspendedFromBuilding)
                                          .append(markedForDeletion)
                                          .append(projectId)
                                          .append(notificationSet)
                                          .append(requirementSet).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("buildId", buildId)
                                        .append("createdDate", createdDate)
                                        .append("updatedDate", updatedDate)
                                        .append("fullKey", fullKey)
                                        .append("buildkey", buildkey)
                                        .append("title", title)
                                        .append("revisionKey", revisionKey)
                                        .append("firstBuildNumber",
            firstBuildNumber).append("latestBuildNumber", latestBuildNumber)
                                        .append("nextBuildNumber",
            nextBuildNumber)
                                        .append("suspendedFromBuilding",
            suspendedFromBuilding).append("markedForDeletion", markedForDeletion)
                                        .append("projectId", projectId)
                                        .append("notificationSet",
            notificationSet).append("requirementSet", requirementSet).toString();
    }
}
