package com.sbu.controller.model;

import com.sbu.dao.model.Courseprofterm;
import com.sbu.dao.model.Prof;

import java.util.Date;

/**
 * Created by Tara on 5/29/2017.
 */
public class NewTermIn {
    private int termCode;
    private int courseInId;
//    private Prof prof;
    private int profId;
    private int capacity;
    private String hour;
    private String date;
    private Date examDate;
    private String examHour;
//    private CourseProfTermIn courseProfTermIn;


    public int getProfId() {
        return profId;
    }

    public void setProfId(int profId) {
        this.profId = profId;
    }

    public void setCourseInId(int courseInId) {
        this.courseInId = courseInId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public String getExamHour() {
        return examHour;
    }

    public void setExamHour(String examHour) {
        this.examHour = examHour;
    }

    public int getTermCode() {
        return termCode;
    }

    public void setTermCode(int termCode) {
        this.termCode = termCode;
    }

    public int getCourseInId() {
        return courseInId;
    }

    public void setCourseIn(int courseInId) {
        this.courseInId = courseInId;
    }
}
