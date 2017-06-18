package com.sbu.dao;

import java.util.List;

import com.sbu.dao.model.Modir;
import org.springframework.stereotype.Repository;

@Repository
public interface managerDAO 
{
    Modir findUser(int id);
	 boolean updateEmail(int id, String email);
}
