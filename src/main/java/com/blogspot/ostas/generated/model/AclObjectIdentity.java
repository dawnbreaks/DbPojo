package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class AclObjectIdentity {
    private long id;
    private String objectIdClass;
    private long objectIdIdentity;
    private long parentObject;
    private boolean entriesInheriting;
    private String ownerType;
    private String ownerSid;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setObjectIdClass(String objectIdClass) {
        this.objectIdClass = objectIdClass;
    }

    public String getObjectIdClass() {
        return this.objectIdClass;
    }

    public void setObjectIdIdentity(long objectIdIdentity) {
        this.objectIdIdentity = objectIdIdentity;
    }

    public long getObjectIdIdentity() {
        return this.objectIdIdentity;
    }

    public void setParentObject(long parentObject) {
        this.parentObject = parentObject;
    }

    public long getParentObject() {
        return this.parentObject;
    }

    public void setEntriesInheriting(boolean entriesInheriting) {
        this.entriesInheriting = entriesInheriting;
    }

    public boolean getEntriesInheriting() {
        return this.entriesInheriting;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getOwnerType() {
        return this.ownerType;
    }

    public void setOwnerSid(String ownerSid) {
        this.ownerSid = ownerSid;
    }

    public String getOwnerSid() {
        return this.ownerSid;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AclObjectIdentity)) {
            return false;
        }

        AclObjectIdentity rhs = (AclObjectIdentity) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(id, rhs.id)
                                  .append(objectIdClass, rhs.objectIdClass)
                                  .append(objectIdIdentity, rhs.objectIdIdentity)
                                  .append(parentObject, rhs.parentObject)
                                  .append(entriesInheriting,
            rhs.entriesInheriting).append(ownerType, rhs.ownerType)
                                  .append(ownerSid, rhs.ownerSid).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(id).append(objectIdClass)
                                          .append(objectIdIdentity)
                                          .append(parentObject)
                                          .append(entriesInheriting)
                                          .append(ownerType).append(ownerSid)
                                          .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("id", id)
                                        .append("objectIdClass", objectIdClass)
                                        .append("objectIdIdentity",
            objectIdIdentity).append("parentObject", parentObject)
                                        .append("entriesInheriting",
            entriesInheriting).append("ownerType", ownerType)
                                        .append("ownerSid", ownerSid).toString();
    }
}
