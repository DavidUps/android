-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 25, 2018 at 05:53 PM
-- Server version: 5.6.34-log
-- PHP Version: 7.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_prueba`
--

-- --------------------------------------------------------

--
-- Table structure for table `registry`
--

CREATE TABLE `registry` (
  `id` int(11) NOT NULL,
  `email` varchar(40) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registry`
--

INSERT INTO `registry` (`id`, `email`, `NAME`, `PASSWORD`) VALUES
(1, 'davidarribasc@gmail.com', 'david', '1234'),
(2, 'pacofenandez@gmail.com', 'paco', '1234'),
(3, 'mariagomez@gmail.com', 'maria', 'Maria1234.'),
(4, 'davidarribasc@gmail.com', 'david', '1234'),
(5, 'pacocamela@gmail.com', 'paco', '1234'),
(6, 'd@gmail.com', 'd', '1234'),
(7, 'd@gmail.com', 'd', '1234'),
(8, 'h@gmail.clm', 'h', '1234'),
(9, 'g', 'g', '13'),
(10, 'davidarribasc@gmail.com', 'david', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `registry`
--
ALTER TABLE `registry`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `registry`
--
ALTER TABLE `registry`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
