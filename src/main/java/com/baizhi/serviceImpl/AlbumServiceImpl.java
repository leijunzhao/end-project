package com.baizhi.serviceImpl;

import com.baizhi.entity.Album;
import com.baizhi.entity.AlbumDto;
import com.baizhi.mapper.AlbumMapper;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    AlbumMapper albumMapper;

    public List<Album> queryAllAlbum() {
        return albumMapper.queryAllAlbum();
    }

    @Override
    public void addAlbum(Album album) {
        albumMapper.insert(album);
    }


    @Override
    public Album queryOneAlbum(Integer id) {
        return albumMapper.selectByPrimaryKey(id);
    }

    @Override
    public AlbumDto queryAllAlbumByPage(Integer page, Integer rows) {
        AlbumDto albumDto = new AlbumDto();
        albumDto.setTotal(albumMapper.selectCount(new Album()));
        albumDto.setRows(albumMapper.queryAllAlbumByPage(page, rows));
        return albumDto;
    }
}
