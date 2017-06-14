package com.grupo4.independenciaFinanciera.model;

import java.util.Date;

/**
 * Created by rumm on 13/06/17.
 */
public class Inversion {

    private Categoria categoria;
    private String descripcion;
    private String id;
    private String monto;
    private Date fecha;
    private boolean recurrente;
    private FrecuenciaDeOperacion tipoDeFrec;
    private Integer frecuencia;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
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
    @Override
    public String toString() {
        return "Inversion [id=" + id + ", descripcion=" + descripcion
                + ", categoria=" + categoria + ", monto=" + monto + ", fecha="
                + fecha + "]";
    }
}
