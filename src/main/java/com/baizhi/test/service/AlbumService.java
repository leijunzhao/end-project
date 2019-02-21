package com.baizhi.test.service;

import com.baizhi.test.entity.Album;
import com.baizhi.test.entity.AlbumDto;

import java.util.List;

public interface AlbumService {
    //查询所有专辑
    public List<Album> queryAllAlbum();

    //添加专辑
    public void addAlbum(Album album);

    //查询一个
    public Album queryOneAlbum(Integer id);

    //分页查询
    public AlbumDto queryAllAlbumByPage(Integer page, Integer rows);
}
