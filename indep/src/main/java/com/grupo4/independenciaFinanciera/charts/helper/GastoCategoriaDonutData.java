package com.grupo4.independenciaFinanciera.charts.helper;

import com.grupo4.independenciaFinanciera.model.Gasto;
import com.grupo4.independenciaFinanciera.utils.MockLoader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GastoCategoriaDonutData implements DataAdder {
    @Override
    public JSONObject addData(JSONObject json) {
        JSONArray datos = new JSONArray();
        for (Gasto dato : getMappedData() ) {
            datos.put(new JSONObject()
                    .put("category", dato.getCategoria().toString())
                    .put("money", dato.getMonto())
            );
        }

        json.put("dataProvider", datos);

        return json;
    }

    private List<Gasto> getMappedData() {
        Map<String, Map<String, Gasto>> data = MockLoader.getInstance().getGastoMocks();
        List<Gasto> gastos = new LinkedList<>();

        for(String key : data.keySet()) {
            for(String key2 : data.get(key).keySet()) {
                    gastos.add(data.get(key).get(key2));
            }
        }

        return gastos;
    }
}
