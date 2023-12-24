-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 24, 2023 at 03:58 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `account_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `account_tbl`
--

CREATE TABLE `account_tbl` (
  `id_account` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `balance` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account_tbl`
--

INSERT INTO `account_tbl` (`id_account`, `username`, `email`, `password`, `balance`) VALUES
(2, 'a', 'a', 'a', 100000),
(4, 'd', 'd', 'd', 100000),
(6, 'e', 'e', 'e', 100000),
(7, 'q', 'q', 'q', 100000),
(8, 'f', 'f', 'f', 100000),
(9, 'dev', 'dev', 'dev', 100000),
(10, 'devin', 'devin', 'devin', 100000);

-- --------------------------------------------------------

--
-- Table structure for table `cart_tbl`
--

CREATE TABLE `cart_tbl` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_produk` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cart_tbl`
--

INSERT INTO `cart_tbl` (`id`, `id_user`, `id_produk`, `quantity`) VALUES
(4, 2, 1, 5),
(5, 2, 1, 5),
(6, 2, 1, 5),
(7, 2, 1, 5),
(8, 2, 1, 5),
(9, 2, 1, 5),
(10, 2, 1, 5),
(11, 2, 1, 5),
(12, 2, 1, 6),
(13, 2, 1, 5),
(14, 2, 1, 5),
(15, 2, 1, 5),
(16, 2, 1, 5),
(17, 2, 1, 5),
(18, 2, 1, 4),
(19, 2, 1, 4),
(20, 2, 1, 6),
(21, 2, 1, 4),
(22, 2, 1, 3),
(23, 2, 1, 4),
(24, 2, 1, 4),
(25, 2, 1, 4),
(26, 2, 1, 3),
(27, 2, 1, 3),
(28, 2, 1, 3),
(29, 2, 1, 3),
(30, 2, 1, 3),
(31, 2, 1, 3),
(32, 2, 1, 4),
(33, 2, 1, 3),
(34, 2, 1, 1),
(35, 4, 1, 5),
(36, 4, 1, 1),
(37, 2, 1, 4),
(38, 7, 1, 5),
(39, 8, 1, 4),
(40, 8, 1, 3),
(41, 8, 1, 1),
(42, 8, 1, 1),
(43, 8, 1, 3),
(44, 8, 1, 4),
(45, 8, 1, 3),
(46, 2, 1, 3),
(47, 2, 1, 4),
(48, 9, 1, 4),
(49, 2, 1, 4),
(50, 10, 1, 4),
(51, 10, 1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `produk_tbl`
--

CREATE TABLE `produk_tbl` (
  `id_barang` int(2) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `stok_barang` int(2) NOT NULL,
  `harga_barang` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `produk_tbl`
--

INSERT INTO `produk_tbl` (`id_barang`, `nama_barang`, `stok_barang`, `harga_barang`) VALUES
(1, 'Indomie Kuah Kari Ayam', 7, 3100),
(2, 'Indomie Goreng Rendang', 30, 3100),
(3, 'Pocky Cookies n Cream', 25, 8700),
(4, 'Pocky Matcha', 35, 8700),
(5, 'Samyang Buldak Original', 20, 23900),
(6, 'Samyang Buldak Carbonara', 20, 21900),
(7, 'Daia Detergen Bubuk Putih', 40, 10000),
(8, 'Rinso Detergen', 40, 10000),
(9, 'Nu Greentea Original', 50, 4900),
(10, 'Thai Milk Green Tea', 50, 9100);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account_tbl`
--
ALTER TABLE `account_tbl`
  ADD PRIMARY KEY (`id_account`);

--
-- Indexes for table `cart_tbl`
--
ALTER TABLE `cart_tbl`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idUser` (`id_user`),
  ADD KEY `idProduk` (`id_produk`);

--
-- Indexes for table `produk_tbl`
--
ALTER TABLE `produk_tbl`
  ADD PRIMARY KEY (`id_barang`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account_tbl`
--
ALTER TABLE `account_tbl`
  MODIFY `id_account` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `cart_tbl`
--
ALTER TABLE `cart_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `produk_tbl`
--
ALTER TABLE `produk_tbl`
  MODIFY `id_barang` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cart_tbl`
--
ALTER TABLE `cart_tbl`
  ADD CONSTRAINT `idProduk` FOREIGN KEY (`id_produk`) REFERENCES `produk_tbl` (`id_barang`),
  ADD CONSTRAINT `idUser` FOREIGN KEY (`id_user`) REFERENCES `account_tbl` (`id_account`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
