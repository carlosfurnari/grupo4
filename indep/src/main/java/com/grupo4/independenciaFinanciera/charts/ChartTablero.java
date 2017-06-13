package com.grupo4.independenciaFinanciera.charts;

import org.json.JSONArray;
import org.json.JSONObject;

public class ChartTablero implements ChartData {

    private float income;
    private float expenses;
    private float total;

    public ChartTablero() {
        this.income = incomeValue();
        this.expenses = expensesValue();
        this.total = income + expenses;
    }


    //@Override
    public String getData() {
        String jsonString = new JSONObject()
                                .put("type", "serial")
                                .put("categoryField", "category")
                                .put("rotate", true)
                .put("startDuration", 1)
                .put("categoryAxis", new JSONObject()
                    .put("gridPosition", "start")
                )
                .put("trendLines", new JSONArray()
                    .put(new JSONObject()
                            .put("id", "TrendLine-1")
                        )
                    )
                .put("graphs", new JSONArray()
                    .put(new JSONObject()
                            .put("ballonText", "[[title]] of [[category]]:[[value]]")
                            .put("fillAlphas", 1)
                            .put("fillColors", "#5FC00B")
                            .put("id", "AmGraph-1")
                            .put("lineColor", "#5FC00B")
                            .put("title", "graph 1")
                            .put("type", "column")
                            .put("valueField", "column-1")
                        )
                    .put(new JSONObject()
                            .put("ballonText", "[[title]] of [[category]]:[[value]]")
                            .put("fillAlphas", 1)
                            .put("fillColors", "#ED1313")
                            .put("id", "AmGraph-2")
                            .put("lineColor", "#ED1313")
                            .put("title", "graph 2")
                            .put("type", "column")
                            .put("valueField", "column-2")
                        )
                    )
                .put("valueAxes", new JSONArray()
                        .put(new JSONObject()
                                .put("id", "ValueAxis-1")
                                .put("stackType", "100%")
                                .put("gridColor", "#CC2525")
                                .put("title", "")
                            )
                        .put(new JSONObject()
                                .put("id", "ValueAxis-2")
                            )
                    )
                .put("titles", new JSONArray()
                        .put(new JSONObject()
                                .put("id", "Title-1")
                                .put("size", 15)
                                .put("text", "Mi posición Actual es: $" + this.total)
                            )
                    )
                .put("dataProvider", new JSONArray()
                        .put(new JSONObject()
                                .put("category", "")
                                .put("column-1", this.income)
                                .put("column-2", this.expenses)
                            )
                    )
                .toString();

        return jsonString;
    }

    private float incomeValue() {
        //TODO get it from database
        return 32000;
    }

    private float expensesValue() {
        //TODO get it from database
        return 8000;
    }
}
