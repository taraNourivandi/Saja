package com.sbu.service.impl;

import com.sbu.dao.impl.StdgradeDAOImpl;
import com.sbu.dao.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tara on 6/19/2017.
 */

@Service
public class StdgradesManagerImpl {
    @Autowired
    public StdgradeDAOImpl stdgradeDAO;

    public StdgradesManagerImpl() {
    }

//    public List<Course> findStudentCourses(int stId){
//        return stdgradeDAO.
//    }


}
