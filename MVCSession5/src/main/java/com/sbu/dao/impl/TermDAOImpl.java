package com.sbu.dao.impl;

import com.sbu.dao.model.Term;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Tara on 5/29/2017.
 */
@Repository
public class TermDAOImpl {
    public TermDAOImpl() {
    }

    @PersistenceContext
    public EntityManager entityManager;

    public Term findById(int id)
    {
        return entityManager.find(Term.class, id);
    }


}
