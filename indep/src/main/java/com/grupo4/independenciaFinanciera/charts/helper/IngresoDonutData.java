package com.grupo4.independenciaFinanciera.charts.helper;

import com.grupo4.independenciaFinanciera.dto.DonutDataDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class IngresoDonutData implements DataAdder {
    @Override
    public JSONObject addData(JSONObject json) {
        JSONArray datos = new JSONArray();
        for (DonutDataDTO dato : getDonutData() ) {
            datos.put(new JSONObject()
                    .put("category", dato.getTipo())
                    .put("money", dato.getValor())
            );
        }

        json.put("dataProvider", datos);

        return json;
    }

    public List<DonutDataDTO> getDonutData() {
        List<DonutDataDTO> list = new LinkedList<>();

        DonutDataDTO dato1 = new DonutDataDTO();
        dato1.setTipo("Sueldo");
        dato1.setValor("12345");
        DonutDataDTO dato2 = new DonutDataDTO();
        dato2.setTipo("Venta Auto");
        dato2.setValor("44000");
        DonutDataDTO dato3 = new DonutDataDTO();
        dato3.setTipo("Cheque");
        dato3.setValor("7000");

        list.add(dato1);
        list.add(dato2);
        list.add(dato3);

        return list;
    }
}
