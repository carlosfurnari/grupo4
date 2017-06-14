package com.grupo4.independenciaFinanciera.controller;

import com.grupo4.independenciaFinanciera.charts.ChartData;
import com.grupo4.independenciaFinanciera.charts.DonutChart;
import com.grupo4.independenciaFinanciera.charts.helper.IngresoDonutData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IngresoController {

    @RequestMapping(value = {"/ingresos"}, method = RequestMethod.GET)
    public String showIngresos(ModelMap modelMap){
        ChartData ingresoChart = new DonutChart(new IngresoDonutData());

        modelMap.addAttribute("chartData", ingresoChart.getData());

        return "ingresos";
    }
}
