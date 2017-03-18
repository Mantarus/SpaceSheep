package com.ottepel_hack.entities;

import javax.persistence.*;

/**
 * Created by iistomin on 17/03/17.
 */
@Entity
@Table(name = "user")
public class User {

    private String userId;
    private String fullName;

    @Id
    @Column
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
