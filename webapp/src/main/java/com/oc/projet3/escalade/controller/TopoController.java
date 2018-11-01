package com.oc.projet3.escalade.controller;

import com.oc.projet3.escalade.contract.RegionRepository;
import com.oc.projet3.escalade.contract.SpotRepository;
import com.oc.projet3.escalade.contract.TopoService;
import com.oc.projet3.escalade.entities.Topo;
import com.oc.projet3.escalade.impl.TopoBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping()
public class TopoController {
    @Autowired
    TopoBusinessImpl tb;

    @Autowired
    private SpotRepository spotRepository;

    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private TopoService topoService;

    private String biddingError(Model model,Topo topo){
        model.addAttribute("topo",topo);
        model.addAttribute("regions", regionRepository.findAll());
        if (topo.getRegion_id()>0) {
            model.addAttribute("spots", spotRepository.findAllByRegion_id(topo.getRegion_id()));
        }else{
            model.addAttribute("spots", null);

        }
        return "formTopo";
    }

    @GetMapping(value = "/topo/add")
    public String addTopo(Model model) {
        model.addAttribute("regions", regionRepository.findAll());

        if(!model.containsAttribute("topo")){
            model.addAttribute("topo",new Topo());
        }

        return "formTopo";
    }

    // AJAX : liste les spots d'une region et les ajoutes au th:fragment
    @GetMapping(value = {"/topo/spot/{region_id}","/topo/edit/spot/{region_id}"})
    public String showSpotByRegion(Model model, @PathVariable("region_id") Long region_id) {
        model.addAttribute("spots", spotRepository.findAllByRegion_id(region_id));
        System.out.println("AJAX");
        return "formTopo :: spotsList";
    }

    @PostMapping("/topo/add")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String addTopo(@ModelAttribute @Valid Topo topo, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            biddingError(model,topo);
            return "formTopo";
        }
        tb.save(topo);
        return "FormSuccess";
    }

    @GetMapping(value = "/topo/edit/{id}")
    public String editTopo(Model model,@PathVariable Long id) {
        Topo t = tb.findTopoById(id);
        model.addAttribute("topo", t);
        model.addAttribute("regions", regionRepository.findAll());
        model.addAttribute("spots", spotRepository.findAllByRegion_id(t.getRegion_id()));
        model.addAttribute("action", "edit");
        model.addAttribute("id",id);
        return "formTopo";
    }

    @PostMapping("/topo/edit/{id}")
    public String updateTopo(@ModelAttribute  @Valid Topo topo, BindingResult bindingResult, Model model,@PathVariable Long id) {

        if (bindingResult.hasErrors()) {
            biddingError(model,topo);
        }

        tb.topoUpdate(topo,id);
        return "FormSuccess";
    }


//    @GetMapping("/topos")
//    public String topo(Model model, @RequestParam("region") Long idregion) {
//        model.addAttribute("topo", topoRepository.getFirstByRegion_id(idregion));
//        model.addAttribute("topos", topoRepository.findAllByRegion_id(idregion));
//        return "resultSearchTopo";
//    }

//    @GetMapping("/topo/{id}/comment")
//    public @ResponseBody List<Comment>  fetchComment(@PathVariable Long id){
//        return commentRepository.findAllComments(id);
//
//    }

    @GetMapping(value = "/topo/{id}")
    public String viewTopo(Model model,@PathVariable Long id) {
        model.addAttribute("topo", tb.findTopoById(id));
        return "topo";
    }
}