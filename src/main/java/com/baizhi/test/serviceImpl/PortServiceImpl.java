package com.baizhi.test.serviceImpl;

import com.baizhi.test.entity.Album;
import com.baizhi.test.entity.Banner;
import com.baizhi.test.entity.Chapter;
import com.baizhi.test.entity.User;
import com.baizhi.test.mapper.AlbumMapper;
import com.baizhi.test.mapper.BannerMapper;
import com.baizhi.test.mapper.ChapterMapper;
import com.baizhi.test.mapper.UserMapper;
import com.baizhi.test.service.PortService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PortServiceImpl implements PortService {
    @Autowired
    BannerMapper bannerMapper;
    @Autowired
    AlbumMapper albumMapper;
    @Autowired
    ChapterMapper chapterMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public Object firstPage(String id, String type, String sub_type) {
        if (id == null || type == null) {
            return "参数不能为空";
        } else {
            if (type.equals("all")) {
                Map<String, Object> map = new HashMap<>();
                List<Banner> banners = bannerMapper.selectAll();
                List<Album> albums = albumMapper.queryAllAlbum();
                List<Chapter> chapters = chapterMapper.selectAll();
                map.put("chapters", chapters);
                map.put("albums", albums);
                map.put("banner", banners);
                return map;
            } else if (type.equals("wen")) {
                Map<String, Object> map = new HashMap<>();
                List<Album> albums = albumMapper.queryAllAlbum();
                map.put("album", albums);
                return map;
            } else {                //传入的type为si的时候的集合
                if (sub_type != null) {
                    if (type.equals("ssyj")) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("shangshiAlbum", "上师的文章集合");
                        return map;
                    } else {
                        Map<String, Object> map = new HashMap<>();
                        map.put("otherAlbum", "其他上师的文章集合");
                        return map;
                    }
                } else {
                    return "思的类型不能为空";
                }
            }
        }
    }

    //文的详情页接口
    public Object wen(Integer id, String uid) {
        if (id == null || uid == null) {
            return "查询文时，参数不能为空";
        } else {
            if (uid instanceof String) {
                Map<String, Object> map = new HashMap<>();
                List<Chapter> chapters = chapterMapper.selectAll();
                map.put("detailChapter", chapters);
                return map;
            } else {
                Album album = albumMapper.selectByPrimaryKey(id);
                return album;
            }
        }
    }

    //登录接口
    public Object login(String phone, String password, String code) {
        if (phone == null) {
            return "手机号不能为空";
        } else {
            if (password == null && code == null) {
                return "验证码和密码至少填一个";
            } else {
                User user = userMapper.queryOneUser(phone);
                return user;
            }
        }
    }

    //注册接口
    public Object regist(String phone, String password) {
        if (phone == null || password == null) {
            return "注册失败,手机号和密码不能为空";
        } else {
            User user = userMapper.queryOneUser(phone);
            if (user != null) {
                return "该手机已存在";
            } else {
                return "注册成功";
            }
        }
    }
}
