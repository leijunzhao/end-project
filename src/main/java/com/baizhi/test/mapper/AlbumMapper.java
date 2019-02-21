package com.baizhi.test.mapper;


import com.baizhi.test.entity.Album;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AlbumMapper extends Mapper<Album> {
    //查询所有的专辑
    public List<Album> queryAllAlbum();

    public List<Album> queryAllAlbumByPage(@Param("page") Integer page, @Param("rows") Integer rows);
}
