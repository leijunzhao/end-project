package com.baizhi.test.utiil;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileUtil {
    public static String getFile(MultipartFile file, HttpSession session) {
        //获取原来文件的名字
        String originalFilename = file.getOriginalFilename();
        //文件拼接后的名字

        String newName = new Date().getTime() + originalFilename;
        String realPath = session.getServletContext().getRealPath("/upload");
        File file1 = new File(realPath + "/" + newName);
        try {
            file.transferTo(file1);
            return newName;
        } catch (IOException e) {
            e.printStackTrace();
            return "没有名字";
        }
    }
}
