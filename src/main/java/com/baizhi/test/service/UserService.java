package com.baizhi.test.service;

import com.baizhi.test.entity.Province;
import com.baizhi.test.entity.User;

import java.util.List;

public interface UserService {
    public Integer queryOneWeek(Integer week);

    public Integer queryTwoWeek();

    public Integer queryThreeWeek();

    public List<Province> userRegion();

    public User queryOneUser(String phone);
}
