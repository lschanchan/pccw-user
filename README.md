1.mysql info
Username:root
Pwd:123456
Database:pccw-user
table:t_user

CREATE TABLE `t_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `user_name` varchar(200) DEFAULT NULL COMMENT 'username',
  `email` varchar(200) DEFAULT NULL COMMENT 'email',
  `age` int(11) DEFAULT NULL COMMENT 'age',
  `created_time` timestamp NULL DEFAULT NULL COMMENT ‘create_time',
  `update_time` timestamp NULL DEFAULT NULL COMMENT ‘update_time’,
  `deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT ‘0 no deleted, 1 deleted’,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

2.rest API document
http://localhost:8088/swagger-ui.html

3.validation
Ref:com.pccw.user.validation.UserValidation
Ensure that the user name and email address are unique to the same user from the business code

4.error handle
Ref:com.pccw.user.exception.ExceptionHandle


5.test
Ref:com.pccw.user.UserDemo1ApplicationTests


6.how to run via docker
6.1 dockerfile
/src/main/docker/dockerfile
6.2 jar 
/src/main/docker/demo-0.0.1-SNAPSHOT-exec.jar


6.3 make docker image
 mvn package docker:build  

6.4 run by cmd
docker run -p 8080:8080 -t springboot/demo
