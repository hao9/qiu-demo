package com.example.demo.controller;

import com.example.demo.model.DemoUser;
import com.example.demo.service.impl.DemoUserService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class DemoUserController {

    @Autowired
//    @Resource
    private DemoUserService demoUserService;

    @RequestMapping("/allUser")
    @ResponseBody
    public PageInfo<DemoUser> queryAllUser() {
        PageInfo<DemoUser> userPageInfo = demoUserService.queryAll(1, 3);
        return userPageInfo;
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public DemoUser getUser(@Param("id") String id) {
        return demoUserService.getUser(id);
    }

}
