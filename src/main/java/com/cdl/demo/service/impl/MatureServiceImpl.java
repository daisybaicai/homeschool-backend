package com.cdl.demo.service.impl;

import com.cdl.demo.dao.MatureDao;
import com.cdl.demo.domain.Mature;
import com.cdl.demo.service.MatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MatureServiceImpl implements MatureService {

    @Autowired
    private MatureDao matureDao;

    @Override
    public List<Mature> getMatureByTime(int userId,String startTime, String endTime) {
        long sTime = new Long(startTime);
        long eTime = new Long(endTime);
        Date sDate = new Date(sTime);
        Date eDate = new Date(eTime);
        return matureDao.getMatureByTime(userId,sDate,eDate);
    }

    @Override
    public List<Mature> getMatureByGroup(int userId, String grouping) {
        return matureDao.getMatureByGroup(userId,grouping);
    }

    @Override
    public List<Mature> getMatureByNewsUserId(int userId, int newsUserId) {
        return matureDao.getMatureByNewsUserId(userId,newsUserId);

    }

    @Override
    public int addMature(Mature mature) {

            return matureDao.sendMature(mature);
    }

    @Override
    public int deleteMature(Mature mature) {
       return matureDao.deleteMature(mature);
    }

}
