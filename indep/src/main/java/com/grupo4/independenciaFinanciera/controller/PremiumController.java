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
public class PremiumController {

    @RequestMapping(value = {"/premiumPage"}, method = RequestMethod.GET)
    public String showPremium(ModelMap modelMap){
        return "./show-premium";
    }

    @RequestMapping(value = {"/premium-op1"}, method = RequestMethod.GET)
    public String showPremiumOp1(ModelMap modelMap){
        return "premium-op1";
    }

    @RequestMapping(value = {"/premium-op2"}, method = RequestMethod.GET)
    public String showPremiumOp2(ModelMap modelMap){
        return "premium-op2";
    }
}