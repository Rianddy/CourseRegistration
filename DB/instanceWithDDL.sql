-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: localhost:8889
-- Generation Time: Nov 15, 2014 at 01:43 AM
-- Server version: 5.5.34
-- PHP Version: 5.5.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `CourseRegistrationDB`
--

-- --------------------------------------------------------

--
-- Table structure for table `Class`
--

CREATE TABLE `Class` (
  `Cls_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Cos_ID` int(11) NOT NULL,
  `Max_Size` int(11) NOT NULL DEFAULT '0',
  `Max_WaitList` int(11) NOT NULL DEFAULT '0',
  `Cur_Size` int(11) NOT NULL DEFAULT '0',
  `Cur_WaitList` int(11) NOT NULL DEFAULT '0',
  `Open_Sem_ID` int(11) NOT NULL,
  `Fac_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cls_ID`),
  KEY `Cos_ID` (`Cos_ID`),
  KEY `Open_Sem_ID` (`Open_Sem_ID`),
  KEY `Fac_ID` (`Fac_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `Class`
--

INSERT INTO `Class` (`Cls_ID`, `Cos_ID`, `Max_Size`, `Max_WaitList`, `Cur_Size`, `Cur_WaitList`, `Open_Sem_ID`, `Fac_ID`) VALUES
(1, 1, 30, 10, 0, 0, 1, 1),
(6, 1, 27, 11, 0, 0, 1, 2),
(7, 2, 30, 10, 0, 2, 1, 3),
(8, 3, 30, 0, 0, 0, 1, 4),
(9, 1, 30, 10, 0, 0, 2, 4);

-- --------------------------------------------------------

--
-- Table structure for table `Concentration`
--

CREATE TABLE `Concentration` (
  `Conc_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(250) NOT NULL,
  `Maj_ID` int(11) NOT NULL,
  PRIMARY KEY (`Conc_ID`),
  KEY `Maj_ID` (`Maj_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `Concentration`
--

INSERT INTO `Concentration` (`Conc_ID`, `Name`, `Maj_ID`) VALUES
(1, 'general', 1),
(2, 'Human Center Computing', 1),
(3, 'Big Data', 1),
(4, 'Database and Web', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Course`
--

CREATE TABLE `Course` (
  `Cos_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Dep_ID` int(11) DEFAULT NULL,
  `Maj_ID` int(11) DEFAULT NULL,
  `Conc_ID` int(11) DEFAULT NULL,
  `Name` varchar(250) NOT NULL,
  `Description` varchar(250) DEFAULT NULL,
  `Credits` int(11) NOT NULL,
  `Status` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cos_ID`),
  KEY `Maj_ID` (`Maj_ID`),
  KEY `Conc_ID` (`Conc_ID`),
  KEY `Dep_ID` (`Dep_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `Course`
--

INSERT INTO `Course` (`Cos_ID`, `Dep_ID`, `Maj_ID`, `Conc_ID`, `Name`, `Description`, `Credits`, `Status`) VALUES
(1, 1, 1, 1, 'E-Business', 'E-business by Spring', 3, 1),
(2, 1, 1, NULL, 'Database', 'Database by valamier', 3, 1),
(3, 1, 1, 2, 'Interactive System Design', 'Interactive by Peter', 3, 1),
(4, 1, 1, 3, 'Data Mining ', 'Data Mining by Peter', 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Department`
--

CREATE TABLE `Department` (
  `Dep_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(250) NOT NULL,
  `Address` varchar(250) DEFAULT NULL,
  `Dean_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`Dep_ID`),
  KEY `Dean_ID` (`Dean_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `Department`
--

INSERT INTO `Department` (`Dep_ID`, `Name`, `Address`, `Dean_ID`) VALUES
(1, 'Information School', 'N.Bellified St', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `Faculty`
--

CREATE TABLE `Faculty` (
  `Fac_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(250) NOT NULL,
  `Status` bit(1) NOT NULL,
  `Email` varchar(250) NOT NULL,
  `Cell` varchar(25) DEFAULT NULL,
  `Dep_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`Fac_ID`),
  KEY `Dep_ID` (`Dep_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `Faculty`
--

INSERT INTO `Faculty` (`Fac_ID`, `Name`, `Status`, `Email`, `Cell`, `Dep_ID`) VALUES
(1, 'Michael Spring', '', 'mbsSpring@pitt.edu', '412-608-8888', 1),
(2, 'Becich, Michael', '\0', 'becich@pitt.edu', '412-608-7777', 1),
(3, 'Cooper, Gregory F', '\0', 'gfc@pitt.edu', '412-608-6666', 1),
(4, 'Brusilovsky, Peter', '\0', 'peter@pitt.edu', '412-608-1234', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Major`
--

CREATE TABLE `Major` (
  `Maj_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(250) NOT NULL,
  `Dep_ID` int(11) NOT NULL,
  PRIMARY KEY (`Maj_ID`),
  KEY `Dep_ID` (`Dep_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `Major`
--

INSERT INTO `Major` (`Maj_ID`, `Name`, `Dep_ID`) VALUES
(1, 'Information Scienece', 1),
(2, 'Telecomnication Information', 1),
(3, 'Liberity information science', 1),
(4, 'Undergraduate information science', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Permission`
--

CREATE TABLE `Permission` (
  `Perms_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Stu_ID` int(11) NOT NULL,
  `Fac_ID` int(11) NOT NULL,
  `Status` enum('submit','transfer','reject','accept') DEFAULT NULL,
  PRIMARY KEY (`Perms_ID`),
  KEY `Stu_ID` (`Stu_ID`),
  KEY `Fac_ID` (`Fac_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Prerequestment`
--

CREATE TABLE `Prerequestment` (
  `PreReq_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Cos_ID` int(11) NOT NULL,
  `Pre_Cos_ID` int(11) NOT NULL,
  PRIMARY KEY (`PreReq_ID`),
  KEY `Cos_ID` (`Cos_ID`),
  KEY `Pre_Cos_ID` (`Pre_Cos_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `Prerequestment`
--

INSERT INTO `Prerequestment` (`PreReq_ID`, `Cos_ID`, `Pre_Cos_ID`) VALUES
(1, 1, 2),
(2, 1, 3),
(3, 2, 4);

-- --------------------------------------------------------

--
-- Table structure for table `Semester`
--

CREATE TABLE `Semester` (
  `Sem_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Short_Name` varchar(255) NOT NULL,
  `Start_Date` date NOT NULL,
  `End_Date` date NOT NULL,
  `Add_Drop_Date` date NOT NULL,
  PRIMARY KEY (`Sem_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `Semester`
--

INSERT INTO `Semester` (`Sem_ID`, `Short_Name`, `Start_Date`, `End_Date`, `Add_Drop_Date`) VALUES
(1, 'FALL2014', '2014-08-27', '2014-12-14', '2014-09-15'),
(2, 'Spring2015', '2014-01-27', '2014-04-14', '2014-02-15'),
(3, 'Spring2014', '2014-01-27', '2014-04-14', '2014-02-15'),
(4, 'Summer2014', '2014-04-17', '2014-08-19', '2014-05-25');

-- --------------------------------------------------------

--
-- Table structure for table `Student`
--

CREATE TABLE `Student` (
  `Stu_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(250) NOT NULL,
  `Email` varchar(250) NOT NULL,
  `Dep_ID` int(11) DEFAULT NULL,
  `Maj_ID` int(11) DEFAULT NULL,
  `Conc_ID` int(11) DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `Address` varchar(250) DEFAULT NULL,
  `Cell` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`Stu_ID`),
  KEY `Conc_ID` (`Conc_ID`),
  KEY `Maj_ID` (`Maj_ID`),
  KEY `Dep_ID` (`Dep_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `Student`
--

INSERT INTO `Student` (`Stu_ID`, `Name`, `Email`, `Dep_ID`, `Maj_ID`, `Conc_ID`, `Birthday`, `Address`, `Cell`) VALUES
(1, 'Zhefeng Chen', 'chenzf.pitts@gmail.com', NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'Haoyu Wang', 'hyw2013.pitts@gmail.com', NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'Zhefeng Chen', 'zf@pitt.edu', 1, 1, 1, '1990-12-09', 'N.Dithridge', '412-608-9999'),
(4, 'Yaping Chen', 'yaping@gmail.com', 1, 1, 2, NULL, NULL, NULL),
(5, 'Rui Cai', 'ruiC@gmail.com', 1, 1, 3, NULL, NULL, NULL),
(6, 'Bi Rui', 'rb@pitt.edu', 1, 1, 1, NULL, NULL, NULL),
(7, 'Victory', 'vc@gmail.com', 1, 1, 1, NULL, NULL, NULL),
(8, 'Sam', 'sam@gmail.com', 1, 1, 3, NULL, NULL, NULL),
(9, 'Ruiting Yi', 'ry@pitt.edu', 1, 1, 1, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `StudentEnrollment`
--

CREATE TABLE `StudentEnrollment` (
  `Stu_Enroll_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Stu_ID` int(11) NOT NULL,
  `Cls_ID` int(11) NOT NULL,
  `Grade` enum('A','B','C','D','E','F','G') DEFAULT NULL,
  `Score` int(11) DEFAULT NULL,
  `Status` enum('enroll','waitlist','drop','withdraw','complete','fail') DEFAULT NULL,
  `Stu_Enroll_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Stu_Enroll_ID`),
  KEY `Stu_ID` (`Stu_ID`),
  KEY `Cls_ID` (`Cls_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `StudentEnrollment`
--

INSERT INTO `StudentEnrollment` (`Stu_Enroll_ID`, `Stu_ID`, `Cls_ID`, `Grade`, `Score`, `Status`, `Stu_Enroll_Time`) VALUES
(1, 2, 1, NULL, 0, 'enroll', '2014-11-15 00:15:43'),
(4, 1, 6, 'A', 90, 'complete', '2014-11-15 00:38:58'),
(5, 3, 7, NULL, NULL, 'enroll', '2014-11-15 00:39:20'),
(6, 4, 7, NULL, NULL, 'waitlist', '2014-11-15 00:39:30'),
(7, 5, 7, NULL, NULL, 'waitlist', '2014-11-15 00:39:39');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Class`
--
ALTER TABLE `Class`
  ADD CONSTRAINT `class_ibfk_1` FOREIGN KEY (`Cos_ID`) REFERENCES `Course` (`Cos_ID`),
  ADD CONSTRAINT `class_ibfk_2` FOREIGN KEY (`Open_Sem_ID`) REFERENCES `Semester` (`Sem_ID`),
  ADD CONSTRAINT `class_ibfk_3` FOREIGN KEY (`Fac_ID`) REFERENCES `Faculty` (`Fac_ID`);

--
-- Constraints for table `Concentration`
--
ALTER TABLE `Concentration`
  ADD CONSTRAINT `concentration_ibfk_1` FOREIGN KEY (`Maj_ID`) REFERENCES `Major` (`Maj_ID`);

--
-- Constraints for table `Course`
--
ALTER TABLE `Course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`Maj_ID`) REFERENCES `Major` (`Maj_ID`),
  ADD CONSTRAINT `course_ibfk_2` FOREIGN KEY (`Conc_ID`) REFERENCES `Concentration` (`Conc_ID`),
  ADD CONSTRAINT `course_ibfk_3` FOREIGN KEY (`Dep_ID`) REFERENCES `Department` (`Dep_ID`);

--
-- Constraints for table `Department`
--
ALTER TABLE `Department`
  ADD CONSTRAINT `department_ibfk_1` FOREIGN KEY (`Dean_ID`) REFERENCES `Faculty` (`Fac_ID`);

--
-- Constraints for table `Faculty`
--
ALTER TABLE `Faculty`
  ADD CONSTRAINT `faculty_ibfk_1` FOREIGN KEY (`Dep_ID`) REFERENCES `Department` (`Dep_ID`);

--
-- Constraints for table `Major`
--
ALTER TABLE `Major`
  ADD CONSTRAINT `major_ibfk_1` FOREIGN KEY (`Dep_ID`) REFERENCES `Department` (`Dep_ID`);

--
-- Constraints for table `Permission`
--
ALTER TABLE `Permission`
  ADD CONSTRAINT `permission_ibfk_1` FOREIGN KEY (`Stu_ID`) REFERENCES `Student` (`Stu_ID`),
  ADD CONSTRAINT `permission_ibfk_2` FOREIGN KEY (`Fac_ID`) REFERENCES `Faculty` (`Fac_ID`);

--
-- Constraints for table `Prerequestment`
--
ALTER TABLE `Prerequestment`
  ADD CONSTRAINT `prerequestment_ibfk_1` FOREIGN KEY (`Cos_ID`) REFERENCES `Course` (`Cos_ID`),
  ADD CONSTRAINT `prerequestment_ibfk_2` FOREIGN KEY (`Pre_Cos_ID`) REFERENCES `Course` (`Cos_ID`);

--
-- Constraints for table `Student`
--
ALTER TABLE `Student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`Conc_ID`) REFERENCES `Concentration` (`Conc_ID`),
  ADD CONSTRAINT `student_ibfk_2` FOREIGN KEY (`Maj_ID`) REFERENCES `Major` (`Maj_ID`),
  ADD CONSTRAINT `student_ibfk_3` FOREIGN KEY (`Dep_ID`) REFERENCES `Department` (`Dep_ID`);

--
-- Constraints for table `StudentEnrollment`
--
ALTER TABLE `StudentEnrollment`
  ADD CONSTRAINT `studentenrollment_ibfk_1` FOREIGN KEY (`Stu_ID`) REFERENCES `Student` (`Stu_ID`),
  ADD CONSTRAINT `studentenrollment_ibfk_2` FOREIGN KEY (`Cls_ID`) REFERENCES `Class` (`Cls_ID`);
