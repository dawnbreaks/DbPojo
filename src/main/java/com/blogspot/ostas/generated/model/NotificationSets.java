package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class NotificationSets {
    private long notificationSetId;

    public void setNotificationSetId(long notificationSetId) {
        this.notificationSetId = notificationSetId;
    }

    public long getNotificationSetId() {
        return this.notificationSetId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NotificationSets)) {
            return false;
        }

        NotificationSets rhs = (NotificationSets) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(notificationSetId,
            rhs.notificationSetId).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(notificationSetId).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("notificationSetId",
            notificationSetId).toString();
    }
}
