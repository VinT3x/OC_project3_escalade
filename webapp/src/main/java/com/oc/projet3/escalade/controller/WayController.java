package com.oc.projet3.escalade.controller;

import com.oc.projet3.escalade.contract.SectorRepository;
import com.oc.projet3.escalade.contract.WayRepository;
import com.oc.projet3.escalade.entities.Way;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
@Controller
public class WayController {
    @Autowired
    WayRepository wayRepository;
    @Autowired
    SectorRepository sectorRepository;

    @GetMapping(value = "/way/add")
    public String viewFormWay(Model model) {
        model.addAttribute("sectors", sectorRepository.findAll());
        if(!model.containsAttribute("way")){

            model.addAttribute("way",new Way());
        }
        return "formWay";
    }

    @PostMapping("/way/add")
    public String addWay(@ModelAttribute @Valid Way way, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("way",way);
            return "formWay";
        }
        wayRepository.save(way);
        return "FormSuccess";
    }
}
