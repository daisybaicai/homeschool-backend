package com.cdl.demo.service;

import com.cdl.demo.domain.Mature;
import com.cdl.demo.domain.News;

import java.util.List;

public interface MatureService {
    List<Mature> getMatureByTime(int userId, String startTime, String endTime);
    Mature addMature(Mature mature);
}
