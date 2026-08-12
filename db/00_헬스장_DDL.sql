drop database if exists health;

create database health;

use health;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL,
    `reg_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `phone` VARCHAR(13) NOT NULL UNIQUE
);

DROP TABLE IF EXISTS `locker`;

CREATE TABLE `locker` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `user_id` INT NULL
);

DROP TABLE IF EXISTS `trainer`;

CREATE TABLE `trainer` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL,
    `major` VARCHAR(10) NULL,
    `history` INT NOT NULL DEFAULT 0,
    `leader_id` INT NULL
);

DROP TABLE IF EXISTS `program`;

CREATE TABLE `program` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(20) NOT NULL,
    `personal` INT NOT NULL,
    `fee` INT NOT NULL DEFAULT 0,
    `trainer_id` INT NOT NULL
);

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `app_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `state` VARCHAR(10) NOT NULL DEFAULT '결제완료',
    user_id INT NOT NULL,
    program_id INT NOT NULL
);

DROP TABLE IF EXISTS `attendance`;

CREATE TABLE `attendance` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `date` DATE NULL,
    `state` CHAR(1) NULL,
    `user_id` INT NOT NULL,
    `program_id` INT NOT NULL
);

ALTER TABLE `locker` ADD CONSTRAINT `FK_user_TO_locker_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `user` (
	`id`
);

ALTER TABLE `trainer` ADD CONSTRAINT `FK_trainer_TO_trainer_1` FOREIGN KEY (
	`leader_id`
)
REFERENCES `trainer` (
	`id`
);

ALTER TABLE `program` ADD CONSTRAINT `FK_trainer_TO_program_1` FOREIGN KEY (
	`trainer_id`
)
REFERENCES `trainer` (
	`id`
);

ALTER TABLE `course` ADD CONSTRAINT `FK_user_TO_course_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `user` (
	`id`
);

ALTER TABLE `course` ADD CONSTRAINT `FK_program_TO_course_1` FOREIGN KEY (
	`program_id`
)
REFERENCES `program` (
	`id`
);

ALTER TABLE `attendance` ADD CONSTRAINT `FK_user_TO_attendance_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `user` (
	`id`
);

ALTER TABLE `attendance` ADD CONSTRAINT `FK_program_TO_attendance_1` FOREIGN KEY (
	`program_id`
)
REFERENCES `program` (
	`id`
);

