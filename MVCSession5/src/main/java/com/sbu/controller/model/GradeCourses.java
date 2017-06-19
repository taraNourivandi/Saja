package com.sbu.controller.model;

/**
 * Created by Tara on 6/19/2017.
 */
public class GradeCourses {
    int courseId;
    String courseName;
    String profName;
    int courseUnit;
    int grade;
    String  gradeStatus;
    int courseType;


    public GradeCourses(){}

    public GradeCourses(int courseId, String courseName, String profName, int courseUnit, int grade, String gradeStatus, int courseType) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.profName = profName;
        this.courseUnit = courseUnit;
        this.grade = grade;
        this.gradeStatus = gradeStatus;
        this.courseType = courseType;
    }

    public int getCourseId() {
        return 1;
//        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public int getCourseUnit() {
        return courseUnit;
    }

    public void setCourseUnit(int courseUnit) {
        this.courseUnit = courseUnit;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getGradeStatus() {
        return gradeStatus;
    }

    public void setGradeStatus(String gradeStatus) {
        this.gradeStatus = gradeStatus;
    }

    public int getCourseType() {
        return courseType;
    }

    public void setCourseType(int courseType) {
        this.courseType = courseType;
    }
}
