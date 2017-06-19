package com.sbu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.sbu.dao.impl.UserDAOImpl;
import com.sbu.dao.impl.CourseProfTermDAOImpl;

//dao models
import com.sbu.dao.model.Course;
import com.sbu.dao.model.Major;
import com.sbu.dao.model.Term;
import com.sbu.dao.model.Courseprofterm;
import java.util.Collection;
import java.util.LinkedList;

//fatemeh
@Service
public class CourseProfTermManagerImpl /*implements UserManager*/
{
    
    public CourseProfTermManagerImpl() 
    {}

    @Autowired
    public CourseProfTermDAOImpl courseProfTermDAOImpl;
    
    public List<Courseprofterm> findCourseProfTermByTerm (Term term)
    {
        return courseProfTermDAOImpl.findEntitiesByTerm(term);
        
    }
    
    public Term findCurrentTerm()
    {
        return courseProfTermDAOImpl.findCurrentTerm();
    }
    
    public Courseprofterm findCourseproftermById (int id)
    {
        return courseProfTermDAOImpl.findCourseprofterm(id);
    }
    
    
}