package com.hao.jpa.demo.service;


import cn.hutool.core.date.DateTime;
import com.hao.jpa.demo.Reponse.PageResponse;
import com.hao.jpa.demo.Request.CommentIDRequest;
import com.hao.jpa.demo.Request.RedUserInfo;
import com.hao.jpa.demo.Request.RedUserRequest;
import com.hao.jpa.demo.entity.RedUser;
import com.hao.jpa.demo.enums.RedUserInfoEnumInterface;
import com.hao.jpa.demo.repository.RedUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;


@Service
public class RedUserService {

    @Autowired
    RedUserDao redUserDao;

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
        Page<RedUser> pageResult = redUserDao.findAll(pageabl1e);
        PageResponse<RedUser> result = new PageResponse<RedUser>();
        result.setDatas(pageResult.getContent());
        result.setListSize(Integer.valueOf(pageResult.getTotalElements()+""));
        result.setPageCount(pageResult.getTotalPages());
        result.setPageCurr(u.getPageCurr());
        result.setPageSize(u.getPageSize());
        //RedUser ru = new RedUser();
        //ru.setName(u.getName()==null ? "" :u.getName());
        return result;
    }
    public Boolean deleteRedUser(CommentIDRequest u){
        Boolean result = true;
        try {
            redUserDao.deleteById(u.getId());
        }catch(Exception e){
            result = false;
        }
        return result;
    }

}
