-- --------------------------------------------------------
-- 主机:                           192.168.0.199
-- 服务器版本:                        5.7.10-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 adminstore 的数据库结构
DROP DATABASE IF EXISTS `adminstore`;
CREATE DATABASE IF NOT EXISTS `adminstore` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `adminstore`;


-- 导出  表 adminstore.config_data_version 结构
DROP TABLE IF EXISTS `config_data_version`;
CREATE TABLE IF NOT EXISTS `config_data_version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `sequence` varchar(255) DEFAULT NULL,
  `step` int(11) DEFAULT NULL,
  `versionnum` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_f8c3y9hevq9jmdrb1wjyyqut` (`versionnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.config_data_version 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `config_data_version` DISABLE KEYS */;
/*!40000 ALTER TABLE `config_data_version` ENABLE KEYS */;


-- 导出  表 adminstore.site_app 结构
DROP TABLE IF EXISTS `site_app`;
CREATE TABLE IF NOT EXISTS `site_app` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `downUrl` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `packageName` varchar(255) DEFAULT NULL,
  `system` varchar(255) DEFAULT NULL,
  `versionCode` int(11) DEFAULT NULL,
  `versionName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_jfx5shexfh9lo32836m2t62ga` (`packageName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.site_app 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `site_app` DISABLE KEYS */;
/*!40000 ALTER TABLE `site_app` ENABLE KEYS */;


-- 导出  表 adminstore.site_app_version 结构
DROP TABLE IF EXISTS `site_app_version`;
CREATE TABLE IF NOT EXISTS `site_app_version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `downUrl` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `versionCode` int(11) DEFAULT NULL,
  `versionName` varchar(255) DEFAULT NULL,
  `app_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9rgjxw6r5h7gf0e7ijfbademt` (`app_id`),
  CONSTRAINT `FK9rgjxw6r5h7gf0e7ijfbademt` FOREIGN KEY (`app_id`) REFERENCES `site_app` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.site_app_version 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `site_app_version` DISABLE KEYS */;
/*!40000 ALTER TABLE `site_app_version` ENABLE KEYS */;


-- 导出  表 adminstore.site_log 结构
DROP TABLE IF EXISTS `site_log`;
CREATE TABLE IF NOT EXISTS `site_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `level_info` int(11) DEFAULT NULL,
  `messages` varchar(5000) DEFAULT NULL,
  `source` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.site_log 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `site_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `site_log` ENABLE KEYS */;


-- 导出  表 adminstore.site_template_noticec 结构
DROP TABLE IF EXISTS `site_template_noticec`;
CREATE TABLE IF NOT EXISTS `site_template_noticec` (
  `id` varchar(255) NOT NULL,
  `catalog` int(11) DEFAULT NULL,
  `demo` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.site_template_noticec 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `site_template_noticec` DISABLE KEYS */;
/*!40000 ALTER TABLE `site_template_noticec` ENABLE KEYS */;


-- 导出  表 adminstore.site_template_push 结构
DROP TABLE IF EXISTS `site_template_push`;
CREATE TABLE IF NOT EXISTS `site_template_push` (
  `id` varchar(255) NOT NULL,
  `catalog` int(11) DEFAULT NULL,
  `demo` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.site_template_push 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `site_template_push` DISABLE KEYS */;
/*!40000 ALTER TABLE `site_template_push` ENABLE KEYS */;


-- 导出  表 adminstore.site_template_web 结构
DROP TABLE IF EXISTS `site_template_web`;
CREATE TABLE IF NOT EXISTS `site_template_web` (
  `id` varchar(255) NOT NULL,
  `catalog` int(11) DEFAULT NULL,
  `demo` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.site_template_web 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `site_template_web` DISABLE KEYS */;
/*!40000 ALTER TABLE `site_template_web` ENABLE KEYS */;


-- 导出  表 adminstore.sys_basic_menu 结构
DROP TABLE IF EXISTS `sys_basic_menu`;
CREATE TABLE IF NOT EXISTS `sys_basic_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelinfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortnum` int(11) DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `nums` bigint(20) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK42cvxwq0yf8pj16b113tg23bt` (`pid`),
  CONSTRAINT `FK42cvxwq0yf8pj16b113tg23bt` FOREIGN KEY (`pid`) REFERENCES `sys_basic_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.sys_basic_menu 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_basic_menu` DISABLE KEYS */;
REPLACE INTO `sys_basic_menu` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelinfo`, `lft`, `name`, `rgt`, `sortnum`, `catalog`, `icon`, `nums`, `path`, `permission`, `pid`) VALUES
	(1, '2017-02-22 11:50:55', '1', '1', '2017-02-22 11:55:11', 1, 1, '系统菜单', 8, 1, 1, NULL, 3, NULL, '1', NULL),
	(2, '2017-02-22 11:53:52', NULL, '1,2', '2017-02-22 11:55:10', 2, 2, '系统配置', 7, NULL, 0, 'fa fa-circle-o', 2, '', '', 1),
	(3, '2017-02-22 11:54:23', NULL, '1,2,3', '2017-02-22 11:54:23', 3, 3, '菜单管理', 4, 1, 0, 'fa fa-circle-o', 0, 'admin/menu/list.htm', 'menu:list', 2),
	(4, '2017-02-22 11:55:10', NULL, '1,2,4', '2017-02-22 11:55:10', 3, 5, '角色管理', 6, NULL, 0, 'fa fa-circle-o', 0, 'admin/userrole/view_list.htm', 'role:list', 2);
/*!40000 ALTER TABLE `sys_basic_menu` ENABLE KEYS */;


-- 导出  表 adminstore.sys_user_account 结构
DROP TABLE IF EXISTS `sys_user_account`;
CREATE TABLE IF NOT EXISTS `sys_user_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `accountType` int(11) DEFAULT NULL,
  `loginSize` int(11) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3e0dpuhumaxr3s9wm6idy3r3v` (`username`),
  KEY `FK2qnkifr1gf1i0ru8jru7c3y26` (`user_id`),
  CONSTRAINT `FK2qnkifr1gf1i0ru8jru7c3y26` FOREIGN KEY (`user_id`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.sys_user_account 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_user_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user_account` ENABLE KEYS */;


-- 导出  表 adminstore.sys_user_info 结构
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE IF NOT EXISTS `sys_user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `loginSize` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `registerType` varchar(20) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.sys_user_info 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `sys_user_info` DISABLE KEYS */;
REPLACE INTO `sys_user_info` (`id`, `addDate`, `lastDate`, `avatar`, `catalog`, `loginSize`, `name`, `password`, `registerType`, `salt`, `username`) VALUES
	(1, '2017-02-22 11:47:05', '2017-02-22 12:01:47', NULL, NULL, 6, 'admin', '545c3ee3341bf735c789c0f2b6a7b8e2c24d9297', '账号', 'ca5cdb182a402924', 'admin');
/*!40000 ALTER TABLE `sys_user_info` ENABLE KEYS */;


-- 导出  表 adminstore.sys_user_info_attribute 结构
DROP TABLE IF EXISTS `sys_user_info_attribute`;
CREATE TABLE IF NOT EXISTS `sys_user_info_attribute` (
  `user_id` bigint(20) NOT NULL,
  `attr` varchar(100) DEFAULT NULL,
  `name` varchar(36) NOT NULL,
  PRIMARY KEY (`user_id`,`name`),
  CONSTRAINT `FK2k9wd2mn3jh6g1wqq2c2b02xl` FOREIGN KEY (`user_id`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.sys_user_info_attribute 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_user_info_attribute` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user_info_attribute` ENABLE KEYS */;


-- 导出  表 adminstore.sys_user_login_log 结构
DROP TABLE IF EXISTS `sys_user_login_log`;
CREATE TABLE IF NOT EXISTS `sys_user_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq1wyinji5bvwearcopg9x5ipu` (`user_id`),
  CONSTRAINT `FKq1wyinji5bvwearcopg9x5ipu` FOREIGN KEY (`user_id`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.sys_user_login_log 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_user_login_log` DISABLE KEYS */;
REPLACE INTO `sys_user_login_log` (`id`, `addDate`, `lastDate`, `ip`, `state`, `user_id`) VALUES
	(1, '2017-02-22 11:53:07', '2017-02-22 11:53:07', '192.168.199.208', 1, 1),
	(2, '2017-02-22 11:57:35', '2017-02-22 11:57:35', '192.168.199.208', 1, 1);
/*!40000 ALTER TABLE `sys_user_login_log` ENABLE KEYS */;


-- 导出  表 adminstore.sys_user_role 结构
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `alias` varchar(255) DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `isSystem` bit(1) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.sys_user_role 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
REPLACE INTO `sys_user_role` (`id`, `addDate`, `lastDate`, `alias`, `catalog`, `description`, `isSystem`, `name`) VALUES
	(1, '2017-02-22 11:59:43', '2017-02-22 11:59:43', '管理员', 1, '后台的超级管理员', b'1', 'admin');
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;


-- 导出  表 adminstore.sys_user_role_authority 结构
DROP TABLE IF EXISTS `sys_user_role_authority`;
CREATE TABLE IF NOT EXISTS `sys_user_role_authority` (
  `role_id` bigint(20) NOT NULL,
  `permission` varchar(100) DEFAULT NULL,
  KEY `FK831pgrqk3uemmfgm1u55o1oly` (`role_id`),
  CONSTRAINT `FK831pgrqk3uemmfgm1u55o1oly` FOREIGN KEY (`role_id`) REFERENCES `sys_user_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.sys_user_role_authority 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_user_role_authority` DISABLE KEYS */;
REPLACE INTO `sys_user_role_authority` (`role_id`, `permission`) VALUES
	(1, '2'),
	(1, 'menu:list'),
	(1, 'role:list');
/*!40000 ALTER TABLE `sys_user_role_authority` ENABLE KEYS */;


-- 导出  表 adminstore.sys_user_role_links 结构
DROP TABLE IF EXISTS `sys_user_role_links`;
CREATE TABLE IF NOT EXISTS `sys_user_role_links` (
  `user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`roles_id`),
  KEY `FKjs7bulftjcyvg4law45typ5v4` (`roles_id`),
  CONSTRAINT `FKjs7bulftjcyvg4law45typ5v4` FOREIGN KEY (`roles_id`) REFERENCES `sys_user_role` (`id`),
  CONSTRAINT `FKors5gr65efwj93j0yxk4u02j7` FOREIGN KEY (`user_id`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.sys_user_role_links 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_user_role_links` DISABLE KEYS */;
REPLACE INTO `sys_user_role_links` (`user_id`, `roles_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `sys_user_role_links` ENABLE KEYS */;


-- 导出  表 adminstore.user_code 结构
DROP TABLE IF EXISTS `user_code`;
CREATE TABLE IF NOT EXISTS `user_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `loginSize` int(11) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhl59ydgsrne3klfrm0qa3kv90` (`userid`),
  CONSTRAINT `FKhl59ydgsrne3klfrm0qa3kv90` FOREIGN KEY (`userid`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_code 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_code` ENABLE KEYS */;


-- 导出  表 adminstore.user_device 结构
DROP TABLE IF EXISTS `user_device`;
CREATE TABLE IF NOT EXISTS `user_device` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `catalog` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `times` int(11) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj1l1y3ohj369aq3u6gb7fr6p7` (`userid`),
  CONSTRAINT `FKj1l1y3ohj369aq3u6gb7fr6p7` FOREIGN KEY (`userid`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_device 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_device` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_device` ENABLE KEYS */;


-- 导出  表 adminstore.user_feedback 结构
DROP TABLE IF EXISTS `user_feedback`;
CREATE TABLE IF NOT EXISTS `user_feedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `contents` varchar(5000) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `exts` varchar(5000) DEFAULT NULL,
  `feedContent` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjophgaybnc4xcgxybd71q3toj` (`userid`),
  CONSTRAINT `FKjophgaybnc4xcgxybd71q3toj` FOREIGN KEY (`userid`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_feedback 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_feedback` ENABLE KEYS */;


-- 导出  表 adminstore.user_follow 结构
DROP TABLE IF EXISTS `user_follow`;
CREATE TABLE IF NOT EXISTS `user_follow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `followid` bigint(20) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKok5m3y3tqfk4hte82xa0s2twh` (`followid`),
  KEY `FKavvn2n1cv6qqxh1t2c49m7ta7` (`userid`),
  CONSTRAINT `FKavvn2n1cv6qqxh1t2c49m7ta7` FOREIGN KEY (`userid`) REFERENCES `sys_user_info` (`id`),
  CONSTRAINT `FKok5m3y3tqfk4hte82xa0s2twh` FOREIGN KEY (`followid`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_follow 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_follow` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_follow` ENABLE KEYS */;


-- 导出  表 adminstore.user_friend 结构
DROP TABLE IF EXISTS `user_friend`;
CREATE TABLE IF NOT EXISTS `user_friend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `friendid` bigint(20) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKng9pd4bqcnmpxow28v6aerdnb` (`friendid`),
  KEY `FKa3tlib4de0iog0m2nyqknoj4e` (`userid`),
  CONSTRAINT `FKa3tlib4de0iog0m2nyqknoj4e` FOREIGN KEY (`userid`) REFERENCES `sys_user_info` (`id`),
  CONSTRAINT `FKng9pd4bqcnmpxow28v6aerdnb` FOREIGN KEY (`friendid`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_friend 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_friend` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_friend` ENABLE KEYS */;


-- 导出  表 adminstore.user_friend_request 结构
DROP TABLE IF EXISTS `user_friend_request`;
CREATE TABLE IF NOT EXISTS `user_friend_request` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `friendid` bigint(20) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm5kn6kt0cp72cwebhgmbvvet4` (`friendid`),
  KEY `FKnjw6m8a3uw3umlkvno0kj5mnv` (`userid`),
  CONSTRAINT `FKm5kn6kt0cp72cwebhgmbvvet4` FOREIGN KEY (`friendid`) REFERENCES `sys_user_info` (`id`),
  CONSTRAINT `FKnjw6m8a3uw3umlkvno0kj5mnv` FOREIGN KEY (`userid`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_friend_request 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_friend_request` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_friend_request` ENABLE KEYS */;


-- 导出  表 adminstore.user_github 结构
DROP TABLE IF EXISTS `user_github`;
CREATE TABLE IF NOT EXISTS `user_github` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar_url` varchar(255) DEFAULT NULL,
  `blog` varchar(255) DEFAULT NULL,
  `collaborators` int(11) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `disk_usage` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `events_url` varchar(255) DEFAULT NULL,
  `followers` int(11) DEFAULT NULL,
  `followers_url` varchar(255) DEFAULT NULL,
  `following` int(11) DEFAULT NULL,
  `following_url` varchar(255) DEFAULT NULL,
  `gists_url` varchar(255) DEFAULT NULL,
  `gravatar_id` varchar(255) DEFAULT NULL,
  `html_url` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `organizations_url` varchar(255) DEFAULT NULL,
  `owned_private_repos` int(11) DEFAULT NULL,
  `private_gists` int(11) DEFAULT NULL,
  `public_gists` int(11) DEFAULT NULL,
  `public_repos` int(11) DEFAULT NULL,
  `received_events_url` varchar(255) DEFAULT NULL,
  `repos_url` varchar(255) DEFAULT NULL,
  `site_admin` varchar(255) DEFAULT NULL,
  `starred_url` varchar(255) DEFAULT NULL,
  `subscriptions_url` varchar(255) DEFAULT NULL,
  `total_private_repos` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbxnb0ygb4ef60ud3voqene56q` (`userid`),
  CONSTRAINT `FKbxnb0ygb4ef60ud3voqene56q` FOREIGN KEY (`userid`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_github 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_github` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_github` ENABLE KEYS */;


-- 导出  表 adminstore.user_message 结构
DROP TABLE IF EXISTS `user_message`;
CREATE TABLE IF NOT EXISTS `user_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `subject_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKprww0bw44m48y4xxbkv13u5g7` (`subject_id`),
  KEY `FK843q4824idh2vkngwwamvidel` (`user_id`),
  CONSTRAINT `FK843q4824idh2vkngwwamvidel` FOREIGN KEY (`user_id`) REFERENCES `sys_user_info` (`id`),
  CONSTRAINT `FKprww0bw44m48y4xxbkv13u5g7` FOREIGN KEY (`subject_id`) REFERENCES `user_message_subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_message 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_message` ENABLE KEYS */;


-- 导出  表 adminstore.user_message_member 结构
DROP TABLE IF EXISTS `user_message_member`;
CREATE TABLE IF NOT EXISTS `user_message_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `nums` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `subjectid` bigint(20) DEFAULT NULL,
  `uid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq810ie1390jw6r2umbsvtpusf` (`subjectid`),
  KEY `FKik0cncmywqgej7e1memege57i` (`uid`),
  CONSTRAINT `FKik0cncmywqgej7e1memege57i` FOREIGN KEY (`uid`) REFERENCES `sys_user_info` (`id`),
  CONSTRAINT `FKq810ie1390jw6r2umbsvtpusf` FOREIGN KEY (`subjectid`) REFERENCES `user_message_subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_message_member 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_message_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_message_member` ENABLE KEYS */;


-- 导出  表 adminstore.user_message_subject 结构
DROP TABLE IF EXISTS `user_message_subject`;
CREATE TABLE IF NOT EXISTS `user_message_subject` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `lastMessage` varchar(255) DEFAULT NULL,
  `members` int(11) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `uid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK91f6ad7nyqokfft2mxq3oc79g` (`uid`),
  CONSTRAINT `FK91f6ad7nyqokfft2mxq3oc79g` FOREIGN KEY (`uid`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_message_subject 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_message_subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_message_subject` ENABLE KEYS */;


-- 导出  表 adminstore.user_notification 结构
DROP TABLE IF EXISTS `user_notification`;
CREATE TABLE IF NOT EXISTS `user_notification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `clicks` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `imageType` int(11) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `nums` int(11) DEFAULT NULL,
  `taxonomy` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `top` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `authorid` bigint(20) DEFAULT NULL,
  `catalogid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgyrdi6od1ol1b89rv6cjmegw8` (`authorid`),
  KEY `FK25yxc2g4kt2wk510uy05nr10f` (`catalogid`),
  CONSTRAINT `FK25yxc2g4kt2wk510uy05nr10f` FOREIGN KEY (`catalogid`) REFERENCES `user_notification_catalog` (`id`),
  CONSTRAINT `FKgyrdi6od1ol1b89rv6cjmegw8` FOREIGN KEY (`authorid`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_notification 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_notification` ENABLE KEYS */;


-- 导出  表 adminstore.user_notification_catalog 结构
DROP TABLE IF EXISTS `user_notification_catalog`;
CREATE TABLE IF NOT EXISTS `user_notification_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelinfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortnum` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `system` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgftt45f6mnajuk0k4c8aya4ew` (`pid`),
  CONSTRAINT `FKgftt45f6mnajuk0k4c8aya4ew` FOREIGN KEY (`pid`) REFERENCES `user_notification_catalog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_notification_catalog 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_notification_catalog` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_notification_catalog` ENABLE KEYS */;


-- 导出  表 adminstore.user_notification_member 结构
DROP TABLE IF EXISTS `user_notification_member`;
CREATE TABLE IF NOT EXISTS `user_notification_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `notificationid` bigint(20) DEFAULT NULL,
  `uid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKolldeppu9xw9we1jwgcvpc6m7` (`notificationid`),
  KEY `FKnjtrfb6q35ja368lkcl1fwume` (`uid`),
  CONSTRAINT `FKnjtrfb6q35ja368lkcl1fwume` FOREIGN KEY (`uid`) REFERENCES `sys_user_info` (`id`),
  CONSTRAINT `FKolldeppu9xw9we1jwgcvpc6m7` FOREIGN KEY (`notificationid`) REFERENCES `user_notification` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_notification_member 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_notification_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_notification_member` ENABLE KEYS */;


-- 导出  表 adminstore.user_notification_num 结构
DROP TABLE IF EXISTS `user_notification_num`;
CREATE TABLE IF NOT EXISTS `user_notification_num` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `mid` bigint(20) DEFAULT NULL,
  `uid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK70rnp6y24q70m5px6hvjmjoh3` (`uid`),
  CONSTRAINT `FK70rnp6y24q70m5px6hvjmjoh3` FOREIGN KEY (`uid`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_notification_num 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_notification_num` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_notification_num` ENABLE KEYS */;


-- 导出  表 adminstore.user_notification_time 结构
DROP TABLE IF EXISTS `user_notification_time`;
CREATE TABLE IF NOT EXISTS `user_notification_time` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `uid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3y342m36l9l8l79adp3taic3k` (`uid`),
  CONSTRAINT `FK3y342m36l9l8l79adp3taic3k` FOREIGN KEY (`uid`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_notification_time 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_notification_time` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_notification_time` ENABLE KEYS */;


-- 导出  表 adminstore.user_oauth_info_oschina 结构
DROP TABLE IF EXISTS `user_oauth_info_oschina`;
CREATE TABLE IF NOT EXISTS `user_oauth_info_oschina` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpsmg1gm8l8oelyb0bcvfcowhl` (`userid`),
  CONSTRAINT `FKpsmg1gm8l8oelyb0bcvfcowhl` FOREIGN KEY (`userid`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_oauth_info_oschina 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_oauth_info_oschina` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_oauth_info_oschina` ENABLE KEYS */;


-- 导出  表 adminstore.user_oauth_info_qq 结构
DROP TABLE IF EXISTS `user_oauth_info_qq`;
CREATE TABLE IF NOT EXISTS `user_oauth_info_qq` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `access_token` varchar(255) DEFAULT NULL,
  `appid` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `figureurl` varchar(255) DEFAULT NULL,
  `figureurl1` varchar(255) DEFAULT NULL,
  `figureurl2` varchar(255) DEFAULT NULL,
  `figureurl_qq_1` varchar(255) DEFAULT NULL,
  `figureurl_qq_2` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `yellow_vip` int(11) DEFAULT NULL,
  `yellow_year_vip` int(11) DEFAULT NULL,
  `level_info` int(11) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `ret` int(11) DEFAULT NULL,
  `vip` int(11) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `yellow_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_oauth_info_qq 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_oauth_info_qq` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_oauth_info_qq` ENABLE KEYS */;


-- 导出  表 adminstore.user_oauth_info_weibo 结构
DROP TABLE IF EXISTS `user_oauth_info_weibo`;
CREATE TABLE IF NOT EXISTS `user_oauth_info_weibo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar_hd` varchar(255) DEFAULT NULL,
  `avatar_large` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `cover_image_phone` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `domain` varchar(255) DEFAULT NULL,
  `favourites_count` int(11) DEFAULT NULL,
  `followers_count` int(11) DEFAULT NULL,
  `friends_count` int(11) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `idstr` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pagefriends_count` int(11) DEFAULT NULL,
  `profile_image_url` varchar(255) DEFAULT NULL,
  `profile_url` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `screen_name` varchar(255) DEFAULT NULL,
  `statuses_count` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `weihao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_oauth_info_weibo 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_oauth_info_weibo` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_oauth_info_weibo` ENABLE KEYS */;


-- 导出  表 adminstore.user_oauth_info_weixin 结构
DROP TABLE IF EXISTS `user_oauth_info_weixin`;
CREATE TABLE IF NOT EXISTS `user_oauth_info_weixin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `access_token` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `headimgurl` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `unionid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_oauth_info_weixin 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_oauth_info_weixin` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_oauth_info_weixin` ENABLE KEYS */;


-- 导出  表 adminstore.user_oauth_token 结构
DROP TABLE IF EXISTS `user_oauth_token`;
CREATE TABLE IF NOT EXISTS `user_oauth_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `access_token` varchar(255) DEFAULT NULL,
  `expires_in` bigint(20) DEFAULT NULL,
  `loginSize` int(11) DEFAULT NULL,
  `refresh_token` varchar(255) DEFAULT NULL,
  `token_type` varchar(255) DEFAULT NULL,
  `uid` varchar(255) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK652cq94oppkulkshghmjiudci` (`userid`),
  CONSTRAINT `FK652cq94oppkulkshghmjiudci` FOREIGN KEY (`userid`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_oauth_token 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_oauth_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_oauth_token` ENABLE KEYS */;


-- 导出  表 adminstore.user_token 结构
DROP TABLE IF EXISTS `user_token`;
CREATE TABLE IF NOT EXISTS `user_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK78jw8we5cvtlg3ggeotefnfi2` (`userid`),
  CONSTRAINT `FK78jw8we5cvtlg3ggeotefnfi2` FOREIGN KEY (`userid`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_token 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_token` ENABLE KEYS */;


-- 导出  表 adminstore.user_verification 结构
DROP TABLE IF EXISTS `user_verification`;
CREATE TABLE IF NOT EXISTS `user_verification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  adminstore.user_verification 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_verification` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_verification` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
