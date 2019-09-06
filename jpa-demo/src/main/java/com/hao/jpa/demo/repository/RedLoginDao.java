package com.hao.jpa.demo.repository;

import com.hao.jpa.demo.entity.RedLogin;
import com.hao.jpa.demo.entity.RedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * User Dao
 * </p>
 *
 * @package: com.xkcoding.orm.jpa.repository
 * @description: User Dao
 * @author: yangkai.shen
 * @date: Created in 2018/11/7 14:07
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Repository
public interface RedLoginDao extends JpaRepository<RedLogin, Long> {
    
}
