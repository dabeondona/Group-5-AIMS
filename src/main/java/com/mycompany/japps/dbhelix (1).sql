-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2023 at 05:07 PM
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
  `institutionalEmail` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbladmin`
--

INSERT INTO `tbladmin` (`adminID`, `jobTitle`, `position`, `institutionalEmail`) VALUES
(1, '', '', ''),
(2, '', '', ''),
(10000, '', '', ''),
(10001, 'fgdfdddg', 'dgd', 'gh'),
(10002, 'ytyy', 'y', 'y'),
(10003, '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tblregister`
--

CREATE TABLE `tblregister` (
  `id` int(11) NOT NULL,
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

INSERT INTO `tblregister` (`id`, `lastName`, `firstName`, `middleName`, `suffix`, `homeAddress`, `dateOfBirth`, `placeOfBirth`, `maritalStatus`, `contactNumber`, `email`, `religion`, `citizenship`, `region`, `province`, `municipality`, `bloodType`) VALUES
(1, 'Selma', 'Kheisa', '', '', 'Sangi', 'February 27, 2003', 'Minglanilla, Cebu', 'Single', '123455', 'gjhgjghjm', 'ff nfn', 'bnfh ght', 'dfbhgnh', 'fg', 'vffgd', 'o'),
(3, 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v'),
(4, 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v'),
(5, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(6, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(7, 'hg', 'gg', 'gg', 'ff', 'gg', ',', ',m', 'Single', ',m', 'n', 'n', 'n', 'Region III', 'Region IV‑A', 'Region III', 'A Negative'),
(8, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(9, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(10, 'hg', 'hg', 'hh', 'h', 'h', 'h', 'h', 'Married', 'h', 'h', 'h', 'h', 'Region III', 'Region II', 'Region I', 'A Positive'),
(11, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(12, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(13, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(14, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(15, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(16, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(17, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(18, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(19, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(20, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(21, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tblsttudent`
--

CREATE TABLE `tblsttudent` (
  `studentID` int(11) NOT NULL,
  `department` varchar(255) NOT NULL,
  `program` varchar(255) NOT NULL,
  `yearLevel` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tblsttudent`
--

INSERT INTO `tblsttudent` (`studentID`, `department`, `program`, `yearLevel`) VALUES
(23240000, '', '', ''),
(23240001, 'yh', 'ht', 'ghnh'),
(23240002, 'yh', 'ht', 'ghnh'),
(23240003, 'College of Computer Studies', 'Bachelor of Science in Information Technology', 'Second Year');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbladmin`
--
ALTER TABLE `tbladmin`
  ADD PRIMARY KEY (`adminID`);

--
-- Indexes for table `tblregister`
--
ALTER TABLE `tblregister`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tblsttudent`
--
ALTER TABLE `tblsttudent`
  ADD PRIMARY KEY (`studentID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbladmin`
--
ALTER TABLE `tbladmin`
  MODIFY `adminID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10004;

--
-- AUTO_INCREMENT for table `tblregister`
--
ALTER TABLE `tblregister`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `tblsttudent`
--
ALTER TABLE `tblsttudent`
  MODIFY `studentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23240004;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
