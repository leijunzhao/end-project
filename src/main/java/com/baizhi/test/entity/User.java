package com.baizhi.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @KeySql(useGeneratedKeys = true)
    @Id
    private Integer id;
    private String phone;
    private String password;
    private String salt;
    private String sign;
    private String headPic;
    private String name;
    private String dharma;
    private String sex;
    private String province;
    private String city;
    private Integer status;
    private Date registDate;
}
