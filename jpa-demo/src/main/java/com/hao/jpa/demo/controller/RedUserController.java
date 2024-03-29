package com.hao.jpa.demo.controller;


import com.hao.jpa.demo.Reponse.PageResponse;
import com.hao.jpa.demo.Reponse.PageResponse2;
import com.hao.jpa.demo.Request.CommentIDRequest;
import com.hao.jpa.demo.Request.RedUserInfo;
import com.hao.jpa.demo.Request.RedUserRequest;
import com.hao.jpa.demo.Request.RegisterUserRequest;
import com.hao.jpa.demo.entity.RedUser;
import com.hao.jpa.demo.service.RedUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Boolean inserRedUser(@Validated  RedUserRequest u){
        return redUserService.insertOrUpdateRedUser(u);
    }
    @RequestMapping("/list")
    public PageResponse<RedUser> getList(RedUserInfo u){
        return redUserService.getList(u);
    }
    @RequestMapping("/list2")
    public PageResponse2<RedUser> getList2(RedUserInfo u){
        return redUserService.getList2(u);
    }
    @PostMapping("delete")
    public Boolean deleteRedUser(CommentIDRequest u){
        return redUserService.deleteRedUser(u);
    }

    @PostMapping("register")
    public Boolean registerRedUser(@Validated  RegisterUserRequest u){
        return redUserService.registerRedUser(u);
    }
    @PostMapping("login")
    public Boolean loginRedUser(@Validated  RegisterUserRequest u){
        return redUserService.loginRedUser(u);
    }

}
