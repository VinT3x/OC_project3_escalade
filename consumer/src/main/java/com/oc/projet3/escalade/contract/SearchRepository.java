package com.oc.projet3.escalade.contract;

import com.oc.projet3.escalade.entities.Region;
import com.oc.projet3.escalade.entities.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SearchRepository {
    @Autowired
    EntityManager em;

    public List<Topo> findToposByRegions(List<Region> regions){

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Topo> cq = cb.createQuery(Topo.class);

        Root<Topo> topoRoot = cq.from(Topo.class);

        if (regions != null) {
            List<Predicate> criteria = new ArrayList<Predicate>();
            for (Region region : regions) {
                criteria.add(cb.equal(topoRoot.get("region_id"), region.getId()));
                cq=cq.where(cb.or(criteria.toArray(new Predicate[criteria.size()])));
            }
        }
        cq=cq.select(topoRoot);

        return em.createQuery(cq).getResultList();
    }
}
