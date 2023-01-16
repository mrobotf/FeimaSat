-- MySQL dump 10.13  Distrib 8.0.27, for Linux (aarch64)
--
-- Host: localhost    Database: bankinfo
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `moneyinfo`
--

DROP TABLE IF EXISTS `moneyinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `moneyinfo` (
  `username` varchar(10) DEFAULT NULL,
  `balance` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moneyinfo`
--

LOCK TABLES `moneyinfo` WRITE;
/*!40000 ALTER TABLE `moneyinfo` DISABLE KEYS */;
INSERT INTO `moneyinfo` VALUES ('qwe',2000),('pjc',11000),('qaz',5000),('qazwsx',6000),('pan',2000),('zhi',10000),('zhizhi',5000),('zhifubao',3000);
/*!40000 ALTER TABLE `moneyinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo` (
  `username` varchar(10) DEFAULT NULL,
  `userid` bigint DEFAULT NULL,
  `id` bigint DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `phone` bigint DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `dob` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES ('qwe',NULL,NULL,'456',NULL,NULL,NULL),('pjc',610521200209112978,123456789,'112233',19944155243,'F','2002-09-11'),('qaz',21412441,354354343,'1234567890',1242297378,'F','1998-08-09'),('qazwsx',124254141,2314231,'123123123',111222333,'F','2001-11-09'),('pan',1242424,12312424,'11111111',11111111,'F','2001-09-09'),('zhi',3215241,123154231,'123456',123456,'F','2002-09-09'),('zhizhi',1241242,31241231,'123456',13325672678,'F','2001-09-09'),('zhifubao',12345678,12345678,'112233',15332230760,'F','2002-09-09');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-02 12:47:40
