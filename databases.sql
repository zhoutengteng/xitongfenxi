drop database if exists xitongfenxi;
create  database xitongfenxi CHARACTER SET 'utf8'   COLLATE 'utf8_general_ci' ;
use xitongfenxi;


CREATE TABLE `xitongfenxi`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `sex` VARCHAR(2) NOT NULL DEFAULT 0 COMMENT '0表示男，1表示女',
  `password` VARCHAR(45) NOT NULL COMMENT 'MD5加密',
  `mail` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `headImageAdd` VARCHAR(45) NULL,
  `addr` VARCHAR(45)  NULL,
  `contactPeopleList` VARCHAR(45) NULL COMMENT 'usersId列表，如1,11,13 用逗号隔开',
  `rate` INT NULL DEFAULT 0 COMMENT '个人信用度，越大越好',
  PRIMARY KEY (`id`)) ENGINE = INNODB DEFAULT CHARSET=utf8;
	
CREATE TABLE `xitongfenxi`.`records` (
  `id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `label` VARCHAR(45) NULL,
  `content` VARCHAR(45) NOT NULL,
  `startTime` VARCHAR(45) NOT NULL,
  `endTIme` VARCHAR(45) NOT NULL,
  `peopleId` INT NOT NULL,
  `joinPeopleList` TEXT,
  PRIMARY KEY (`id`),
  INDEX `peopleId_idx2` (`peopleId` ASC),
  CONSTRAINT `peopleId2`
    FOREIGN KEY (`peopleId`)
    REFERENCES `xitongfenxi`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) ENGINE = INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `xitongfenxi`.`comments` (
  `id` INT NOT NULL,
  `peopleId` INT NOT NULL,
  `recordId` INT NOT NULL,
  `content` TEXT NULL,
  `goodsCount` INT NULL DEFAULT 0,
  `badsCount` INT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `peopleId_idx` (`peopleId` ASC),
  INDEX `recordId_idx` (`recordId` ASC),
  CONSTRAINT `peopleId`
    FOREIGN KEY (`peopleId`)
    REFERENCES `xitongfenxi`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `recordId`
    FOREIGN KEY (`recordId`)
    REFERENCES `xitongfenxi`.`records` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) ENGINE = INNODB DEFAULT CHARSET=utf8;
    
INSERT INTO `xitongfenxi`.`users` (`id`,`name`,`sex`,`password`) VALUES (1, "zhou1", 0, "1992927zhou");
INSERT INTO `xitongfenxi`.`users` (`id`,`name`,`sex`,`password`) VALUES (2, "zhou2", 0, "1992927zhou");
INSERT INTO `xitongfenxi`.`users` (`id`,`name`,`sex`,`password`) VALUES (3, "zhou3", 0, "1992927zhou");
INSERT INTO `xitongfenxi`.`users` (`id`,`name`,`sex`,`password`) VALUES (4, "zhou4", 0, "1992927zhou");
INSERT INTO `xitongfenxi`.`users` (`id`,`name`,`sex`,`password`) VALUES (5, "zhou5", 0, "1992927zhou");
INSERT INTO `xitongfenxi`.`users` (`id`,`name`,`sex`,`password`) VALUES (6, "zhou6", 0, "1992927zhou");
UPDATE `xitongfenxi`.`users` SET `contactPeopleList` = "2;3;4;5;6", `rate` = 1 WHERE `id` = 1;
UPDATE `xitongfenxi`.`users` SET `contactPeopleList` = "1;3;4;5;6", `rate` = 1 WHERE `id` = 2;
UPDATE `xitongfenxi`.`users` SET `contactPeopleList` = "2;1;4;5;6", `rate` = 1 WHERE `id` = 3;
UPDATE `xitongfenxi`.`users` SET `contactPeopleList` = "2;3;1;5;6", `rate` = 1 WHERE `id` = 4;
UPDATE `xitongfenxi`.`users` SET `contactPeopleList` = "2;3;4;1;6", `rate` = 1 WHERE `id` = 5;
UPDATE `xitongfenxi`.`users` SET `contactPeopleList` = "2;3;4;5;1", `rate` = 1 WHERE `id` = 6;
INSERT INTO `xitongfenxi`.`records` (`id`,`title`,`label`,`content`,`startTime`,`endTIme`, `peopleId`) VALUES (1, "一起跑内环", "体育", "详细介绍", "2016-09-02", "2016-10-01", 1);
INSERT INTO `xitongfenxi`.`comments` (`id`, `peopleId`,`recordId`,`content`) VALUES (1,2,1,"内环1");
INSERT INTO `xitongfenxi`.`comments` (`id`, `peopleId`,`recordId`,`content`) VALUES (2,3,1,"内环1");
INSERT INTO `xitongfenxi`.`comments` (`id`, `peopleId`,`recordId`,`content`) VALUES (3,4,1,"内环1");
INSERT INTO `xitongfenxi`.`comments` (`id`, `peopleId`,`recordId`,`content`) VALUES (4,5,1,"内环1");
INSERT INTO `xitongfenxi`.`comments` (`id`, `peopleId`,`recordId`,`content`) VALUES (5,1,1,"内环1");
    

