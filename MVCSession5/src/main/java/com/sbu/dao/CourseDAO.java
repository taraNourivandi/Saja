package com.sbu.dao;

import java.util.List;

import com.sbu.dao.model.Course;
import com.sbu.dao.model.Term;
import com.sbu.dao.model.Major;


import org.springframework.stereotype.Repository;

@Repository
public interface CourseDAO 
{
	void insertUser(Course course);
	List<Course> findAllCourses();  
        List<Term> findAllTerm();
        List<Major> findAllMajor();
        void insertcourse(Course course);
        
}
