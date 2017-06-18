package com.sbu.service.impl;

import com.sbu.dao.impl.TermDAOImpl;
import com.sbu.dao.model.Term;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Tara on 5/29/2017.
 */
public class TermManagerImpl {

    public TermManagerImpl() {
    }

    @Autowired
    public TermDAOImpl termDAOImpl;


    public Term findById(int termId){
        return termDAOImpl.findById(termId);
    }
}
