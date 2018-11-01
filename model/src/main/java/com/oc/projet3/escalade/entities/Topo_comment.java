package com.oc.projet3.escalade.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topo_comment {
    @Id
    private Long id;
    private Long topo_id;
    private Long comment_id;
}
