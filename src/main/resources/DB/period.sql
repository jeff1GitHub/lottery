--生成期数模板存储过程
CREATE DEFINER=`root`@`localhost` PROCEDURE `p_create_period`()
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
END

--插入彩票基础数据
insert into t_lottery(f_id, f_name, f_type) values(1, '重庆时时彩', 1);

--投注项基础数据
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('1', '总和大', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('2', '总和小', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('3', '总和单', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('4', '总和双', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('5', '龙', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('6', '虎', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('7', '和', '1', '9');

INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('8', '第一球大', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('9', '第一球小', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('10', '第一球单', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('11', '第一球双', '1', '1.995');

INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('12', '第二球大', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('13', '第二球小', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('14', '第二球单', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('15', '第二球双', '1', '1.995');

INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('16', '第三球大', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('17', '第三球小', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('18', '第三球单', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('19', '第三球双', '1', '1.995');

INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('20', '第四球大', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('21', '第四球小', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('22', '第四球单', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('23', '第四球双', '1', '1.995');

INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('24', '第五球大', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('25', '第五球小', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('26', '第五球单', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('27', '第五球双', '1', '1.995');

INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('28', '总和尾数0', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('29', '总和尾数1', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('30', '总和尾数2', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('31', '总和尾数3', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('32', '总和尾数4', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('33', '总和尾数5', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('34', '总和尾数6', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('35', '总和尾数7', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('36', '总和尾数8', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('37', '总和尾数9', '1', '1.995');

INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('38', '第一球0', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('39', '第一球1', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('41', '第一球2', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('42', '第一球3', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('43', '第一球4', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('44', '第一球5', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('45', '第一球6', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('46', '第一球7', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('47', '第一球8', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('48', '第一球9', '1', '1.995');

INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('49', '第二球0', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('50', '第二球1', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('51', '第二球2', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('52', '第二球3', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('53', '第二球4', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('54', '第二球5', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('55', '第二球6', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('56', '第二球7', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('57', '第二球8', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('58', '第二球9', '1', '1.995');

INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('59', '第三球0', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('60', '第三球1', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('61', '第三球2', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('62', '第三球3', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('63', '第三球4', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('64', '第三球5', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('65', '第三球6', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('66', '第三球7', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('67', '第三球8', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('68', '第三球9', '1', '1.995');

INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('69', '第四球0', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('70', '第四球1', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('71', '第四球2', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('72', '第四球3', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('73', '第四球4', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('74', '第四球5', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('75', '第四球6', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('76', '第四球7', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('77', '第四球8', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('78', '第四球9', '1', '1.995');

INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('79', '第五球0', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('80', '第五球1', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('81', '第五球2', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('82', '第五球3', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('83', '第五球4', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('84', '第五球5', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('85', '第五球6', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('86', '第五球7', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('87', '第五球8', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('88', '第五球9', '1', '1.995');

INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('89', '前三豹子', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('90', '中三豹子', '1', '1.995');
INSERT INTO `lottery`.`t_project` (`f_id`, `f_name`, `f_lottery_id`, `f_odds`) VALUES ('91', '后三豹子', '1', '1.995');

