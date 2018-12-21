package com.cdl.demo.dao;

import com.cdl.demo.domain.PersonalInformation;
import org.apache.ibatis.annotations.Param;

public interface PersonalInformationDao {
    PersonalInformation getInformationByUserId(@Param("userId") int userId);
    boolean changeJianjie(@Param("userId") int userId, @Param("jianjie") String jianjie);
    boolean changeAddress(@Param("userId") int userId, @Param("address") String address);
    boolean changePhone(@Param("userId") int userId, @Param("phone") String phone);
    boolean changeInterest(@Param("userId") int userId, @Param("interest") String interest);
    boolean changeWork(@Param("userId") int userId, @Param("work") String work);
}
