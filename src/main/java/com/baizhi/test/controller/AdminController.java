package com.baizhi.test.controller;

import com.baizhi.test.exception.LoginException;
import com.baizhi.test.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("queryOneAdmin")
    public String queryOneAdmin(String name, String password, String code, HttpSession session) {
        //获取session中存入的验证码文字
        String imgCode = (String) session.getAttribute("code");
        System.out.println("-----" + imgCode);
        System.out.println("-----" + code);

        if (!code.equals(imgCode)) {
            throw new LoginException("验证码错误");
        }


        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name, password);
        try {
            subject.login(usernamePasswordToken);
            return "redirect:/main/main.jsp";
        } catch (UnknownAccountException e) {
            return "/main/login";
        } catch (IncorrectCredentialsException e2) {
            return "/main/login";
        }

        //Admin queryOneAdmin = adminService.queryOneAdmin(name, password, code, imgCode);
        //存入登录标志
        //session.setAttribute("loginAdmin", queryOneAdmin);


    }
}
