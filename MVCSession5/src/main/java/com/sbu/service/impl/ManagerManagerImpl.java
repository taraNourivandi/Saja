package com.sbu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbu.dao.impl.ManagerDAOImpl;
import com.sbu.dao.impl.UserDAOImpl;
import com.sbu.dao.model.Modir;
import javax.transaction.Transactional;

@Service
public class ManagerManagerImpl /*implements ProfManager*/ {

    public ManagerManagerImpl() {}

    @Autowired
    public ManagerDAOImpl managerDAOImpl;
    
    @Autowired
    public UserDAOImpl userDAOImpl;
    
    //@Override
    public Modir findManager(int id)
    {
        return managerDAOImpl.findUser(id);        
    }
    @Transactional
    public boolean updateEmail(int id ,String email ,String username ,String pass ,String repeatPass)
    {
        System.out.println("in the update Email method in ProfManagerImpl");
        boolean updateEmail = managerDAOImpl.updateEmail(id ,email );
        System.out.println(updateEmail);
        System.out.println(pass +"------"+ repeatPass);
        if ( !pass.equals(repeatPass) )
            return false;
        boolean updatePass = userDAOImpl.updatePass(username, pass);
        System.out.println(updatePass);
        
        if (updatePass & updateEmail)
            return true;
        else
            return false;               
    }
  
}
