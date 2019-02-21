package com.baizhi.test.controller;

import com.baizhi.test.entity.Menu;
import com.baizhi.test.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @RequestMapping("queryAllMenu")
    public List<Menu> queryAllMenu() {
        List<Menu> menuList = menuService.queryAllMenu();
        return menuList;
    }

    //根据parent_id=id查询二级标签
    @RequestMapping("secondTitle")
    public List<Menu> querySecondTitle(Integer pid) {
        List<Menu> querySecondTitle = menuService.querySecondTitle(pid);
        return querySecondTitle;
    }
}
