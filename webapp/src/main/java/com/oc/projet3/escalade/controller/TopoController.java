package com.oc.projet3.escalade.controller;


import com.oc.projet3.escalade.contract.TopoCommentRepository;
import com.oc.projet3.escalade.contract.TopoRepository;
import com.oc.projet3.escalade.entities.TopoComments;
import com.oc.projet3.escalade.impl.CommentForm;
import com.oc.projet3.escalade.impl.SearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class TopoController {
    @Autowired
    TopoRepository topoRepository;
    @Autowired
    TopoCommentRepository topoCommentRepository;


    @RequestMapping("/topos")
    public String topo(Model model, @RequestParam("region") Long idregion) {
        model.addAttribute("topo", topoRepository.getFirstByRegion_id(idregion));
        model.addAttribute("topos", topoRepository.findAllByRegion_id(idregion));

        return "topo";
    }

    @PostMapping("/topos")
    public String searchSubmit(Model model, @Valid @ModelAttribute SearchForm searchForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "accueil";
        }
        model.addAttribute("regions", searchForm.getRegionsChoisi());
        model.addAttribute("recherche", searchForm);
        return "topo";
    }

    @PostMapping("/topos/comment")
    public String commentSubmit(Model model, @Valid @ModelAttribute CommentForm commentForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "accueil";
        }
        TopoComments tc =
        commentForm.getComment();
        TopoComments tc =
        topoCommentRepository.save();
        return "topo";
    }
}