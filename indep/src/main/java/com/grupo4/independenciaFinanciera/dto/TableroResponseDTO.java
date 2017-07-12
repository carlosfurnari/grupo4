package com.grupo4.independenciaFinanciera.dto;

/**
 * Created by rumm on 11/07/17.
 */
public class TableroResponseDTO {

    private String inversiones;
    private String gastos;
    private String ingresos;
    private String balance;

    public String getInversiones() {
        return inversiones;
    }

    public void setInversiones(String inversiones) {
        this.inversiones = inversiones;
    }

    public String getGastos() {
        return gastos;
    }

    public void setGastos(String gastos) {
        this.gastos = gastos;
    }

    public String getIngresos() {
        return ingresos;
    }

    public void setIngresos(String ingresos) {
        this.ingresos = ingresos;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
