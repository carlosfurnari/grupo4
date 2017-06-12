package com.grupo4.independenciaFinanciera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rumm on 11/06/17.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = {"/", "/asd"}, method = RequestMethod.GET)
    public String showHomePage(ModelMap model){

        return "home";

    }
}
