package com.cdl.demo.utils;

import com.cdl.demo.domain.Message;
import com.cdl.demo.domain.Result;
import com.cdl.demo.enums.ResultEnum;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class MessageSystem {
    public Result getPersonalMessageList(int fromUserId, int toUserId) {
        try {
            File file = ResourceUtils.getFile("classpath:message/personal/" + fromUserId + "/" + toUserId + ".txt");
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            List<Message> messageList = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                String [] values = line.split(" +");
                for (String value: values) {
                    System.out.println(value + "  ");
                }
                Message item = new Message(Integer.parseInt(values[0]), Integer.parseInt(values[1]), values[2], new Timestamp(new Long(values[3])));
                messageList.add(item);
            }
            return  new Result<>(ResultEnum.SUCCESS, messageList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new Result(ResultEnum.MESSGAE_EMPTY);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result(ResultEnum.ERROR);
    }

    public Result sendPersonalMessage(Message message) {
        File file = null;
        try {
            file = new File(ResourceUtils.getURL("classpath:message/personal/" +
                    message.getFromUserId()).getPath() + "/" + message.getToUserId() + ".txt");
        } catch (FileNotFoundException e) {
            File fileParent = file.getParentFile();
            fileParent.mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            bufferedWriter.write(message.toString() + "\r\n");
            return new Result(ResultEnum.SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result(ResultEnum.ERROR);
    }
}
