package com.sbu.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sbu.dao.model.Course;
import com.sbu.dao.model.Department;
import com.sbu.dao.model.Employee;
import com.sbu.dao.model.Major;
import com.sbu.dao.model.Stdgrade;
import com.sbu.dao.model.Term;
import com.sbu.dao.model.User;

@Repository
public class CourseGradeDAOImpl /*implements UserDAO*/ {

    public CourseGradeDAOImpl() {
    }

    
    
    @PersistenceContext
    public EntityManager entityManager;

    //@Override
    @Transactional
    public void insertStdGrade (Stdgrade stdgrade) {
        //entityManager.getTransaction().begin();
        entityManager.persist(stdgrade);
        //entityManager.getTransaction().commit();
    }
    
    public List<Stdgrade> findStdGradeByTermId (int id)
    {
        Query query = entityManager.createNamedQuery("Stdgrade.findByTerm");
        return (List<Stdgrade>)query.setParameter("termId", id).getResultList(); 
    }

    
    
}

