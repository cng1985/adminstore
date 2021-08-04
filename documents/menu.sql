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

-- 导出  表 multisite.menu 结构
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
  `menuType` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqcf9gem97gqa5qjm4d3elcqt5` (`pid`),
  CONSTRAINT `FKqcf9gem97gqa5qjm4d3elcqt5` FOREIGN KEY (`pid`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  multisite.menu 的数据：~54 rows (大约)
DELETE FROM `menu`;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `catalog`, `icon`, `nums`, `path`, `permission`, `pid`, `menuType`) VALUES
	(1, '2017-09-25 14:25:39', '', '1', '2017-09-25 14:25:39', 1, 1, '根节点', 108, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '2018-08-21 21:48:58', NULL, '1,2', '2018-08-21 21:48:58', 2, 2, '系统设置', 29, 55, 0, 'fa  fa-gear', 0, '', '2', 1, NULL),
	(3, '2017-09-25 14:34:37', NULL, '1,2,3', '2017-09-25 14:34:37', 3, 3, '菜单管理', 4, 0, 0, 'fa  fa-reorder', 0, 'admin/menu/view_list.htm', 'menu', 2, NULL),
	(4, '2017-09-25 14:36:59', NULL, '1,2,4', '2017-09-25 14:36:59', 3, 5, '角色管理', 6, 0, 0, 'fa  fa-tree', 0, 'admin/userrole/view_list.htm', 'userrole', 2, NULL),
	(5, '2017-09-25 14:38:29', NULL, '1,2,5', '2017-09-25 14:38:29', 3, 7, '第三方登陆配置', 8, 0, 0, 'fa  fa-connectdevelop', 0, 'admin/useroauthconfig/view_list.htm', 'useroauthconfig', 2, NULL),
	(6, '2017-09-25 14:35:30', NULL, '1,2,6', '2017-09-25 14:35:30', 3, 9, '友情链接分类管理', 10, 0, 0, 'fa  fa-link', 0, 'admin/linktype/view_list.htm', 'linktype', 2, NULL),
	(7, '2017-09-25 14:37:37', NULL, '1,2,7', '2017-09-25 14:37:37', 3, 11, '友情链接管理', 12, 0, 0, 'fa  fa-link', 0, 'admin/link/view_list.htm', 'link', 2, NULL),
	(8, '2017-09-25 14:48:04', NULL, '1,2,8', '2017-09-25 14:48:04', 3, 13, '角色分类配置', 14, 0, 0, 'fa  fa-user-secret', 0, 'admin/userrolecatalog/view_list.htm', 'userrolecatalog', 2, NULL),
	(9, '2019-03-12 10:37:42', NULL, '1,2,9', '2019-03-12 10:37:42', 3, 15, '移动app配置', 16, 0, 0, 'fa  fa-life-ring', 0, 'admin/app/view_list.htm', 'appversion', 2, NULL),
	(10, '2017-09-25 15:22:17', NULL, '1,2,10', '2017-09-25 15:22:17', 3, 17, '网站主题配置', 18, 0, 0, 'fa  fa-sitemap', 0, 'admin/theme.htm', '10', 2, NULL),
	(11, '2018-12-01 10:25:00', NULL, '1,2,11', '2018-12-01 10:25:00', 3, 19, '模板管理', 20, 0, 0, 'fa fa-circle-o', 0, 'admin/tmpl/view_list.htm', 'tmpl', 2, NULL),
	(15, '2017-12-27 14:04:35', NULL, '1,15', '2017-12-27 14:04:35', 2, 30, '服务插件管理', 45, 2, 0, 'fa  fa-cloud', 0, '', '15', 1, NULL),
	(16, '2018-07-10 21:57:50', NULL, '1,15,16', '2018-07-10 21:57:50', 3, 31, '验证码插件配置', 32, 0, 0, 'fa  fa-commenting-o', 0, 'admin/plugin_sendcode/list.htm', 'plugin_sendcode', 15, NULL),
	(17, '2018-07-10 21:58:05', NULL, '1,15,17', '2018-07-10 21:58:05', 3, 33, '存储插件配置', 34, 0, 0, 'fa  fa-cloud-upload', 0, 'admin/plugin_storage/list.htm', 'plugin_storage', 15, NULL),
	(18, '2018-07-10 21:57:36', NULL, '1,15,18', '2018-07-10 21:57:36', 3, 35, '推送插件配置', 36, 0, 0, 'fa fa-circle-o', 0, 'admin/plugin_push/list.htm', 'plugin_push', 15, NULL),
	(19, '2017-12-27 14:04:52', NULL, '1,19', '2017-12-27 14:04:52', 2, 46, '控制台', 47, 0, 0, 'fa fa-home', 0, 'admin/index.htm', '19', 1, NULL),
	(20, '2017-12-27 14:19:54', NULL, '1,20', '2017-12-27 14:19:54', 2, 48, '用户管理', 55, 0, 0, 'fa  fa-users', 0, '', '20', 1, NULL),
	(21, '2017-12-27 14:27:31', NULL, '1,20,21', '2017-12-27 14:27:31', 3, 49, '用户管理', 50, 0, 0, 'fa fa-user', 0, 'admin/member/view_list.htm', 'member', 20, NULL),
	(22, '2019-09-12 16:09:33', NULL, '1,20,22', '2019-09-12 16:09:33', 3, 51, '账号管理', 52, 0, 0, 'fa fa-list', 0, 'admin/member/accounts.htm', 'accounts', 20, NULL),
	(23, '2017-12-27 15:05:28', NULL, '1,20,23', '2017-12-27 15:05:28', 3, 53, '登陆日志', 54, 0, 0, 'fa fa-support', 0, 'admin/userloginlog/view_list.htm', 'userloginlog', 20, NULL),
	(24, '2018-12-17 22:04:25', NULL, '1,15,24', '2018-12-17 22:04:25', 3, 37, '支付插件管理', 38, 0, 0, 'fa fa-circle-o', 0, '', '24', 15, NULL),
	(25, '2018-12-17 22:04:32', NULL, '1,15,25', '2018-12-17 22:04:32', 3, 39, '第三方登陆插件配置', 40, 0, 0, 'fa fa-circle-o', 0, 'admin/plugin_oauth/list.htm', 'plugin_oauth', 15, NULL),
	(26, '2018-12-17 22:04:29', NULL, '1,15,26', '2018-12-17 22:04:29', 3, 41, '邮件插件配置', 42, 0, 0, 'fa fa-circle-o', 0, '', '26', 15, NULL),
	(27, '2020-11-17 21:16:02', NULL, '1,27', '2020-11-17 21:16:02', 2, 56, '组织管理', 61, 0, 0, 'fa fa-circle-o', 0, '', '27', 1, NULL),
	(34, '2018-07-16 15:02:29', NULL, '1,34', '2018-07-16 15:02:29', 2, 62, '定时任务管理', 69, 3, 0, 'fa  fa-calendar-plus-o', 0, '', '34', 1, NULL),
	(35, '2018-07-16 14:57:01', NULL, '1,34,35', '2018-07-16 14:57:01', 3, 63, '控制台', 64, 0, 0, 'fa fa-dashboard', 0, 'admin/crontask/index.htm', '35', 34, NULL),
	(36, '2018-07-16 14:57:20', NULL, '1,34,36', '2018-07-16 14:57:20', 3, 65, '任务管理', 66, 0, 0, 'fa   fa-list-ol', 0, 'admin/crontask/view_list.htm', 'crontask', 34, NULL),
	(37, '2018-07-16 14:56:48', NULL, '1,34,37', '2018-07-16 14:56:48', 3, 67, '运行记录', 68, 0, 0, 'fa fa-reorder', 0, 'admin/crontaskrecord/view_list.htm', 'crontaskrecord', 34, NULL),
	(38, '2018-07-16 14:58:54', NULL, '1,38', '2018-07-16 14:58:54', 2, 70, '消息通知', 77, 5, 0, 'fa  fa-comments', 0, '', '38', 1, NULL),
	(39, '2018-12-07 08:56:04', NULL, '1,38,39', '2018-12-07 08:56:04', 3, 71, '收件箱', 72, 0, 0, 'fa fa-circle-o', 0, 'admin/usernotificationmember/view_list.htm', 'usernotificationmember', 38, NULL),
	(40, '2018-07-16 15:00:19', NULL, '1,38,40', '2018-07-16 15:00:19', 3, 73, '通知分类', 74, NULL, 0, 'fa fa-circle-o', NULL, 'admin/usernotificationcatalog/view_list.htm', 'usernotificationcatalog', 38, NULL),
	(41, '2018-07-16 15:08:44', NULL, '1,41', '2018-07-16 15:08:44', 2, 78, '分类管理', 81, 8, 0, 'fa  fa-tree', 0, '', 'types', 1, NULL),
	(42, '2018-07-16 15:07:53', NULL, '1,41,42', '2018-07-16 15:07:53', 3, 79, '地区管理', 80, 0, 0, 'fa  fa-building-o', 0, 'admin/area/view_list.htm', 'area', 41, NULL),
	(43, '2018-12-01 11:07:37', NULL, '1,2,43', '2018-12-01 11:07:37', 3, 21, '个人资料管理', 22, -1, 0, 'glyphicon glyphicon-user', 0, 'tenant/system/profile.htm', 'system_profile', 2, 1),
	(44, '2018-12-07 08:57:37', NULL, '1,38,44', '2018-12-07 08:57:37', 3, 75, '通知管理', 76, 3, 0, 'fa fa-circle-o', NULL, 'admin/usernotification/view_list.htm', 'usernotification', 38, NULL),
	(45, '2018-12-17 22:04:21', NULL, '1,15,45', '2018-12-17 22:04:21', 3, 43, '服务管理', 44, -1, 0, 'fa fa-circle-o', NULL, 'admin/plugin_proxy/list.htm', 'plugin_proxy', 15, NULL),
	(47, '2019-09-11 19:15:40', NULL, '1,2,47', '2019-09-11 19:15:40', 3, 23, '数据字典管理', 24, 0, 0, 'fa  fa-square', 0, 'admin/dictionary/view_list.htm', 'dictionary', 2, NULL),
	(48, '2019-09-11 19:14:28', NULL, '1,2,48', '2019-09-11 19:14:28', 3, 25, '系统配置', 26, -1, 0, 'fa  fa-cogs', 0, 'tenant/system/index.htm', 'system_index', 2, NULL),
	(51, '2019-09-17 20:47:13', NULL, '1,51', '2019-09-17 20:47:13', 2, 82, '广告中心', 87, 0, 0, 'fa fa fa-buysellads', 0, '', '51', 1, NULL),
	(52, '2019-09-17 20:49:56', NULL, '1,51,52', '2019-09-17 20:49:56', 3, 83, '广告位管理', 84, 0, 0, 'fa  fa-minus-square', 0, 'admin/adposition/view_list.htm', 'adposition', 51, NULL),
	(53, '2019-09-17 20:50:11', NULL, '1,51,53', '2019-09-17 20:50:11', 3, 85, '广告管理', 86, 0, 0, 'fa fa-life-buoy', 0, 'admin/ad/view_list.htm', 'ad', 51, NULL),
	(54, '2020-11-17 21:16:43', NULL, '1,27,54', '2020-11-17 21:16:43', 3, 57, '组织架构', 58, 0, 0, 'fa fa-circle-o', 0, 'admin/structure/view_list.htm', 'structure', 27, NULL),
	(55, '2020-11-17 21:16:54', NULL, '1,27,55', '2020-11-17 21:16:54', 3, 59, '员工管理', 60, 0, 0, 'fa fa-circle-o', 0, 'admin/employee/view_list.htm', 'employee', 27, NULL),
	(56, '2021-04-09 19:02:24', NULL, '1,2,56', '2021-04-09 19:02:24', 3, 27, '菜单树管理', 28, NULL, 0, 'fa fa-circle-o', NULL, 'admin/menu/tree.htm', 'menu', 2, NULL),
	(57, '2021-04-09 19:04:20', NULL, '1,57', '2021-04-09 19:04:20', 2, 88, '内容管理', 107, 0, 0, 'fa fa-circle-o', NULL, '', '57', 1, 0),
	(58, '2021-04-09 19:04:30', NULL, '1,57,58', '2021-04-09 19:04:30', 3, 89, '模块管理', 90, NULL, 0, 'fa fa-circle-o', NULL, 'admin/modular/view_list.htm', 'modular', 57, NULL),
	(59, '2021-04-09 19:04:55', NULL, '1,57,59', '2021-04-09 19:04:55', 3, 91, '产品管理', 92, NULL, 0, 'fa fa-circle-o', NULL, 'admin/product/view_list.htm', 'product', 57, NULL),
	(60, '2021-04-09 19:05:02', NULL, '1,57,60', '2021-04-09 19:05:02', 3, 93, '解决方案', 94, NULL, 0, 'fa fa-circle-o', NULL, 'admin/solution/view_list.htm', 'solution', 57, NULL),
	(61, '2021-04-09 19:05:10', NULL, '1,57,61', '2021-04-09 19:05:10', 3, 95, '新闻管理', 96, NULL, 0, 'fa fa-circle-o', NULL, 'admin/news/view_list.htm', 'news', 57, NULL),
	(63, '2021-04-09 19:05:41', NULL, '1,57,63', '2021-04-09 19:05:41', 3, 97, '研发动态管理', 98, NULL, 0, 'fa fa-circle-o', NULL, 'admin/develop/view_list.htm', 'develop', 57, NULL),
	(64, '2021-04-18 10:08:48', NULL, '1,57,64', '2021-04-18 10:08:48', 3, 99, '客户案例', 100, NULL, 0, 'fa fa-circle-o', NULL, 'admin/example/view_list.htm', 'example', 57, NULL),
	(65, '2021-04-18 15:56:23', NULL, '1,57,65', '2021-04-18 15:56:23', 3, 101, '案例分类管理', 102, NULL, 0, 'fa fa-circle-o', NULL, 'admin/examplecatalog/view_list.htm', 'examplecatalog', 57, NULL),
	(66, '2021-07-15 11:23:28', NULL, '1,57,66', '2021-07-15 11:23:28', 3, 103, '招聘管理', 104, NULL, 0, 'fa fa-circle-o', NULL, 'admin/job/view_list.htm', 'job', 57, NULL),
	(67, '2021-07-15 11:23:57', NULL, '1,57,67', '2021-07-15 11:23:57', 3, 105, '相册管理', 106, NULL, 0, 'fa fa-circle-o', NULL, 'admin/album/view_list.htm', 'album', 57, NULL);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
