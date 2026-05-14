# AGENTS.md

## Cursor Cloud specific instructions

### Overview

AdminStore is a Java (Spring MVC + Hibernate) admin panel / CMS. It's a Maven multi-module project (`modules/business`, `modules/analysis`, `web`) deployed via embedded Jetty.

### System Dependencies

- **JDK 8** (`/usr/lib/jvm/java-8-openjdk-amd64`): Must set `JAVA_HOME` before running Maven commands.
- **Maven 3.x**: Installed via apt.
- **MySQL 8.x**: Installed via apt; post-install script may fail in Docker — start manually with `sudo mysqld --user=mysql --daemonize`.

### Starting MySQL

```
sudo chmod 755 /var/run/mysqld/
sudo mysqld --user=mysql --daemonize
```

The socket directory permissions must be relaxed (`chmod 755`) after each MySQL start for non-root clients to connect.

### Database Setup

- Database: `adminstore` (utf8mb4)
- Credentials in `web/src/main/resources/jdbc.properties`: root / 123.com
- Schema: `mysql -u root -p'123.com' adminstore < documents/adminstore.sql`
- The SQL dump does NOT include user data. An admin account must be created manually.
- Password hashing: SHA-1, 1024 iterations, 8-byte random salt (hex-encoded). See the `SecurityUtil` class in the discover framework.

### Missing Maven Artifacts (discover framework)

Several `com.haoxuer.discover` artifacts at version `3.1.4-20201031` are NOT published to Maven Central. They must be built from the [Gitee repo](https://gitee.com/cng1985/discover.git) at commit `70dac1f9`:

```
git clone https://gitee.com/cng1985/discover.git /tmp/discover
cd /tmp/discover && git checkout 70dac1f938be6b3e2efe704b522c131cac8888ac
```

Missing modules to build (each with `mvn install -DskipTests -Dgpg.skip=true -Dmaven.javadoc.skip=true -pl <module> --no-transfer-progress`):
- `discover-common/discover-common-eventdispatcher`
- `discover-common/discover-common-security`
- `discover-common/discover-common-interceptor`
- `discover-common/discover-common-freemarker`

Additionally, `ChainMake.java` in `discover-common/discover-common-make` must be patched with `getMenus()`/`setMenus(String)` methods for the adminstore `App.java` to compile.

### Maven HTTP Mirror Issue

Maven 3.8.1+ blocks HTTP repositories. The `pom.xml` references `http://maven.aliyun.com/...`. Create `~/.m2/settings.xml` mirroring `aliyun` to Maven Central (HTTPS):

```xml
<settings>
  <mirrors>
    <mirror>
      <id>central-https</id>
      <mirrorOf>aliyun</mirrorOf>
      <url>https://repo1.maven.org/maven2/</url>
    </mirror>
  </mirrors>
</settings>
```

### Build and Run

```
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
cd /workspace
mvn compile                   # compile only
mvn jetty:run                 # run dev server on port 8080
```

Access: http://localhost:8080/web/login.htm (admin / 123456)

### Key Notes

- The project has no automated tests (`maven-surefire-plugin` skip=true in root POM).
- Hibernate `hbm2ddl.auto=update` auto-creates/alters DB tables on startup.
- Some admin pages may show SQL errors for columns added by newer Hibernate schema updates not in the base SQL dump — this is expected and resolves after the first Jetty startup (Hibernate updates the schema).
