package com.scm.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
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
    @Enumerated
    private Provider providerName = Provider.SELF;
    private String providerId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();
}
