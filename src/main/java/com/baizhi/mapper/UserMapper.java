package com.baizhi.mapper;

import com.baizhi.entity.Province;
import com.baizhi.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    public Integer queryOneWeek(Integer week);

    public Integer queryTwoWeek();

    public Integer queryThreeWeek();

    public List<Province> userRegion();
}
