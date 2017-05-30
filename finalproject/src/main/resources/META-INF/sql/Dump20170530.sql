CREATE DATABASE  IF NOT EXISTS `cinema_ticketing_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cinema_ticketing_db`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: cinema_ticketing_db
-- ------------------------------------------------------
-- Server version	5.7.17

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
-- Table structure for table `bought_seat`
--

DROP TABLE IF EXISTS `bought_seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bought_seat` (
  `seat_id` int(11) NOT NULL,
  `row` int(11) DEFAULT NULL,
  `col` int(11) DEFAULT NULL,
  `cutting_id` int(11) NOT NULL,
  PRIMARY KEY (`seat_id`,`cutting_id`),
  KEY `cutting_id_idx` (`cutting_id`),
  CONSTRAINT `FKsga6kj5wp88mt01afqy17gq5t` FOREIGN KEY (`cutting_id`) REFERENCES `movie_cutting` (`movie_cutting_id`),
  CONSTRAINT `cutting_id` FOREIGN KEY (`cutting_id`) REFERENCES `movie_cutting` (`movie_cutting_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bought_seat`
--

LOCK TABLES `bought_seat` WRITE;
/*!40000 ALTER TABLE `bought_seat` DISABLE KEYS */;
INSERT INTO `bought_seat` VALUES (1,1,1,1),(2,1,2,1),(3,1,3,1),(18,2,8,1),(19,2,9,1),(21,2,11,1),(22,2,12,1),(23,3,3,1),(28,3,8,1),(29,3,9,1),(34,4,4,1),(35,4,5,1),(38,4,8,1),(39,4,9,1),(40,4,10,1),(41,5,1,1),(42,5,2,1),(43,5,3,1),(48,5,8,1),(49,5,9,1),(50,5,10,1),(53,6,3,1),(54,6,4,1),(58,6,8,1),(59,6,9,1),(60,6,10,1),(61,6,11,1),(62,6,12,1),(63,7,3,1),(68,7,8,1),(69,7,9,1),(70,7,10,1),(78,8,8,1),(79,8,9,1),(80,8,10,1),(81,9,1,1),(82,9,2,1),(83,9,3,1);
/*!40000 ALTER TABLE `bought_seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cinema`
--

DROP TABLE IF EXISTS `cinema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cinema` (
  `cinema_id` int(11) NOT NULL AUTO_INCREMENT,
  `cinema_name` varchar(45) CHARACTER SET gb2312 DEFAULT NULL,
  `address` varchar(45) CHARACTER SET gb2312 DEFAULT NULL,
  `description` tinytext CHARACTER SET gb2312,
  `rate` int(11) DEFAULT NULL,
  PRIMARY KEY (`cinema_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinema`
--

LOCK TABLES `cinema` WRITE;
/*!40000 ALTER TABLE `cinema` DISABLE KEYS */;
INSERT INTO `cinema` VALUES (1,'珠江影城','大学城','还行',4),(2,'白云影城','白云区','挺好',5),(3,'万达影城','海珠区','挺好',5),(4,'阿里影城','海珠区','挺好',5);
/*!40000 ALTER TABLE `cinema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` tinytext,
  `rate` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `cmt_movie_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `cmt_movie_id_idx` (`cmt_movie_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `FK61ejaiyyut8h13nirbkig7oy6` FOREIGN KEY (`cmt_movie_id`) REFERENCES `movie` (`movie_id`),
  CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `cmt_movie_id` FOREIGN KEY (`cmt_movie_id`) REFERENCES `movie` (`movie_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie` (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(45) CHARACTER SET gb2312 DEFAULT NULL,
  `description` tinytext CHARACTER SET gb2312,
  `price` double DEFAULT NULL,
  `cinema_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`movie_id`),
  KEY `cinema_id_idx` (`cinema_id`),
  CONSTRAINT `FKcxqqfikr2t9yv97cd1lgyikv7` FOREIGN KEY (`cinema_id`) REFERENCES `cinema` (`cinema_id`),
  CONSTRAINT `cinema_id` FOREIGN KEY (`cinema_id`) REFERENCES `cinema` (`cinema_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'加勒比海盗5','好看',35,1),(2,'摔跤吧爸爸','好看',35,1),(3,'荡寇风云','好看',35,2),(4,'三只小猪2','不看',35,2);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_cutting`
--

DROP TABLE IF EXISTS `movie_cutting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie_cutting` (
  `movie_cutting_id` int(11) NOT NULL AUTO_INCREMENT,
  `start_date` date DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  `hall_number` int(11) DEFAULT NULL,
  `movie_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`movie_cutting_id`),
  KEY `movie_id_idx` (`movie_id`),
  CONSTRAINT `FK4cv26j24pjuikppqb0nhksw8j` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`),
  CONSTRAINT `movie_id` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_cutting`
--

LOCK TABLES `movie_cutting` WRITE;
/*!40000 ALTER TABLE `movie_cutting` DISABLE KEYS */;
INSERT INTO `movie_cutting` VALUES (1,'2017-06-11','19:30:00',100,5,1);
/*!40000 ALTER TABLE `movie_cutting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(45) DEFAULT NULL,
  `movie_name` varchar(45) CHARACTER SET gb2312 DEFAULT NULL,
  `cinema_name` varchar(45) CHARACTER SET gb2312 DEFAULT NULL,
  `hall_number` varchar(45) DEFAULT NULL,
  `row` int(11) DEFAULT NULL,
  `col` int(11) DEFAULT NULL,
  `total_price` varchar(45) DEFAULT NULL,
  `order_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `order_user_id_idx` (`order_user_id`),
  CONSTRAINT `FK27f1iim365211uflgbedcq85r` FOREIGN KEY (`order_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `order_user_id` FOREIGN KEY (`order_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,'2017-05-30','加勒比海盗5','珠江影城','5',1,2,'70.0',5);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `balance` double DEFAULT '0',
  `portrait` longblob,
  `email` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,'huitr','123456',NULL,NULL,NULL,NULL,1),(5,'tom','12345',NULL,NULL,'tom@gmail.com','12345678',1),(6,'jerry','12345',NULL,NULL,'jerry@gmail.com','12345678',1);
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

-- Dump completed on 2017-05-30  3:09:16
