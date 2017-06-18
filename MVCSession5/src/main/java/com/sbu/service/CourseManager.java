package com.sbu.service;

import java.util.List;

import com.sbu.dao.model.Course;
import com.sbu.dao.model.Term;
import com.sbu.dao.model.Major;

public interface CourseManager {

	void insertCourse(Course course);

	List<Course> findAlls();
        List<Term> findAllTerms();
        List<Major> findAllMajors();
        List<String> findAllSection ();
		List<String> findAllCourseType ();
		List<String> findAllCourseTypeLab ();
		List<String> findAllCourseGender();
		void saveCourse(Integer ID, String name, int units,
            int preCourse,
            int courseTerm,
            int courseMager, 
            int coursesection,
            int labtheorytype,
            int coursetype, 
            int coursegender);
		void updateCourse(Integer ID, int units,
            int preCourse,
            int courseTerm,
            int courseMager, 
            int coursesection,
            int labtheorytype,
            int coursetype, 
            int coursegender);	
        /*this function use for login 
        give usernaame and pass 
        if there is existing the same user then return it's id
        otherwise retrn -1
        input correction have to be checked
        */
        //int findLoginCourse(String userName, String pass);
}
