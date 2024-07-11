package com.scm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    private String userId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    @Column(length = 10000)
    private String profilePic;
    private String phoneNumber;
    @Column(length = 10000)
    private String about;

    //boolean values
    private boolean enabled = false;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;

    //Provider
    private Provider providerName;
    private String providerId;
}
