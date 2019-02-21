package com.baizhi.test;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.test.entity.Admin;
import com.baizhi.test.mapper.AdminMapper;
import com.baizhi.test.mapper.UserMapper;
import com.baizhi.test.service.UserService;
import io.goeasy.GoEasy;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import java.io.File;
import java.time.LocalDateTime;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EndProjectApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Autowired
    AdminMapper adminMapper;

    @Test
    public void contextLoads() {
        File source = new File("G:\\网易云\\王英姿 - 月亮船.mp3");
        Encoder encoder = new Encoder();
        try {
            MultimediaInfo m = encoder.getInfo(source);
            long ls = m.getDuration();
            long length = source.length();
            System.out.println("文件大小是===" + length);
            System.out.println("此视频时长为:" + ls / 60000 + "分" + (ls % 60000) / 1000 + "秒！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDate() {
        System.out.println(UUID.randomUUID());
    }

    @Test
    public void testWeek() {
        Integer integer = userMapper.queryOneWeek(1);
        System.out.println(integer);
    }

    @Test
    public void testGoEasy() {
        Map<String, Object> map = new HashMap<>();
        List<String> str = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Integer num = userService.queryOneWeek(i * 7);
            str.add(i + "周内");
            count.add(num);
        }
        map.put("weeks", str);
        map.put("counts", count);
        String s = JSONObject.toJSONString(map);

        System.out.println(s);
        GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-b68cdb659fd94878b214a1d9b8416eea");
        goEasy.publish("active", s);
    }

    @Test
    public void testYeee() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }

    @Test
    public void testMd5() {
        String a = "123456";

        String v = "12345";
        byte[] bytes = DigestUtils.md5Digest(a.getBytes());
        byte[] bytes2 = DigestUtils.md5Digest(a.getBytes());

        String s1 = DigestUtils.md5DigestAsHex(a.getBytes());
        String s = bytes.toString();
        String s2 = bytes2.toString();
        System.out.println(s);
        System.out.println(s2);
        System.out.println(s1);

        System.out.println();


    }


    @Test
    public void testInte() {
        Integer a = 2;
        String s = Integer.toString(a);
        String s1 = a.toString();
        String s2 = String.valueOf(a);
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(a.toString());
    }


    @Test
    public void testInsertAdmin() {
        Admin admin = new Admin(null, "lhy", "123456", "0000");
        adminMapper.insertOneAdmin(admin);
    }
}

