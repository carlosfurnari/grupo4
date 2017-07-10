package com.grupo4.independenciaFinanciera.dao;

import com.grupo4.independenciaFinanciera.config.Config;
import com.grupo4.independenciaFinanciera.model.Categoria;
import com.grupo4.independenciaFinanciera.model.Gasto;
import com.grupo4.independenciaFinanciera.utils.MockLoader;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rumm on 13/06/17.
 */

@Component
public class CategoriaDao {

    private Map<String, Map<String, Categoria>> categoriaMap;


    public CategoriaDao(){
        super();
        if (Config.USE_MOCKS){
            this.categoriaMap = MockLoader.getInstance().getCategoriaMocks();
        }else {
            this.categoriaMap = new HashMap<String, Map<String, Categoria>>();
        }


    }

    public Categoria getCategoriaByUserAndCategoriaId(String username, String categoriaId){
        Map<String, Categoria> innerMap = this.categoriaMap.get(username);

        if (innerMap != null){
            return innerMap.get(categoriaId);
        }

        return null;
    }

    public void addCategoriaByUser(String username, Categoria categoria){

        Map<String, Categoria> innerMap = this.categoriaMap.get(username);

        if (innerMap == null){
            innerMap = new HashMap<String, Categoria>();
        }
        categoria.setId(String.valueOf(innerMap.values().size()));
        innerMap.put(categoria.getId(), categoria);


    }

    public void deleteCategoria(String username, String categoriaId){
        Map<String, Categoria> innerMap = this.categoriaMap.get(username);

        if (innerMap != null){
            innerMap.remove(categoriaId);
        }
    }

    public void updateCategoria(String username, Categoria categoria){
        Map<String, Categoria> innerMap = this.categoriaMap.get(username);

        if (innerMap != null){
            innerMap.put(categoria.getId(), categoria);
        }
    }

    public Map<String, Categoria> getAllCategoriasForUser(String username){
        Map<String, Categoria> innerMap = this.categoriaMap.get(username);

        return innerMap;
    }
}
