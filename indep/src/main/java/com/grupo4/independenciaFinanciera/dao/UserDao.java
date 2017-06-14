package com.grupo4.independenciaFinanciera.dao;

import com.grupo4.independenciaFinanciera.config.Config;
import com.grupo4.independenciaFinanciera.model.User;
import com.grupo4.independenciaFinanciera.utils.MockLoader;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by rumm on 13/06/17.
 */

@Component
@Scope("singleton")
public class UserDao {

    private Map<String, User> userMap;

    public UserDao(){
        super();
        if (Config.USE_MOCKS){
            this.userMap = MockLoader.getInstance().getUserMocks();
        }else{

            this.userMap = new HashMap<String, User>();
        }
    }

    public User getUserByUsername(String id){
        return this.userMap.get(id.toLowerCase());
    }

    public void addUser(User user){
        this.userMap.put(user.getUsername().toLowerCase(), user);

    }

    public void deleteUser(String username){
        this.userMap.remove(username.toLowerCase());
    }

    public Set<User> getAllUsers(){
        return new HashSet<User>(userMap.values());
    }
}
