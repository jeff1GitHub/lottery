/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : lottery

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-01-03 02:25:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_betting`
-- ----------------------------
DROP TABLE IF EXISTS `t_betting`;
CREATE TABLE `t_betting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '注单流水号',
  `period` varchar(255) NOT NULL COMMENT '期号',
  `betting_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '投注时间',
  `lottery_id` int(11) NOT NULL COMMENT '彩票id',
  `project` int(11) NOT NULL COMMENT '投注项',
  `odds` decimal(10,0) NOT NULL COMMENT '赔率',
  `money` decimal(10,0) NOT NULL COMMENT '投注金额',
  `square` int(11) NOT NULL DEFAULT '0' COMMENT '是否结算',
  `square_time` timestamp NULL DEFAULT NULL COMMENT '结算时间',
  `prize` int(11) NOT NULL DEFAULT '0' COMMENT '是否派彩',
  `prize_time` timestamp NULL DEFAULT NULL COMMENT '派奖时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_betting
-- ----------------------------

-- ----------------------------
-- Table structure for `t_lottery`
-- ----------------------------
DROP TABLE IF EXISTS `t_lottery`;
CREATE TABLE `t_lottery` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `name` varchar(255) NOT NULL COMMENT '彩票名称',
  `type` int(11) NOT NULL COMMENT '彩票类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_lottery
-- ----------------------------

-- ----------------------------
-- Table structure for `t_period`
-- ----------------------------
DROP TABLE IF EXISTS `t_period`;
CREATE TABLE `t_period` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `code` varchar(255) NOT NULL COMMENT '期号',
  `game_id` int(11) NOT NULL COMMENT '彩票id',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '开盘时间',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '封盘时间',
  `finish_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '开奖时间',
  `result` varchar(255) NOT NULL COMMENT '开奖结果',
  `status` int(11) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_period
-- ----------------------------

-- ----------------------------
-- Table structure for `t_project`
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project` (
  `id` int(11) NOT NULL COMMENT '项目编号',
  `name` varchar(255) NOT NULL COMMENT '项目名称',
  `lottery_id` int(11) NOT NULL COMMENT '彩票id',
  `odds` decimal(10,0) NOT NULL COMMENT '赔率',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_project
-- ----------------------------
