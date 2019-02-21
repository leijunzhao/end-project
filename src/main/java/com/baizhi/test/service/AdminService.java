package com.baizhi.test.service;

import com.baizhi.test.entity.Admin;

public interface AdminService {
    public Admin queryOneAdmin(String name, String password, String code, String imgCode);
}
