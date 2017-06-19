package com.grupo4.independenciaFinanciera.dto;

import com.grupo4.independenciaFinanciera.model.Gasto;
import com.grupo4.independenciaFinanciera.model.Inversion;

import java.util.List;
import java.util.Map;

/**
 * Created by rumm on 14/06/17.
 */
public class GastoResponseDTO {

    private List<GastoDTO> gastos;
    private String errorMessage;

    //se usa cuando queremos devolver un solo gasto
    private Gasto gasto;
    private List<GastoCategorizadoDTO> gastoByCategoria;

    public List<GastoCategorizadoDTO> getGastoByCategoria() {
        return gastoByCategoria;
    }

    public void setGastoByCategoria(List<GastoCategorizadoDTO> gastoByCategoria) {
        this.gastoByCategoria = gastoByCategoria;
    }

    public List<GastoDTO> getGastos() {
        return gastos;
    }

    public void setGastos(List<GastoDTO> gastos) {
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
