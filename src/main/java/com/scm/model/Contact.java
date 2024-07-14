package com.scm.model;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Entity
@Table(name = "contact")
@Getter
@Setter
@AllArgsConstructor
public class Contact {
    @Id
    private String contactId;

    @Column(nullable = false, unique = true, length = 10)
    private String contactNumber;

    @Column(length = 20)
    private String contactName;

    private String picture;

    private boolean isFavourite = false;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Social> socials = new ArrayList<>();

    @ManyToOne
    private User user;
}
