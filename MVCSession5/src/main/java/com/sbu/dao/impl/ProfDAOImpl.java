package com.sbu.dao.impl;

import com.sbu.dao.model.Prof;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.sbu.dao.model.User;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProfDAOImpl /*implements ProfDAO*/ {

    public ProfDAOImpl() {}    
    
    @PersistenceContext
    public EntityManager entityManager;
    
    /*
    search in prof table by primary key and 
    retunr the prof entity if found otherwise return null
    */
    public Prof findUser(int id)
    {
        return entityManager.find(Prof.class, id);
    }
    
    public List<Prof> findAllProf()
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Prof> cq = builder.createQuery(Prof.class);
        Root<Prof> root = cq.from(Prof.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();        
    }
}

