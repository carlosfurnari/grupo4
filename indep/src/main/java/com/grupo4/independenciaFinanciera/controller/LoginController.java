package com.grupo4.independenciaFinanciera.controller;

import com.grupo4.independenciaFinanciera.dao.UserDao;
import com.grupo4.independenciaFinanciera.dto.LoginResponseDTO;
import com.grupo4.independenciaFinanciera.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rumm on 12/06/17.
 */

@Controller
public class LoginController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = {"/loginPage"}, method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){

        return "login";

    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    @ResponseBody
    public LoginResponseDTO login(@RequestBody User user, HttpServletResponse response){

        User realUser = this.userDao.getUserByUsername(user.getUsername());
        LoginResponseDTO responseDTO = new LoginResponseDTO();

        if (realUser == null){
            response.setStatus(403);
            responseDTO.setErrorMessage("Usuario inexistente");
            return responseDTO;
        }


        if (realUser.getUsername().equalsIgnoreCase(user.getUsername()) && realUser.getPassword().equalsIgnoreCase(user.getPassword())){
            response.setStatus(200);
            responseDTO.setUser(realUser);
            return responseDTO;

        }
        responseDTO.setErrorMessage("Usuario o contraseña erronea.");
        response.setStatus(403);
        return responseDTO;
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    @ResponseBody
    public LoginResponseDTO register(@RequestBody User user, ModelMap model, HttpServletResponse response){
        User existentUser = this.userDao.getUserByUsername(user.getUsername());
        LoginResponseDTO responseDTO = new LoginResponseDTO();

        if (existentUser != null){
            response.setStatus(400);
            responseDTO.setErrorMessage("Usuario existente");
            return responseDTO;
        }

        responseDTO.setUser(user);
        response.setStatus(200);
        this.userDao.addUser(user);
        return responseDTO;

    }


}
