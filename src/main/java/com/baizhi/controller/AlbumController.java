package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.AlbumDto;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RequestMapping("album")
@RestController
public class AlbumController {
    @Autowired
    AlbumService albumService;

    @RequestMapping("queryAllAlbum")
    public List<Album> queryAllAlbum() {
        return albumService.queryAllAlbum();
    }

    //添加专辑
    @RequestMapping("addAlbum")
    public void addAlbum(Album album, MultipartFile multipartFile, HttpSession session) throws IOException {
        //获取文件的原始名字
        String originalFilename = multipartFile.getOriginalFilename();
        //拼接后的文件的新名字
        String newFileName = new Date().getTime() + originalFilename;
        String realPath = session.getServletContext().getRealPath("/upload");
        File file = new File(realPath + "/" + newFileName);
        multipartFile.transferTo(file);
        album.setCoverImg(newFileName);
        albumService.addAlbum(album);
    }

    //查询一个
    @RequestMapping("queryOneAlbum")
    public Album queryOneAlbum(Integer id) {
        return albumService.queryOneAlbum(id);
    }

    //分页查询
    @RequestMapping("queryAllAlbumByPage")
    public AlbumDto queryAllAlbumByPage(Integer page, Integer rows) {
        return albumService.queryAllAlbumByPage(page, rows);
    }
}
