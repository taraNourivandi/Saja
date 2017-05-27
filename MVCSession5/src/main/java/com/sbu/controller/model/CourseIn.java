/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.controller.model;

/**
 *
 * @author Tara
 */
public class CourseIn {

    private Integer ID;
    private String name;
    private int units;    
    private int preCourse;
    private int courseTerm;
    private int courseMager;
    private int coursesection;
    private String labtheorytype;
    private String coursetype;
    private String coursegender;
    

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public int getLabtheorytype() 
    {        
        if (labtheorytype.equals("عملی"))
            return 1;
        else if (labtheorytype.equals("نظری"))
            return 2;
        else
            return -1;
    }

    public void setLabtheorytype(String labtheorytype) {
        this.labtheorytype = labtheorytype;
    }

    public int getCoursetype()
    {
        if (coursetype.equals("اصلی"))
            return 1;
        else if (coursetype.equals("پایه"))
            return 2;
        else if (coursetype.equals("اختیاری"))
            return 3;
        else if (coursetype.equals("تخصصی"))
            return 4;
        else
            return -1;
    }

    public void setCoursetype(String coursetype) {
        this.coursetype = coursetype;
    }   
    
    public int getCoursegender() {
        if (coursegender.equals("زن"))
            return 1;
        else if (coursegender.equals("مرد"))
            return 2;
        else if (coursegender.equals("مختلط"))
            return 3;
        else
            return -1;
    }

    public void setCoursegender(String coursegender) {
        this.coursegender = coursegender;
    }
    
    

    public int getCoursesection() {
        return coursesection;
    }

    public void setCoursesection(int coursesection) {
        this.coursesection = coursesection;
    }

    public int getCourseMager() {
        return courseMager;
    }

    public void setCourseMager(int courseMager) {
        this.courseMager = courseMager;
    }

    public int getCourseTerm() {
        return courseTerm;
    }

    public void setCourseTerm(int courseTerm) {
        this.courseTerm = courseTerm;
    }

    public int getPreCourse() {
        return preCourse;
    }

    public void setPreCourse(int preCourse) {
        this.preCourse = preCourse;
    }
}
