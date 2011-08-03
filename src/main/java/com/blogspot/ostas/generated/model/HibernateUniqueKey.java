package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class HibernateUniqueKey {
    private int nextHi;

    public void setNextHi(int nextHi) {
        this.nextHi = nextHi;
    }

    public int getNextHi() {
        return this.nextHi;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HibernateUniqueKey)) {
            return false;
        }

        HibernateUniqueKey rhs = (HibernateUniqueKey) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(nextHi, rhs.nextHi).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(nextHi).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("nextHi", nextHi).toString();
    }
}
