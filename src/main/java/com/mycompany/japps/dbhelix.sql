-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 27, 2023 at 08:38 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbhelix`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbladmin`
--

CREATE TABLE `tbladmin` (
  `adminID` int(11) NOT NULL,
  `jobTitle` varchar(255) NOT NULL,
  `position` varchar(255) NOT NULL,
  `institutionalEmail` varchar(255) NOT NULL,
  `register_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbladmin`
--

INSERT INTO `tbladmin` (`adminID`, `jobTitle`, `position`, `institutionalEmail`, `register_Id`) VALUES
(10000000, '', '', '', 0),
(10000001, '', '', '', 51),
(10000002, '', '', '', 51);

-- --------------------------------------------------------

--
-- Table structure for table `tblnewsletter`
--

CREATE TABLE `tblnewsletter` (
  `news_ID` int(11) NOT NULL,
  `news_Month` varchar(256) NOT NULL,
  `news_Day` varchar(256) NOT NULL,
  `news_DayInt` int(11) NOT NULL,
  `news_Title` mediumtext NOT NULL,
  `news_Content` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tblregister`
--

CREATE TABLE `tblregister` (
  `register_id` int(11) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `middleName` varchar(100) NOT NULL,
  `suffix` varchar(20) NOT NULL,
  `homeAddress` varchar(200) NOT NULL,
  `dateOfBirth` varchar(50) NOT NULL,
  `placeOfBirth` varchar(200) NOT NULL,
  `maritalStatus` varchar(20) NOT NULL,
  `contactNumber` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `religion` varchar(100) NOT NULL,
  `citizenship` varchar(100) NOT NULL,
  `region` varchar(100) NOT NULL,
  `province` varchar(100) NOT NULL,
  `municipality` varchar(100) NOT NULL,
  `bloodType` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tblregister`
--

INSERT INTO `tblregister` (`register_id`, `lastName`, `firstName`, `middleName`, `suffix`, `homeAddress`, `dateOfBirth`, `placeOfBirth`, `maritalStatus`, `contactNumber`, `email`, `religion`, `citizenship`, `region`, `province`, `municipality`, `bloodType`) VALUES
(22, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(23, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(24, 'maria', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(25, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(26, 'mae', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(27, 'cxf', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(28, 'jona', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(29, 'vxcx dfbv', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(30, 'ma', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(31, 'enlo', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(32, 'XCCXFC', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(33, 'szcs', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(34, 'kimmy', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(35, 'ann', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(36, 'hne', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(37, 'fdsdf', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(38, 'qedsf', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(39, 'dfsgddg', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(40, 'vdfd', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(41, 'Selma', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(42, 'bu', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(43, 'ewewrwtd', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(44, 'co', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(45, 'me', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(46, 'qw', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(47, 'rf', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(48, 'fghg', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(49, 'vcx', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(50, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(51, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tblsttudent`
--

CREATE TABLE `tblsttudent` (
  `studentID` int(11) NOT NULL,
  `department` varchar(255) NOT NULL,
  `program` varchar(255) NOT NULL,
  `yearLevel` varchar(255) NOT NULL,
  `register_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tblsttudent`
--

INSERT INTO `tblsttudent` (`studentID`, `department`, `program`, `yearLevel`, `register_id`) VALUES
(23240000, '', '', '', NULL),
(23240001, 'yh', 'ht', 'ghnh', NULL),
(23240002, 'yh', 'ht', 'ghnh', NULL),
(23240003, 'College of Computer Studies', 'Bachelor of Science in Information Technology', 'Second Year', NULL),
(23240004, 'College of Computer Studies', '', '', 31),
(23240005, '', 'Bachelor of Science in Computer Science', '', 31),
(23240006, 'College of Computer Studies', 'Bachelor of Science in Computer Science', 'First Year', 36),
(23240007, 'College of Computer Studies', 'Bachelor of Science in Information Technology', 'First Year', 37),
(23240008, 'College of Computer Studies', 'Bachelor of Science in Information Technology', 'Second Year', 38),
(23240009, 'College of Computer Studies', 'Bachelor of Science in Information Technology', 'Second Year', 39),
(23240010, 'College of Computer Studies', 'Bachelor of Science in Information Technology', 'Second Year', 40),
(23240011, 'College of Computer Studies', 'Bachelor of Science in Information Technology', 'Second Year', 41),
(23240012, 'College of Computer Studies', 'Bachelor of Science in Computer Science', 'First Year', 43),
(23240013, 'College of Computer Studies', 'Bachelor of Science in Computer Science', 'Third Year', 44);

-- --------------------------------------------------------

--
-- Table structure for table `tbluser`
--

CREATE TABLE `tbluser` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbluser`
--

INSERT INTO `tbluser` (`id`, `username`, `password`) VALUES
(1, '', ''),
(2, '', ''),
(3, '23240008', ''),
(4, '232400091', 'vdfd'),
(5, '232400101', 'Selma'),
(6, '23240012', 'ewewrwtd'),
(7, '23240013', 'co'),
(8, '10000001', ''),
(9, '10000002', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbladmin`
--
ALTER TABLE `tbladmin`
  ADD PRIMARY KEY (`adminID`);

--
-- Indexes for table `tblnewsletter`
--
ALTER TABLE `tblnewsletter`
  ADD PRIMARY KEY (`news_ID`);

--
-- Indexes for table `tblregister`
--
ALTER TABLE `tblregister`
  ADD PRIMARY KEY (`register_id`);

--
-- Indexes for table `tblsttudent`
--
ALTER TABLE `tblsttudent`
  ADD PRIMARY KEY (`studentID`);

--
-- Indexes for table `tbluser`
--
ALTER TABLE `tbluser`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbladmin`
--
ALTER TABLE `tbladmin`
  MODIFY `adminID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10000003;

--
-- AUTO_INCREMENT for table `tblnewsletter`
--
ALTER TABLE `tblnewsletter`
  MODIFY `news_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tblregister`
--
ALTER TABLE `tblregister`
  MODIFY `register_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `tblsttudent`
--
ALTER TABLE `tblsttudent`
  MODIFY `studentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23240014;

--
-- AUTO_INCREMENT for table `tbluser`
--
ALTER TABLE `tbluser`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
