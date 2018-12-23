package com.baizhi;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EndProjectApplicationTests {

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

}

