package com.cdl.demo.service.impl;

import com.cdl.demo.dao.AccuseDao;
import com.cdl.demo.domain.Accusation;
import com.cdl.demo.service.AccuseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccuseServiceImpl implements AccuseService {

    @Autowired
    private AccuseDao accuseDao;
    @Override
    public int addAccuse(Accusation accusation) {
        return accuseDao.addAccuse(accusation);
    }

    @Override
    public List<Accusation> queryAccusationByPage(int pageNumber, int pageSize) {
        int startIndex = (pageNumber - 1) * pageSize;
        return accuseDao.queryUnhandledAccusationByPage(startIndex, pageSize);
    }

    @Override
    public int updateAccusationStatus(int accusationId, int accusationStatus) {
        return accuseDao.updateAccusationStatusById(accusationId, accusationStatus);
    }
}
