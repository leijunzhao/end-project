package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "people")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class People {
    @Id
    private Integer id;
    private String name;
    private String mobile;
    private String email;
    private String city;
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;
}
