package com.oc.projet3.escalade.contract;

import com.oc.projet3.escalade.entities.Site;
import org.springframework.data.repository.CrudRepository;


public interface SiteRepository extends CrudRepository<Site, Long> {
    public Site getById(Long id);
}
