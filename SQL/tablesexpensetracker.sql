-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`USER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`USER` ;

CREATE TABLE IF NOT EXISTS `mydb`.`USER` (
  `ID` INT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NULL,
  `LASTNAME` VARCHAR(45) NULL,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ACCOUNT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ACCOUNT` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ACCOUNT` (
  `ID` INT NULL AUTO_INCREMENT,
  `BALANCE` VARCHAR(45) NULL,
  `USER_ID` INT NULL,
  INDEX `fk_ACCOUNT_USER_idx` (`USER_ID` ASC) VISIBLE,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  CONSTRAINT `fk_ACCOUNT_USER`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `mydb`.`USER` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '					';


-- -----------------------------------------------------
-- Table `mydb`.`MOVEMENTS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`MOVEMENTS` ;

CREATE TABLE IF NOT EXISTS `mydb`.`MOVEMENTS` (
  `ID` INT NULL AUTO_INCREMENT,
  `AMOUNT` INT NULL,
  `DATE` DATE NULL,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ACCOUNT_has_MOVEMENTS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ACCOUNT_has_MOVEMENTS` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ACCOUNT_has_MOVEMENTS` (
  `ACCOUNT_ID` INT NOT NULL,
  `MOVEMENTS_ID` INT NOT NULL,
  PRIMARY KEY (`ACCOUNT_ID`, `MOVEMENTS_ID`),
  INDEX `fk_ACCOUNT_has_MOVEMENTS_MOVEMENTS1_idx` (`MOVEMENTS_ID` ASC) VISIBLE,
  INDEX `fk_ACCOUNT_has_MOVEMENTS_ACCOUNT1_idx` (`ACCOUNT_ID` ASC) VISIBLE,
  CONSTRAINT `fk_ACCOUNT_has_MOVEMENTS_ACCOUNT1`
    FOREIGN KEY (`ACCOUNT_ID`)
    REFERENCES `mydb`.`ACCOUNT` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ACCOUNT_has_MOVEMENTS_MOVEMENTS1`
    FOREIGN KEY (`MOVEMENTS_ID`)
    REFERENCES `mydb`.`MOVEMENTS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`USER_has_MOVEMENTS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`USER_has_MOVEMENTS` ;

CREATE TABLE IF NOT EXISTS `mydb`.`USER_has_MOVEMENTS` (
  `USER_ID` INT NOT NULL,
  `MOVEMENTS_ID` INT NOT NULL,
  PRIMARY KEY (`USER_ID`, `MOVEMENTS_ID`),
  INDEX `fk_USER_has_MOVEMENTS_MOVEMENTS1_idx` (`MOVEMENTS_ID` ASC) VISIBLE,
  INDEX `fk_USER_has_MOVEMENTS_USER1_idx` (`USER_ID` ASC) VISIBLE,
  CONSTRAINT `fk_USER_has_MOVEMENTS_USER1`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `mydb`.`USER` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USER_has_MOVEMENTS_MOVEMENTS1`
    FOREIGN KEY (`MOVEMENTS_ID`)
    REFERENCES `mydb`.`MOVEMENTS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
