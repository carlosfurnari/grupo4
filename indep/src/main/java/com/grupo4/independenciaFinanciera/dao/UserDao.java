package com.grupo4.independenciaFinanciera.dao;

import com.grupo4.independenciaFinanciera.model.User;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by rumm on 13/06/17.
 */

@Component
public class UserDao {

    private Map<String, User> userMap;

    public UserDao(){
        super();
        this.userMap = new HashMap<String, User>();
    }

    public User getUserByUsername(String id){
        return this.userMap.get(id);
    }

    public void addUser(User user){
        this.userMap.put(user.getUsername(), user);

    }

    public void deleteUser(String username){
        this.userMap.remove(username);
    }

    public Set<User> getAllUsers(){
        return new HashSet<User>(userMap.values());
    }
}
