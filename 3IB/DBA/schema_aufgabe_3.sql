CREATE DATABASE IF NOT EXISTS dba;
USE dba;

DROP TABLE `dba`.`Verein`;
CREATE TABLE `dba`.`Verein` (
  `Vereins-ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Vereinsname` VARCHAR(90) NOT NULL,
  `Gründungsjahr` INT UNSIGNED NOT NULL,
  `Ort` VARCHAR(90) NOT NULL,
  `Mitglieder` INT ZEROFILL UNSIGNED NOT NULL,
  PRIMARY KEY (`Vereins-ID`),
  UNIQUE INDEX `Vereinsname_UNIQUE` (`Vereinsname` ASC));
  
INSERT INTO `dba`.`Verein` (`Vereins-ID`, `Vereinsname`, `Gründungsjahr`, `Ort`, `Mitglieder`) VALUES ('1', 'Glatzkopf Ägypten', '1886', 'Mannheim', '60');
INSERT INTO `dba`.`Verein` (`Vereins-ID`, `Vereinsname`, `Gründungsjahr`, `Ort`, `Mitglieder`) VALUES ('2', 'Barfuß Bethlehem', '1623', 'Kaiserslautern', '400');
INSERT INTO `dba`.`Verein` (`Vereins-ID`, `Vereinsname`, `Gründungsjahr`, `Ort`, `Mitglieder`) VALUES ('3', 'FC Wadenkrampf', '1987', 'Gelsenkirchen', '48000');
INSERT INTO `dba`.`Verein` (`Vereins-ID`, `Vereinsname`, `Gründungsjahr`, `Ort`, `Mitglieder`) VALUES ('4', 'Hertha BSE', '2017', 'Berlin', '1002');
INSERT INTO `dba`.`Verein` (`Vereins-ID`, `Vereinsname`, `Gründungsjahr`, `Ort`, `Mitglieder`) VALUES ('5', 'Stiftung Wadentest', '345', 'München', '4564');
INSERT INTO `dba`.`Verein` (`Vereins-ID`, `Vereinsname`, `Gründungsjahr`, `Ort`, `Mitglieder`) VALUES ('6', 'SSV Elfenbeinkiste', '1989', 'Clausthal-Zellerfeld', '23');

DROP TABLE `dba`.`Liga`;
CREATE TABLE `dba`.`Liga` (
  `Liga-ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `1. Teilnahmejahr` INT UNSIGNED NOT NULL,
  `Vereins-ID` INT UNSIGNED NOT NULL,
  `Einnahmen` DECIMAL ZEROFILL UNSIGNED NOT NULL,
  PRIMARY KEY (`Liga-ID`),
  INDEX `Vereins-ID_idx` (`Vereins-ID` ASC),
  CONSTRAINT `Vereins-ID`
    FOREIGN KEY (`Vereins-ID`)
    REFERENCES `dba`.`Verein` (`Vereins-ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `dba`.`Liga` (`Liga-ID`, `1. Teilnahmejahr`, `Vereins-ID`, `Einnahmen`) VALUES ('1', '1964', '1', '7360');
INSERT INTO `dba`.`Liga` (`Liga-ID`, `1. Teilnahmejahr`, `Vereins-ID`, `Einnahmen`) VALUES ('2', '1870', '4', '8000');
INSERT INTO `dba`.`Liga` (`Liga-ID`, `1. Teilnahmejahr`, `Vereins-ID`, `Einnahmen`) VALUES ('3', '1956', '2', '12800');
INSERT INTO `dba`.`Liga` (`Liga-ID`, `1. Teilnahmejahr`, `Vereins-ID`, `Einnahmen`) VALUES ('4', '2015', '3', '976');
INSERT INTO `dba`.`Liga` (`Liga-ID`, `1. Teilnahmejahr`, `Vereins-ID`, `Einnahmen`) VALUES ('5', '1999', '5', '2698');
INSERT INTO `dba`.`Liga` (`Liga-ID`, `1. Teilnahmejahr`, `Vereins-ID`, `Einnahmen`) VALUES ('6', '1976', '6', '400000');

CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `homestead`@`%` 
    SQL SECURITY DEFINER
VIEW `aufgabe_3_a` AS
    SELECT 
        `V`.`Vereins-ID` AS `Vereins-ID`,
        `V`.`Vereinsname` AS `Vereinsname`,
        `L`.`Einnahmen` AS `Einnahmen`,
        `L`.`1. Teilnahmejahr` AS `1. Teilnahmejahr`
    FROM
        `Liga` `L`
            JOIN
        `Verein` `V` ON (`L`.`Vereins-ID` = `V`.`Vereins-ID`)
    ORDER BY `L`.`Einnahmen` ASC