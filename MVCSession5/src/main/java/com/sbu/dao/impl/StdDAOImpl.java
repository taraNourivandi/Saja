package com.sbu.dao.impl;

import com.sbu.dao.model.Stdtable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;

@Repository
public class StdDAOImpl /*implements ProfDAO*/ {

    public StdDAOImpl() {}    
    
    @PersistenceContext
    public EntityManager entityManager;
    
    /*
    search in prof table by primary key and 
    retunr the prof entity if found otherwise return null
    */
    public Stdtable findUser(int id)
    {
        return entityManager.find(Stdtable.class, id);
    }
}

