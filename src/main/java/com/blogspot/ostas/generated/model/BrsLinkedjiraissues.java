package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class BrsLinkedjiraissues {
    private long linkedjiraissueId;
    private long buildresultsummaryId;
    private String jiraIssueKey;
    private int jiraIssueLinkType;

    public void setLinkedjiraissueId(long linkedjiraissueId) {
        this.linkedjiraissueId = linkedjiraissueId;
    }

    public long getLinkedjiraissueId() {
        return this.linkedjiraissueId;
    }

    public void setBuildresultsummaryId(long buildresultsummaryId) {
        this.buildresultsummaryId = buildresultsummaryId;
    }

    public long getBuildresultsummaryId() {
        return this.buildresultsummaryId;
    }

    public void setJiraIssueKey(String jiraIssueKey) {
        this.jiraIssueKey = jiraIssueKey;
    }

    public String getJiraIssueKey() {
        return this.jiraIssueKey;
    }

    public void setJiraIssueLinkType(int jiraIssueLinkType) {
        this.jiraIssueLinkType = jiraIssueLinkType;
    }

    public int getJiraIssueLinkType() {
        return this.jiraIssueLinkType;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BrsLinkedjiraissues)) {
            return false;
        }

        BrsLinkedjiraissues rhs = (BrsLinkedjiraissues) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(linkedjiraissueId,
            rhs.linkedjiraissueId)
                                  .append(buildresultsummaryId,
            rhs.buildresultsummaryId).append(jiraIssueKey, rhs.jiraIssueKey)
                                  .append(jiraIssueLinkType,
            rhs.jiraIssueLinkType).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(linkedjiraissueId)
                                          .append(buildresultsummaryId)
                                          .append(jiraIssueKey)
                                          .append(jiraIssueLinkType).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("linkedjiraissueId",
            linkedjiraissueId)
                                        .append("buildresultsummaryId",
            buildresultsummaryId).append("jiraIssueKey", jiraIssueKey)
                                        .append("jiraIssueLinkType",
            jiraIssueLinkType).toString();
    }
}
