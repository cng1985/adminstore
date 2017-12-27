# AdminStore

本源码包采用maven结构

## 环境要求

- JDK6或更高版本（支持JDK7、JDK8）。建议使用JDK8，有更好的内存管理。更低版本的JDK6、JDK7可能需要设置Java内存`-XX:PermSize=128M -XX:MaxPermSize=512M`，否则可能出现这种类型的内存溢出：`java.lang.OutOfMemoryError: PermGen space`。
- Servlet2.5或更高版本（如Tomcat6或更高版本）。
- MySQL5.0或更高版本
- Maven3.0或更高版本。

## 搭建步骤

1. 创建数据库。如使用MySQL，字符集选择为`utf8`或者`utf8mb4`（支持更多特殊字符，推荐）。
2. 执行数据库脚本。数据库脚本在`database`目录下。
3. 在eclipse中导入maven项目。点击eclipse菜单`File` - `Import`，选择`Maven` - `Existing Maven Projects`。创建好maven项目后，会开始从maven服务器下载第三方jar包（如spring等），需要一定时间，请耐心等待。
4. 修改数据库连接。打开`/src/main/resources/jdbc.propertis`文件，根据实际情况修改`jdbc.url`、`jdbc.username`、`jdbc.password`的值。
5. 运行程序。在eclipse中，右键点击项目名，选择`Run as` - `Maven build...`，`Goals`填入`tomcat6:run`或`tomcat7:run`，然后点击`Run`。
6. 访问系统。前台地址：[http://localhost:8080/web](http://localhost:8080/)，手机站地址：[http://127.0.0.1:8080/](http://127.0.0.1:8080/)；后台地址：[http://localhost:8080/cmscp/index.do](http://localhost:8080/cmscp/index.do)，用户名：admin，密码：空。

## 界面效果

![菜单管理功能](http://image.yichisancun.com/7075c8f053f0b2aa0f06ad08b750029d "菜单管理功能")