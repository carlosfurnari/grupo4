package com.grupo4.independenciaFinanciera.dao;

import com.grupo4.independenciaFinanciera.model.Gasto;
import com.grupo4.independenciaFinanciera.model.Inversion;
import com.grupo4.independenciaFinanciera.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rumm on 13/06/17.
 */

@Component
public class InversionDao {

    private Map<String, Map<String, Inversion>> inversionMap;

    public InversionDao(){
        super();

        this.inversionMap = new HashMap<String, Map<String, Inversion>>();

    }

    public Inversion getGastoByUserAndGastoId(String username, String inversionId){
        Map<String, Inversion> innerMap = this.inversionMap.get(username);

        if (innerMap != null){
            return innerMap.get(inversionId);
        }

        return null;
    }

    public void addGastoByUser(String username, Inversion inversion){

        Map<String, Inversion> innerMap = this.inversionMap.get(username);

        if (innerMap == null){
            innerMap = new HashMap<String, Inversion>();
        }

        innerMap.put(inversion.getId(), inversion);


    }

    public void deleteGasto(String username, String inversionId){
        Map<String, Inversion> innerMap = this.inversionMap.get(username);

        if (innerMap != null){
            innerMap.remove(inversionId);
        }
    }

    public void updateGasto(String username, Inversion inversion){
        Map<String, Inversion> innerMap = this.inversionMap.get(username);

        if (innerMap != null){
            innerMap.put(inversion.getId(), inversion);
        }
    }

    public Set<Inversion> getAllInversionesForUser(String username){
        Map<String, Inversion> innerMap = this.inversionMap.get(username);

        if (innerMap != null){
            return new HashSet<Inversion>(innerMap.values());
        }
        return null;
    }
}
