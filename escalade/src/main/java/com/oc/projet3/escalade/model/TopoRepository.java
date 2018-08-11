package com.oc.projet3.escalade.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TopoRepository extends CrudRepository<Topo, Long> {
    public List<Topo> findAllByRegion_id(Long idregion);
    public Topo getFirstByRegion_id(Long idregion);
}
