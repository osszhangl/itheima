--学习测试样例
INSERT INTO `user`` (`id`, `username`, `birthday`, `sex`, `address`) VALUES (1, '老王', '2018-2-12 00:00:00', '男', '北京');
INSERT INTO `user` (`id`, `username`, `birthday`, `sex`, `address`) VALUES (21, '小二王', '2018-3-12 00:00:00', '女', '北京金燕龙');
INSERT INTO `user` (`id`, `username`, `birthday`, `sex`, `address`) VALUES (22, '小二王', '2018-2-12 00:00:00', '女', '北京金燕龙');
INSERT INTO `user` (`id`, `username`, `birthday`, `sex`, `address`) VALUES (23, '传智播客', '2018-2-12 00:00:00', '男', '北京金燕龙');
INSERT INTO `user` (`id`, `username`, `birthday`, `sex`, `address`) VALUES (24, '老王', '2018-2-12 00:00:00', '男', '北京');
INSERT INTO `user` (`id`, `username`, `birthday`, `sex`, `address`) VALUES (25, '小马宝莉', '2018-2-12 00:00:00', '女', '北京修正');


CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;


CREATE TABLE `account` (
  `id` int(11) NOT NULL comment '编号',
  `uid` int(11) default NULL COMMENT '用户编号',
  `money` double DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`id`)，
	KEY `FK_Reference_8` (uid),
	CONSTRAINT `FK_Reference_8`FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
)

INSERT into `account` (id,uid,money) VALUES (1,21,1000),(2,22,1000),(3,23,2000)













