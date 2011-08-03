package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class Requirement {
    private long requirementId;
    private String keyIdentifier;
    private boolean regexMatch;
    private boolean readonlyReq;
    private String matchValue;
    private long requirementSet;

    public void setRequirementId(long requirementId) {
        this.requirementId = requirementId;
    }

    public long getRequirementId() {
        return this.requirementId;
    }

    public void setKeyIdentifier(String keyIdentifier) {
        this.keyIdentifier = keyIdentifier;
    }

    public String getKeyIdentifier() {
        return this.keyIdentifier;
    }

    public void setRegexMatch(boolean regexMatch) {
        this.regexMatch = regexMatch;
    }

    public boolean getRegexMatch() {
        return this.regexMatch;
    }

    public void setReadonlyReq(boolean readonlyReq) {
        this.readonlyReq = readonlyReq;
    }

    public boolean getReadonlyReq() {
        return this.readonlyReq;
    }

    public void setMatchValue(String matchValue) {
        this.matchValue = matchValue;
    }

    public String getMatchValue() {
        return this.matchValue;
    }

    public void setRequirementSet(long requirementSet) {
        this.requirementSet = requirementSet;
    }

    public long getRequirementSet() {
        return this.requirementSet;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Requirement)) {
            return false;
        }

        Requirement rhs = (Requirement) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(requirementId, rhs.requirementId)
                                  .append(keyIdentifier, rhs.keyIdentifier)
                                  .append(regexMatch, rhs.regexMatch)
                                  .append(readonlyReq, rhs.readonlyReq)
                                  .append(matchValue, rhs.matchValue)
                                  .append(requirementSet, rhs.requirementSet)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(requirementId)
                                          .append(keyIdentifier)
                                          .append(regexMatch).append(readonlyReq)
                                          .append(matchValue)
                                          .append(requirementSet).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("requirementId", requirementId)
                                        .append("keyIdentifier", keyIdentifier)
                                        .append("regexMatch", regexMatch)
                                        .append("readonlyReq", readonlyReq)
                                        .append("matchValue", matchValue)
                                        .append("requirementSet", requirementSet)
                                        .toString();
    }
}
