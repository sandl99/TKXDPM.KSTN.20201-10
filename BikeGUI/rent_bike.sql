-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: rent_bike
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `rent_bike`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `rent_bike` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `rent_bike`;

--
-- Table structure for table `bike`
--

DROP TABLE IF EXISTS `bike`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bike` (
  `id` int NOT NULL,
  `type` int DEFAULT NULL,
  `pin` int DEFAULT NULL,
  `value` int DEFAULT NULL,
  `dockId` int DEFAULT NULL,
  `barcode` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `bikecol` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `bikecol_UNIQUE` (`bikecol`),
  KEY `dockId_idx` (`dockId`),
  CONSTRAINT `dockId` FOREIGN KEY (`dockId`) REFERENCES `dock` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bike`
--

LOCK TABLES `bike` WRITE;
/*!40000 ALTER TABLE `bike` DISABLE KEYS */;
INSERT INTO `bike` VALUES (0,0,83,400000,4,'LDD65',NULL),(1,0,77,400000,11,'INYYS',NULL),(2,2,73,700000,1,'IO3Z5',NULL),(3,0,56,400000,8,'VBPQY',NULL),(4,2,62,700000,8,'RR1ML',NULL),(5,2,59,700000,3,'2TMTC',NULL),(6,1,63,550000,0,'P9KHN',NULL),(7,2,51,700000,4,'SPKGH',NULL),(8,0,64,400000,2,'RJUR6',NULL),(9,2,78,700000,10,'C4I22',NULL),(10,0,91,400000,8,'651K2',NULL),(11,2,95,700000,9,'2TFN6',NULL),(12,0,59,400000,11,'Y9HM6',NULL),(13,1,61,550000,5,'L7ABL',NULL),(14,0,53,400000,1,'8H2PA',NULL),(15,2,77,700000,10,'NTREC',NULL),(16,0,64,400000,8,'62X5E',NULL),(17,1,72,550000,10,'9WKXS',NULL),(18,2,94,700000,2,'UONFY',NULL),(19,1,60,550000,5,'GL5MA',NULL),(20,1,100,550000,7,'MCBRX',NULL),(21,2,78,700000,5,'ZAVA4',NULL),(22,1,68,550000,7,'PK4JZ',NULL),(23,0,100,400000,5,'VMZ2B',NULL),(24,2,74,700000,6,'34LLL',NULL),(25,0,94,400000,1,'S2XJK',NULL),(26,0,55,400000,5,'DQ7O3',NULL),(27,1,92,550000,7,'APMCK',NULL),(28,1,59,550000,1,'SCYVI',NULL),(29,2,62,700000,2,'QE9OE',NULL),(30,1,87,550000,9,'4BG89',NULL),(31,1,86,550000,8,'9RSOV',NULL),(32,2,80,700000,9,'AH4Z3',NULL),(33,0,50,400000,11,'IXID3',NULL),(34,1,56,550000,3,'AJVAW',NULL),(35,0,85,400000,10,'6KK73',NULL),(36,1,71,550000,5,'Q5UYH',NULL),(37,0,60,400000,10,'16QO5',NULL),(38,2,71,700000,4,'H6K91',NULL),(39,2,71,700000,8,'DOTQA',NULL),(40,0,64,400000,0,'LQRSB',NULL),(41,2,80,700000,9,'1KF73',NULL),(42,2,93,700000,2,'KEW3F',NULL),(43,1,77,550000,11,'SM2SI',NULL),(44,0,54,400000,0,'B2Z72',NULL),(45,2,60,700000,8,'C992E',NULL),(46,1,90,550000,3,'NXZ2B',NULL),(47,1,51,550000,2,'1E1KR',NULL),(48,2,71,700000,0,'WA2XV',NULL),(49,0,57,400000,9,'J3NFQ',NULL),(50,0,73,400000,9,'23ZAC',NULL),(51,2,53,700000,0,'E9NGJ',NULL),(52,2,93,700000,10,'2WVQZ',NULL),(53,0,73,400000,0,'UA1SY',NULL),(54,1,55,550000,1,'4PVT4',NULL),(55,2,58,700000,7,'AGPTU',NULL),(56,1,53,550000,3,'FQ1FI',NULL),(57,2,54,700000,10,'JMAXB',NULL),(58,2,84,700000,3,'56FRE',NULL),(59,2,67,700000,0,'Q2XMV',NULL),(60,2,68,700000,10,'SWQSM',NULL),(61,1,98,550000,5,'VVI8K',NULL),(62,1,93,550000,5,'HTG0S',NULL),(63,0,77,400000,7,'UQMLF',NULL),(64,2,88,700000,2,'K33YQ',NULL),(65,2,81,700000,8,'NOSCE',NULL),(66,2,60,700000,9,'TNKLX',NULL),(67,0,69,400000,4,'HP75V',NULL),(68,1,74,550000,8,'ZWUS5',NULL),(69,0,94,400000,9,'T6W2Y',NULL),(70,1,59,550000,8,'O5G30',NULL),(71,1,68,550000,0,'WNY54',NULL),(72,1,84,550000,6,'7GZTG',NULL),(73,2,72,700000,8,'IYCC7',NULL),(74,1,58,550000,9,'S057Z',NULL),(75,2,60,700000,8,'26XDU',NULL),(76,1,67,550000,8,'6HJ6D',NULL),(77,1,75,550000,0,'NWJWI',NULL),(78,0,66,400000,9,'3XR35',NULL),(79,1,70,550000,1,'OHXMG',NULL),(80,1,57,550000,9,'53RFE',NULL),(81,2,95,700000,5,'RN727',NULL),(82,1,96,550000,4,'U4916',NULL),(83,0,58,400000,9,'VLYZO',NULL),(84,2,86,700000,7,'A65FX',NULL),(85,0,84,400000,2,'8HOHA',NULL),(86,2,70,700000,9,'O65QK',NULL),(87,1,88,550000,7,'44CK7',NULL),(88,1,71,550000,9,'5BHKP',NULL),(89,1,80,550000,9,'8TSFC',NULL),(90,2,93,700000,8,'VZOBE',NULL),(91,2,68,700000,3,'B2VGY',NULL),(92,2,68,700000,0,'6R5C7',NULL),(93,0,62,400000,11,'2ED96',NULL),(94,1,58,550000,3,'6FUN4',NULL),(95,2,60,700000,8,'J8GW5',NULL),(96,0,57,400000,1,'QINVZ',NULL),(97,0,90,400000,3,'HRDQG',NULL),(98,1,63,550000,5,'DG5WS',NULL),(99,2,92,700000,8,'NSKG5',NULL),(100,2,88,700000,10,'OVBJG',NULL),(101,1,83,550000,8,'3QPTA',NULL),(102,1,88,550000,11,'Y43XJ',NULL),(103,0,63,400000,3,'5XRB1',NULL),(104,2,82,700000,5,'NOA68',NULL),(105,0,92,400000,2,'BKPIN',NULL),(106,0,97,400000,8,'89ELR',NULL),(107,1,63,550000,9,'XPPBV',NULL),(108,0,54,400000,0,'RC7SA',NULL),(109,1,59,550000,9,'MIS2J',NULL),(110,1,76,550000,5,'TBS01',NULL),(111,1,78,550000,6,'4XBW0',NULL),(112,2,50,700000,6,'DX76Q',NULL),(113,2,91,700000,5,'B24AP',NULL),(114,1,88,550000,10,'UFP7T',NULL),(115,1,74,550000,2,'STJBU',NULL),(116,1,72,550000,5,'OFY6M',NULL),(117,0,62,400000,5,'31HWU',NULL),(118,0,76,400000,1,'J26JR',NULL),(119,2,93,700000,10,'13D37',NULL),(120,0,63,400000,8,'T2Q8D',NULL),(121,1,86,550000,1,'YJ52T',NULL),(122,1,98,550000,8,'27BG9',NULL),(123,0,83,400000,7,'DHDJ0',NULL),(124,1,73,550000,9,'CX8CL',NULL),(125,0,86,400000,6,'S2KAF',NULL),(126,1,99,550000,7,'7C30B',NULL),(127,0,59,400000,7,'BV0L4',NULL),(128,2,73,700000,1,'07WHP',NULL),(129,1,60,550000,6,'GN2JL',NULL),(130,1,76,550000,0,'A9ALX',NULL),(131,0,70,400000,8,'1HHC9',NULL),(132,0,74,400000,10,'6BD6I',NULL),(133,0,54,400000,7,'8VO8C',NULL),(134,0,99,400000,11,'QDNE0',NULL),(135,1,86,550000,3,'K1F03',NULL),(136,1,51,550000,11,'U9VG6',NULL),(137,2,66,700000,6,'UQ4CP',NULL),(138,1,61,550000,4,'0HZLJ',NULL),(139,2,78,700000,4,'TLQ2Z',NULL),(140,0,91,400000,2,'47UAV',NULL),(141,1,88,550000,4,'UTV5C',NULL),(142,1,80,550000,5,'OGZPI',NULL),(143,1,69,550000,3,'U3NPN',NULL),(144,2,83,700000,1,'RXD0U',NULL),(145,1,91,550000,6,'0QST8',NULL),(146,2,65,700000,2,'XSPII',NULL),(147,1,53,550000,1,'A2I2N',NULL),(148,2,67,700000,10,'P90QK',NULL),(149,2,93,700000,7,'6IEFT',NULL),(150,1,73,550000,11,'63RJB',NULL),(151,2,64,700000,7,'YA0QO',NULL),(152,0,98,400000,1,'GCARK',NULL),(153,0,92,400000,8,'NP52L',NULL),(154,1,62,550000,4,'DGZAZ',NULL),(155,2,68,700000,6,'0UWU9',NULL),(156,1,77,550000,6,'EDOUC',NULL),(157,1,82,550000,0,'V53AQ',NULL),(158,1,74,550000,2,'LCEPL',NULL),(159,1,52,550000,11,'UYULG',NULL),(160,0,50,400000,2,'HR98R',NULL),(161,1,81,550000,1,'G14Z7',NULL),(162,0,74,400000,8,'YTDD1',NULL),(163,1,56,550000,4,'HG88X',NULL),(164,1,52,550000,9,'R6G2U',NULL),(165,1,95,550000,5,'NQJAL',NULL),(166,0,88,400000,9,'823RC',NULL),(167,2,84,700000,10,'SG9FM',NULL),(168,1,58,550000,7,'7WSHZ',NULL),(169,0,89,400000,6,'MKWKL',NULL),(170,1,64,550000,1,'K8HWQ',NULL),(171,1,79,550000,1,'JMP5N',NULL),(172,2,74,700000,5,'XV48X',NULL),(173,2,74,700000,4,'O7T65',NULL),(174,2,62,700000,5,'1VA0H',NULL),(175,2,63,700000,10,'AXCD5',NULL),(176,2,51,700000,6,'3FFCZ',NULL),(177,0,83,400000,1,'D2US0',NULL),(178,0,59,400000,3,'LFHJF',NULL),(179,0,52,400000,10,'HIN5Q',NULL),(180,2,69,700000,8,'MR4BM',NULL),(181,2,63,700000,5,'MDZ5Y',NULL),(182,1,72,550000,2,'2UFZM',NULL),(183,2,60,700000,11,'KFGHL',NULL),(184,1,71,550000,2,'RG0IX',NULL),(185,0,94,400000,7,'T5G2X',NULL),(186,1,70,550000,10,'EOGDX',NULL),(187,0,69,400000,3,'P4LE7',NULL),(188,2,93,700000,0,'E2YCA',NULL),(189,2,75,700000,9,'2YJFR',NULL),(190,0,75,400000,4,'GAJDB',NULL),(191,0,95,400000,4,'RNEO3',NULL),(192,1,84,550000,6,'RZ541',NULL),(193,0,89,400000,8,'DA8I6',NULL),(194,0,98,400000,3,'7VDSP',NULL),(195,0,78,400000,6,'7TUWR',NULL),(196,1,67,550000,2,'PG6Q4',NULL),(197,1,63,550000,3,'LC2A4',NULL),(198,1,94,550000,3,'QSXSQ',NULL),(199,1,55,550000,1,'27T5V',NULL),(200,1,58,550000,3,'91UG3',NULL),(201,0,96,400000,6,'QIH05',NULL),(202,2,57,700000,11,'9OS3D',NULL),(203,2,65,700000,1,'TC6G3',NULL),(204,0,91,400000,9,'EPSVC',NULL),(205,2,55,700000,11,'YQNVS',NULL),(206,1,60,550000,5,'2E19X',NULL),(207,1,85,550000,11,'JZZCO',NULL),(208,0,96,400000,3,'HW898',NULL),(209,1,76,550000,2,'DJZRD',NULL),(210,1,71,550000,6,'QFG0U',NULL),(211,1,79,550000,9,'YBA1J',NULL),(212,0,98,400000,8,'45QQC',NULL),(213,1,58,550000,7,'NDI5Z',NULL),(214,0,85,400000,2,'OCEES',NULL),(215,2,84,700000,2,'V5WKZ',NULL),(216,0,50,400000,3,'4L6LQ',NULL),(217,0,86,400000,11,'IT039',NULL),(218,2,50,700000,5,'W3S5Y',NULL),(219,2,90,700000,4,'HQQXL',NULL),(220,0,100,400000,3,'E73VT',NULL),(221,2,64,700000,7,'TD1HL',NULL),(222,2,91,700000,11,'Y7ESC',NULL),(223,1,100,550000,0,'FUOAS',NULL),(224,1,86,550000,2,'NTTVW',NULL),(225,1,80,550000,3,'4QHGS',NULL),(226,2,77,700000,4,'NR9SI',NULL),(227,1,77,550000,6,'5III2',NULL),(228,1,90,550000,9,'XN6BF',NULL),(229,0,69,400000,6,'4R1LC',NULL),(230,1,73,550000,6,'V9RXZ',NULL),(231,1,89,550000,9,'N25PF',NULL),(232,0,99,400000,8,'41IT9',NULL),(233,1,66,550000,2,'LAEOQ',NULL),(234,2,58,700000,9,'H2AHC',NULL),(235,1,74,550000,0,'QQ75Y',NULL),(236,1,50,550000,3,'U0GDG',NULL),(237,2,55,700000,1,'OOR18',NULL),(238,1,89,550000,11,'SEYGT',NULL),(239,0,88,400000,11,'JW08L',NULL),(240,1,82,550000,9,'NKD1P',NULL),(241,2,73,700000,0,'7ABJ5',NULL),(242,0,50,400000,8,'1N4GE',NULL),(243,0,76,400000,5,'5K2RC',NULL),(244,2,89,700000,6,'XVJH8',NULL),(245,2,71,700000,10,'YDWAJ',NULL),(246,0,67,400000,8,'7HEHP',NULL),(247,1,63,550000,8,'97I85',NULL),(248,1,61,550000,4,'K7BM4',NULL),(249,1,62,550000,10,'MA07R',NULL),(250,2,70,700000,4,'CM2XY',NULL),(251,0,52,400000,5,'NV2YZ',NULL),(252,0,76,400000,9,'INC9P',NULL),(253,0,64,400000,11,'PJBM1',NULL),(254,1,57,550000,11,'WX0ZY',NULL),(255,1,67,550000,6,'YB3CK',NULL),(256,0,70,400000,9,'WFK05',NULL),(257,1,54,550000,7,'HFDL5',NULL),(258,2,53,700000,0,'08LKG',NULL),(259,1,80,550000,7,'ZR6JO',NULL),(260,2,71,700000,4,'6WY0M',NULL),(261,0,69,400000,2,'N8BLO',NULL),(262,1,70,550000,6,'9PK1A',NULL),(263,2,59,700000,8,'NOCYQ',NULL),(264,0,54,400000,8,'8GIRR',NULL),(265,2,83,700000,9,'9V4RZ',NULL),(266,1,95,550000,5,'SWXQF',NULL),(267,0,60,400000,6,'F36WO',NULL),(268,0,100,400000,8,'DF7CW',NULL),(269,0,61,400000,7,'0SLTU',NULL),(270,0,99,400000,10,'L1QKD',NULL),(271,1,100,550000,11,'2YJ86',NULL),(272,2,80,700000,1,'9TRM3',NULL),(273,0,86,400000,6,'5MPAU',NULL),(274,0,62,400000,8,'YHEJS',NULL),(275,0,60,400000,3,'V0HLE',NULL),(276,2,92,700000,1,'017QQ',NULL),(277,2,65,700000,9,'BO0II',NULL),(278,1,52,550000,2,'JMYNA',NULL),(279,1,68,550000,0,'Y5NVH',NULL),(280,0,50,400000,4,'DATBN',NULL),(281,1,70,550000,2,'4UDEH',NULL),(282,0,96,400000,11,'SA9A7',NULL),(283,2,52,700000,0,'BXS2X',NULL),(284,1,90,550000,0,'3FW1O',NULL),(285,2,55,700000,6,'4EWUH',NULL),(286,0,75,400000,7,'IDC2W',NULL),(287,0,52,400000,1,'KQHXI',NULL),(288,1,88,550000,9,'5832G',NULL),(289,0,57,400000,0,'MMNK3',NULL),(290,1,55,550000,11,'DY3G6',NULL),(291,2,64,700000,7,'XPW6K',NULL),(292,2,69,700000,10,'4DKC1',NULL),(293,2,80,700000,2,'V0FAK',NULL),(294,0,85,400000,10,'MOW48',NULL),(295,1,61,550000,8,'XLE5F',NULL),(296,1,84,550000,3,'P2Y8J',NULL),(297,2,50,700000,2,'8CE82',NULL),(298,2,86,700000,8,'JI1I9',NULL),(299,0,50,400000,0,'QGDO7',NULL),(300,2,65,700000,6,'PQLJA',NULL),(301,0,55,400000,8,'TGOUM',NULL),(302,0,59,400000,3,'7QOBY',NULL),(303,0,93,400000,2,'CZ39C',NULL),(304,0,86,400000,8,'QYI83',NULL),(305,2,87,700000,3,'F1WTV',NULL),(306,1,62,550000,8,'JRF9P',NULL),(307,0,70,400000,4,'JZ239',NULL),(308,1,79,550000,7,'9ENIJ',NULL),(309,0,71,400000,1,'DESFY',NULL),(310,0,65,400000,8,'7PIIM',NULL),(311,2,85,700000,9,'KNDYL',NULL),(312,2,87,700000,4,'32XW9',NULL),(313,1,65,550000,3,'9GNM6',NULL),(314,0,97,400000,1,'8P4RT',NULL),(315,2,100,700000,11,'WUSPN',NULL),(316,1,57,550000,5,'F5KXQ',NULL),(317,2,91,700000,2,'47ZEL',NULL),(318,1,57,550000,2,'MSWC9',NULL),(319,0,92,400000,9,'KMK3L',NULL),(320,2,79,700000,2,'BL3GI',NULL),(321,1,95,550000,6,'AOI6J',NULL),(322,0,72,400000,4,'5KJYG',NULL),(323,1,84,550000,0,'U2Q7C',NULL),(324,1,93,550000,1,'V5N6E',NULL),(325,0,100,400000,5,'5WHH8',NULL),(326,0,70,400000,2,'B55AE',NULL),(327,1,53,550000,11,'ZZ6BB',NULL),(328,2,59,700000,10,'DFUIE',NULL),(329,0,79,400000,9,'AZ9DY',NULL),(330,1,75,550000,1,'UENCU',NULL),(331,0,86,400000,2,'QHNI2',NULL),(332,2,95,700000,6,'SA7L7',NULL),(333,0,62,400000,11,'UEFRE',NULL),(334,2,60,700000,11,'SRR45',NULL),(335,1,98,550000,2,'RESMK',NULL),(336,1,50,550000,3,'ATPHY',NULL),(337,0,73,400000,9,'XC0VK',NULL),(338,2,75,700000,10,'NHFCV',NULL),(339,1,59,550000,11,'1L0JJ',NULL),(340,1,66,550000,4,'8IDSS',NULL),(341,0,91,400000,7,'KP3QC',NULL),(342,0,88,400000,7,'Z42ZX',NULL),(343,1,86,550000,9,'K4W97',NULL),(344,0,92,400000,4,'QVGNQ',NULL),(345,0,91,400000,3,'R414G',NULL),(346,1,57,550000,0,'K0DOF',NULL),(347,2,88,700000,9,'KCWM8',NULL),(348,2,85,700000,5,'91E3Z',NULL),(349,0,83,400000,3,'YNYJM',NULL),(350,1,66,550000,4,'UJM60',NULL),(351,2,94,700000,5,'ALA6Y',NULL),(352,1,57,550000,1,'9QRXR',NULL),(353,1,99,550000,2,'SVYMO',NULL),(354,1,75,550000,0,'JR41Z',NULL),(355,2,80,700000,5,'P96V1',NULL),(356,1,69,550000,7,'B8RXK',NULL),(357,2,86,700000,10,'HBAVF',NULL),(358,0,54,400000,5,'DJIZX',NULL),(359,1,79,550000,2,'U78CY',NULL);
/*!40000 ALTER TABLE `bike` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dock`
--

DROP TABLE IF EXISTS `dock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dock` (
  `id` int NOT NULL,
  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(145) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dock`
--

LOCK TABLES `dock` WRITE;
/*!40000 ALTER TABLE `dock` DISABLE KEYS */;
INSERT INTO `dock` VALUES (0,'Wano','128 One Piece, Japan'),(1,'Uchiha','128 Naruto, Japan'),(2,'Conan','101  Cambridge Road'),(3,'ALLIGIN SHUAS','54  Withers Close'),(4,'PLAISTOW','26  Wressle Road'),(5,'EBFORD','109  Haslemere Road'),(6,'Eloise K Farrell','61  Wressle Road'),(7,'TINDALE','52  Brackley Road'),(8,'Coates','64  Warren St'),(9,'Scott ','51  Jesmond Rd'),(10,'Davies','54  Botley Road'),(11,'Courtney ','81 Park Place');
/*!40000 ALTER TABLE `dock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `bikeId` int DEFAULT NULL,
  `userId` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  `total` int DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `time` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `userId_idx` (`userId`),
  KEY `bikeId` (`bikeId`),
  CONSTRAINT `bikeId` FOREIGN KEY (`bikeId`) REFERENCES `bike` (`id`),
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (3,0,0,0,0,'2020-12-18 00:00:00',0),(5,40,0,0,16000,'2020-12-18 23:04:12',1801),(6,40,0,0,16000,'2020-12-18 23:21:15',1801),(7,40,0,0,0,'2020-12-19 00:19:34',16),(8,40,0,0,0,'2020-12-19 00:57:29',15);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `card` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (0,'Dang Lam San','1234 5678 1201');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-19 14:49:29
