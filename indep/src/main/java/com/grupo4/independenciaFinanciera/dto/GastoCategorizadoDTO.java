package com.grupo4.independenciaFinanciera.dto;

public class GastoCategorizadoDTO {
    private String Categoria;
    private String monto;

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }
}
