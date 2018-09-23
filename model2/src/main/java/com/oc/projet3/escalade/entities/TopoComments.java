package com.oc.projet3.escalade.entities;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "topo_commentaires", schema = "public")
public class TopoComments {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="topo_id", nullable=false, insertable = false, updatable = false)
    private Topo topo;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "comments", nullable = false)
    private String comments;

    @Column(name = "author_id", nullable = false)
    private Long author_id;

    @Column(name = "topo_id", nullable = false)
    private Long topo_id;

    @CreatedDate
    @Column(name = "date_publishing", nullable = false)
    private Date date_publishing;

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public Long getTopo_id() {
        return topo_id;
    }

    public void setTopo_id(Long topo_id) {
        this.topo_id = topo_id;
    }

    public Date getDate_publishing() {
        return date_publishing;
    }

    public void setDate_publishing(Date date_publishing) {
        this.date_publishing = date_publishing;
    }
}
