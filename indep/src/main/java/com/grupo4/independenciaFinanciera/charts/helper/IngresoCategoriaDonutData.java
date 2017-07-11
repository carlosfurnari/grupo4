package com.grupo4.independenciaFinanciera.charts.helper;

import com.grupo4.independenciaFinanciera.dto.IngresoCategorizadoDTO;
import com.grupo4.independenciaFinanciera.model.Ingreso;
import com.grupo4.independenciaFinanciera.utils.MockLoader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;


public class IngresoCategoriaDonutData implements DataAdder {
    private String username;

    public IngresoCategoriaDonutData(String username){
        super();
        this.username = username;
    }
    @Override
    public JSONObject addData(JSONObject json) {
        addIncomeColors(json);

        JSONArray datos = new JSONArray();
        for (IngresoCategorizadoDTO dato : getIngresoByCategoria(username) ) {
            datos.put(new JSONObject()
                    .put("category", dato.getCategoria())
                    .put("money", dato.getMonto())
            );
        }

        json.put("dataProvider", datos);

        return json;
    }

    private void addIncomeColors(JSONObject json) {
        JSONArray colors = new JSONArray();
        colors.put("#009933");
        colors.put("#00cc99");
        colors.put("#00ccff");
        colors.put("#3366ff");
        colors.put("#66ccff");
        colors.put("#0000cc");
        colors.put("#ccff33");

        json.put("colors", colors);
    }

    private List<IngresoCategorizadoDTO> getIngresoByCategoria(String username) {
        Map<String, Map<String, Ingreso>> data = MockLoader.getInstance().getIngresoMocks();
        Map<String, Ingreso> ingreso = data.get(username);
        Map<String, IngresoCategorizadoDTO> map = new HashMap<>();
        for (Ingreso g : ingreso.values()){
            IngresoCategorizadoDTO dto = map.get(g.getCategoria().getNombre());
            if (dto == null){
                dto = new IngresoCategorizadoDTO();
                dto.setCategoria(g.getCategoria().getNombre());
                dto.setMonto(0);
                map.put(dto.getCategoria(), dto);
            }
            dto.setMonto(dto.getMonto() + Integer.parseInt(g.getMonto()));

        }
        List<IngresoCategorizadoDTO> result = new ArrayList<IngresoCategorizadoDTO>(map.values());
        return result;

    }
}
