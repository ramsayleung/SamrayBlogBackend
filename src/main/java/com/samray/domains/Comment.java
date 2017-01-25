package com.samray.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 1/9/17
 */
@Entity
@Getter
@Setter
@Table(name = "comment")
public class Comment extends BaseDomain {
    @ManyToOne
    @JsonBackReference
    private Post post;

    @Column(nullable = false,name = "is_reply_to_id")
    private Long isReplyToId; //如果是回复某一个用户的话，值为用户id，否则，值为０

    @Column(nullable = false)
    @Type(type = "text")
    private String comment;

    @Column(nullable = false,name = "mark_read")
    private boolean markRead;

    @Column(nullable = false)
    private boolean enable;

    @ManyToOne
    @JsonBackReference
    private User user;
}
