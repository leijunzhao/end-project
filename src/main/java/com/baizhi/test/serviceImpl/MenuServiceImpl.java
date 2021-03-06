package com.baizhi.test.serviceImpl;

import com.baizhi.test.entity.Menu;
import com.baizhi.test.mapper.MenuMapper;
import com.baizhi.test.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> queryAllMenu() {
        List<Menu> menuList = menuMapper.queryAllMenu();
        return menuList;
    }

    @Override
    public List<Menu> querySecondTitle(Integer pid) {

        List<Menu> querySecondTitle = menuMapper.querySecondTitle(pid);
        return querySecondTitle;
    }
}
