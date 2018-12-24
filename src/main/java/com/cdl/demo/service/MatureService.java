package com.cdl.demo.service;

import com.cdl.demo.domain.Mature;

import java.util.List;

public interface MatureService {
    List<Mature> getMatureByTime(int userId, String startTime, String endTime);
    List<Mature> getMatureByGroup(int userId, String grouping);
    List<Mature> getMatureByNewsUserId(int userId, int newsUserId);



    int addMature(Mature mature);
    int deleteMature(Mature mature);
}
