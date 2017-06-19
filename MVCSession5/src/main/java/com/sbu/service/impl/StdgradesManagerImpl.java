package com.sbu.service.impl;

import com.sbu.dao.impl.StdgradeDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tara on 6/19/2017.
 */

@Service
public class StdgradesManagerImpl {
    @Autowired
    public StdgradeDAOImpl stdgradeDAO;

    public StdgradesManagerImpl() {
    }


}
