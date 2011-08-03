package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class CommitFiles {
    private long commitId;
    private String commitFileName;
    private String commitFileReivision;
    private int listPosition;

    public void setCommitId(long commitId) {
        this.commitId = commitId;
    }

    public long getCommitId() {
        return this.commitId;
    }

    public void setCommitFileName(String commitFileName) {
        this.commitFileName = commitFileName;
    }

    public String getCommitFileName() {
        return this.commitFileName;
    }

    public void setCommitFileReivision(String commitFileReivision) {
        this.commitFileReivision = commitFileReivision;
    }

    public String getCommitFileReivision() {
        return this.commitFileReivision;
    }

    public void setListPosition(int listPosition) {
        this.listPosition = listPosition;
    }

    public int getListPosition() {
        return this.listPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CommitFiles)) {
            return false;
        }

        CommitFiles rhs = (CommitFiles) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(commitId, rhs.commitId)
                                  .append(commitFileName, rhs.commitFileName)
                                  .append(commitFileReivision,
            rhs.commitFileReivision).append(listPosition, rhs.listPosition)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(commitId)
                                          .append(commitFileName)
                                          .append(commitFileReivision)
                                          .append(listPosition).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("commitId", commitId)
                                        .append("commitFileName", commitFileName)
                                        .append("commitFileReivision",
            commitFileReivision).append("listPosition", listPosition).toString();
    }
}
