package com.sbu.service.impl;

import com.sbu.controller.model.CourseIn;
import com.sbu.dao.impl.CourseDAOImpl;
import com.sbu.dao.impl.CourseProfTermDAOImpl;
import com.sbu.dao.impl.ProfDAOImpl;
import com.sbu.dao.model.Course;
import com.sbu.dao.model.Courseprofterm;
import com.sbu.dao.model.Prof;
import com.sbu.dao.model.Term;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Tara on 5/29/2017.
 */
@Service
public class CourseProfTermManagerImpl {
    public CourseProfTermManagerImpl() {
    }
    @Autowired
    public CourseProfTermDAOImpl courseProfTermDAOImpl;
    @Autowired
    public CourseDAOImpl courseDAOImpl;
    @Autowired
    public ProfDAOImpl profDAOImpl;

//    public CourseProfTermManagerImpl() {
//    }
    @Transactional
    public void saveCPT(int capacity, String date, String exam, int courseId, int profId, int termId)
    {
        Term term = courseDAOImpl.findTerm(termId);
        Prof prof = profDAOImpl.findUser(profId);

        Course course = courseDAOImpl.findById(courseId);
        System.out.println(course.toString());
        Courseprofterm cpt=new Courseprofterm(date, exam, capacity, course, prof, term);

        courseProfTermDAOImpl.insertCPT(cpt);

    }
}
