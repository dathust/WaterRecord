-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 12, 2018 at 09:11 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `waterrecord`
--

-- --------------------------------------------------------

--
-- Table structure for table `banggia`
--

CREATE TABLE `banggia` (
  `MA_BG` int(11) NOT NULL,
  `TEN_BANG_GIA` varchar(20) NOT NULL,
  `TEN_VIET_TAT` varchar(4) NOT NULL,
  `DON_GIA` int(11) NOT NULL,
  `THUE_VAT` int(11) NOT NULL,
  `THUE` int(11) NOT NULL,
  `GIA_BAN` int(11) NOT NULL,
  `XOA` int(11) NOT NULL DEFAULT '0' COMMENT '1=DELETE'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `MA_KH` int(11) NOT NULL,
  `TEN_KH` varchar(50) NOT NULL COMMENT 'Ho va Ten',
  `TEN_KHAC` varchar(50) NOT NULL,
  `DIA_CHI` varchar(60) NOT NULL,
  `DIEN_THOAI` int(11) NOT NULL,
  `MA_SO_THUE` varchar(11) NOT NULL,
  `MA_SO_DONG_HO` int(11) NOT NULL,
  `MA_BG` int(11) NOT NULL COMMENT 'Ma Bang Gia',
  `MA_TRAM` int(11) NOT NULL,
  `TONG_SO` int(11) NOT NULL,
  `TOA_DO_X` float DEFAULT NULL,
  `TOA_DO_Y` float DEFAULT NULL,
  `GHI_CHU` varchar(255) NOT NULL,
  `XOA` int(11) NOT NULL DEFAULT '0' COMMENT '1=DELETE'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MA_NV` int(11) NOT NULL,
  `TEN_NV` varchar(50) NOT NULL,
  `SO_DIEN_THOAI` int(11) NOT NULL,
  `DIA_CHI` varchar(60) NOT NULL,
  `TAI_KHOAN` varchar(20) NOT NULL,
  `MAT_KHAU` varchar(20) NOT NULL,
  `XOA` int(11) NOT NULL DEFAULT '0' COMMENT '1=DELETE'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `soghi`
--

CREATE TABLE `soghi` (
  `MA_SG` int(11) NOT NULL,
  `MA_KH` int(11) NOT NULL,
  `TEN_KH` varchar(50) NOT NULL,
  `MA_NV` int(11) NOT NULL,
  `CHI_SO` int(11) NOT NULL,
  `CHI_PHI` int(11) NOT NULL DEFAULT '0',
  `NGAY_GHI_SO` date NOT NULL,
  `THUE` float NOT NULL DEFAULT '0.05',
  `GHI_CHU` varchar(255) DEFAULT NULL,
  `XOA` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1=DELETE'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tram`
--

CREATE TABLE `tram` (
  `MA_TRAM` int(11) NOT NULL,
  `TEN_TRAM` varchar(7) NOT NULL,
  `DIA_CHI` varchar(60) NOT NULL,
  `TONG_KH` int(11) NOT NULL,
  `XOA` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1=DELETE'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tram`
--

INSERT INTO `tram` (`MA_TRAM`, `TEN_TRAM`, `DIA_CHI`, `TONG_KH`, `XOA`) VALUES
(1, 'Trạm 1', 'Đoàn Ái - Thống Nhất - Gia Lộc - Hải Dương', 10, 0),
(2, 'Trạm 2', 'Quang Trung - Thống Nhất - Gia Lộc - Hải Dương', 15, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `banggia`
--
ALTER TABLE `banggia`
  ADD PRIMARY KEY (`MA_BG`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MA_KH`),
  ADD KEY `FK_KH_TRAM` (`MA_TRAM`),
  ADD KEY `FK_KH_BG` (`MA_BG`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MA_NV`);

--
-- Indexes for table `soghi`
--
ALTER TABLE `soghi`
  ADD PRIMARY KEY (`MA_SG`),
  ADD KEY `FK_SG_KH` (`MA_KH`),
  ADD KEY `FK_SG_NV` (`MA_NV`);

--
-- Indexes for table `tram`
--
ALTER TABLE `tram`
  ADD PRIMARY KEY (`MA_TRAM`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `banggia`
--
ALTER TABLE `banggia`
  MODIFY `MA_BG` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `MA_KH` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `MA_NV` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `soghi`
--
ALTER TABLE `soghi`
  MODIFY `MA_SG` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tram`
--
ALTER TABLE `tram`
  MODIFY `MA_TRAM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD CONSTRAINT `FK_KH_BG` FOREIGN KEY (`MA_BG`) REFERENCES `banggia` (`MA_BG`),
  ADD CONSTRAINT `FK_KH_TRAM` FOREIGN KEY (`MA_TRAM`) REFERENCES `tram` (`MA_TRAM`);

--
-- Constraints for table `soghi`
--
ALTER TABLE `soghi`
  ADD CONSTRAINT `FK_SG_KH` FOREIGN KEY (`MA_KH`) REFERENCES `khachhang` (`MA_KH`),
  ADD CONSTRAINT `FK_SG_NV` FOREIGN KEY (`MA_NV`) REFERENCES `nhanvien` (`MA_NV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
