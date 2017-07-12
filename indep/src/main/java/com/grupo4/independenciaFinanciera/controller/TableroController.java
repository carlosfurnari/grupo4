package com.grupo4.independenciaFinanciera.controller;

import com.grupo4.independenciaFinanciera.charts.ChartData;
import com.grupo4.independenciaFinanciera.charts.ChartTablero;
import com.grupo4.independenciaFinanciera.charts.MensualTablero;
import com.grupo4.independenciaFinanciera.dao.GastoDao;
import com.grupo4.independenciaFinanciera.dao.IngresoDao;
import com.grupo4.independenciaFinanciera.dao.InversionDao;
import com.grupo4.independenciaFinanciera.dto.TableroResponseDTO;
import com.grupo4.independenciaFinanciera.model.Gasto;
import com.grupo4.independenciaFinanciera.model.Ingreso;
import com.grupo4.independenciaFinanciera.model.Inversion;
import com.grupo4.independenciaFinanciera.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by rumm on 12/06/17.
 */

@Controller
public class TableroController {

    @Autowired
    private GastoDao gastoDao;

    @Autowired
    private InversionDao inversionDao;

    @Autowired
    private IngresoDao ingresoDao;

    @RequestMapping(value = {"/tablero"}, method = RequestMethod.GET)
    public String showTablero(@RequestParam(required = false) String username, ModelMap modelMap){
        ChartData tableroChart = new ChartTablero();
        ChartData monthlyChart = new MensualTablero();

        modelMap.addAttribute("chartData", tableroChart.getData());
        modelMap.addAttribute("monthlyChart", monthlyChart.getData());

        if(username == null || username.isEmpty()){
            username = "admin";
        }

        TableroResponseDTO dto = getTableroData(username);
        modelMap.addAttribute("inversiones", dto.getInversiones());
        modelMap.addAttribute("gastos", dto.getGastos());
        modelMap.addAttribute("ingresos", dto.getIngresos());
        modelMap.addAttribute("balance", dto.getBalance());

        return "tablero";
    }


    public TableroResponseDTO getTableroData(@RequestParam String username){

        TableroResponseDTO tableroResponseDTO = new TableroResponseDTO();

        Float gastos = this.getCurrentMonthGastosForUser(username);
        Float ingresos = this.getCurrentMonthIngresosForUser(username);

        Float balance = ingresos - gastos;

        tableroResponseDTO.setInversiones(this.getCurrentMonthInversionesForUser(username).toString());
        tableroResponseDTO.setGastos(gastos.toString());
        tableroResponseDTO.setIngresos(ingresos.toString());
        tableroResponseDTO.setBalance(balance.toString());

        return tableroResponseDTO;
    }

    private Float getCurrentMonthInversionesForUser(String username) {
        Map<String, Inversion> inversiones = this.inversionDao.getAllInversionesForUser(username);
        Float inversion = 0.0F;
        for (Inversion i : inversiones.values()){
            if (DateUtils.isThisMonth(i.getFecha())){
                inversion += Float.parseFloat(i.getMonto());
            }
        }
        return inversion;
    }

    private Float getCurrentMonthIngresosForUser(String username) {
        Map<String, Ingreso> ingresos = this.ingresoDao.getAllIngresosForUser(username);
        Float ingreso = 0.0F;
        for (Ingreso i : ingresos.values()){
            if (DateUtils.isThisMonth(i.getFecha())){
                ingreso += Float.parseFloat(i.getMonto());
            }
        }
        return ingreso;
    }

    private Float getCurrentMonthGastosForUser(String username) {
        Map<String, Gasto> gastos = this.gastoDao.getAllGastosForUser(username);
        Float gasto = 0.0F;
        for (Gasto i : gastos.values()){
            if (DateUtils.isThisMonth(i.getFecha())){
                gasto += Float.parseFloat(i.getMonto());
            }
        }
        return gasto;
    }


}
