--生成期数模板存储过程
DELIMITER $$
DROP PROCEDURE IF EXISTS `p_create_period`$$
CREATE PROCEDURE `p_create_period`()
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
	END$$
DELIMITER ;

--插入彩票基础数据
insert into t_lottery(f_id, f_name, f_type) values(1, '澳门时时彩', 1);

--投注项基础数据
TRUNCATE t_project;
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('总和大', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('总和小', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('总和单', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('总和双', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('龙', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('虎', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('和', '1', '9.5');

INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第一球大', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第一球小', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第一球单', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第一球双', '1', '1.95');

INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第二球大', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第二球小', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第二球单', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第二球双', '1', '1.95');

INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第三球大', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第三球小', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第三球单', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第三球双', '1', '1.95');

INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第四球大', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第四球小', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第四球单', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第四球双', '1', '1.95');

INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第五球大', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第五球小', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第五球单', '1', '1.95');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第五球双', '1', '1.95');

INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('总和尾数0', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('总和尾数1', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('总和尾数2', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('总和尾数3', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('总和尾数4', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('总和尾数5', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('总和尾数6', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('总和尾数7', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('总和尾数8', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('总和尾数9', '1', '9.65');

INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第一球0', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第一球1', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第一球2', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第一球3', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第一球4', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第一球5', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第一球6', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第一球7', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第一球8', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第一球9', '1', '9.65');

INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第二球0', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第二球1', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第二球2', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第二球3', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第二球4', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第二球5', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第二球6', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第二球7', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第二球8', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第二球9', '1', '9.65');

INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第三球0', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第三球1', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第三球2', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第三球3', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第三球4', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第三球5', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第三球6', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第三球7', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第三球8', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第三球9', '1', '9.65');

INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第四球0', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第四球1', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第四球2', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第四球3', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第四球4', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第四球5', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第四球6', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第四球7', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第四球8', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第四球9', '1', '9.65');

INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第五球0', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第五球1', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第五球2', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第五球3', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第五球4', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第五球5', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第五球6', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第五球7', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第五球8', '1', '9.65');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('第五球9', '1', '9.65');

INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('前三豹子', '1', '66');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('中三豹子', '1', '66');
INSERT INTO `lottery`.`t_project` (`f_name`, `f_lottery_id`, `f_odds`) VALUES ('后三豹子', '1', '66');
