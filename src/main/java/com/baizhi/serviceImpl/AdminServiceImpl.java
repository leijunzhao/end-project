package com.baizhi.serviceImpl;

import com.baizhi.entity.Admin;
import com.baizhi.exception.LoginException;
import com.baizhi.mapper.AdminMapper;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    public Admin queryOneAdmin(String name, String password, String code, String imgCode) {
        Admin admin = new Admin();
        admin.setName(name);
        admin.setPassword(password);
        Admin selectOne = adminMapper.selectOne(admin);

        if (!code.equals(imgCode)) {
            throw new LoginException("验证码错误");
        }
        if (selectOne == null) {
            throw new LoginException("账号或者密码错误");
        }
        return selectOne;
    }

}
