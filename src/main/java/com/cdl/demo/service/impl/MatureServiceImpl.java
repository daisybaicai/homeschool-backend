package com.cdl.demo.service.impl;

import com.cdl.demo.dao.MatureDao;
import com.cdl.demo.dao.NewsDao;
import com.cdl.demo.dao.UserDao;
import com.cdl.demo.domain.Comment;
import com.cdl.demo.domain.Mature;
import com.cdl.demo.domain.News;
import com.cdl.demo.domain.User;
import com.cdl.demo.service.CommentService;
import com.cdl.demo.service.MatureService;
import com.cdl.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Mature addMature(Mature mature) {
        if (matureDao.sendMature(mature) == 1) {
            return mature;
        } else  {
            return  null;
        }
    }


}
