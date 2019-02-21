package com.baizhi.test.controller;

import com.baizhi.test.conf.ValidateImageCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("code")
public class CodeController {
    @RequestMapping("getCode")
    public String getCode(HttpSession session, HttpServletResponse response) {
        //获取验证码上的字
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        session.setAttribute("code", securityCode);
        //绘制验证码
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);

        //获取输出流
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();

            //用流将图片写到页面上
            ImageIO.write(image, "png", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
