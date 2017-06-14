package com.grupo4.independenciaFinanciera.controller;

import com.grupo4.independenciaFinanciera.dao.InversionDao;
import com.grupo4.independenciaFinanciera.dto.CotizacionDolarDTO;
import com.grupo4.independenciaFinanciera.dto.InversionesResponseDTO;
import com.grupo4.independenciaFinanciera.model.Categoria;
import com.grupo4.independenciaFinanciera.model.Inversion;
import com.grupo4.independenciaFinanciera.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * Created by rumm on 14/06/17.
 */

@Controller
public class InversionesController {

    @Autowired
    private InversionDao inversionDao;

    //muestra el jsp y nada mas
    @RequestMapping(value = {"/inversionesPage"}, method = RequestMethod.GET)
    public String getInversionesPage(){
        return "./show-inversiones";
    }

    //borra una inversion
    @RequestMapping(value = {"/deleteInversion"}, method = RequestMethod.POST)
    @ResponseBody
    public InversionesResponseDTO deleteInversion(User user, Inversion inversion, HttpServletResponse response){
        Inversion i = this.inversionDao.getInversionByUserAndInversionId(user.getUsername(), inversion.getId());
        InversionesResponseDTO inversionesResponseDTO = new InversionesResponseDTO();

        if (i != null){
            this.inversionDao.deleteInversion(user.getUsername(), inversion.getId());
            inversionesResponseDTO.setInversion(i);
            return inversionesResponseDTO;
        }


        response.setStatus(400);
        inversionesResponseDTO.setErrorMessage("No hay inversiones");
        return inversionesResponseDTO;
    }

    //edita una inversion
    @RequestMapping(value = {"/editInversion"}, method = RequestMethod.POST)
    @ResponseBody
    public InversionesResponseDTO editInversion(User user, Inversion inversion, HttpServletResponse response){
        Inversion i = this.inversionDao.getInversionByUserAndInversionId(user.getUsername(), inversion.getId());
        InversionesResponseDTO inversionesResponseDTO = new InversionesResponseDTO();

        if (i != null){
           this.inversionDao.updateInversion(user.getUsername(), inversion);
           inversionesResponseDTO.setInversion(i);
            return inversionesResponseDTO;
        }


        response.setStatus(400);
        inversionesResponseDTO.setErrorMessage("No hay inversiones");
        return inversionesResponseDTO;
    }

    //lista todas las inversiones
    @RequestMapping(value = {"/listInversion"}, method = RequestMethod.GET)
    @ResponseBody
    public InversionesResponseDTO listInversion(User user, HttpServletResponse response){
        Map<String, Inversion> inversiones = this.inversionDao.getAllInversionesForUser(user.getUsername());
        InversionesResponseDTO inversionesResponseDTO = new InversionesResponseDTO();
        if (inversiones != null && !inversiones.isEmpty()){
            inversionesResponseDTO.setInversiones(inversiones);
            return inversionesResponseDTO;
        }
        response.setStatus(400);
        inversionesResponseDTO.setErrorMessage("No hay inversiones");
        return inversionesResponseDTO;
    }

    @RequestMapping(value = {"/addInversion"}, method = RequestMethod.POST)
    @ResponseBody
    public InversionesResponseDTO addInversion(User user, Inversion inversion){
        this.inversionDao.addInversionByUser(user.getUsername(), inversion);
        InversionesResponseDTO inversionesResponseDTO = new InversionesResponseDTO();

        inversionesResponseDTO.setInversion(inversion);

        return  inversionesResponseDTO;
    }

    @RequestMapping(value = {"/getCotizacionDolar"}, method = RequestMethod.GET)
    @ResponseBody
    public CotizacionDolarDTO getCotizacionDolar(){
        CotizacionDolarDTO cotizacionDolarDTO = new CotizacionDolarDTO();
        cotizacionDolarDTO.setNombre("Dolar");
        cotizacionDolarDTO.setPrecioCompra("16.60");
        cotizacionDolarDTO.setPrecioVenta("16.90");

        return cotizacionDolarDTO;


    }




}
