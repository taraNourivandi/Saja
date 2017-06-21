package com.sbu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.sbu.dao.impl.UserDAOImpl;
import com.sbu.dao.impl.CourseGradeDAOImpl;
import com.sbu.dao.impl.CourseProfTermDAOImpl;

//dao models
import com.sbu.dao.model.Stdgrade;
import com.sbu.dao.model.Major;
import com.sbu.dao.model.Term;
import com.sbu.dao.model.Courseprofterm;
import com.sbu.dao.model.Stdtable;
import java.util.ArrayList;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import javassist.compiler.TokenId;

//fatemeh
@Service
public class StdGradeManagerImpl /*implements UserManager*/
{
    
    public StdGradeManagerImpl() 
    {}

    @Autowired
    public CourseGradeDAOImpl courseGradeDAOImpl;
    
     @Autowired
    public CourseProfTermDAOImpl courseProfTermDAOImp;   
    
    @Autowired
    public CourseProfTermManagerImpl courseProfTermManagerImpl;    
    
    @Autowired
    public StdManagerImpl stdManagerImpl;
            
   @Transactional
    public void insertStdGrade(Stdgrade stdgrade)
    {
        courseGradeDAOImpl.insertStdGrade(stdgrade);              
    }
    
    public int totalUnits = 142;
    private float A = 17;
    private float mashroot = 14;
    private int maxUnit = 24;
    private int minUnit = 14;
    private int normalUnit = 20;
    
    @Transactional
    public int insertCoursesForStdById(ArrayList<Integer> courses , int stdId )
    {
        /*
        1 : student nor found
        2 : course not found
        3 : more than total unit
        4 : not have precourse
        5 : more than max Unit in cuttent term
        6 : more than max of all unit
        
        
        */
        
        int currentTermId = courseProfTermDAOImp.findCurrentTerm().getId();
        
        Stdtable student = stdManagerImpl.findStd(stdId);
        if(student == null)
            return 1;
        
         // mizan vahede mojaz dar term bar asase moadel
            
            int preTermId = courseProfTermDAOImp.findpreTerm().getId();
            List<Stdgrade> preTermStdGrade = courseGradeDAOImpl.findStdGradeByTermId(preTermId);
            int maxAvailableUnit = 0;
            //cal vag
                int numberOfCourseUnit=0;
                int sumOfMark = 0;
                for (Stdgrade stdgrade : preTermStdGrade) 
                {
                    int grade = stdgrade.getGrade();
                    if(grade == -1)
                        continue;
                    int unit = stdgrade.getCourseproftermid().getCourseid().getUnits();
                    numberOfCourseUnit += unit;
                    sumOfMark += grade*unit;                
                }
                float avg;
                if(numberOfCourseUnit != 0)
                    avg = sumOfMark/numberOfCourseUnit;
                avg = 0;
                
            if(avg > A)
            {
                maxAvailableUnit = maxUnit;                    
            }
            else if(avg < mashroot)
            {
                maxAvailableUnit = minUnit;
            }
            else
                maxAvailableUnit = normalUnit;
            //
        
        int allcoursesUnit = calAllUnits(courses, student);
        if (allcoursesUnit>totalUnits)
            return 6;
            
        int allRequestedUnits = calWantedUnits (courses ,student);        
        if(allRequestedUnits>maxAvailableUnit)
        {
            return 5;            
        }            
        
        
        for (int id : courses)
        {
            Courseprofterm courseToAdd = courseProfTermManagerImpl.findCourseproftermById(id);
            if(courseToAdd == null)
                return 2; 
            if (student.getPassedunit() + courseToAdd.getCourseid().getUnits() > 142)
                return 3;
            //check precourse
            
            int preCourseId = courseToAdd.getCourseid().getPreCourseID();
            student.getStdgradeCollection().iterator();
            Iterator <Stdgrade> stdIt = student.getStdgradeCollection().iterator();
            boolean havePreCourse = false;
            if(preCourseId == -1)
                havePreCourse = true;
            
           
            while (stdIt.hasNext()) 
            {
                Stdgrade s = stdIt.next();
                System.out.println("in while:  "+ s.getCourseproftermid().getCourseid().getId() + preCourseId);
                if ((s.getCourseproftermid().getCourseid().getId() == preCourseId)
                        && (s.getCourseproftermid().getTermid().getId() != currentTermId))                                   
                    havePreCourse = true;           
                              
            }            
            if(!havePreCourse)
                return 4;                   
        }
        
        for (int id : courses)
        {
            System.out.println("adding lesson");
            Courseprofterm courseToAdd = courseProfTermManagerImpl.findCourseproftermById(id);
            Stdgrade newCourse = new Stdgrade();
            newCourse.setCourseproftermid(courseToAdd);
            newCourse.setGrade(-1);
            newCourse.setGradestatus("اعلام نشده");
            newCourse.setStdid(student); 
            courseGradeDAOImpl.insertStdGrade(newCourse);
        }
        return 0;
    }
    
    
    private int calWantedUnits (ArrayList<Integer> courses , Stdtable student)
    {
        int allRequestedUnits = 0;
        int termId = courseProfTermDAOImp.findCurrentTerm().getId();
        for (int id : courses)
        {
            Courseprofterm courseToAdd = courseProfTermManagerImpl.findCourseproftermById(id);
            if(courseToAdd == null)
                return 2;
            allRequestedUnits += courseToAdd.getCourseid().getUnits();          
        }        
        Iterator <Stdgrade> stdIt = student.getStdgradeCollection().iterator();
        while (stdIt.hasNext())
        {
            Stdgrade stdgrade = stdIt.next();
            if(termId == stdgrade.getCourseproftermid().getTermid().getId())
                allRequestedUnits += stdgrade.getCourseproftermid().getCourseid().getUnits();            
        }
        return allRequestedUnits;        
    }
    
    private int calAllUnits (ArrayList<Integer> courses , Stdtable student)
    {
        int allRequestedUnits = 0;
        for (int id : courses)
        {
            Courseprofterm courseToAdd = courseProfTermManagerImpl.findCourseproftermById(id);
            if(courseToAdd == null)
                return 2;
            allRequestedUnits += courseToAdd.getCourseid().getUnits();          
        }        
        Iterator <Stdgrade> stdIt = student.getStdgradeCollection().iterator();
        while (stdIt.hasNext())
        {
            Stdgrade stdgrade = stdIt.next();
            allRequestedUnits += stdgrade.getCourseproftermid().getCourseid().getUnits();            
        }
        return allRequestedUnits;
        
    }
    
}