DROP TABLE IF EXISTS `authorized_session`;
CREATE TABLE `authorized_session` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `request_no` varchar(100) NOT NULL,
  `session` varchar(100) NOT NULL,
  `auth_url` varchar(300) NOT NULL,
  `status` varchar(45) NOT NULL,
  `extra_params` varchar(500) DEFAULT NULL,
  `time_out` int(10) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `update_time` timestamp(3) NULL DEFAULT NULL,
  `create_time` timestamp(3) NULL DEFAULT CURRENT_TIMESTAMP(3),
  `expire` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;