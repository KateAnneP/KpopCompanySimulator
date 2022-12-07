-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Czas generowania: 29 Maj 2022, 23:33
-- Wersja serwera: 10.5.15-MariaDB-0ubuntu0.21.10.1
-- Wersja PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `kpop`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `grupy`
--

CREATE TABLE `grupy` (
  `id` int(11) NOT NULL,
  `nazwa` text NOT NULL,
  `hp` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `fani` int(11) NOT NULL,
  `piosenki` int(11) NOT NULL,
  `kontrakt` int(11) NOT NULL,
  `wytwornia` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `grupy`
--

INSERT INTO `grupy` (`id`, `nazwa`, `hp`, `dni`, `fani`, `piosenki`, `kontrakt`, `wytwornia`) VALUES
(5, 'Astro', 1000, 25, 427, 16, 1794, 'JYP'),
(6, 'Astro', 1000, 25, 491, 16, 1794, 'Kate'),
(8, 'TXT', 1000, 10, 428, 7, 1805, 'Kate'),
(17, 'NCT Dream', 1000, 22, 246, 1, 1805, 'Kate');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `idole`
--

CREATE TABLE `idole` (
  `id` int(11) NOT NULL,
  `imie` text NOT NULL,
  `wiek` int(11) NOT NULL,
  `pozycja` text NOT NULL,
  `grupa` text NOT NULL,
  `wytwornia` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `idole`
--

INSERT INTO `idole` (`id`, `imie`, `wiek`, `pozycja`, `grupa`, `wytwornia`) VALUES
(16, 'Dongmin', 17, 'leader', 'Astro', 'JYP'),
(17, 'Chaejong', 23, 'lead vocal', 'Astro', 'JYP'),
(18, 'Naerin', 17, 'sub-vocalist', 'Astro', 'JYP'),
(19, 'Chaemin', 15, 'lead dancer', 'Astro', 'JYP'),
(20, 'Sunjong', 21, 'lead dancer', 'Astro', 'JYP'),
(21, 'Minyun', 22, 'leader', 'Astro', 'Kate'),
(22, 'Jechul', 15, 'main dancer', 'Astro', 'Kate'),
(23, 'Taemun', 20, 'lead vocal', 'Astro', 'Kate'),
(24, 'Heejoon', 20, 'visual', 'Astro', 'Kate'),
(25, 'Dongchul', 24, 'visual', 'Astro', 'Kate'),
(31, 'Soonbin', 17, 'leader', 'TXT', 'Kate'),
(32, 'Hyunjin', 19, 'lead dancer', 'TXT', 'Kate'),
(33, 'Jimin', 19, 'main vocal', 'TXT', 'Kate'),
(34, 'Namjoon', 20, 'main dancer', 'TXT', 'Kate'),
(35, 'Bangchan', 17, 'sub-vocalist', 'TXT', 'Kate'),
(36, 'Hanjin', 18, 'center', 'TXT', 'Kate'),
(93, 'Sorin', 21, 'leader', 'NCT Dream', 'Kate'),
(94, 'Jirin', 20, 'main dancer', 'NCT Dream', 'Kate'),
(95, 'Naehwa', 15, 'lead vocal', 'NCT Dream', 'Kate'),
(96, 'Wonjin', 18, 'center', 'NCT Dream', 'Kate'),
(97, 'Wonmun', 23, 'sub-vocalist', 'NCT Dream', 'Kate'),
(98, 'Heehwa', 22, 'center', 'NCT Dream', 'Kate'),
(99, 'Taerin', 16, 'center', 'NCT Dream', 'Kate');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `nick` text NOT NULL,
  `haslo` text NOT NULL,
  `fundusze` double NOT NULL,
  `dni` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`id`, `nick`, `haslo`, `fundusze`, `dni`) VALUES
(7, 'JYP', '1234', 10000, 1),
(8, 'Kate', '1234', 8300, 48);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `grupy`
--
ALTER TABLE `grupy`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `idole`
--
ALTER TABLE `idole`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `grupy`
--
ALTER TABLE `grupy`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT dla tabeli `idole`
--
ALTER TABLE `idole`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;

--
-- AUTO_INCREMENT dla tabeli `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
