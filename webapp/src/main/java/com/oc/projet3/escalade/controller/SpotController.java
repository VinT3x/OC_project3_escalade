package com.oc.projet3.escalade.controller;


import com.oc.projet3.escalade.contract.RegionRepository;
import com.oc.projet3.escalade.contract.SpotRepository;
import com.oc.projet3.escalade.contract.TopoRepository;
import com.oc.projet3.escalade.entities.Spot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SpotController {
    @Autowired
    SpotRepository spotRepository;
    @Autowired
    TopoRepository topoRepository;
    @Autowired
    private RegionRepository regionRepository;
//    @RequestMapping("/site")
//    public String site(Model model, @RequestParam("id") Long id) {
//        model.addAttribute("site", siteRepository.getById(id));
//
//        return "site";
//    }

    @GetMapping(value = "/spot/add")
    public String viewFormTopo(Model model) {
        model.addAttribute("topos", topoRepository.findAll());
        model.addAttribute("regions", regionRepository.findAll());
        if(!model.containsAttribute("spot")){

            model.addAttribute("spot",new Spot());
        }
        return "formSpot";
    }

    @PostMapping("/spot/add")
    public String addTopo(@ModelAttribute @Valid Spot spot, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("spot",spot);
            return "formSpot";
        }
        spotRepository.save(spot);
        return "FormSuccess";
    }

}