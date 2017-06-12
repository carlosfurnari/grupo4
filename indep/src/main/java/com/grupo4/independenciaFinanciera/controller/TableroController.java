package com.grupo4.independenciaFinanciera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rumm on 12/06/17.
 */

@Controller
public class TableroController {

    @RequestMapping(value = {"/tablero"}, method = RequestMethod.GET)
    public String showTablero(){
        return "tablero";
    }
}
