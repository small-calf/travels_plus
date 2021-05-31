CREATE TABLE `t_place` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) COLLATE utf8_czech_ci DEFAULT NULL,
  `picpath` varchar(100) COLLATE utf8_czech_ci DEFAULT NULL COMMENT '景点路径',
  `hottime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '旺季时间',
  `hotticket` double(7,2) DEFAULT NULL COMMENT '旺季票价',
  `dimticket` double(7,2) DEFAULT NULL COMMENT '淡季票价',
  `placeds` varchar(300) COLLATE utf8_czech_ci DEFAULT NULL COMMENT '描述',
  `provinceid` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `t_province` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) COLLATE utf8_czech_ci DEFAULT NULL,
  `tags` varchar(80) COLLATE utf8_czech_ci DEFAULT NULL COMMENT '标签',
  `placecounts` int(4) DEFAULT NULL COMMENT '景点个数',
  PRIMARY KEY (`id`)
);


CREATE TABLE `t_user` (
  `id` int(6) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(60) COLLATE utf8_czech_ci DEFAULT NULL,
  `password` varchar(60) COLLATE utf8_czech_ci DEFAULT NULL,
  `email` varchar(60) COLLATE utf8_czech_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
)