package com.oc.projet3.escalade.controler;

import com.oc.projet3.escalade.model.Region;
import com.oc.projet3.escalade.model.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    RegionRepository regionRepository;

    @RequestMapping("/")
    public String region(Model model) {
        model.addAttribute("regions", regionRepository.findAll());
        return "accueil";
    }
}
