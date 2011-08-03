package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class AclEntry {
    private long id;
    private long aclObjectIdentity;
    private String type;
    private String sid;
    private int aceOrder;
    private int mask;
    private boolean granting;
    private boolean auditSuccess;
    private boolean auditFailure;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setAclObjectIdentity(long aclObjectIdentity) {
        this.aclObjectIdentity = aclObjectIdentity;
    }

    public long getAclObjectIdentity() {
        return this.aclObjectIdentity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSid() {
        return this.sid;
    }

    public void setAceOrder(int aceOrder) {
        this.aceOrder = aceOrder;
    }

    public int getAceOrder() {
        return this.aceOrder;
    }

    public void setMask(int mask) {
        this.mask = mask;
    }

    public int getMask() {
        return this.mask;
    }

    public void setGranting(boolean granting) {
        this.granting = granting;
    }

    public boolean getGranting() {
        return this.granting;
    }

    public void setAuditSuccess(boolean auditSuccess) {
        this.auditSuccess = auditSuccess;
    }

    public boolean getAuditSuccess() {
        return this.auditSuccess;
    }

    public void setAuditFailure(boolean auditFailure) {
        this.auditFailure = auditFailure;
    }

    public boolean getAuditFailure() {
        return this.auditFailure;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AclEntry)) {
            return false;
        }

        AclEntry rhs = (AclEntry) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(id, rhs.id)
                                  .append(aclObjectIdentity,
            rhs.aclObjectIdentity).append(type, rhs.type).append(sid, rhs.sid)
                                  .append(aceOrder, rhs.aceOrder)
                                  .append(mask, rhs.mask)
                                  .append(granting, rhs.granting)
                                  .append(auditSuccess, rhs.auditSuccess)
                                  .append(auditFailure, rhs.auditFailure)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(id).append(aclObjectIdentity)
                                          .append(type).append(sid)
                                          .append(aceOrder).append(mask)
                                          .append(granting).append(auditSuccess)
                                          .append(auditFailure).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("id", id)
                                        .append("aclObjectIdentity",
            aclObjectIdentity).append("type", type).append("sid", sid)
                                        .append("aceOrder", aceOrder)
                                        .append("mask", mask)
                                        .append("granting", granting)
                                        .append("auditSuccess", auditSuccess)
                                        .append("auditFailure", auditFailure)
                                        .toString();
    }
}
