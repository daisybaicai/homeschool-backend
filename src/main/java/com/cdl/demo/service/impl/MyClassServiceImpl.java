package com.cdl.demo.service.impl;

import com.cdl.demo.dao.MyClassDao;
import com.cdl.demo.domain.MyClass;
import com.cdl.demo.service.MyClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyClassServiceImpl implements MyClassService {

    @Autowired
    private MyClassDao myClassDao;

    @Override
    public MyClass queryClassById(int classId) {
        return myClassDao.queryClassById(classId);
    }
}
