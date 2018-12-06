package com.cdl.demo.utils;

import com.cdl.demo.dao.MyClassDao;
import com.cdl.demo.dao.UserDao;
import com.cdl.demo.domain.Message;
import com.cdl.demo.domain.MyClass;
import com.cdl.demo.domain.Result;
import com.cdl.demo.domain.User;
import com.cdl.demo.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MessageSystem {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MyClassDao myClassDao;

    public Result getPersonalMessageList(int fromUserId, int toUserId) {
        try {
            File file = ResourceUtils.getFile("classpath:message/personal/" + fromUserId + "/" + toUserId + ".txt");
            List<Message> messageList = readMessageFile(file);
            return  new Result<>(ResultEnum.SUCCESS, messageList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new Result(ResultEnum.MESSGAE_EMPTY);
        }
    }

    public Result getClassMessageList(int classId) {
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "message/class/" + classId + ".txt";
        File file = new File(path);
        List<Message> messageList = readClassMessageFile(file);
        return new Result<>(ResultEnum.SUCCESS, messageList);
    }

    public Result getMessageRecordOfOne(int userId, int classId) {
        List<Map> mapList = new ArrayList<>();
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "message/personal/" + userId;
        String classPath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "message/class/" + classId + ".txt";
        MyClass myClass = myClassDao.queryClassById(classId);
        File classFile = new File(classPath);
        try {
            String classLine = readLastLine(classFile, "UTF-8");
            classLine = classLine.replaceAll("\r|\n", "");
            String [] classLineValues = classLine.split(" +");
            classLineValues[2] = classLineValues[2].trim();
            Map<String, Object> classMap = new HashMap<>();
            classMap.put("lastMessage", new Message(Integer.parseInt(classLineValues[0]), classLineValues[1], new Timestamp(new Long(classLineValues[2]))));
            classMap.put("class", myClass);
            mapList.add(classMap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File fileDir = new File(path);
        File[] files = fileDir.listFiles();
        if (files != null) {
            for (File file: files) {
                try {
                    Map<String, Object> map = new HashMap<>();
                    String fileName = file.getName();
                    Integer fromUserId = Integer.parseInt(fileName.substring(0, fileName.lastIndexOf(".")));
                    User user = userDao.queryUserById(fromUserId);
                    String line = readLastLine(file, "UTF-8");
                    line = line.replaceAll("\r|\n", "");
                    String [] values = line.split(" +");
                    values[3] = values[3].trim();
                    Message lastMessage = new Message(Integer.parseInt(values[0]), Integer.parseInt(values[1]), values[2], new Timestamp(new Long(values[3])));
                    map.put("user", user);
                    map.put("lastMessage", lastMessage);
                    mapList.add(map);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new Result<>(ResultEnum.SUCCESS, mapList);
    }

    public Result sendClassMessage(Message message) {
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "message/class/" + message.getToClassId() + ".txt";
        System.out.println(path);
        File file = new File(path);
        mkMessageDirs(file);
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            writer.write(message.getClassMessageFileLine() + "\r\n");
            writer.close();
            return new Result(ResultEnum.SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result(ResultEnum.ERROR);
    }

    public Result sendPersonalMessage(Message message) {
        File file;
        File mirror;
        String path = ClassUtils.getDefaultClassLoader().getResource("message/personal/").getPath() + message.getFromUserId() + "/" + message.getToUserId() + ".txt";
        String mirrorPath = ClassUtils.getDefaultClassLoader().getResource("message/personal/").getPath() + message.getToUserId() + "/" + message.getFromUserId() + ".txt";
        file = new File(path);
        mirror = new File(mirrorPath);
        mkMessageDirs(file);
        mkMessageDirs(mirror);
        BufferedWriter bufferedWriter;
        BufferedWriter mirrorWriter;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            mirrorWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mirror, true)));
            bufferedWriter.write(message.getFileLine() + "\r\n");
            mirrorWriter.write(message.getFileLine() + "\r\n");
            bufferedWriter.close();
            mirrorWriter.close();
            return new Result(ResultEnum.SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result(ResultEnum.ERROR);
    }

    private void mkMessageDirs(File file) {
        if (!file.exists()) {
            File fileParent = file.getParentFile();
            if (!fileParent.exists()) {
                fileParent.mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Message> readMessageFile(File file) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            List<Message> messageList = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                String [] values = line.split(" +");
                Message item = new Message(Integer.parseInt(values[0]), Integer.parseInt(values[1]), values[2], new Timestamp(new Long(values[3])));
                messageList.add(item);
            }
            return messageList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Message> readClassMessageFile(File file) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            List<Message> messageList = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                String [] values = line.split(" +");
                Message item = new Message(Integer.parseInt(values[0]), values[1], new Timestamp(new Long(values[2])));
                messageList.add(item);
            }
            return messageList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String readLastLine(File file, String charset) throws IOException {
        if (!file.exists() || file.isDirectory() || !file.canRead()) {
            return null;
        }
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file, "r");
            long len = raf.length();
            if (len == 0L) {
                return "";
            } else {
                long pos = len - 1;
                while (pos > 0) {
                    pos--;
                    raf.seek(pos);
                    if (raf.readByte() == '\n') {
                        break;
                    }
                }
                if (pos == 0) {
                    raf.seek(0);
                }
                byte[] bytes = new byte[(int) (len - pos)];
                raf.read(bytes);
                if (charset == null) {
                    return new String(bytes);
                } else {
                    return new String(bytes, charset);
                }
            }
        } catch (FileNotFoundException ignored) {
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (Exception ignored) {
                }
            }
        }
        return null;
    }
}
