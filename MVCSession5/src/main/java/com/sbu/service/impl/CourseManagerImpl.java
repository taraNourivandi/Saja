package com.sbu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.sbu.dao.impl.UserDAOImpl;
import com.sbu.dao.impl.CourseDAOImpl;

//dao models
import com.sbu.dao.model.Course;
import com.sbu.dao.model.Major;
import com.sbu.dao.model.Term;
import java.util.Collection;
import java.util.LinkedList;


@Service
public class CourseManagerImpl /*implements UserManager*/ {
    
    public CourseManagerImpl() 
    {}

    @Autowired
    public CourseDAOImpl courseDAOImpl;

    //@Override
    @Transactional
    public void insertCourse(Course course)
    {
        courseDAOImpl.insertUser(course);              
    }

    //@Override
    public List<Course> findAlls()
    {
        return courseDAOImpl.findAllCourses();        
    } 
    
    public List<Term> findAllTerms()
    {
        return courseDAOImpl.findAllTerm();
    }
    
    public List<Major> findAllMajors()
    {
        return courseDAOImpl.findAllMajor();
    }
    
    public  List<String> findAllSection ()
    {
        List<String> sections = new LinkedList<String>();
        sections.add("کارشناسی");
        sections.add("کارشناسی ارشد");
        sections.add("دکترا");
        return sections;
    }
    
    public  List<String> findAllCourseType ()
    {
        List<String> courseType = new LinkedList<String>();
        courseType.add("اصلی");
        courseType.add("پایه");
        courseType.add("اختیاری");
        courseType.add("تخصصی");
        return courseType;
    }
    
    public  List<String> findAllCourseTypeLab ()
    {
        List<String> courseTypeLab = new LinkedList<String>();
        courseTypeLab.add("عملی");
        courseTypeLab.add("نظری");
        return courseTypeLab;
    }
    
    public List<String> findAllCourseGender()
    {
        List<String> courseGender = new LinkedList<String>();
        courseGender.add("زن");
        courseGender.add("مرد");
        courseGender.add("مختلط");
        return courseGender;
    }

    public void saveCourse(Integer ID, String name, int units,
            int preCourse,
            int courseTerm,
            int courseMager, 
            int coursesection,
            int labtheorytype,
            int coursetype, 
            int coursegender)
    {
        //check inputs
        Course course = new Course();
        /*
        course.setId(ID);
        course.setName(name);
        course.setUnits(units);
        course.setCoursegender(coursegender);
        course.setCoursesection(coursesection);
        course.setCoursetype(coursetype);
        course.setLabtheorytype(labtheorytype);
        

        Collection<Course> courseCollection = new LinkedList<>();
        courseCollection.add(courseDAOImpl.findCourse(preCourse));
        course.setCourseCollection(courseCollection);
        courseDAOImpl.insertcourse(course);
        
        */
        course.setId(8);
        course.setName("a");
        course.setUnits(3);
        course.setCoursegender(1);
        course.setCoursesection(1);
        course.setCoursetype(2);
        course.setLabtheorytype(2);
        courseDAOImpl.insertcourse(course);
    }
    
    public void updateCourse(Integer ID, int units,
            int preCourse,
            int courseTerm,
            int courseMager, 
            int coursesection,
            int labtheorytype,
            int coursetype, 
            int coursegender)
    {
        //check inputs
        Course course = new Course();
        /*
        course.setId(ID);
        course.setName(name);
        course.setUnits(units);
        course.setCoursegender(coursegender);
        course.setCoursesection(coursesection);
        course.setCoursetype(coursetype);
        course.setLabtheorytype(labtheorytype);
        

        Collection<Course> courseCollection = new LinkedList<>();
        courseCollection.add(courseDAOImpl.findCourse(preCourse));
        course.setCourseCollection(courseCollection);
        courseDAOImpl.insertcourse(course);
        
        */
        course.setId(8);
        course.setName("a");
        course.setUnits(3);
        course.setCoursegender(1);
        course.setCoursesection(1);
        course.setCoursetype(2);
        course.setLabtheorytype(2);
        courseDAOImpl.insertcourse(course);
    }
/*
    public void updateCourse(Integer ID, int units, int preCourse, int courseTerm, int courseMager, int coursesection, int labtheorytype, int coursetype, int coursegender) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  */  
}