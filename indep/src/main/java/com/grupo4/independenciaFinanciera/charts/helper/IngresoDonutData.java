package com.grupo4.independenciaFinanciera.charts.helper;

import com.grupo4.independenciaFinanciera.dto.DonutDataDTO;
import com.grupo4.independenciaFinanciera.dto.GastoCategorizadoDTO;
import com.grupo4.independenciaFinanciera.dto.IngresoCategorizadoDTO;
import com.grupo4.independenciaFinanciera.model.Gasto;
import com.grupo4.independenciaFinanciera.model.Ingreso;
import com.grupo4.independenciaFinanciera.utils.MockLoader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class IngresoDonutData implements DataAdder {
    /*@Override
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
    }*/

    private String username;

    public IngresoDonutData(String username){
        super();
        this.username = username;
    }
    @Override
    public JSONObject addData(JSONObject json) {
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
