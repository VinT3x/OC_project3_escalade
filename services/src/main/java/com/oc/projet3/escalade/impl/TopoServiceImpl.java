package com.oc.projet3.escalade.impl;


import com.oc.projet3.escalade.contract.TopoRepository;
import com.oc.projet3.escalade.contract.TopoService;
import com.oc.projet3.escalade.entities.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("topoService")
public class TopoServiceImpl implements TopoService {
    @Autowired
    private TopoRepository topoRepository;

    @Override
    public Topo update(Topo topo) {
       return topoRepository.save(topo);
    }
}
