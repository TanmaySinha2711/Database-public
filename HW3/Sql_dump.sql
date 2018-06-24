-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: hw2_sinha_tanmay_2018
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `person_id` int(11) NOT NULL,
  `street1` varchar(45) NOT NULL,
  `street2` varchar(45) DEFAULT NULL,
  `city` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `zip` varchar(45) NOT NULL,
  `primary` tinyint(4) DEFAULT '0',
  KEY `address_person_composition_idx` (`person_id`),
  CONSTRAINT `address_person_composition` FOREIGN KEY (`person_id`) REFERENCES `person` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (12,'123 Adam St',NULL,'Alton','Uttar Pradesh','01234',1),(12,'234 Birch St',NULL,'Boston','Uttar Pradesh','02345',0),(23,'345 Charles St',NULL,'Chelms','Uttar Pradesh','03455',1),(23,'456 Down St.',NULL,'Dalton','Uttar Pradesh','04566',0),(23,'543 East St',NULL,'Everett','Uttar Pradesh','01112',0),(34,'654 Frank St.',NULL,'Foulton','Uttar Pradesh','04322',1);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `developer`
--

DROP TABLE IF EXISTS `developer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `developer` (
  `ID` int(11) NOT NULL,
  `developer_key` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `developer_person_generalization` FOREIGN KEY (`ID`) REFERENCES `person` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `developer`
--

LOCK TABLES `developer` WRITE;
/*!40000 ALTER TABLE `developer` DISABLE KEYS */;
INSERT INTO `developer` VALUES (12,'4321rewq'),(23,'5432trew'),(34,'6543ytre');
/*!40000 ALTER TABLE `developer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `page`
--

DROP TABLE IF EXISTS `page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `page` (
  `PageID` int(11) NOT NULL AUTO_INCREMENT,
  `WebsiteID` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `created` date NOT NULL,
  `updated` date DEFAULT NULL,
  `views` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`PageID`),
  KEY `page_website_composition` (`WebsiteID`),
  CONSTRAINT `page_website_composition` FOREIGN KEY (`WebsiteID`) REFERENCES `website` (`WebsiteID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=568 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `page`
--

LOCK TABLES `page` WRITE;
/*!40000 ALTER TABLE `page` DISABLE KEYS */;
INSERT INTO `page` VALUES (123,567,'Home','Landing page','2018-05-07','2018-06-10',123434),(234,678,'About','Website description','2018-05-07','2018-06-10',234545),(345,345,'Contact','Addresses, phones, and contact info','2018-05-07','2018-06-10',345656),(456,456,'Preferences','Where users can configure their preferences','2018-05-07','2018-06-10',456776),(567,567,'Profile','Users can configure their personal information','2018-05-07','2018-06-10',567878);
/*!40000 ALTER TABLE `page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pageprivilege`
--

DROP TABLE IF EXISTS `pageprivilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pageprivilege` (
  `Privilege` varchar(45) NOT NULL,
  `developerID` int(11) NOT NULL,
  `pageID` int(11) NOT NULL,
  KEY `privilege_key_idx` (`Privilege`),
  KEY `privilege_developer_key_idx` (`developerID`),
  KEY `privilege_page_key_idx` (`pageID`),
  CONSTRAINT `privilege_dp_developer_key` FOREIGN KEY (`developerID`) REFERENCES `developer` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `privilege_dp_key` FOREIGN KEY (`Privilege`) REFERENCES `privilege` (`privilege_name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `privilege_page_key` FOREIGN KEY (`pageID`) REFERENCES `page` (`PageID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pageprivilege`
--

LOCK TABLES `pageprivilege` WRITE;
/*!40000 ALTER TABLE `pageprivilege` DISABLE KEYS */;
/*!40000 ALTER TABLE `pageprivilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagerole`
--

DROP TABLE IF EXISTS `pagerole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagerole` (
  `Role` varchar(45) NOT NULL,
  `developerID` int(11) NOT NULL,
  `pageID` int(11) NOT NULL,
  KEY `role_dp_key_idx` (`Role`),
  KEY `role_dp_developer_key_idx` (`developerID`),
  KEY `role_page_key_idx` (`pageID`),
  CONSTRAINT `role_dp_developer_key` FOREIGN KEY (`developerID`) REFERENCES `developer` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `role_dp_key` FOREIGN KEY (`Role`) REFERENCES `role` (`role_name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `role_page_key` FOREIGN KEY (`pageID`) REFERENCES `page` (`PageID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagerole`
--

LOCK TABLES `pagerole` WRITE;
/*!40000 ALTER TABLE `pagerole` DISABLE KEYS */;
INSERT INTO `pagerole` VALUES ('Editor',12,123),('Reviewer',23,123),('Writer',34,123),('Writer',12,234),('Reviewer',34,234),('Editor',23,234),('Editor',34,345),('Reviewer',12,345),('Writer',23,345),('Writer',34,456),('Reviewer',23,456),('Editor',12,456),('Editor',23,567),('Reviewer',34,567),('Writer',12,567);
/*!40000 ALTER TABLE `pagerole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `dob` date DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (12,'Alice','Wonder','alice','alice@wonder.com',NULL,'alice'),(23,'Bob','Marley','bob','bob@wmarley.com',NULL,'bob'),(34,'Charles','Garcia','charlie','chuch@garcia.com',NULL,'charlie'),(45,'Dan','Martin','dan','dan@martin.com',NULL,'dan'),(56,'Ed','Karaz','ed','ed@kar.com',NULL,'ed');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone` (
  `personid` int(11) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `primary` tinyint(4) DEFAULT NULL,
  KEY `phone_person_composition_idx` (`personid`),
  CONSTRAINT `phone_person_composition` FOREIGN KEY (`personid`) REFERENCES `person` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
INSERT INTO `phone` VALUES (12,'123-234-3456',1),(12,'234-345-4566',0),(23,'345-456-5677',1),(34,'321-432-5435',1),(34,'432-432-5433',0),(34,'543-543-6544',0);
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privilege` (
  `privilege_name` varchar(45) NOT NULL,
  PRIMARY KEY (`privilege_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
INSERT INTO `privilege` VALUES ('Create'),('Delete'),('Read'),('Update');
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('Admin'),('Editor'),('Owner'),('Reviewer'),('Writer');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `user_key` varchar(45) NOT NULL,
  `user_agreement` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  CONSTRAINT `user_person_generalization` FOREIGN KEY (`ID`) REFERENCES `person` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (45,'7654fda',0),(56,'5678dfgh',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `website`
--

DROP TABLE IF EXISTS `website`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `website` (
  `WebsiteID` int(11) NOT NULL AUTO_INCREMENT,
  `developerID` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `created` date NOT NULL,
  `updated` date DEFAULT NULL,
  `visits` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`WebsiteID`),
  KEY `developer_website_key_idx` (`developerID`),
  CONSTRAINT `developer_website_key` FOREIGN KEY (`developerID`) REFERENCES `developer` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=679 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `website`
--

LOCK TABLES `website` WRITE;
/*!40000 ALTER TABLE `website` DISABLE KEYS */;
INSERT INTO `website` VALUES (123,12,'Facebook','an online social media and social networking service','2018-06-08','2018-06-08',1234234),(234,23,'Twitter','an online social media and social networking service','2018-06-08','2018-06-08',4321543),(345,34,'Wikipedia','a free online encyclopedia','2018-06-08','2018-06-08',3456654),(456,12,'CNN','an American basic cable and satellite television news channel','2018-06-08','2018-06-08',6543345),(567,23,'CNET','an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics','2018-06-08','2018-06-08',5433455),(678,34,'Gizmodo','a design, technology, science and science fiction website that also writes articles on politics','2018-06-08','2018-06-08',4322345);
/*!40000 ALTER TABLE `website` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `websiteprivilege`
--

DROP TABLE IF EXISTS `websiteprivilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `websiteprivilege` (
  `Privilege` varchar(45) NOT NULL,
  `developerID` int(11) NOT NULL,
  `websiteID` int(11) NOT NULL,
  KEY `privilege_key_idx` (`Privilege`),
  KEY `developer_privilege_key_idx` (`developerID`),
  KEY `website_privilege_key_idx` (`websiteID`),
  CONSTRAINT `developer_privilege_key` FOREIGN KEY (`developerID`) REFERENCES `developer` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `privilege_key` FOREIGN KEY (`Privilege`) REFERENCES `privilege` (`privilege_name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `website_privilege_key` FOREIGN KEY (`websiteID`) REFERENCES `website` (`WebsiteID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `websiteprivilege`
--

LOCK TABLES `websiteprivilege` WRITE;
/*!40000 ALTER TABLE `websiteprivilege` DISABLE KEYS */;
/*!40000 ALTER TABLE `websiteprivilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `websiterole`
--

DROP TABLE IF EXISTS `websiterole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `websiterole` (
  `Role` varchar(45) NOT NULL,
  `developerID` int(11) NOT NULL,
  `websiteID` int(11) NOT NULL,
  KEY `role_key_idx` (`Role`),
  KEY `developer_role_key_idx` (`developerID`),
  KEY `website_role_key_idx` (`websiteID`),
  CONSTRAINT `developer_role_key` FOREIGN KEY (`developerID`) REFERENCES `developer` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `role_key` FOREIGN KEY (`Role`) REFERENCES `role` (`role_name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `website_role_key` FOREIGN KEY (`websiteID`) REFERENCES `website` (`WebsiteID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `websiterole`
--

LOCK TABLES `websiterole` WRITE;
/*!40000 ALTER TABLE `websiterole` DISABLE KEYS */;
INSERT INTO `websiterole` VALUES ('Owner',12,123),('Editor',23,123),('Admin',34,123),('Owner',23,234),('Editor',34,234),('Admin',12,234),('Admin',23,345),('Editor',12,345),('Owner',34,345),('Owner',12,456),('Editor',23,456),('Admin',34,456),('Admin',12,567),('Editor',34,567),('Owner',23,567),('Owner',34,678),('Editor',12,678),('Admin',23,678);
/*!40000 ALTER TABLE `websiterole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `widget`
--

DROP TABLE IF EXISTS `widget`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `widget` (
  `ID` int(11) NOT NULL,
  `pageID` int(11) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `width` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `cssClass` varchar(45) NOT NULL,
  `cssStyle` varchar(45) NOT NULL,
  `text` varchar(1024) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `Type` varchar(45) NOT NULL,
  `url` varchar(45) DEFAULT NULL,
  `sharable` tinyint(4) DEFAULT '0',
  `expandable` tinyint(4) DEFAULT '0',
  `src` varchar(45) DEFAULT NULL,
  `size` int(11) DEFAULT '2',
  `html` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `widget_type_idx` (`Type`),
  KEY `widget_page_composition_idx` (`pageID`),
  CONSTRAINT `widget_page_composition` FOREIGN KEY (`pageID`) REFERENCES `page` (`PageID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `widget_type` FOREIGN KEY (`Type`) REFERENCES `widgettype` (`type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `widget`
--

LOCK TABLES `widget` WRITE;
/*!40000 ALTER TABLE `widget` DISABLE KEYS */;
INSERT INTO `widget` VALUES (123,123,'head123',0,0,'omae wa mou shindeiru','nani?','Welcome',0,'Heading',NULL,1,0,NULL,NULL,NULL),(234,234,'post234',0,0,'omae wa mou shindeiru','nani?','<p>Lorem</p>',0,'HTML',NULL,1,0,NULL,NULL,'<p>Lorem</p>'),(345,345,'head345',0,0,'omae wa mou shindeiru','nani?','Hi',1,'Heading',NULL,1,0,NULL,NULL,NULL),(456,345,'intro456',0,0,'omae wa mou shindeiru','nani?','<h1>Hi</h1>',2,'HTML',NULL,1,0,NULL,NULL,'<h1>Hi</h1>'),(567,345,'image345',50,100,'omae wa mou shindeiru','nani?',NULL,3,'Image','/img/567.png',1,0,NULL,NULL,NULL),(678,456,'video456',400,300,'omae wa mou shindeiru','nani?',NULL,0,'YouTube',NULL,1,0,'https://youtu.be/h67VX51QXiQ',NULL,NULL);
/*!40000 ALTER TABLE `widget` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `widgettype`
--

DROP TABLE IF EXISTS `widgettype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `widgettype` (
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `widgettype`
--

LOCK TABLES `widgettype` WRITE;
/*!40000 ALTER TABLE `widgettype` DISABLE KEYS */;
INSERT INTO `widgettype` VALUES ('Heading'),('HTML'),('Image'),('YouTube');
/*!40000 ALTER TABLE `widgettype` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-08 19:53:29
