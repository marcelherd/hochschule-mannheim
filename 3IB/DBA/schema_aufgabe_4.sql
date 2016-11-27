CREATE DATABASE  IF NOT EXISTS `dba` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dba`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 192.168.10.10    Database: dba
-- ------------------------------------------------------
-- Server version	5.7.12-0ubuntu1.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `überwacht_von`
--

DROP TABLE IF EXISTS `überwacht_von`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `überwacht_von` (
  `SpielId` int(10) unsigned NOT NULL,
  `SchiedsrichterId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`SpielId`,`SchiedsrichterId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `LAND`
--

DROP TABLE IF EXISTS `LAND`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LAND` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Kontinent` varchar(45) NOT NULL,
  `Einwohnerzahl` bigint(20) unsigned NOT NULL,
  `Sprache` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Abkürzung` varchar(5) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name_UNIQUE` (`Name`),
  UNIQUE KEY `Abkürzung_UNIQUE` (`Abkürzung`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `NATIONALMANNSCHAFT`
--

DROP TABLE IF EXISTS `NATIONALMANNSCHAFT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NATIONALMANNSCHAFT` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SCHIEDSRICHTER`
--

DROP TABLE IF EXISTS `SCHIEDSRICHTER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SCHIEDSRICHTER` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Aufgabe` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SPIEL`
--

DROP TABLE IF EXISTS `SPIEL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SPIEL` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Tore` int(10) unsigned DEFAULT '0',
  `Gegentore` int(10) unsigned DEFAULT '0',
  `Anpfiff` datetime NOT NULL,
  `Datum` date NOT NULL,
  `Endergebnis` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SPIELER`
--

DROP TABLE IF EXISTS `SPIELER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SPIELER` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nummer` int(10) unsigned NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Position` varchar(45) NOT NULL,
  `Geschossene_Tore` int(10) unsigned DEFAULT '0',
  `Absolvierte_Spiele` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TRAINER`
--

DROP TABLE IF EXISTS `TRAINER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TRAINER` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `WELTMEISTERSCHAFT`
--

DROP TABLE IF EXISTS `WELTMEISTERSCHAFT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `WELTMEISTERSCHAFT` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Austragungsort` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `besteht_aus`
--

DROP TABLE IF EXISTS `besteht_aus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `besteht_aus` (
  `SpielerId` int(10) unsigned NOT NULL,
  `NationalmannschaftId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`SpielerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `bestreitet`
--

DROP TABLE IF EXISTS `bestreitet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bestreitet` (
  `NationalmannschaftId` int(10) unsigned NOT NULL,
  `SpielId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`NationalmannschaftId`,`SpielId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `gehört_zu`
--

DROP TABLE IF EXISTS `gehört_zu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gehört_zu` (
  `LandId` int(10) unsigned NOT NULL,
  `NationalmannschaftId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`LandId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `nimmt_teil_an`
--

DROP TABLE IF EXISTS `nimmt_teil_an`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nimmt_teil_an` (
  `WeltmeisterschaftId` int(10) unsigned NOT NULL,
  `LandId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`WeltmeisterschaftId`,`LandId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `trainiert_von`
--

DROP TABLE IF EXISTS `trainiert_von`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trainiert_von` (
  `TrainerId` int(10) unsigned NOT NULL,
  `NationalmannschaftId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`TrainerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-27 18:09:45
