package com.grupo4.independenciaFinanciera.utils;

import com.grupo4.independenciaFinanciera.model.*;

import java.beans.FeatureDescriptor;
import java.util.*;

/**
 * Created by rumm on 14/06/17.
 */

public class MockLoader {

    private static MockLoader instance = null;
    private Map<String, User> userMocks;
    private Map<String, Categoria> categoriasDefaultMocks;
    private Map<String, Map<String, Inversion>> inversionMocks;
    private Map<String, Map<String, Gasto>> gastoMocks;
    private Map<String, Map<String, Ingreso>> ingresoMocks;
    private Map<String, Map<String, Categoria>> categoriaMocks;

    public static MockLoader getInstance(){
        if(instance == null){
            instance = new MockLoader();
        }
        return  instance;
    }

    private MockLoader(){
        super();
    }


    public Map<String, User> getUserMocks() {
        if (this.userMocks == null) {
            this.userMocks = new HashMap<String, User>();

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("admin");
            admin.setEmail("admin@gmail.com");
            this.userMocks.put(admin.getUsername(), admin);

            User cliente = new User();
            cliente.setUsername("cliente");
            cliente.setPassword("cliente");
            cliente.setEmail("cliente@gmail.com");
            this.userMocks.put(cliente.getUsername(), cliente);
        }

        return userMocks;
    }

    public Map<String, Map<String, Inversion>> getInversionMocks() {
        this.inversionMocks = new HashMap<String, Map<String, Inversion>>();

        Inversion plazoFijo = new Inversion();
        plazoFijo.setId("0");
        plazoFijo.setCategoria(this.getCategoriasDefaultMocks().get("5"));
        plazoFijo.setDescripcion("plazo fijo banco santander");
        plazoFijo.setFecha(new Date());
        plazoFijo.setTipoDeFrec(FrecuenciaDeOperacion.MENSUAL);
        plazoFijo.setMonto("10000");
        plazoFijo.setRecurrente(Boolean.FALSE);

        Inversion otroPlazoFijo = new Inversion();
        otroPlazoFijo.setId("1");
        otroPlazoFijo.setCategoria(this.getCategoriasDefaultMocks().get("5"));
        otroPlazoFijo.setDescripcion("plazo fijo banco nacion");
        otroPlazoFijo.setFecha(new Date());
        otroPlazoFijo.setTipoDeFrec(FrecuenciaDeOperacion.MENSUAL);
        otroPlazoFijo.setMonto("5000");
        otroPlazoFijo.setRecurrente(Boolean.FALSE);

        for (User user : this.getUserMocks().values()){
            Map<String, Inversion> innerMap = new HashMap<String, Inversion>();
            plazoFijo.setUser(user);
            otroPlazoFijo.setUser(user);
            innerMap.put(plazoFijo.getId(), plazoFijo);
            innerMap.put(otroPlazoFijo.getId(), otroPlazoFijo);

            inversionMocks.put(user.getUsername(), innerMap);
        }



        return inversionMocks;
    }

    public Map<String, Map<String, Gasto>> getGastoMocks() {
        this.gastoMocks = new HashMap<String, Map<String, Gasto>>();

        ArrayList<Gasto> gastos = new ArrayList<>();

        //facturas de servicios
        gastos.add(getGasto("0", "La factura de la luz", this.getCategoriasDefaultMocks().get("2"), "250", DateUtils.dateFor("05-05-2017")));
        gastos.add(getGasto("1", "La factura de la luz", this.getCategoriasDefaultMocks().get("2"), "532", DateUtils.dateFor("05-06-2017")));
        gastos.add(getGasto("2", "La factura de la luz", this.getCategoriasDefaultMocks().get("2"), "368", DateUtils.dateFor("06-04-2017")));
        gastos.add(getGasto("3", "La factura del gas", this.getCategoriasDefaultMocks().get("2"), "504", DateUtils.dateFor("05-06-2017")));
        gastos.add(getGasto("4", "La factura del gas", this.getCategoriasDefaultMocks().get("2"), "709", DateUtils.dateFor("04-07-2017")));
        gastos.add(getGasto("5", "La factura del gas", this.getCategoriasDefaultMocks().get("2"), "603", DateUtils.dateFor("04-05-2017")));

        //tarjeta
        gastos.add(getGasto("6", "American express", this.getCategoriasDefaultMocks().get("4"), "1500", DateUtils.dateFor("12-05-2017")));
        gastos.add(getGasto("7", "American express", this.getCategoriasDefaultMocks().get("4"), "3000", DateUtils.dateFor("11-06-2017")));
        gastos.add(getGasto("8", "American express", this.getCategoriasDefaultMocks().get("4"), "500", DateUtils.dateFor("13-07-2017")));
        gastos.add(getGasto("38", "American express", this.getCategoriasDefaultMocks().get("4"), "900", DateUtils.dateFor("15-08-2017")));
        gastos.add(getGasto("39", "Visa", this.getCategoriasDefaultMocks().get("4"), "2670", DateUtils.dateFor("12-08-2017")));
        gastos.add(getGasto("9", "Visa", this.getCategoriasDefaultMocks().get("4"), "1570", DateUtils.dateFor("11-05-2017")));
        gastos.add(getGasto("10", "Visa", this.getCategoriasDefaultMocks().get("4"), "2500", DateUtils.dateFor("10-06-2017")));
        gastos.add(getGasto("11", "Visa", this.getCategoriasDefaultMocks().get("4"), "500", DateUtils.dateFor("11-07-2017")));

        //auto
        gastos.add(getGasto("12", "Nafta lunes", this.getCategoriasDefaultMocks().get("1"), "300", DateUtils.dateFor("17-05-2017")));
        gastos.add(getGasto("13", "Lubricante", this.getCategoriasDefaultMocks().get("1"), "150", DateUtils.dateFor("05-06-2017")));
        gastos.add(getGasto("14", "Llene el tanque el miercoles", this.getCategoriasDefaultMocks().get("1"), "1500", DateUtils.dateFor("14-06-2017")));
        gastos.add(getGasto("15", "Seguro del auto", this.getCategoriasDefaultMocks().get("1"), "220", DateUtils.dateFor("02-05-2017")));
        gastos.add(getGasto("16", "Seguro del auto", this.getCategoriasDefaultMocks().get("1"), "220", DateUtils.dateFor("03-06-2017")));
        gastos.add(getGasto("17", "Seguro del auto", this.getCategoriasDefaultMocks().get("1"), "220", DateUtils.dateFor("01-07-2017")));
        gastos.add(getGasto("40", "Seguro del auto", this.getCategoriasDefaultMocks().get("1"), "220", DateUtils.dateFor("03-08-2017")));
        gastos.add(getGasto("26", "Nafta Sabado", this.getCategoriasDefaultMocks().get("1"), "500", DateUtils.dateFor("15-05-2017")));
        gastos.add(getGasto("27", "Mecanico", this.getCategoriasDefaultMocks().get("1"), "3000", DateUtils.dateFor("17-06-2017")));
        gastos.add(getGasto("28", "Nafta Miercoles", this.getCategoriasDefaultMocks().get("1"), "500", DateUtils.dateFor("05-07-2017")));
        gastos.add(getGasto("29", "Nafta Domingo", this.getCategoriasDefaultMocks().get("1"), "1300", DateUtils.dateFor("29-06-2017")));

        //super
        gastos.add(getGasto("18", "Gasto de super del finde", this.getCategoriasDefaultMocks().get("0"), "500", DateUtils.dateFor("05-06-2017")));
        gastos.add(getGasto("19", "Cerveza", this.getCategoriasDefaultMocks().get("0"), "300", DateUtils.dateFor("14-05-2017")));
        gastos.add(getGasto("20", "Gasto de super del martes", this.getCategoriasDefaultMocks().get("0"), "200", DateUtils.dateFor("13-06-2017")));
        gastos.add(getGasto("21", "Gasto de super del jueves", this.getCategoriasDefaultMocks().get("0"), "500", DateUtils.dateFor("15-05-2017")));
        gastos.add(getGasto("22", "Compras del mes", this.getCategoriasDefaultMocks().get("0"), "1800", DateUtils.dateFor("17-05-2017")));
        gastos.add(getGasto("23", "Compras del mes", this.getCategoriasDefaultMocks().get("0"), "2920", DateUtils.dateFor("05-06-2017")));
        gastos.add(getGasto("24", "Birra", this.getCategoriasDefaultMocks().get("0"), "200", DateUtils.dateFor("14-06-2017")));
        gastos.add(getGasto("25", "Pizza", this.getCategoriasDefaultMocks().get("0"), "200", DateUtils.dateFor("12-07-2017")));

        //salidas
        gastos.add(getGasto("30", "Bar", this.getCategoriasDefaultMocks().get("3"), "253", DateUtils.dateFor("13-06-2017")));
        gastos.add(getGasto("31", "After office", this.getCategoriasDefaultMocks().get("3"), "500", DateUtils.dateFor("25-06-2017")));
        gastos.add(getGasto("32", "Asado con los muchachos", this.getCategoriasDefaultMocks().get("3"), "300", DateUtils.dateFor("17-05-2017")));
        gastos.add(getGasto("33", "Cine", this.getCategoriasDefaultMocks().get("3"), "120", DateUtils.dateFor("05-05-2017")));
        gastos.add(getGasto("34", "Teatro", this.getCategoriasDefaultMocks().get("3"), "200", DateUtils.dateFor("14-06-2017")));
        gastos.add(getGasto("35", "Bar Jueves", this.getCategoriasDefaultMocks().get("3"), "200", DateUtils.dateFor("15-06-2017")));
        gastos.add(getGasto("36", "Cena Restaurant", this.getCategoriasDefaultMocks().get("3"), "500", DateUtils.dateFor("25-05-2017")));
        gastos.add(getGasto("37", "Parrilla", this.getCategoriasDefaultMocks().get("3"), "300", DateUtils.dateFor("07-07-2017")));


        for (User user : this.getUserMocks().values()){
            Map<String, Gasto> innerMap = new HashMap<String, Gasto>();
            for (Gasto g : gastos){
                g.setUser(user);
                innerMap.put(g.getId(), g);
            }

            gastoMocks.put(user.getUsername(), innerMap);
        }

        return gastoMocks;
    }

    private Gasto getGasto(String id, String descripcion, Categoria categoria, String monto, Date fecha) {
        Gasto super1 = new Gasto();
        super1.setId(id);
        super1.setDescripcion(descripcion);
        super1.setCategoria(categoria);
        super1.setMonto(monto);
        super1.setFecha(fecha);
        super1.setTipoDeFrec(FrecuenciaDeOperacion.UNICO);
        super1.setRecurrente(Boolean.FALSE);
        return super1;
    }

    public Map<String, Map<String, Ingreso>> getIngresoMocks() {
        this.ingresoMocks = new HashMap<String, Map<String, Ingreso>>();
        ArrayList<Ingreso> ingresos = new ArrayList<>();
        ingresos.add(getIngreso("0", "Sueldo Mensual", this.getCategoriasDefaultMocks().get("10"), "25000", DateUtils.dateFor("01-07-2017")));
        ingresos.add(getIngreso("1", "Aguinaldo", this.getCategoriasDefaultMocks().get("10"), "12500", DateUtils.dateFor("07-07-2017")));
        ingresos.add(getIngreso("2", "Sueldo Mensual", this.getCategoriasDefaultMocks().get("10"), "25000", DateUtils.dateFor("01-05-2017")));
        ingresos.add(getIngreso("4", "Sueldo Mensual", this.getCategoriasDefaultMocks().get("10"), "25000", DateUtils.dateFor("01-06-2017")));
        ingresos.add(getIngreso("5", "Venta mercado libre", this.getCategoriasDefaultMocks().get("11"), "300", DateUtils.dateFor("22-06-2017")));
        ingresos.add(getIngreso("6", "Sueldo Mensual", this.getCategoriasDefaultMocks().get("10"), "25000", DateUtils.dateFor("01-08-2017")));
        ingresos.add(getIngreso("7", "Gane Apuesta", this.getCategoriasDefaultMocks().get("11"), "50", DateUtils.dateFor("08-07-2017")));
        

        for (User user : this.getUserMocks().values()){
            Map<String, Ingreso> innerMap = new HashMap<String, Ingreso>();
            for (Ingreso g : ingresos){
                g.setUser(user);
                innerMap.put(g.getId(), g);
            }

            ingresoMocks.put(user.getUsername(), innerMap);
        }

        return ingresoMocks;
    }

    private Ingreso getIngreso(String id, String descripcion, Categoria categoria, String monto, Date fecha) {
        Ingreso sueldo = new Ingreso();
        sueldo.setId(id);
        sueldo.setDescripcion(descripcion);
        sueldo.setCategoria(categoria);
        sueldo.setMonto(monto);
        sueldo.setFecha(fecha);
        sueldo.setTipoDeFrec(FrecuenciaDeOperacion.UNICO);
        sueldo.setRecurrente(Boolean.FALSE);
        return sueldo;
    }

    public Map<String, Map<String, Categoria>> getCategoriaMocks() {
        this.categoriaMocks = new HashMap<String, Map<String, Categoria>>();

        for (User user : this.getUserMocks().values()){
            Map<String, Categoria> innerMap = new HashMap<String, Categoria>();
            for (Categoria c : this.getCategoriasDefaultMocks().values()){
                innerMap.put(c.getId(), c);
            }
            categoriaMocks.put(user.getUsername(), innerMap);
        }

        return categoriaMocks;
    }

    private Map<String, Categoria> getCategoriasDefaultMocks(){
        if (this.categoriasDefaultMocks == null){
            this.categoriasDefaultMocks = new HashMap<String, Categoria>();


            Categoria supermercado = new Categoria();
            supermercado.setNombre("supermercado");
            supermercado.setDescription("las compras del supermercado");
            supermercado.setId("0");
            this.categoriasDefaultMocks.put(supermercado.getId(), supermercado);


            Categoria auto = new Categoria();
            auto.setNombre("auto");
            auto.setDescription("auto");
            auto.setId("1");
            this.categoriasDefaultMocks.put(auto.getId(), auto);

            Categoria servicios = new Categoria();
            servicios.setNombre("servicios");
            servicios.setDescription("servicios");
            servicios.setId("2");
            this.categoriasDefaultMocks.put(servicios.getId(), servicios);

            Categoria salidas = new Categoria();
            salidas.setNombre("salidas");
            salidas.setDescription("salidas");
            salidas.setId("3");
            this.categoriasDefaultMocks.put(salidas.getId(), salidas);

            Categoria tarjeta = new Categoria();
            tarjeta.setNombre("tarjeta");
            tarjeta.setDescription("tarjeta");
            tarjeta.setId("4");
            this.categoriasDefaultMocks.put(tarjeta.getId(), tarjeta);

            Categoria plazoFijo = new Categoria();
            plazoFijo.setNombre("plazoFijo");
            plazoFijo.setDescription("plazoFijo");
            plazoFijo.setId("5");
            this.categoriasDefaultMocks.put(plazoFijo.getId(), plazoFijo);

            Categoria rentaFijaPesos = new Categoria();
            rentaFijaPesos.setNombre("Renta Fija Pesos");
            rentaFijaPesos.setDescription("Renta Fija Pesos");
            rentaFijaPesos.setId("6");
            this.categoriasDefaultMocks.put(rentaFijaPesos.getId(), rentaFijaPesos);

            Categoria rentaVariablePesos = new Categoria();
            rentaVariablePesos.setNombre("Renta Variable Pesos");
            rentaVariablePesos.setDescription("Renta Variable Pesos");
            rentaVariablePesos.setId("7");
            this.categoriasDefaultMocks.put(rentaVariablePesos.getId(), rentaVariablePesos);

            Categoria rentaFijaDolares = new Categoria();
            rentaFijaDolares.setNombre("Renta Fija Dolares");
            rentaFijaDolares.setDescription("Renta Fija Dolares");
            rentaFijaDolares.setId("8");
            this.categoriasDefaultMocks.put(rentaFijaDolares.getId(), rentaFijaDolares);

            Categoria rentaVariableDolares = new Categoria();
            rentaVariableDolares.setNombre("Renta Variable Dolares");
            rentaVariableDolares.setDescription("Renta Variable Dolares");
            rentaVariableDolares.setId("9");
            this.categoriasDefaultMocks.put(rentaVariableDolares.getId(), rentaVariableDolares);

            Categoria sueldo = new Categoria();
            sueldo.setNombre("Sueldo");
            sueldo.setDescription("El sueldo");
            sueldo.setId("10");
            this.categoriasDefaultMocks.put(sueldo.getId(), sueldo);

            Categoria ingresosVarios = new Categoria();
            ingresosVarios.setNombre("Ingresos Varios");
            ingresosVarios.setDescription("Ingresos Varios");
            ingresosVarios.setId("11");
            this.categoriasDefaultMocks.put(ingresosVarios.getId(), ingresosVarios);

        }
        return this.categoriasDefaultMocks;
    }
}
