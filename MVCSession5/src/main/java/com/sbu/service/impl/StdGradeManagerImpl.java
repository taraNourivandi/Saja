package com.sbu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.sbu.dao.impl.UserDAOImpl;
import com.sbu.dao.impl.CourseGradeDAOImpl;

//dao models
import com.sbu.dao.model.Stdgrade;
import com.sbu.dao.model.Major;
import com.sbu.dao.model.Term;
import com.sbu.dao.model.Courseprofterm;

import java.util.Collection;
import java.util.LinkedList;

//fatemeh
@Service
public class StdGradeManagerImpl /*implements UserManager*/
{
    
    public StdGradeManagerImpl() 
    {}

    @Autowired
    public CourseGradeDAOImpl courseGradeDAOImpl;
    
   @Transactional
    public void insertStdGrade(Stdgrade stdgrade)
    {
        courseGradeDAOImpl.insertStdGrade(stdgrade);              
    }
    
}