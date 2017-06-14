package com.grupo4.independenciaFinanciera.controller;

import com.grupo4.independenciaFinanciera.dao.UserDao;
import com.grupo4.independenciaFinanciera.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String login(@RequestBody User user, ModelMap model){
        if ("admin".equalsIgnoreCase(user.getUsername()) && "admin".equalsIgnoreCase(user.getPassword())){

            return "redirect:/tablero";
        }else{
            return "login";
        }
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String register(@RequestBody User user, ModelMap model){

        this.userDao.addUser(user);

        return "redirect:/tablero";

    }


}
