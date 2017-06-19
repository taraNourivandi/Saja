package com.sbu.dao.impl;

import com.sbu.dao.model.Stdgrade;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Tara on 6/19/2017.
 */

@Repository
public class StdgradeDAOImpl {

    public StdgradeDAOImpl() {
    }
    @PersistenceContext
    public EntityManager entityManager;


//    public List<Stdgrade> findGradeCourses(int stdId){
//
//        List<Stdgrade> list =  ;
//        return list;
//    }
}
