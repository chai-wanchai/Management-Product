-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2016 at 11:00 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oop`
--

-- --------------------------------------------------------

--
-- Table structure for table `billing`
--

CREATE TABLE `billing` (
  `billing_id` int(5) NOT NULL,
  `billing_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `billing`
--

INSERT INTO `billing` (`billing_id`, `billing_date`) VALUES
(107, '2016-11-12 15:33:15'),
(1559, '2016-11-26 16:07:36'),
(1775, '2016-11-12 15:16:13'),
(1934, '2016-11-12 15:16:49'),
(2008, '2016-11-26 15:14:46'),
(2666, '2016-11-13 18:29:39'),
(3914, '2016-11-12 11:21:49'),
(4496, '2016-11-26 15:20:17'),
(4976, '2016-11-26 14:47:57'),
(5278, '2016-11-12 15:32:28'),
(5940, '2016-11-25 17:34:53'),
(7001, '2016-11-26 16:03:03'),
(7061, '2016-11-26 15:06:09'),
(7203, '2016-11-29 09:13:49'),
(7281, '2016-11-29 08:34:22'),
(7582, '2016-11-26 15:16:00'),
(7766, '2016-11-26 14:45:50'),
(8126, '2016-11-25 17:36:22'),
(8147, '2016-11-26 14:24:11'),
(9499, '2016-11-13 18:08:28'),
(9657, '2016-11-12 15:31:11');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` int(5) NOT NULL,
  `product_barcode` varchar(20) NOT NULL,
  `product_name` varchar(40) NOT NULL,
  `product_amount` int(5) NOT NULL,
  `product_price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `product_barcode`, `product_name`, `product_amount`, `product_price`) VALUES
(1, '8888336011981', 'สก็อตต์ เอ็กตร้าแคร์', 100, 16),
(2, '8851952350161', 'น้ำดื่มคริสตัล', 100, 7.5),
(3, '8850240101089', 'Polaris', 96, 10),
(4, '8854556000647', 'ปากกาลบคำผิด papermate', 100, 47),
(5, '8850039207558', 'กระดาษเช็ดหน้าคลีเน็กซ์', 96, 50),
(18, '471157701369', 'Pental ยางลบ', 100, 17),
(19, '8850774032514', 'สมุดพิมพ์เขียน MT555', 100, 5.25),
(20, '8858201011187', 'ดินสอHB ยี่ห้อ Sepia', 100, 17),
(21, '62528226814', 'ดินสอกด vivid color M&G', 100, 27),
(22, '8801456103626', 'ปากกาสี MC.44 ยี่ห้อ MyClor2', 100, 17),
(24, '8853002080004', 'ดีน่า งาดำ 2 เท่า', 100, 10),
(25, '8850123110818', 'เดลี่ แซนด์วิช ทูน่า', 100, 12),
(30, 'wanchai', 'nupinit', 100, 18.5),
(31, '555', 'วันชัย 5555', 100, 1),
(32, '147852369', 'xiaomi mi5s', 100, 10000.5),
(33, '369852147', 'cruzer blate 8GB', 100, 159.5),
(34, '55555', 'สบู่ปลาทอง', 100, 100);

-- --------------------------------------------------------

--
-- Table structure for table `sale`
--

CREATE TABLE `sale` (
  `billing_id` int(5) NOT NULL,
  `product_id` int(3) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sale`
--

INSERT INTO `sale` (`billing_id`, `product_id`, `amount`) VALUES
(107, 1, 50),
(1559, 4, 1),
(1559, 34, 1),
(1775, 1, 88),
(1934, 1, 8),
(1934, 18, 88),
(2008, 32, 1),
(2666, 26, 4),
(3914, 1, 10),
(3914, 18, 10),
(4496, 18, 15),
(4496, 20, 15),
(4976, 1, 44),
(5278, 1, 10),
(5940, 33, 2),
(7001, 1, 154),
(7001, 18, 154),
(7061, 1, 100),
(7061, 33, 100),
(7203, 3, 4),
(7203, 5, 4),
(7281, 18, 82),
(7582, 18, 14),
(7766, 33, 14),
(8126, 33, 50),
(8147, 1, 4),
(8147, 18, 4),
(8147, 26, 4),
(9499, 26, 5),
(9657, 1, 8);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `billing`
--
ALTER TABLE `billing`
  ADD PRIMARY KEY (`billing_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `sale`
--
ALTER TABLE `sale`
  ADD PRIMARY KEY (`billing_id`,`product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `sale`
--
ALTER TABLE `sale`
  MODIFY `billing_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9658;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
