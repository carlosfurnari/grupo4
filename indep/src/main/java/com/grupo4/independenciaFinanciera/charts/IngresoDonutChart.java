package com.grupo4.independenciaFinanciera.charts;

import com.grupo4.independenciaFinanciera.dto.IngresoDTO;
import com.grupo4.independenciaFinanciera.utils.MockLoader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class IngresoDonutChart implements ChartData {

    @Override
    public String getData() {
        JSONObject json = new JSONObject()
                .put("type", "pie")
                .put("balloonText", "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>")
                .put("innerRadius", "40%")
                .put("titleField", "category")
                .put("valueField", "money")
                .put("legend", new JSONObject()
                        .put("enabled", true)
                        .put("align", "center")
                        .put("markerType", "circle")
                );

        return addData(json).toString();
    }

    private JSONObject addData(JSONObject jsonObject) {
        JSONArray datos = new JSONArray();
        for (IngresoDTO dato : getDonutData() ) {
            datos.put(new JSONObject()
                    .put("category", dato.getTipo())
                    .put("money", dato.getValor())
                    );
        }

        jsonObject.put("dataProvider", datos);

        return jsonObject;
    }

    public List<IngresoDTO> getDonutData() {
        List<IngresoDTO> list = new LinkedList<>();

        IngresoDTO dato1 = new IngresoDTO();
        dato1.setTipo("Sueldo");
        dato1.setValor("12345");
        IngresoDTO dato2 = new IngresoDTO();
        dato2.setTipo("Venta Auto");
        dato2.setValor("44000");
        IngresoDTO dato3 = new IngresoDTO();
        dato3.setTipo("Cheque");
        dato3.setValor("7000");

        list.add(dato1);
        list.add(dato2);
        list.add(dato3);

        return list;
    }
}
