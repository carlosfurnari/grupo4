package com.grupo4.independenciaFinanciera.controller;

import com.grupo4.independenciaFinanciera.charts.ChartData;
import com.grupo4.independenciaFinanciera.charts.DonutChart;
import com.grupo4.independenciaFinanciera.charts.helper.GastoCategoriaDonutData;
import com.grupo4.independenciaFinanciera.dao.CategoriaDao;
import com.grupo4.independenciaFinanciera.dao.GastoDao;
import com.grupo4.independenciaFinanciera.dto.GastoCategorizadoDTO;
import com.grupo4.independenciaFinanciera.dto.GastoDTO;
import com.grupo4.independenciaFinanciera.dto.GastoResponseDTO;
import com.grupo4.independenciaFinanciera.dto.InversionesResponseDTO;
import com.grupo4.independenciaFinanciera.model.*;
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
 * Created by rumm on 13/06/17.
 */
@Controller
public class GastoController {

    @Autowired
    private GastoDao gastoDao;

    @Autowired
    private CategoriaDao categoriaDao;


    //muestra el jsp y nada mas
    @RequestMapping(value = {"/gastosPage"}, method = RequestMethod.GET)
    public String getGastosPage(@RequestParam String username, ModelMap modelMap){
        ChartData gastosPorCategoriaDonut = new DonutChart(new GastoCategoriaDonutData());
        modelMap.addAttribute("gastosPorCategoriaDonut", gastosPorCategoriaDonut.getData());

        return "./show-gastos";
    }

    //borra un gasto
    @RequestMapping(value = {"/deleteGasto"}, method = RequestMethod.GET)
    @ResponseBody
    public GastoResponseDTO deleteGasto(@RequestParam String username, @RequestParam String id, HttpServletResponse response){
        Gasto g = this.gastoDao.getGastoByUserAndGastoId(username, id);
        GastoResponseDTO gastoResponseDTO = new GastoResponseDTO();

        if (g != null){
            this.gastoDao.deleteGasto(username, id);
            gastoResponseDTO.setGasto(g);
            return gastoResponseDTO;
        }


        response.setStatus(400);
        gastoResponseDTO.setErrorMessage("No hay Gastos");
        return gastoResponseDTO;
    }

    //lista todos los gastos
    @RequestMapping(value = {"/listGasto"}, method = RequestMethod.GET)
    @ResponseBody
    public GastoResponseDTO listGasto(@RequestParam String username, HttpServletResponse response){
        Map<String, Gasto> gasto = this.gastoDao.getAllGastosForUser(username);
        GastoResponseDTO gastoResponseDTO = new GastoResponseDTO();
        if (gasto != null && !gasto.isEmpty()){
            gastoResponseDTO.setGastos(this.mapGastoToGastoDTO(gasto));
            return gastoResponseDTO;
        }
        response.setStatus(400);
        gastoResponseDTO.setErrorMessage("No hay gastos");
        return gastoResponseDTO;
    }

    @RequestMapping(value = {"/listGastoByCategoria"}, method = RequestMethod.GET)
    @ResponseBody
    public GastoResponseDTO listGastoByCategoria(@RequestParam String username, HttpServletResponse response){
        Map<String, Gasto> gasto = this.gastoDao.getAllGastosForUser(username);
        GastoResponseDTO gastoResponseDTO = new GastoResponseDTO();
        if (gasto != null && !gasto.isEmpty()){
            gastoResponseDTO.setGastoByCategoria(this.getGastoByCategoria(gasto));
            return gastoResponseDTO;
        }
        response.setStatus(400);
        gastoResponseDTO.setErrorMessage("No hay gastos");
        return gastoResponseDTO;
    }

    private List<GastoCategorizadoDTO> getGastoByCategoria(Map<String, Gasto> gasto) {
        Map<String, GastoCategorizadoDTO> map = new HashMap<>();
        for (Gasto g : gasto.values()){
            GastoCategorizadoDTO dto = map.get(g.getCategoria().getNombre());
            if (dto == null){
                dto = new GastoCategorizadoDTO();
                dto.setCategoria(g.getCategoria().getNombre());
                dto.setMonto(0);
                map.put(dto.getCategoria(), dto);
            }
            dto.setMonto(dto.getMonto() + Integer.parseInt(g.getMonto()));

        }
        List<GastoCategorizadoDTO> result = new ArrayList<GastoCategorizadoDTO>(map.values());
        return result;

    }


    private List<GastoDTO> mapGastoToGastoDTO(Map<String, Gasto> gasto) {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        List<GastoDTO> result = new ArrayList<GastoDTO>();
        for (Gasto g : gasto.values()){
            GastoDTO dto = new GastoDTO();
            dto.setCategoria(g.getCategoria().getNombre());
            dto.setCategoriaId(g.getCategoria().getId());
            dto.setDescripcion(g.getDescripcion());
            dto.setId(g.getId());
            dto.setMonto(g.getMonto());
            dto.setFecha(DATE_FORMAT.format(g.getFecha()));
            result.add(dto);
        }
        return result;
    }

    private Gasto mapGastoDTOToGasto(GastoDTO gastoDTO) {
        Gasto gasto = new Gasto();
        gasto.setDescripcion(gastoDTO.getDescripcion());


        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(gastoDTO.getFecha());
            gasto.setFecha(date);
        }catch(ParseException e){
            gasto.setFecha(new Date());
        }

        Categoria categoria = this.categoriaDao.getCategoriaByUserAndCategoriaId(gastoDTO.getUsername(), gastoDTO.getCategoriaId());
        gasto.setCategoria(categoria);
        gasto.setMonto(gastoDTO.getMonto());
        gasto.setId(gastoDTO.getId());

        return gasto;
    }

    @RequestMapping(value = {"/addGasto"}, method = RequestMethod.POST)
    @ResponseBody
    public GastoResponseDTO addGasto(@RequestBody GastoDTO gastoDTO, HttpServletResponse response){
        if (gastoDTO.getId() != null){
            Gasto g = this.gastoDao.getGastoByUserAndGastoId(gastoDTO.getUsername(), gastoDTO.getId());
            GastoResponseDTO gastoResponseDTO = new GastoResponseDTO();

            if (g != null){
                Gasto gasto = this.mapGastoDTOToGasto(gastoDTO);
                this.gastoDao.updateGasto(gastoDTO.getUsername(), gasto);
                gastoResponseDTO.setGasto(g);
                return gastoResponseDTO;
            }


            response.setStatus(400);
            gastoResponseDTO.setErrorMessage("No hay gastos");
            return gastoResponseDTO;
        }else{

            Gasto gasto = this.mapGastoDTOToGasto(gastoDTO);
            this.gastoDao.addGastoByUser(gastoDTO.getUsername(), gasto);
            GastoResponseDTO gastoResponseDTO = new GastoResponseDTO();

            gastoResponseDTO.setGasto(gasto);

            return  gastoResponseDTO;
        }
    }


}
