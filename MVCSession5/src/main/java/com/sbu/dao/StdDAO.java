package com.sbu.dao;

import java.util.List;

import com.sbu.dao.model.Stdtable;
import org.springframework.stereotype.Repository;

@Repository
public interface StdDAO 
{
    Stdtable findUser(int id);
}
