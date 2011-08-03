package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.sql.Timestamp;


public class UserComment {
    private long commentId;
    private String content;
    private String userName;
    private long buildresultsummaryId;
    private Timestamp createdDate;
    private Timestamp updatedDate;

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public long getCommentId() {
        return this.commentId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserComment)) {
            return false;
        }

        UserComment rhs = (UserComment) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(commentId, rhs.commentId)
                                  .append(content, rhs.content)
                                  .append(userName, rhs.userName)
                                  .append(buildresultsummaryId,
            rhs.buildresultsummaryId).append(createdDate, rhs.createdDate)
                                  .append(updatedDate, rhs.updatedDate)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(commentId).append(content)
                                          .append(userName)
                                          .append(buildresultsummaryId)
                                          .append(createdDate)
                                          .append(updatedDate).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("commentId", commentId)
                                        .append("content", content)
                                        .append("userName", userName)
                                        .append("buildresultsummaryId",
            buildresultsummaryId).append("createdDate", createdDate)
                                        .append("updatedDate", updatedDate)
                                        .toString();
    }
}
