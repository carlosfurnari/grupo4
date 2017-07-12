package com.grupo4.independenciaFinanciera.controller;


import com.grupo4.independenciaFinanciera.charts.ChartData;
import com.grupo4.independenciaFinanciera.charts.DonutChart;
import com.grupo4.independenciaFinanciera.charts.helper.GastoCategoriaDonutData;
import com.grupo4.independenciaFinanciera.charts.helper.IngresoCategoriaDonutData;
import com.grupo4.independenciaFinanciera.dao.IngresoDao;
import com.grupo4.independenciaFinanciera.dto.IngresoCategorizadoDTO;
import com.grupo4.independenciaFinanciera.dto.IngresoDTO;
import com.grupo4.independenciaFinanciera.dto.IngresoResponseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.grupo4.independenciaFinanciera.dao.CategoriaDao;
import com.grupo4.independenciaFinanciera.model.*;
import com.grupo4.independenciaFinanciera.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by rumm on 13/06/17.
 */
@Controller
public class IngresoController {

    @Autowired
    private IngresoDao ingresoDao;

    @Autowired
    private CategoriaDao categoriaDao;


    //muestra el jsp y nada mas
    @RequestMapping(value = {"/ingresosPage"}, method = RequestMethod.GET)
    public String getIngresosPage(@RequestParam String username, ModelMap modelMap){
        ChartData ingresosPorCategoriaDonut = new DonutChart(new IngresoCategoriaDonutData(username));
        modelMap.addAttribute("ingresoPorCategoriaDonut", ingresosPorCategoriaDonut.getData());

        return "./show-ingresos";
    }

    @RequestMapping(value = {"/deleteIngreso"}, method = RequestMethod.GET)
    @ResponseBody
    public IngresoResponseDTO deleteIngreso(@RequestParam String username, @RequestParam String id, HttpServletResponse response){
        Ingreso g = this.ingresoDao.getIngresoByUserAndIngresoId(username, id);
        IngresoResponseDTO ingresoResponseDTO = new IngresoResponseDTO();

        if (g != null){
            this.ingresoDao.deleteIngreso(username, id);
            ingresoResponseDTO.setIngreso(g);
            return ingresoResponseDTO;
        }


        response.setStatus(400);
        ingresoResponseDTO.setErrorMessage("No hay Ingresos");
        return ingresoResponseDTO;
    }

    //lista todos los ingresos
    @RequestMapping(value = {"/listIngreso"}, method = RequestMethod.GET)
    @ResponseBody
    public IngresoResponseDTO listIngreso(@RequestParam String username, @RequestParam String filtro,
                                      @RequestParam String filtroCategoria, HttpServletResponse response){
        Map<String, Ingreso> ingreso = this.ingresoDao.getAllIngresosForUser(username);
        IngresoResponseDTO ingresoResponseDTO = new IngresoResponseDTO();
        if (ingreso != null && !ingreso.isEmpty()){
            ingresoResponseDTO.setIngresos(this.mapIngresoToIngresoDTO(ingreso, filtro, filtroCategoria));
            float total = 0;
            for (IngresoDTO g : ingresoResponseDTO.getIngresos()){
                total += Float.parseFloat(g.getMonto());
            }

            ingresoResponseDTO.setTotal(total);
            return ingresoResponseDTO;
        }
        response.setStatus(400);
        ingresoResponseDTO.setErrorMessage("No hay ingresos");
        return ingresoResponseDTO;
    }

    @RequestMapping(value = {"/listIngresoByCategoria"}, method = RequestMethod.GET)
    @ResponseBody
    public IngresoResponseDTO listIngresoByCategoria(@RequestParam String username, @RequestParam String filtro,
                                                     @RequestParam String filtroCategoria, HttpServletResponse response){
        Map<String, Ingreso> ingreso = this.ingresoDao.getAllIngresosForUser(username);
        IngresoResponseDTO ingresoResponseDTO = new IngresoResponseDTO();
        if (ingreso != null && !ingreso.isEmpty()){
            ingresoResponseDTO.setIngresoByCategoria(this.getIngresoByCategoria(ingreso, filtro, filtroCategoria));
            return ingresoResponseDTO;
        }
        response.setStatus(400);
        ingresoResponseDTO.setErrorMessage("No hay ingresos");
        return ingresoResponseDTO;
    }

    private List<IngresoCategorizadoDTO> getIngresoByCategoria(Map<String, Ingreso> ingreso, String filtro, String filtroCategoria) {
        Map<String, IngresoCategorizadoDTO> map = new HashMap<>();
        for (Ingreso g : ingreso.values()){

            if (this.filterByFecha(g, filtro) && this.filterByCategoria(g, filtroCategoria)) {
                IngresoCategorizadoDTO dto = map.get(g.getCategoria().getNombre());
                if (dto == null) {
                    dto = new IngresoCategorizadoDTO();
                    dto.setCategoria(g.getCategoria().getNombre());
                    dto.setMonto(0);
                    map.put(dto.getCategoria(), dto);
                }
                dto.setMonto(dto.getMonto() + Integer.parseInt(g.getMonto()));
            }

        }
        List<IngresoCategorizadoDTO> result = new ArrayList<IngresoCategorizadoDTO>(map.values());
        return result;

    }


    private List<IngresoDTO> mapIngresoToIngresoDTO(Map<String, Ingreso> ingreso, String filtro, String filtroCategoria) {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        List<IngresoDTO> result = new ArrayList<IngresoDTO>();
        for (Ingreso g : ingreso.values()){
            if (this.filterByFecha(g, filtro) && this.filterByCategoria(g, filtroCategoria)) {

                IngresoDTO dto = new IngresoDTO();
                dto.setCategoria(g.getCategoria().getNombre());
                dto.setCategoriaId(g.getCategoria().getId());
                dto.setDescripcion(g.getDescripcion());
                dto.setId(g.getId());
                dto.setMonto(g.getMonto());
                dto.setFecha(DATE_FORMAT.format(g.getFecha()));
                result.add(dto);
            }
        }
        return result;
    }

    private boolean filterByCategoria(Ingreso g, String filtroCategoria) {
        if (filtroCategoria.equalsIgnoreCase("empty")  || filtroCategoria.isEmpty()){
            return true;
        }
        return g.getCategoria().getId().equalsIgnoreCase(filtroCategoria);

    }

    private boolean filterByFecha(Ingreso g, String filtro) {
        Date fecha = g.getFecha();
        switch (filtro) {
            case "empty":
                return true;
            case "today":
                return DateUtils.isToday(fecha);
            case "month":
                return DateUtils.isThisMonth(fecha);
            case "year":
                return DateUtils.isThisYear(fecha);
            case "12months":
                return DateUtils.isLast12Months(fecha);
            case "nextmonth":
                return DateUtils.isNextMonths(fecha);
            case "next12months":
                return DateUtils.isNext12Months(fecha);
            case "lastmonth":
                return DateUtils.isLastMonth(fecha);
        }
        return true;
    }

    private Ingreso mapIngresoDTOToIngreso(IngresoDTO ingresoDTO) {
        Ingreso ingreso = new Ingreso();
        ingreso.setDescripcion(ingresoDTO.getDescripcion());


        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(ingresoDTO.getFecha());
            ingreso.setFecha(date);
        }catch(ParseException e){
            ingreso.setFecha(new Date());
        }

        Categoria categoria = this.categoriaDao.getCategoriaByUserAndCategoriaId(ingresoDTO.getUsername(), ingresoDTO.getCategoriaId());
        ingreso.setCategoria(categoria);
        ingreso.setMonto(ingresoDTO.getMonto());
        ingreso.setId(ingresoDTO.getId());

        return ingreso;
    }

    @RequestMapping(value = {"/addIngreso"}, method = RequestMethod.POST)
    @ResponseBody
    public IngresoResponseDTO addIngreso(@RequestBody IngresoDTO ingresoDTO, HttpServletResponse response){
        if (ingresoDTO.getId() != null && !ingresoDTO.getId().isEmpty()){
            Ingreso g = this.ingresoDao.getIngresoByUserAndIngresoId(ingresoDTO.getUsername(), ingresoDTO.getId());
            IngresoResponseDTO ingresoResponseDTO = new IngresoResponseDTO();

            if (g != null){
                Ingreso ingreso = this.mapIngresoDTOToIngreso(ingresoDTO);
                this.ingresoDao.updateIngreso(ingresoDTO.getUsername(), ingreso);
                ingresoResponseDTO.setIngreso(g);
                return ingresoResponseDTO;
            }


            response.setStatus(400);
            ingresoResponseDTO.setErrorMessage("No hay ingresos");
            return ingresoResponseDTO;
        }else{

            Ingreso ingreso = this.mapIngresoDTOToIngreso(ingresoDTO);
            this.ingresoDao.addIngresoByUser(ingresoDTO.getUsername(), ingreso);
            IngresoResponseDTO ingresoResponseDTO = new IngresoResponseDTO();

            ingresoResponseDTO.setIngreso(ingreso);

            return  ingresoResponseDTO;
        }
    }


}


