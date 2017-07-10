package com.grupo4.independenciaFinanciera.dto;

import com.grupo4.independenciaFinanciera.model.Gasto;
import com.grupo4.independenciaFinanciera.model.Inversion;

import java.util.List;
import java.util.Map;

/**
 * Created by rumm on 14/06/17.
 */
public class InversionResponseDTO {

    private List<InversionDTO> inversiones;
    private Float total;
    private String errorMessage;

    //se usa cuando queremos devolver un solo gasto
    private Inversion inversion;
    private List<InversionCategorizadoDTO> inversionByCategoria;


    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public List<InversionCategorizadoDTO> getInversionByCategoria() {
        return inversionByCategoria;
    }

    public void setInversionByCategoria(List<InversionCategorizadoDTO> inversionByCategoria) {
        this.inversionByCategoria = inversionByCategoria;
    }

    public List<InversionDTO> getInversiones() {
        return inversiones;
    }

    public void setInversiones(List<InversionDTO> inversiones) {
        this.inversiones = inversiones;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Inversion getInversion() {
        return inversion;
    }

    public void setInversion(Inversion inversion) {
        this.inversion = inversion;
    }
}
