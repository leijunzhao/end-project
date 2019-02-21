package com.baizhi.test.mapper;

import com.baizhi.test.entity.Admin;
import tk.mybatis.mapper.common.Mapper;

public interface AdminMapper extends Mapper<Admin> {
    public void insertOneAdmin(Admin admin);
}
