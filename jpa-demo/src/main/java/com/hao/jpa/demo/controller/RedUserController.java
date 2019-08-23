package com.hao.jpa.demo.controller;


import com.hao.jpa.demo.Request.RedUserInfo;
import com.hao.jpa.demo.entity.RedUser;
import com.hao.jpa.demo.service.RedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class RedUserController {

    @Autowired
    RedUserService redUserService;

    @PostMapping("/add")
    public RedUser inserRedUser(@Validated  RedUser u){
        return redUserService.insertRedUser(u);
    }
    @PostMapping("/list")
    public Page<RedUser> getList(RedUserInfo u){
        return redUserService.getList(u);
    }

}
