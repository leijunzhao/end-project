package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
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

        Admin queryOneAdmin = adminService.queryOneAdmin(name, password, code, imgCode);
        //存入登录标志
        session.setAttribute("loginAdmin", queryOneAdmin);

        return "redirect:/main/main.jsp";
    }
}
