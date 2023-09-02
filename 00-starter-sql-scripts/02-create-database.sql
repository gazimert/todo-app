CREATE DATABASE  IF NOT EXISTS `todo_app`;
USE `todo_app`;

DROP TABLE IF EXISTS `todo_item`;

CREATE TABLE `todo_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description`text DEFAULT NULL,
  `is_complete` boolean DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
