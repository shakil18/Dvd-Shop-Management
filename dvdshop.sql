-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 13, 2016 at 04:19 AM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dvdshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE IF NOT EXISTS `admins` (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`admin_id`, `admin_name`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`user_id`, `user_name`, `password`) VALUES
(1, 'user1', 'user1'),
(2, 'user2', 'user2');

-- --------------------------------------------------------

--
-- Table structure for table `dvd`
--

CREATE TABLE IF NOT EXISTS `dvd` (
  `p_id` int(11) NOT NULL,
  `p_name` varchar(50) NOT NULL,
  `p_genre` varchar(50) NOT NULL,
  `p_year` int(11) NOT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dvd`
--

INSERT INTO `dvd` (`p_id`, `p_name`, `p_genre`, `p_year`, `price`, `quantity`) VALUES
(1, 'Saw I', 'Horror', 1990, 120, 100),
(2, 'Commando', 'Action', 1994, 100, 80),
(3, 'Sherlock Holmes', 'Drama', 2014, 140, 90),
(4, 'Avengers', 'Action', 2012, 140, 45),
(5, 'Final Destination I', 'Horror', 2004, 180, 100);

-- --------------------------------------------------------

--
-- Table structure for table `purchased`
--

CREATE TABLE IF NOT EXISTS `purchased` (
  `o_id` int(20) NOT NULL,
  `user_name` varchar(16) NOT NULL,
  `p_name` varchar(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchased`
--

INSERT INTO `purchased` (`o_id`, `user_name`, `p_name`, `quantity`, `price`) VALUES
(18, 'user2', 'Saw I', 1, 120),
(19, 'user2', 'Commando', 1, 100),
(20, 'user2', 'Sherlock Holmes', 1, 140);

-- --------------------------------------------------------

--
-- Table structure for table `reqdvd`
--

CREATE TABLE IF NOT EXISTS `reqdvd` (
  `req_id` int(20) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `msg` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reqdvd`
--

INSERT INTO `reqdvd` (`req_id`, `user_name`, `msg`) VALUES
(4, 'user1', 'shakil\r\n');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`admin_id`), ADD UNIQUE KEY `admin_name` (`admin_name`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`user_id`), ADD UNIQUE KEY `user_name` (`user_name`);

--
-- Indexes for table `dvd`
--
ALTER TABLE `dvd`
  ADD PRIMARY KEY (`p_id`);

--
-- Indexes for table `purchased`
--
ALTER TABLE `purchased`
  ADD PRIMARY KEY (`o_id`);

--
-- Indexes for table `reqdvd`
--
ALTER TABLE `reqdvd`
  ADD PRIMARY KEY (`req_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `dvd`
--
ALTER TABLE `dvd`
  MODIFY `p_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `purchased`
--
ALTER TABLE `purchased`
  MODIFY `o_id` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `reqdvd`
--
ALTER TABLE `reqdvd`
  MODIFY `req_id` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
