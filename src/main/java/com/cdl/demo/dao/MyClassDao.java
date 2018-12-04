package com.cdl.demo.dao;

import com.cdl.demo.domain.MyClass;
import org.apache.ibatis.annotations.Param;

public interface MyClassDao {
    MyClass queryClassById(@Param("classId") int classId);
}
