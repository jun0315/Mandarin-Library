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
  `book_fine_value` varchar(11) DEFAULT NULL,
  `book_return_period` varchar(11) DEFAULT NULL,
  `reader_security_deposit` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin_setting` */

insert  into `admin_setting`(`book_fine_value`,`book_return_period`,`reader_security_deposit`) values 
('1','30','15'),
('1','30','15');

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
  `book_description` varchar(4096) DEFAULT NULL,
  PRIMARY KEY (`book_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`book_number`,`book_name`,`book_press`,`book_price`,`book_author`,`book_category`,`book_amount`,`book_description`) values 
('9780131872486','Thinking in Java','Pearson Education',32,'Bruce Eckel','Art',2,'With humor and insight, the author introduces the fundamental concepts of the Java programming language, from object development to design patterns, with the help of straightforward examples. By the author of Thinking in C++++. Original. (Beginner).'),
('9787020139927','失踪的孩子','西北工业大学出版社',2,'Elena Ferrante ','Art',2,'2'),
('9787115216878','代码整洁之道','人民邮电出版社',32,'Robert C. Martin马丁Rtin Ma韩磊','Science',2,'本书提出一种观念：代码质量与其整洁度成正比。干净的代码，既在质量上较为可靠，也为后期维护、升级奠定了良好基础。作为编程领域的佼佼者，本书作者给出了一系列行之有效的整洁代码操作实践。这些实践在本书中体现为一条条规则(或称“启示”)，并辅以来自现实项目的正、反两面的范例。只要遵循这些规则，就能编写出干净的代码，从而有效提升代码质量。');

/*Table structure for table `book_category` */

DROP TABLE IF EXISTS `book_category`;

CREATE TABLE `book_category` (
  `category` varchar(2048) NOT NULL,
  `floor` int(11) DEFAULT NULL,
  `shelf` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book_category` */

insert  into `book_category`(`category`,`floor`,`shelf`) values 
('Art',1,'1'),
('Science',1,'2'),
('Music',2,'1'),
('Computer',2,'2'),
('Nature',2,'3'),
('Math',4,'2');

/*Table structure for table `book_deleted` */

DROP TABLE IF EXISTS `book_deleted`;

CREATE TABLE `book_deleted` (
  `copy_id` varchar(32) NOT NULL,
  `delete_time` datetime DEFAULT NULL,
  `staff_id` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`copy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book_deleted` */

insert  into `book_deleted`(`copy_id`,`delete_time`,`staff_id`) values 
('97801318724860002','2019-10-31 00:00:00','0201'),
('97801318724860003','2019-10-31 00:00:00','0201'),
('97801318724860016','2019-10-31 22:25:14','0201'),
('97801318724860017','2019-10-31 22:26:38','0201'),
('97801318724860018','2019-10-31 22:26:42',NULL);

/*Table structure for table `book_detail` */

DROP TABLE IF EXISTS `book_detail`;

CREATE TABLE `book_detail` (
  `book_number` char(13) NOT NULL,
  `copy_id` varchar(32) NOT NULL,
  `status` int(4) NOT NULL,
  `areacode` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`copy_id`),
  KEY `book_id` (`book_number`),
  CONSTRAINT `book_detail_ibfk_1` FOREIGN KEY (`book_number`) REFERENCES `book` (`book_number`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book_detail` */

insert  into `book_detail`(`book_number`,`copy_id`,`status`,`areacode`) values 
('9780131872486','97801318724860004',2,'3'),
('9780131872486','97801318724860005',2,'4'),
('9787020139927','97870201399270001',2,'34'),
('9787020139927','97870201399270002',2,'32'),
('9787115216878','97871152168780001',2,'5'),
('9787115216878','97871152168780002',2,'1');

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `notice_topic` varchar(12) DEFAULT NULL,
  `notice_content` varchar(64) DEFAULT NULL,
  `notice_id` int(10) NOT NULL,
  `notice_date` datetime DEFAULT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `notice` */

insert  into `notice`(`notice_topic`,`notice_content`,`notice_id`,`notice_date`) values 
(NULL,NULL,0,NULL),
('test notice','Good luck',1,'2019-10-30 00:00:00'),
('notice1','The library is opened.',2,'2019-10-31 21:51:16'),
('notice 2','we are seperated.',3,'2019-10-31 21:51:53'),
('other notice','book will be deleted.',4,'2019-10-31 21:52:13'),
('other notice','book will be deleted.',5,'2019-10-31 21:52:13'),
('other notice','book will be deleted.',6,'2019-10-31 21:52:13'),
('other notice','book will be deleted.',7,'2019-10-31 21:52:13'),
('other notice','book will be deleted.',8,'2019-10-31 21:52:13'),
('other notice','book will be deleted.',9,'2019-10-31 21:52:13'),
('other notice','book will be deleted.',11,'2019-10-31 21:52:13'),
('other notice','book will be deleted.',12,'2019-10-31 21:52:13');

/*Table structure for table `reader` */

DROP TABLE IF EXISTS `reader`;

CREATE TABLE `reader` (
  `user_account` varchar(64) NOT NULL,
  `user_name` varchar(2048) DEFAULT NULL,
  `user_password` varchar(64) NOT NULL,
  `user_email` varchar(128) DEFAULT NULL,
  `security_deposit` int(11) DEFAULT '0',
  `register_time` date DEFAULT NULL,
  `borrowing_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reader` */

insert  into `reader`(`user_account`,`user_name`,`user_password`,`user_email`,`security_deposit`,`register_time`,`borrowing_count`) values 
('12213123123','samuel','12345678','m123213@163.com',0,NULL,NULL),
('13855447008','jun1','123','1072505283@qq.com',0,'2019-10-28',0),
('17795832333','liubihao','123456','1072505283@qq.com',300,'2019-11-01',2);

/*Table structure for table `reader_borrow` */

DROP TABLE IF EXISTS `reader_borrow`;

CREATE TABLE `reader_borrow` (
  `copy_id` varchar(32) NOT NULL,
  `user_account` varchar(64) NOT NULL,
  `borrow_time` datetime DEFAULT NULL,
  `isReturned` tinyint(4) DEFAULT NULL,
  `fine` double DEFAULT NULL,
  `book_name` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`copy_id`,`user_account`),
  KEY `user_id` (`user_account`),
  CONSTRAINT `copy_id` FOREIGN KEY (`copy_id`) REFERENCES `book_detail` (`copy_id`),
  CONSTRAINT `reader_borrow_ibfk_2` FOREIGN KEY (`user_account`) REFERENCES `reader` (`user_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reader_borrow` */

insert  into `reader_borrow`(`copy_id`,`user_account`,`borrow_time`,`isReturned`,`fine`,`book_name`) values 
('97801318724860004','12213123123','2019-10-03 22:02:16',0,0,'Thinking in Java'),
('97801318724860004','13855447008','2019-10-03 22:02:16',0,0,'Thinking in Java'),
('97801318724860004','17795832333','2019-10-02 22:02:16',0,0,'Thinking in Java'),
('97801318724860005','17795832333','2019-10-03 22:02:16',0,0,'Thinking in Java');

/*Table structure for table `reader_reserve` */

DROP TABLE IF EXISTS `reader_reserve`;

CREATE TABLE `reader_reserve` (
  `user_account` varchar(64) NOT NULL,
  `copy_id` varchar(32) NOT NULL,
  `reserve_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_account`,`copy_id`),
  KEY `copy_id` (`copy_id`),
  CONSTRAINT `reader_reserve_ibfk_1` FOREIGN KEY (`user_account`) REFERENCES `reader` (`user_account`),
  CONSTRAINT `reader_reserve_ibfk_2` FOREIGN KEY (`copy_id`) REFERENCES `book_detail` (`copy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
('xieqijun','Admin','0101','0101','12388984637'),
('zhangcongy','Admin','0102','0102','19232983298'),
('liubihao','Librarian','0201','0201','17786423232'),
('huangzhi','Librarian','0202','00010001','12321002322');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
