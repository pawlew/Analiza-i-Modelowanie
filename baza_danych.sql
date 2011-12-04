SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `poker` DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci ;
USE `poker` ;

-- -----------------------------------------------------
-- Table `poker`.`users`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `poker`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `login` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(255) NOT NULL ,
  `deleted` INT NOT NULL DEFAULT 0 ,
  PRIMARY KEY (`id`) )
ENGINE = MyISAM;


-- -----------------------------------------------------
-- Table `poker`.`games`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `poker`.`games` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `userId` INT NOT NULL ,
  `createDate` DATE NOT NULL ,
  `scores` DOUBLE NOT NULL DEFAULT 0 ,
  `deleted` INT NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
