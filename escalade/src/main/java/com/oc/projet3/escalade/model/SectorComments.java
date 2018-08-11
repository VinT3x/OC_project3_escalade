package com.oc.projet3.escalade.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sector_comments", schema = "public")
public class SectorComments {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="sector_id", nullable=false)
    private Sector sector;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "sector_id", nullable = false, insertable = false, updatable = false)
    private Long sector_id;

    @Column(name = "author_id", nullable = false)
    private String author_id;

    @Column(name = "comments", nullable = false)
    private String comments;

    @Column(name = "date_publishing", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_publishing;

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSector_id() {
        return sector_id;
    }

    public void setSector_id(Long sector_id) {
        this.sector_id = sector_id;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDate_publishing() {
        return date_publishing;
    }

    public void setDate_publishing(Date date_puplishing) {
        this.date_publishing = date_puplishing;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
}
