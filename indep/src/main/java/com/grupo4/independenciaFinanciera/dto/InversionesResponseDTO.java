package com.grupo4.independenciaFinanciera.dto;

import com.grupo4.independenciaFinanciera.model.Inversion;

import java.util.Map;

/**
 * Created by rumm on 14/06/17.
 */
public class InversionesResponseDTO {

    private Map<String, Inversion> inversiones;
    private String errorMessage;

    //se usa cuando queremos devolver una sola inversion
    private Inversion inversion;

    public Inversion getInversion() {
        return inversion;
    }

    public void setInversion(Inversion inversion) {
        this.inversion = inversion;
    }

    public Map<String, Inversion> getInversiones() {
        return inversiones;
    }

    public void setInversiones(Map<String, Inversion> inversiones) {
        this.inversiones = inversiones;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
