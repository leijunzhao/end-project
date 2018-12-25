package com.baizhi.serviceImpl;

import com.baizhi.entity.Province;
import com.baizhi.mapper.UserMapper;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional

@Service
public class UserServiceImpl
        implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<Province> userRegion() {
        List<Province> provinceList = userMapper.userRegion();
        return provinceList;
    }

    @Override
    public Integer queryOneWeek(Integer week) {
        Integer integer = userMapper.queryOneWeek(week);
        return integer;
    }

    @Override
    public Integer queryTwoWeek() {
        return userMapper.queryTwoWeek();
    }

    @Override
    public Integer queryThreeWeek() {
        return userMapper.queryThreeWeek();
    }
}
