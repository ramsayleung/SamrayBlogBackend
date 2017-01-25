package com.samray.domains;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by samray on 1/7/17.
 */
@MappedSuperclass
public class BaseDomain implements Comparable<BaseDomain>, Serializable {
    private static final SimpleDateFormat SLUG_DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private Date createAt;

    @Column(nullable = false)
    private Date updateAt;

    @PrePersist
    public void prePersist(){
        createAt=updateAt=new Date();
    }

    @PreUpdate
    public void preUpdate(){
        updateAt=new Date();
    }

    @Override
    public int compareTo(BaseDomain o) {
       return this.getId().compareTo(o.getId());
    }
    public Long getId(){
        return  id;
    }
    public void setId(Long _id){
        id=_id;
    }
    public Date getCreateAt(){return  createAt;}
    public void setCreateAt(Date createAt){
        this.createAt=createAt;
    }

    public Date getUpdateAt(){return  updateAt;}
    public void setUpdateAt(Date updateAt){
        this.updateAt=updateAt;
    }
}
