package com.oc.projet3.escalade.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sector", schema = "public")
public class Sector {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Spot spot;

    @JoinTable(
            name = "sector_way",
            joinColumns = @JoinColumn(name = "sector_id"),
            inverseJoinColumns = @JoinColumn(name = "way_id")
    )
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.ALL
            })
    private Set<Way> ways = new HashSet<>();

    @Id
    @GeneratedValue
    @Column(name = "sector_id", nullable = false)
    private Long id;

    @Column(name = "spot_id", nullable = false)
    private Long spotid;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "name", nullable = false)
    private String name;

    public Sector(Long spot_id, String description, String name) {
        this.spotid = spot_id;
        this.description = description;
        this.name = name;
    }

    public Sector() {
    }

    // getters and setters
    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
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

    public Long getSpotid() {
        return spotid;
    }

    public void setSpotid(Long spotid) {
        this.spotid = spotid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
