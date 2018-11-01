package com.oc.projet3.escalade.contract;

import com.oc.projet3.escalade.entities.Region;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegionRepository extends CrudRepository<Region, Long> {
    public List<Region> findAll();


    @Query(value="SELECT r.id, r.name, count(t.topo_id) FROM Region as r LEFT JOIN Topo as t ON r.id = t.region_id group by r.id, r.name order by r.name",nativeQuery = true)
    public List<Object[]> trouve_RegionNameWithCountTopo();

}