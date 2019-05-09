-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 
-- サーバのバージョン： 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `taskmanagement`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- テーブルのデータのダンプ `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(21),
(21);

-- --------------------------------------------------------

--
-- テーブルの構造 `statusdata`
--

CREATE TABLE `statusdata` (
  `statuscd` int(11) NOT NULL,
  `statusname` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- テーブルのデータのダンプ `statusdata`
--

INSERT INTO `statusdata` (`statuscd`, `statusname`) VALUES
(0, '未着手'),
(4, '完了'),
(2, '待機中'),
(1, '対応中'),
(3, '取消');

-- --------------------------------------------------------

--
-- テーブルの構造 `statusdata_task_datas`
--

CREATE TABLE `statusdata_task_datas` (
  `status_data_statuscd` int(11) NOT NULL,
  `task_datas_taskno` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- テーブルの構造 `taskdata`
--

CREATE TABLE `taskdata` (
  `taskno` bigint(20) NOT NULL,
  `due` varchar(255) DEFAULT NULL,
  `planfrom` varchar(255) NOT NULL,
  `planto` varchar(255) DEFAULT NULL,
  `projectcd` varchar(255) NOT NULL,
  `statuscd` int(11) DEFAULT NULL,
  `task` varchar(255) NOT NULL,
  `taskdetails` varchar(255) NOT NULL,
  `userno` bigint(20) NOT NULL,
  `status_data_statuscd` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- テーブルのデータのダンプ `taskdata`
--

INSERT INTO `taskdata` (`taskno`, `due`, `planfrom`, `planto`, `projectcd`, `statuscd`, `task`, `taskdetails`, `userno`, `status_data_statuscd`) VALUES
(10, '2019-05-09', '2019-05-09', '2019-05-09', 'テスト', NULL, 'テストタスク', 'テストタスクを入力', 0, 2),
(14, '2019-05-09', '2019-05-09', '2019-05-09', 'テスト', NULL, 'テスト', 'あああ', 0, 1),
(16, '2019-05-09', '2019-05-09', '2019-05-09', 'テスト', NULL, 'テスト', 'あああ', 0, 2),
(17, '2019-05-09', '2019-05-09', '2019-05-09', 'テスト', NULL, 'あああ', 'ｓｄｄｄ', 0, 1);

-- --------------------------------------------------------

--
-- テーブルの構造 `userdata`
--

CREATE TABLE `userdata` (
  `userNo` int(11) NOT NULL,
  `loginId` text NOT NULL,
  `password` text NOT NULL,
  `userName` text NOT NULL,
  `statusname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- テーブルのデータのダンプ `userdata`
--

INSERT INTO `userdata` (`userNo`, `loginId`, `password`, `userName`, `statusname`) VALUES
(1, 'kymx1983', 'rvog0197', '小山雄太', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `statusdata`
--
ALTER TABLE `statusdata`
  ADD PRIMARY KEY (`statuscd`);

--
-- Indexes for table `statusdata_task_datas`
--
ALTER TABLE `statusdata_task_datas`
  ADD UNIQUE KEY `UK_p27y79mcyqwn93t3ptm945xev` (`task_datas_taskno`),
  ADD KEY `FKi0q2qb0s4theli4vcjspugce6` (`status_data_statuscd`);

--
-- Indexes for table `taskdata`
--
ALTER TABLE `taskdata`
  ADD PRIMARY KEY (`taskno`),
  ADD KEY `FKsosuutpa9x5lcqjlvadmbtsv1` (`status_data_statuscd`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
