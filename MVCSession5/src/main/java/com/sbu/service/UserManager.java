package com.sbu.service;

import java.util.List;

import com.sbu.dao.model.User;

public interface UserManager {

	void insertUser(User user);

	List<User> findAllUsers();
        
        /*this function use for login 
        give usernaame and pass 
        if there is existing the same user then return it's id
        otherwise retrn -1
        input correction have to be checked
        */
        int findLoginUser(String userName, String pass);
}
