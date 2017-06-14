package com.grupo4.independenciaFinanciera.charts;

import com.grupo4.independenciaFinanciera.charts.helper.DataAdder;
import com.grupo4.independenciaFinanciera.dto.DonutDataDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class DonutChart implements ChartData {

    private DataAdder dataAdder;

    public DonutChart(DataAdder dataAdder) {
        this.dataAdder = dataAdder;
    }

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

        return dataAdder.addData(json).toString();
    }
}
