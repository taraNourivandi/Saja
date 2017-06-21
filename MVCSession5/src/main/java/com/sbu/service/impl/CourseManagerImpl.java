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
import com.sbu.dao.model.User;
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
        courseDAOImpl.insertCouse(course);              
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
        //courseTypeLab.add("amali");
        //courseTypeLab.add("nazari");
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
        Course course = new Course(name ,units , labtheorytype, coursetype, coursegender,coursesection , preCourse);
        // Course(String name, int units, int labtheorytype, int coursetype, int coursegender, int coursesection, int preCourseID) {
        Major major = courseDAOImpl.findMajor(courseMager);
        course.setMajor(major);
        Term term = courseDAOImpl.findTerm(courseTerm);
        course.setTerm(term);
        
        courseDAOImpl.insertcourse(course);
        
    }
    
    public boolean checkCourseInputs(Integer ID, String name, int units,
            int preCourse,
            int courseTerm,
            int courseMager, 
            int coursesection,
            int labtheorytype,
            int coursetype, 
            int coursegender)
    {      
       if((ID==null) || (name==null) || (name.equals("")) || (units<1) || (units>10) || (preCourse<-1)
               || (courseTerm < 1) || (courseMager < 1))
           return false;
       if( (labtheorytype>2) || (labtheorytype<1) || (coursegender<1) || (coursegender>3)
               || (coursesection<1) || (coursesection>3) )
           return false;
       return true;       
    }
    
    public boolean checkCourseUpdateInputs(Integer ID, int units,
            int preCourse,
            int courseTerm,
            int courseMager, 
            int coursesection,
            int labtheorytype,
            int coursetype, 
            int coursegender)
    {      
       if((ID==null) || (units<1) || (units>10) || (preCourse<-1)
               || (courseTerm < 1) || (courseMager < 1))
           return false;
       if( (labtheorytype>2) || (labtheorytype<1) || (coursegender<1) || (coursegender>3)
               || (coursesection<1) || (coursesection>3) )
           return false;
       return true;       
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
        Course course = courseDAOImpl.findCourse(ID);
        System.out.println(" edited course found : " + course.getName());
        //course.setId(ID);
        //course.setName(name);
        course.setUnits(units);
        course.setCoursegender(coursegender);
        course.setCoursesection(coursesection);
        course.setCoursetype(coursetype);
        course.setLabtheorytype(labtheorytype);
        

        Major major = courseDAOImpl.findMajor(courseMager);
        course.setMajor(major);
        Term term = courseDAOImpl.findTerm(courseTerm);
        course.setTerm(term);
        
        courseDAOImpl.updatecourse(course);
        
        
        /*
        course.setId(8);
        course.setName("a");
        course.setUnits(3);
        course.setCoursegender(1);
        course.setCoursesection(1);
        course.setCoursetype(2);
        course.setLabtheorytype(2);
        courseDAOImpl.insertcourse(course);
        */
    }
/*
    public void updateCourse(Integer ID, int units, int preCourse, int courseTerm, int courseMager, int coursesection, int labtheorytype, int coursetype, int coursegender) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  */  
}