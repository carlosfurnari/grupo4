package com.grupo4.independenciaFinanciera.controller;

import com.grupo4.independenciaFinanciera.charts.ChartData;
import com.grupo4.independenciaFinanciera.charts.ChartTablero;
import com.grupo4.independenciaFinanciera.charts.MensualTablero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rumm on 12/06/17.
 */

@Controller
public class TableroController {

    @RequestMapping(value = {"/tablero"}, method = RequestMethod.GET)
    public String showTablero(ModelMap modelMap){
        ChartData tableroChart = new ChartTablero();
        ChartData monthlyChart = new MensualTablero();

        modelMap.addAttribute("chartData", tableroChart.getData());
        modelMap.addAttribute("monthlyChart", monthlyChart.getData());
        return "tablero";
    }
}
