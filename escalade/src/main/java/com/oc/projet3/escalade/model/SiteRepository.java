package com.oc.projet3.escalade.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SiteRepository extends CrudRepository<Site, Long> {
    public Site getById(Long id);
}
