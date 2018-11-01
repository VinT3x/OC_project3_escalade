package com.oc.projet3.escalade.contract;

import com.oc.projet3.escalade.entities.Topo;


public interface TopoBusiness {

    public void topoUpdate(Topo topo, Long id);

    public Topo findTopoById(Long id);

    public void save(Topo topo);


}
