
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema legohus
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema legohus
-- -----------------------------------------------------
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema legohus
-- -----------------------------------------------------
DROP DATABASE IF EXISTS `legohus`;
-- -----------------------------------------------------
-- Schema legohus
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `legohus` DEFAULT CHARACTER SET utf8 ;
USE `legohus` ;

-- -----------------------------------------------------
-- Table `legohus`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `legohus`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(90) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `legohus`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `legohus`.`order` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `length` INT(11) NOT NULL,
  `width` INT(11) NOT NULL,
  `layers` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `shipped` TINYINT(4) NULL DEFAULT false,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC),
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `legohus`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


INSERT INTO `user` (email, password) VALUES ("customer@customer.com", "customer");
INSERT INTO `user` (email, password, role) VALUES ("employee@employee.com", "admin", "employee");


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
