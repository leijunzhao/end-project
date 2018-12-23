package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.entity.BannerDto;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;

@RestController
@RequestMapping("banner")
public class BannerController {
    @Autowired
    BannerService bannerService;

    @RequestMapping("queryAllBanner")
    public BannerDto queryAllBanner(Integer page, Integer rows) {
        return bannerService.queryAllByPage(page, rows);
    }

    @RequestMapping("addBanner")
    public void addBanner(Banner banner, MultipartFile imgFile, HttpSession session) throws Exception {
        String filename = imgFile.getOriginalFilename();//获取文件原始的名字
        long time = new Date().getTime();//时间戳
        String newName = time + filename;        //文件拼接后的名字

        String realPath = session.getServletContext().getRealPath("/upload");
        File file = new File(realPath + "/" + newName);

        imgFile.transferTo(file);

        banner.setImgPath(newName);
        bannerService.addBanner(banner);
    }

    //修改轮播图的状态
    @RequestMapping("updateBanner")
    public void updateBanner(Banner banner) {
        bannerService.updateBanner(banner);
    }

    //删除轮播图
    @RequestMapping("deleteBanner")
    public String deleteBanner(Banner banner) {
        bannerService.deleteBanner(banner);
        return "";
    }

}
