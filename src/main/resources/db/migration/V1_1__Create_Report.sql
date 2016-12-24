CREATE TABLE IF NOT EXISTS `report_definition` (
  `id` int NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `data_source` varchar(100),
  `modified_time` timestamp, 
  `modified_by` varchar(32),
  `created_time` timestamp, 
  `created_by` varchar(32),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `report_definition_field` (
  `id` int NOT NULL auto_increment,
  `report_definition_id` int NOT NULL,
  `field_name` varchar(100) NOT NULL,
  `show_name` varchar(100) NOT NULL,
  `show_type` varchar(32) NOT NULL,
  `show_option` varchar(4000),
  `modified_time` timestamp, 
  `modified_by` varchar(32),
  `created_time` timestamp, 
  `created_by` varchar(32),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `report` (
  `id` int NOT NULL auto_increment,
  `report_definition_id` int NOT NULL,
  `report_name` varchar(100) NOT NULL,
  `description` varchar(1000),
  `modified_time` timestamp, 
  `modified_by` varchar(32),
  `created_time` timestamp, 
  `created_by` varchar(32),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `report_field` (
  `id` int NOT NULL auto_increment,
  `report_id` int NOT NULL,
  `report_definition_field_id` int NOT NULL,
  `show_name` varchar(100) NOT NULL,
  `modified_time` timestamp, 
  `modified_by` varchar(32),
  `created_time` timestamp, 
  `created_by` varchar(32),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

