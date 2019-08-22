package com.example.demo.service.impl;

import com.example.demo.dao.DemoUserMapper;
import com.example.demo.model.DemoUser;
import com.example.demo.service.DemoUserInterface;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoUserService implements DemoUserInterface {

    @Autowired  //或则@Resource
    private DemoUserMapper demoUserMapper;  //这里报错是正常的

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public PageInfo<DemoUser> queryAll(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<DemoUser> users = demoUserMapper.queryAll();
        PageInfo result = new PageInfo(users);
        return result;
    }

    @Override
    public DemoUser getUser(String id) {
        return demoUserMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

}
