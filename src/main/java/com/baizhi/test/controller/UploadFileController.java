package com.baizhi.test.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

@RequestMapping("upload")
@RestController
public class UploadFileController {
    //获取文件上传时的路径
    @RequestMapping("uploadFile")
    public void uploadFile(HttpSession session, HttpServletResponse response, String url) throws Exception {
        //上传的文件都是保存在/webapp/uploadAudio目录下的子目录当中
        String fileSaveRootPath = session.getServletContext().getRealPath("/uploadAudio");
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(url, "UTF-8"));
        // response.setContentType("application/x-msdownload");
        response.setContentType("audio/mpeg");
        byte[] bytes = FileUtils.readFileToByteArray(new File(fileSaveRootPath + "/" + url));

        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //读取要下载的文件，保存到文件输入流
        // FileInputStream in = new FileInputStream(fileSaveRootPath + "\\" + url);
        //创建输出流
        //  OutputStream out = response.getOutputStream();
        //创建缓冲区
/*        byte buffer[] = new byte[1024];
        int len = in.read(buffer);*/
        //循环将输入流中的内容读取到缓冲区当中
/*        while (len > 0) {
            //输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }*/
        //关闭文件输入流
/*
        in.close();
        //关闭输出流
        out.close();
*/

    }
}
