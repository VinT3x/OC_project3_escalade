package com.oc.projet3.escalade.contract;

import com.oc.projet3.escalade.entities.Spot;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SpotRepository extends CrudRepository<Spot, Long> {

    public List<Spot> findAllByRegion_id(Long id);

}
