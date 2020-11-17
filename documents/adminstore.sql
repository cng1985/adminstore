-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.26 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 adminstore 的数据库结构
DROP DATABASE IF EXISTS `adminstore`;
CREATE DATABASE IF NOT EXISTS `adminstore` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `adminstore`;

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
  `fullName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtn7all8h9e6fi9pspra60rht5` (`pid`),
  CONSTRAINT `FKtn7all8h9e6fi9pspra60rht5` FOREIGN KEY (`pid`) REFERENCES `area` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.area 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT IGNORE INTO `area` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `geo`, `govCode`, `lat`, `lng`, `state`, `area_type`, `pid`, `fullName`) VALUES
	(1, '2018-07-16 15:06:35', '', '1', '2018-07-16 15:06:35', 1, 1, '根节点', 6, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '2018-12-12 21:01:37', '2', '1,2', '2018-12-12 21:01:37', 2, 2, '1', 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL),
	(3, '2019-02-17 20:51:55', '3', '1,2,3', '2019-02-17 20:51:55', 3, 3, '2', 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL);
/*!40000 ALTER TABLE `area` ENABLE KEYS */;

-- 导出  表 adminstore.area_business_circle 结构
DROP TABLE IF EXISTS `area_business_circle`;
CREATE TABLE IF NOT EXISTS `area_business_circle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `area` tinyblob,
  `lat` float DEFAULT NULL,
  `lng` float DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.area_business_circle 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `area_business_circle` DISABLE KEYS */;
/*!40000 ALTER TABLE `area_business_circle` ENABLE KEYS */;

-- 导出  表 adminstore.article 结构
DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `comments` int(11) DEFAULT NULL,
  `contents` varchar(255) DEFAULT NULL,
  `extData` varchar(255) DEFAULT NULL,
  `images` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `likes` int(11) DEFAULT NULL,
  `storeState` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `ups` int(11) DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `catalog_id` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2aptines4lfv2116021bh53gs` (`catalog_id`),
  KEY `FKgfkys9w7qv3xcubq0drrayuu3` (`user_id`),
  CONSTRAINT `FK2aptines4lfv2116021bh53gs` FOREIGN KEY (`catalog_id`) REFERENCES `article_catalog` (`id`),
  CONSTRAINT `FKgfkys9w7qv3xcubq0drrayuu3` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.article 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
/*!40000 ALTER TABLE `article` ENABLE KEYS */;

-- 导出  表 adminstore.article_catalog 结构
DROP TABLE IF EXISTS `article_catalog`;
CREATE TABLE IF NOT EXISTS `article_catalog` (
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
  `size` bigint(20) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeltrcktceyicg6so4kxa1muy5` (`pid`),
  CONSTRAINT `FKeltrcktceyicg6so4kxa1muy5` FOREIGN KEY (`pid`) REFERENCES `article_catalog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.article_catalog 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `article_catalog` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_catalog` ENABLE KEYS */;

-- 导出  表 adminstore.article_comment 结构
DROP TABLE IF EXISTS `article_comment`;
CREATE TABLE IF NOT EXISTS `article_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `contents` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `article_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKghmocqkgqs5tkmucf5putw64t` (`article_id`),
  KEY `FKq2u0dy36tq655hnhxal16of7k` (`user_id`),
  CONSTRAINT `FKghmocqkgqs5tkmucf5putw64t` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`),
  CONSTRAINT `FKq2u0dy36tq655hnhxal16of7k` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.article_comment 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `article_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_comment` ENABLE KEYS */;

-- 导出  表 adminstore.article_like 结构
DROP TABLE IF EXISTS `article_like`;
CREATE TABLE IF NOT EXISTS `article_like` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `article_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKabthli6g1qjriusniw93pbesw` (`article_id`),
  KEY `FK13bn3spxe6xfy318i80669hon` (`user_id`),
  CONSTRAINT `FK13bn3spxe6xfy318i80669hon` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`),
  CONSTRAINT `FKabthli6g1qjriusniw93pbesw` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.article_like 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `article_like` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_like` ENABLE KEYS */;

-- 导出  表 adminstore.article_link_tag 结构
DROP TABLE IF EXISTS `article_link_tag`;
CREATE TABLE IF NOT EXISTS `article_link_tag` (
  `Article_id` bigint(20) NOT NULL,
  `tags_id` bigint(20) NOT NULL,
  PRIMARY KEY (`Article_id`,`tags_id`),
  KEY `FK8cbs5lfskjdpwpae5p48um1gr` (`tags_id`),
  CONSTRAINT `FK3n4k9pr1q03p0ars5qsudil6a` FOREIGN KEY (`Article_id`) REFERENCES `article` (`id`),
  CONSTRAINT `FK8cbs5lfskjdpwpae5p48um1gr` FOREIGN KEY (`tags_id`) REFERENCES `article_tag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.article_link_tag 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `article_link_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_link_tag` ENABLE KEYS */;

-- 导出  表 adminstore.article_sensitive_category 结构
DROP TABLE IF EXISTS `article_sensitive_category`;
CREATE TABLE IF NOT EXISTS `article_sensitive_category` (
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
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6yr0lp832885ybn738e80wlp4` (`parent_id`),
  CONSTRAINT `FK6yr0lp832885ybn738e80wlp4` FOREIGN KEY (`parent_id`) REFERENCES `article_sensitive_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.article_sensitive_category 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `article_sensitive_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_sensitive_category` ENABLE KEYS */;

-- 导出  表 adminstore.article_sensitive_word 结构
DROP TABLE IF EXISTS `article_sensitive_word`;
CREATE TABLE IF NOT EXISTS `article_sensitive_word` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `replace_word` varchar(255) DEFAULT NULL,
  `word_size` int(11) DEFAULT NULL,
  `word` varchar(255) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4jx243akswqmswta87kwsr4wb` (`category_id`),
  KEY `FKebq1aflt9h1l0hki7qu3292yj` (`user_id`),
  CONSTRAINT `FK4jx243akswqmswta87kwsr4wb` FOREIGN KEY (`category_id`) REFERENCES `article_sensitive_category` (`id`),
  CONSTRAINT `FKebq1aflt9h1l0hki7qu3292yj` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.article_sensitive_word 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `article_sensitive_word` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_sensitive_word` ENABLE KEYS */;

-- 导出  表 adminstore.article_tag 结构
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE IF NOT EXISTS `article_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.article_tag 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `article_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_tag` ENABLE KEYS */;

-- 导出  表 adminstore.bs_article 结构
DROP TABLE IF EXISTS `bs_article`;
CREATE TABLE IF NOT EXISTS `bs_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `note` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.bs_article 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `bs_article` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_article` ENABLE KEYS */;

-- 导出  表 adminstore.bs_basic_ad 结构
DROP TABLE IF EXISTS `bs_basic_ad`;
CREATE TABLE IF NOT EXISTS `bs_basic_ad` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `beginDate` datetime DEFAULT NULL,
  `bussId` bigint(20) DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `adPosition_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfcpoci4jrh6mye1b0t9wcsy3i` (`adPosition_id`),
  CONSTRAINT `FKfcpoci4jrh6mye1b0t9wcsy3i` FOREIGN KEY (`adPosition_id`) REFERENCES `bs_basic_ad_position` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.bs_basic_ad 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `bs_basic_ad` DISABLE KEYS */;
INSERT IGNORE INTO `bs_basic_ad` (`id`, `addDate`, `lastDate`, `sortNum`, `beginDate`, `bussId`, `catalog`, `endDate`, `note`, `path`, `title`, `type`, `url`, `adPosition_id`) VALUES
	(1, '2020-11-06 23:31:12', '2020-11-06 23:47:01', NULL, '2020-11-09 00:00:00', NULL, NULL, '2020-11-18 00:00:00', '', 'http://file.metamall.cn/b2b/upload/image/202011/7182fb8a-2626-4adb-bcd3-f6e99899d27f.jpg', 'werer', NULL, '', 1);
/*!40000 ALTER TABLE `bs_basic_ad` ENABLE KEYS */;

-- 导出  表 adminstore.bs_basic_ad_position 结构
DROP TABLE IF EXISTS `bs_basic_ad_position`;
CREATE TABLE IF NOT EXISTS `bs_basic_ad_position` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `height` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `template` longtext NOT NULL,
  `width` int(11) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgn7e9qvq14vrk6e7d001a4sus` (`parent_id`),
  CONSTRAINT `FKgn7e9qvq14vrk6e7d001a4sus` FOREIGN KEY (`parent_id`) REFERENCES `bs_basic_ad_position` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.bs_basic_ad_position 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `bs_basic_ad_position` DISABLE KEYS */;
INSERT IGNORE INTO `bs_basic_ad_position` (`id`, `addDate`, `lastDate`, `sortNum`, `description`, `height`, `name`, `template`, `width`, `parent_id`, `note`) VALUES
	(1, '2020-11-06 23:20:35', '2020-11-06 23:22:59', NULL, '', 3, 'rewr', '', 1, NULL, NULL);
/*!40000 ALTER TABLE `bs_basic_ad_position` ENABLE KEYS */;

-- 导出  表 adminstore.bs_config 结构
DROP TABLE IF EXISTS `bs_config`;
CREATE TABLE IF NOT EXISTS `bs_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(18) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKojhwfbool85ew4ynhl0ucfcgq` (`account_id`),
  CONSTRAINT `FKojhwfbool85ew4ynhl0ucfcgq` FOREIGN KEY (`account_id`) REFERENCES `sys_trade_account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.bs_config 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `bs_config` DISABLE KEYS */;
INSERT IGNORE INTO `bs_config` (`id`, `addDate`, `lastDate`, `name`, `phone`, `account_id`) VALUES
	(1, '2019-09-11 19:10:35', '2019-09-11 19:10:35', '后台管理系统', '', NULL);
/*!40000 ALTER TABLE `bs_config` ENABLE KEYS */;

-- 导出  表 adminstore.bs_exception_log 结构
DROP TABLE IF EXISTS `bs_exception_log`;
CREATE TABLE IF NOT EXISTS `bs_exception_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `note` longtext,
  `params` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.bs_exception_log 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `bs_exception_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_exception_log` ENABLE KEYS */;

-- 导出  表 adminstore.bs_function 结构
DROP TABLE IF EXISTS `bs_function`;
CREATE TABLE IF NOT EXISTS `bs_function` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `data_key` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `data_script` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `languageType` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9o27wrtudkkooqh2jp9r218hk` (`data_key`),
  KEY `FKgvfa7gpacspe5f3y88d6t6dh2` (`user_id`),
  CONSTRAINT `FKgvfa7gpacspe5f3y88d6t6dh2` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.bs_function 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `bs_function` DISABLE KEYS */;
INSERT IGNORE INTO `bs_function` (`id`, `addDate`, `lastDate`, `data_key`, `name`, `note`, `data_script`, `user_id`, `languageType`) VALUES
	(1, '2019-12-28 10:51:00', '2019-12-28 10:51:00', 'demo', 'demo', 'http://localhost:8080/web/function/demo.htm', 'import com.haoxuer.adminstore.rest.domain.response.MemberResponse;\r\nprint("hello world");\r\nresult=new MemberResponse();\r\nresult.setName("hello111");', NULL, NULL);
/*!40000 ALTER TABLE `bs_function` ENABLE KEYS */;

-- 导出  表 adminstore.bs_org_data 结构
DROP TABLE IF EXISTS `bs_org_data`;
CREATE TABLE IF NOT EXISTS `bs_org_data` (
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
  `num` bigint(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKadl34onkdnyqn4jwvugm5bgo3` (`parent_id`),
  CONSTRAINT `FKadl34onkdnyqn4jwvugm5bgo3` FOREIGN KEY (`parent_id`) REFERENCES `bs_org_data` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.bs_org_data 的数据：~13 rows (大约)
/*!40000 ALTER TABLE `bs_org_data` DISABLE KEYS */;
INSERT IGNORE INTO `bs_org_data` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `catalog`, `num`, `parent_id`) VALUES
	(4, '2020-11-17 21:17:48', NULL, '4', '2020-11-17 21:17:48', 1, 1, '研发中心', 6, NULL, NULL, NULL, NULL),
	(13, '2020-11-17 21:37:00', NULL, '13', '2020-11-17 21:37:00', 1, 7, '实验室', 8, NULL, NULL, NULL, NULL),
	(14, '2020-11-17 21:37:13', NULL, '14', '2020-11-17 21:37:13', 1, 9, '市场集群', 26, NULL, NULL, NULL, NULL),
	(15, '2020-11-17 21:37:19', NULL, '14,15', '2020-11-17 21:37:19', 2, 10, '华北', 11, NULL, NULL, NULL, 14),
	(16, '2020-11-17 21:37:23', NULL, '14,16', '2020-11-17 21:37:23', 2, 12, '华南', 13, NULL, NULL, NULL, 14),
	(17, '2020-11-17 21:37:31', NULL, '14,17', '2020-11-17 21:37:31', 2, 14, '西北', 19, NULL, NULL, NULL, 14),
	(18, '2020-11-17 21:37:35', NULL, '14,18', '2020-11-17 21:37:35', 2, 20, '西南', 25, NULL, NULL, NULL, 14),
	(19, '2020-11-17 21:37:53', NULL, '4,19', '2020-11-17 21:37:53', 2, 2, '交互设计中心', 3, NULL, NULL, NULL, 4),
	(20, '2020-11-17 21:38:03', NULL, '4,20', '2020-11-17 21:38:03', 2, 4, 'ai研究中心', 5, NULL, NULL, NULL, 4),
	(21, '2020-11-17 21:38:18', NULL, '14,18,21', '2020-11-17 21:38:18', 3, 21, '重庆分公司', 22, NULL, NULL, NULL, 18),
	(22, '2020-11-17 21:38:25', NULL, '14,18,22', '2020-11-17 21:38:25', 3, 23, '成都分公司', 24, NULL, NULL, NULL, 18),
	(23, '2020-11-17 21:39:55', NULL, '14,17,23', '2020-11-17 21:39:55', 3, 15, '陕西分公司', 16, NULL, NULL, NULL, 17),
	(24, '2020-11-17 21:40:02', NULL, '14,17,24', '2020-11-17 21:40:02', 3, 17, '西安分公司', 18, NULL, NULL, NULL, 17);
/*!40000 ALTER TABLE `bs_org_data` ENABLE KEYS */;

-- 导出  表 adminstore.bs_org_user_department 结构
DROP TABLE IF EXISTS `bs_org_user_department`;
CREATE TABLE IF NOT EXISTS `bs_org_user_department` (
  `user_id` bigint(20) NOT NULL,
  `department_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`department_id`),
  KEY `FK5e7eajneuxtq35msy7njcphmn` (`department_id`),
  CONSTRAINT `FK5e7eajneuxtq35msy7njcphmn` FOREIGN KEY (`department_id`) REFERENCES `bs_org_data` (`id`),
  CONSTRAINT `FKmkkd1xis8xfihwir7vsil4wgx` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.bs_org_user_department 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `bs_org_user_department` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_org_user_department` ENABLE KEYS */;

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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.flow_define 的数据：0 rows
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
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.menu 的数据：~54 rows (大约)
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT IGNORE INTO `menu` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `catalog`, `icon`, `nums`, `path`, `permission`, `pid`) VALUES
	(1, '2017-09-25 14:25:39', '', '1', '2017-09-25 14:25:39', 1, 1, '根节点', 108, 0, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '2018-08-21 21:48:58', NULL, '1,2', '2018-08-21 21:48:58', 2, 2, '系统设置', 27, 55, 0, 'fa  fa-gear', 0, '', '2', 1),
	(3, '2017-09-25 14:34:37', NULL, '1,2,3', '2017-09-25 14:34:37', 3, 3, '菜单管理', 4, 0, 0, 'fa  fa-reorder', 0, 'admin/menu/view_list.htm', 'menu', 2),
	(4, '2017-09-25 14:36:59', NULL, '1,2,4', '2017-09-25 14:36:59', 3, 5, '角色管理', 6, 0, 0, 'fa  fa-tree', 0, 'admin/userrole/view_list.htm', 'userrole', 2),
	(5, '2017-09-25 14:38:29', NULL, '1,2,5', '2017-09-25 14:38:29', 3, 7, '第三方登陆配置', 8, 0, 0, 'fa  fa-connectdevelop', 0, 'admin/useroauthconfig/view_list.htm', 'useroauthconfig', 2),
	(6, '2017-09-25 14:35:30', NULL, '1,2,6', '2017-09-25 14:35:30', 3, 9, '友情链接分类管理', 10, 0, 0, 'fa  fa-link', 0, 'admin/linktype/view_list.htm', 'linktype', 2),
	(7, '2017-09-25 14:37:37', NULL, '1,2,7', '2017-09-25 14:37:37', 3, 11, '友情链接管理', 12, 0, 0, 'fa  fa-link', 0, 'admin/link/view_list.htm', 'link', 2),
	(8, '2017-09-25 14:48:04', NULL, '1,2,8', '2017-09-25 14:48:04', 3, 13, '角色分类配置', 14, 0, 0, 'fa  fa-user-secret', 0, 'admin/userrolecatalog/view_list.htm', 'userrolecatalog', 2),
	(9, '2019-03-12 10:37:42', NULL, '1,2,9', '2019-03-12 10:37:42', 3, 15, '移动app配置', 16, 0, 0, 'fa  fa-life-ring', 0, 'admin/app/view_list.htm', 'appversion', 2),
	(10, '2017-09-25 15:22:17', NULL, '1,2,10', '2017-09-25 15:22:17', 3, 17, '网站主题配置', 18, 0, 0, 'fa  fa-sitemap', 0, 'admin/theme.htm', '10', 2),
	(11, '2018-12-01 10:25:00', NULL, '1,2,11', '2018-12-01 10:25:00', 3, 19, '模板管理', 20, 0, 0, 'fa fa-circle-o', 0, 'admin/tmpl/view_list.htm', 'tmpl', 2),
	(12, '2018-07-16 15:09:53', NULL, '1,12', '2018-07-16 15:09:53', 2, 28, '流程管理', 33, 1, 0, 'fa  fa-archive', 0, '', '12', 1),
	(13, '2017-10-26 14:51:49', NULL, '1,12,13', '2017-10-26 14:51:49', 3, 29, '工作流管理', 30, NULL, 0, 'fa fa-circle-o', NULL, 'admin/flow/view_list.htm', 'flow', 12),
	(14, '2017-10-26 15:42:26', NULL, '1,12,14', '2017-10-26 15:42:26', 3, 31, '模型管理', 32, NULL, 0, 'fa fa-circle-o', NULL, 'admin/act/view_list.htm', 'act', 12),
	(15, '2017-12-27 14:04:35', NULL, '1,15', '2017-12-27 14:04:35', 2, 34, '服务插件管理', 49, 2, 0, 'fa  fa-cloud', 0, '', '15', 1),
	(16, '2018-07-10 21:57:50', NULL, '1,15,16', '2018-07-10 21:57:50', 3, 35, '验证码插件配置', 36, 0, 0, 'fa  fa-commenting-o', 0, 'admin/plugin_sendcode/list.htm', 'plugin_sendcode', 15),
	(17, '2018-07-10 21:58:05', NULL, '1,15,17', '2018-07-10 21:58:05', 3, 37, '存储插件配置', 38, 0, 0, 'fa  fa-cloud-upload', 0, 'admin/plugin_storage/list.htm', 'plugin_storage', 15),
	(18, '2018-07-10 21:57:36', NULL, '1,15,18', '2018-07-10 21:57:36', 3, 39, '推送插件配置', 40, 0, 0, 'fa fa-circle-o', 0, 'admin/plugin_push/list.htm', 'plugin_push', 15),
	(19, '2017-12-27 14:04:52', NULL, '1,19', '2017-12-27 14:04:52', 2, 50, '控制台', 51, 0, 0, 'fa fa-home', 0, 'admin/index.htm', '19', 1),
	(20, '2017-12-27 14:19:54', NULL, '1,20', '2017-12-27 14:19:54', 2, 52, '用户管理', 59, 0, 0, 'fa  fa-users', 0, '', '20', 1),
	(21, '2017-12-27 14:27:31', NULL, '1,20,21', '2017-12-27 14:27:31', 3, 53, '用户管理', 54, 0, 0, 'fa fa-user', 0, 'admin/member/view_list.htm', 'member', 20),
	(22, '2019-09-12 16:09:33', NULL, '1,20,22', '2019-09-12 16:09:33', 3, 55, '账号管理', 56, 0, 0, 'fa fa-list', 0, 'admin/member/accounts.htm', 'accounts', 20),
	(23, '2017-12-27 15:05:28', NULL, '1,20,23', '2017-12-27 15:05:28', 3, 57, '登陆日志', 58, 0, 0, 'fa fa-support', 0, 'admin/userloginlog/view_list.htm', 'userloginlog', 20),
	(24, '2018-12-17 22:04:25', NULL, '1,15,24', '2018-12-17 22:04:25', 3, 41, '支付插件管理', 42, 0, 0, 'fa fa-circle-o', 0, '', '24', 15),
	(25, '2018-12-17 22:04:32', NULL, '1,15,25', '2018-12-17 22:04:32', 3, 43, '第三方登陆插件配置', 44, 0, 0, 'fa fa-circle-o', 0, 'admin/plugin_oauth/list.htm', 'plugin_oauth', 15),
	(26, '2018-12-17 22:04:29', NULL, '1,15,26', '2018-12-17 22:04:29', 3, 45, '邮件插件配置', 46, 0, 0, 'fa fa-circle-o', 0, '', '26', 15),
	(27, '2020-11-17 21:16:02', NULL, '1,27', '2020-11-17 21:16:02', 2, 60, '组织管理', 65, 0, 0, 'fa fa-circle-o', 0, '', '27', 1),
	(28, '2018-07-10 21:25:38', NULL, '1,28', '2018-07-10 21:25:38', 2, 66, '云储存', 71, NULL, 0, 'fa fa-circle-o', NULL, '', '', 1),
	(29, '2018-07-10 21:28:12', NULL, '1,28,29', '2018-07-10 21:28:12', 3, 67, ' Bucket管理 ', 68, NULL, 0, 'fa fa-circle-o', NULL, '', '', 28),
	(30, '2018-07-10 21:29:17', NULL, '1,28,30', '2018-07-10 21:29:17', 3, 69, '统计分析', 70, NULL, 0, 'fa fa-circle-o', NULL, '', '', 28),
	(31, '2018-07-10 21:30:49', NULL, '1,31', '2018-07-10 21:30:49', 2, 72, '积分系统', 77, NULL, 0, 'fa fa-circle-o', NULL, '', '', 1),
	(32, '2018-07-10 21:31:03', NULL, '1,31,32', '2018-07-10 21:31:03', 3, 73, '积分明细', 74, NULL, 0, 'fa fa-circle-o', NULL, '', '', 31),
	(33, '2018-07-10 21:31:09', NULL, '1,31,33', '2018-07-10 21:31:09', 3, 75, '积分规则管理', 76, NULL, 0, 'fa fa-circle-o', NULL, '', '', 31),
	(34, '2018-07-16 15:02:29', NULL, '1,34', '2018-07-16 15:02:29', 2, 78, '定时任务管理', 85, 3, 0, 'fa  fa-calendar-plus-o', 0, '', '34', 1),
	(35, '2018-07-16 14:57:01', NULL, '1,34,35', '2018-07-16 14:57:01', 3, 79, '控制台', 80, 0, 0, 'fa fa-dashboard', 0, 'admin/crontask/index.htm', '35', 34),
	(36, '2018-07-16 14:57:20', NULL, '1,34,36', '2018-07-16 14:57:20', 3, 81, '任务管理', 82, 0, 0, 'fa   fa-list-ol', 0, 'admin/crontask/view_list.htm', 'crontask', 34),
	(37, '2018-07-16 14:56:48', NULL, '1,34,37', '2018-07-16 14:56:48', 3, 83, '运行记录', 84, 0, 0, 'fa fa-reorder', 0, 'admin/crontaskrecord/view_list.htm', 'crontaskrecord', 34),
	(38, '2018-07-16 14:58:54', NULL, '1,38', '2018-07-16 14:58:54', 2, 86, '消息通知', 93, 5, 0, 'fa  fa-comments', 0, '', '38', 1),
	(39, '2018-12-07 08:56:04', NULL, '1,38,39', '2018-12-07 08:56:04', 3, 87, '收件箱', 88, 0, 0, 'fa fa-circle-o', 0, 'admin/usernotificationmember/view_list.htm', 'usernotificationmember', 38),
	(40, '2018-07-16 15:00:19', NULL, '1,38,40', '2018-07-16 15:00:19', 3, 89, '通知分类', 90, NULL, 0, 'fa fa-circle-o', NULL, 'admin/usernotificationcatalog/view_list.htm', 'usernotificationcatalog', 38),
	(41, '2018-07-16 15:08:44', NULL, '1,41', '2018-07-16 15:08:44', 2, 94, '分类管理', 97, 8, 0, 'fa  fa-tree', 0, '', 'types', 1),
	(42, '2018-07-16 15:07:53', NULL, '1,41,42', '2018-07-16 15:07:53', 3, 95, '地区管理', 96, 0, 0, 'fa  fa-building-o', 0, 'admin/area/view_list.htm', 'area', 41),
	(43, '2018-12-01 11:07:37', NULL, '1,2,43', '2018-12-01 11:07:37', 3, 21, '个人资料管理', 22, -1, 0, 'glyphicon glyphicon-user', 0, 'admin/member/basic.htm', 'member_basic', 2),
	(44, '2018-12-07 08:57:37', NULL, '1,38,44', '2018-12-07 08:57:37', 3, 91, '通知管理', 92, 3, 0, 'fa fa-circle-o', NULL, 'admin/usernotification/view_list.htm', 'usernotification', 38),
	(45, '2018-12-17 22:04:21', NULL, '1,15,45', '2018-12-17 22:04:21', 3, 47, '服务管理', 48, -1, 0, 'fa fa-circle-o', NULL, 'admin/plugin_proxy/list.htm', 'plugin_proxy', 15),
	(47, '2019-09-11 19:15:40', NULL, '1,2,47', '2019-09-11 19:15:40', 3, 23, '数据字典管理', 24, 0, 0, 'fa  fa-square', 0, 'admin/dictionary/view_list.htm', 'dictionary', 2),
	(48, '2019-09-11 19:14:28', NULL, '1,2,48', '2019-09-11 19:14:28', 3, 25, '系统配置', 26, -1, 0, 'fa  fa-cogs', 0, 'admin/config.htm', 'system_config', 2),
	(49, '2019-09-12 16:43:16', NULL, '1,49', '2019-09-12 16:43:16', 2, 98, '云服务', 101, 0, 0, 'fa  fa-cloud', 0, '', '49', 1),
	(50, '2019-09-12 16:43:04', NULL, '1,49,50', '2019-09-12 16:43:04', 3, 99, '云函数', 100, 0, 0, 'fa  fa-code', 0, 'admin/function/view_list.htm', 'function', 49),
	(51, '2019-09-17 20:47:13', NULL, '1,51', '2019-09-17 20:47:13', 2, 102, '广告中心', 107, 0, 0, 'fa fa fa-buysellads', 0, '', '51', 1),
	(52, '2019-09-17 20:49:56', NULL, '1,51,52', '2019-09-17 20:49:56', 3, 103, '广告位管理', 104, 0, 0, 'fa  fa-minus-square', 0, 'admin/adposition/view_list.htm', 'adposition', 51),
	(53, '2019-09-17 20:50:11', NULL, '1,51,53', '2019-09-17 20:50:11', 3, 105, '广告管理', 106, 0, 0, 'fa fa-life-buoy', 0, 'admin/ad/view_list.htm', 'ad', 51),
	(54, '2020-11-17 21:16:43', NULL, '1,27,54', '2020-11-17 21:16:43', 3, 61, '组织架构', 62, 0, 0, 'fa fa-circle-o', 0, 'admin/organization/view_list.htm', 'organization', 27),
	(55, '2020-11-17 21:16:54', NULL, '1,27,55', '2020-11-17 21:16:54', 3, 63, '员工管理', 64, 0, 0, 'fa fa-circle-o', 0, 'admin/employee/view_list.htm', 'employee', 27);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.plugin_config 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `plugin_config` DISABLE KEYS */;
INSERT IGNORE INTO `plugin_config` (`id`, `addDate`, `lastDate`, `sortNum`, `isEnabled`, `pluginId`) VALUES
	(1, '2018-08-21 21:43:29', '2018-08-21 21:43:29', NULL, b'0', 'diskFilePlugin'),
	(2, '2018-08-21 21:43:43', '2018-08-21 21:43:43', NULL, b'0', 'github_plugin'),
	(4, '2018-08-21 21:46:04', '2018-08-21 21:46:04', NULL, b'0', 'filePlugin'),
	(6, '2018-08-21 21:46:30', '2018-08-21 21:46:30', NULL, b'1', 'dayuPlug'),
	(7, '2018-12-10 10:27:05', '2018-12-10 10:27:05', NULL, b'0', 'weibo_plugin'),
	(8, '2018-12-10 10:27:17', '2018-12-10 10:27:17', NULL, b'0', 'noneSendCodePlugin'),
	(9, '2018-12-10 19:39:46', '2018-12-10 19:39:46', NULL, b'0', 'oschina_plugin'),
	(10, '2018-12-10 19:40:07', '2018-12-10 19:40:07', NULL, b'0', 'nonePushPlugin');
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

-- 正在导出表  adminstore.plugin_config_attribute 的数据：~22 rows (大约)
/*!40000 ALTER TABLE `plugin_config_attribute` DISABLE KEYS */;
INSERT IGNORE INTO `plugin_config_attribute` (`PluginConfig_id`, `attributes`, `name`) VALUES
	(2, '0998d17bd1c5b93f6e41', 'apikey'),
	(2, 'btn-github', 'bg'),
	(2, 'https://www.haoxuer.com/plugs/github_plugin.htm', 'callback'),
	(2, 'fa  fa-cny', 'icon'),
	(2, '语文', 'name'),
	(2, '', 'order'),
	(2, 'get_user_info,add_share,add_pic_t', 'scope'),
	(2, '51f6d015c40a58f4da538626b89d1e1b', 'secret'),
	(4, '', 'order'),
	(4, '1', 'urlPrefix'),
	(6, '', 'appkey'),
	(6, '', 'binding'),
	(6, '', 'changePhone'),
	(6, 'on', 'enabled'),
	(6, '', 'init'),
	(6, '', 'login'),
	(6, '', 'order'),
	(6, '', 'product'),
	(6, '', 'register'),
	(6, '', 'reset'),
	(6, '', 'secret'),
	(6, '', 'signName');
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
  `system_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_jfx5shexfh9lo32836m2t62ga` (`packageName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.site_app 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `site_app` DISABLE KEYS */;
INSERT IGNORE INTO `site_app` (`id`, `addDate`, `lastDate`, `appKey`, `appSecret`, `counts`, `downUrl`, `name`, `note`, `packageName`, `system`, `versionCode`, `versionName`, `system_name`) VALUES
	(1, '2018-12-05 10:09:50', '2018-12-05 10:09:50', 'xh5jjwae1', '8b6hpn7ejjx46b4ncn21e9146bd', NULL, '', '客服端', '', '', NULL, NULL, '', 'android');
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
  `mobile` bit(1) NOT NULL,
  `adminTheme` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.site_config 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `site_config` DISABLE KEYS */;
INSERT IGNORE INTO `site_config` (`id`, `addDate`, `lastDate`, `description`, `domainName`, `favicon`, `icp`, `keywords`, `logo`, `pageSize`, `shortName`, `theme`, `title`, `mobile`, `adminTheme`) VALUES
	(1, '2018-02-04 13:29:23', '2019-03-01 13:55:26', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'default', NULL, b'0', NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.site_link 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `site_link` DISABLE KEYS */;
INSERT IGNORE INTO `site_link` (`id`, `addDate`, `lastDate`, `icon`, `name`, `sortNum`, `target`, `url`, `linkType_id`) VALUES
	(1, '2018-12-07 18:51:35', '2018-12-07 18:51:35', NULL, '不挂科', NULL, '_blank', 'http://www.buguake.cc', 3),
	(2, '2018-12-07 18:51:55', '2018-12-07 18:51:55', NULL, '开源中国', NULL, '_self', 'https://www.oschina.net/', 2),
	(3, '2018-12-07 18:57:56', '2018-12-07 18:57:56', NULL, 'discover', NULL, '_blank', 'https://gitee.com/cng1985/discover', 4),
	(4, '2018-12-07 18:58:20', '2018-12-07 18:58:20', NULL, 'ucms', NULL, '_blank', 'https://gitee.com/cng1985/iwan', 4),
	(5, '2018-12-07 18:59:13', '2018-12-07 18:59:13', NULL, '点评系统', NULL, '_blank', 'https://gitee.com/quhaodian/iyelp', 4);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.site_link_type 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `site_link_type` DISABLE KEYS */;
INSERT IGNORE INTO `site_link_type` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `pid`) VALUES
	(1, '2017-12-27 13:59:20', '', '1', '2017-12-27 13:59:20', 1, 1, '根节点', 8, 0, NULL),
	(2, '2017-12-29 08:52:53', '001', '1,2', '2017-12-29 08:52:53', 2, 2, '开源网站', 3, NULL, 1),
	(3, '2017-12-29 08:53:07', '002', '1,3', '2017-12-29 08:53:07', 2, 4, '朋友网站', 5, NULL, 1),
	(4, '2018-12-07 18:57:03', '003', '1,4', '2018-12-07 18:57:03', 2, 6, '开源项目', 7, NULL, 1);
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

-- 正在导出表  adminstore.site_theme_config 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `site_theme_config` DISABLE KEYS */;
INSERT IGNORE INTO `site_theme_config` (`id`, `name`, `path`, `screenShot`) VALUES
	('default', NULL, NULL, NULL),
	('defaultmobile', NULL, NULL, NULL);
/*!40000 ALTER TABLE `site_theme_config` ENABLE KEYS */;

-- 导出  表 adminstore.spring_session 结构
DROP TABLE IF EXISTS `spring_session`;
CREATE TABLE IF NOT EXISTS `spring_session` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`),
  UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 正在导出表  adminstore.spring_session 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `spring_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `spring_session` ENABLE KEYS */;

-- 导出  表 adminstore.spring_session_attributes 结构
DROP TABLE IF EXISTS `spring_session_attributes`;
CREATE TABLE IF NOT EXISTS `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`),
  CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 正在导出表  adminstore.spring_session_attributes 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `spring_session_attributes` DISABLE KEYS */;
/*!40000 ALTER TABLE `spring_session_attributes` ENABLE KEYS */;

-- 导出  表 adminstore.storage_bucket 结构
DROP TABLE IF EXISTS `storage_bucket`;
CREATE TABLE IF NOT EXISTS `storage_bucket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nums` bigint(20) DEFAULT NULL,
  `volume` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gh3c3jhrw4nb5kyy7j7ku6pf5` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.storage_bucket 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `storage_bucket` DISABLE KEYS */;
/*!40000 ALTER TABLE `storage_bucket` ENABLE KEYS */;

-- 导出  表 adminstore.storage_file 结构
DROP TABLE IF EXISTS `storage_file`;
CREATE TABLE IF NOT EXISTS `storage_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `diskPath` varchar(255) DEFAULT NULL,
  `fileType` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `volume` bigint(20) DEFAULT NULL,
  `bucket_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7n23g7ejwp2ki3fpf2xyk7dj1` (`bucket_id`),
  KEY `FKc2x9vsme8cy43h1que2hrlr06` (`parent_id`),
  KEY `FKeebalhjs5j5219fyjmguyq3n` (`user_id`),
  CONSTRAINT `FK7n23g7ejwp2ki3fpf2xyk7dj1` FOREIGN KEY (`bucket_id`) REFERENCES `storage_bucket` (`id`),
  CONSTRAINT `FKc2x9vsme8cy43h1que2hrlr06` FOREIGN KEY (`parent_id`) REFERENCES `storage_file` (`id`),
  CONSTRAINT `FKeebalhjs5j5219fyjmguyq3n` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.storage_file 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `storage_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `storage_file` ENABLE KEYS */;

-- 导出  表 adminstore.system_config_option 结构
DROP TABLE IF EXISTS `system_config_option`;
CREATE TABLE IF NOT EXISTS `system_config_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `config_key` varchar(50) DEFAULT NULL,
  `config_value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_2oj8i6u0tw1w3ljkt3l49lfq6` (`config_key`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.system_config_option 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `system_config_option` DISABLE KEYS */;
INSERT IGNORE INTO `system_config_option` (`id`, `addDate`, `lastDate`, `config_key`, `config_value`) VALUES
	(1, '2018-12-17 21:58:24', '2018-12-17 21:58:24', 'option_token_config', '86oqK8Z6WrhskvJXXfHiyy3cBcN4KHo/fy/euivUFQen0xKQOXYBoGa8uJw5lrjGEIPa/w3tWWUIZPgMRRIQaw=='),
	(2, '2018-12-17 21:58:24', '2018-12-17 21:58:24', 'option_token_day', '360');
/*!40000 ALTER TABLE `system_config_option` ENABLE KEYS */;

-- 导出  表 adminstore.system_dictionary 结构
DROP TABLE IF EXISTS `system_dictionary`;
CREATE TABLE IF NOT EXISTS `system_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `data_key` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `storeState` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.system_dictionary 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `system_dictionary` DISABLE KEYS */;
INSERT IGNORE INTO `system_dictionary` (`id`, `addDate`, `lastDate`, `data_key`, `name`, `note`, `storeState`, `version`) VALUES
	(1, '2019-03-12 13:19:59', '2019-03-12 13:19:59', 'sex', '性别', '性别字典', 1, 1),
	(2, '2019-03-12 13:21:14', '2019-03-12 13:21:14', 'age', '年龄', '年龄字典', 1, 1);
/*!40000 ALTER TABLE `system_dictionary` ENABLE KEYS */;

-- 导出  表 adminstore.system_dictionary_item 结构
DROP TABLE IF EXISTS `system_dictionary_item`;
CREATE TABLE IF NOT EXISTS `system_dictionary_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sortNum` int(11) NOT NULL,
  `state` int(11) DEFAULT NULL,
  `dictionary_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2toq4t20km76i83xfyb8adrf` (`dictionary_id`),
  CONSTRAINT `FK2toq4t20km76i83xfyb8adrf` FOREIGN KEY (`dictionary_id`) REFERENCES `system_dictionary` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.system_dictionary_item 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `system_dictionary_item` DISABLE KEYS */;
INSERT IGNORE INTO `system_dictionary_item` (`id`, `name`, `sortNum`, `state`, `dictionary_id`) VALUES
	(1, '男', 1, 1, 1),
	(2, '女', 2, 1, 1),
	(3, '60后', 1, 1, 2),
	(4, '70后', 2, 1, 2),
	(5, '80后', 3, 1, 2),
	(6, '90后', 4, 1, 2),
	(7, '00后', 5, 1, 2);
/*!40000 ALTER TABLE `system_dictionary_item` ENABLE KEYS */;

-- 导出  表 adminstore.sys_trade_account 结构
DROP TABLE IF EXISTS `sys_trade_account`;
CREATE TABLE IF NOT EXISTS `sys_trade_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `accountType` int(11) DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `checkValue` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.sys_trade_account 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_trade_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_trade_account` ENABLE KEYS */;

-- 导出  表 adminstore.sys_trade_account_exception 结构
DROP TABLE IF EXISTS `sys_trade_account_exception`;
CREATE TABLE IF NOT EXISTS `sys_trade_account_exception` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `checkValue` varchar(255) DEFAULT NULL,
  `oldAmount` decimal(19,2) DEFAULT NULL,
  `oldCheckValue` varchar(255) DEFAULT NULL,
  `oldSalt` varchar(255) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1m0rkqckvet4dpba4iobom9bd` (`account_id`),
  CONSTRAINT `FK1m0rkqckvet4dpba4iobom9bd` FOREIGN KEY (`account_id`) REFERENCES `sys_trade_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.sys_trade_account_exception 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_trade_account_exception` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_trade_account_exception` ENABLE KEYS */;

-- 导出  表 adminstore.sys_trade_basic_account 结构
DROP TABLE IF EXISTS `sys_trade_basic_account`;
CREATE TABLE IF NOT EXISTS `sys_trade_basic_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `trade_key` varchar(50) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4q8hs8tl45tbgj7dwkbfxwvkm` (`trade_key`),
  KEY `FKgcc5jsy2cexdiwknpv3ms8h3e` (`account_id`),
  CONSTRAINT `FKgcc5jsy2cexdiwknpv3ms8h3e` FOREIGN KEY (`account_id`) REFERENCES `sys_trade_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.sys_trade_basic_account 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_trade_basic_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_trade_basic_account` ENABLE KEYS */;

-- 导出  表 adminstore.sys_trade_info 结构
DROP TABLE IF EXISTS `sys_trade_info`;
CREATE TABLE IF NOT EXISTS `sys_trade_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `from_id` bigint(20) DEFAULT NULL,
  `to_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb00j1ko828ceh39r74r9ajn9l` (`from_id`),
  KEY `FK25kmhmgd3vpnkrove9gjt06vq` (`to_id`),
  CONSTRAINT `FK25kmhmgd3vpnkrove9gjt06vq` FOREIGN KEY (`to_id`) REFERENCES `sys_trade_account` (`id`),
  CONSTRAINT `FKb00j1ko828ceh39r74r9ajn9l` FOREIGN KEY (`from_id`) REFERENCES `sys_trade_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.sys_trade_info 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_trade_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_trade_info` ENABLE KEYS */;

-- 导出  表 adminstore.sys_trade_stream 结构
DROP TABLE IF EXISTS `sys_trade_stream`;
CREATE TABLE IF NOT EXISTS `sys_trade_stream` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `afterAmount` decimal(19,2) DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `changeType` int(11) DEFAULT NULL,
  `note` varchar(100) DEFAULT NULL,
  `preAmount` decimal(19,2) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `info_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK499th7tpww7kwgkd9btfexq36` (`account_id`),
  KEY `FK7k0ohx0lf7nf4quc4cgisxpo` (`info_id`),
  CONSTRAINT `FK499th7tpww7kwgkd9btfexq36` FOREIGN KEY (`account_id`) REFERENCES `sys_trade_account` (`id`),
  CONSTRAINT `FK7k0ohx0lf7nf4quc4cgisxpo` FOREIGN KEY (`info_id`) REFERENCES `sys_trade_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.sys_trade_stream 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_trade_stream` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_trade_stream` ENABLE KEYS */;

-- 导出  表 adminstore.sys_trade_user_account 结构
DROP TABLE IF EXISTS `sys_trade_user_account`;
CREATE TABLE IF NOT EXISTS `sys_trade_user_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `trade_key` varchar(50) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqn3g3ql33vkvanib5187iybht` (`account_id`),
  KEY `FK38tgxi15323dcrllbgb9pbxf6` (`user_id`),
  CONSTRAINT `FK38tgxi15323dcrllbgb9pbxf6` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`),
  CONSTRAINT `FKqn3g3ql33vkvanib5187iybht` FOREIGN KEY (`account_id`) REFERENCES `sys_trade_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.sys_trade_user_account 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_trade_user_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_trade_user_account` ENABLE KEYS */;

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
  `nextDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqpj60iiafuf9b7dh5xtxoeusw` (`user_id`),
  CONSTRAINT `FKqpj60iiafuf9b7dh5xtxoeusw` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.task 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT IGNORE INTO `task` (`id`, `addDate`, `lastDate`, `cron`, `name`, `note`, `nums`, `recordState`, `state`, `url`, `user_id`, `nextDate`) VALUES
	(1, '2019-09-12 16:39:22', '2019-12-28 10:51:45', '1 50 23 * * ?', '测试', '11', 114318, 4, 1, 'https://api.maotouin.com/uinfo/crawler/sync_company_new.htm', NULL, '2019-12-28 23:50:01');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.task_record 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `task_record` DISABLE KEYS */;
INSERT IGNORE INTO `task_record` (`id`, `addDate`, `lastDate`, `expensesTime`, `note`, `task_id`) VALUES
	(1, '2019-09-12 16:39:24', '2019-09-12 16:39:24', 223, '', 1);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_account 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;

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
  KEY `FKfulmxb2y8nrres564ymc2kqr4` (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_code 的数据：0 rows
/*!40000 ALTER TABLE `user_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_code` ENABLE KEYS */;

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
  `note` varchar(5000) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfjxq06hj1obi36glqqlbimt4g` (`userid`),
  KEY `FK16hwg5kemchnom1viytedumwr` (`user_id`),
  CONSTRAINT `FK16hwg5kemchnom1viytedumwr` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`),
  CONSTRAINT `FKfjxq06hj1obi36glqqlbimt4g` FOREIGN KEY (`userid`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_feedback 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_feedback` ENABLE KEYS */;

-- 导出  表 adminstore.user_identification 结构
DROP TABLE IF EXISTS `user_identification`;
CREATE TABLE IF NOT EXISTS `user_identification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `bindType` int(11) DEFAULT NULL,
  `no` varchar(50) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh4c2qe2s2jyoq5gwl4sp09efn` (`user_id`),
  CONSTRAINT `FKh4c2qe2s2jyoq5gwl4sp09efn` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_identification 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `user_identification` DISABLE KEYS */;
INSERT IGNORE INTO `user_identification` (`id`, `addDate`, `lastDate`, `bindType`, `no`, `user_id`) VALUES
	(1, '2018-12-01 10:26:11', '2018-12-01 10:26:11', 2, 'ada', 1),
	(2, '2018-12-01 10:26:23', '2018-12-01 10:26:23', 2, 'admin', 2),
	(9, '2019-09-12 16:03:06', '2019-09-12 16:03:06', 2, '3', 10);
/*!40000 ALTER TABLE `user_identification` ENABLE KEYS */;

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
  `state` int(11) DEFAULT NULL,
  `edge` varchar(255) DEFAULT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `household_id` int(11) DEFAULT NULL,
  `companyName` varchar(30) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `job` varchar(20) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `storeState` int(11) DEFAULT NULL,
  `no` varchar(255) DEFAULT NULL,
  `dataType` int(11) DEFAULT NULL,
  `permissionType` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3193uu2asgocbhkk1mus5wfd7` (`household_id`),
  KEY `FK5osla9rjm07kbyi8wx7oq8qbs` (`account_id`),
  KEY `FKk3ry8t8gy9f74tqibu2d03ej4` (`org_id`),
  CONSTRAINT `FK3193uu2asgocbhkk1mus5wfd7` FOREIGN KEY (`household_id`) REFERENCES `area` (`id`),
  CONSTRAINT `FK5osla9rjm07kbyi8wx7oq8qbs` FOREIGN KEY (`account_id`) REFERENCES `sys_trade_account` (`id`),
  CONSTRAINT `FKk3ry8t8gy9f74tqibu2d03ej4` FOREIGN KEY (`org_id`) REFERENCES `bs_org_data` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_info 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT IGNORE INTO `user_info` (`id`, `addDate`, `lastDate`, `avatar`, `catalog`, `loginSize`, `name`, `phone`, `state`, `edge`, `introduce`, `note`, `sex`, `household_id`, `companyName`, `email`, `job`, `account_id`, `storeState`, `no`, `dataType`, `permissionType`, `org_id`) VALUES
	(1, '2017-12-27 14:44:05', '2020-11-17 21:39:04', NULL, 0, 806, '管理员', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '2019-09-12 16:31:05', '2020-11-17 21:39:28', NULL, 0, 27, 'super', 'a', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(10, '2019-09-12 16:26:22', '2019-09-12 16:29:21', NULL, 0, 6, '333', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
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
/*!40000 ALTER TABLE `user_label_links` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_label_links` ENABLE KEYS */;

-- 导出  表 adminstore.user_lockout 结构
DROP TABLE IF EXISTS `user_lockout`;
CREATE TABLE IF NOT EXISTS `user_lockout` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `beginDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpb7diegkhtsskj1c8j5iq9ap5` (`user_id`),
  CONSTRAINT `FKpb7diegkhtsskj1c8j5iq9ap5` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_lockout 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_lockout` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_lockout` ENABLE KEYS */;

-- 导出  表 adminstore.user_login_log 结构
DROP TABLE IF EXISTS `user_login_log`;
CREATE TABLE IF NOT EXISTS `user_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `client` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj91w0nnfocpdp796lr3ot4lxs` (`user_id`),
  CONSTRAINT `FKj91w0nnfocpdp796lr3ot4lxs` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_login_log 的数据：~29 rows (大约)
/*!40000 ALTER TABLE `user_login_log` DISABLE KEYS */;
INSERT IGNORE INTO `user_login_log` (`id`, `addDate`, `lastDate`, `ip`, `state`, `user_id`, `account`, `client`) VALUES
	(1, '2019-09-11 19:05:57', '2019-09-11 19:05:57', '0:0:0:0:0:0:0:1', 1, 1, NULL, NULL),
	(2, '2019-09-11 19:10:12', '2019-09-11 19:10:12', '0:0:0:0:0:0:0:1', 1, 1, NULL, NULL),
	(3, '2019-09-11 19:18:16', '2019-09-11 19:18:16', '0:0:0:0:0:0:0:1', 1, 1, NULL, NULL),
	(4, '2019-09-12 15:47:54', '2019-09-12 15:47:54', '0:0:0:0:0:0:0:1', 1, 1, NULL, NULL),
	(5, '2019-09-12 16:00:30', '2019-09-12 16:00:30', '0:0:0:0:0:0:0:1', 1, 1, NULL, NULL),
	(7, '2019-09-12 16:24:58', '2019-09-12 16:24:58', '0:0:0:0:0:0:0:1', 1, 10, NULL, NULL),
	(8, '2019-09-12 16:25:17', '2019-09-12 16:25:17', '0:0:0:0:0:0:0:1', 1, 10, NULL, NULL),
	(9, '2019-09-12 16:31:14', '2019-09-12 16:31:14', '0:0:0:0:0:0:0:1', 1, 1, NULL, NULL),
	(10, '2019-09-12 16:31:22', '2019-09-12 16:31:22', '0:0:0:0:0:0:0:1', 1, 2, NULL, NULL),
	(11, '2019-09-12 16:31:38', '2019-09-12 16:31:38', '0:0:0:0:0:0:0:1', 1, 1, NULL, NULL),
	(12, '2019-09-12 16:43:31', '2019-09-12 16:43:31', '0:0:0:0:0:0:0:1', 1, 2, NULL, NULL),
	(13, '2019-09-12 16:43:41', '2019-09-12 16:43:41', '0:0:0:0:0:0:0:1', 1, 1, NULL, NULL),
	(14, '2019-09-12 16:51:35', '2019-09-12 16:51:35', '0:0:0:0:0:0:0:1', 1, 1, NULL, NULL),
	(15, '2019-09-17 19:42:36', '2019-09-17 19:42:36', '0:0:0:0:0:0:0:1', 1, 2, NULL, NULL),
	(16, '2019-09-17 19:42:44', '2019-09-17 19:42:44', '0:0:0:0:0:0:0:1', 1, 1, NULL, NULL),
	(17, '2019-09-17 20:46:32', '2019-09-17 20:46:32', '127.0.0.1', 1, 1, NULL, NULL),
	(18, '2019-11-03 15:28:12', '2019-11-03 15:28:12', '0:0:0:0:0:0:0:1', 1, 2, NULL, NULL),
	(19, '2019-12-28 10:50:24', '2019-12-28 10:50:24', '0:0:0:0:0:0:0:1', 1, 1, NULL, NULL),
	(20, '2020-04-12 22:29:12', '2020-04-12 22:29:12', '0:0:0:0:0:0:0:1', 1, 1, NULL, NULL),
	(21, '2020-10-10 19:54:38', '2020-10-10 19:54:38', '127.0.0.1', 1, 1, NULL, NULL),
	(22, '2020-11-06 22:53:00', '2020-11-06 22:53:00', '0:0:0:0:0:0:0:1', 1, 1, NULL, NULL),
	(23, '2020-11-06 23:43:16', '2020-11-06 23:43:16', '127.0.0.1', 1, 1, NULL, NULL),
	(24, '2020-11-13 12:11:51', '2020-11-13 12:11:51', '0:0:0:0:0:0:0:1', 1, 1, NULL, NULL),
	(25, '2020-11-13 12:19:03', '2020-11-13 12:19:03', '0:0:0:0:0:0:0:1', 1, 1, NULL, NULL),
	(26, '2020-11-17 16:21:43', '2020-11-17 16:21:43', '0:0:0:0:0:0:0:1', 1, 1, NULL, NULL),
	(27, '2020-11-17 21:11:24', '2020-11-17 21:11:24', '0:0:0:0:0:0:0:1', 1, 1, NULL, NULL),
	(28, '2020-11-17 21:17:15', '2020-11-17 21:17:15', '0:0:0:0:0:0:0:1', 1, 1, NULL, NULL),
	(29, '2020-11-17 21:31:23', '2020-11-17 21:31:23', '0:0:0:0:0:0:0:1', 1, 1, NULL, NULL),
	(30, '2020-11-17 21:39:28', '2020-11-17 21:39:28', '0:0:0:0:0:0:0:1', 1, 2, NULL, NULL);
/*!40000 ALTER TABLE `user_login_log` ENABLE KEYS */;

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
  `storeState` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKen7mn6n9j4ach4hyewfjakkg2` (`authorid`),
  KEY `FK25yxc2g4kt2wk510uy05nr10f` (`catalogid`),
  CONSTRAINT `FK25yxc2g4kt2wk510uy05nr10f` FOREIGN KEY (`catalogid`) REFERENCES `user_notification_catalog` (`id`),
  CONSTRAINT `FKen7mn6n9j4ach4hyewfjakkg2` FOREIGN KEY (`authorid`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_notification 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `user_notification` DISABLE KEYS */;
INSERT IGNORE INTO `user_notification` (`id`, `addDate`, `lastDate`, `category`, `clicks`, `image`, `imageType`, `introduction`, `note`, `nums`, `taxonomy`, `title`, `top`, `url`, `authorid`, `catalogid`, `storeState`) VALUES
	(1, '2018-12-07 08:57:59', '2018-12-07 08:57:59', 2, NULL, NULL, NULL, NULL, 'sdsd', NULL, NULL, 'ds', NULL, NULL, 1, NULL, NULL),
	(2, '2018-12-07 11:23:32', '2018-12-07 11:23:32', 2, NULL, NULL, NULL, NULL, 'ere', NULL, NULL, 'fd', NULL, NULL, 1, NULL, NULL),
	(3, '2018-12-07 13:42:18', '2018-12-07 13:42:18', 2, NULL, NULL, NULL, NULL, 'ddd', 2, NULL, 'dd', NULL, NULL, 1, NULL, 1),
	(4, '2018-12-07 13:49:28', '2018-12-07 13:49:28', 1, NULL, NULL, NULL, NULL, 'nice', 1, NULL, 'hi', NULL, NULL, 1, NULL, 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_notification_catalog 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_notification_catalog` DISABLE KEYS */;
INSERT IGNORE INTO `user_notification_catalog` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `icon`, `system`, `pid`) VALUES
	(1, '2018-07-16 15:01:15', '', '1', '2018-07-16 15:01:15', 1, 1, '根节点', 2, 0, NULL, NULL, NULL);
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
  KEY `FKlatb6olq7rthe83lg86qovdqh` (`uid`),
  CONSTRAINT `FKlatb6olq7rthe83lg86qovdqh` FOREIGN KEY (`uid`) REFERENCES `user_info` (`id`),
  CONSTRAINT `FKolldeppu9xw9we1jwgcvpc6m7` FOREIGN KEY (`notificationid`) REFERENCES `user_notification` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_notification_member 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `user_notification_member` DISABLE KEYS */;
INSERT IGNORE INTO `user_notification_member` (`id`, `addDate`, `lastDate`, `state`, `notificationid`, `uid`) VALUES
	(1, '2018-12-07 08:57:59', '2018-12-07 08:57:59', 0, 1, 1),
	(2, '2018-12-07 08:57:59', '2018-12-07 08:57:59', 0, 1, 2),
	(3, '2018-12-07 11:23:32', '2018-12-07 11:23:32', 0, 2, 1),
	(4, '2018-12-07 11:23:32', '2018-12-07 11:23:32', 0, 2, 2),
	(5, '2018-12-07 13:42:18', '2018-12-07 13:42:18', 0, 3, 1),
	(6, '2018-12-07 13:42:18', '2018-12-07 13:42:18', 0, 3, 2),
	(7, '2018-12-07 13:49:28', '2018-12-07 13:49:28', 0, 4, 2);
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
/*!40000 ALTER TABLE `user_notification_num` DISABLE KEYS */;
INSERT IGNORE INTO `user_notification_num` (`id`, `addDate`, `lastDate`, `mid`, `uid`) VALUES
	(1, '2018-12-07 08:56:24', '2019-09-11 19:18:48', 0, 1);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_notification_time 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_notification_time` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_role 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT IGNORE INTO `user_role` (`id`, `addDate`, `lastDate`, `alias`, `description`, `name`, `roleType`, `catalog_id`) VALUES
	(1, '2020-11-17 21:17:03', '2020-11-17 21:17:03', '', '', 'admin', 0, 2),
	(2, '2020-11-17 21:39:22', '2020-11-17 21:39:22', '管理员', '后台管理员', '管理员', 0, 2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

-- 导出  表 adminstore.user_role_authority 结构
DROP TABLE IF EXISTS `user_role_authority`;
CREATE TABLE IF NOT EXISTS `user_role_authority` (
  `role_id` bigint(20) NOT NULL,
  `permission` varchar(100) DEFAULT NULL,
  KEY `FKo6xok4ngrsuacqkyjpqbykn9l` (`role_id`),
  CONSTRAINT `FKo6xok4ngrsuacqkyjpqbykn9l` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_role_authority 的数据：~65 rows (大约)
/*!40000 ALTER TABLE `user_role_authority` DISABLE KEYS */;
INSERT IGNORE INTO `user_role_authority` (`role_id`, `permission`) VALUES
	(1, '19'),
	(1, '20'),
	(1, 'member'),
	(1, 'userloginlog'),
	(1, '27'),
	(1, 'organization'),
	(1, 'employee'),
	(1, '49'),
	(1, 'function'),
	(1, '51'),
	(1, 'adposition'),
	(1, 'ad'),
	(1, '15'),
	(1, 'plugin_sendcode'),
	(1, 'plugin_storage'),
	(1, 'plugin_push'),
	(1, 'plugin_oauth'),
	(1, 'plugin_proxy'),
	(1, '34'),
	(1, '35'),
	(1, 'crontask'),
	(1, 'crontaskrecord'),
	(1, '38'),
	(1, 'usernotificationmember'),
	(1, 'usernotificationcatalog'),
	(1, 'usernotification'),
	(1, 'types'),
	(1, 'area'),
	(1, '2'),
	(1, 'menu'),
	(1, 'userrole'),
	(1, 'useroauthconfig'),
	(1, 'linktype'),
	(1, 'link'),
	(1, 'userrolecatalog'),
	(1, 'appversion'),
	(1, '10'),
	(1, 'tmpl'),
	(1, 'member_basic'),
	(1, 'dictionary'),
	(1, 'system_config'),
	(2, '19'),
	(2, '20'),
	(2, 'member'),
	(2, 'accounts'),
	(2, 'userloginlog'),
	(2, '27'),
	(2, 'organization'),
	(2, 'employee'),
	(2, '51'),
	(2, 'adposition'),
	(2, 'ad'),
	(2, '2'),
	(2, 'menu'),
	(2, 'userrole'),
	(2, 'useroauthconfig'),
	(2, 'linktype'),
	(2, 'link'),
	(2, 'userrolecatalog'),
	(2, 'appversion'),
	(2, '10'),
	(2, 'tmpl'),
	(2, 'member_basic'),
	(2, 'dictionary'),
	(2, 'system_config');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_role_catalog 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `user_role_catalog` DISABLE KEYS */;
INSERT IGNORE INTO `user_role_catalog` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `pid`) VALUES
	(1, '2017-12-27 13:59:23', '', '1', '2017-12-27 13:59:23', 1, 1, '根节点', 8, 0, NULL),
	(2, '2018-08-12 16:43:59', '002', '1,2', '2018-08-12 16:43:59', 2, 2, '系统', 5, NULL, 1),
	(3, '2018-08-12 16:44:19', '001', '1,3', '2018-08-12 16:44:19', 2, 6, '自定义', 7, NULL, 1),
	(4, '2018-08-12 17:24:34', 'gg', '1,2,4', '2018-08-12 17:24:34', 3, 3, 'gg', 4, NULL, 2);
/*!40000 ALTER TABLE `user_role_catalog` ENABLE KEYS */;

-- 导出  表 adminstore.user_role_links 结构
DROP TABLE IF EXISTS `user_role_links`;
CREATE TABLE IF NOT EXISTS `user_role_links` (
  `user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`roles_id`),
  KEY `FKpm1oweb01msxxqf212qmd0984` (`roles_id`),
  CONSTRAINT `FK3r2sf8531lbjt40y3qjhkg2an` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKpm1oweb01msxxqf212qmd0984` FOREIGN KEY (`roles_id`) REFERENCES `user_role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_role_links 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `user_role_links` DISABLE KEYS */;
INSERT IGNORE INTO `user_role_links` (`user_id`, `roles_id`) VALUES
	(1, 1),
	(10, 1),
	(2, 2),
	(10, 2);
/*!40000 ALTER TABLE `user_role_links` ENABLE KEYS */;

-- 导出  表 adminstore.user_security 结构
DROP TABLE IF EXISTS `user_security`;
CREATE TABLE IF NOT EXISTS `user_security` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `checkSize` int(11) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  `securityType` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK641wdw6hf3c0nflv03rt0d6h2` (`user_id`),
  CONSTRAINT `FK641wdw6hf3c0nflv03rt0d6h2` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- 正在导出表  adminstore.user_security 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `user_security` DISABLE KEYS */;
INSERT IGNORE INTO `user_security` (`id`, `addDate`, `lastDate`, `checkSize`, `password`, `salt`, `securityType`, `user_id`) VALUES
	(1, '2018-12-01 10:26:11', '2018-12-01 10:29:19', 0, 'b63e05a75d3c13c53becedeb885bda5b67a6664a', 'e1e8c5fab5a28e13', 0, 1),
	(2, '2018-12-01 10:26:23', '2018-12-01 10:26:23', 0, 'd9730873f22fdd9bef4793e9c28b9a5d877810a0', 'ea6990c1cbfbcbbb', 0, 2),
	(9, '2019-09-12 16:03:06', '2019-09-12 16:25:09', 0, 'ed6325aba15042638a7efc01b003746735c5b82b', 'b797c613fd100142', 0, 10);
/*!40000 ALTER TABLE `user_security` ENABLE KEYS */;

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
/*!40000 ALTER TABLE `user_verification` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_verification` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
