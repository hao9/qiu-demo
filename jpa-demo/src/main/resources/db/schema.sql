DROP TABLE IF EXISTS `red_user`;
CREATE TABLE `red_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
  `age` INT(3) NOT NULL UNIQUE COMMENT '年龄',
  `name` VARCHAR(20) NOT NULL COMMENT '姓名',
  `sex` INT(2) NOT NULL COMMENT '性别',
  `height` DOUBLE(6,2) DEFAULT NULL UNIQUE COMMENT '身高',
  `weight` DOUBLE(6,2) DEFAULT NULL UNIQUE COMMENT '体重',
  `phone` VARCHAR(15) NOT NULL UNIQUE COMMENT '手机号码',
  `address` VARCHAR(50) DEFAULT NULL UNIQUE COMMENT '体重',
  `status` INT(2) NOT NULL DEFAULT 1 COMMENT '状态，-1：逻辑删除，0：禁用，1：启用',
  `create_time` DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT NOW() COMMENT '上次更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Spring Boot Demo Orm 系列示例表';
DROP TABLE IF EXISTS `red_login`;
CREATE TABLE `red_login` (
    `id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    `nick_name` VARCHAR(32) NOT NULL UNIQUE COMMENT '用户名',
    `password` VARCHAR(32) NOT NULL COMMENT '加密后的密码',
    `salt` VARCHAR(32) NOT NULL COMMENT '加密使用的盐',
    `email` VARCHAR(32) NOT NULL UNIQUE COMMENT '邮箱',
    `phone_number` VARCHAR(15) NOT NULL UNIQUE COMMENT '手机号码',
    `status` INT(2) NOT NULL DEFAULT 1 COMMENT '状态，-1：逻辑删除，0：禁用，1：启用',
    `create_time` DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    `login_time` DATETIME DEFAULT NULL COMMENT '上次登录时间',
    `login_address` VARCHAR(32) DEFAULT NULL COMMENT '登陆ip',
    `update_time` DATETIME NOT NULL DEFAULT NOW() COMMENT '上次更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Spring Boot Demo Orm 系列示例表';

