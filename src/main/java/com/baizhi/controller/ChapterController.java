package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@RequestMapping("chapter")
@RestController
public class ChapterController {
    @Autowired
    ChapterService chapterService;

    @RequestMapping("addChapter")
    public void addChapter(Chapter chapter, MultipartFile audioFile, HttpSession session) {
        //获取文件的原始名字
        String originalFilename = audioFile.getOriginalFilename();
        //设置文件的新名字
        String newFileName = new Date().getTime() + originalFilename;
        String realPath = session.getServletContext().getRealPath("/uploadAudio");
        //新建一个文件
        File file = new File(realPath + "/" + newFileName);
        try {
            audioFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Encoder encoder = new Encoder();
        Long ls = null;
        try {
            MultimediaInfo m = encoder.getInfo(file);
            ls = m.getDuration();
        } catch (Exception e) {
            e.printStackTrace();
        }
        chapter.setDuration(ls / 60000 + "分" + (ls % 60000) / 1000 + "秒");
        chapter.setSize(audioFile.getSize() / 1024 / 1024 + "MB");
        chapter.setUrl(newFileName);
        chapter.setId(UUID.randomUUID().toString().replace("-", ""));
        chapter.setUploadDate(new Date());

        chapterService.addChapter(chapter);
    }
}
