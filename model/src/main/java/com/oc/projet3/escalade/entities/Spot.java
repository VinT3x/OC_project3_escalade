package com.oc.projet3.escalade.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "spot", schema = "public")
public class Spot {

    public Spot() {
    }

    public Spot(@NotEmpty String name, @NotEmpty String category, String description, String place, Set<Topo> topos, Set<Sector> sectors, Set<Comment> comments) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.place = place;
        this.topos = topos;
        this.sectors = sectors;
        this.comments = comments;
    }

    public enum Categories {
        CLIFF,
        BLOCK;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "spot_id", nullable = false)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    @NotEmpty
    private String name;

    @Column(name = "category", nullable = false)
    @NotEmpty
    private String category;

    @Column(name = "description", length = 1000, nullable = false)
    private String description;

    @Column(name = "place", length = 150, nullable = false)
    private String place;

    @Column(name = "region_id", nullable = false)
    private Long region_id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="region_id", nullable=false, insertable = false, updatable = false)
    private Region region;

    @JoinTable(
            name = "topo_spot",
            joinColumns = @JoinColumn(name = "spot_id"),
            inverseJoinColumns = @JoinColumn(name = "topo_id")
    )
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.ALL
            })
    private Set<Topo> topos = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.ALL
            })
    private Set<Sector> sectors = new HashSet<>();

    @JoinTable(
            name = "spot_comment",
            joinColumns = @JoinColumn(name = "spot_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id")
    )
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    private Set<Comment> comments = new HashSet<>();



//    @Column(name = "owner_id", nullable = false, insertable = false, updatable = false)
//    private Long owner_id;

    // getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Set<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(Set<Sector> sectors) {
        this.sectors = sectors;
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

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Topo> getTopos() {
        return topos;
    }

    public void setTopos(Set<Topo> topos) {
        this.topos = topos;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Long region_id) {
        this.region_id = region_id;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
