    server {
      listen       80;
      server_name  www.haoxuer.com;
      rewrite ^(.*)$  https://$host$1 permanent;
    }

    mvn dependency:tree