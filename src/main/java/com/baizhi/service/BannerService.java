package com.baizhi.service;

import com.baizhi.entity.Banner;
import com.baizhi.entity.BannerDto;

import java.util.List;

public interface BannerService {
    public List<Banner> queryAllBanner();

    //添加轮播图
    public void addBanner(Banner banner);

    //修改轮播图的状态
    public void updateBanner(Banner banner);

    //删除轮播图
    public void deleteBanner(Banner banner);

    //分页查询所有轮播图
    public BannerDto queryAllByPage(Integer page, Integer rows);
}
