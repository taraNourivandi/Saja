package com.sbu.service;


import com.sbu.dao.model.Prof;

public interface ProfManager {
        
        Prof findProf(int id);
		 String findProfEmail(int id);
}
