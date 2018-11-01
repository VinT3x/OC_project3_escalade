package com.oc.projet3.escalade.controller;

import com.oc.projet3.escalade.contract.CommentRepository;
import com.oc.projet3.escalade.contract.RegionRepository;
import com.oc.projet3.escalade.contract.SearchRepository;
import com.oc.projet3.escalade.entities.Comment;
import com.oc.projet3.escalade.impl.SearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    private SearchRepository searchRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private RegionRepository regionRepository;

    @RequestMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("regions", regionRepository.trouve_RegionNameWithCountTopo());
        return "accueil";
    }


    @PostMapping("/topos")
    public String resultSearchTopo(Model model, @Valid @ModelAttribute SearchForm searchForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "accueil";
        }
        //model.addAttribute("regions", searchForm.getRegionsChoisi());
        model.addAttribute("topos", searchRepository.findToposByRegions(searchForm.getRegionsChoisi()));
        model.addAttribute("recherche", searchForm);
        return "resultSearchTopo";
    }
    @PostMapping("/topos/comment/add")
    public Void commentSubmit(Model model, @Valid @ModelAttribute Comment comment, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            //return "accueil";
        }
        commentRepository.save(comment);

        return null;
    }



    @RequestMapping("/api/search")
    public String viewSearch(Model model) {
        return "ajax";
    }

    // Login form
    @RequestMapping("/login.html")
    public String login() {
        return "login.html";
    }

    // Login form with error
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }
}
