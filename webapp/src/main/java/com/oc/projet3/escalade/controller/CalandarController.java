package com.oc.projet3.escalade.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalandarController {


    @RequestMapping("/calandar")
    public String calandar() {
        return "testCalendar";
    }
}
