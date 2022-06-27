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
-- SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

-- SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `id` bigint NOT NULL,
  `additional_information` longtext,
  `arrival` date DEFAULT NULL,
  `covid_vaccine` bit(1) DEFAULT NULL,
  `departure` date DEFAULT NULL,
  `reservation_time` varchar(255) DEFAULT NULL,
  `product_id` bigint NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsh4nrvwbhl3okuio2be7wxm3a` (`product_id`),
  KEY `FKkgseyy7t56x7lkjgu3wah5s3t` (`user_id`),
  CONSTRAINT `FKkgseyy7t56x7lkjgu3wah5s3t` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKsh4nrvwbhl3okuio2be7wxm3a` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,NULL,'2022-08-12',NULL,'2022-08-14','14:00',1,1),(2,NULL,'2022-08-22',NULL,'2022-08-28','17:00',1,2),(3,NULL,'2022-08-29',NULL,'2022-08-30','19:00',1,3),(4,NULL,'2022-08-02',NULL,'2022-08-09','14:00',2,4),(5,NULL,'2022-09-12',NULL,'2022-09-15','15:00',2,5),(6,NULL,'2022-09-29',NULL,'2022-09-30','19:00',2,1),(7,NULL,'2022-07-29',NULL,'2022-08-04','18:00',3,2),(8,NULL,'2022-08-12',NULL,'2022-08-14','20:00',3,3),(9,NULL,'2022-08-26',NULL,'2022-09-01','15:00',3,4);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_sequence`
--

DROP TABLE IF EXISTS `booking_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_sequence`
--

LOCK TABLES `booking_sequence` WRITE;
/*!40000 ALTER TABLE `booking_sequence` DISABLE KEYS */;
INSERT INTO `booking_sequence` VALUES (10);
/*!40000 ALTER TABLE `booking_sequence` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `category` VALUES (1,'Un hotel es un edificio planificado y acondicionado para otorgar servicios de alojamiento a las personas. Los hoteles proveen a los huéspedes de servicios adicionales como restaurantes, piscinas y guarderías.','Imagen interior de Hotel','Hotel','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/hotel.jpg'),(2,'Un albergue o hostel es una forma de alojamiento sociable compartido a corto plazo y de bajo costo donde los huéspedes pueden alquilar una cama, generalmente una litera en un dormitorio, con uso compartido de un salón y, a veces, una cocina.','Imagen interior de Hostel','Hostel','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/hostel.jpg'),(3,'Un apartamento es una unidad de vivienda que comprende una o más habitaciones diseñadas para proporcionar instalaciones completas para un individuo o una pequeña familia.','Imagen interior de Departamento','Departamento','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/departamento.jpg'),(4,'El Bed and Breakfast, es un establecimiento hotelero que ofrece precios moderados. La expresión inglesa, se traduce como \'cama y desayuno\'','Imagen interior de Bed and Breakfast','Bed and breakfast','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/bedandbreakfast.jpg');
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
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `province_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKll21eddgtrjc9f40ueeouyr8f` (`province_id`),
  CONSTRAINT `FKll21eddgtrjc9f40ueeouyr8f` FOREIGN KEY (`province_id`) REFERENCES `province` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,-38.716244508192126,-62.26524449983167,'Bahía Blanca',1),(2,-37.26015787261739,-56.9713360221457,'Villa Gesell',1),(3,-32.94919864502203,-60.64342695372633,'Rosario',2),(4,-31.63525782524705,-60.70270000984399,'Santa Fe',2),(5,-33.12304669004345,-64.34912011453486,'Río Cuarto',3),(6,-32.05799337143068,-64.54816517814119,'Santa Rosa de Calamuchita',3),(7,-26.832724441173,-65.2174963397207,'San Miguel de Tucumán',4),(8,-26.851622542856273,-65.7102972237858,'Tafí del Valle',4),(9,-41.134496062067534,-71.31141431695279,'San Carlos de Bariloche',5),(10,-40.79801571533473,-65.07947537115643,'Las Grutas',5);
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
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Argentina');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country_sequence`
--

DROP TABLE IF EXISTS `country_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country_sequence`
--

LOCK TABLES `country_sequence` WRITE;
/*!40000 ALTER TABLE `country_sequence` DISABLE KEYS */;
INSERT INTO `country_sequence` VALUES (2);
/*!40000 ALTER TABLE `country_sequence` ENABLE KEYS */;
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
  `product_id` bigint NOT NULL,
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
INSERT INTO `image` VALUES (1,_binary '','galeriahotel1','Pileta','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel1.jpg',1),(2,NULL,'galeriahotel2','Desayuno','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel2.jpg',1),(3,NULL,'galeriahotel3','Area Social','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel3.jpg',1),(4,NULL,'galeriahotel4','Habitaciones de lujo','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel4.jpg',1),(5,NULL,'galeriahotel5','Vinoteca','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel5.jpg',1),(6,NULL,'galeriahotel1','Pileta','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel1.jpg',2),(7,_binary '','galeriahotel2','Desayuno','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel2.jpg',2),(8,NULL,'galeriahotel3','Area Social','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel3.jpg',2),(9,NULL,'galeriahotel4','Habitaciones de lujo','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel4.jpg',2),(10,NULL,'galeriahotel5','Vinoteca','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel5.jpg',2),(11,NULL,'galeriahotel1','Pileta','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel1.jpg',3),(12,NULL,'galeriahotel2','Desayuno','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel2.jpg',3),(13,_binary '','galeriahotel3','Area Social','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel3.jpg',3),(14,NULL,'galeriahotel4','Habitaciones de lujo','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel4.jpg',3),(15,NULL,'galeriahotel5','Vinoteca','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel5.jpg',3),(16,NULL,'galeriahotel1','Pileta','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel1.jpg',4),(17,NULL,'galeriahotel2','Desayuno','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel2.jpg',4),(18,NULL,'galeriahotel3','Area Social','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel3.jpg',4),(19,_binary '','galeriahotel4','Habitaciones de lujo','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel4.jpg',4),(20,NULL,'galeriahotel5','Vinoteca','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel5.jpg',4),(21,NULL,'galeriahotel1','Pileta','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel1.jpg',5),(22,NULL,'galeriahotel2','Desayuno','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel2.jpg',5),(23,NULL,'galeriahotel3','Area Social','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel3.jpg',5),(24,NULL,'galeriahotel4','Habitaciones de lujo','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel4.jpg',5),(25,_binary '','galeriahotel5','Vinoteca','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel5.jpg',5),(26,_binary '','galeriahotel1','Pileta','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel1.jpg',6),(27,NULL,'galeriahotel2','Desayuno','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel2.jpg',6),(28,NULL,'galeriahotel3','Area Social','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel3.jpg',6),(29,NULL,'galeriahotel4','Habitaciones de lujo','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel4.jpg',6),(30,NULL,'galeriahotel5','Vinoteca','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hotel/galeriahotel5.jpg',6),(31,_binary '','galeriahostel1','Privacidad','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel1.jpg',7),(32,NULL,'galeriahostel2','Recepcion','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel2.jpg',7),(33,NULL,'galeriahostel3','Coworking','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel3.jpg',7),(34,NULL,'galeriahostel4','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel4.jpg',7),(35,NULL,'galeriahostel5','Cocina2','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel5.jpg',7),(36,NULL,'galeriahostel1','Privacidad','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel1.jpg',8),(37,_binary '','galeriahostel2','Recepcion','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel2.jpg',8),(38,NULL,'galeriahostel3','Coworking','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel3.jpg',8),(39,NULL,'galeriahostel4','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel4.jpg',8),(40,NULL,'galeriahostel5','Cocina2','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel5.jpg',8),(41,_binary '','galeriahostel1','Privacidad','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel1.jpg',9),(42,NULL,'galeriahostel2','Recepcion','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel2.jpg',9),(43,_binary '','galeriahostel3','Coworking','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel3.jpg',9),(44,NULL,'galeriahostel4','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel4.jpg',9),(45,NULL,'galeriahostel5','Cocina2','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel5.jpg',9),(46,_binary '','galeriahostel1','Privacidad','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel1.jpg',10),(47,NULL,'galeriahostel2','Recepcion','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel2.jpg',10),(48,NULL,'galeriahostel3','Coworking','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel3.jpg',10),(49,_binary '','galeriahostel4','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel4.jpg',10),(50,NULL,'galeriahostel5','Cocina2','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/hostel/galeriahostel5.jpg',10),(51,_binary '','galeriadepa1','Balcon','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa1.jpg',11),(52,NULL,'galeriadepa2','Camas','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa2.jpg',11),(53,NULL,'galeriadepa3','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa3.jpg',11),(54,NULL,'galeriadepa4','Baño','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa4.jpg',11),(55,NULL,'galeriadepa5','Comedor','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa5.jpg',11),(56,NULL,'galeriadepa1','Balcon','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa1.jpg',12),(57,_binary '','galeriadepa2','Camas','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa2.jpg',12),(58,NULL,'galeriadepa3','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa3.jpg',12),(59,NULL,'galeriadepa4','Baño','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa4.jpg',12),(60,NULL,'galeriadepa5','Comedor','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa5.jpg',12),(61,NULL,'galeriadepa1','Balcon','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa1.jpg',13),(62,NULL,'galeriadepa2','Camas','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa2.jpg',13),(63,_binary '','galeriadepa3','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa3.jpg',13),(64,NULL,'galeriadepa4','Baño','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa4.jpg',13),(65,NULL,'galeriadepa5','Comedor','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa5.jpg',13),(66,NULL,'galeriadepa1','Balcon','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa1.jpg',14),(67,NULL,'galeriadepa2','Camas','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa2.jpg',14),(68,NULL,'galeriadepa3','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa3.jpg',14),(69,_binary '','galeriadepa4','Baño','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa4.jpg',14),(70,NULL,'galeriadepa5','Comedor','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa5.jpg',14),(71,NULL,'galeriadepa1','Balcon','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa1.jpg',15),(72,NULL,'galeriadepa2','Camas','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa2.jpg',15),(73,NULL,'galeriadepa3','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa3.jpg',15),(74,NULL,'galeriadepa4','Baño','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa4.jpg',15),(75,_binary '','galeriadepa5','Comedor','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa5.jpg',15),(76,_binary '','galeriadepa1','Balcon','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa1.jpg',16),(77,NULL,'galeriadepa2','Camas','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa2.jpg',16),(78,NULL,'galeriadepa3','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa3.jpg',16),(79,NULL,'galeriadepa4','Baño','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa4.jpg',16),(80,NULL,'galeriadepa5','Comedor','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/departamento/galeriadepa5.jpg',16),(81,_binary '','galeriabed1','Sala','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed1.jpg',17),(82,NULL,'galeriabed2','Lockers','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed2.jpg',17),(83,NULL,'galeriabed3','Patio','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed3.jpg',17),(84,NULL,'galeriabed4','Cama','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed4.jpg',17),(85,NULL,'galeriabed5','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed5.jpg',17),(86,NULL,'galeriabed1','Sala','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed1.jpg',18),(87,_binary '','galeriabed2','Lockers','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed2.jpg',18),(88,NULL,'galeriabed3','Patio','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed3.jpg',18),(89,NULL,'galeriabed4','Cama','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed4.jpg',18),(90,NULL,'galeriabed5','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed5.jpg',18),(91,NULL,'galeriabed1','Sala','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed1.jpg',19),(92,NULL,'galeriabed2','Lockers','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed2.jpg',19),(93,_binary '','galeriabed3','Patio','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed3.jpg',19),(94,NULL,'galeriabed4','Cama','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed4.jpg',19),(95,NULL,'galeriabed5','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed5.jpg',19),(96,NULL,'galeriabed1','Sala','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed1.jpg',20),(97,NULL,'galeriabed2','Lockers','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed2.jpg',20),(98,NULL,'galeriabed3','Patio','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed3.jpg',20),(99,_binary '','galeriabed4','Cama','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed4.jpg',20),(100,NULL,'galeriabed5','Cocina','https://buckets3-grupo08.s3.us-west-1.amazonaws.com/bedandbreakfast/galeriabed5.jpg',20);
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
INSERT INTO `image_sequence` VALUES (101);
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
  `check_in_max` varchar(255) NOT NULL,
  `check_in_min` varchar(255) NOT NULL,
  `description` longtext,
  `direction` varchar(255) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `name` varchar(255) NOT NULL,
  `stars` int DEFAULT NULL,
  `title_description` varchar(255) DEFAULT NULL,
  `category_id` bigint NOT NULL,
  `city_id` bigint NOT NULL,
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
INSERT INTO `product` VALUES (1,'23:00','10:00','Este alojamiento está a 2 minutos a pie de la playa. El Fonte Arcada ofrece una piscina al aire libre/cubierta e instalaciones de spa en el centro de Villa Gesell, a solo 100 metros de la playa. Hay WiFi gratis. Las habitaciones del Arcada cuentan con TV por cable, aire acondicionado y minibar. El baño privado incluye ducha, bañera y secador de pelo. Se ofrece una piscina. El Fonte Arcada cuenta con recepción 24 horas y consigna de equipaje. El establecimiento ofrece aparcamiento gratuito y se encuentra a 2 km de la estación de autobuses de Villa Gesell. Nuestros clientes dicen que esta parte de Villa Gesell es su favorita, según los comentarios independientes.','Av 1 entre Paseo 108 y 109',-37.261919678039064,-56.96991330339291,'Fonte Arcada',4,'Situado en la zona mejor valorada de Villa Gesell',1,2),(2,'21:00','11:00','El Puerto Amarras Hotel & Suites, situado en el interior del puerto, ofrece restaurante, spa, gimnasio, piscina en Santa Fe, conexión Wi-Fi gratuita y desayuno. Las suites del Puerto Amarras ofrecen un ambiente tranquilo y cuentan con TV de pantalla plana por cable, minibar y vistas al río. Además, el Puerto Amarras Hotel & Suites ofrece aparcamiento privado por un suplemento y dispone de sauna y pista de tenis. El Puerto Amarras Hotel & Suites se encuentra a 600 metros del centro comercial, a 1 km de la estación de autobuses, a 1,5 km del centro de la ciudad y a 40 minutos en coche de Paraná.','1º de Enero 27 - Dique II',-31.652728706728812,-60.699037047359624,'Puerto Amarras Hotel & Suites',3,'Suites en el interior del puerto',1,4),(3,'23:00','09:00','El Hilton Garden Inn Tucuman, situado en San Miguel de Tucumán, a 5 minutos en coche del centro histórico, ofrece habitaciones con una decoración elegante y conexión Wi-Fi gratuita. Este hotel también alberga un spa, una piscina, un gimnasio y un restaurante. Las habitaciones del Hilton Garden Inn Tucuman presentan una decoración elegante y disponen de aire acondicionado, escritorio amplio, sillas ergonómicas y TV con canales de alta definición. Todas las habitaciones son independientes y cuentan con baño privado. Todos los días se sirve un desayuno bufé. El restaurante del hotel propone platos de cocina internacional y el bar ofrece bebidas y aperitivos. El spa del hotel incluye bañera de hidromasaje, sauna y sala de masajes. Si lo prefiere, podrá relajarse en la piscina o en el gimnasio.','Miguel Lillo 365',-26.83268828221646,-65.2224113446539,'Hilton Garden Inn Tucuman',5,'El Hilton Garden Inn Tucuman se encuentra a 10 minutos en coche de la zona residencial',1,7),(4,'23:00','11:00','Este establecimiento ofrece habitaciones con vistas y WiFi gratuita en el centro de Bariloche, a 100 metros de la calle Mitre. Todos los días se sirve el desayuno, que incluye yogur y fruta. Las habitaciones del Hotel Plaza son cómodas y cuentan con TV de pantalla plana y baño privado. También incluyen caja fuerte. Hay servicio de lavandería. El Plaza Hotel se encuentra a 20 km de la estación de esquí Catedral y tiene mostrador de información turística. La recepción está abierta las 24 horas. El aeropuerto internacional Luis Candelaria está a 15 km. Nuestros clientes dicen que esta parte de San Carlos de Bariloche es su favorita, según los comentarios independientes.','Vicealmirante O´Connor 431',-41.13303126544593,-71.30337341788174,'Hotel Plaza Bariloche',2,'Habitaciones con vistas',1,9),(5,'23:00','14:00','Este alojamiento está a 2 minutos a pie de la playa. El Complejo Tamariscos se sitúa a solo 50 metros de la playa y ofrece apartamentos independientes y confortables en Las Grutas. El establecimiento cuenta con 2 piscinas exteriores. La conexión WiFi es gratuita. Los apartamentos del Complejo Tamariscos incorporan TV de pantalla plana, aire acondicionado, cocina totalmente equipada, baños completos y salas de estar luminosas. La mayoría de los apartamentos incluye balcón con vistas panorámicas al mar y al jardín. Asimismo, hay un jardín amplio con zona de barbacoa, donde se puede disfrutar de un asado tradicional al aire libre. El establecimiento también dispone de lavadora. Además, el aparcamiento es gratuito.','Aguada Cecilio 560',-40.80354446456498,-65.07468104707267,'Complejo Tamariscos',4,'A 50m de la playa',1,10),(6,'23:00','10:00','El Land Plaza Hotel está situado en Bahía Blanca. Todos los alojamientos de este hotel de 4 estrellas tienen vistas a la ciudad y acceso a un salón compartido y a un jardín. Ofrece recepción 24 horas, servicio de enlace con el aeropuerto, servicio de habitaciones y WiFi gratuita. Las habitaciones disponen de aire acondicionado, escritorio, cafetera, minibar, caja fuerte, TV de pantalla plana y baño privado con bidet. Las habitaciones del Land Plaza Hotel están equipadas con ropa de cama y toallas. Todas las mañanas se sirve un desayuno buffet. El Land Plaza Hotel alberga un solárium. El establecimiento alberga un centro de negocios y un bar. Punta Alta se encuentra a 24 km del hotel, mientras que Médanos está a 37 km. El aeropuerto Comandante Espora es el más cercano y está a 14 km del Land Plaza Hotel.','Saavedra 41',-38.721126586690744,-62.269039131652434,'Land Plaza Hotel',4,'Hotel situado en el corazón de Bahía Blanca',1,1),(7,'23:00','12:00','El Hospedaje La Serranita ofrece alojamiento en Bahía Blanca. Además, hay terraza, WiFi gratuita y aparcamiento privado gratuito. Las habitaciones están equipadas con escritorio, TV de pantalla plana, baño compartido, ropa de cama y toallas. Las habitaciones disponen de armario y hervidor de agua. Los huéspedes del Hospedaje La Serranita podrán disfrutar de actividades en Bahía Blanca y sus alrededores, como ciclismo y pesca. Punta Alta se encuentra a 20 km del alojamiento, mientras que Médanos está a 36 km. El aeropuerto Comandante Espora es el más cercano y está a 14 km del Hospedaje La Serranita. Se proporciona servicio de enlace con el aeropuerto por un suplemento.','José M. Carrega 3434',-38.784773695890145,-62.27052020523869,'Hostel La Serranita',NULL,'Hospedaje con parking privado gratis en el alojamiento',2,1),(8,'21:00','11:00','Este alojamiento está a 6 minutos a pie de la playa. El Hostel Hola Ola se encuentra en Villa Gesell y ofrece alojamiento solo para adultos con salón compartido y jardín. El albergue cuenta con solárium, recepción 24 horas y WiFi gratuita. Las habitaciones del albergue incluyen baño privado con ducha. El Hostel Hola Ola sirve un desayuno continental y buffet todas las mañanas. Las Playas del Centro se encuentran a 650 metros del alojamiento, mientras que las Playas del Norte están a 700 metros. El aeropuerto más cercano es el aeropuerto internacional de Villa Gesell-Pinamar, ubicado a 7 km del Hostel Hola Ola.','Av. 5 474',-37.25364384355991,-56.97094761803347,'Hostel Hola Ola',NULL,'La mejor ubicación',2,2),(9,'22:00','11:00','El Hostel El Refugio de Las Aves se encuentra frente a la playa de Santa Rosa de Calamuchita y cuenta con salón compartido y jardín. Cuenta con recepción 24 horas, cocina compartida y WiFi gratuita en todas las instalaciones. Las habitaciones incluyen armario y baño compartido. En Santa Rosa de Calamuchita y sus alrededores se pueden practicar diversas actividades, como senderismo. Villa General Belgrano se encuentra a 13 km del alojamiento, mientras que Alta Gracia está a 48 km. El aeropuerto más cercano es el aeropuerto internacional Ingeniero Aeronáutico Ambrosio L.V. Taravella, ubicado a 116 km del Hostel El Refugio de Las Aves.','Calle 3 140',-32.07704697974508,-64.5379702875396,'Hostel El Refugio de Las Aves',NULL,'Hostel con vista a la playa',2,6),(10,'23:00','13:00','Los alojamientos incluyen TV de pantalla plana. Algunas habitaciones de LOS MENIRES II tienen balcón. Yerba Buena se encuentra a 41 km del alojamiento, mientras que Famaillá está a 38 km. El aeropuerto más cercano es el aeropuerto internacional Teniente General Benjamín Matienzo, ubicado a 113 km de Los Menires II.','Avenida Belgrano 322',-26.853056571082814,-65.71153378802944,'Los Menires II',NULL,'Hay aparcamiento privado gratuito y WiFi gratuita.',2,8),(11,'23:00','13:00','El Departamento Céntrico ofrece vistas a la ciudad, salón compartido y WiFi gratuita y se encuentra en Rosario, a poca distancia de la ruta modernista, el monumento a la bandera y el centro cultural Roberto Fontanarrosa. Los alojamientos disponen de balcón, aire acondicionado, TV de pantalla plana y baño privado con bidet y secador de pelo. Cerca del apartamento hay varios lugares de interés, como la plaza Montenegro, el centro cultural Bernardino Rivadavia y el teatro municipal La Comedia. El aeropuerto más cercano es el aeropuerto internacional de Rosario-Islas Malvinas, ubicado a 15 km del Departamento Céntrico.','San Juan 1055',-32.9502048053267,-60.638605380422916,'Departamento Céntrico',NULL,'Ubicación céntrica',3,3),(12,'21:00','11:00','El Excelente Departamento a 10 cuadras de Bv ofrece vistas al jardín y alojamiento con patio y hervidor de agua a unos 5 km del estadio Brigadier General Estanislao López. Se encuentra a 1,4 km de la Universidad Nacional del Litoral y ofrece WiFi gratuita y aparcamiento privado. Este apartamento cuenta con aire acondicionado, 2 dormitorios, TV de pantalla plana y cocina con horno. Se proporcionan toallas y ropa de cama. El apartamento tiene terraza. El aeropuerto más cercano es el de Sauce Viejo, ubicado a 14 km del Excelente Departamento a 10 cuadras de Bv.','José Quintana 2600',-31.622298940975973,-60.70076090734721,'Excelente Departamento a 10 cuadras de Bv',NULL,'Departamento a 10 cuadras de Bv',3,4),(13,'23:00','13:00','El Apart FJL se encuentra a 8 km del hipódromo de Río Cuarto y ofrece alojamiento con jardín, casino y recepción 24 horas. Algunos alojamientos incluyen TV de pantalla plana vía satélite, cocina totalmente equipada con microondas y baño privado con bidet y artículos de aseo gratuitos. En los alrededores se puede practicar senderismo y pesca. El apartamento ofrece servicio de alquiler de coches. El aeropuerto más cercano es el de Río Cuarto, ubicado a 15 km del Apart FJL. Se proporciona servicio de enlace con el aeropuerto por un suplemento.','Boulevard Roca 901 Departamento 1 E',-33.12950399251891,-64.34069316367737,'Apart FJL',NULL,'Apart a 8km del hipódromo',3,5),(14,'21:00','12:00','El Tucumán departamento se encuentra en San Miguel de Tucumán, a 2,9 km del CIIDEPT y a menos de 1 km de la plaza Independencia, y ofrece WiFi gratuita y aire acondicionado. El apartamento cuenta con 2 dormitorios, 1 baño, ropa de cama, toallas, TV de pantalla plana vía satélite, zona de comedor, cocina totalmente equipada y balcón con vistas a la ciudad. El establecimiento proporciona toallas y ropa de cama por un suplemento. El estadio monumental José Fierro está a 1,7 km del apartamento. El aeropuerto más cercano es el aeropuerto internacional Teniente General Benjamín Matienzo, ubicado a 11 km del Tucumán departamento. Se proporciona servicio de enlace con el aeropuerto por un suplemento. Nuestros clientes dicen que esta parte de San Miguel de Tucumán es su favorita, según los comentarios independientes.','Muñecas 397',-26.825387625974983,-65.20463388729578,'Tucumán departamento',NULL,'Departamento completo cercano a la plaza Independencia',3,7),(15,'20:00','13:00','El Departamento en el centro de Bariloche bb ofrece aire acondicionado y se encuentra en San Carlos de Bariloche, a menos de 1 km de la playa del Centro y a 2,2 km de la playa del Centenario. Este apartamento ofrece aparcamiento privado gratuito, recepción 24 horas y WiFi gratuita. El apartamento cuenta con 2 dormitorios, 1 baño, ropa de cama, toallas, TV de pantalla plana con canales por cable, zona de comedor, cocina totalmente equipada y patio con vistas al lago. El apartamento ofrece servicio de alquiler de coches. Cerca del Departamento en el centro de hay varios lugares de interés, como el centro cívico, el club Andino Bariloche y el casino Tresor. El aeropuerto más cercano es el de San Carlos de Bariloche, ubicado a 16 km. Se proporciona servicio de enlace con el aeropuerto por un suplemento.','Campichuelo 734',-41.137704521945864,-71.31765154100705,'Departamento en el centro de Bariloche',NULL,'La mejor ubicación',3,9),(16,'23:00','11:00','Todos los alojamientos disponen de aire acondicionado, baño privado, sala de estar, TV de pantalla plana, cocina totalmente equipada y balcón. San Antonio Oeste se encuentra a 16 km del apartamento.','Laguna Tres Picos 145',-40.811192353158404,-65.09798246314475,'Ayenruca I y II',NULL,'El Ayenruca I y II se encuentra en el corazón de Las Grutas',3,10),(17,'23:00','13:00','El Green House.river se encuentra en Rosario y ofrece vistas al jardín, centro de fitness, salón compartido y jardín. Todos los alojamientos están equipados con nevera, horno, hervidor de agua, fogones y cafetera. Algunos alojamientos incluyen TV de pantalla plana por cable, cocina totalmente equipada con microondas y baño privado con bidet y secador de pelo. Este bed and breakfast sirve un desayuno a la carta. En las inmediaciones se puede practicar ciclismo. Cerca del Green House.river hay varios lugares de interés, como las playas de La Florida, La Florida y La Florida Beach Club. El aeropuerto internacional de Rosario-Islas Malvinas es el más cercano y queda a 13 km.','Martín Fierro 438',-32.87666980438991,-60.692282432313874,'Green House.river',NULL,'Hermosa vista al jardín',4,3),(18,'23:00','11:00','El Cecar se encuentra en Río Cuarto, en la provincia de Córdoba, y ofrece balcón y vistas a la ciudad. Este bed and breakfast ofrece WiFi gratuita y se encuentra a 6 km del circuito de Río Cuarto. Este bed and breakfast cuenta con aire acondicionado, TV de pantalla plana, cocina totalmente equipada con microondas y baño con bidet y ducha.','Albedi 1087',-33.12835901251088,-64.34654928693358,'Cecar',NULL,'Bed and Breakfast con vista a la ciudad',4,5),(19,'21:00','14:00','El Bella Vista Boutique se encuentra en Santa Rosa de Calamuchita y ofrece vistas a la ciudad, bar, jardín y terraza. Todos los alojamientos están equipados con nevera, horno, hervidor de agua, fogones y cafetera. Algunos alojamientos cuentan con TV de pantalla plana vía satélite, cocina totalmente equipada con microondas y baño privado con bidet y artículos de aseo gratuitos. Este bed and breakfast sirve un desayuno americano todas las mañanas. El Bella Vista Hostel Boutique se encuentra a 10 km de Villa General Belgrano y a 29 km de La Cumbrecita. El aeropuerto internacional Ingeniero Aeronáutico Ambrosio L.V. Taravella es el más cercano y queda a 89 km.','Libertad 711',-32.06415005619609,-64.54000983162764,'Bella Vista Boutique',NULL,'Vistas a la ciudad y el jardín',4,6),(20,'21:00','09:00','Los alojamientos disponen de patio, TV de pantalla plana y baño privado con bidet y artículos de aseo gratuitos. Este bed and breakfast sirve un desayuno continental todas las mañanas. El establecimiento alberga un jardín. La ESTANCIA LOS CUARTOS se encuentra a 41 km de Yerba Buena y a 38 km de Famaillá. El aeropuerto internacional Teniente General Benjamín Matienzo es el más cercano y queda a 113 km.','Avenida Gobernador Miguel Critto S/N',-26.854242989314738,-65.70667436063161,'Estancia Los Cuartos',NULL,'Ubicado en el corazón de Tafí del Valle',4,8);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_features`
--

DROP TABLE IF EXISTS `product_features`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_features` (
  `product_id` bigint NOT NULL,
  `feature_id` bigint NOT NULL,
  PRIMARY KEY (`product_id`,`feature_id`),
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
INSERT INTO `product_features` VALUES (1,1),(3,1),(4,1),(5,1),(7,1),(11,1),(15,1),(17,1),(1,2),(2,2),(3,2),(5,2),(6,2),(7,2),(10,2),(11,2),(13,2),(15,2),(16,2),(20,2),(3,3),(5,3),(12,3),(13,3),(16,3),(18,3),(19,3),(20,3),(3,4),(4,4),(9,4),(12,4),(13,4),(19,4),(1,5),(2,5),(3,5),(5,5),(8,5),(9,5),(13,5),(14,5),(16,5),(17,5),(18,5),(20,5),(2,6),(3,6),(4,6),(5,6),(6,6),(8,6),(12,6),(14,6),(15,6),(18,6),(20,6),(2,7),(7,7),(8,7),(9,7),(10,7),(11,7),(12,7),(15,7),(16,7);
/*!40000 ALTER TABLE `product_features` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_policies`
--

DROP TABLE IF EXISTS `product_policies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_policies` (
  `product_id` bigint NOT NULL,
  `policy_id` bigint NOT NULL,
  PRIMARY KEY (`product_id`,`policy_id`),
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
INSERT INTO `product_policies` VALUES (2,1),(3,1),(5,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1),(15,1),(16,1),(18,1),(20,1),(2,2),(3,2),(4,2),(6,2),(7,2),(9,2),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(18,2),(19,2),(20,2),(1,3),(3,3),(4,3),(5,3),(6,3),(8,3),(10,3),(12,3),(13,3),(15,3),(17,3),(18,3),(19,3),(20,3),(1,4),(3,4),(5,4),(6,4),(9,4),(11,4),(12,4),(14,4),(15,4),(17,4),(19,4),(20,4),(2,5),(3,5),(5,5),(6,5),(7,5),(8,5),(10,5),(12,5),(16,5),(18,5),(20,5),(2,6),(3,6),(4,6),(5,6),(6,6),(7,6),(12,6),(13,6),(14,6),(16,6),(19,6),(1,7),(2,7),(3,7),(4,7),(5,7),(6,7),(7,7),(8,7),(9,7),(10,7),(11,7),(12,7),(13,7),(14,7),(15,7),(16,7),(17,7),(18,7),(19,7),(20,7);
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
INSERT INTO `product_sequence` VALUES (21);
/*!40000 ALTER TABLE `product_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `province`
--

DROP TABLE IF EXISTS `province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `province` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `country_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKipakwfceswwc0lb3esew9hqqv` (`country_id`),
  CONSTRAINT `FKipakwfceswwc0lb3esew9hqqv` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province`
--

LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;
INSERT INTO `province` VALUES (1,'Buenos Aires',1),(2,'Santa Fe',1),(3,'Córdoba',1),(4,'Tucuman',1),(5,'Río Negro',1);
/*!40000 ALTER TABLE `province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `province_sequence`
--

DROP TABLE IF EXISTS `province_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `province_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province_sequence`
--

LOCK TABLES `province_sequence` WRITE;
/*!40000 ALTER TABLE `province_sequence` DISABLE KEYS */;
INSERT INTO `province_sequence` VALUES (6);
/*!40000 ALTER TABLE `province_sequence` ENABLE KEYS */;
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
  `product_id` bigint NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlkuwie0au2dru36asng9nywmh` (`product_id`),
  KEY `FKpn05vbx6usw0c65tcyuce4dw5` (`user_id`),
  CONSTRAINT `FKlkuwie0au2dru36asng9nywmh` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKpn05vbx6usw0c65tcyuce4dw5` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (1,8,1,1),(2,9,1,2),(3,9,3,1),(4,7,2,4),(5,4,2,3),(6,7,5,2),(7,10,3,5),(8,8,5,3),(9,7,6,5),(10,6,6,4),(11,5,7,1),(12,6,7,2),(13,9,8,3),(14,8,8,4),(15,3,9,5),(16,7,9,1),(17,10,10,2),(18,10,10,3);
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
INSERT INTO `rating_sequence` VALUES (19);
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
INSERT INTO `rol` VALUES (1,'ADMIN'),(2,'USER');
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
INSERT INTO `rol_sequence` VALUES (3);
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
  `city_id` bigint NOT NULL,
  `id_rol` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  KEY `FK29eqyw0gxw5r4f1ommy11nd9i` (`city_id`),
  KEY `FK4si04gx6t56ut6wjy7k114mbk` (`id_rol`),
  CONSTRAINT `FK29eqyw0gxw5r4f1ommy11nd9i` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `FK4si04gx6t56ut6wjy7k114mbk` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'nico@mail.com','Nico','$2a$10$vWIjTiniQw1n121i7VtYPO/6TfS3rkZxNBspz7rMIeqSY8Arcec6e','Dias',1,2),(2,'pau@mail.com','Pau','$2a$10$VEwmwNTePO7T2haqyijP4uCzUCWgNnRFomrIKCFC.mjMRsgtvQIjO','Alonso',3,2),(3,'agos@mail.com','Agos','$2a$10$UO9kg2CXepPs1SY1qFT7n.GikrYAd9HOJwcX4YYUnaqNaNAKUVmhe','Mora',5,2),(4,'eli@mail.com','Eli','$2a$10$AAIXLMW1HVYiqpkbKd3bi.c7OLCkjJknIGHIkpbD9gW26h4YdR/sO','García',7,2),(5,'dami@mail.com','Dami','$2a$10$DEwrEIP/3OODgo/Eug1UvOahFazz7MLQ2fNU1NqY1XN1I60PTkP5a','Sformo',9,2);
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
INSERT INTO `user_sequence` VALUES (6);
/*!40000 ALTER TABLE `user_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'BookingDB'
--

--
-- Dumping routines for database 'BookingDB'
--
-- SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-21 12:10:52
