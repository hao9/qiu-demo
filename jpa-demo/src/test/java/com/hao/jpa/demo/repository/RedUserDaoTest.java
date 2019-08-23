package com.hao.jpa.demo.repository;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.hao.jpa.demo.DemoApplicationTests;
import com.hao.jpa.demo.entity.RedUser;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * jpa 测试类
 * </p>
 *
 * @package: com.xkcoding.orm.jpa.repository
 * @description: jpa 测试类
 * @author: yangkai.shen
 * @date: Created in 2018/11/7 14:09
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Slf4j
public class RedUserDaoTest extends DemoApplicationTests {
    @Autowired
    private RedUserDao redUserDao;

    /**
     * 测试保存
     */
    @Test
    public void testSave() {
        String salt = IdUtil.fastSimpleUUID();
        //RedUser testSave3 = RedUser.builder().name("testSave3").password(SecureUtil.md5("123456" + salt)).salt(salt).email("testSave3@xkcoding.com").phoneNumber("17300000003").status(1).lastLoginTime(new DateTime()).build();
        RedUser testSave3 = RedUser.builder().name("testSave3").address("后海站").age(27).sex(1).height(127.66).weight(120.66).phone("17300000003").status(1).createTime(new DateTime()).updateTime(new DateTime()).build();
        redUserDao.save(testSave3);

        Assert.assertNotNull(testSave3.getId());
        Optional<RedUser> byId = redUserDao.findById(testSave3.getId());
        Assert.assertTrue(byId.isPresent());
        log.debug("【byId】= {}", byId.get());
    }

    /**
     * 测试删除
     */
    @Test
    public void testDelete() {
        long count = redUserDao.count();
        redUserDao.deleteById(1L);
        long left = redUserDao.count();
        Assert.assertEquals(count - 1, left);
    }

    /**
     * 测试修改
     */
    @Test
    public void testUpdate() {
        redUserDao.findById(1L).ifPresent(redUser -> {
            redUser.setName("JPA修改名字");
            redUserDao.save(redUser);
        });
        Assert.assertEquals("JPA修改名字", redUserDao.findById(1L).get().getName());
    }

    /**
     * 测试查询单个
     */
    @Test
    public void testQueryOne() {
        Optional<RedUser> byId = redUserDao.findById(1L);
        Assert.assertTrue(byId.isPresent());
        log.debug("【byId】= {}", byId.get());
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testQueryAll() {
        List<RedUser> redUsers = redUserDao.findAll();
        Assert.assertNotEquals(0, redUsers.size());
        log.debug("【RedUsers】= {}", redUsers);
    }

    /**
     * 测试分页排序查询
     */
    @Test
    public void testQueryPage() {
        // 初始化数据
        initData();
        // JPA分页的时候起始页是页码减1
        Integer currentPage = 0;
        Integer pageSize = 5;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize, sort);
        Page<RedUser> redUserPage = redUserDao.findAll(pageRequest);

        Assert.assertEquals(5, redUserPage.getSize());
        Assert.assertEquals(redUserDao.count(), redUserPage.getTotalElements());
        log.debug("【id】= {}", redUserPage.getContent().stream().map(RedUser::getId).collect(Collectors.toList()));
    }

    /**
     * 初始化10条数据
     */
    private void initData() {
        List<RedUser> redUserList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            String salt = IdUtil.fastSimpleUUID();
            int index = 3 + i;
            //RedUser redUser = RedUser.builder().name("testSave" + index).password(SecureUtil.md5("123456" + salt)).salt(salt).email("testSave" + index + "@xkcoding.com").phoneNumber("1730000000" + index).status(1).lastLoginTime(new DateTime()).build();
            //redUserList.add(redUser);
        }
        redUserDao.saveAll(redUserList);
    }

}