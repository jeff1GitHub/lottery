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