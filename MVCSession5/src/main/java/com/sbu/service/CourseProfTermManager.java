package com.sbu.service;

import com.sbu.dao.model.Courseprofterm;

import java.util.Date;

/**
 * Created by Tara on 5/30/2017.
 */
public interface CourseProfTermManager {
    void saveCPT(int capacity, String date, Date exam, int courseId, int profId, int termId);

}
