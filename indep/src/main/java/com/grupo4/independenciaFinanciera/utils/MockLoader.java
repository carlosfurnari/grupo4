package com.grupo4.independenciaFinanciera.utils;

/**
 * Created by rumm on 14/06/17.
 */
public class MockLoader {

    private static MockLoader instance = null;

    public static MockLoader getInstance(){
        if(instance == null){
            instance = new MockLoader();
        }
        return  instance;
    }

    private MockLoader(){
        super();
    }

    
}
