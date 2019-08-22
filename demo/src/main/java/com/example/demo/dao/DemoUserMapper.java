package com.example.demo.dao;

import com.example.demo.model.DemoUser;

import java.util.List;

public interface DemoUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DemoUser record);

    int insertSelective(DemoUser record);

    DemoUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DemoUser record);

    int updateByPrimaryKey(DemoUser record);

    List<DemoUser> queryAll();
}