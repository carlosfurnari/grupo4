package com.grupo4.independenciaFinanciera.controller;

import com.grupo4.independenciaFinanciera.dao.CategoriaDao;
import com.grupo4.independenciaFinanciera.dto.CategoriaDTO;
import com.grupo4.independenciaFinanciera.dto.CategoriasDTO;
import com.grupo4.independenciaFinanciera.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rumm on 09/07/17.
 */
@Controller
public class CategoriasController {

    @Autowired
    private CategoriaDao categoriaDao;

    @RequestMapping(value = {"/listCategorias"}, method = RequestMethod.GET)
    @ResponseBody
    public CategoriasDTO listCategorias(@RequestParam String username){
        Map<String, Categoria> categorias = this.categoriaDao.getAllCategoriasForUser(username);

        CategoriasDTO categoriasDTO = new CategoriasDTO();
        categoriasDTO.setCategorias(new ArrayList<Categoria>(categorias.values()));
        return categoriasDTO;

    }


    @RequestMapping(value = {"/addCategoria"}, method = RequestMethod.POST)
    @ResponseBody
    public CategoriasDTO addCategoria(@RequestBody CategoriaDTO categoriaDTO){
        Categoria categoria = this.mapCategoriaDTOToCategoria(categoriaDTO);
        this.categoriaDao.addCategoriaByUser(categoriaDTO.getUsername(), categoria);

        Map<String, Categoria> categorias = this.categoriaDao.getAllCategoriasForUser(categoriaDTO.getUsername());

        CategoriasDTO categoriasDTO = new CategoriasDTO();
        categoriasDTO.setCategorias(new ArrayList<Categoria>(categorias.values()));
        return categoriasDTO;

    }

    private Categoria mapCategoriaDTOToCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();

        categoria.setNombre(categoriaDTO.getNombre());
        categoria.setDescription(categoriaDTO.getDescripcion());

        return  categoria;

    }

}
