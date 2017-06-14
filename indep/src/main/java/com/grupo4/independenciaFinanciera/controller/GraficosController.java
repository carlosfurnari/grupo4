package com.grupo4.independenciaFinanciera.controller;

import com.grupo4.independenciaFinanciera.charts.*;
import com.grupo4.independenciaFinanciera.charts.helper.GastoCategoriaDonutData;
import com.grupo4.independenciaFinanciera.charts.helper.IngresoDonutData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GraficosController {

    @RequestMapping(value = {"/graficos"}, method = RequestMethod.GET)
    public String showIngresos(ModelMap modelMap){
        ChartData ingresoChart = new DonutChart(new IngresoDonutData());
        ChartData tableroChart = new ChartTablero();
        ChartData monthlyChart = new MensualTablero();
        ChartData gastosPorCategoriaChart = new GastoPorCategoria();
        ChartData gastosPorCategoriaDonut = new DonutChart(new GastoCategoriaDonutData());

        modelMap.addAttribute("ingresosTablero", ingresoChart.getData());
        modelMap.addAttribute("chartTablero", tableroChart.getData());
        modelMap.addAttribute("monthlyChartTablero", monthlyChart.getData());
        modelMap.addAttribute("gastoPorCategoria", gastosPorCategoriaChart.getData());
        modelMap.addAttribute("gastosPorCategoriaDonut", gastosPorCategoriaDonut.getData());

        return "graficos";
    }
}
