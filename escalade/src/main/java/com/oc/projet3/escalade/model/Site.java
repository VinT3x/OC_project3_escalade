package com.oc.projet3.escalade.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "site", schema = "public")
public class Site {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="topo_id", nullable=false)
    private Topo topo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "site")
    private Set<Sector> sectors = new HashSet<>();

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "topo_id", nullable = false, insertable = false, updatable = false)
    private Long topo_id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "place", nullable = false)
    private String place;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "cotations", nullable = false)
    private String cotations;

    @Column(name = "category", nullable = false)
    private String category;


    // getters et setters


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

    public Long getTopo_id() {
        return topo_id;
    }

    public void setTopo_id(Long topo_id) {
        this.topo_id = topo_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCotations() {
        return cotations;
    }

    public void setCotations(String cotations) {
        this.cotations = cotations;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(Set<Sector> sectors) {
        this.sectors = sectors;
    }
}
