package com.samray.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by samray on 1/7/17.
 */
@Entity
@Getter
@Setter
@Table(name = "tag")
public class Tag extends BaseDomain {
    @Column(nullable = false,unique = true)
    private String name;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "tags")
    private List<Post> posts=new ArrayList<Post>();

    public Tag(){

    }
    public Tag(String name){
        this.setname(name);
    }

    public void setname(String name) {
        this.name = name;
    }
}
