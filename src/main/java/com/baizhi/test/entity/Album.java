package com.baizhi.test.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "album")
@ExcelTarget(value = "album")
public class Album implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    @ExcelIgnore
    private Integer id;
    @Excel(name = "专辑", needMerge = true)
    private String title;
    @Excel(name = "专辑集数", needMerge = true)
    private Integer count;
    @Excel(name = "专辑封面", needMerge = true, type = 2, width = 40, height = 20)
    private String coverImg;
    @Excel(name = "评分", needMerge = true)
    private String score;
    @Excel(name = "作者", needMerge = true)
    private String author;
    @Excel(name = "专辑简介", needMerge = true)
    private String brief;
    @Excel(name = "播放者", needMerge = true)
    private String broadcast;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上传日期", format = "yyyy年MM月dd日", width = 20, needMerge = true)
    private Date publishDate;
    @Transient
    @ExcelCollection(name = "专辑章节")
    private List<Chapter> children;

}
