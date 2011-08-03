package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class ElasticImage {
    private long elasticImageId;
    private String name;
    private String description;
    private String amiImageId;
    private String ebsSnapshotId;
    private String instanceType;
    private String availabilityZone;
    private boolean shippedWithBamboo;
    private long capabilitySet;

    public void setElasticImageId(long elasticImageId) {
        this.elasticImageId = elasticImageId;
    }

    public long getElasticImageId() {
        return this.elasticImageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setAmiImageId(String amiImageId) {
        this.amiImageId = amiImageId;
    }

    public String getAmiImageId() {
        return this.amiImageId;
    }

    public void setEbsSnapshotId(String ebsSnapshotId) {
        this.ebsSnapshotId = ebsSnapshotId;
    }

    public String getEbsSnapshotId() {
        return this.ebsSnapshotId;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getInstanceType() {
        return this.instanceType;
    }

    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    public String getAvailabilityZone() {
        return this.availabilityZone;
    }

    public void setShippedWithBamboo(boolean shippedWithBamboo) {
        this.shippedWithBamboo = shippedWithBamboo;
    }

    public boolean getShippedWithBamboo() {
        return this.shippedWithBamboo;
    }

    public void setCapabilitySet(long capabilitySet) {
        this.capabilitySet = capabilitySet;
    }

    public long getCapabilitySet() {
        return this.capabilitySet;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ElasticImage)) {
            return false;
        }

        ElasticImage rhs = (ElasticImage) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(elasticImageId, rhs.elasticImageId)
                                  .append(name, rhs.name)
                                  .append(description, rhs.description)
                                  .append(amiImageId, rhs.amiImageId)
                                  .append(ebsSnapshotId, rhs.ebsSnapshotId)
                                  .append(instanceType, rhs.instanceType)
                                  .append(availabilityZone, rhs.availabilityZone)
                                  .append(shippedWithBamboo,
            rhs.shippedWithBamboo).append(capabilitySet, rhs.capabilitySet)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(elasticImageId).append(name)
                                          .append(description).append(amiImageId)
                                          .append(ebsSnapshotId)
                                          .append(instanceType)
                                          .append(availabilityZone)
                                          .append(shippedWithBamboo)
                                          .append(capabilitySet).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("elasticImageId", elasticImageId)
                                        .append("name", name)
                                        .append("description", description)
                                        .append("amiImageId", amiImageId)
                                        .append("ebsSnapshotId", ebsSnapshotId)
                                        .append("instanceType", instanceType)
                                        .append("availabilityZone",
            availabilityZone).append("shippedWithBamboo", shippedWithBamboo)
                                        .append("capabilitySet", capabilitySet)
                                        .toString();
    }
}
