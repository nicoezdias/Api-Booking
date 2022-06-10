CREATE DATABASE  IF NOT EXISTS `BookingDB` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `BookingDB`;
-- MySQL dump 10.13  Distrib 8.0.29, for macos12 (x86_64)
--
-- Host: dbmysql-grupo08.cqgaxtjzrcm6.us-west-1.rds.amazonaws.com    Database: BookingDB
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL,
  `description` longtext,
  `text_alt` varchar(255) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `url_image` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Un hotel es un edificio planificado y acondicionado para otorgar servicios de alojamiento a las personas. Los hoteles proveen a los huéspedes de servicios adicionales como restaurantes, piscinas y guarderías.','imageHotelesCategory','Hoteles','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/hotel.jpg'),(2,'Un albergue es una forma de alojamiento sociable compartido a corto plazo y de bajo costo donde los huéspedes pueden alquilar una cama, generalmente una litera en un dormitorio, con uso compartido de un salón y, a veces, una cocina.','imageHostelsCategory','Hostels','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/hostel.jpg'),(3,'Un apartamento es una unidad de vivienda que comprende una o más habitaciones diseñadas para proporcionar instalaciones completas para un individuo o una pequeña familia.','imageDeptosCategory','Departamentos','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/departamento.jpg'),(4,'El Bed and Breakfast, es un establecimiento hotelero que ofrece precios moderados. La expresión inglesa, se traduce como \'cama y desayuno\'','imageB&BCategory','Bed and breakfast','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/bedandbreakfast.jpg');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_sequence`
--

DROP TABLE IF EXISTS `category_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_sequence`
--

LOCK TABLES `category_sequence` WRITE;
/*!40000 ALTER TABLE `category_sequence` DISABLE KEYS */;
INSERT INTO `category_sequence` VALUES (5);
/*!40000 ALTER TABLE `category_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id` bigint NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `name_country` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Buenos Aires','Argentina'),(2,'Chaco','Argentina'),(3,'Formosa','Argentina'),(4,'Cordoba','Argentina'),(5,'San Luis','Argentina'),(6,'Barranquilla','Colombia'),(7,'Bogota','Colombia'),(8,'Medellin','Colombia'),(9,'Santa Marta','Colombia'),(10,'San Andrés','Colombia');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city_sequence`
--

DROP TABLE IF EXISTS `city_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city_sequence`
--

LOCK TABLES `city_sequence` WRITE;
/*!40000 ALTER TABLE `city_sequence` DISABLE KEYS */;
INSERT INTO `city_sequence` VALUES (11);
/*!40000 ALTER TABLE `city_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feature`
--

DROP TABLE IF EXISTS `feature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feature` (
  `id` bigint NOT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feature`
--

LOCK TABLES `feature` WRITE;
/*!40000 ALTER TABLE `feature` DISABLE KEYS */;
INSERT INTO `feature` VALUES (1,'IconCocina','Cocina'),(2,'IconTelevisor','Televisor'),(3,'IconoAireAcondicionado','Aire acondicionado'),(4,'IconAptoMascotas','Apto mascotas'),(5,'IconEstacionamiento','Estacionamiento gratuito'),(6,'IconPileta','Pileta'),(7,'IconWifi','Wifi');
/*!40000 ALTER TABLE `feature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feature_sequence`
--

DROP TABLE IF EXISTS `feature_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feature_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feature_sequence`
--

LOCK TABLES `feature_sequence` WRITE;
/*!40000 ALTER TABLE `feature_sequence` DISABLE KEYS */;
INSERT INTO `feature_sequence` VALUES (8);
/*!40000 ALTER TABLE `feature_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id` bigint NOT NULL,
  `profile` bit(1) DEFAULT NULL,
  `text_alt` varchar(255) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `url` longtext,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgpextbyee3uk9u6o2381m7ft1` (`product_id`),
  CONSTRAINT `FKgpextbyee3uk9u6o2381m7ft1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,_binary '','galeriahotel1','Pileta','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel1.jpg',1),(2,NULL,'galeriahotel2','Desayuno','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel2.jpg',1),(3,NULL,'galeriahotel3','Area Social','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel3.jpg',1),(4,NULL,'galeriahotel4','Habitaciones de lujo','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel4.jpg',1),(5,NULL,'galeriahotel5','Vinoteca','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel5.jpg',1),(6,_binary '','galeriahostel1','Privacidad','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel1.jpg',11),(7,NULL,'galeriahostel2','Recepcion','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel2.jpg',11),(8,NULL,'galeriahostel3','Coworking','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel3.jpg',11),(9,NULL,'galeriahostel4','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel4.jpg',11),(10,NULL,'galeriahostel5','Cocina2','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel5.jpg',11),(11,_binary '','galeriadepa1','Balcon','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa1.jpg',21),(12,NULL,'galeriadepa2','Camas','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa2.jpg',21),(13,NULL,'galeriadepa3','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa3.jpg',21),(14,NULL,'galeriadepa4','Baño','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa4.jpg',21),(15,NULL,'galeriadepa5','Comedor','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa5.jpg',21),(16,_binary '','galeriabed1','Sala','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed1.jpg',31),(17,NULL,'galeriabed2','Lockers','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed2.jpg',31),(18,NULL,'galeriabed3','Patio','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed3.jpg',31),(19,NULL,'galeriabed4','Cama','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed4.jpg',31),(20,NULL,'galeriabed5','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed5.jpg',31),(21,_binary '','galeriahotel1','Pileta','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel1.jpg',2),(22,NULL,'galeriahotel2','Desayuno','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel2.jpg',2),(23,NULL,'galeriahotel3','Area Social','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel3.jpg',2),(24,NULL,'galeriahotel4','Habitaciones de lujo','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel4.jpg',2),(25,NULL,'galeriahotel5','Vinoteca','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel5.jpg',2),(26,_binary '','galeriahostel1','Privacidad','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel1.jpg',12),(27,NULL,'galeriahostel2','Recepcion','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel2.jpg',12),(28,NULL,'galeriahostel3','Coworking','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel3.jpg',12),(29,NULL,'galeriahostel4','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel4.jpg',12),(30,NULL,'galeriahostel5','Cocina2','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel5.jpg',12),(31,_binary '','galeriadepa1','Balcon','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa1.jpg',22),(32,NULL,'galeriadepa2','Camas','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa2.jpg',22),(33,NULL,'galeriadepa3','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa3.jpg',22),(34,NULL,'galeriadepa4','Baño','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa4.jpg',22),(35,NULL,'galeriadepa5','Comedor','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa5.jpg',22),(36,_binary '','galeriabed1','Sala','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed1.jpg',32),(37,NULL,'galeriabed2','Lockers','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed2.jpg',32),(38,NULL,'galeriabed3','Patio','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed3.jpg',32),(39,NULL,'galeriabed4','Cama','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed4.jpg',32),(40,NULL,'galeriabed5','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed5.jpg',32),(41,_binary '','galeriahotel1','Pileta','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel1.jpg',3),(42,NULL,'galeriahotel2','Desayuno','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel2.jpg',3),(43,NULL,'galeriahotel3','Area Social','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel3.jpg',3),(44,NULL,'galeriahotel4','Habitaciones de lujo','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel4.jpg',3),(45,NULL,'galeriahotel5','Vinoteca','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel5.jpg',3),(46,_binary '','galeriahostel1','Privacidad','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel1.jpg',13),(47,NULL,'galeriahostel2','Recepcion','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel2.jpg',13),(48,NULL,'galeriahostel3','Coworking','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel3.jpg',13),(49,NULL,'galeriahostel4','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel4.jpg',13),(50,NULL,'galeriahostel5','Cocina2','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel5.jpg',13),(51,_binary '','galeriadepa1','Balcon','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa1.jpg',23),(52,NULL,'galeriadepa2','Camas','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa2.jpg',23),(53,NULL,'galeriadepa3','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa3.jpg',23),(54,NULL,'galeriadepa4','Baño','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa4.jpg',23),(55,NULL,'galeriadepa5','Comedor','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa5.jpg',23),(56,_binary '','galeriabed1','Sala','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed1.jpg',33),(57,NULL,'galeriabed2','Lockers','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed2.jpg',33),(58,NULL,'galeriabed3','Patio','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed3.jpg',33),(59,NULL,'galeriabed4','Cama','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed4.jpg',33),(60,NULL,'galeriabed5','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed5.jpg',33),(61,_binary '','galeriahotel1','Pileta','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel1.jpg',4),(62,NULL,'galeriahotel2','Desayuno','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel2.jpg',4),(63,NULL,'galeriahotel3','Area Social','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel3.jpg',4),(64,NULL,'galeriahotel4','Habitaciones de lujo','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel4.jpg',4),(65,NULL,'galeriahotel5','Vinoteca','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel5.jpg',4),(66,_binary '','galeriahostel1','Privacidad','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel1.jpg',14),(67,NULL,'galeriahostel2','Recepcion','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel2.jpg',14),(68,NULL,'galeriahostel3','Coworking','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel3.jpg',14),(69,NULL,'galeriahostel4','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel4.jpg',14),(70,NULL,'galeriahostel5','Cocina2','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel5.jpg',14),(71,_binary '','galeriadepa1','Balcon','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa1.jpg',24),(72,NULL,'galeriadepa2','Camas','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa2.jpg',24),(73,NULL,'galeriadepa3','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa3.jpg',24),(74,NULL,'galeriadepa4','Baño','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa4.jpg',24),(75,NULL,'galeriadepa5','Comedor','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa5.jpg',24),(76,_binary '','galeriabed1','Sala','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed1.jpg',34),(77,NULL,'galeriabed2','Lockers','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed2.jpg',34),(78,NULL,'galeriabed3','Patio','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed3.jpg',34),(79,NULL,'galeriabed4','Cama','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed4.jpg',34),(80,NULL,'galeriabed5','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed5.jpg',34),(81,_binary '','galeriahotel1','Pileta','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel1.jpg',5),(82,NULL,'galeriahotel2','Desayuno','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel2.jpg',5),(83,NULL,'galeriahotel3','Area Social','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel3.jpg',5),(84,NULL,'galeriahotel4','Habitaciones de lujo','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel4.jpg',5),(85,NULL,'galeriahotel5','Vinoteca','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel5.jpg',5),(86,_binary '','galeriahostel1','Privacidad','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel1.jpg',15),(87,NULL,'galeriahostel2','Recepcion','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel2.jpg',15),(88,NULL,'galeriahostel3','Coworking','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel3.jpg',15),(89,NULL,'galeriahostel4','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel4.jpg',15),(90,NULL,'galeriahostel5','Cocina2','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel5.jpg',15),(91,_binary '','galeriadepa1','Balcon','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa1.jpg',25),(92,NULL,'galeriadepa2','Camas','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa2.jpg',25),(93,NULL,'galeriadepa3','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa3.jpg',25),(94,NULL,'galeriadepa4','Baño','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa4.jpg',25),(95,NULL,'galeriadepa5','Comedor','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa5.jpg',25),(96,_binary '','galeriabed1','Sala','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed1.jpg',35),(97,NULL,'galeriabed2','Lockers','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed2.jpg',35),(98,NULL,'galeriabed3','Patio','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed3.jpg',35),(99,NULL,'galeriabed4','Cama','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed4.jpg',35),(100,NULL,'galeriabed5','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed5.jpg',35),(101,_binary '','galeriahotel1','Pileta','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel1.jpg',6),(102,NULL,'galeriahotel2','Desayuno','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel2.jpg',6),(103,NULL,'galeriahotel3','Area Social','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel3.jpg',6),(104,NULL,'galeriahotel4','Habitaciones de lujo','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel4.jpg',6),(105,NULL,'galeriahotel5','Vinoteca','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel5.jpg',6),(106,_binary '','galeriahostel1','Privacidad','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel1.jpg',16),(107,NULL,'galeriahostel2','Recepcion','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel2.jpg',16),(108,NULL,'galeriahostel3','Coworking','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel3.jpg',16),(109,NULL,'galeriahostel4','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel4.jpg',16),(110,NULL,'galeriahostel5','Cocina2','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel5.jpg',16),(111,_binary '','galeriadepa1','Balcon','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa1.jpg',26),(112,NULL,'galeriadepa2','Camas','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa2.jpg',26),(113,NULL,'galeriadepa3','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa3.jpg',26),(114,NULL,'galeriadepa4','Baño','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa4.jpg',26),(115,NULL,'galeriadepa5','Comedor','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa5.jpg',26),(116,_binary '','galeriabed1','Sala','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed1.jpg',36),(117,NULL,'galeriabed2','Lockers','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed2.jpg',36),(118,NULL,'galeriabed3','Patio','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed3.jpg',36),(119,NULL,'galeriabed4','Cama','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed4.jpg',36),(120,NULL,'galeriabed5','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed5.jpg',36),(121,_binary '','galeriahotel1','Pileta','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel1.jpg',7),(122,NULL,'galeriahotel2','Desayuno','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel2.jpg',7),(123,NULL,'galeriahotel3','Area Social','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel3.jpg',7),(124,NULL,'galeriahotel4','Habitaciones de lujo','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel4.jpg',7),(125,NULL,'galeriahotel5','Vinoteca','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel5.jpg',7),(126,_binary '','galeriahostel1','Privacidad','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel1.jpg',17),(127,NULL,'galeriahostel2','Recepcion','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel2.jpg',17),(128,NULL,'galeriahostel3','Coworking','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel3.jpg',17),(129,NULL,'galeriahostel4','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel4.jpg',17),(130,NULL,'galeriahostel5','Cocina2','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel5.jpg',17),(131,_binary '','galeriadepa1','Balcon','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa1.jpg',27),(132,NULL,'galeriadepa2','Camas','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa2.jpg',27),(133,NULL,'galeriadepa3','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa3.jpg',27),(134,NULL,'galeriadepa4','Baño','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa4.jpg',27),(135,NULL,'galeriadepa5','Comedor','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa5.jpg',27),(136,_binary '','galeriabed1','Sala','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed1.jpg',37),(137,NULL,'galeriabed2','Lockers','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed2.jpg',37),(138,NULL,'galeriabed3','Patio','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed3.jpg',37),(139,NULL,'galeriabed4','Cama','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed4.jpg',37),(140,NULL,'galeriabed5','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed5.jpg',37),(141,_binary '','galeriahotel1','Pileta','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel1.jpg',8),(142,NULL,'galeriahotel2','Desayuno','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel2.jpg',8),(143,NULL,'galeriahotel3','Area Social','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel3.jpg',8),(144,NULL,'galeriahotel4','Habitaciones de lujo','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel4.jpg',8),(145,NULL,'galeriahotel5','Vinoteca','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel5.jpg',8),(146,_binary '','galeriahostel1','Privacidad','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel1.jpg',18),(147,NULL,'galeriahostel2','Recepcion','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel2.jpg',18),(148,NULL,'galeriahostel3','Coworking','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel3.jpg',18),(149,NULL,'galeriahostel4','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel4.jpg',18),(150,NULL,'galeriahostel5','Cocina2','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel5.jpg',18),(151,_binary '','galeriadepa1','Balcon','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa1.jpg',28),(152,NULL,'galeriadepa2','Camas','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa2.jpg',28),(153,NULL,'galeriadepa3','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa3.jpg',28),(154,NULL,'galeriadepa4','Baño','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa4.jpg',28),(155,NULL,'galeriadepa5','Comedor','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa5.jpg',28),(156,_binary '','galeriabed1','Sala','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed1.jpg',38),(157,NULL,'galeriabed2','Lockers','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed2.jpg',38),(158,NULL,'galeriabed3','Patio','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed3.jpg',38),(159,NULL,'galeriabed4','Cama','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed4.jpg',38),(160,NULL,'galeriabed5','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed5.jpg',38),(161,_binary '','galeriahotel1','Pileta','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel1.jpg',9),(162,NULL,'galeriahotel2','Desayuno','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel2.jpg',9),(163,NULL,'galeriahotel3','Area Social','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel3.jpg',9),(164,NULL,'galeriahotel4','Habitaciones de lujo','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel4.jpg',9),(165,NULL,'galeriahotel5','Vinoteca','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel5.jpg',9),(166,_binary '','galeriahostel1','Privacidad','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel1.jpg',19),(167,NULL,'galeriahostel2','Recepcion','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel2.jpg',19),(168,NULL,'galeriahostel3','Coworking','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel3.jpg',19),(169,NULL,'galeriahostel4','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel4.jpg',19),(170,NULL,'galeriahostel5','Cocina2','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel5.jpg',19),(171,_binary '','galeriadepa1','Balcon','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa1.jpg',29),(172,NULL,'galeriadepa2','Camas','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa2.jpg',29),(173,NULL,'galeriadepa3','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa3.jpg',29),(174,NULL,'galeriadepa4','Baño','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa4.jpg',29),(175,NULL,'galeriadepa5','Comedor','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa5.jpg',29),(176,_binary '','galeriabed1','Sala','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed1.jpg',39),(177,NULL,'galeriabed2','Lockers','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed2.jpg',39),(178,NULL,'galeriabed3','Patio','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed3.jpg',39),(179,NULL,'galeriabed4','Cama','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed4.jpg',39),(180,NULL,'galeriabed5','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed5.jpg',39),(181,_binary '','galeriahotel1','Pileta','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel1.jpg',10),(182,NULL,'galeriahotel2','Desayuno','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel2.jpg',10),(183,NULL,'galeriahotel3','Area Social','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel3.jpg',10),(184,NULL,'galeriahotel4','Habitaciones de lujo','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel4.jpg',10),(185,NULL,'galeriahotel5','Vinoteca','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel5.jpg',10),(186,_binary '','galeriahostel1','Privacidad','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel1.jpg',20),(187,NULL,'galeriahostel2','Recepcion','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel2.jpg',20),(188,NULL,'galeriahostel3','Coworking','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel3.jpg',20),(189,NULL,'galeriahostel4','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel4.jpg',20),(190,NULL,'galeriahostel5','Cocina2','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel5.jpg',20),(191,_binary '','galeriadepa1','Balcon','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa1.jpg',30),(192,NULL,'galeriadepa2','Camas','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa2.jpg',30),(193,NULL,'galeriadepa3','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa3.jpg',30),(194,NULL,'galeriadepa4','Baño','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa4.jpg',30),(195,NULL,'galeriadepa5','Comedor','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa5.jpg',30),(196,_binary '','galeriabed1','Sala','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed1.jpg',40),(197,NULL,'galeriabed2','Lockers','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed2.jpg',40),(198,NULL,'galeriabed3','Patio','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed3.jpg',40),(199,NULL,'galeriabed4','Cama','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed4.jpg',40),(200,NULL,'galeriabed5','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed5.jpg',40);
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image_sequence`
--

DROP TABLE IF EXISTS `image_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image_sequence`
--

LOCK TABLES `image_sequence` WRITE;
/*!40000 ALTER TABLE `image_sequence` DISABLE KEYS */;
INSERT INTO `image_sequence` VALUES (201);
/*!40000 ALTER TABLE `image_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `policy`
--

DROP TABLE IF EXISTS `policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `policy` (
  `id` bigint NOT NULL,
  `description` longtext,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy`
--

LOCK TABLES `policy` WRITE;
/*!40000 ALTER TABLE `policy` DISABLE KEYS */;
INSERT INTO `policy` VALUES (1,'Check-out: 10:00','Normas de la casa'),(2,'No se permiten fiestas','Normas de la casa'),(3,'No fumar','Normas de la casa'),(4,'Check-out: 10:00','Salud y seguridad'),(5,'Detector de humo','Salud y seguridad'),(6,'Deposito de seguridad','Normas de la casa'),(7,'Agregá las fechas de tu viaje para obtener los detalles de tu cancelacion de esta estadia','Politica de cancelacion');
/*!40000 ALTER TABLE `policy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `policy_sequence`
--

DROP TABLE IF EXISTS `policy_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `policy_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy_sequence`
--

LOCK TABLES `policy_sequence` WRITE;
/*!40000 ALTER TABLE `policy_sequence` DISABLE KEYS */;
INSERT INTO `policy_sequence` VALUES (8);
/*!40000 ALTER TABLE `policy_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL,
  `availability` bit(1) DEFAULT NULL,
  `description` longtext,
  `name` varchar(255) DEFAULT NULL,
  `stars` int DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `city_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  KEY `FKh788ivjgngf4jvk4e5h4u8dkm` (`city_id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKh788ivjgngf4jvk4e5h4u8dkm` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,_binary '','Four Season Buenos Aires es una magnífica elección para los viajeros que visiten Buenos Aires, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Buenos Aires, Four Season Buenos Aires es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el hotel incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Four Season Buenos Aires. Además, ofrece restaurante, lo que hará tu viaje a Buenos Aires incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Four Season Buenos Aires',5,1,1),(2,_binary '','Four Season Chaco es una magnífica elección para los viajeros que visiten Chaco, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Chaco, Four Season Chaco es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el hotel incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Four Season Chaco. Además, ofrece restaurante, lo que hará tu viaje a Chaco incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Four Season Chaco',5,1,2),(3,_binary '','Four Season Formosa es una magnífica elección para los viajeros que visiten Formosa, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Formosa, Four Season Formosa es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el hotel incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Four Season Formosa. Además, ofrece restaurante, lo que hará tu viaje a Formosa incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Four Season Formosa',5,1,3),(4,_binary '','Four Season Cordoba es una magnífica elección para los viajeros que visiten Cordoba, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Cordoba, Four Season Cordoba es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el hotel incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Four Season Cordoba. Además, ofrece restaurante, lo que hará tu viaje a Cordoba incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Four Season Cordoba',5,1,4),(5,_binary '','Four Season San Luis es una magnífica elección para los viajeros que visiten San Luis, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de San Luis, Four Season San Luis es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el hotel incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Four Season San Luis. Además, ofrece restaurante, lo que hará tu viaje a San Luis incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Four Season San Luis',5,1,5),(6,_binary '','Four Season Barranquilla es una magnífica elección para los viajeros que visiten Barranquilla, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Barranquilla, Four Season Barranquilla es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el hotel incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Four Season Barranquilla. Además, ofrece restaurante, lo que hará tu viaje a Barranquilla incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Four Season Barranquilla',5,1,6),(7,_binary '','Four Season Bogota es una magnífica elección para los viajeros que visiten Bogota, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Bogota, Four Season Bogota es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el hotel incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Four Season Bogota. Además, ofrece restaurante, lo que hará tu viaje a Bogota incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Four Season Bogota',5,1,7),(8,_binary '','Four Season Medellin es una magnífica elección para los viajeros que visiten Medellin, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Medellin, Four Season Medellin es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el hotel incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Four Season Medellin. Además, ofrece restaurante, lo que hará tu viaje a Medellin incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Four Season Medellin',5,1,8),(9,_binary '','Four Season Santa Marta es una magnífica elección para los viajeros que visiten Santa Marta, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Santa Marta, Four Season Santa Marta es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el hotel incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Four Season Santa Marta. Además, ofrece restaurante, lo que hará tu viaje a Santa Marta incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Four Season Santa Marta',5,1,9),(10,_binary '','Four Season San Andrés es una magnífica elección para los viajeros que visiten San Andrés, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de San Andrés, Four Season San Andrés es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el hotel incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Four Season San Andrés. Además, ofrece restaurante, lo que hará tu viaje a San Andrés incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Four Season San Andrés',5,1,10),(11,_binary '','Accor Buenos Aires es una magnífica elección para los viajeros que visiten Buenos Aires, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Buenos Aires, Accor Buenos Aires es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Accor Buenos Aires. Además, ofrece restaurante, lo que hará tu viaje a Buenos Aires incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Accor Buenos Aires',5,2,1),(12,_binary '','Accor Chaco es una magnífica elección para los viajeros que visiten Chaco, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Chaco, Accor Chaco es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Accor Chaco. Además, ofrece restaurante, lo que hará tu viaje a Chaco incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Accor Chaco',5,2,2),(13,_binary '','Accor Formosa es una magnífica elección para los viajeros que visiten Formosa, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Formosa, Accor Formosa es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Accor Formosa. Además, ofrece restaurante, lo que hará tu viaje a Formosa incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Accor Formosa',5,2,3),(14,_binary '','Accor Cordoba es una magnífica elección para los viajeros que visiten Cordoba, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Cordoba, Accor Cordoba es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Accor Cordoba. Además, ofrece restaurante, lo que hará tu viaje a Cordoba incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Accor Cordoba',5,2,4),(15,_binary '','Accor San Luis es una magnífica elección para los viajeros que visiten San Luis, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de San Luis, Accor San Luis es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Accor San Luis. Además, ofrece restaurante, lo que hará tu viaje a San Luis incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Accor San Luis',5,2,5),(16,_binary '','Accor Barranquilla es una magnífica elección para los viajeros que visiten Barranquilla, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Barranquilla, Accor Barranquilla es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Accor Barranquilla. Además, ofrece restaurante, lo que hará tu viaje a Barranquilla incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Accor Barranquilla',5,2,6),(17,_binary '','Accor Bogota es una magnífica elección para los viajeros que visiten Bogota, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Bogota, Accor Bogota es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Accor Bogota. Además, ofrece restaurante, lo que hará tu viaje a Bogota incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Accor Bogota',5,2,7),(18,_binary '','Accor Medellin es una magnífica elección para los viajeros que visiten Medellin, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Medellin, Accor Medellin es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Accor Medellin. Además, ofrece restaurante, lo que hará tu viaje a Medellin incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Accor Medellin',5,2,8),(19,_binary '','Accor Santa Marta es una magnífica elección para los viajeros que visiten Santa Marta, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Santa Marta, Accor Santa Marta es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Accor Santa Marta. Además, ofrece restaurante, lo que hará tu viaje a Santa Marta incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Accor Santa Marta',5,2,9),(20,_binary '','Accor San Andrés es una magnífica elección para los viajeros que visiten San Andrés, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de San Andrés, Accor San Andrés es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Accor San Andrés. Además, ofrece restaurante, lo que hará tu viaje a San Andrés incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Accor San Andrés',5,2,10),(21,_binary '','Departamento Buenos Aires es una magnífica elección para los viajeros que visiten Buenos Aires, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Buenos Aires, Departamento Buenos Aires es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Departamento incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Departamento Buenos Aires. Además, ofrece restaurante, lo que hará tu viaje a Buenos Aires incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Departamento Buenos Aires',5,3,1),(22,_binary '','Departamento Chaco es una magnífica elección para los viajeros que visiten Chaco, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Chaco, Departamento Chaco es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Departamento incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Departamento Chaco. Además, ofrece restaurante, lo que hará tu viaje a Chaco incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Departamento Chaco',5,3,2),(23,_binary '','Departamento Formosa es una magnífica elección para los viajeros que visiten Formosa, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Formosa, Departamento Formosa es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Departamento incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Departamento Formosa. Además, ofrece restaurante, lo que hará tu viaje a Formosa incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Departamento Formosa',5,3,3),(24,_binary '','Departamento Cordoba es una magnífica elección para los viajeros que visiten Cordoba, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Cordoba, Departamento Cordoba es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Departamento incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Departamento Cordoba. Además, ofrece restaurante, lo que hará tu viaje a Cordoba incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Departamento Cordoba',5,3,4),(25,_binary '','Departamento San Luis es una magnífica elección para los viajeros que visiten San Luis, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de San Luis, Departamento San Luis es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Departamento incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Departamento San Luis. Además, ofrece restaurante, lo que hará tu viaje a San Luis incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Departamento San Luis',5,3,5),(26,_binary '','Departamento Barranquilla es una magnífica elección para los viajeros que visiten Barranquilla, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Barranquilla, Departamento Barranquilla es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Departamento incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Departamento Barranquilla. Además, ofrece restaurante, lo que hará tu viaje a Barranquilla incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Departamento Barranquilla',5,3,6),(27,_binary '','Departamento Bogota es una magnífica elección para los viajeros que visiten Bogota, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Bogota, Departamento Bogota es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Departamento incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Departamento Bogota. Además, ofrece restaurante, lo que hará tu viaje a Bogota incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Departamento Bogota',5,3,7),(28,_binary '','Departamento Medellin es una magnífica elección para los viajeros que visiten Medellin, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Medellin, Departamento Medellin es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Departamento incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Departamento Medellin. Además, ofrece restaurante, lo que hará tu viaje a Medellin incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Departamento Medellin',5,3,8),(29,_binary '','Departamento Santa Marta es una magnífica elección para los viajeros que visiten Santa Marta, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Santa Marta, Departamento Santa Marta es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Departamento incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Departamento Santa Marta. Además, ofrece restaurante, lo que hará tu viaje a Santa Marta incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Departamento Santa Marta',5,3,9),(30,_binary '','Departamento San Andrés es una magnífica elección para los viajeros que visiten San Andrés, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de San Andrés, Departamento San Andrés es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Departamento incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Departamento San Andrés. Además, ofrece restaurante, lo que hará tu viaje a San Andrés incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Departamento San Andrés',5,3,10),(31,_binary '','Relux Buenos Aires es una magnífica elección para los viajeros que visiten Buenos Aires, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Buenos Aires, Relux Buenos Aires es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Relux incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Relux Buenos Aires. Además, ofrece restaurante, lo que hará tu viaje a Buenos Aires incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Relux Buenos Aires',5,4,1),(32,_binary '','Relux Chaco es una magnífica elección para los viajeros que visiten Chaco, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Chaco, Relux Chaco es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Relux incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Relux Chaco. Además, ofrece restaurante, lo que hará tu viaje a Chaco incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Relux Chaco',5,4,2),(33,_binary '','Relux Formosa es una magnífica elección para los viajeros que visiten Formosa, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Formosa, Relux Formosa es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Relux incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Relux Formosa. Además, ofrece restaurante, lo que hará tu viaje a Formosa incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Relux Formosa',5,4,3),(34,_binary '','Relux Cordoba es una magnífica elección para los viajeros que visiten Cordoba, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Cordoba, Relux Cordoba es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Relux incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Relux Cordoba. Además, ofrece restaurante, lo que hará tu viaje a Cordoba incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Relux Cordoba',5,4,4),(35,_binary '','Relux San Luis es una magnífica elección para los viajeros que visiten San Luis, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de San Luis, Relux San Luis es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Relux incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Relux San Luis. Además, ofrece restaurante, lo que hará tu viaje a San Luis incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Relux San Luis',5,4,5),(36,_binary '','Relux Barranquilla es una magnífica elección para los viajeros que visiten Barranquilla, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Barranquilla, Relux Barranquilla es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Relux incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Relux Barranquilla. Además, ofrece restaurante, lo que hará tu viaje a Barranquilla incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Relux Barranquilla',5,4,6),(37,_binary '','Relux Bogota es una magnífica elección para los viajeros que visiten Bogota, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Bogota, Relux Bogota es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Relux incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Relux Bogota. Además, ofrece restaurante, lo que hará tu viaje a Bogota incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Relux Bogota',5,4,7),(38,_binary '','Relux Medellin es una magnífica elección para los viajeros que visiten Medellin, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Medellin, Relux Medellin es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Relux incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Relux Medellin. Además, ofrece restaurante, lo que hará tu viaje a Medellin incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Relux Medellin',5,4,8),(39,_binary '','Relux Santa Marta es una magnífica elección para los viajeros que visiten Santa Marta, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de Santa Marta, Relux Santa Marta es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Relux incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Relux Santa Marta. Además, ofrece restaurante, lo que hará tu viaje a Santa Marta incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Relux Santa Marta',5,4,9),(40,_binary '','Relux San Andrés es una magnífica elección para los viajeros que visiten San Andrés, ya que ofrece un ambiente para familias, además de numerosos servicios diseñados para mejorar tu estancia.\n Como está cerca de la mayoría de los puntos de referencia de San Andrés, Relux San Andrés es un fantástico destino para turistas.\n Para que te sientas como en casa, las habitaciones en el Relux incluyen televisor de pantalla plana y aire acondicionado, y mantenerte conectado es fácil, ya que hay wifi gratuito disponible.\n Los huéspedes tienen acceso a recepción abierta 24 horas durante su estancia en Relux San Andrés. Además, ofrece restaurante, lo que hará tu viaje a San Andrés incluso más gratificante. Y otra ventaja es que hay aparcamiento disponible para los huéspedes.','Relux San Andrés',5,4,10);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_features`
--

DROP TABLE IF EXISTS `product_features`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_features` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_id` bigint NOT NULL,
  `feature_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKej5v6d4jh9c4y057og26vfadt` (`feature_id`),
  CONSTRAINT `FKej5v6d4jh9c4y057og26vfadt` FOREIGN KEY (`feature_id`) REFERENCES `feature` (`id`),
  CONSTRAINT `FKimprh85dmgtkfb97m9g45rmou` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_features`
--

LOCK TABLES `product_features` WRITE;
/*!40000 ALTER TABLE `product_features` DISABLE KEYS */;
INSERT INTO `product_features` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1),(13,1),(14,1),(15,1),(16,1),(17,1),(18,1),(19,1),(20,1),(21,1),(22,1),(23,1),(24,1),(25,1),(26,1),(27,1),(28,1),(29,1),(30,1),(31,1),(32,1),(33,1),(34,1),(35,1),(36,1),(37,1),(38,1),(39,1),(40,1),(1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(20,2),(21,2),(22,2),(23,2),(24,2),(25,2),(26,2),(27,2),(28,2),(29,2),(30,2),(31,2),(32,2),(33,2),(34,2),(35,2),(36,2),(37,2),(38,2),(39,2),(40,2),(1,3),(2,3),(3,3),(4,3),(5,3),(6,3),(7,3),(8,3),(9,3),(10,3),(11,3),(12,3),(13,3),(14,3),(15,3),(16,3),(17,3),(18,3),(19,3),(20,3),(21,3),(22,3),(23,3),(24,3),(25,3),(26,3),(27,3),(28,3),(29,3),(30,3),(31,3),(32,3),(33,3),(34,3),(35,3),(36,3),(37,3),(38,3),(39,3),(40,3),(1,4),(2,4),(3,4),(4,4),(5,4),(6,4),(7,4),(8,4),(9,4),(10,4),(11,4),(12,4),(13,4),(14,4),(15,4),(16,4),(17,4),(18,4),(19,4),(20,4),(21,4),(22,4),(23,4),(24,4),(25,4),(26,4),(27,4),(28,4),(29,4),(30,4),(31,4),(32,4),(33,4),(34,4),(35,4),(36,4),(37,4),(38,4),(39,4),(40,4),(1,5),(2,5),(3,5),(4,5),(5,5),(6,5),(7,5),(8,5),(9,5),(10,5),(11,5),(12,5),(13,5),(14,5),(15,5),(16,5),(17,5),(18,5),(19,5),(20,5),(21,5),(22,5),(23,5),(24,5),(25,5),(26,5),(27,5),(28,5),(29,5),(30,5),(31,5),(32,5),(33,5),(34,5),(35,5),(36,5),(37,5),(38,5),(39,5),(40,5),(1,6),(2,6),(3,6),(4,6),(5,6),(6,6),(7,6),(8,6),(9,6),(10,6),(11,6),(12,6),(13,6),(14,6),(15,6),(16,6),(17,6),(18,6),(19,6),(20,6),(21,6),(22,6),(23,6),(24,6),(25,6),(26,6),(27,6),(28,6),(29,6),(30,6),(31,6),(32,6),(33,6),(34,6),(35,6),(36,6),(37,6),(38,6),(39,6),(40,6),(1,7),(2,7),(3,7),(4,7),(5,7),(6,7),(7,7),(8,7),(9,7),(10,7),(11,7),(12,7),(13,7),(14,7),(15,7),(16,7),(17,7),(18,7),(19,7),(20,7),(21,7),(22,7),(23,7),(24,7),(25,7),(26,7),(27,7),(28,7),(29,7),(30,7),(31,7),(32,7),(33,7),(34,7),(35,7),(36,7),(37,7),(38,7),(39,7),(40,7);
/*!40000 ALTER TABLE `product_features` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_policies`
--

DROP TABLE IF EXISTS `product_policies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_policies` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_id` bigint NOT NULL,
  `policy_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmcmmh0rig5hy5k2y9km0xtxf` (`policy_id`),
  CONSTRAINT `FKh8vdkj2k96xyo8lqdi2lmmonw` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKmcmmh0rig5hy5k2y9km0xtxf` FOREIGN KEY (`policy_id`) REFERENCES `policy` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_policies`
--

LOCK TABLES `product_policies` WRITE;
/*!40000 ALTER TABLE `product_policies` DISABLE KEYS */;
INSERT INTO `product_policies` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1),(13,1),(14,1),(15,1),(16,1),(17,1),(18,1),(19,1),(20,1),(21,1),(22,1),(23,1),(24,1),(25,1),(26,1),(27,1),(28,1),(29,1),(30,1),(31,1),(32,1),(33,1),(34,1),(35,1),(36,1),(37,1),(38,1),(39,1),(40,1),(1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(20,2),(21,2),(22,2),(23,2),(24,2),(25,2),(26,2),(27,2),(28,2),(29,2),(30,2),(31,2),(32,2),(33,2),(34,2),(35,2),(36,2),(37,2),(38,2),(39,2),(40,2),(1,3),(2,3),(3,3),(4,3),(5,3),(6,3),(7,3),(8,3),(9,3),(10,3),(11,3),(12,3),(13,3),(14,3),(15,3),(16,3),(17,3),(18,3),(19,3),(20,3),(21,3),(22,3),(23,3),(24,3),(25,3),(26,3),(27,3),(28,3),(29,3),(30,3),(31,3),(32,3),(33,3),(34,3),(35,3),(36,3),(37,3),(38,3),(39,3),(40,3),(1,4),(2,4),(3,4),(4,4),(5,4),(6,4),(7,4),(8,4),(9,4),(10,4),(11,4),(12,4),(13,4),(14,4),(15,4),(16,4),(17,4),(18,4),(19,4),(20,4),(21,4),(22,4),(23,4),(24,4),(25,4),(26,4),(27,4),(28,4),(29,4),(30,4),(31,4),(32,4),(33,4),(34,4),(35,4),(36,4),(37,4),(38,4),(39,4),(40,4),(1,5),(2,5),(3,5),(4,5),(5,5),(6,5),(7,5),(8,5),(9,5),(10,5),(11,5),(12,5),(13,5),(14,5),(15,5),(16,5),(17,5),(18,5),(19,5),(20,5),(21,5),(22,5),(23,5),(24,5),(25,5),(26,5),(27,5),(28,5),(29,5),(30,5),(31,5),(32,5),(33,5),(34,5),(35,5),(36,5),(37,5),(38,5),(39,5),(40,5),(1,6),(2,6),(3,6),(4,6),(5,6),(6,6),(7,6),(8,6),(9,6),(10,6),(11,6),(12,6),(13,6),(14,6),(15,6),(16,6),(17,6),(18,6),(19,6),(20,6),(21,6),(22,6),(23,6),(24,6),(25,6),(26,6),(27,6),(28,6),(29,6),(30,6),(31,6),(32,6),(33,6),(34,6),(35,6),(36,6),(37,6),(38,6),(39,6),(40,6),(1,7),(2,7),(3,7),(4,7),(5,7),(6,7),(7,7),(8,7),(9,7),(10,7),(11,7),(12,7),(13,7),(14,7),(15,7),(16,7),(17,7),(18,7),(19,7),(20,7),(21,7),(22,7),(23,7),(24,7),(25,7),(26,7),(27,7),(28,7),(29,7),(30,7),(31,7),(32,7),(33,7),(34,7),(35,7),(36,7),(37,7),(38,7),(39,7),(40,7);
/*!40000 ALTER TABLE `product_policies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_sequence`
--

DROP TABLE IF EXISTS `product_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_sequence`
--

LOCK TABLES `product_sequence` WRITE;
/*!40000 ALTER TABLE `product_sequence` DISABLE KEYS */;
INSERT INTO `product_sequence` VALUES (41);
/*!40000 ALTER TABLE `product_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rating` (
  `id` bigint NOT NULL,
  `score` int DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlkuwie0au2dru36asng9nywmh` (`product_id`),
  CONSTRAINT `FKlkuwie0au2dru36asng9nywmh` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (1,5,1),(2,5,1),(3,3,1),(4,3,1),(5,5,11),(6,5,11),(7,3,11),(8,3,11),(9,5,21),(10,5,21),(11,3,21),(12,3,21),(13,5,31),(14,5,31),(15,3,31),(16,3,31),(17,5,2),(18,5,2),(19,3,2),(20,3,2),(21,5,12),(22,5,12),(23,3,12),(24,3,12),(25,5,22),(26,5,22),(27,3,22),(28,3,22),(29,5,32),(30,5,32),(31,3,32),(32,3,32),(33,5,3),(34,5,3),(35,3,3),(36,3,3),(37,5,13),(38,5,13),(39,3,13),(40,3,13),(41,5,23),(42,5,23),(43,3,23),(44,3,23),(45,5,33),(46,5,33),(47,3,33),(48,3,33),(49,5,4),(50,5,4),(51,3,4),(52,3,4),(53,5,14),(54,5,14),(55,3,14),(56,3,14),(57,5,24),(58,5,24),(59,3,24),(60,3,24),(61,5,34),(62,5,34),(63,3,34),(64,3,34),(65,5,5),(66,5,5),(67,3,5),(68,3,5),(69,5,15),(70,5,15),(71,3,15),(72,3,15),(73,5,25),(74,5,25),(75,3,25),(76,3,25),(77,5,35),(78,5,35),(79,3,35),(80,3,35),(81,5,6),(82,5,6),(83,3,6),(84,3,6),(85,5,16),(86,5,16),(87,3,16),(88,3,16),(89,5,26),(90,5,26),(91,3,26),(92,3,26),(93,5,36),(94,5,36),(95,3,36),(96,3,36),(97,5,7),(98,5,7),(99,3,7),(100,3,7),(101,5,17),(102,5,17),(103,3,17),(104,3,17),(105,5,27),(106,5,27),(107,3,27),(108,3,27),(109,5,37),(110,5,37),(111,3,37),(112,3,37),(113,5,8),(114,5,8),(115,3,8),(116,3,8),(117,5,18),(118,5,18),(119,3,18),(120,3,18),(121,5,28),(122,5,28),(123,3,28),(124,3,28),(125,5,38),(126,5,38),(127,3,38),(128,3,38),(129,5,9),(130,5,9),(131,3,9),(132,3,9),(133,5,19),(134,5,19),(135,3,19),(136,3,19),(137,5,29),(138,5,29),(139,3,29),(140,3,29),(141,5,39),(142,5,39),(143,3,39),(144,3,39),(145,5,10),(146,5,10),(147,3,10),(148,3,10),(149,5,20),(150,5,20),(151,3,20),(152,3,20),(153,5,30),(154,5,30),(155,3,30),(156,3,30),(157,5,40),(158,5,40),(159,3,40),(160,3,40);
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating_sequence`
--

DROP TABLE IF EXISTS `rating_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rating_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating_sequence`
--

LOCK TABLES `rating_sequence` WRITE;
/*!40000 ALTER TABLE `rating_sequence` DISABLE KEYS */;
INSERT INTO `rating_sequence` VALUES (161);
/*!40000 ALTER TABLE `rating_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol_sequence`
--

DROP TABLE IF EXISTS `rol_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_sequence`
--

LOCK TABLES `rol_sequence` WRITE;
/*!40000 ALTER TABLE `rol_sequence` DISABLE KEYS */;
INSERT INTO `rol_sequence` VALUES (1);
/*!40000 ALTER TABLE `rol_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `id_rol` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  KEY `FK4si04gx6t56ut6wjy7k114mbk` (`id_rol`),
  CONSTRAINT `FK4si04gx6t56ut6wjy7k114mbk` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_sequence`
--

DROP TABLE IF EXISTS `user_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_sequence`
--

LOCK TABLES `user_sequence` WRITE;
/*!40000 ALTER TABLE `user_sequence` DISABLE KEYS */;
INSERT INTO `user_sequence` VALUES (1);
/*!40000 ALTER TABLE `user_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'BookingDB'
--

--
-- Dumping routines for database 'BookingDB'
--
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-08  9:07:10
