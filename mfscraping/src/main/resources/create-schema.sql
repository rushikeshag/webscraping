
/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mfdata` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mfdata`;

DROP TABLE IF EXISTS `MF_DIR`;
DROP TABLE IF EXISTS `MF_ASSET_ALLOCATION`;
DROP TABLE IF EXISTS `MF_PERFORMANCE`;
DROP TABLE IF EXISTS `MF_FUND_MANAGEMENT`;
DROP TABLE IF EXISTS `MF_TOP_TEN_HOLDINGS`;
DROP TABLE IF EXISTS `MF_ANNUALIZED_RETURENS`;
DROP TABLE IF EXISTS `MF_QUARTERLY_RETURNS`;
DROP TABLE IF EXISTS `MF_INVESMENT`;
DROP TABLE IF EXISTS `MF_NAV_INFO`;
DROP TABLE IF EXISTS `MF_NAV_DATA`;


CREATE TABLE `MF_DIR` (
  `mfId` varchar(32) NOT NULL,
  `name` varchar(256) NOT NULL,  
  `category` varchar(64),
  `Launch_date` date,
  `Type` varchar(32),

  PRIMARY KEY (`mfId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `MF_NAV_INFO` (
  `mfId` varchar(32) NOT NULL,
  `current_NAV` double,
  `f_week_high` double,
  `f_week_low` double,
  `as_of` date,
  
  CONSTRAINT `mfIdInNavInfo` FOREIGN KEY (`mfId`) REFERENCES `MF_DIR` (`mfId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `MF_NAV_DATA` (
  `mfId` varchar(32) NOT NULL,
  `date` date,
  `nav` double,
  
  CONSTRAINT `mfIdInNavData` FOREIGN KEY (`mfId`) REFERENCES `MF_DIR` (`mfId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `MF_ASSET_ALLOCATION` (
  `mfId` varchar(32) NOT NULL,
  `class_allocation` json NOT NULL,
  -- [{"c":"equity", "a":0.69}, {"month":3, "return":1.62}, {"month":12, "return":20.19}]
  CONSTRAINT `mfIdInAA` FOREIGN KEY (`mfId`) REFERENCES `MF_DIR` (`mfId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `MF_PERFORMANCE` (
  `mfId` varchar(32) NOT NULL,
  `month_wise_performance` JSON NOT NULL, 
  -- [{"m":1, "r":-1.62}, {"month":3, "return":1.62}, {"month":12, "return":20.19}]
  `as_of` date NOT NULL,
  
  CONSTRAINT `mfIdInPerformance` FOREIGN KEY (`mfId`) REFERENCES `MF_DIR` (`mfId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `MF_FUND_MANAGEMENT` (
  `mfId` varchar(32) NOT NULL,
  `fund_management_info` JSON NOT NULL,
  
  CONSTRAINT `mfIdInFundManagement` FOREIGN KEY (`mfId`) REFERENCES `MF_DIR` (`mfId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `MF_TOP_TEN_HOLDINGS` (
  `mfId` varchar(32) NOT NULL,
  `holdings` JSON NOT NULL,
  
  CONSTRAINT `mfIdInTopTenHoldings` FOREIGN KEY (`mfId`) REFERENCES `MF_DIR` (`mfId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `MF_ANNUALIZED_RETURENS` (
  `mfId` varchar(32) NOT NULL,
  `year` integer,
  `fund_return` double,
  
  CONSTRAINT `mfIdInAnnualizedReturns` FOREIGN KEY (`mfId`) REFERENCES `MF_DIR` (`mfId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `MF_QUARTERLY_RETURNS` (
  `mfId` varchar(32) NOT NULL,
  `year` integer,
  `quater` integer,
  `fund_return` double,
  
  CONSTRAINT `mfIdInQuarterlyReturns` FOREIGN KEY (`mfId`) REFERENCES `MF_DIR` (`mfId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `MF_INVESMENT` (
  `mfId` varchar(32) NOT NULL,
  `investment` JSON NOT NULL,
  
  CONSTRAINT `mfIdInInvestment` FOREIGN KEY (`mfId`) REFERENCES `MF_DIR` (`mfId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



commit;