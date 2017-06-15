package com.grupo4.independenciaFinanciera.controller;

import com.grupo4.independenciaFinanciera.dao.GastoDao;
import com.grupo4.independenciaFinanciera.dto.GastoResponseDTO;
import com.grupo4.independenciaFinanciera.dto.InversionesResponseDTO;
import com.grupo4.independenciaFinanciera.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rumm on 13/06/17.
 */
@Controller
public class GastoController {

    @Autowired
    private GastoDao gastoDao;


    //muestra el jsp y nada mas
    @RequestMapping(value = {"/gastosPage"}, method = RequestMethod.GET)
    public String getGastosPage(@RequestParam String username){
        return "./show-gastos";
    }

    //borra un gasto
    @RequestMapping(value = {"/deleteGasto"}, method = RequestMethod.POST)
    @ResponseBody
    public GastoResponseDTO deleteGasto(User user, Gasto gasto, HttpServletResponse response){
        Gasto g = this.gastoDao.getGastoByUserAndGastoId(user.getUsername(), gasto.getId());
        GastoResponseDTO gastoResponseDTO = new GastoResponseDTO();

        if (g != null){
            this.gastoDao.deleteGasto(user.getUsername(), gasto.getId());
            gastoResponseDTO.setGasto(g);
            return gastoResponseDTO;
        }


        response.setStatus(400);
        gastoResponseDTO.setErrorMessage("No hay Gastos");
        return gastoResponseDTO;
    }

    //edita un gasto
    @RequestMapping(value = {"/editGasto"}, method = RequestMethod.POST)
    @ResponseBody
    public GastoResponseDTO editGasto(User user, Gasto gasto, HttpServletResponse response){
        Gasto g = this.gastoDao.getGastoByUserAndGastoId(user.getUsername(), gasto.getId());
        GastoResponseDTO gastoResponseDTO = new GastoResponseDTO();

        if (g != null){
            this.gastoDao.updateGasto(user.getUsername(), gasto);
            gastoResponseDTO.setGasto(g);
            return gastoResponseDTO;
        }


        response.setStatus(400);
        gastoResponseDTO.setErrorMessage("No hay gastos");
        return gastoResponseDTO;
    }

    //lista todos los gastos
    @RequestMapping(value = {"/listGasto"}, method = RequestMethod.GET)
    @ResponseBody
    public GastoResponseDTO listGasto(User user, HttpServletResponse response){
        Map<String, Gasto> gasto = this.gastoDao.getAllGastosForUser(user.getUsername());
        GastoResponseDTO gastoResponseDTO = new GastoResponseDTO();
        if (gasto != null && !gasto.isEmpty()){
            gastoResponseDTO.setGastos(gasto);
            return gastoResponseDTO;
        }
        response.setStatus(400);
        gastoResponseDTO.setErrorMessage("No hay inversiones");
        return gastoResponseDTO;
    }

    @RequestMapping(value = {"/addGasto"}, method = RequestMethod.POST)
    @ResponseBody
    public GastoResponseDTO addGasto(User user, Gasto gasto){
        this.gastoDao.addGastoByUser(user.getUsername(), gasto);
        GastoResponseDTO gastoResponseDTO = new GastoResponseDTO();

        gastoResponseDTO.setGasto(gasto);

        return  gastoResponseDTO;
    }

    private List<Gasto> getMockedGastos() {
        Gasto gasto1 = new Gasto();
        gasto1.setDescripcion("desc1");
        Categoria alimentos = new Categoria();
        alimentos.setId("alimentos");
        alimentos.setDescription("alimentos para comer");
        alimentos.setNombre("alimentos");

        gasto1.setCategoria(alimentos);
        gasto1.setMonto("200");

        Gasto gasto2 = new Gasto();
        gasto2.setDescripcion("desc2");

        Categoria indumentaria = new Categoria();
        alimentos.setId("indumentaria");
        alimentos.setDescription("indumentaria para vestir");
        alimentos.setNombre("indumentaria");
        gasto2.setCategoria(indumentaria);
        gasto2.setMonto("500");
        List<Gasto> result = new ArrayList<Gasto>();
        result.add(gasto1);
        result.add(gasto2);
        return result;
    }


}
