package com.baizhi.test.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HandingException implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //将错误信息带到页面
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("main/login");

        //将错误信息存储
        modelAndView.addObject("loginHandinig", e.getMessage());
        return modelAndView;
    }
}
