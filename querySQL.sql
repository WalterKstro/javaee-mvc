CREATE DATABASE `ctrl_customers`
USE `ctrl_customers`;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='ctrl_customers';



CREATE TABLE `customers` (
	`Customer_ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`Customer_FirstN` VARCHAR(60) NOT NULL DEFAULT '' COLLATE 'utf8mb4_general_ci',
	`Customer_LastN` VARCHAR(60) NOT NULL DEFAULT '' COLLATE 'utf8mb4_general_ci',
	`Customer_Email` VARCHAR(60) NOT NULL DEFAULT '' COLLATE 'utf8mb4_general_ci',
	`Customer_Tel` VARCHAR(8) NOT NULL DEFAULT '' COLLATE 'utf8mb4_general_ci',
	`Customer_Balance` DOUBLE NOT NULL DEFAULT '0',
	PRIMARY KEY (`Customer_ID`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
