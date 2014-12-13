/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : crw_data

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2014-06-18 18:04:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(255) DEFAULT NULL,
  `exam_type` int(11) NOT NULL,
  `hours` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `department_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_43qlng9c3drm9nwg9e6erqj87` (`department_id`),
  CONSTRAINT `FK_43qlng9c3drm9nwg9e6erqj87` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '数据结构（）', '0', '40', '数据结构', '1');
INSERT INTO `course` VALUES ('3', '电路三合一', '0', '30', '电路与电子技术', '2');
INSERT INTO `course` VALUES ('4', '汤子瀛', '0', '30', '操作系统', '1');
INSERT INTO `course` VALUES ('5', '', '2', '30', 'java程序设计', '1');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `student_sum` int(11) NOT NULL,
  `teacher_sum` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '信息科学与工程学院', '800', '100');
INSERT INTO `department` VALUES ('2', '电气与自动化工程学院', '500', '100');
INSERT INTO `department` VALUES ('4', '理学院', '500', '100');
INSERT INTO `department` VALUES ('5', '外国语学院', '500', '100');
INSERT INTO `department` VALUES ('6', '矿业与安全工程学院', '500', '100');
INSERT INTO `department` VALUES ('7', '测绘科学与工程学院', '500', '100');
INSERT INTO `department` VALUES ('8', '地球科学与工程学院', '500', '100');
INSERT INTO `department` VALUES ('9', '土木工程与建筑学院', '500', '100');
INSERT INTO `department` VALUES ('10', '机械电子工程学院', '500', '100');
INSERT INTO `department` VALUES ('11', '经济管理学院', '500', '100');
INSERT INTO `department` VALUES ('12', '电子通信与物理学院', '500', '100');
INSERT INTO `department` VALUES ('13', '化学与环境工程学院', '500', '100');
INSERT INTO `department` VALUES ('14', '材料科学与工程学院', '500', '100');
INSERT INTO `department` VALUES ('15', '交通学院', '500', '100');
INSERT INTO `department` VALUES ('16', '文法学院', '500', '100');
INSERT INTO `department` VALUES ('17', '艺术与设计学院', '500', '100');
INSERT INTO `department` VALUES ('18', '马克思主义学院', '500', '100');
INSERT INTO `department` VALUES ('19', '体育学院', '500', '100');
INSERT INTO `department` VALUES ('20', '继续教育学院', '500', '100');
INSERT INTO `department` VALUES ('22', '全校公共', '1000', '20000');

-- ----------------------------
-- Table structure for exercises_answer
-- ----------------------------
DROP TABLE IF EXISTS `exercises_answer`;
CREATE TABLE `exercises_answer` (
  `answer_id` bigint(20) NOT NULL,
  `answer_name` varchar(100) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `answer_path` varchar(100) NOT NULL,
  `course_id` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`answer_id`),
  KEY `exercises_answer_ibfk_1` (`user_id`),
  KEY `exercises_answer_ibfk_2` (`course_id`),
  CONSTRAINT `exercises_answer_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `exercises_answer_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exercises_answer
-- ----------------------------

-- ----------------------------
-- Table structure for exercises_topic
-- ----------------------------
DROP TABLE IF EXISTS `exercises_topic`;
CREATE TABLE `exercises_topic` (
  `exercises_id` bigint(20) NOT NULL,
  `exercises_name` varchar(100) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `exercises_path` varchar(100) NOT NULL,
  `course_id` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  `d_times` int(12) unsigned zerofill NOT NULL,
  `exercises_content` varchar(2000) DEFAULT NULL,
  `exercises_score` float(255,0) DEFAULT NULL,
  `check_advice` varchar(2000) DEFAULT NULL,
  `is_checked` varchar(1) NOT NULL,
  PRIMARY KEY (`exercises_id`),
  KEY `exercises_topic_ibfk_1` (`user_id`),
  KEY `exercises_topic_ibfk_2` (`course_id`),
  CONSTRAINT `exercises_topic_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `exercises_topic_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exercises_topic
-- ----------------------------

-- ----------------------------
-- Table structure for homework_answer
-- ----------------------------
DROP TABLE IF EXISTS `homework_answer`;
CREATE TABLE `homework_answer` (
  `answer_id` bigint(20) NOT NULL,
  `answer_name` varchar(100) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `answer_path` varchar(100) NOT NULL,
  `course_id` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`answer_id`),
  KEY `homework_answer_ibfk_1` (`user_id`),
  KEY `homework_answer_ibfk_2` (`course_id`),
  CONSTRAINT `homework_answer_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `homework_answer_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of homework_answer
-- ----------------------------

-- ----------------------------
-- Table structure for homework_topic
-- ----------------------------
DROP TABLE IF EXISTS `homework_topic`;
CREATE TABLE `homework_topic` (
  `homework_id` bigint(20) NOT NULL,
  `homework_name` varchar(100) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `homework_path` varchar(100) NOT NULL,
  `corse_id` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  `d_times` int(12) unsigned zerofill NOT NULL,
  PRIMARY KEY (`homework_id`),
  KEY `homework_topic_ibfk_1` (`user_id`),
  KEY `homework_topic_ibfk_2` (`corse_id`),
  CONSTRAINT `homework_topic_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `homework_topic_ibfk_2` FOREIGN KEY (`corse_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of homework_topic
-- ----------------------------

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `text` varchar(300) NOT NULL,
  `stu_id` int(12) NOT NULL,
  `tec_id` int(12) NOT NULL,
  `time` datetime NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `reply` varchar(300) DEFAULT NULL,
  `flag` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', 'ssh2需要的jar包', '具体jar包的功能是什么？', '4', '0', '2014-06-08 09:04:54', '1', '看书', '0');
INSERT INTO `question` VALUES ('2', 'test1', 'laksjfajslkdfjalk', '4', '0', '2014-06-08 09:16:38', '0', null, '0');
INSERT INTO `question` VALUES ('3', 'test2', 'askdfgklasl', '4', '0', '2014-06-08 09:16:51', '0', null, '1');
INSERT INTO `question` VALUES ('4', '哈哈哈哈', '哈哈哈哈哈快快快', '4', '0', '2014-06-10 08:21:23', '0', null, '0');

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `d_times` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  `name` varchar(100) NOT NULL,
  `path` varchar(255) NOT NULL,
  `course_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ltb9krcibi8y9drajnxnvbfp9` (`course_id`),
  KEY `FK_jxdy8bryv19kw1c8cghxvi3de` (`user_id`),
  CONSTRAINT `FK_jxdy8bryv19kw1c8cghxvi3de` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ltb9krcibi8y9drajnxnvbfp9` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('10', '4', '2014-06-05 22:02:21', 'Hadoop.txt', 'resources\\r_3\\', '1', '3', 'text/plain');
INSERT INTO `resource` VALUES ('11', '0', '2014-06-06 15:38:35', 'crw_data.sql', 'resources\\r_0\\', '1', '0', 'application/octet-stream');
INSERT INTO `resource` VALUES ('12', '0', '2014-06-10 08:09:28', 'test.ppt', 'resources\\r_3\\', '1', '3', 'application/vnd.ms-powerpoint');

-- ----------------------------
-- Table structure for test_answer
-- ----------------------------
DROP TABLE IF EXISTS `test_answer`;
CREATE TABLE `test_answer` (
  `answer_id` bigint(20) NOT NULL,
  `answer_name` varchar(100) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `answer_path` varchar(100) NOT NULL,
  `course_id` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`answer_id`),
  KEY `test_answer_ibfk_1` (`user_id`),
  KEY `test_answer_ibfk_2` (`course_id`),
  CONSTRAINT `test_answer_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `test_answer_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_answer
-- ----------------------------

-- ----------------------------
-- Table structure for test_topic
-- ----------------------------
DROP TABLE IF EXISTS `test_topic`;
CREATE TABLE `test_topic` (
  `test_id` bigint(20) NOT NULL,
  `test_name` varchar(100) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `test_path` varchar(100) NOT NULL,
  `course_id` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  `d_times` int(12) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`test_id`),
  KEY `test_topic_ibfk_1` (`user_id`),
  KEY `test_topic_ibfk_2` (`course_id`),
  CONSTRAINT `test_topic_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `test_topic_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_topic
-- ----------------------------

-- ----------------------------
-- Table structure for t_c
-- ----------------------------
DROP TABLE IF EXISTS `t_c`;
CREATE TABLE `t_c` (
  `id` bigint(20) NOT NULL,
  `c_id` bigint(20) NOT NULL,
  `t_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_7xc6lyr4vnirg3j8iepjh84ol` (`c_id`),
  KEY `FK_o6pk39uju96bbsstn2ffb2unj` (`t_id`),
  CONSTRAINT `FK_7xc6lyr4vnirg3j8iepjh84ol` FOREIGN KEY (`c_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_o6pk39uju96bbsstn2ffb2unj` FOREIGN KEY (`t_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_c
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `r_date` datetime NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `sex` tinyint(1) NOT NULL,
  `state` tinyint(1) NOT NULL,
  `tel` bigint(20) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `department_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tb5gq05t7xhddh2idsdy8ddd` (`department_id`),
  CONSTRAINT `FK_tb5gq05t7xhddh2idsdy8ddd` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0', '2014-06-05 21:33:33', null, '202cb962ac59075b964b07152d234b70', '0', '0', null, '0', '管理员', '1');
INSERT INTO `user` VALUES ('3', '2014-06-05 21:56:05', '', '202cb962ac59075b964b07152d234b70', '0', '1', '0', '1', '老师甲', '1');
INSERT INTO `user` VALUES ('4', '2014-06-06 22:24:50', '', '202cb962ac59075b964b07152d234b70', '0', '1', '0', '2', '学生乙', '1');
INSERT INTO `user` VALUES ('5', '2014-06-08 09:15:42', '', '202cb962ac59075b964b07152d234b70', '0', '1', '0', '2', '学生甲', '1');
