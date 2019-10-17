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
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lib_system` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lib_system`;

/*Table structure for table `admin_setting` */

DROP TABLE IF EXISTS `admin_setting`;

CREATE TABLE `admin_setting` (
  `book_fine_value` int(11) DEFAULT '1',
  `book_return_period` int(11) DEFAULT '30',
  `reader_security_deposit` int(11) DEFAULT '300'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin_setting` */

insert  into `admin_setting`(`book_fine_value`,`book_return_period`,`reader_security_deposit`) values 
(15,30,20);

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `book_number` char(13) NOT NULL,
  `book_name` varchar(2048) DEFAULT NULL,
  `book_press` varchar(2048) DEFAULT NULL,
  `book_price` double unsigned DEFAULT NULL,
  `book_author` varchar(2048) DEFAULT NULL,
  `book_category` varchar(2048) DEFAULT NULL,
  `book_amount` int(10) unsigned DEFAULT NULL,
  `book_areacode` varchar(2048) DEFAULT NULL,
  `book_description` varchar(4096) DEFAULT NULL,
  PRIMARY KEY (`book_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`book_number`,`book_name`,`book_press`,`book_price`,`book_author`,`book_category`,`book_amount`,`book_areacode`,`book_description`) values 
('','librarianafadf','ewe',16,'阿迪斯发','arts',626,'177','阿道夫啊'),
('1231231231234','','12',12,'','arts',12,'',''),
('1236632125666','','',233,'','arts',23,'',''),
('3263632563263','78782','7',36,'','arts',36,' 违法',' 违法我'),
('3264692563263','78782','7',36,'阿迪斯发','music',82,' 违法','88'),
('3264692563633','78782','7',36,'阿迪斯发','music',82,'','88'),
('3264692563963','78782','7',36,'阿迪斯发','music',82,' 违法','88'),
('3269692563263','78782','7',36,'阿迪斯发','arts',36,' 违法',''),
('9636548521236','','23',23,'',NULL,2323,'',''),
('9787536025097','白银时代','上海三联书店',50,'王小波',NULL,NULL,NULL,NULL),
('plokmnjuhbko2','','',12,'','arts',12,'','');

/*Table structure for table `book_category` */

DROP TABLE IF EXISTS `book_category`;

CREATE TABLE `book_category` (
  `category` varchar(2048) NOT NULL,
  `floor` int(11) DEFAULT NULL,
  `shelf` varchar(16) DEFAULT NULL,
  `areacode` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book_category` */

insert  into `book_category`(`category`,`floor`,`shelf`,`areacode`) values 
('arts',NULL,NULL,NULL),
('music',NULL,NULL,NULL),
('fiction',NULL,NULL,NULL);

/*Table structure for table `book_deleted` */

DROP TABLE IF EXISTS `book_deleted`;

CREATE TABLE `book_deleted` (
  `copy_id` varchar(32) NOT NULL,
  `delete_time` time DEFAULT NULL,
  `staff_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`copy_id`),
  CONSTRAINT `book_deleted_ibfk_1` FOREIGN KEY (`copy_id`) REFERENCES `book_detail` (`copy_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book_deleted` */

/*Table structure for table `book_detail` */

DROP TABLE IF EXISTS `book_detail`;

CREATE TABLE `book_detail` (
  `book_number` char(13) NOT NULL,
  `copy_id` varchar(32) NOT NULL,
  `status` int(4) NOT NULL,
  PRIMARY KEY (`copy_id`),
  KEY `book_id` (`book_number`),
  CONSTRAINT `book_detail_ibfk_1` FOREIGN KEY (`book_number`) REFERENCES `book` (`book_number`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book_detail` */

/*Table structure for table `reader` */

DROP TABLE IF EXISTS `reader`;

CREATE TABLE `reader` (
  `user_account` varchar(64) NOT NULL,
  `user_name` varchar(2048) CHARACTER SET latin1 DEFAULT NULL,
  `user_password` varchar(64) CHARACTER SET latin1 NOT NULL,
  `user_email` varchar(128) CHARACTER SET latin1 DEFAULT NULL,
  `security_deposit` int(11) DEFAULT '0',
  PRIMARY KEY (`user_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reader` */

insert  into `reader`(`user_account`,`user_name`,`user_password`,`user_email`,`security_deposit`) values 
('reader','123','123','123',300),
('reader-test','jun','123','1072505283@qq.com',0);

/*Table structure for table `reader_borrow` */

DROP TABLE IF EXISTS `reader_borrow`;

CREATE TABLE `reader_borrow` (
  `copy_id` varchar(10) NOT NULL,
  `user_account` varchar(64) NOT NULL,
  `borrow_time` datetime DEFAULT NULL,
  `isreturned` tinyint(1) NOT NULL,
  `fine` double DEFAULT NULL,
  PRIMARY KEY (`copy_id`,`user_account`),
  KEY `user_id` (`user_account`),
  CONSTRAINT `copy_id` FOREIGN KEY (`copy_id`) REFERENCES `book_detail` (`copy_id`),
  CONSTRAINT `reader_borrow_ibfk_2` FOREIGN KEY (`user_account`) REFERENCES `reader` (`user_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reader_borrow` */

/*Table structure for table `reader_reserve` */

DROP TABLE IF EXISTS `reader_reserve`;

CREATE TABLE `reader_reserve` (
  `user_account` varchar(64) DEFAULT NULL,
  `book_id` varchar(128) DEFAULT NULL,
  `isbn` int(11) DEFAULT NULL,
  `reservetime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `reader_reserve` */

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `staff_name` varchar(256) DEFAULT NULL,
  `user_type` enum('Admin','Librarian') CHARACTER SET latin1 DEFAULT NULL,
  `staff_account` varchar(64) NOT NULL,
  `staff_password` varchar(64) CHARACTER SET latin1 DEFAULT NULL,
  `staff_phone` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`staff_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `staff` */

insert  into `staff`(`staff_name`,`user_type`,`staff_account`,`staff_password`,`staff_phone`) values 
('admin','Admin','admin','root1','1333333'),
('librarian','Librarian','librarian','123','1333333');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
