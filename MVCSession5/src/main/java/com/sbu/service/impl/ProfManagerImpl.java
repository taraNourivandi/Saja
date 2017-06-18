package com.sbu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbu.dao.impl.ProfDAOImpl;
import com.sbu.dao.impl.UserDAOImpl;
import com.sbu.dao.model.Prof;
import javax.transaction.Transactional;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ProfManagerImpl /*implements ProfManager*/ {

    public ProfManagerImpl() {}

    @Autowired
    public ProfDAOImpl profDAOImpl;
    
    @Autowired
    public UserDAOImpl userDAOImpl;
    
    //@Override
    public Prof findProf(int id)
    {
        return profDAOImpl.findUser(id);        
    }
    public String findProfEmail(int id)
    {
        return profDAOImpl.findEmail(id);
    }
    ////Tara
    public List<Prof> findAll()
    {
        return profDAOImpl.findAllProfs();
    }
    
    @Transactional
    public boolean updateEmail(int id ,String email ,String username ,String pass ,String repeatPass)
    {
        System.out.println("in the update Email method in ProfManagerImpl");
        boolean updateEmail = profDAOImpl.updateEmail(id ,email );
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
