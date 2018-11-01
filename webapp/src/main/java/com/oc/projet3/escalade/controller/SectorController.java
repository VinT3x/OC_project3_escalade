package com.oc.projet3.escalade.controller;


import com.oc.projet3.escalade.contract.SectorRepository;
import com.oc.projet3.escalade.contract.SpotRepository;
import com.oc.projet3.escalade.contract.WayRepository;
import com.oc.projet3.escalade.entities.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SectorController {
    @Autowired
    SpotRepository spotRepository;
    @Autowired
    SectorRepository sectorRepository;
    @Autowired
    WayRepository wayRepository;

    @GetMapping(value = "/sector/add")
    public String viewFormSector(Model model) {
        model.addAttribute("spots", spotRepository.findAll());
        model.addAttribute("ways", wayRepository.findAll());
        if(!model.containsAttribute("sector")){

            model.addAttribute("sector",new Sector());
        }
        return "formSector";
    }

    @PostMapping("/sector/add")
    public String addTopo(@ModelAttribute @Valid Sector sector, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("sector",sector);
            return "formSector";
        }
        sectorRepository.save(sector);
        return "FormSuccess";
    }

}