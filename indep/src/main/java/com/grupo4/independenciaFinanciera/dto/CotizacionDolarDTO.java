package com.grupo4.independenciaFinanciera.dto;

/**
 * Created by rumm on 14/06/17.
 */
public class CotizacionDolarDTO {

    private String nombre;
    private String precioCompra;
    private String precioVenta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(String precioCompra) {
        this.precioCompra = precioCompra;
    }

    public String getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
    }
}
