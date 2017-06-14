package com.grupo4.independenciaFinanciera.dto;

import com.grupo4.independenciaFinanciera.model.Gasto;
import com.grupo4.independenciaFinanciera.model.Inversion;

import java.util.Map;

/**
 * Created by rumm on 14/06/17.
 */
public class GastoResponseDTO {

    private Map<String, Gasto> gastos;
    private String errorMessage;

    //se usa cuando queremos devolver un solo gasto
    private Gasto gasto;

    public Map<String, Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(Map<String, Gasto> gastos) {
        this.gastos = gastos;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Gasto getGasto() {
        return gasto;
    }

    public void setGasto(Gasto gasto) {
        this.gasto = gasto;
    }
}
