/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.5.40 : Database - spring
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spring` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `food` */

DROP TABLE IF EXISTS `food`;

CREATE TABLE `food` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `info` varchar(200) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `imgSrc` varchar(260) DEFAULT NULL,
  `typeId` int(50) DEFAULT NULL,
  `discount` int(50) DEFAULT NULL,
  `review` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `typeId` (`typeId`),
  CONSTRAINT `food_ibfk_1` FOREIGN KEY (`typeId`) REFERENCES `types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `food` */

insert  into `food`(`id`,`name`,`title`,`info`,`price`,`imgSrc`,`typeId`,`discount`,`review`) values (1,'鱼片色拉','香','甜品',3,'images\\g2.jpg',1,0,555),(2,'面包','早餐必备','顶饿',5,'images\\g3.jpg',2,0,555),(3,'鸡腿','香','乡巴佬出品',5,'images\\a2.jpg',3,0,555),(4,'可乐鸡翅','脆嫩','奥尔良',5,'images\\a3.jpg',4,0,555),(5,'炒粉','不油腻','丰城老婆子',5,'images\\a4.jpg',5,0,666),(6,'可口可乐','0糖','可口可乐',3,'images\\a1.jpg',6,0,666);

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `usersId` int(20) DEFAULT NULL,
  `orderTime` datetime DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `usersId` (`usersId`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`usersId`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `order` */

insert  into `order`(`id`,`usersId`,`orderTime`,`Address`) values (1,2,'2017-05-03 11:41:19','a15-260'),(2,NULL,NULL,NULL),(3,2,'2017-05-27 11:04:51',NULL),(4,2,'2017-05-27 11:06:22',NULL),(5,2,'2017-05-27 11:12:52',NULL),(6,1,'2017-11-04 14:34:08',NULL),(7,1,'2017-11-04 14:35:37',NULL),(8,1,'2017-11-04 14:35:51',NULL),(9,8,'2017-11-04 14:47:31',NULL),(10,8,'2017-11-04 14:47:49',NULL),(11,9,'2017-11-04 19:49:39',NULL);

/*Table structure for table `orderdetail` */

DROP TABLE IF EXISTS `orderdetail`;

CREATE TABLE `orderdetail` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `orderId` int(20) DEFAULT NULL,
  `foodId` int(20) DEFAULT NULL,
  `nums` int(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orderId` (`orderId`),
  KEY `foodId` (`foodId`),
  CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `order` (`id`),
  CONSTRAINT `orderdetail_ibfk_2` FOREIGN KEY (`foodId`) REFERENCES `food` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `orderdetail` */

insert  into `orderdetail`(`id`,`orderId`,`foodId`,`nums`,`price`) values (1,1,3,2,10),(2,1,5,4,20),(3,3,2,1,5),(4,3,1,1,3),(5,4,3,1,5),(6,4,6,1,3),(7,5,2,2,10),(8,6,6,5,15),(9,7,1,25,75),(10,8,1,25,75),(11,8,3,5,25),(12,9,2,2,10),(13,10,2,2,10),(14,10,1,4,12),(15,11,4,3,15);

/*Table structure for table `types` */

DROP TABLE IF EXISTS `types`;

CREATE TABLE `types` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `types` */

insert  into `types`(`id`,`name`) values (1,'小吃'),(2,'面包'),(3,'肉类'),(4,'烤翅'),(5,'主食'),(6,'饮料');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `level` int(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`nickname`,`password`,`email`,`phone`,`level`) values (1,'lisi','李四','123','123@163.com','15070553114',0),(2,'ge','葛聪','123','jxfcgc@163.com','15717004279',0),(8,'zhangsan','张三','123','123@qq.com','15070553114',NULL),(9,'gecong','葛聪','123','100@qq.com','15070553114',NULL),(10,'san','张三','123','100@qq.com','12345678911',NULL),(11,'','','','','',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
