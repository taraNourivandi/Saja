package com.sbu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbu.dao.impl.ManagerDAOImpl;
import com.sbu.dao.model.Modir;


@Service
public class ManagerManagerImpl /*implements ProfManager*/ {

    public ManagerManagerImpl() {}

    @Autowired
    public ManagerDAOImpl managerDAOImpl;
    
    //@Override
    public Modir findProf(int id)
    {
        return managerDAOImpl.findUser(id);        
    }
    
}
