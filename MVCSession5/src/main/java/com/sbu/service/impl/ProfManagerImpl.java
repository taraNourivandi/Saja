package com.sbu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbu.dao.impl.ProfDAOImpl;
import com.sbu.dao.model.Prof;
import java.util.List;

@Service
public class ProfManagerImpl /*implements ProfManager*/ {

    public ProfManagerImpl() {}

    @Autowired
    public ProfDAOImpl profDAOImpl;
    
    //@Override
    public Prof findProf(int id)
    {
        return profDAOImpl.findUser(id);        
    }
    
    public List<Prof> findAllProf()
    {
        return profDAOImpl.findAllProf();        
    }
    
}
