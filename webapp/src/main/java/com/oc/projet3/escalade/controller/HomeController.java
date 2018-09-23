package com.oc.projet3.escalade.controller;

import com.oc.projet3.escalade.contract.RegionRepository;
import com.oc.projet3.escalade.impl.SearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private RegionRepository regionRepository;

    @RequestMapping("/")
    public String viewHome(Model model) {

        model.addAttribute("regions", regionRepository.findAll());

        return "accueil";
    }


}
