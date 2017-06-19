package com.sbu.dao.impl;

import com.sbu.dao.model.Term;
import com.sbu.dao.model.Courseprofterm;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.sbu.dao.model.User;
import java.util.ArrayList;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CourseProfTermDAOImpl /*implements UserDAO*/ {

    public CourseProfTermDAOImpl() {
    }

    
    
    @PersistenceContext
    public EntityManager entityManager;

    
    //@Override
    public List<Courseprofterm> findEntitiesByTerm(Term term) 
    {
        //int termId = term.getId();
        //System.out.println("termid : "+termId);
        Query query = entityManager.createNamedQuery("Courseprofterm.findByTerm"); 
        System.out.println("find query");
        query.setParameter("termid",term);
        System.out.println("findEntityByTerm");
        try
        {
            List<Object> obj = query.getResultList();
            List<Courseprofterm> cpt = new ArrayList<Courseprofterm>();
            for (Object o : obj)
            {
                cpt.add((Courseprofterm) o);
            }
            return cpt;
        }
        catch(Exception e)
        {
            return null;            
        }        
    }
    
    public Term findCurrentTerm()
    {
        Query query = entityManager.createNamedQuery("Term.findCurrentTerm");
        return (Term) query.setMaxResults(1).getSingleResult();    
    }
    
    public Courseprofterm findCourseprofterm (int id)
    {
        return entityManager.find(Courseprofterm.class, id);
    }

}

