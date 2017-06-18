package com.sbu.dao.impl;

import com.sbu.dao.model.Courseprofterm;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Tara on 5/29/2017.
 */
@Repository
public class CourseProfTermDAOImpl {
    public CourseProfTermDAOImpl() {
    }

    @PersistenceContext
    public EntityManager entityManager;

    @Transactional
    public void insertCPT(Courseprofterm cpt){
        entityManager.persist(cpt);
    }
}
