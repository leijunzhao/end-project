package com.baizhi.serviceImpl;

import com.baizhi.entity.Banner;
import com.baizhi.entity.BannerDto;
import com.baizhi.mapper.BannerMapper;
import com.baizhi.service.BannerService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bannerMapper;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<Banner> queryAllBanner() {

        List<Banner> bannerList = bannerMapper.selectAll();
        return bannerList;
    }

    @Override
    public void addBanner(Banner banner) {
        bannerMapper.insert(banner);
    }

    @Override
    public void updateBanner(Banner banner) {
        bannerMapper.updateByPrimaryKey(banner);
    }

    @Override
    public void deleteBanner(Banner banner) {
        bannerMapper.delete(banner);
    }

    //分页查询
    @Override
    public BannerDto queryAllByPage(Integer page, Integer rows) {
        //RowBounds中的两个参数，每页显示的第一条的数据的索引(下标)
        //例如每页显示3行，第一页的第一个索引的为0，第二页的第一个索引为3

        BannerDto bannerDto = new BannerDto();
        bannerDto.setTotal(bannerMapper.selectCount(new Banner()));
        PageHelper.startPage(page, rows);
        List<Banner> bannerList = bannerMapper.selectAll();
        bannerDto.setRows(bannerList);
        return bannerDto;
    }
}
