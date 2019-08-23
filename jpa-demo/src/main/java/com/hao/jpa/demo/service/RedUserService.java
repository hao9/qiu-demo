package com.hao.jpa.demo.service;


import com.hao.jpa.demo.Request.RedUserInfo;
import com.hao.jpa.demo.entity.RedUser;
import com.hao.jpa.demo.repository.RedUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;


@Service
public class RedUserService {

    @Autowired
    RedUserDao redUserDao;

    public RedUser insertRedUser(RedUser u){
        return redUserDao.save(u);
    }
    public Page<RedUser> getList(RedUserInfo u){
        Pageable pageabl1e = PageRequest.of(u.getPageCurr() -1 ,u.getPageSize());
        //RedUser ru = new RedUser();
        //ru.setName(u.getName()==null ? "" :u.getName());
        return redUserDao.findAll(pageabl1e);
    }

}
