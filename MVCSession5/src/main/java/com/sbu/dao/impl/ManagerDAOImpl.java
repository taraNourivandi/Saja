package com.sbu.dao.impl;

import com.sbu.dao.model.Modir;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


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
	
    @Transactional
    public boolean updateEmail(int id, String email)
    {
        System.out.println("in the update Email method in ProfDAOImpl");
        Query query = entityManager.createNamedQuery("Modir.updateEmail");
        query.setParameter("email", email);        
        query.setParameter("id", id);
        System.out.println(query.toString());
        try
        {
            Object obj = query.executeUpdate();
            System.out.println("update email succesfully");
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("error in update the email /profDAOImpl");
            System.out.println("update email UNNNNNNNNNNNNNsuccesfully");
            return false;
        }
    }
}

