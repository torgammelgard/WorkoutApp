-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Värd: 127.0.0.1
-- Tid vid skapande: 16 mars 2016 kl 09:07
-- Serverversion: 10.1.10-MariaDB
-- PHP-version: 7.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databas: `sql_project`
--

-- --------------------------------------------------------

--
-- Tabellstruktur `exercises`
--

CREATE TABLE `exercises` (
  `id` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `description` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumpning av Data i tabell `exercises`
--

INSERT INTO `exercises` (`id`, `name`, `description`) VALUES
(1, 'Bench Press', 'Good'),
(2, 'Bent Over Row', 'Rowing'),
(3, 'Squat', 'Felt good'),
(4, 'Dips', '-'),
(5, 'Leg Curl', 'Max out'),
(6, 'Pull-Ups', 'Pull'),
(7, 'Seated Calf Raise', '-'),
(8, 'Swiss Ball Crunch', '-'),
(9, 'Deadlift', '-'),
(10, 'Barbell Curl', '-'),
(11, 'Tricep Cable Pressdown', '-'),
(12, 'Abs', '-'),
(13, 'Back Extension', '-'),
(14, 'Lunges', '-'),
(15, 'Romanian Deadlift', '-'),
(16, 'Shoulder Shrugs', '-'),
(17, 'Lat Pull-Downs', '-'),
(18, 'Scull Crushers', '-'),
(19, 'Parallel Bar Dips', '-'),
(20, 'Dumbbell Chest Flys', '-'),
(21, 'Weighted Chin-Ups', '-'),
(22, 'Calf Press', '-');

-- --------------------------------------------------------

--
-- Tabellstruktur `workouts`
--

CREATE TABLE `workouts` (
  `id` int(11) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `type` varchar(32) DEFAULT NULL,
  `info` text,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumpning av Data i tabell `workouts`
--

INSERT INTO `workouts` (`id`, `name`, `type`, `info`, `date`) VALUES
(1, 'Monday ', 'Upper Body A', 'Went great', '2016-03-03'),
(2, 'Tuesday', 'Lower Body A', 'Feeling strong', '1970-01-01'),
(3, 'Thursday', 'Upper Body B', 'Oh yes', '1970-01-01'),
(4, 'Friday', 'Lower Body B', '', '1970-01-01');

-- --------------------------------------------------------

--
-- Tabellstruktur `workouts_exercises`
--

CREATE TABLE `workouts_exercises` (
  `workout_id` int(11) NOT NULL,
  `exercise_id` int(11) NOT NULL,
  `sets` int(11) DEFAULT NULL,
  `reps` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumpning av Data i tabell `workouts_exercises`
--

INSERT INTO `workouts_exercises` (`workout_id`, `exercise_id`, `sets`, `reps`, `weight`) VALUES
(1, 1, 3, 10, 50),
(1, 7, 4, 20, 15),
(1, 14, 3, 14, 5),
(2, 2, 4, 15, 20),
(2, 12, 4, 30, 5),
(2, 15, 3, 5, 10),
(3, 3, 3, 3, 18),
(3, 16, 5, 20, 10),
(3, 22, 5, 25, 8),
(4, 4, 5, 25, 10),
(4, 5, 3, 15, 10),
(4, 6, 3, 18, 5);

--
-- Index för dumpade tabeller
--

--
-- Index för tabell `exercises`
--
ALTER TABLE `exercises`
  ADD PRIMARY KEY (`id`);

--
-- Index för tabell `workouts`
--
ALTER TABLE `workouts`
  ADD PRIMARY KEY (`id`);

--
-- Index för tabell `workouts_exercises`
--
ALTER TABLE `workouts_exercises`
  ADD PRIMARY KEY (`workout_id`,`exercise_id`),
  ADD KEY `exercise_id` (`exercise_id`);

--
-- AUTO_INCREMENT för dumpade tabeller
--

--
-- AUTO_INCREMENT för tabell `exercises`
--
ALTER TABLE `exercises`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT för tabell `workouts`
--
ALTER TABLE `workouts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Restriktioner för dumpade tabeller
--

--
-- Restriktioner för tabell `workouts_exercises`
--
ALTER TABLE `workouts_exercises`
  ADD CONSTRAINT `workouts_exercises_ibfk_1` FOREIGN KEY (`workout_id`) REFERENCES `workouts` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `workouts_exercises_ibfk_2` FOREIGN KEY (`exercise_id`) REFERENCES `exercises` (`id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
