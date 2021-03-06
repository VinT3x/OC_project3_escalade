package com.oc.projet3.escalade.controler;

import com.oc.projet3.escalade.model.SiteRepository;
import com.oc.projet3.escalade.model.TopoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiteController {
    @Autowired
    SiteRepository siteRepository;

    @RequestMapping("/site")
    public String site(Model model, @RequestParam("id") Long id) {
        model.addAttribute("site", siteRepository.getById(id));

        return "site";
    }

}