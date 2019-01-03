package com.cdl.demo.service;

import com.cdl.demo.domain.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component

public class ScheduledTasks {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private LikeService likeService;

//    //每30秒执行一次
//    @Scheduled(fixedRate = 1000 * 10)
//    public void reportCurrentTime(){
//        System.out.println ("Scheduling Tasks Examples: The time is now " + dateFormat ().format (new Date()));
//    }

    //在固定时间执行
    //一分钟一次 0 */1 *  * * *
    //10秒钟一次 */10 * * * * *
    @Scheduled(cron = "*/10 * * * * *")
    public void reportCurrentByCron(){
        System.out.println ("Scheduling Tasks Examples By Cron: The time is now " + dateFormat ().format (new Date()));
        long size = redisTemplate.opsForList().size("mylist");
        if (size == 0) {
            System.out.println("no need to post");
        }else if (size != 0) {
            for (int i = 0; i < size; i++) {
                Object popValue = redisTemplate.opsForList().leftPop("mylist");
                Like like = (Like) popValue;
                if (like.getLikeType() == 0) {
                    likeService.delteLike(like);
                }
                if (like.getLikeType() == 1) {
                    likeService.sendLike(like);
                }
                System.out.print("通过leftPop(K key)方法移除的元素是:" + popValue);
            }
        }
    }

    private SimpleDateFormat dateFormat(){
        return new SimpleDateFormat ("HH:mm:ss");
    }
}
