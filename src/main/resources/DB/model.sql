CREATE TABLE `t_order` (
`id` int NOT NULL AUTO_INCREMENT,
`game_id` int NOT NULL,
`period` varchar(255) NOT NULL,
`project` int NOT NULL,
`project_value` varchar(255) NOT NULL DEFAULT '',
`user_name` varchar(255) NOT NULL,
`moeny` int NOT NULL,
`open` int NOT NULL DEFAULT 0,
`balance` int NOT NULL DEFAULT 0 COMMENT '是否结算',
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_period` (
`id` int NOT NULL AUTO_INCREMENT,
`code` varchar(255) NOT NULL,
`game_id` int NOT NULL,
`day` date NOT NULL,
`start_time` time NOT NULL,
`end_time` time NOT NULL,
`finish_time` time NOT NULL,
`result` varchar(255) NOT NULL,
`status` int NOT NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `base_period` (
`id` int NOT NULL AUTO_INCREMENT,
`game_id` int NOT NULL,
`start_time` time NOT NULL,
`end_time` time NOT NULL,
`finish_time` time NOT NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `base_reward` (
`id` int NOT NULL AUTO_INCREMENT,
`game_type` int NOT NULL,
`project` int NOT NULL,
`reward` decimal(19,5) NOT NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_reward` (
`id` int NOT NULL AUTO_INCREMENT,
`game_id` int NOT NULL,
`project` int NOT NULL,
`reward` decimal NOT NULL
);

CREATE TABLE `t_betting` (
`id` bigint NOT NULL AUTO_INCREMENT COMMENT '注单流水号',
`period` varchar(255) NOT NULL COMMENT '期号',
`betting_time` timestamp NOT NULL COMMENT '投注时间',
`lottery_id` int NOT NULL COMMENT '彩票id',
`project` int NOT NULL COMMENT '投注项',
`odds` double NOT NULL COMMENT '赔率',
`money` int NOT NULL COMMENT '投注金额',
`square` int NOT NULL DEFAULT 0 COMMENT '是否结算',
`square_time` timestamp NULL COMMENT '结算时间',
`prize` int NOT NULL DEFAULT 0 COMMENT '是否派彩',
`prize_time` timestamp NULL COMMENT '派奖时间',
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_odds` (
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(255) NOT NULL,
`lottery_id` int NOT NULL,
`odds` double NOT NULL,
`min` int NOT NULL,
`max` int NOT NULL
);

