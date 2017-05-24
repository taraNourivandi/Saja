package com.sbu.dao;

import java.util.List;

import com.sbu.dao.model.Prof;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfDAO 
{
    Prof findUser(int id);
}
