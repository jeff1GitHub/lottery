--生成期数模板存储过程
CREATE PROCEDURE `p_create_period`()
BEGIN
	DECLARE startTime TIME DEFAULT '00:00';
	DECLARE endTime TIME;
	DECLARE finishTime TIME;
	DECLARE endIntervalTime INT DEFAULT 4*60;
	DECLARE finishIntervalTime INT DEFAULT 5*60;
	DECLARE i INT DEFAULT 1;

	while i <= 120 do
		set endTime = DATE_ADD(startTime, INTERVAL endIntervalTime HOUR_SECOND);
		set finishTime = DATE_ADD(startTime, INTERVAL finishIntervalTime HOUR_SECOND);
		INSERT INTO lottery.base_period (game_id, start_time, end_time, finish_time) VALUES (1, startTime, endTime, finishTime);
		set i=i+1;
        
        if finishTime = '02:00:00' then
			set startTime = '10:00';
			set endIntervalTime = 9 * 60;
			set finishIntervalTime = 10 * 60;
        elseif finishTime = '22:00:00' then
			set endIntervalTime = 4 * 60;
			set finishIntervalTime = 5 * 60;
            set startTime = finishTime;
		else
			set startTime = finishTime;
        end if;
	end while;
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
