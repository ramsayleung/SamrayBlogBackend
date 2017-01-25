package com.samray.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 1/10/17
 */
@Entity
@Getter
@Setter
@Table(name = "permission")
public class Permission extends BaseDomain {

    @Column(nullable = false)
    private Long pid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,name = "permission_type")
    private String permissionType;

    private int sort;

    private String url;

    private String perm_code;

    private String icon;

    private boolean enable;

}
