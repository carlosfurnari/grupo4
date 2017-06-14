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

        Gasto super1 = new Gasto();
        super1.setId("0");
        super1.setDescripcion("gasto de super del martes");
        super1.setCategoria(this.getCategoriasDefaultMocks().get("0"));
        super1.setMonto("200");
        super1.setFecha(new Date());
        super1.setTipoDeFrec(FrecuenciaDeOperacion.UNICO);
        super1.setRecurrente(Boolean.FALSE);

        Gasto super2 = new Gasto();
        super2.setId("1");
        super2.setDescripcion("gasto de super del jueves");
        super2.setCategoria(this.getCategoriasDefaultMocks().get("0"));
        super2.setMonto("500");
        super2.setFecha(new Date());
        super2.setTipoDeFrec(FrecuenciaDeOperacion.UNICO);
        super2.setRecurrente(Boolean.FALSE);

        Gasto super3 = new Gasto();
        super3.setId("2");
        super3.setDescripcion("gasto de super del sabado");
        super3.setCategoria(this.getCategoriasDefaultMocks().get("0"));
        super3.setMonto("300");
        super3.setFecha(new Date());
        super3.setTipoDeFrec(FrecuenciaDeOperacion.UNICO);
        super3.setRecurrente(Boolean.FALSE);

        Gasto luz = new Gasto();
        luz.setId("3");
        luz.setDescripcion("La factura de la luz");
        luz.setCategoria(this.getCategoriasDefaultMocks().get("2"));
        luz.setMonto("500");
        luz.setFecha(new Date());
        luz.setTipoDeFrec(FrecuenciaDeOperacion.UNICO);
        luz.setRecurrente(Boolean.FALSE);

        Gasto nafta = new Gasto();
        nafta.setId("3");
        nafta.setDescripcion("Llene el tanque el miercoles");
        nafta.setCategoria(this.getCategoriasDefaultMocks().get("3"));
        nafta.setMonto("1500");
        nafta.setFecha(new Date());
        nafta.setTipoDeFrec(FrecuenciaDeOperacion.UNICO);
        nafta.setRecurrente(Boolean.FALSE);



        for (User user : this.getUserMocks().values()){
            Map<String, Gasto> innerMap = new HashMap<String, Gasto>();
            super1.setUser(user);
            super2.setUser(user);
            super3.setUser(user);
            luz.setUser(user);
            nafta.setUser(user);

            innerMap.put(super1.getId(), super1);
            innerMap.put(super2.getId(), super2);
            innerMap.put(super3.getId(), super3);
            innerMap.put(luz.getId(), luz);
            innerMap.put(nafta.getId(), nafta);

            gastoMocks.put(user.getUsername(), innerMap);
        }

        return gastoMocks;
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
            this.categoriasDefaultMocks.put(supermercado.getId(), supermercado);

            Categoria servicios = new Categoria();
            servicios.setNombre("servicios");
            servicios.setDescription("servicios");
            servicios.setId("2");
            this.categoriasDefaultMocks.put(supermercado.getId(), supermercado);

            Categoria salidas = new Categoria();
            salidas.setNombre("salidas");
            salidas.setDescription("salidas");
            salidas.setId("3");
            this.categoriasDefaultMocks.put(supermercado.getId(), supermercado);

            Categoria tarjeta = new Categoria();
            tarjeta.setNombre("tarjeta");
            tarjeta.setDescription("tarjeta");
            tarjeta.setId("4");
            this.categoriasDefaultMocks.put(supermercado.getId(), supermercado);

            Categoria plazoFijo = new Categoria();
            plazoFijo.setNombre("plazoFijo");
            plazoFijo.setDescription("plazoFijo");
            plazoFijo.setId("5");
            this.categoriasDefaultMocks.put(supermercado.getId(), supermercado);


        }
        return this.categoriasDefaultMocks;
    }
}
