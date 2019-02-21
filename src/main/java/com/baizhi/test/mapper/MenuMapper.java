package com.baizhi.test.mapper;

import com.baizhi.test.entity.Menu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MenuMapper extends Mapper<Menu> {
    public List<Menu> queryAllMenu();

    public List<Menu> querySecondTitle(Integer pid);
}
