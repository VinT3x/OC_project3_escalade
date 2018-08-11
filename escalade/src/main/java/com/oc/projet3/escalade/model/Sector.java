package com.oc.projet3.escalade.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sector", schema = "public")
public class Sector {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="site_id", nullable=false)
    private Site site;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sector")
    private Set<Way> ways = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sector")
    private Set<SectorComments> sectorComments = new HashSet<>();

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "site_id", nullable = false, insertable = false, updatable = false)
    private Long site_id;

    @Column(name = "name", nullable = false)
    private String name;

    // getters and setters


    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Set<Way> getWays() {
        return ways;
    }

    public void setWays(Set<Way> ways) {
        this.ways = ways;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSite_id() {
        return site_id;
    }

    public void setSite_id(Long site_id) {
        this.site_id = site_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SectorComments> getSectorComments() {
        return sectorComments;
    }

    public void setSectorComments(Set<SectorComments> sectorComments) {
        this.sectorComments = sectorComments;
    }
}
