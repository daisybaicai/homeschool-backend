package com.cdl.demo.controller;

import com.cdl.demo.domain.News;
import com.cdl.demo.domain.Result;
import com.cdl.demo.enums.ResultEnum;
import com.cdl.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/{newsId}")
    public Result<News> getNewsByNewsId(@PathVariable int newsId) {
        return new Result<>(ResultEnum.SUCCESS, newsService.getNewsByNewsId(newsId));
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
                String pathes ="/upload/" + fileName;
                return new Result<>(ResultEnum.SUCCESS,pathes);
                } catch (IOException e) {
                System.out.println("上传失败");
                e.printStackTrace();
                String mess= "上传失败";
                return new Result<>(ResultEnum.SUCCESS,mess);
                }
            }
}

