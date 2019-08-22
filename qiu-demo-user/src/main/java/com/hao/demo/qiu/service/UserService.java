package com.hao.demo.qiu.service;

import com.github.pagehelper.PageHelper;
import com.hao.demo.qiu.dao.DemoUserMapper;
import com.hao.demo.qiu.model.DemoUser;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private DemoUserMapper demoUserMapper;

    public Page<DemoUser> getUserList(){



        return null;
    }


}
