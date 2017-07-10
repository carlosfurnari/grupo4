package com.grupo4.independenciaFinanciera.dto;

import com.grupo4.independenciaFinanciera.model.FrecuenciaDeOperacion;

/**
 * Created by rumm on 10/07/17.
 */
public class IngresoDTO {

    private String username;
    private String categoria;
    private String categoriaId;
    private String descripcion;
    private String id;
    private String monto;
    private String fecha;
    private boolean recurrente;
    private FrecuenciaDeOperacion tipoDeFrec;
    private Integer frecuencia;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(String categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isRecurrente() {
        return recurrente;
    }

    public void setRecurrente(boolean recurrente) {
        this.recurrente = recurrente;
    }

    public FrecuenciaDeOperacion getTipoDeFrec() {
        return tipoDeFrec;
    }

    public void setTipoDeFrec(FrecuenciaDeOperacion tipoDeFrec) {
        this.tipoDeFrec = tipoDeFrec;
    }

    public Integer getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }
}
