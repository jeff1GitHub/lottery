--生成期数模板存储过程
CREATE DEFINER=`root`@`localhost` PROCEDURE `p_create_period`()
BEGIN
	DECLARE startTime time DEFAULT '10:00';
	DECLARE endTime TIME;
	DECLARE finishTime TIME;
	DECLARE endIntervalTime INT DEFAULT 9*60;
	DECLARE finishIntervalTime INT DEFAULT 10*60;
	DECLARE i INT DEFAULT 1;

	while i<=120 do
		SET endTime = DATE_ADD(startTime, INTERVAL endIntervalTime HOUR_SECOND);
		SET finishTime = DATE_ADD(startTime, INTERVAL finishIntervalTime HOUR_SECOND);
		INSERT INTO lottery.base_period (game_id, start_time, end_time, finish_time) VALUES (1, startTime, endTime, finishTime);
		set i=i+1;
		if i = 73 then
			SET endIntervalTime = 4 * 60;
			set finishIntervalTime = 5 * 60;
		end if;
		set startTime = finishTime;
	end while;
END

--生成明天的期数
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