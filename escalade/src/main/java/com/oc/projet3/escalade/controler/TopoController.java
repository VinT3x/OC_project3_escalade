package com.oc.projet3.escalade.controler;

import com.oc.projet3.escalade.model.RegionRepository;
import com.oc.projet3.escalade.model.TopoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TopoController {
    @Autowired
    TopoRepository topoRepository;

    @RequestMapping("/topos")
    public String topo(Model model, @RequestParam("region") Long idregion) {
        model.addAttribute("topo", topoRepository.getFirstByRegion_id(idregion));
        model.addAttribute("topos", topoRepository.findAllByRegion_id(idregion));

        return "topo";
    }

}