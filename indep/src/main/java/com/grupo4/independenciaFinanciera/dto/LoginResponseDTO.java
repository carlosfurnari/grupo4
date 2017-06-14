package com.grupo4.independenciaFinanciera.dto;

import com.grupo4.independenciaFinanciera.model.User;

/**
 * Created by rumm on 14/06/17.
 */
public class LoginResponseDTO {

    private String errorMessage;
    private User user;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
