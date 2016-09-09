SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `pricebd` ;
CREATE SCHEMA IF NOT EXISTS `pricebd` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `pricebd` ;

-- -----------------------------------------------------
-- Table `pricebd`.`CAT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pricebd`.`CAT` ;

CREATE  TABLE IF NOT EXISTS `pricebd`.`CAT` (
  `ID` INT NOT NULL ,
  `NAME` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`ID`) );


-- -----------------------------------------------------
-- Table `pricebd`.`PROD`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pricebd`.`PROD` ;

CREATE  TABLE IF NOT EXISTS `pricebd`.`PROD` (
  `ID` INT NOT NULL ,
  `CAT_ID` INT NOT NULL ,
  `NAME` VARCHAR(255) NOT NULL ,
  `PRICE` DECIMAL(16,2) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_PROD_CAT_idx` (`CAT_ID` ASC) ,
  CONSTRAINT `fk_PROD_CAT`
    FOREIGN KEY (`CAT_ID` )
    REFERENCES `pricebd`.`CAT` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `pricebd` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `pricebd`.`CAT`
-- -----------------------------------------------------
START TRANSACTION;
USE `pricebd`;
INSERT INTO `pricebd`.`CAT` (`ID`, `NAME`) VALUES (1, 'Принтеры');
INSERT INTO `pricebd`.`CAT` (`ID`, `NAME`) VALUES (2, 'Сканеры');
INSERT INTO `pricebd`.`CAT` (`ID`, `NAME`) VALUES (3, 'Мониторы');

COMMIT;

-- -----------------------------------------------------
-- Data for table `pricebd`.`PROD`
-- -----------------------------------------------------
START TRANSACTION;
USE `pricebd`;
INSERT INTO `pricebd`.`PROD` (`ID`, `CAT_ID`, `NAME`, `PRICE`) VALUES (1, 1, 'Принтер Canon', 2500);
INSERT INTO `pricebd`.`PROD` (`ID`, `CAT_ID`, `NAME`, `PRICE`) VALUES (2, 1, 'Принтер Sony', 3000.99);
INSERT INTO `pricebd`.`PROD` (`ID`, `CAT_ID`, `NAME`, `PRICE`) VALUES (3, 2, 'Сканер Canon', 2645.20);
INSERT INTO `pricebd`.`PROD` (`ID`, `CAT_ID`, `NAME`, `PRICE`) VALUES (4, 3, 'Монитор Sony', 5400.50);
INSERT INTO `pricebd`.`PROD` (`ID`, `CAT_ID`, `NAME`, `PRICE`) VALUES (5, 1, 'Принтер HP', 2125.20);
INSERT INTO `pricebd`.`PROD` (`ID`, `CAT_ID`, `NAME`, `PRICE`) VALUES (6, 2, 'Сканер HP', 2400.89);

COMMIT;
