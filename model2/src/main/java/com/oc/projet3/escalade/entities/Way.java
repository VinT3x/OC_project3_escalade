package com.oc.projet3.escalade.entities;

import javax.persistence.*;

@Entity
@Table(name = "way", schema = "public")
public class Way {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="sector_id", nullable=false)
    private Sector sector;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "sector_id", nullable = false, insertable = false, updatable = false)
    private Long sector_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "height", nullable = false)
    private int height;

    @Column(name = "cotation", nullable = false)
    private String cotation;

    @Column(name = "nb_point", nullable = false)
    private int nb_point;


    // getters and setters


    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getCotation() {
        return cotation;
    }

    public void setCotation(String cotation) {
        this.cotation = cotation;
    }

    public int getNb_point() {
        return nb_point;
    }

    public void setNb_point(int nb_point) {
        this.nb_point = nb_point;
    }
}
