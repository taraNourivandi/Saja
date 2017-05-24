package com.sbu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbu.dao.impl.StdDAOImpl;
import com.sbu.dao.model.Stdtable;

@Service
public class StdManagerImpl /*implements ProfManager*/ {

    public StdManagerImpl() {}

    @Autowired
    public StdDAOImpl stdDAOImpl;
    
    //@Override
    public Stdtable findProf(int id)
    {
        return stdDAOImpl.findUser(id);        
    }
    
}
