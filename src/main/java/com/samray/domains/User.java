package com.samray.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by samray on 1/7/17.
 */
@Entity
@Getter
@Setter
@Table(name="user")
public class User extends BaseDomain {
    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    @Column(nullable = false)
    private String username;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl; //头像缩略图url

    @Column(name = "original_url")
    private String originalUrl; //头像原图

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> posts=new ArrayList<Post>();


    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Comment> comments=new ArrayList<Comment>();


    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
    joinColumns = {@JoinColumn(name="user_id",nullable = false,updatable = false)},
    inverseJoinColumns = {@JoinColumn(name = "role_id",nullable = false,updatable = false)})
    private Set<Role> roles=new HashSet<Role>();

    public User() {
    }

    public User(String email, String password, String username, String thumbnailUrl, String originalUrl) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.thumbnailUrl = thumbnailUrl;
        this.originalUrl = originalUrl;
    }
}
