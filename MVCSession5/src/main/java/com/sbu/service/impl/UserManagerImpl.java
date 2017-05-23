package com.sbu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbu.dao.impl.UserDAOImpl;
import com.sbu.dao.model.User;
import java.util.ArrayList;

@Service
public class UserManagerImpl /*implements UserManager*/ {

    private ArrayList<ArrayList<String>> rolesAccess = new ArrayList<>();    
    /*
    1 student  ->0
    2 teacher  ->1
    3 modir    ->2 
    */
    
    public UserManagerImpl() 
    {
        rolesAccess = new ArrayList<>(); 
        //student
        ArrayList<String> list = new ArrayList<String>();
        list.add("مشاهده نمرات");
        list.add("انتخاب واحد");
        list.add("تغییر مشخصات");
        rolesAccess.add(list);
        //teacher
        list = new ArrayList<String>();
        list.add("مشاهده دروس");
        list.add("ثبت نمره");
        list.add("تغییر مشخصات");
        rolesAccess.add(list);
        //modir
        list = new ArrayList<String>();
        list.add("تعریف/تغییر درس");
        list.add("تعریف/تغییر ترم");
        list.add("مشاهده دروس ارائه شده در هر ترم");
        list.add("تغییر مشخصات");
        rolesAccess.add(list);       
    }

    @Autowired
    public UserDAOImpl userDAOImpl;

    //@Override
    @Transactional
    public void insertUser(User user) {
        userDAOImpl.insertUser(user);
    }

    //@Override
    public List<User> findAllUsers() {
        return userDAOImpl.findAllUsers();
    }
    
    public User findLoginUser(String userName, String pass)
    {
        //server side checked
        if((userName == null) || (pass == null) || (userName.equals("")) || (pass.equals("")))
            return null;
        //call model function for finding user 
        User user = userDAOImpl.findUser(userName);
        if (user == null)
            return null;
        if(user.getPass().equals(pass))
            return user;
     else 
            return null;       
    } 
    public ArrayList<String> getRoleList (int role)
    {
        if(role<1 || role>3)
            return null;
        return rolesAccess.get(role-1);       
    }
}
