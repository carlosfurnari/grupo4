package com.grupo4.independenciaFinanciera.charts.helper;

import com.grupo4.independenciaFinanciera.dto.IngresoCategorizadoDTO;
import com.grupo4.independenciaFinanciera.dto.InversionCategorizadoDTO;
import com.grupo4.independenciaFinanciera.model.Ingreso;
import com.grupo4.independenciaFinanciera.model.Inversion;
import com.grupo4.independenciaFinanciera.utils.MockLoader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InversionesCategoriaDonutData implements DataAdder {
    private String username;

    public InversionesCategoriaDonutData(String username){
        this.username = username;
    }

    @Override
    public JSONObject addData(JSONObject json) {


        JSONArray datos = new JSONArray();
        for (InversionCategorizadoDTO dato : getInversionByCategoria(username) ) {
            datos.put(new JSONObject()
                    .put("category", dato.getCategoria())
                    .put("money", dato.getMonto())
            );
        }

        json.put("dataProvider", datos);

        return json;
    }


    private List<InversionCategorizadoDTO> getInversionByCategoria(String username) {
        Map<String, Map<String, Inversion>> data = MockLoader.getInstance().getInversionMocks();
        Map<String, Inversion> inversion = data.get(username);
        Map<String, InversionCategorizadoDTO> map = new HashMap<>();
        for (Inversion g : inversion.values()){
            InversionCategorizadoDTO dto = map.get(g.getCategoria().getNombre());
            if (dto == null){
                dto = new InversionCategorizadoDTO();
                dto.setCategoria(g.getCategoria().getNombre());
                dto.setMonto(0);
                map.put(dto.getCategoria(), dto);
            }
            dto.setMonto(dto.getMonto() + Integer.parseInt(g.getMonto()));

        }

        List<InversionCategorizadoDTO> result = new ArrayList<>(map.values());
        return result;
    }
}
