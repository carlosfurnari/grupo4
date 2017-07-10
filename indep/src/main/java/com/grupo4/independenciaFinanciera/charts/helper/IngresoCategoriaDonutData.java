package com.grupo4.independenciaFinanciera.charts.helper;

import com.grupo4.independenciaFinanciera.model.Ingreso;
import com.grupo4.independenciaFinanciera.utils.MockLoader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class IngresoCategoriaDonutData implements DataAdder {
    @Override
    public JSONObject addData(JSONObject json) {
        JSONArray datos = new JSONArray();
        for (Ingreso dato : getMappedData() ) {
            datos.put(new JSONObject()
                    .put("category", dato.getCategoria().getDescription())
                    .put("money", dato.getMonto())
            );
        }

        json.put("dataProvider", datos);

        return json;
    }

    private List<Ingreso> getMappedData() {
        Map<String, Map<String, Ingreso>> data = MockLoader.getInstance().getIngresoMocks();
        List<Ingreso> ingresos = new LinkedList<>();

        for(String key : data.keySet()) {
            for(String key2 : data.get(key).keySet()) {
                ingresos.add(data.get(key).get(key2));
            }
            break;
        }

        return ingresos;
    }
}
