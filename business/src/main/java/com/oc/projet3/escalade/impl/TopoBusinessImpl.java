package com.oc.projet3.escalade.impl;

import com.oc.projet3.escalade.contract.TopoBusiness;
import com.oc.projet3.escalade.contract.TopoRepository;
import com.oc.projet3.escalade.entities.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

@Component
public class TopoBusinessImpl implements TopoBusiness {
    @Autowired
    private TopoRepository topoRepository;

    @Override
    @CacheEvict(cacheNames="topo")
    public void topoUpdate(Topo topo, Long id) {
        Topo t = findTopoById(id);
        t.setName(topo.getName());
        t.setSpots(topo.getSpots());
        t.setRegion_id(topo.getRegion_id());
        t.setDescription(topo.getDescription());

        save(t);

    }

    @Override
    public Topo findTopoById(Long id) {
        Topo t = topoRepository.findTopoById(id);
        return t;
    }

    @Override
    @CacheEvict(cacheNames="topo")
    public void save(Topo topo) {
        topoRepository.save(topo);
    }
}
