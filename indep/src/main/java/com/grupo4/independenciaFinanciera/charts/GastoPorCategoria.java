package com.grupo4.independenciaFinanciera.charts;

import com.grupo4.independenciaFinanciera.dto.GastoCategorizadoDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class GastoPorCategoria implements ChartData {
    @Override
    public String getData() {
        JSONObject json = new JSONObject()
                            .put("type", "serial")
                            .put("categoryField", "monto")
                            .put("startDuration", 1)
                            .put("categoryAxis", new JSONObject()
                                       .put("gridPosition", "start")
                                )
                            .put("chartCursor", new JSONObject()
                                    .put("enabled", true)
                            )
                            .put("chartScrollbar", new JSONObject()
                                    .put("enabled", true)
                            )
                            .put("graphs", new JSONArray()
                                .put(new JSONObject()
                                        .put("fillAlphas", 1)
                                        .put("id", "AmGraph-1")
                                        .put("title", "graph 1")
                                        .put("type", "column")
                                        .put("valueField", "monto")
                                    )
                                )
                            .put("valueAxes", new JSONArray()
                                    .put(new JSONObject()
                                            .put("id", "ValueAxis-1")
                                            .put("title", "Monto")
                                    )
                            )
                            .put("titles", new JSONArray()
                                    .put(new JSONObject()
                                            .put("id", "Title-1")
                                            .put("size", 15)
                                            .put("text", "Gastos por categoría")
                                    )
                            );

        return addData(json).toString();

    }

    private JSONObject addData(JSONObject jsonObject) {
        JSONArray datos = new JSONArray();
        for (GastoCategorizadoDTO dato : getDonutData() ) {
            datos.put(new JSONObject()
                    .put("category", dato.getCategoria())
                    .put("monto", dato.getMonto())
            );
        }

        jsonObject.put("dataProvider", datos);

        return jsonObject;
    }

    public List<GastoCategorizadoDTO> getDonutData() {
        List<GastoCategorizadoDTO> list = new LinkedList<>();

        GastoCategorizadoDTO dato1 = new GastoCategorizadoDTO();
        dato1.setCategoria("Casa");
        dato1.setMonto(5000);
        GastoCategorizadoDTO dato2 = new GastoCategorizadoDTO();
        dato2.setCategoria("Alimentos");
        dato2.setMonto(9000);
        GastoCategorizadoDTO dato3 = new GastoCategorizadoDTO();
        dato3.setCategoria("Salidas");
        dato3.setMonto(3000);
        GastoCategorizadoDTO dato4 = new GastoCategorizadoDTO();
        dato4.setCategoria("Servicios");
        dato4.setMonto(6250);
        GastoCategorizadoDTO dato5 = new GastoCategorizadoDTO();
        dato5.setCategoria("Auto");
        dato5.setMonto(4100);

        list.add(dato1);
        list.add(dato2);
        list.add(dato3);
        list.add(dato4);
        list.add(dato5);

        return list;
    }
}
