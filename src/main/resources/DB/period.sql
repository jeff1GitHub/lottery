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

--生成日期的期数
INSERT INTO lottery.t_period (
  `code`,
  game_id,
  start_time,
  end_time,
  finish_time,
  result,
  `status`
)
SELECT
	LPAD(id, 3, '000') AS `code`,
	game_id,
	DATE_ADD(@dt, INTERVAL start_time HOUR_SECOND) AS start_time,
	DATE_ADD(@dt, INTERVAL end_time HOUR_SECOND) AS end_time,
	DATE_ADD(@dt, INTERVAL finish_time HOUR_SECOND) AS finish_time,
	'' result,
	0 `status`
FROM base_period ORDER BY id

--查询档期期数
select * from t_period where @dt >= start_time and @dt < finish_time
