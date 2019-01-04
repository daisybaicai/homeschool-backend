package com.cdl.demo.service;

import com.cdl.demo.domain.Accusation;

import java.util.List;


public interface AccuseService {
    int addAccuse(Accusation accusation);
    List<Accusation> queryAccusationByPage(int pageNumber, int pageSize);
    int updateAccusationStatus(int accusationId, int accusationStatus);
}
