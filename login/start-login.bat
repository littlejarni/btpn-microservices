@ECHO OFF

SET SPRING_PROFILES_ACTIVE=deployment
SET REDIS_HOST=pub-redis-11508.ap-southeast-1-1.1.ec2.garantiadata.com
SET REDIS_PASSWORD=P@ssw0rd
SET REDIS_PORT=11508
SET MYSQL_HOST=localhost
SET MYSQL_PORT=3306
SET MYSQL_DB=platform
SET MYSQL_USER=root
SET MYSQL_PASSWORD=password

CALL mvn spring-boot:run

PAUSE 
