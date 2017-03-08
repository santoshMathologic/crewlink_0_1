/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.5-10.1.13-MariaDB : Database - crewlink_0_1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`crewlink_0_1` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `crewlink_0_1`;

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_8sewwnpamngi6b1dwaa88askk` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `role` */

insert  into `role`(`id`,`name`) values (3,'ADMIN'),(4,'guest'),(5,'super'),(1,'USER');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activation_key` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `employee_no` varchar(255) DEFAULT NULL,
  `extension` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `is_active` bit(1) DEFAULT b'0',
  `last_name` varchar(255) DEFAULT NULL,
  `mobile_no` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `telephone_no` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`),
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`activation_key`,`email`,`employee_no`,`extension`,`first_name`,`is_active`,`last_name`,`mobile_no`,`password`,`telephone_no`,`username`,`role_id`) values (1,NULL,'san@gmail.com','MIT124','123','santosh','\0','sahu','9008365317','123456',NULL,'santosh',1),(2,NULL,'abc@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'raj',3),(3,NULL,'ac@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'ll',3),(4,NULL,'a@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'pppp',3),(5,NULL,'k@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'mmmmm',3),(6,NULL,'q@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'dasdas',3),(7,NULL,'qppp@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'oodsd',3),(8,NULL,'wwww@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'lkkdasd',3),(9,NULL,'zzzz@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'nnnnn',3),(10,NULL,'trtrt@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'wwww',3),(11,NULL,'lodkd@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'mkjsjs',3),(12,NULL,'qweedd@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'pdodo',3),(13,NULL,'qweqw@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'ldldld',3),(14,NULL,'dsadasda@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'dddasd',3),(15,NULL,'seaasda@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'dsdsdasdasd',3),(16,NULL,'dadasd@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'dsdadsa',3),(17,NULL,'ewewew@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'pdpdpd',3),(18,NULL,'pewpqpeeqw@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'clclld',3),(19,NULL,'eeqeqwe@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'dsdasdasd',3),(20,NULL,'eqeqwe@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'pdpdpdpdpdd',3),(21,NULL,'eqweqwe@gmail.com','MIT145','254','raj','','malhotra','7406456159','123',NULL,'dldkdkd',3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
