package com.grupo4.independenciaFinanciera.controller;

import com.grupo4.independenciaFinanciera.model.Categoria;
import com.grupo4.independenciaFinanciera.model.Gasto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rumm on 13/06/17.
 */
@Controller
public class GastoController {


    @RequestMapping(value = {"/deleteGasto"}, method = RequestMethod.GET)
    public String deleteGasto(@RequestParam String gastoId, ModelMap modelMap){
        System.out.println("DELETE GASTO" + gastoId);
        modelMap.addAttribute("gastos", getMockedGastos() );
        return "show-gastos";
    }

    @RequestMapping(value = {"/editGasto"}, method = RequestMethod.GET)
    public String editGasto(){
//        System.out.println("EDIT gasto");
//        int gastoId = Integer.parseInt( request.getParameter("gastoId") );
//        request.setAttribute("gasto", null);
//        String gastoId = request.getParameter("gastoId") ;
        return "carga-gastos";
    }

    @RequestMapping(value = {"/insertGasto"}, method = RequestMethod.GET)
    public String insertGasto(){
        return "carga-gastos";
    }

    @RequestMapping(value = {"/listGasto"}, method = RequestMethod.GET)
    public String listGasto(ModelMap modelMap){
        modelMap.addAttribute("gastos", getMockedGastos() );
        return "show-gastos";
    }

    @RequestMapping(value = {"/addGasto"}, method = RequestMethod.POST)
    public String addGasto(){
//        Gasto gasto = new Gasto();
//        gasto.setDescripcion(request.getParameter( "desc" ) );
//        gasto.setMonto( request.getParameter( "monto" ) );
//        gasto.setCategoria( Categoria.valueOf(request.getParameter( "Cat" )) );
//        String gastoId = request.getParameter("gastoId");
//
//        if( gastoId == null || gastoId.isEmpty() )
//            //dao.addStudent(student);
//            System.out.println("Add to database");
//        else {
//            gasto.setId( gastoId );
//            //dao.updateStudent(student);
//            System.out.println("update in database");
//        }

        return "redirect:show-gastos";
    }


    private List<Gasto> getMockedGastos() {
        Gasto gasto1 = new Gasto();
        gasto1.setDescripcion("desc1");
        gasto1.setCategoria(Categoria.ALIMENTOS);
        gasto1.setMonto("200");

        Gasto gasto2 = new Gasto();
        gasto2.setDescripcion("desc2");
        gasto2.setCategoria(Categoria.INDUMENTARIA);
        gasto2.setMonto("500");
        List<Gasto> result = new ArrayList<Gasto>();
        result.add(gasto1);
        result.add(gasto2);
        return result;
    }


}
