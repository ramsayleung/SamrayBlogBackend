package com.samray.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

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
@Table(name = "post")
public class Post extends BaseDomain {
    @ManyToOne
    @JsonBackReference
    private User user;

    @Column(nullable = false)
    private String title;

    @Type(type = "text")
    private String content;

    @Type(type="text")
    private String renderedContent;

    @Column(nullable = false,name = "comments_enable")
    private boolean commentsEnable;

    @Column(nullable = false,name = "banner_image_url")
    private String bannerImageUrl;

    @Column(nullable = false)
    private boolean enable;

    @Column(nullable = false)
    private boolean delete_flag=false;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="post_tag",
    joinColumns = {@JoinColumn(name="post_id",nullable = false,updatable = false)},
    inverseJoinColumns = {@JoinColumn(name = "tag_id",nullable = false,updatable = false)})
    private Set<Tag> tags=new HashSet<Tag>();

    @JsonManagedReference
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Comment> comments=new ArrayList<Comment>();

}
