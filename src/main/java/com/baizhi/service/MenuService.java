package com.baizhi.service;

import com.baizhi.entity.Menu;

import java.util.List;

public interface MenuService {
    public List<Menu> queryAllMenu();

    //根据parent_id 查询二级菜单
    public List<Menu> querySecondTitle(Integer pid);
}
