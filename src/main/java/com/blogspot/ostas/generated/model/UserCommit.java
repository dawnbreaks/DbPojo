package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.sql.Timestamp;


public class UserCommit {
    private long commitId;
    private long buildresultsummaryId;
    private long authorId;
    private Timestamp commitDate;
    private String commitCommentClob;

    public void setCommitId(long commitId) {
        this.commitId = commitId;
    }

    public long getCommitId() {
        return this.commitId;
    }

    public void setBuildresultsummaryId(long buildresultsummaryId) {
        this.buildresultsummaryId = buildresultsummaryId;
    }

    public long getBuildresultsummaryId() {
        return this.buildresultsummaryId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getAuthorId() {
        return this.authorId;
    }

    public void setCommitDate(Timestamp commitDate) {
        this.commitDate = commitDate;
    }

    public Timestamp getCommitDate() {
        return this.commitDate;
    }

    public void setCommitCommentClob(String commitCommentClob) {
        this.commitCommentClob = commitCommentClob;
    }

    public String getCommitCommentClob() {
        return this.commitCommentClob;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserCommit)) {
            return false;
        }

        UserCommit rhs = (UserCommit) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(commitId, rhs.commitId)
                                  .append(buildresultsummaryId,
            rhs.buildresultsummaryId).append(authorId, rhs.authorId)
                                  .append(commitDate, rhs.commitDate)
                                  .append(commitCommentClob,
            rhs.commitCommentClob).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(commitId)
                                          .append(buildresultsummaryId)
                                          .append(authorId).append(commitDate)
                                          .append(commitCommentClob).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("commitId", commitId)
                                        .append("buildresultsummaryId",
            buildresultsummaryId).append("authorId", authorId)
                                        .append("commitDate", commitDate)
                                        .append("commitCommentClob",
            commitCommentClob).toString();
    }
}
