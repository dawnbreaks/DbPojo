package com.blogspot.ostas.generated.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.sql.Timestamp;


public class Users {
    private long id;
    private String name;
    private String password;
    private String email;
    private Timestamp created;
    private String fullname;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getCreated() {
        return this.created;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return this.fullname;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Users)) {
            return false;
        }

        Users rhs = (Users) o;

        return new EqualsBuilder().appendSuper(super.equals(o))
                                  .append(id, rhs.id).append(name, rhs.name)
                                  .append(password, rhs.password)
                                  .append(email, rhs.email)
                                  .append(created, rhs.created)
                                  .append(fullname, rhs.fullname).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
                                          .append(id).append(name)
                                          .append(password).append(email)
                                          .append(created).append(fullname)
                                          .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                                        .append("id", id).append("name", name)
                                        .append("password", password)
                                        .append("email", email)
                                        .append("created", created)
                                        .append("fullname", fullname).toString();
    }
}
