package com.grupo4.independenciaFinanciera.controller;

import com.grupo4.independenciaFinanciera.charts.ChartData;
import com.grupo4.independenciaFinanciera.charts.DonutChart;
import com.grupo4.independenciaFinanciera.charts.helper.GastoCategoriaDonutData;
import com.grupo4.independenciaFinanciera.charts.helper.InversionesCategoriaDonutData;
import com.grupo4.independenciaFinanciera.dao.CategoriaDao;
import com.grupo4.independenciaFinanciera.dao.InversionDao;
import com.grupo4.independenciaFinanciera.dto.*;
import com.grupo4.independenciaFinanciera.model.Categoria;
import com.grupo4.independenciaFinanciera.model.Gasto;
import com.grupo4.independenciaFinanciera.model.Inversion;
import com.grupo4.independenciaFinanciera.model.User;
import com.grupo4.independenciaFinanciera.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by rumm on 14/06/17.
 */

@Controller
public class InversionesController {

    @Autowired
    private InversionDao inversionDao;

    @Autowired
    private CategoriaDao categoriaDao;

    //muestra el jsp y nada mas
    @RequestMapping(value = {"/inversionesPage"}, method = RequestMethod.GET)
    public String getInversionesPage(@RequestParam String username, ModelMap modelMap){
        ChartData ingresosPorCategoriaDonut = new DonutChart(new InversionesCategoriaDonutData(username));
        modelMap.addAttribute("inversionPorCategoriaDonut", ingresosPorCategoriaDonut.getData());


        return "./show-inversiones";
    }

    //borra un inversion
    @RequestMapping(value = {"/deleteInversion"}, method = RequestMethod.GET)
    @ResponseBody
    public InversionResponseDTO deleteInversion(@RequestParam String username, @RequestParam String id, HttpServletResponse response){
        Inversion g = this.inversionDao.getInversionByUserAndInversionId(username, id);
        InversionResponseDTO inversionResponseDTO = new InversionResponseDTO();

        if (g != null){
            this.inversionDao.deleteInversion(username, id);
            inversionResponseDTO.setInversion(g);
            return inversionResponseDTO;
        }


        response.setStatus(400);
        inversionResponseDTO.setErrorMessage("No hay Inversiones");
        return inversionResponseDTO;
    }

    //lista todos los inversiones
    @RequestMapping(value = {"/listInversion"}, method = RequestMethod.GET)
    @ResponseBody
    public InversionResponseDTO listInversion(@RequestParam String username, @RequestParam String filtro,
                                      @RequestParam String filtroCategoria, HttpServletResponse response){
        Map<String, Inversion> inversion = this.inversionDao.getAllInversionesForUser(username);
        InversionResponseDTO inversionResponseDTO = new InversionResponseDTO();
        if (inversion != null && !inversion.isEmpty()){
            inversionResponseDTO.setInversiones(this.mapInversionToInversionDTO(inversion, filtro, filtroCategoria));
            float total = 0;
            for (InversionDTO g : inversionResponseDTO.getInversiones()){
                total += Float.parseFloat(g.getMonto());
            }

            inversionResponseDTO.setTotal(total);
            return inversionResponseDTO;
        }
        response.setStatus(400);
        inversionResponseDTO.setErrorMessage("No hay inversiones");
        return inversionResponseDTO;
    }

    @RequestMapping(value = {"/listInversionByCategoria"}, method = RequestMethod.GET)
    @ResponseBody
    public InversionResponseDTO listInversionByCategoria(@RequestParam String username, HttpServletResponse response){
        Map<String, Inversion> inversion = this.inversionDao.getAllInversionesForUser(username);
        InversionResponseDTO inversionResponseDTO = new InversionResponseDTO();
        if (inversion != null && !inversion.isEmpty()){
            inversionResponseDTO.setInversionByCategoria(this.getInversionByCategoria(inversion));
            return inversionResponseDTO;
        }
        response.setStatus(400);
        inversionResponseDTO.setErrorMessage("No hay inversiones");
        return inversionResponseDTO;
    }

    private List<InversionCategorizadoDTO> getInversionByCategoria(Map<String, Inversion> inversion) {
        Map<String, InversionCategorizadoDTO> map = new HashMap<>();
        for (Inversion g : inversion.values()){
            InversionCategorizadoDTO dto = map.get(g.getCategoria().getNombre());
            if (dto == null){
                dto = new InversionCategorizadoDTO();
                dto.setCategoria(g.getCategoria().getNombre());
                dto.setMonto(0);
                map.put(dto.getCategoria(), dto);
            }
            dto.setMonto(dto.getMonto() + Integer.parseInt(g.getMonto()));

        }
        List<InversionCategorizadoDTO> result = new ArrayList<InversionCategorizadoDTO>(map.values());
        return result;

    }


    private List<InversionDTO> mapInversionToInversionDTO(Map<String, Inversion> inversion, String filtro, String filtroCategoria) {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        List<InversionDTO> result = new ArrayList<InversionDTO>();
        for (Inversion g : inversion.values()){
            if (this.filterByFecha(g, filtro) && this.filterByCategoria(g, filtroCategoria)) {

                InversionDTO dto = new InversionDTO();
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

    private boolean filterByCategoria(Inversion g, String filtroCategoria) {
        if (filtroCategoria.equalsIgnoreCase("empty")  || filtroCategoria.isEmpty()){
            return true;
        }
        return g.getCategoria().getId().equalsIgnoreCase(filtroCategoria);

    }

    private boolean filterByFecha(Inversion g, String filtro) {
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
        }
        return true;
    }

    private Inversion mapInversionDTOToInversion(InversionDTO inversionDTO) {
        Inversion inversion = new Inversion();
        inversion.setDescripcion(inversionDTO.getDescripcion());


        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(inversionDTO.getFecha());
            inversion.setFecha(date);
        }catch(ParseException e){
            inversion.setFecha(new Date());
        }

        Categoria categoria = this.categoriaDao.getCategoriaByUserAndCategoriaId(inversionDTO.getUsername(), inversionDTO.getCategoriaId());
        inversion.setCategoria(categoria);
        inversion.setMonto(inversionDTO.getMonto());
        inversion.setId(inversionDTO.getId());

        return inversion;
    }

    @RequestMapping(value = {"/addInversion"}, method = RequestMethod.POST)
    @ResponseBody
    public InversionResponseDTO addInversion(@RequestBody InversionDTO inversionDTO, HttpServletResponse response){
        if (inversionDTO.getId() != null && !inversionDTO.getId().isEmpty()){
            Inversion g = this.inversionDao.getInversionByUserAndInversionId(inversionDTO.getUsername(), inversionDTO.getId());
            InversionResponseDTO inversionResponseDTO = new InversionResponseDTO();

            if (g != null){
                Inversion inversion = this.mapInversionDTOToInversion(inversionDTO);
                this.inversionDao.updateInversion(inversionDTO.getUsername(), inversion);
                inversionResponseDTO.setInversion(g);
                return inversionResponseDTO;
            }


            response.setStatus(400);
            inversionResponseDTO.setErrorMessage("No hay inversiones");
            return inversionResponseDTO;
        }else{

            Inversion inversion = this.mapInversionDTOToInversion(inversionDTO);
            this.inversionDao.addInversionByUser(inversionDTO.getUsername(), inversion);
            InversionResponseDTO inversionResponseDTO = new InversionResponseDTO();

            inversionResponseDTO.setInversion(inversion);

            return  inversionResponseDTO;
        }
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
