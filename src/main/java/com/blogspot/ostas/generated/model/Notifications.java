package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class Notifications {
    private long notificationRuleId;
    private String conditionKey;
    private String conditionData;
    private long notificationSet;
    private String recipient;
    private String recipientType;

    public void setNotificationRuleId(long notificationRuleId) {
        this.notificationRuleId = notificationRuleId;
    }

    public long getNotificationRuleId() {
        return this.notificationRuleId;
    }

    public void setConditionKey(String conditionKey) {
        this.conditionKey = conditionKey;
    }

    public String getConditionKey() {
        return this.conditionKey;
    }

    public void setConditionData(String conditionData) {
        this.conditionData = conditionData;
    }

    public String getConditionData() {
        return this.conditionData;
    }

    public void setNotificationSet(long notificationSet) {
        this.notificationSet = notificationSet;
    }

    public long getNotificationSet() {
        return this.notificationSet;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipient() {
        return this.recipient;
    }

    public void setRecipientType(String recipientType) {
        this.recipientType = recipientType;
    }

    public String getRecipientType() {
        return this.recipientType;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Notifications)) {
            return false;
        }

        Notifications rhs = (Notifications) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(notificationRuleId,
            rhs.notificationRuleId).append(conditionKey, rhs.conditionKey)
                                  .append(conditionData, rhs.conditionData)
                                  .append(notificationSet, rhs.notificationSet)
                                  .append(recipient, rhs.recipient)
                                  .append(recipientType, rhs.recipientType)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(notificationRuleId)
                                          .append(conditionKey)
                                          .append(conditionData)
                                          .append(notificationSet)
                                          .append(recipient)
                                          .append(recipientType).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("notificationRuleId",
            notificationRuleId).append("conditionKey", conditionKey)
                                        .append("conditionData", conditionData)
                                        .append("notificationSet",
            notificationSet).append("recipient", recipient)
                                        .append("recipientType", recipientType)
                                        .toString();
    }
}
