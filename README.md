# AdminStore
[![maven](https://img.shields.io/maven-central/v/com.quhaodian/user_hibernate.svg)](http://mvnrepository.com/artifact/com.quhaodian/user_hibernate/1.8.5)
[![QQ](https://img.shields.io/badge/chat-on%20QQ-ff69b4.svg?style=flat-square)](//shang.qq.com/wpa/qunwpa?idkey=d1a308945e4b2ff8aeb1711c2c7914342dae15e9ce7041e94756ab355430dc78)
[![Apache-2.0](https://img.shields.io/hexpm/l/plug.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![使用IntelliJ IDEA开发维护](https://img.shields.io/badge/IntelliJ%20IDEA-提供支持-blue.svg)](https://www.jetbrains.com/idea/)
[![GitHub forks](https://img.shields.io/github/stars/cng1985/adminstore.svg?style=social&logo=github&label=Stars)](https://github.com/cng1985/adminstore)

本源码包采用maven结构

## 环境要求

- JDK6或更高版本（支持JDK7、JDK8）。建议使用JDK8，有更好的内存管理。更低版本的JDK6、JDK7可能需要设置Java内存`-XX:PermSize=128M -XX:MaxPermSize=512M`，否则可能出现这种类型的内存溢出：`java.lang.OutOfMemoryError: PermGen space`。
- Servlet2.5或更高版本（如Tomcat6或更高版本）。
- MySQL5.0或更高版本
- Maven3.0或更高版本。

## 技术选型：

* SSH (Spring、SpringMVC、Hibernate）
* 安全权限 Shiro
* 缓存 Ehcache
* 视图模板 freemarker 
* 工作流引擎  activiti(7.x系列目前最新版本) 
* 定时任务  quartz
* [discover](https://gitee.com/quhaodian/disconver)
* AdminLTE
* bootstrap

## 搭建步骤

1. 创建数据库。如使用MySQL，字符集选择为`utf8`或者`utf8mb4`（支持更多特殊字符，推荐）。
2. 执行数据库脚本。数据库脚本在`database`目录下。
3. 创建mysql数据库，导入`adminstore.sql`
4. 在idea中导入maven项目。点击idea菜单`File` - `open`，选择`项目路径`。创建好maven项目后，会开始从maven服务器下载第三方jar包（如spring等），需要一定时间，请耐心等待。
5. 修改数据库连接。打开`/web/src/main/resources/jdbc.propertis`文件，根据实际情况修改`jdbc.url`、`jdbc.username`、`jdbc.password`的值。
6. 运行程序。在idea中，右键点击项目名，选择`Run` - `Run`-`Edit Configurations`-`+`-`Maven`，在`Working directory`选择项目路径 ，在`Command Line`填入`jetty:run`或`tomcat7:run`，然后点击`Run`。
7. 访问系统。前台地址：[http://localhost:8080/web](http://localhost:8080/web/)，手机站地址：[http://127.0.0.1:8080/web/](http://127.0.0.1:8080/web/)；后台地址：[http://localhost:8080/web/login.htm](http://localhost:8080/web/login.htm)，用户名：admin，密码：123456。


## 交流方式

* QQ群:141837028   [discover开源QQ群](//shang.qq.com/wpa/qunwpa?idkey=d1a308945e4b2ff8aeb1711c2c7914342dae15e9ce7041e94756ab355430dc78)

## 界面效果

![部分er图](http://image.yichisancun.com/bd042b2c2a55f57bc6dc3d3568a790ed "部分er图")
![菜单管理功能](http://image.yichisancun.com/7075c8f053f0b2aa0f06ad08b750029d "菜单管理功能")
![模板管理功能](http://image.yichisancun.com/f932a35746388fea26d761420d3cf4fe "模板管理功能")
![插件管理功能](http://image.yichisancun.com/70026a48c20b7ab6c10e59700db302e3 "插件管理功能")
![登陆日志管理功能](http://image.yichisancun.com/25c3c517571f72eae5dc9fb53b2c5a0f "登陆日志管理功能")

## 已经使用的项目

* [ucms](https://gitee.com/cng1985/iwan)


