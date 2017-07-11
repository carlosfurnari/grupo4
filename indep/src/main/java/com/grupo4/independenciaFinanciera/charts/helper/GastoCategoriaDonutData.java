package com.grupo4.independenciaFinanciera.charts.helper;

import com.grupo4.independenciaFinanciera.dto.GastoCategorizadoDTO;
import com.grupo4.independenciaFinanciera.model.Gasto;
import com.grupo4.independenciaFinanciera.utils.MockLoader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class GastoCategoriaDonutData implements DataAdder {

    private String username;

    public GastoCategoriaDonutData(String username){
        super();
        this.username = username;
    }

    @Override
    public JSONObject addData(JSONObject json) {
        JSONArray datos = new JSONArray();
        for (GastoCategorizadoDTO dato : getGastoByCategoria(username) ) {
            datos.put(new JSONObject()
                    .put("category", dato.getCategoria())
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
            break;
        }

        return gastos;
    }

    private List<GastoCategorizadoDTO> getGastoByCategoria(String username) {
        Map<String, Map<String, Gasto>> data = MockLoader.getInstance().getGastoMocks();
        Map<String, Gasto> gasto = data.get(username);
        Map<String, GastoCategorizadoDTO> map = new HashMap<>();
        for (Gasto g : gasto.values()){
            GastoCategorizadoDTO dto = map.get(g.getCategoria().getNombre());
            if (dto == null){
                dto = new GastoCategorizadoDTO();
                dto.setCategoria(g.getCategoria().getNombre());
                dto.setMonto(0);
                map.put(dto.getCategoria(), dto);
            }
            dto.setMonto(dto.getMonto() + Integer.parseInt(g.getMonto()));

        }
        List<GastoCategorizadoDTO> result = new ArrayList<GastoCategorizadoDTO>(map.values());
        return result;

    }
}
