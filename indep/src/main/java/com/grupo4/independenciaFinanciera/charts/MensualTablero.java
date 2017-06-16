package com.grupo4.independenciaFinanciera.charts;

import com.grupo4.independenciaFinanciera.model.GastosTotalMensual;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class MensualTablero implements ChartData {
    @Override
    public String getData() {
        JSONObject json = new JSONObject()
                .put("type", "serial")
                .put("categoryField", "date")
                .put("dataDateFormat", "YYYY-MM")
                .put("theme", "default")
                .put("categoryAxis", new JSONObject()
                        .put("minPeriod", "MM")
                        .put("parseDates", true)
                        .put("labelsEnabled", false)
                        .put("inside", true)
                )
                .put("chartCursor", new JSONObject()
                        .put("enabled", true)
                        .put("categoryBalloonDateFormat", "MMM YYYY")
                )
                .put("chartScrollbar", new JSONObject()
                        .put("enabled", true)
                )
                .put("graphs", new JSONArray()
                        .put(new JSONObject()
                                .put("balloonColor", "#008000")
                                .put("bullet", "round")
                                .put("color", "#008000")
                                .put("fillColors", "#008000")
                                .put("id", "ingresos")
                                .put("lineColor", "#008000")
                                .put("title", "Ingresos")
                                .put("valueField", "Ingresos")
                        )
                        .put(new JSONObject()
                                .put("balloonColor", "#FF0000")
                                .put("bullet", "square")
                                .put("color", "#FF0000")
                                .put("fillColors", "#FF0000")
                                .put("id", "egresos")
                                .put("lineColor", "#FF0000")
                                .put("title", "Egresos")
                                .put("valueField", "Egresos")
                        )
                )
                .put("valueAxes", new JSONArray()
                        .put(new JSONObject()
                                .put("id", "ValueAxis-1")
                                .put("title", "Dinero")
                        )
                )
                .put("legend", new JSONObject()
                        .put("enabled", true)
                        .put("useGraphSettings", true)
                    )
                .put("titles", new JSONArray()
                        .put(new JSONObject()
                                .put("id", "Title-1")
                                .put("size", 15)
                                .put("text", "Evolución Mensual")
                        )
                );

        addMonthlyData(json);

        return json.toString();
    }

    private JSONObject addMonthlyData(JSONObject jsonObject) {
        JSONArray datos = new JSONArray();
        for (GastosTotalMensual gasto : getGastosMensuales() ) {
            datos.put(new JSONObject()
                            .put("date", gasto.getFecha())
                            .put("Ingresos", gasto.getIngreso())
                            .put("Egresos", gasto.getEgreso()
                        )
                    );
        }

        jsonObject.put("dataProvider", datos);

        return jsonObject;
    }

    private List<GastosTotalMensual> getGastosMensuales() {
        List<GastosTotalMensual> list = new LinkedList<>();

        for(int i = 1; i <= 6; i++) {
            GastosTotalMensual gasto = new GastosTotalMensual();
            gasto.setFecha("2017-0" + i);
            Integer ingreso = new Integer(3800 * i);
            gasto.setIngreso(ingreso.toString());
            Integer egreso = new Integer(3000 * i);
            gasto.setEgreso(egreso.toString());

            list.add(gasto);
        }

        return  list;
    }
}
