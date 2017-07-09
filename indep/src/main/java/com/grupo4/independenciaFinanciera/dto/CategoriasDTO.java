package com.grupo4.independenciaFinanciera.dto;

import com.grupo4.independenciaFinanciera.model.Categoria;

import java.util.List;

/**
 * Created by rumm on 18/06/17.
 */
public class CategoriasDTO {

    private List<Categoria> categorias;

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
