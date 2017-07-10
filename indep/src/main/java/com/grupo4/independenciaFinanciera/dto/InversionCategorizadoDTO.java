package com.grupo4.independenciaFinanciera.dto;

/**
 * Created by rumm on 10/07/17.
 */
public class InversionCategorizadoDTO {

    private String Categoria;
    private Integer monto;

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }
}
