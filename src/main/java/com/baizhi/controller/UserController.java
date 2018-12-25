package com.baizhi.controller;

import com.baizhi.entity.Province;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("queryUser")
    public Map<String, Object> queryUser(Integer week) {
        Map<String, Object> map = new HashMap<>();
        List<String> str = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        for (int i = 1; i <= week; i++) {
            Integer num = userService.queryOneWeek(i * 7);
            str.add(i + "周内");
            count.add(num);
        }
        map.put("weeks", str);
        map.put("counts", count);
        return map;
    }

    @RequestMapping("userRegion")
    public Map<String, List<Province>> userRegion() {
        List<Province> provinces = userService.userRegion();
        Map<String, List<Province>> map = new HashMap<>();
        map.put("data", provinces);
        return map;
    }
}
