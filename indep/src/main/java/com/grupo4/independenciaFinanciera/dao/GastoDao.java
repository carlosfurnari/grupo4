package com.grupo4.independenciaFinanciera.dao;

import com.grupo4.independenciaFinanciera.model.Gasto;
import com.grupo4.independenciaFinanciera.model.Inversion;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rumm on 13/06/17.
 */

@Component
public class GastoDao {

    private Map<String, Map<String, Gasto>> gastoMap;

    public GastoDao(){
        super();

        this.gastoMap = new HashMap<String, Map<String, Gasto>>();

    }

    public Gasto getGastoByUserAndGastoId(String username, String gastoId){
        Map<String, Gasto> innerMap = this.gastoMap.get(username);

        if (innerMap != null){
            return innerMap.get(gastoId);
        }

        return null;
    }

    public void addGastoByUser(String username, Gasto gasto){

        Map<String, Gasto> innerMap = this.gastoMap.get(username);

        if (innerMap == null){
            innerMap = new HashMap<String, Gasto>();
        }

        innerMap.put(gasto.getId(), gasto);


    }

    public void deleteGasto(String username, String gastoId){
        Map<String, Gasto> innerMap = this.gastoMap.get(username);

        if (innerMap != null){
            innerMap.remove(gastoId);
        }
    }

    public void updateGasto(String username, Gasto gasto){
        Map<String, Gasto> innerMap = this.gastoMap.get(username);

        if (innerMap != null){
            innerMap.put(gasto.getId(), gasto);
        }
    }

    public Set<Gasto> getAllGastosForUser(String username){
        Map<String, Gasto> innerMap = this.gastoMap.get(username);

        if (innerMap != null){
            return new HashSet<Gasto>(innerMap.values());
        }
        return null;
    }
}
