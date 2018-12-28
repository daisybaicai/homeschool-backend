package com.cdl.demo.service;

import com.cdl.demo.domain.Concern;
import com.cdl.demo.domain.User;

import java.util.List;

public interface ConcernService {
    List<Concern> getUserStarConcern(Integer userId);
    List<Concern> getUserAllFans(Integer userId);

    List<Concern> getUserAllConcern(Integer userId);
    List<User> getAllUser(Integer userId);
    boolean removeConcernsStar(Integer userId, Integer concernedId);

    boolean sendConcernStar(Integer userId, Integer concernedId);

    boolean deleteConcern(Integer userId, Integer concernedId);
    boolean sendConcern(Integer userId, Integer concernedId);




}
