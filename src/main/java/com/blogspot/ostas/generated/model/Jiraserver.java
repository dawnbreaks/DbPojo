package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class Jiraserver {
    private long jiraserverId;
    private String title;
    private String host;
    private String username;
    private String password;

    public void setJiraserverId(long jiraserverId) {
        this.jiraserverId = jiraserverId;
    }

    public long getJiraserverId() {
        return this.jiraserverId;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Jiraserver)) {
            return false;
        }

        Jiraserver rhs = (Jiraserver) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(jiraserverId, rhs.jiraserverId)
                                  .append(title, rhs.title)
                                  .append(host, rhs.host)
                                  .append(username, rhs.username)
                                  .append(password, rhs.password).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(jiraserverId).append(title)
                                          .append(host).append(username)
                                          .append(password).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("jiraserverId", jiraserverId)
                                        .append("title", title)
                                        .append("host", host)
                                        .append("username", username)
                                        .append("password", password).toString();
    }
}
