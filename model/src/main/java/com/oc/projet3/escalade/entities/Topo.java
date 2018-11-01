package com.oc.projet3.escalade.entities;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "topo", schema = "public")
public class Topo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "topo_id", nullable = false)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    @NotNull
    private String name;

    @Column(name = "description", length = 100, nullable = false)
    private String description;

    @Column(name = "region_id", nullable = false)
    @NotNull
    @Min(value = 1L, message = "The value must be positive")
    private Long region_id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="region_id", nullable=false, insertable = false, updatable = false)
    private Region region;


    @JoinTable(
            name = "topo_spot",
            joinColumns = @JoinColumn(name = "topo_id"),
            inverseJoinColumns = @JoinColumn(name = "spot_id")
    )
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.ALL
            })
    private Set<Spot> spots = new HashSet<>();


    @JoinTable(
            name = "topo_comment",
            joinColumns = @JoinColumn(name = "topo_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id")
    )
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.ALL
            })
    private Set<Booking> books = new HashSet<>();

    public Topo() {
    }

    public Topo(@NotEmpty String name, String description,Long region_id, Region region, Set<Spot> spots, Set<Comment> comments) {
        this.name = name;
        this.description = description;
        this.region_id = region_id;
        this.region = region;
        this.spots = spots;
        this.comments = comments;
    }

    //    @Column(name = "owner_id", nullable = false, insertable = false, updatable = false)
//    private Long owner_id;

    // getters and setters
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Set<Spot> getSpots() {
        return spots;
    }

    public void setSpots(Set<Spot> spots) {
        this.spots = spots;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
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

    public void setRegion_id(Long regionId) {
        this.region_id = regionId;
    }

//    public Long getOwner_id() {
//        return owner_id;
//    }
//
//    public void setOwner_id(Long owner_id) {
//        this.owner_id = owner_id;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

}
