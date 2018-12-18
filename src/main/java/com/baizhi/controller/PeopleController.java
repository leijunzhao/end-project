package com.baizhi.controller;

import com.baizhi.entity.People;
import com.baizhi.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PeopleController {
    @Autowired
    private PeopleMapper peopleMapper;

    @RequestMapping("queryAll")
    public List<People> queryAll() {
        return peopleMapper.selectAll();
    }
}
