package com.samray.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by samray on 1/8/17.
 */
@Entity
@Getter
@Setter
@Table(name = "role")
public class Role extends BaseDomain {
//    暂时，拥有两种角色:作者和读者
    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "roles")
    private List<User> users=new ArrayList<User>();
    public Role() {
    }

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
