package com.sbu.dao.impl;

import com.sbu.dao.model.Modir;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;



@Repository
public class ManagerDAOImpl /*implements ProfDAO*/ {

    public ManagerDAOImpl() {}    
    
    @PersistenceContext
    public EntityManager entityManager;
    
    /*
    search in prof table by primary key and 
    retunr the prof entity if found otherwise return null
    */
    public Modir findUser(int id)
    {
        return entityManager.find(Modir.class, id);
    }
}

