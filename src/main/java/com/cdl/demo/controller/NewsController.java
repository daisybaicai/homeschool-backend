package com.cdl.demo.controller;

import com.cdl.demo.domain.Like;
import com.cdl.demo.domain.News;
import com.cdl.demo.domain.Result;
import com.cdl.demo.enums.ResultEnum;
import com.cdl.demo.service.NewsService;
import com.cdl.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private RedisTemplate<Object,Object> template;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisService redisService;

    @GetMapping(value = "/{newsId}")
    public Result<News> getNewsByNewsId(@PathVariable int newsId) {
        return new Result<>(ResultEnum.SUCCESS, newsService.getNewsByNewsId(newsId));
    }

    @GetMapping(value = "newsdetail/{newsId}")
    public Result<News> getDetailNewsByNewsId(@PathVariable int newsId) {
        return new Result<News>(ResultEnum.SUCCESS, newsService.getDetailNewsByNewsId(newsId));
    }

    @GetMapping(value = "/amount")
    public Result<Integer> getNewsAmount(String startTime, String endTime){
        return new Result<>(ResultEnum.SUCCESS, newsService.getNewsAmountByTime(startTime, endTime));
    }

    @GetMapping(value = "")
    public Result<List<News>> getNewsByUserId(int userId){
        return new Result<>(ResultEnum.SUCCESS, newsService.getNewsByUserId(userId));
    }

    @GetMapping(value = "/likeyesorno/{userId}")
    public Result<List<News>> getNewsAllByUserId(@PathVariable int userId) {
        return new Result<List<News>>(ResultEnum.SUCCESS, newsService.getNewsAllByUserIds(userId));
    }

    @GetMapping(value = "/monthAmount")
    public Result getNewsAmountAllMonth() {
        return new Result<>(ResultEnum.SUCCESS, newsService.getNewsAmountAllMonth());
    }

    @GetMapping(value = "/accordingTime/{userId}")
    public Result<List<News>> accordingTime(@PathVariable int userId) {
        return new Result<List<News>>(ResultEnum.SUCCESS, newsService.accordingTime(userId));
    }

    @GetMapping(value = "/accordingClass/{userId}")
    public Result<List<News>> accordingClass(@PathVariable int userId) {
        return new Result<List<News>>(ResultEnum.SUCCESS, newsService.accordingClass(userId));
    }

    @GetMapping(value = "/accordingConcern/{userId}")
    public Result<List<News>> accordingConcern(@PathVariable int userId) {
        return new Result<List<News>>(ResultEnum.SUCCESS, newsService.accordingConcern(userId));
    }

    @GetMapping(value = "/accordingLike/{userId}")
    public Result<List<News>> accordingLike(@PathVariable int userId) {
        return new Result<List<News>>(ResultEnum.SUCCESS, newsService.accordingLike(userId));
    }

    @GetMapping(value = "getNewByUserId/{userId}")
    public Result<List<News>> getNewByUserId(@PathVariable int userId){
        return new Result<List<News>>(ResultEnum.SUCCESS, newsService.getNewByUserId(userId));
    }

    @RequestMapping(value = "/sendZan", method = RequestMethod.POST)
    public Result sendZan(Like like, HttpServletRequest request) {
//        System.out.println("like--------request得到的");
////        String likeNewsId=request.getParameter("likeNewsId");
////        String likeUserId=request.getParameter("likeUserId");
////        String likeType=request.getParameter("likeType");
////        System.out.println(likeNewsId);
////        System.out.println(likeUserId);
////        System.out.println(likeType);
////        String likeone = likeNewsId+"|"+likeUserId+"|"+likeType;
////        String likeone1 = 14+"|"+21+"|"+0;
////        Like like1 = new Like();
////        like1.setLikeNewsId(1);
////        like1.setLikeUserId(22);
////        like1.setLikeType(0);
////        redisTemplate.opsForValue().set("listlike", likeone);
////        redisTemplate.opsForValue().set("listlike",likeone1);
////        System.out.println(redisTemplate.opsForValue().get("listlike"));
////        template.opsForValue().set("like",like);
////        Like result = (Like) template.opsForValue().get("like");
////
////        redisService.setAdd("mylike",like);
////        redisService.setAdd("mylike",like1);
////
////        System.out.println("set");
////        Set<Object> set =  redisService.setMembers("mylike");
////        for (Object like2 : set) {
////            Like like3 = (Like)like2;
////            System.out.println(like3.getLikeNewsId());
////        }
////        System.out.println("----------like打印");
////        System.out.println("like"+like);
////        System.out.println("like"+like1);
//        System.out.println("------打印完毕");

        //用set取得完以后
//        System.out.println("settttt");
//        redisService.zAdd("setlike",like.toString(),1);
//        Set<Object> set2 =  redisService.setMembers("setlike");
//        for (Object like2 : set2) {
//            Like like3 = (Like)like2;
//            System.out.println(like3.getLikeNewsId());
//        }

        System.out.println("------list");
        redisService.push("mylist",like);
        List<Object> list =redisService.range("mylist",1,10);
//        for (Object like4:list
//             ) {
//            Like like5 = (Like) like4;
//            System.out.println(like5);
//        }
        System.out.println("长度"+redisService.getListLength("mylist"));

        return new Result<>(ResultEnum.SUCCESS,"ok");
    }

    @RequestMapping(value = "/sendnews", method = RequestMethod.POST)
    public Result getnewspic(News news,HttpServletRequest request) {
        System.out.println("news--------request得到的");
        String userId=request.getParameter("userId");
        String newsImageURLs=request.getParameter("newsImageURLs");
        String newsVideoURLs=request.getParameter("newsVideoURLs");
        String newsContent=request.getParameter("newsContent");
        System.out.println(newsImageURLs);
        System.out.println(newsVideoURLs);
        System.out.println(newsContent);
        System.out.println("news-------通过封装得到的");
        System.out.println(news.getNewsUserId());
        System.out.println(news.getNewsImageURLs());
        System.out.println(news.getNewsVideoURLs());
        System.out.println(news.getNewsContent());

        return new Result<>(ResultEnum.SUCCESS,newsService.insertNews(news));
    }


    @RequestMapping("/upload")
    public Result upload(@RequestParam("picture") MultipartFile picture, HttpServletRequest request) throws FileNotFoundException {

            //获取文件在服务器的储存位置
    //        String path = request.getSession().getServletContext().getContextPath("/upload");
            String path = ResourceUtils.getURL("classpath:static/img/newsPic").getPath();
            File filePath = new File(path);
            System.out.println("文件的保存路径：" + path);
            if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
            }

            //获取原始文件名称(包含格式)
            String originalFileName = picture.getOriginalFilename();
            System.out.println("原始文件名称：" + originalFileName);

            //获取文件类型，以最后一个`.`为标识
            String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
            System.out.println("文件类型：" + type);
            //获取文件名称（不包含格式）
            String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

            //设置文件新名称: 当前时间+文件名称（不包含格式）
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String date = sdf.format(d);
            String fileName = date + name + "." + type;
            System.out.println("新文件名称：" + fileName);

            //在指定路径下创建一个文件
            File targetFile = new File(path, fileName);

            //将文件保存到服务器指定位置
            try {
            picture.transferTo(targetFile);
            System.out.println("上传成功");
            //将文件在服务器的存储路径返
                String pathes ="newsPic/" + fileName;
                return new Result<>(ResultEnum.SUCCESS,fileName);
                } catch (IOException e) {
                System.out.println("上传失败");
                e.printStackTrace();
                String mess= "上传失败";
                return new Result<>(ResultEnum.SUCCESS,fileName);
                }
            }
}

