package com.oc.projet3.escalade.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment", schema = "public")
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    private Long comment_id;
    private String commentvalue;
    private Date createddate;


    public Comment(Long comment_id, String commentvalue, Date createddate) {
        this.comment_id = comment_id;
        this.commentvalue = commentvalue;
        this.createddate = createddate;
    }

    public Comment() {
    }

    public String getCommentvalue() {
        return commentvalue;
    }

    public void setCommentvalue(String commentvalue) {
        this.commentvalue = commentvalue;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

}
