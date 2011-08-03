package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class Imserver {
    private long imserverId;
    private String title;
    private String host;
    private int port;
    private String username;
    private String resourceName;
    private String password;
    private boolean sslRequired;

    public void setImserverId(long imserverId) {
        this.imserverId = imserverId;
    }

    public long getImserverId() {
        return this.imserverId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHost() {
        return this.host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return this.port;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return this.resourceName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setSslRequired(boolean sslRequired) {
        this.sslRequired = sslRequired;
    }

    public boolean getSslRequired() {
        return this.sslRequired;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Imserver)) {
            return false;
        }

        Imserver rhs = (Imserver) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(imserverId, rhs.imserverId)
                                  .append(title, rhs.title)
                                  .append(host, rhs.host).append(port, rhs.port)
                                  .append(username, rhs.username)
                                  .append(resourceName, rhs.resourceName)
                                  .append(password, rhs.password)
                                  .append(sslRequired, rhs.sslRequired)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(imserverId).append(title)
                                          .append(host).append(port)
                                          .append(username).append(resourceName)
                                          .append(password).append(sslRequired)
                                          .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("imserverId", imserverId)
                                        .append("title", title)
                                        .append("host", host)
                                        .append("port", port)
                                        .append("username", username)
                                        .append("resourceName", resourceName)
                                        .append("password", password)
                                        .append("sslRequired", sslRequired)
                                        .toString();
    }
}
