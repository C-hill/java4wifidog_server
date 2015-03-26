/*
MySQL Data Transfer
Source Host: localhost
Source Database: wifidog
Target Host: localhost
Target Database: wifidog
Date: 2014/1/15 10:08:11
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for ap 路由器表
-- ----------------------------
DROP TABLE IF EXISTS `ap`;
CREATE TABLE `ap` (
  `ap_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库内id号',
  `gw_id` char(32) NOT NULL COMMENT 'wifidog提供的 gw_id',
  `dev_id` char(46) DEFAULT NULL,
  `dev_md5` char(255) DEFAULT NULL COMMENT '设备id的md5值',
  `name` char(32) DEFAULT NULL COMMENT '路由器的名字',
  `remark` text COMMENT '备注',
  `enable` enum('0','1') NOT NULL DEFAULT '1' COMMENT '是否可以使用',
  PRIMARY KEY (`ap_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='路由器 ap 主表';

-- ----------------------------
-- Table structure for ap_admin
-- ----------------------------
DROP TABLE IF EXISTS `ap_admin`;
CREATE TABLE `ap_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ap_id` bigint(20) NOT NULL,
  `user_token` char(32) COLLATE utf8_bin DEFAULT NULL COMMENT '录记用户的登录token',
  `username` char(255) COLLATE utf8_bin NOT NULL,
  `password` char(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='pa管理用户帐号信息';

-- ----------------------------
-- Table structure for ap_portal portal页面表
-- ----------------------------
DROP TABLE IF EXISTS `ap_portal`;
CREATE TABLE `ap_portal` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ap_id` bigint(20) NOT NULL COMMENT '路由器ap_id',
  `url` char(255) COLLATE utf8_bin NOT NULL COMMENT 'portal跳转的url',
  `kind` enum('0','1') COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '型类，0 pc ,1移动',
  `active` enum('1','0') COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '是否激活,1激活可用,0 未激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='记录不同pc不同跳转页面的表格';

-- ----------------------------
-- Table structure for ap_status 路由状态表
-- ----------------------------
DROP TABLE IF EXISTS `ap_status`;
CREATE TABLE `ap_status` (
  `ap_id` bigint(20) NOT NULL COMMENT 'ap_id',
  `sys_uptime` bigint(20) DEFAULT NULL,
  `sys_memfree` bigint(20) DEFAULT NULL,
  `sys_load` float DEFAULT NULL,
  `wifidog_uptime` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `cpu_usage` smallint(6) DEFAULT NULL,
  `nf_conntrack_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`ap_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ap 路由器状态表';

-- ----------------------------
-- Table structure for ap_user
-- ----------------------------
DROP TABLE IF EXISTS `ap_user`;
CREATE TABLE `ap_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ap_id` bigint(20) NOT NULL COMMENT 'ap_id',
  `username` char(255) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` char(255) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `last_login` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `enable` enum('1','0') COLLATE utf8_bin NOT NULL DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='认证用的用户名密码，和微信登录绑定在一起';

-- ----------------------------
-- Table structure for ap_weixinuser
-- ----------------------------
DROP TABLE IF EXISTS `ap_weixinuser`;
CREATE TABLE `ap_weixinuser` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `ap_id` bigint(20) DEFAULT NULL COMMENT 'ap_id',
  `username` char(255) COLLATE utf8_bin NOT NULL COMMENT '认证用的用户名',
  `password` char(255) COLLATE utf8_bin NOT NULL COMMENT '认证用的密码',
  `fromuser` char(255) COLLATE utf8_bin NOT NULL COMMENT '微信的fromuser',
  `touser` char(255) COLLATE utf8_bin NOT NULL COMMENT '微信的touser',
  `freshdate` datetime NOT NULL COMMENT '刷新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='认证用的用户名密码，和微信登录绑定在一起';

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ap_id` bigint(20) NOT NULL COMMENT '从属路由器的 ap_id',
  `kind` enum('0','1','2') NOT NULL DEFAULT '0' COMMENT '客户端类型，0：其他，1：电脑，2：移动',
  `ip` char(15) NOT NULL COMMENT 'ip',
  `mac` char(17) NOT NULL COMMENT 'mac',
  `token` char(32) NOT NULL,
  `outgoing` bigint(20) NOT NULL DEFAULT '0' COMMENT '上行流量',
  `incoming` bigint(20) NOT NULL DEFAULT '0' COMMENT '下行流量',
  `uprate` int(11) DEFAULT '0' COMMENT '上行速率',
  `downrate` int(11) DEFAULT '0' COMMENT '下行速率',
  `status` enum('0','1','2','3','4') NOT NULL DEFAULT '0' COMMENT '最后一次状态；0：其他状态 ，1：登录，2：认证，3：认证通过（计数），4：认证被拒',
  `login_count` int(11) NOT NULL DEFAULT '0' COMMENT '录登次数',
  `update_time` datetime NOT NULL COMMENT '更新日期',
  `login_time` datetime NOT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='客户端信息表';

-- ----------------------------
-- Table structure for rule_domain
-- ----------------------------
DROP TABLE IF EXISTS `rule_domain`;
CREATE TABLE `rule_domain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ap_id` bigint(20) NOT NULL,
  `domain` text NOT NULL,
  `enable` enum('0','1') NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='wifidog 域名白名单';

-- ----------------------------
-- Table structure for rule_host
-- ----------------------------
DROP TABLE IF EXISTS `rule_host`;
CREATE TABLE `rule_host` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ap_id` bigint(20) NOT NULL,
  `ip` char(15) NOT NULL,
  `netmask` char(15) NOT NULL,
  `up` int(11) NOT NULL,
  `down` int(11) NOT NULL,
  `session` int(11) NOT NULL,
  `enable` enum('0','1') NOT NULL DEFAULT '0' COMMENT '否是启用该策略',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='主机规则';

-- ----------------------------
-- Table structure for rule_ipwhite
-- ----------------------------
DROP TABLE IF EXISTS `rule_ipwhite`;
CREATE TABLE `rule_ipwhite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ap_id` bigint(20) NOT NULL,
  `ip` char(15) NOT NULL,
  `netmask` char(15) NOT NULL,
  `enable` enum('0','1') NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='ip白名单表';

-- ----------------------------
-- Table structure for rule_macblack
-- ----------------------------
DROP TABLE IF EXISTS `rule_macblack`;
CREATE TABLE `rule_macblack` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ap_id` bigint(20) NOT NULL,
  `mac` char(17) NOT NULL,
  `enable` enum('0','1') NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='mac黑名单表';

-- ----------------------------
-- Table structure for rule_macwhite
-- ----------------------------
DROP TABLE IF EXISTS `rule_macwhite`;
CREATE TABLE `rule_macwhite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ap_id` bigint(20) NOT NULL,
  `mac` char(17) NOT NULL,
  `enable` enum('0','1') NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='mac白名单';

-- ----------------------------
-- Table structure for rule_wifidog
-- ----------------------------
DROP TABLE IF EXISTS `rule_wifidog`;
CREATE TABLE `rule_wifidog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ap_id` bigint(20) NOT NULL COMMENT 'ap_id',
  `param` char(17) NOT NULL COMMENT '配置参数',
  `value` char(255) NOT NULL DEFAULT '0' COMMENT '配置值',
  `assist` char(255) DEFAULT NULL COMMENT '辅助参数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='mac白名单';

--
-- 表的结构 `user_ap2user`
--
DROP TABLE IF EXISTS `user_ap2user`;
CREATE TABLE IF NOT EXISTS `user_ap2user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `ap_id` int(11) NOT NULL COMMENT '路由id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

--
-- 表的结构 `user_group`
--
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE IF NOT EXISTS `user_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(255) COLLATE utf8_bin NOT NULL COMMENT '用户组名称',
  `remark` char(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `permission_id` int(11) NOT NULL COMMENT '权限id',
  `permission` int(11) NOT NULL COMMENT '权限权重值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

--
-- 表的结构 `user_info`
--
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE IF NOT EXISTS `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` char(255) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` char(255) COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  `active` enum('1','0') COLLATE utf8_bin NOT NULL DEFAULT '1' COMMENT '否是启用改用户',
  `group_id` int(11) NOT NULL COMMENT '用户组id',
  `permission_id` int(11) NOT NULL COMMENT '权限id',
  `last_login` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `login_count` int(11) NOT NULL DEFAULT '0' COMMENT '登录次数',
  `remark` char(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

--
-- 表的结构 `user_permission`
--
DROP TABLE IF EXISTS `user_permission`;
CREATE TABLE IF NOT EXISTS `user_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(255) COLLATE utf8_bin NOT NULL COMMENT '权限名称',
  `code` char(255) COLLATE utf8_bin NOT NULL COMMENT '码中代的code',
  `weight` int(11) NOT NULL COMMENT '权重值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;