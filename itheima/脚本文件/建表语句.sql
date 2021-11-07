CREATE TABLE `account` (
  `id` int(11) NOT NULL DEFAULT '0',
  `uid` int(11) DEFAULT NULL COMMENT '用户编号',
  `money` double DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_8` (`uid`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
  `id` int(11) NOT NULL COMMENT '角色id',
  `role_name` varchar(30) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(60) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

CREATE TABLE `user_role` (
  `uid` int(11) NOT NULL COMMENT '用户id',
  `rid` int(11) NOT NULL COMMENT '角色di',
  PRIMARY KEY (`uid`,`rid`),
  KEY `FK_Reference_10` (`rid`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`rid`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO `user` (`id`, `username`, `birthday`, `sex`, `address`) VALUES (21, '老王update', '2021-7-18 10:37:33', '女', 'update 福州');
INSERT INTO `user` (`id`, `username`, `birthday`, `sex`, `address`) VALUES (22, '小二王', '2018-2-12 00:00:00', '女', '北京金燕龙');
INSERT INTO `user` (`id`, `username`, `birthday`, `sex`, `address`) VALUES (23, '传智播客', '2018-2-12 00:00:00', '男', '北京金燕龙');
INSERT INTO `user` (`id`, `username`, `birthday`, `sex`, `address`) VALUES (24, '老王', '2018-2-12 00:00:00', '男', '北京');
INSERT INTO `user` (`id`, `username`, `birthday`, `sex`, `address`) VALUES (25, '小马宝莉', '2018-2-12 00:00:00', '女', '北京修正');
INSERT INTO `user` (`id`, `username`, `birthday`, `sex`, `address`) VALUES (50, 'zhangsan', '2021-7-17 16:32:15', 'm', '福州');
INSERT INTO `user` (`id`, `username`, `birthday`, `sex`, `address`) VALUES (53, '老王2', '2021-7-17 18:36:45', '女', '北京');
INSERT INTO `user` (`id`, `username`, `birthday`, `sex`, `address`) VALUES (54, '老王2', '2021-7-17 20:32:32', '男', '北京');
INSERT INTO `user` (`id`, `username`, `birthday`, `sex`, `address`) VALUES (57, '自动提交事务', '2021-7-18 16:49:10', '男', '北京');
INSERT INTO `user` (`id`, `username`, `birthday`, `sex`, `address`) VALUES (58, '手动提交事务', '2021-7-18 16:52:22', '男', '北京');
INSERT INTO `user` (`id`, `username`, `birthday`, `sex`, `address`) VALUES (59, '手动提交事务', '2021-7-18 16:53:05', '男', '北京');
INSERT INTO `user` (`id`, `username`, `birthday`, `sex`, `address`) VALUES (61, 'annotation测试update', '2021-7-25 15:40:29', '女', 'update 福州');
INSERT INTO `user` (`id`, `username`, `birthday`, `sex`, `address`) VALUES (62, 'annotation测试', '2021-7-25 15:39:04', '女', '福建省福州市');



INSERT INTO `role` (`id`, `role_name`, `role_desc`) VALUES (1, '院长', '管理整个学院');
INSERT INTO `role` (`id`, `role_name`, `role_desc`) VALUES (2, '总裁', '管理整个公司');
INSERT INTO `role` (`id`, `role_name`, `role_desc`) VALUES (3, '校长', '管理整个学校');


INSERT INTO `account` (`id`, `uid`, `money`) VALUES (1, 21, 5000);
INSERT INTO `account` (`id`, `uid`, `money`) VALUES (2, 22, 1000);
INSERT INTO `account` (`id`, `uid`, `money`) VALUES (3, 23, 2000);
INSERT INTO `account` (`id`, `uid`, `money`) VALUES (4, 21, 2000);
INSERT INTO `account` (`id`, `uid`, `money`) VALUES (5, 22, 200);
INSERT INTO `account` (`id`, `uid`, `money`) VALUES (6, 23, 300);


INSERT INTO `user_role` (`uid`, `rid`) VALUES (21, 1);
INSERT INTO `user_role` (`uid`, `rid`) VALUES (25, 1);
INSERT INTO `user_role` (`uid`, `rid`) VALUES (21, 2);














