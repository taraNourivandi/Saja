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
import com.sbu.dao.model.Term;
import com.sbu.dao.model.User;

@Repository
public class CourseDAOImpl /*implements UserDAO*/ {

    public CourseDAOImpl() {
    }

    
    
    @PersistenceContext
    public EntityManager entityManager;

    //@Override
    @Transactional
    public void insertCouse(Course course) {
        //entityManager.getTransaction().begin();
        entityManager.persist(course);
        //entityManager.getTransaction().commit();
    }

    //@Override
    public List<Course> findAllCourses() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = builder.createQuery(Course.class);
        Root<Course> root = cq.from(Course.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }
    
    public List<Term> findAllTerm()
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Term> cq = builder.createQuery(Term.class);
        Root<Term> root = cq.from(Term.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();        
    }
    
    public Term findTerm(int id)
    {
        return entityManager.find(Term.class, id);
    }
    
    public List<Major> findAllMajor()
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Major> cq = builder.createQuery(Major.class);
        Root<Major> root = cq.from(Major.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();  
    }
    
    public Major findMajor(int id)
    {
        return entityManager.find(Major.class, id);
    }
    
    public Course findCourse(int course) {
        return entityManager.find(Course.class, course);
    }
    
    @Transactional
    public void insertcourse(Course course) {
        //entityManager.getTransaction().begin();
        entityManager.persist(course);
        //entityManager.getTransaction().commit();
    }   
    
    @Transactional
    public void inserEmp(Employee employee) {
        //entityManager.getTransaction().begin();
        entityManager.persist(employee);
        //entityManager.getTransaction().commit();
    }   
    public Department findDep(int depId) {
        return entityManager.find(Department.class, depId);//returns the department named vert
    }
    @Transactional
    public void updatecourse(Course course) {
        entityManager.merge(course);
    }
    
}

