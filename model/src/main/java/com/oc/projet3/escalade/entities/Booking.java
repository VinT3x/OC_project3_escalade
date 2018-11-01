package com.oc.projet3.escalade.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking", schema = "public")
public class Booking {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // This is for bind Date with @ModelAttribute
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // This is for bind Date with @ModelAttribute
    private Date endDate;

    @ManyToOne
    private Topo topo;

    @ManyToOne
    private AppUser user;

    @ManyToOne
    private Booking booking;

    @Column(name = "user_id", nullable = false)
    private Long user_id;

    @Column(name = "topo_id", nullable = false)
    private Long topo_id;

}
