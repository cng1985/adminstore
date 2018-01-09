-- --------------------------------------------------------
-- 主机:                           192.168.0.199
-- 服务器版本:                        5.7.10-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5168
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 adminstore.area 结构
DROP TABLE IF EXISTS `area`;
CREATE TABLE IF NOT EXISTS `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `geo` varchar(255) DEFAULT NULL,
  `govCode` varchar(12) DEFAULT NULL,
  `lat` float DEFAULT NULL,
  `lng` float DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `area_type` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtn7all8h9e6fi9pspra60rht5` (`pid`),
  CONSTRAINT `FKtn7all8h9e6fi9pspra60rht5` FOREIGN KEY (`pid`) REFERENCES `area` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.area 的数据：~0 rows (大约)
DELETE FROM `area`;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
/*!40000 ALTER TABLE `area` ENABLE KEYS */;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.config_data_version 的数据：~0 rows (大约)
DELETE FROM `config_data_version`;
/*!40000 ALTER TABLE `config_data_version` DISABLE KEYS */;
/*!40000 ALTER TABLE `config_data_version` ENABLE KEYS */;

-- 导出  表 adminstore.flow_define 结构
DROP TABLE IF EXISTS `flow_define`;
CREATE TABLE IF NOT EXISTS `flow_define` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.flow_define 的数据：~0 rows (大约)
DELETE FROM `flow_define`;
/*!40000 ALTER TABLE `flow_define` DISABLE KEYS */;
/*!40000 ALTER TABLE `flow_define` ENABLE KEYS */;

-- 导出  表 adminstore.menu 结构
DROP TABLE IF EXISTS `menu`;
CREATE TABLE IF NOT EXISTS `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `nums` bigint(20) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqcf9gem97gqa5qjm4d3elcqt5` (`pid`),
  CONSTRAINT `FKqcf9gem97gqa5qjm4d3elcqt5` FOREIGN KEY (`pid`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.menu 的数据：~28 rows (大约)
DELETE FROM `menu`;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `catalog`, `icon`, `nums`, `path`, `permission`, `pid`) VALUES
	(1, '2017-09-25 14:25:39', '', '1', '2017-09-25 14:25:39', 1, 1, '根节点', 64, 0, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '2017-11-09 14:19:34', NULL, '1,2', '2017-11-09 14:19:34', 2, 2, '系统设置', 21, 55, 0, 'fa  fa-gear', 0, '', '2', 1),
	(3, '2017-09-25 14:34:37', NULL, '1,2,3', '2017-09-25 14:34:37', 3, 3, '菜单管理', 4, 0, 0, 'fa  fa-reorder', 0, 'admin/menu/view_list.htm', 'menu', 2),
	(4, '2017-09-25 14:36:59', NULL, '1,2,4', '2017-09-25 14:36:59', 3, 5, '角色管理', 6, 0, 0, 'fa  fa-tree', 0, 'admin/userrole/view_list.htm', 'userrole', 2),
	(5, '2017-09-25 14:38:29', NULL, '1,2,5', '2017-09-25 14:38:29', 3, 7, '第三方登陆配置', 8, 0, 0, 'fa  fa-connectdevelop', 0, 'admin/useroauthconfig/view_list.htm', 'useroauthconfig', 2),
	(6, '2017-09-25 14:35:30', NULL, '1,2,6', '2017-09-25 14:35:30', 3, 9, '友情链接分类管理', 10, 0, 0, 'fa  fa-link', 0, 'admin/linktype/view_list.htm', 'linktype', 2),
	(7, '2017-09-25 14:37:37', NULL, '1,2,7', '2017-09-25 14:37:37', 3, 11, '友情链接管理', 12, 0, 0, 'fa  fa-link', 0, 'admin/link/view_list.htm', 'link', 2),
	(8, '2017-09-25 14:48:04', NULL, '1,2,8', '2017-09-25 14:48:04', 3, 13, '角色分类配置', 14, 0, 0, 'fa  fa-user-secret', 0, 'admin/userrolecatalog/view_list.htm', 'userrolecatalog', 2),
	(9, '2017-09-25 14:47:35', NULL, '1,2,9', '2017-09-25 14:47:35', 3, 15, '移动app配置', 16, 0, 0, 'fa  fa-life-ring', 0, 'admin/app/view_list.htm', 'app', 2),
	(10, '2017-09-25 15:22:17', NULL, '1,2,10', '2017-09-25 15:22:17', 3, 17, '网站主题配置', 18, 0, 0, 'fa  fa-sitemap', 0, 'admin/theme.htm', '10', 2),
	(11, '2017-09-26 10:34:40', NULL, '1,2,11', '2017-09-26 10:34:40', 3, 19, '模板管理', 20, NULL, 0, 'fa fa-circle-o', NULL, 'admin/tmpl/view_list.htm', 'tmpl', 2),
	(12, '2018-01-09 09:20:21', NULL, '1,12', '2018-01-09 09:20:21', 2, 22, '流程管理', 29, 1, 0, 'fa  fa-suitcase', 0, '', '12', 1),
	(13, '2018-01-09 09:21:57', NULL, '1,12,13', '2018-01-09 09:21:57', 3, 23, '工作流管理', 24, 0, 0, 'fa  fa-archive', 0, 'admin/flow/view_list.htm', 'flow', 12),
	(14, '2018-01-09 09:22:23', NULL, '1,12,14', '2018-01-09 09:22:23', 3, 25, '模型管理', 26, 88, 0, 'fa  fa-cubes', 0, 'admin/flowdefine/view_list.htm', 'flowdefine', 12),
	(15, '2017-12-27 14:04:35', NULL, '1,15', '2017-12-27 14:04:35', 2, 30, '服务插件管理', 37, 2, 0, 'fa  fa-cloud', 0, '', '15', 1),
	(16, '2017-12-27 14:07:09', NULL, '1,15,16', '2017-12-27 14:07:09', 3, 31, '验证码插件配置', 32, 0, 0, 'fa  fa-commenting-o', 0, 'admin/sendcode_plugin/list.htm', 'sendcode_plugin', 15),
	(17, '2017-12-27 14:05:23', NULL, '1,15,17', '2017-12-27 14:05:23', 3, 33, '存储插件配置', 34, 0, 0, 'fa  fa-cloud-upload', 0, 'admin/storage_plugin/list.htm', 'storage_plugin', 15),
	(18, '2017-11-09 09:03:05', NULL, '1,15,18', '2017-11-09 09:03:05', 3, 35, '推送插件配置', 36, NULL, 0, 'fa fa-circle-o', NULL, 'admin/push_plugin/list.htm', 'push_plugin', 15),
	(19, '2017-12-27 14:04:52', NULL, '1,19', '2017-12-27 14:04:52', 2, 38, '控制台', 39, 0, 0, 'fa fa-home', 0, 'admin/index.htm', '19', 1),
	(20, '2017-12-27 14:19:54', NULL, '1,20', '2017-12-27 14:19:54', 2, 40, '用户管理', 47, 0, 0, 'fa  fa-users', 0, '', '20', 1),
	(21, '2017-12-27 14:27:31', NULL, '1,20,21', '2017-12-27 14:27:31', 3, 41, '用户管理', 42, 0, 0, 'fa fa-user', 0, 'admin/member/view_list.htm', 'member', 20),
	(22, '2017-12-27 14:20:51', NULL, '1,20,22', '2017-12-27 14:20:51', 3, 43, '账号管理', 44, 0, 0, 'fa fa-list', 0, 'admin/useraccount/view_list.htm', 'useraccount', 20),
	(23, '2017-12-27 15:05:28', NULL, '1,20,23', '2017-12-27 15:05:28', 3, 45, '登陆日志', 46, 0, 0, 'fa fa-support', 0, 'admin/userloginlog/view_list.htm', 'userloginlog', 20),
	(24, '2018-01-02 09:50:50', NULL, '1,24', '2018-01-02 09:50:50', 2, 48, '定时任务管理', 55, 10, 0, 'fa  fa-tasks', 0, '', '24', 1),
	(25, '2018-01-02 09:52:43', NULL, '1,24,25', '2018-01-02 09:52:43', 3, 49, '任务管理', 50, 2, 0, 'fa   fa-list-ol', 0, 'admin/crontask/view_list.htm', 'crontask', 24),
	(26, '2018-01-02 09:53:02', NULL, '1,24,26', '2018-01-02 09:53:02', 3, 51, '控制台', 52, 0, 0, 'fa fa-dashboard', 0, 'admin/crontask/index.htm', '26', 24),
	(27, '2018-01-02 09:55:43', NULL, '1,24,27', '2018-01-02 09:55:43', 3, 53, '运行记录', 54, 3, 0, 'fa fa-reorder', 0, 'admin/crontaskrecord/view_list.htm', 'crontaskrecord', 24),
	(28, '2018-01-02 10:52:14', NULL, '1,28', '2018-01-02 10:52:14', 2, 56, '通知管理', 63, 5, 0, 'fa fa fa-envelope', 0, '', '28', 1),
	(29, '2018-01-02 12:09:50', NULL, '1,28,29', '2018-01-02 12:09:50', 3, 57, '收件箱', 58, 0, 0, '', 0, 'admin/usernotificationmember/view_list.htm', 'usernotificationmember', 28),
	(30, '2018-01-02 11:03:31', NULL, '1,28,30', '2018-01-02 11:03:31', 3, 59, '通知分类', 60, 0, 0, '', 0, 'admin/usernotificationcatalog/view_list.htm', 'usernotificationcatalog', 28),
	(31, '2018-01-02 11:03:35', NULL, '1,28,31', '2018-01-02 11:03:35', 3, 61, '通知管理', 62, 0, 0, '', 0, 'admin/usernotification/view_list.htm', 'usernotification', 28),
	(32, '2018-01-09 09:20:52', NULL, '1,12,32', '2018-01-09 09:20:52', 3, 27, '审批任务', 28, 111, 0, 'fa  fa-tasks', 0, 'admin/flow/task_list_all.htm', '32', 12);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

-- 导出  表 adminstore.plugin_config 结构
DROP TABLE IF EXISTS `plugin_config`;
CREATE TABLE IF NOT EXISTS `plugin_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `isEnabled` bit(1) NOT NULL,
  `pluginId` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_d80yc0eis8aaqm59fnxc5rs0l` (`pluginId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.plugin_config 的数据：~0 rows (大约)
DELETE FROM `plugin_config`;
/*!40000 ALTER TABLE `plugin_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `plugin_config` ENABLE KEYS */;

-- 导出  表 adminstore.plugin_config_attribute 结构
DROP TABLE IF EXISTS `plugin_config_attribute`;
CREATE TABLE IF NOT EXISTS `plugin_config_attribute` (
  `PluginConfig_id` bigint(20) NOT NULL,
  `attributes` varchar(255) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`PluginConfig_id`,`name`),
  CONSTRAINT `FK9s4k66fykxc5x1oo58bg0ku82` FOREIGN KEY (`PluginConfig_id`) REFERENCES `plugin_config` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.plugin_config_attribute 的数据：~0 rows (大约)
DELETE FROM `plugin_config_attribute`;
/*!40000 ALTER TABLE `plugin_config_attribute` DISABLE KEYS */;
/*!40000 ALTER TABLE `plugin_config_attribute` ENABLE KEYS */;

-- 导出  表 adminstore.site_app 结构
DROP TABLE IF EXISTS `site_app`;
CREATE TABLE IF NOT EXISTS `site_app` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `appKey` varchar(255) DEFAULT NULL,
  `appSecret` varchar(255) DEFAULT NULL,
  `counts` bigint(20) DEFAULT NULL,
  `downUrl` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `packageName` varchar(255) DEFAULT NULL,
  `system` varchar(255) DEFAULT NULL,
  `versionCode` int(11) DEFAULT NULL,
  `versionName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_jfx5shexfh9lo32836m2t62ga` (`packageName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.site_app 的数据：~0 rows (大约)
DELETE FROM `site_app`;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.site_app_version 的数据：~0 rows (大约)
DELETE FROM `site_app_version`;
/*!40000 ALTER TABLE `site_app_version` DISABLE KEYS */;
/*!40000 ALTER TABLE `site_app_version` ENABLE KEYS */;

-- 导出  表 adminstore.site_config 结构
DROP TABLE IF EXISTS `site_config`;
CREATE TABLE IF NOT EXISTS `site_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `domainName` varchar(255) DEFAULT NULL,
  `favicon` varchar(255) DEFAULT NULL,
  `icp` varchar(255) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `pageSize` int(11) DEFAULT NULL,
  `shortName` varchar(255) DEFAULT NULL,
  `theme` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.site_config 的数据：~0 rows (大约)
DELETE FROM `site_config`;
/*!40000 ALTER TABLE `site_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `site_config` ENABLE KEYS */;

-- 导出  表 adminstore.site_link 结构
DROP TABLE IF EXISTS `site_link`;
CREATE TABLE IF NOT EXISTS `site_link` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `target` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `linkType_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1316ht5o7bmu4jbixoso45paa` (`linkType_id`),
  CONSTRAINT `FK1316ht5o7bmu4jbixoso45paa` FOREIGN KEY (`linkType_id`) REFERENCES `site_link_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.site_link 的数据：~0 rows (大约)
DELETE FROM `site_link`;
/*!40000 ALTER TABLE `site_link` DISABLE KEYS */;
/*!40000 ALTER TABLE `site_link` ENABLE KEYS */;

-- 导出  表 adminstore.site_link_type 结构
DROP TABLE IF EXISTS `site_link_type`;
CREATE TABLE IF NOT EXISTS `site_link_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsve8aryqrci3acgot8k7rt6ix` (`pid`),
  CONSTRAINT `FKsve8aryqrci3acgot8k7rt6ix` FOREIGN KEY (`pid`) REFERENCES `site_link_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.site_link_type 的数据：~2 rows (大约)
DELETE FROM `site_link_type`;
/*!40000 ALTER TABLE `site_link_type` DISABLE KEYS */;
INSERT INTO `site_link_type` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `pid`) VALUES
	(1, '2017-12-27 13:59:20', '', '1', '2017-12-27 13:59:20', 1, 1, '根节点', 6, 0, NULL),
	(2, '2017-12-29 08:52:53', '001', '1,2', '2017-12-29 08:52:53', 2, 2, '开源网站', 3, NULL, 1),
	(3, '2017-12-29 08:53:07', '002', '1,3', '2017-12-29 08:53:07', 2, 4, '朋友网站', 5, NULL, 1);
/*!40000 ALTER TABLE `site_link_type` ENABLE KEYS */;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.site_template_web 的数据：~0 rows (大约)
DELETE FROM `site_template_web`;
/*!40000 ALTER TABLE `site_template_web` DISABLE KEYS */;
/*!40000 ALTER TABLE `site_template_web` ENABLE KEYS */;

-- 导出  表 adminstore.site_theme_config 结构
DROP TABLE IF EXISTS `site_theme_config`;
CREATE TABLE IF NOT EXISTS `site_theme_config` (
  `id` varchar(255) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `path` varchar(20) DEFAULT NULL,
  `screenShot` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.site_theme_config 的数据：~0 rows (大约)
DELETE FROM `site_theme_config`;
/*!40000 ALTER TABLE `site_theme_config` DISABLE KEYS */;
INSERT INTO `site_theme_config` (`id`, `name`, `path`, `screenShot`) VALUES
	('default', NULL, NULL, NULL);
/*!40000 ALTER TABLE `site_theme_config` ENABLE KEYS */;

-- 导出  表 adminstore.task 结构
DROP TABLE IF EXISTS `task`;
CREATE TABLE IF NOT EXISTS `task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `cron` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `nums` bigint(20) DEFAULT NULL,
  `recordState` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqpj60iiafuf9b7dh5xtxoeusw` (`user_id`),
  CONSTRAINT `FKqpj60iiafuf9b7dh5xtxoeusw` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.task 的数据：~0 rows (大约)
DELETE FROM `task`;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` (`id`, `addDate`, `lastDate`, `cron`, `name`, `note`, `nums`, `recordState`, `state`, `url`, `user_id`) VALUES
	(1, '2018-01-09 09:31:46', '2018-01-09 09:32:05', '*/5 * * * * ?', '测试访问网站', 'sssss', 606, 4, 0, 'http://www.yichisancun.com/', NULL);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;

-- 导出  表 adminstore.task_attribute 结构
DROP TABLE IF EXISTS `task_attribute`;
CREATE TABLE IF NOT EXISTS `task_attribute` (
  `task_id` bigint(20) NOT NULL,
  `attr` varchar(100) DEFAULT NULL,
  `name` varchar(36) NOT NULL,
  PRIMARY KEY (`task_id`,`name`),
  CONSTRAINT `FKkkpewueys70bcx84x9yd2dsec` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.task_attribute 的数据：~0 rows (大约)
DELETE FROM `task_attribute`;
/*!40000 ALTER TABLE `task_attribute` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_attribute` ENABLE KEYS */;

-- 导出  表 adminstore.task_record 结构
DROP TABLE IF EXISTS `task_record`;
CREATE TABLE IF NOT EXISTS `task_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `expensesTime` bigint(20) DEFAULT NULL,
  `note` varchar(20) DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhcsb7k9mkjpq63wpmfopg0tty` (`task_id`),
  CONSTRAINT `FKhcsb7k9mkjpq63wpmfopg0tty` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.task_record 的数据：~0 rows (大约)
DELETE FROM `task_record`;
/*!40000 ALTER TABLE `task_record` DISABLE KEYS */;
INSERT INTO `task_record` (`id`, `addDate`, `lastDate`, `expensesTime`, `note`, `task_id`) VALUES
	(1, '2018-01-09 09:32:01', '2018-01-09 09:32:01', 541, '', 1),
	(2, '2018-01-09 09:32:01', '2018-01-09 09:32:01', 407, '', 1),
	(3, '2018-01-09 09:32:01', '2018-01-09 09:32:01', 290, '', 1),
	(4, '2018-01-09 09:32:05', '2018-01-09 09:32:05', 293, '', 1);
/*!40000 ALTER TABLE `task_record` ENABLE KEYS */;

-- 导出  表 adminstore.user_account 结构
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE IF NOT EXISTS `user_account` (
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
  KEY `FKloyhlvrn82g8811wyjaa8ehm0` (`user_id`),
  CONSTRAINT `FKloyhlvrn82g8811wyjaa8ehm0` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_account 的数据：~1 rows (大约)
DELETE FROM `user_account`;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` (`id`, `addDate`, `lastDate`, `accountType`, `loginSize`, `password`, `salt`, `username`, `user_id`) VALUES
	(1, '2017-12-27 13:53:50', '2018-01-09 09:31:16', 2, 109, 'b63e05a75d3c13c53becedeb885bda5b67a6664a', 'e1e8c5fab5a28e13', 'admin', 1);
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;

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
  KEY `FKfjxq06hj1obi36glqqlbimt4g` (`userid`),
  CONSTRAINT `FKfjxq06hj1obi36glqqlbimt4g` FOREIGN KEY (`userid`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_feedback 的数据：~0 rows (大约)
DELETE FROM `user_feedback`;
/*!40000 ALTER TABLE `user_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_feedback` ENABLE KEYS */;

-- 导出  表 adminstore.user_info 结构
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE IF NOT EXISTS `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `loginSize` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `registerType` varchar(20) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `edge` varchar(255) DEFAULT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `household_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3193uu2asgocbhkk1mus5wfd7` (`household_id`),
  CONSTRAINT `FK3193uu2asgocbhkk1mus5wfd7` FOREIGN KEY (`household_id`) REFERENCES `area` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1221 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_info 的数据：~2 rows (大约)
DELETE FROM `user_info`;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` (`id`, `addDate`, `lastDate`, `avatar`, `catalog`, `loginSize`, `name`, `phone`, `registerType`, `state`, `edge`, `introduce`, `note`, `sex`, `household_id`) VALUES
	(1, '2017-12-27 14:44:05', '2018-01-09 09:31:16', NULL, 0, 151, 'admin', NULL, '账号', NULL, NULL, NULL, NULL, NULL, NULL),
	(1220, '2018-01-04 14:17:41', '2018-01-04 14:17:41', NULL, 0, 0, '测更', NULL, '账号', NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;

-- 导出  表 adminstore.user_info_attribute 结构
DROP TABLE IF EXISTS `user_info_attribute`;
CREATE TABLE IF NOT EXISTS `user_info_attribute` (
  `user_id` bigint(20) NOT NULL,
  `attr` varchar(100) DEFAULT NULL,
  `name` varchar(36) NOT NULL,
  PRIMARY KEY (`user_id`,`name`),
  CONSTRAINT `FKjf8g1vng9lpmniy8u187j7t0` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_info_attribute 的数据：~0 rows (大约)
DELETE FROM `user_info_attribute`;
/*!40000 ALTER TABLE `user_info_attribute` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_info_attribute` ENABLE KEYS */;

-- 导出  表 adminstore.user_label 结构
DROP TABLE IF EXISTS `user_label`;
CREATE TABLE IF NOT EXISTS `user_label` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_cal21cv5bdi7ee791jvtvji3t` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_label 的数据：~0 rows (大约)
DELETE FROM `user_label`;
/*!40000 ALTER TABLE `user_label` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_label` ENABLE KEYS */;

-- 导出  表 adminstore.user_label_links 结构
DROP TABLE IF EXISTS `user_label_links`;
CREATE TABLE IF NOT EXISTS `user_label_links` (
  `user_id` bigint(20) NOT NULL,
  `labels_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`labels_id`),
  KEY `FKe69vxi1aiq7ww12d8pf03hrn1` (`labels_id`),
  CONSTRAINT `FK5njpwjktgb87ggnjm63vejdwc` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`),
  CONSTRAINT `FKe69vxi1aiq7ww12d8pf03hrn1` FOREIGN KEY (`labels_id`) REFERENCES `user_label` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_label_links 的数据：~0 rows (大约)
DELETE FROM `user_label_links`;
/*!40000 ALTER TABLE `user_label_links` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_label_links` ENABLE KEYS */;

-- 导出  表 adminstore.user_login_log 结构
DROP TABLE IF EXISTS `user_login_log`;
CREATE TABLE IF NOT EXISTS `user_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj91w0nnfocpdp796lr3ot4lxs` (`user_id`),
  CONSTRAINT `FKj91w0nnfocpdp796lr3ot4lxs` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_login_log 的数据：~0 rows (大约)
DELETE FROM `user_login_log`;
/*!40000 ALTER TABLE `user_login_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_login_log` ENABLE KEYS */;

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
  KEY `FKcu2q6axhu3g31g1vbuosec525` (`user_id`),
  CONSTRAINT `FKcu2q6axhu3g31g1vbuosec525` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`),
  CONSTRAINT `FKprww0bw44m48y4xxbkv13u5g7` FOREIGN KEY (`subject_id`) REFERENCES `user_message_subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_message 的数据：~0 rows (大约)
DELETE FROM `user_message`;
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
  KEY `FK2lven49o6lj1fnlb47lwjs9g9` (`uid`),
  CONSTRAINT `FK2lven49o6lj1fnlb47lwjs9g9` FOREIGN KEY (`uid`) REFERENCES `user_info` (`id`),
  CONSTRAINT `FKq810ie1390jw6r2umbsvtpusf` FOREIGN KEY (`subjectid`) REFERENCES `user_message_subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_message_member 的数据：~0 rows (大约)
DELETE FROM `user_message_member`;
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
  KEY `FK1i9f2ekhf4y4xk5cqwr0unb1i` (`uid`),
  CONSTRAINT `FK1i9f2ekhf4y4xk5cqwr0unb1i` FOREIGN KEY (`uid`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_message_subject 的数据：~0 rows (大约)
DELETE FROM `user_message_subject`;
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
  KEY `FKen7mn6n9j4ach4hyewfjakkg2` (`authorid`),
  KEY `FK25yxc2g4kt2wk510uy05nr10f` (`catalogid`),
  CONSTRAINT `FK25yxc2g4kt2wk510uy05nr10f` FOREIGN KEY (`catalogid`) REFERENCES `user_notification_catalog` (`id`),
  CONSTRAINT `FKen7mn6n9j4ach4hyewfjakkg2` FOREIGN KEY (`authorid`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_notification 的数据：~0 rows (大约)
DELETE FROM `user_notification`;
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
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `system` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgftt45f6mnajuk0k4c8aya4ew` (`pid`),
  CONSTRAINT `FKgftt45f6mnajuk0k4c8aya4ew` FOREIGN KEY (`pid`) REFERENCES `user_notification_catalog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_notification_catalog 的数据：~2 rows (大约)
DELETE FROM `user_notification_catalog`;
/*!40000 ALTER TABLE `user_notification_catalog` DISABLE KEYS */;
INSERT INTO `user_notification_catalog` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `icon`, `system`, `pid`) VALUES
	(1, '2018-01-02 11:02:20', '', '1', '2018-01-02 11:02:20', 1, 1, '根节点', 6, 0, NULL, NULL, NULL),
	(2, '2018-01-02 11:02:51', '001', '1,2', '2018-01-02 11:02:51', 2, 2, '系统消息', 3, NULL, NULL, NULL, 1),
	(3, '2018-01-02 11:03:03', '002', '1,3', '2018-01-02 11:03:03', 2, 4, '其他消息', 5, NULL, NULL, NULL, 1);
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
  KEY `FKlatb6olq7rthe83lg86qovdqh` (`uid`),
  KEY `FKolldeppu9xw9we1jwgcvpc6m7` (`notificationid`),
  CONSTRAINT `FKlatb6olq7rthe83lg86qovdqh` FOREIGN KEY (`uid`) REFERENCES `user_info` (`id`),
  CONSTRAINT `FKolldeppu9xw9we1jwgcvpc6m7` FOREIGN KEY (`notificationid`) REFERENCES `user_notification` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5066 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_notification_member 的数据：~0 rows (大约)
DELETE FROM `user_notification_member`;
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
  KEY `FKmi0949b37eayfjjpvv421bmvy` (`uid`),
  CONSTRAINT `FKmi0949b37eayfjjpvv421bmvy` FOREIGN KEY (`uid`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_notification_num 的数据：~0 rows (大约)
DELETE FROM `user_notification_num`;
/*!40000 ALTER TABLE `user_notification_num` DISABLE KEYS */;
INSERT INTO `user_notification_num` (`id`, `addDate`, `lastDate`, `mid`, `uid`) VALUES
	(1, '2018-01-02 15:52:12', '2018-01-09 09:23:27', 9, 1);
/*!40000 ALTER TABLE `user_notification_num` ENABLE KEYS */;

-- 导出  表 adminstore.user_notification_time 结构
DROP TABLE IF EXISTS `user_notification_time`;
CREATE TABLE IF NOT EXISTS `user_notification_time` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `uid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5co2x7rgocx6fmbfptaknqxh8` (`uid`),
  CONSTRAINT `FK5co2x7rgocx6fmbfptaknqxh8` FOREIGN KEY (`uid`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_notification_time 的数据：~0 rows (大约)
DELETE FROM `user_notification_time`;
/*!40000 ALTER TABLE `user_notification_time` DISABLE KEYS */;
INSERT INTO `user_notification_time` (`id`, `addDate`, `lastDate`, `uid`) VALUES
	(2, '2018-01-02 15:31:22', '2018-02-02 15:27:43', 1);
/*!40000 ALTER TABLE `user_notification_time` ENABLE KEYS */;

-- 导出  表 adminstore.user_oauth_config 结构
DROP TABLE IF EXISTS `user_oauth_config`;
CREATE TABLE IF NOT EXISTS `user_oauth_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `appKey` varchar(255) DEFAULT NULL,
  `appSecret` varchar(255) DEFAULT NULL,
  `className` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_oauth_config 的数据：~0 rows (大约)
DELETE FROM `user_oauth_config`;
/*!40000 ALTER TABLE `user_oauth_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_oauth_config` ENABLE KEYS */;

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
  KEY `FKhco9s5j1bhp44w3mpt19kmi21` (`userid`),
  CONSTRAINT `FKhco9s5j1bhp44w3mpt19kmi21` FOREIGN KEY (`userid`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_oauth_token 的数据：~0 rows (大约)
DELETE FROM `user_oauth_token`;
/*!40000 ALTER TABLE `user_oauth_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_oauth_token` ENABLE KEYS */;

-- 导出  表 adminstore.user_role 结构
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `alias` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `roleType` int(11) DEFAULT NULL,
  `catalog_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrwtb6ktd4x1qi6sjjiu3134a1` (`catalog_id`),
  CONSTRAINT `FKrwtb6ktd4x1qi6sjjiu3134a1` FOREIGN KEY (`catalog_id`) REFERENCES `user_role_catalog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_role 的数据：~1 rows (大约)
DELETE FROM `user_role`;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`id`, `addDate`, `lastDate`, `alias`, `description`, `name`, `roleType`, `catalog_id`) VALUES
	(1, '2018-01-09 09:14:36', '2018-01-09 09:14:36', '', '', 'admin', 0, 2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

-- 导出  表 adminstore.user_role_authority 结构
DROP TABLE IF EXISTS `user_role_authority`;
CREATE TABLE IF NOT EXISTS `user_role_authority` (
  `role_id` bigint(20) NOT NULL,
  `permission` varchar(100) DEFAULT NULL,
  KEY `FKo6xok4ngrsuacqkyjpqbykn9l` (`role_id`),
  CONSTRAINT `FKo6xok4ngrsuacqkyjpqbykn9l` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_role_authority 的数据：~31 rows (大约)
DELETE FROM `user_role_authority`;
/*!40000 ALTER TABLE `user_role_authority` DISABLE KEYS */;
INSERT INTO `user_role_authority` (`role_id`, `permission`) VALUES
	(1, '19'),
	(1, '20'),
	(1, 'member'),
	(1, 'useraccount'),
	(1, 'userloginlog'),
	(1, '12'),
	(1, 'flow'),
	(1, 'flowdefine'),
	(1, '32'),
	(1, '15'),
	(1, 'sendcode_plugin'),
	(1, 'storage_plugin'),
	(1, 'push_plugin'),
	(1, '28'),
	(1, 'usernotificationmember'),
	(1, 'usernotificationcatalog'),
	(1, 'usernotification'),
	(1, '24'),
	(1, 'crontask'),
	(1, '26'),
	(1, 'crontaskrecord'),
	(1, '2'),
	(1, 'menu'),
	(1, 'userrole'),
	(1, 'useroauthconfig'),
	(1, 'linktype'),
	(1, 'link'),
	(1, 'userrolecatalog'),
	(1, 'app'),
	(1, '10'),
	(1, 'tmpl');
/*!40000 ALTER TABLE `user_role_authority` ENABLE KEYS */;

-- 导出  表 adminstore.user_role_catalog 结构
DROP TABLE IF EXISTS `user_role_catalog`;
CREATE TABLE IF NOT EXISTS `user_role_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkk8xoshxnvrtd39dd20k4vi85` (`pid`),
  CONSTRAINT `FKkk8xoshxnvrtd39dd20k4vi85` FOREIGN KEY (`pid`) REFERENCES `user_role_catalog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_role_catalog 的数据：~2 rows (大约)
DELETE FROM `user_role_catalog`;
/*!40000 ALTER TABLE `user_role_catalog` DISABLE KEYS */;
INSERT INTO `user_role_catalog` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `pid`) VALUES
	(1, '2017-12-27 13:59:23', '', '1', '2017-12-27 13:59:23', 1, 1, '根节点', 6, 0, NULL),
	(2, '2017-12-27 13:59:42', '002', '1,2', '2017-12-27 13:59:42', 2, 2, '系统', 3, NULL, 1),
	(3, '2017-12-27 13:59:49', '001', '1,3', '2017-12-27 13:59:49', 2, 4, '自定义', 5, NULL, 1);
/*!40000 ALTER TABLE `user_role_catalog` ENABLE KEYS */;

-- 导出  表 adminstore.user_role_links 结构
DROP TABLE IF EXISTS `user_role_links`;
CREATE TABLE IF NOT EXISTS `user_role_links` (
  `user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`roles_id`),
  KEY `FKpm1oweb01msxxqf212qmd0984` (`roles_id`),
  CONSTRAINT `FK3r2sf8531lbjt40y3qjhkg2an` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`),
  CONSTRAINT `FKpm1oweb01msxxqf212qmd0984` FOREIGN KEY (`roles_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_role_links 的数据：~1 rows (大约)
DELETE FROM `user_role_links`;
/*!40000 ALTER TABLE `user_role_links` DISABLE KEYS */;
INSERT INTO `user_role_links` (`user_id`, `roles_id`) VALUES
	(1, 1),
	(1220, 1);
/*!40000 ALTER TABLE `user_role_links` ENABLE KEYS */;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_verification 的数据：~0 rows (大约)
DELETE FROM `user_verification`;
/*!40000 ALTER TABLE `user_verification` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_verification` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
