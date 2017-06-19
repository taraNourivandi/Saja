package com.sbu.dao.impl;

import com.sbu.controller.model.Student;
import com.sbu.dao.model.Stdgrade;
import com.sbu.dao.model.Stdtable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StdDAOImpl /*implements ProfDAO*/ {

    public StdDAOImpl() {}    
    
    @PersistenceContext
    public EntityManager entityManager;
    public Stdtable std;
    
    /*
    search in prof table by primary key and 
    retunr the prof entity if found otherwise return null
    */
    public Stdtable findUser(int id)
    {
        return entityManager.find(Stdtable.class, id);
    }
@Transactional
    public boolean updateEmail(int id, String email)
    {
        System.out.println("in the update Email method in ProfDAOImpl");
        Query query = entityManager.createNamedQuery("prof.updateEmail");
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
/////Tara
    public List<Stdgrade> findGradeCourses(Stdtable student){
        List<Stdgrade> list= (List<Stdgrade>) student.getStdgradeCollection();
        return list;

    }
}


