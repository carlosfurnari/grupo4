package com.grupo4.independenciaFinanciera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rumm on 11/06/17.
 */
@Controller
@RequestMapping("/indepFin")
public class HomeController {


    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String showHomePage(){

        return "index";

    }
}
