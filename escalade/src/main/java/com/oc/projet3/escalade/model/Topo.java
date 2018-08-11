package com.oc.projet3.escalade.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "topo", schema = "public")
public class Topo {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="region_id", nullable=false)
    private Region region;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topo")
    private Set<Site> sites = new HashSet<>();

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "region_id", nullable = false, insertable = false, updatable = false)
    private Long region_id;

    @Column(name = "owner_id", nullable = false, insertable = false, updatable = false)
    private Long owner_id;

    // getters and setters

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Set<Site> getSites() {
        return sites;
    }

    public void setSites(Set<Site> sites) {
        this.sites = sites;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Long region_id) {
        this.region_id = region_id;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }
}
