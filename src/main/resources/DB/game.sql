/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.7.17 : Database - lottery
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lottery` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lottery`;

/*Table structure for table `t_betting` */

DROP TABLE IF EXISTS `t_betting`;

CREATE TABLE `t_betting` (
  `f_id` bigint(20) NOT NULL COMMENT '注单流水号',
  `f_user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `f_user_name` varchar(20) NOT NULL COMMENT '用户名称',
  `f_period` varchar(20) NOT NULL COMMENT '期号',
  `f_betting_time` datetime NOT NULL COMMENT '投注时间',
  `f_lottery_id` int(11) NOT NULL COMMENT '彩票id',
  `f_project` int(11) NOT NULL COMMENT '投注项',
  `f_odds` decimal(6,3) NOT NULL COMMENT '赔率',
  `f_money` decimal(10,2) NOT NULL COMMENT '投注金额',
  `f_square` int(11) NOT NULL DEFAULT '0' COMMENT '是否结算',
  `f_square_money` decimal(10,2) DEFAULT NULL COMMENT '结算金额',
  `f_square_time` datetime DEFAULT NULL COMMENT '结算时间',
  `f_prize` int(11) NOT NULL DEFAULT '0' COMMENT '是否派彩',
  `f_prize_time` datetime DEFAULT NULL COMMENT '派奖时间',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_lottery` */

DROP TABLE IF EXISTS `t_lottery`;

CREATE TABLE `t_lottery` (
  `f_id` int(11) NOT NULL COMMENT '流水号',
  `f_name` varchar(10) NOT NULL COMMENT '彩票名称',
  `f_type` int(11) NOT NULL COMMENT '彩票类型',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_manager` */

DROP TABLE IF EXISTS `t_manager`;

CREATE TABLE `t_manager` (
  `f_id` bigint(20) NOT NULL COMMENT '管理员编号',
  `f_name` varchar(20) NOT NULL COMMENT '账号',
  `f_pwd` char(32) NOT NULL COMMENT '密码',
  `f_create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`f_id`),
  UNIQUE KEY `f_name_UNIQUE` (`f_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_period` */

DROP TABLE IF EXISTS `t_period`;

CREATE TABLE `t_period` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `f_code` varchar(20) NOT NULL COMMENT '期号',
  `f_date` char(10) NOT NULL COMMENT '日期',
  `f_game_id` int(11) NOT NULL COMMENT '彩票id',
  `f_start_time` datetime NOT NULL COMMENT '开盘时间',
  `f_end_time` datetime NOT NULL COMMENT '封盘时间',
  `f_finish_time` datetime NOT NULL COMMENT '开奖时间',
  `f_result` varchar(20) NOT NULL COMMENT '开奖结果',
  `f_status` int(1) NOT NULL COMMENT '状态(-1:未开奖 1:已开奖)',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_period_template` */

DROP TABLE IF EXISTS `t_period_template`;

CREATE TABLE `t_period_template` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `f_game_id` int(11) NOT NULL COMMENT '游戏编号',
  `f_code` varchar(10) NOT NULL COMMENT '期号',
  `f_start_time` time NOT NULL COMMENT '开盘时间',
  `f_end_time` time NOT NULL COMMENT '封盘时间',
  `f_finish_time` time NOT NULL COMMENT '开奖时间',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_project` */

DROP TABLE IF EXISTS `t_project`;

CREATE TABLE `t_project` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '项目编号',
  `f_name` varchar(10) NOT NULL COMMENT '项目名称',
  `f_lottery_id` int(11) NOT NULL COMMENT '彩票id',
  `f_odds` decimal(6,3) NOT NULL COMMENT '赔率',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `f_id` bigint(20) NOT NULL COMMENT '用户编号',
  `f_name` varchar(20) NOT NULL COMMENT '账号',
  `f_pwd` char(32) NOT NULL COMMENT '密码',
  `f_create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`f_id`),
  UNIQUE KEY `f_name_UNIQUE` (`f_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Procedure structure for procedure `p_create_period` */

/*!50003 DROP PROCEDURE IF EXISTS  `p_create_period` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`lottery`@`%` PROCEDURE `p_create_period`()
BEGIN

		DECLARE startTime TIME DEFAULT '00:00';

		DECLARE endTime TIME;

		DECLARE finishTime TIME;

		DECLARE endIntervalTime INT DEFAULT 4*60;

		DECLARE finishIntervalTime INT DEFAULT 5*60;

		DECLARE i INT DEFAULT 1;



		WHILE i <= 120 DO

			SET endTime = DATE_ADD(startTime, INTERVAL endIntervalTime HOUR_SECOND);

			SET finishTime = DATE_ADD(startTime, INTERVAL finishIntervalTime HOUR_SECOND);

			INSERT INTO t_period_template(f_game_id, f_code, f_start_time, f_end_time, f_finish_time) VALUES(1, i, startTime, endTime, finishTime);

			SET i=i+1;

			

			IF finishTime = '02:00:00' THEN

				SET startTime = '10:00';

				SET endIntervalTime = 9 * 60;

				SET finishIntervalTime = 10 * 60;

			ELSEIF finishTime = '22:00:00' THEN

				SET endIntervalTime = 4 * 60;

				SET finishIntervalTime = 5 * 60;

				SET startTime = finishTime;

			ELSE

				SET startTime = finishTime;

			END IF;

		END WHILE;

	END */$$
DELIMITER ;

/* Procedure structure for procedure `p_data_test` */

/*!50003 DROP PROCEDURE IF EXISTS  `p_data_test` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`lottery`@`%` PROCEDURE `p_data_test`()
BEGIN

		DECLARE betId INT DEFAULT 1;

		DECLARE i INT DEFAULT 1;

		

		WHILE i <= 5000 DO

			SET i=i+1;

			

			INSERT INTO lottery.t_betting (

			  f_id,

			  f_user_id,

			  f_user_name,

			  f_period,

			  f_betting_time,

			  f_lottery_id,

			  f_project,

			  f_odds,

			  f_money

			)

			VALUES

			  (

				betId,

				2018012422320500001,

				'hermes',

				'20180124103',

				'2018-01-24 22:32:05',

				1,

				CEILING(RAND() * 90),

				1.995,

				CEILING(RAND() * 100)

			  );

			

			

			SET betId=betId+1;

		END WHILE;

	END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
