package com.sbu.service.impl;

import com.sbu.dao.impl.CourseDAOImpl;
import com.sbu.dao.impl.TermDAOImpl;
import com.sbu.dao.model.Term;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tara on 5/29/2017.
 */

@Service
public class TermManagerImpl {

    public TermManagerImpl() {
    }

    @Autowired
    public TermDAOImpl termDAOImpl;
    @Autowired
    public CourseDAOImpl courseDAOImpl;


    @Transactional
    public void insertTerm(int id){
        String name = String.valueOf(id);
        Term term = new Term(id,name);
        termDAOImpl.insertTerm(term);

    }


    public Term findById(int termId){
        return termDAOImpl.findById(termId);
    }
}
