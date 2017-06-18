package com.sbu.controller.model;

import com.sbu.dao.model.Course;
import com.sbu.dao.model.Prof;
import com.sbu.dao.model.Term;

import java.util.Date;

/**
 * Created by Tara on 5/29/2017.
 */
public class CourseProfTermIn {
    private String dateTime;
    private Date examTime;
    private int capasity;
    private Course course;
    private Prof prof;
    private Term term;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    public int getCapasity() {
        return capasity;
    }

    public void setCapasity(int capasity) {
        this.capasity = capasity;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }
}
