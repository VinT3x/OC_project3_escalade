package com.oc.projet3.escalade.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "way", schema = "public")
public class Way {

    @JoinTable(
            name = "sector_way",
            joinColumns = @JoinColumn(name = "way_id"),
            inverseJoinColumns = @JoinColumn(name = "sector_id")
    )
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.ALL
            })
    private Set<Sector> sectors = new HashSet<>();

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "way_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "height", nullable = false)
    private int height;

    @Column(name = "quotations", nullable = false)
    private String quotations;

    @Column(name = "number_of_points", nullable = false)
    private int nb_point;

    //  constructeurs

    public Way(String name, String description, int height, String quotations, int nb_point) {
        this.name = name;
        this.description = description;
        this.height = height;
        this.quotations = quotations;
        this.nb_point = nb_point;
    }

    public Way() {
    }

    // getters and setters
    public static List<String> listQuotations = Arrays.asList("1","2","3","4","5a","5b","5c","6a","6a+","6b","6b+","6c","6c+","7a","7a+","7b","7b+","7c","7c+","8a","8a+","8b","8b+","8c","8c+","9a","9a+","9b","9b+","9c");


    public Set<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(Set<Sector> sectors) {
        this.sectors = sectors;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getQuotations() {
        return quotations;
    }

    public void setQuotations(String quotations) {
        this.quotations = quotations;
    }

    public int getNb_point() {
        return nb_point;
    }

    public void setNb_point(int nb_point) {
        this.nb_point = nb_point;
    }
}
