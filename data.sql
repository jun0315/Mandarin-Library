/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 5.6.45-log : Database - lib_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lib_system` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `lib_system`;

/*Table structure for table `admin_setting` */

DROP TABLE IF EXISTS `admin_setting`;

CREATE TABLE `admin_setting` (
  `book_fine_value` int(11) DEFAULT '1',
  `book_return_period` int(11) DEFAULT '30',
  `reader_security_deposit` int(11) DEFAULT '300'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin_setting` */

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `isbn` char(13) NOT NULL,
  `book_name` varchar(2048) DEFAULT NULL,
  `book_press` varchar(2048) DEFAULT NULL,
  `book_price` int(11) unsigned DEFAULT NULL,
  `book_author` varchar(2048) DEFAULT NULL,
  `book_category` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`isbn`,`book_name`,`book_press`,`book_price`,`book_author`,`book_category`) values 
('9787542637956','白银时代','上海三联书店',50,'王小波',NULL);

/*Table structure for table `book_deleted` */

DROP TABLE IF EXISTS `book_deleted`;

CREATE TABLE `book_deleted` (
  `book_id` varchar(128) DEFAULT NULL,
  `isbn` int(11) DEFAULT NULL,
  `delete_time` time DEFAULT NULL,
  `staff_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `book_deleted` */

/*Table structure for table `book_detail` */

DROP TABLE IF EXISTS `book_detail`;

CREATE TABLE `book_detail` (
  `book_id` varchar(128) NOT NULL,
  `isbn` char(13) NOT NULL,
  PRIMARY KEY (`book_id`),
  KEY `book_detail_ibfk_1` (`isbn`),
  CONSTRAINT `book_detail_ibfk_1` FOREIGN KEY (`isbn`) REFERENCES `book` (`isbn`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book_detail` */

/*Table structure for table `reader` */

DROP TABLE IF EXISTS `reader`;

CREATE TABLE `reader` (
  `user_id` int(11) unsigned NOT NULL,
  `user_name` varchar(2048) CHARACTER SET latin1 DEFAULT NULL,
  `user_password` varchar(64) CHARACTER SET latin1 NOT NULL,
  `reader_email` varchar(128) CHARACTER SET latin1 DEFAULT NULL,
  `security_deposit` int(11) DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reader` */

/*Table structure for table `reader_borrow` */

DROP TABLE IF EXISTS `reader_borrow`;

CREATE TABLE `reader_borrow` (
  `book_id` varchar(128) NOT NULL,
  `user_id` int(11) unsigned NOT NULL,
  `borrow_time` datetime DEFAULT NULL,
  PRIMARY KEY (`book_id`,`user_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `reader_borrow_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book_detail` (`book_id`),
  CONSTRAINT `reader_borrow_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `reader` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reader_borrow` */

/*Table structure for table `reader_reserve` */

DROP TABLE IF EXISTS `reader_reserve`;

CREATE TABLE `reader_reserve` (
  `user_id` int(11) DEFAULT NULL,
  `book_id` varchar(128) DEFAULT NULL,
  `isbn` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `reader_reserve` */

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `staff_name` varchar(256) DEFAULT NULL,
  `staff_type` enum('admin','librarian') CHARACTER SET latin1 DEFAULT NULL,
  `staff_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `staff_password` varchar(64) CHARACTER SET latin1 DEFAULT NULL,
  `staff_phone` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `staff` */

insert  into `staff`(`staff_name`,`staff_type`,`staff_id`,`staff_password`,`staff_phone`) values 
('admin','admin',1,'root','1333333'),
('librarian','librarian',2,'123','1333333');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
