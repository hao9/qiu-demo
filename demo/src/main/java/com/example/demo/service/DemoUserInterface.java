package com.example.demo.service;

import com.example.demo.model.DemoUser;
import com.github.pagehelper.PageInfo;

public interface DemoUserInterface {

    public PageInfo<DemoUser> queryAll(int pageNum, int pageSize);


    public DemoUser getUser(String id);
}
