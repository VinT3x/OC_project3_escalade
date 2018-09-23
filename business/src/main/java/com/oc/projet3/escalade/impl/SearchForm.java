package com.oc.projet3.escalade.impl;

import com.oc.projet3.escalade.contract.RegionRepository;
import com.oc.projet3.escalade.entities.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

public class SearchForm {

    private List<Region> regionsChoisi;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // This is for bind Date with @ModelAttribute
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // This is for bind Date with @ModelAttribute
    private Date endDate;


    public List<Region> getRegionsChoisi() {
        return regionsChoisi;
    }

    public void setRegionsChoisi(List<Region> regionsChoisi) {
        this.regionsChoisi = regionsChoisi;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


}
