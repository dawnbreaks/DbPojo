package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class Author {
    private long authorId;
    private String linkedUserName;
    private String authorName;

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getAuthorId() {
        return this.authorId;
    }

    public void setLinkedUserName(String linkedUserName) {
        this.linkedUserName = linkedUserName;
    }

    public String getLinkedUserName() {
        return this.linkedUserName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Author)) {
            return false;
        }

        Author rhs = (Author) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(authorId, rhs.authorId)
                                  .append(linkedUserName, rhs.linkedUserName)
                                  .append(authorName, rhs.authorName).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(authorId)
                                          .append(linkedUserName)
                                          .append(authorName).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("authorId", authorId)
                                        .append("linkedUserName", linkedUserName)
                                        .append("authorName", authorName)
                                        .toString();
    }
}
