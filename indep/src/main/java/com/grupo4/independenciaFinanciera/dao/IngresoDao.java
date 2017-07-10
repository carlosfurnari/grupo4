package com.grupo4.independenciaFinanciera.dao;

import com.grupo4.independenciaFinanciera.config.Config;
import com.grupo4.independenciaFinanciera.model.Ingreso;
import com.grupo4.independenciaFinanciera.utils.MockLoader;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rumm on 10/07/17.
 */
@Component
public class IngresoDao {

    private Map<String, Map<String, Ingreso>> ingresoMap;

    public IngresoDao(){
        super();
        if (Config.USE_MOCKS){
            this.ingresoMap = MockLoader.getInstance().getIngresoMocks();
        }else {
            this.ingresoMap = new HashMap<String, Map<String, Ingreso>>();
        }


    }

    public Ingreso getIngresoByUserAndIngresoId(String username, String ingresoId){
        Map<String, Ingreso> innerMap = this.ingresoMap.get(username);

        if (innerMap != null){
            return innerMap.get(ingresoId);
        }

        return null;
    }

    public void addIngresoByUser(String username, Ingreso ingreso){

        Map<String, Ingreso> innerMap = this.ingresoMap.get(username);

        if (innerMap == null){
            innerMap = new HashMap<String, Ingreso>();
        }
        ingreso.setId(String.valueOf(innerMap.values().size()));
        innerMap.put(ingreso.getId(), ingreso);


    }

    public void deleteIngreso(String username, String ingresoId){
        Map<String, Ingreso> innerMap = this.ingresoMap.get(username);

        if (innerMap != null){
            innerMap.remove(ingresoId);
        }
    }

    public void updateIngreso(String username, Ingreso ingreso){
        Map<String, Ingreso> innerMap = this.ingresoMap.get(username);

        if (innerMap != null){
            innerMap.put(ingreso.getId(), ingreso);
        }
    }

    public Map<String, Ingreso> getAllIngresosForUser(String username){
        Map<String, Ingreso> innerMap = this.ingresoMap.get(username);

        return innerMap;
    }
}
