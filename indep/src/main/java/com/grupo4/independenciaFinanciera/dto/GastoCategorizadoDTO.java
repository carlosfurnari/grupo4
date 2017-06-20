package com.grupo4.independenciaFinanciera.dto;

public class GastoCategorizadoDTO {
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
