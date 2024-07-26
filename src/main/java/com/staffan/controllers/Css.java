package com.staffan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Css {

    @RequestMapping(value = "/assets/index.css", method = RequestMethod.GET)
    public String index(Model model) {
        return "assets/index.css";
    }
}