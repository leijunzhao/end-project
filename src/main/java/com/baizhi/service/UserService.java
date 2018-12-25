package com.baizhi.service;

import com.baizhi.entity.Province;

import java.util.List;

public interface UserService {
    public Integer queryOneWeek(Integer week);

    public Integer queryTwoWeek();

    public Integer queryThreeWeek();

    public List<Province> userRegion();
}
