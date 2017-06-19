package com.sbu.controller.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tara on 6/19/2017.
 */
public class TermGrade {
    public ArrayList<GradeCourses> gradeCourses;
    public float avg;
    public int passedUnits;
    public int failedUnits;
    public int totalUnits;
    public int termCode;

    public int getTermCode() {
        return termCode;
    }

    public void setTermCode(int termCode) {
        this.termCode = termCode;
    }

    public TermGrade() {
    }

    public ArrayList<GradeCourses> getGradeCourses() {
        return gradeCourses;
    }

    public void setGradeCourses(ArrayList<GradeCourses> gradeCourses) {
        this.gradeCourses = gradeCourses;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public int getPassedUnits() {
        return passedUnits;
    }

    public void setPassedUnits(int passedUnits) {
        this.passedUnits = passedUnits;
    }

    public int getFailedUnits() {
        return failedUnits;
    }

    public void setFailedUnits(int failedUnits) {
        this.failedUnits = failedUnits;
    }

    public int getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits() {
        this.totalUnits = this.passedUnits+this.failedUnits;
    }
}
