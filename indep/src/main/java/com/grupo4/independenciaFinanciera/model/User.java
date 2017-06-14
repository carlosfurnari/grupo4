package com.grupo4.independenciaFinanciera.model;

/**
 * Created by rumm on 12/06/17.
 */
public class User {

    private String username;
    private String password;
    private String email;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.toLowerCase();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.toLowerCase();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }
}
