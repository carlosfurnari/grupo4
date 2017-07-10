package com.grupo4.independenciaFinanciera.dto;

import com.grupo4.independenciaFinanciera.model.Gasto;
import com.grupo4.independenciaFinanciera.model.Ingreso;

import java.util.List;

/**
 * Created by rumm on 10/07/17.
 */
public class IngresoResponseDTO {

    private List<IngresoDTO> ingresos;
    private Float total;
    private String errorMessage;

    //se usa cuando queremos devolver un solo ingreso
    private Ingreso ingreso;
    private List<IngresoCategorizadoDTO> ingresoByCategoria;


    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public List<IngresoCategorizadoDTO> getIngresoByCategoria() {
        return ingresoByCategoria;
    }

    public void setIngresoByCategoria(List<IngresoCategorizadoDTO> ingresoByCategoria) {
        this.ingresoByCategoria = ingresoByCategoria;
    }

    public List<IngresoDTO> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<IngresoDTO> ingresos) {
        this.ingresos = ingresos;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }
}
