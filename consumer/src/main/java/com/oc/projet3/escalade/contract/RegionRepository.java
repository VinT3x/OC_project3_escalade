package com.oc.projet3.escalade.contract;

import com.oc.projet3.escalade.entities.Region;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegionRepository extends CrudRepository<Region, Long> {
    public List<Region> findAll();

}