package com.hao.jpa.demo.service;


import cn.hutool.core.date.DateTime;
import com.hao.jpa.demo.Reponse.PageResponse;
import com.hao.jpa.demo.Reponse.PageResponse2;
import com.hao.jpa.demo.Request.CommentIDRequest;
import com.hao.jpa.demo.Request.RedUserInfo;
import com.hao.jpa.demo.Request.RedUserRequest;
import com.hao.jpa.demo.Request.RegisterUserRequest;
import com.hao.jpa.demo.entity.RedLogin;
import com.hao.jpa.demo.entity.RedUser;
import com.hao.jpa.demo.enums.RedUserInfoEnumInterface;
import com.hao.jpa.demo.repository.RedLoginDao;
import com.hao.jpa.demo.repository.RedUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;


@Service
public class RedUserService {

    @Autowired
    RedUserDao redUserDao;
    @Autowired
    RedLoginDao redLoginDao;

    public Boolean insertOrUpdateRedUser(RedUserRequest u){
        RedUser redUser = new RedUser();
        redUser.setName(u.getName());
        redUser.setAddress(u.getAddress());
        redUser.setAge(u.getAge());
        redUser.setPhone(u.getPhone());
        redUser.setHeight(u.getHeight());
        redUser.setSex(u.getSex());
        redUser.setWeight(u.getWeight());
        redUser.setId(u.getId());
        redUser.setUpdateTime(new DateTime());
        redUser.setStatus(RedUserInfoEnumInterface.STATUS.ABLE);
        if(null == u.getId()){
            redUser.setCreateTime(new DateTime());
        }
        return redUserDao.save(redUser).getId() !=  null;
    }
    public PageResponse<RedUser> getList(RedUserInfo u){
        Pageable pageabl1e = PageRequest.of(u.getPageCurr() -1 ,u.getPageSize());
        RedUser redUser = new RedUser();
        redUser.setName(u.getName());
        redUser.setStatus(RedUserInfoEnumInterface.STATUS.ABLE);
        Example<RedUser> example = Example.of(redUser);
        Page<RedUser> pageResult = redUserDao.findAll(example,pageabl1e);
        PageResponse<RedUser> result = new PageResponse<RedUser>();
        if(null == pageResult || null == pageResult.getContent()) return result;
        result.setDatas(pageResult.getContent());
        result.setListSize(Integer.valueOf(pageResult.getTotalElements()+""));
        result.setPageCount(pageResult.getTotalPages());
        result.setPageCurr(u.getPageCurr());
        result.setPageSize(u.getPageSize());
        return result;
    }
    public PageResponse2<RedUser> getList2(RedUserInfo u){
        Pageable pageabl1e = PageRequest.of(u.getPageCurr() -1 ,u.getPageSize());
        RedUser redUser = new RedUser();
        redUser.setName(u.getName());
        redUser.setStatus(RedUserInfoEnumInterface.STATUS.ABLE);
        Example<RedUser> example = Example.of(redUser);
        Page<RedUser> pageResult = redUserDao.findAll(example,pageabl1e);
        PageResponse2<RedUser> result = new PageResponse2<RedUser>();
        if(null == pageResult || null == pageResult.getContent()) return result;
        result.setRows(pageResult.getContent());
        result.setListSize(Integer.valueOf(pageResult.getTotalElements()+""));
        result.setPageCount(pageResult.getTotalPages());
        result.setPageCurr(u.getPageCurr());
        result.setPageSize(u.getPageSize());
        return result;
    }

    public Boolean deleteRedUser(CommentIDRequest u){
        Long[] ids = u.getId();
        for(int i=0;i<ids.length;i++){
            RedUser redUser = redUserDao.findById(ids[i]).get();
            redUser.setStatus(RedUserInfoEnumInterface.STATUS.DEL);
            redUser.setId(ids[i]);
            redUser.setUpdateTime(new DateTime());
            redUserDao.save(redUser);
        }
        return true;
    }

    public Boolean registerRedUser(RegisterUserRequest u){
        RedLogin redLogin = new RedLogin();
        redLogin.setName(u.getName());
        Example<RedLogin> example = Example.of(redLogin);
        Long rl = redLoginDao.count(example);
        if(null != rl && rl > 0 ){
            return false;
        }
        redLogin.setPassword(u.getPassword());
        redLogin.setUpdateTime(new DateTime());
        redLogin.setCreateTime(new DateTime());
        return redLoginDao.save(redLogin).getId() !=  null;
    }

    public Boolean loginRedUser(RegisterUserRequest u){
        RedLogin redLogin = new RedLogin();
        redLogin.setName(u.getName());
        redLogin.setPassword(u.getPassword());
        Example<RedLogin> example = Example.of(redLogin);
        Long rl = redLoginDao.count(example);
        return  rl != null && rl>0 ? true : false;
    }



}
