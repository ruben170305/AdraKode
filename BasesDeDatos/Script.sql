-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 16-05-2024 a las 09:18:25
-- Versión del servidor: 10.11.6-MariaDB-0+deb12u1
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `kode`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juega`
--

CREATE TABLE `juega` (
  `id_partida` int(11) NOT NULL,
  `id_personaje` int(11) NOT NULL,
  `fuerza` int(11) DEFAULT NULL,
  `destreza` int(11) DEFAULT NULL,
  `constitucion` int(11) DEFAULT NULL,
  `inteligencia` int(11) DEFAULT NULL,
  `sabiduria` int(11) DEFAULT NULL,
  `carisma` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `juega`
--

INSERT INTO `juega` (`id_partida`, `id_personaje`, `fuerza`, `destreza`, `constitucion`, `inteligencia`, `sabiduria`, `carisma`) VALUES
(3001, 1001, 12, 14, 13, 18, 15, 10),
(3002, 1002, 14, 18, 12, 14, 12, 16),
(3003, 1003, 18, 12, 17, 10, 13, 8),
(3004, 1004, 10, 12, 12, 16, 18, 14),
(3005, 1005, 16, 10, 18, 10, 12, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `miembro`
--

CREATE TABLE `miembro` (
  `cod` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `expediente` int(11) DEFAULT NULL,
  `estudio` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `miembro`
--

INSERT INTO `miembro` (`cod`, `nombre`, `apellidos`, `pass`, `expediente`, `estudio`) VALUES
(2001, 'John', 'Doe', 'pass', 12345, 'Ciencias Computacionales'),
(2002, 'Jane', 'Smith', 'pass', 12346, 'Ingeniería de Software'),
(2003, 'Alice', 'Johnson', 'pass', 12347, 'Diseño de Sistemas'),
(2004, 'Bob', 'Brown', 'pass', 12348, 'Ciencias de la Computación'),
(2005, 'Carol', 'White', 'pass', 12349, 'Seguridad Informática');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partida`
--

CREATE TABLE `partida` (
  `partida_id` int(11) NOT NULL,
  `num_sesion` int(11) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `duracion` int(11) DEFAULT NULL,
  `dificultad` int(11) NOT NULL,
  `fecha` varchar(50) DEFAULT NULL,
  `numero_jugadores` int(11) NOT NULL,
  `ambientacion` varchar(50) DEFAULT NULL,
  `en_curso` tinyint(1) DEFAULT NULL,
  `anfitrion_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `partida`
--

INSERT INTO `partida` (`partida_id`, `num_sesion`, `nombre`, `duracion`, `dificultad`, `fecha`, `numero_jugadores`, `ambientacion`, `en_curso`, `anfitrion_id`) VALUES
(3001, 10, 'Amanecer de fuego', 180, 0, 'Martes a las 17:00', 4, 'Fantasía medieval', 1, 2001),
(3002, 15, 'Crepúsculo gélido', 150, 0, 'Martes a las 19:00', 4, 'Fantasía gélida', 0, 2002),
(3003, 20, 'La caída de la noche', 210, 0, 'Miercoles a las 16:00', 4, 'Fantasía oscura', 1, 2003),
(3004, 25, 'El alba dorada', 160, 0, 'Jueves a las 21:00', 4, 'Fantasía clásica', 0, 2004),
(3005, 30, 'Sombras persistentes', 190, 0, 'Sábado a las 20:00', 4, 'Fantasía steampunk', 1, 2005);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personaje`
--

CREATE TABLE `personaje` (
  `cod` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `personaje` varchar(50) DEFAULT NULL,
  `raza` varchar(50) DEFAULT NULL,
  `clase` varchar(50) DEFAULT NULL,
  `expe` int(11) DEFAULT NULL,
  `cod_miembro` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `personaje`
--

INSERT INTO `personaje` (`cod`, `nombre`, `personaje`, `raza`, `clase`, `expe`, `cod_miembro`) VALUES
(1001, 'Eldon', 'Glimmer', 'Elfo', 'Mago', 5000, 2001),
(1002, 'Mara', 'Nightshade', 'Humano', 'Ladrón', 4500, 2002),
(1003, 'Korin', 'Steelbrow', 'Enano', 'Guerrero', 5200, 2003),
(1004, 'Alya', 'Starfire', 'Elfo', 'Clerigo', 4800, 2004),
(1005, 'Borin', 'Hammerhand', 'Enano', 'Paladin', 5500, 2005);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `juega`
--
ALTER TABLE `juega`
  ADD PRIMARY KEY (`id_partida`,`id_personaje`),
  ADD KEY `id_personaje` (`id_personaje`);

--
-- Indices de la tabla `miembro`
--
ALTER TABLE `miembro`
  ADD PRIMARY KEY (`cod`);

--
-- Indices de la tabla `partida`
--
ALTER TABLE `partida`
  ADD PRIMARY KEY (`partida_id`),
  ADD KEY `controlador` (`anfitrion_id`);

--
-- Indices de la tabla `personaje`
--
ALTER TABLE `personaje`
  ADD PRIMARY KEY (`cod`),
  ADD KEY `cod_miembro` (`cod_miembro`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `partida`
--
ALTER TABLE `partida`
  MODIFY `partida_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3006;

--
-- AUTO_INCREMENT de la tabla `personaje`
--
ALTER TABLE `personaje`
  MODIFY `cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1006;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `juega`
--
ALTER TABLE `juega`
  ADD CONSTRAINT `juega_ibfk_1` FOREIGN KEY (`id_partida`) REFERENCES `partida` (`partida_id`),
  ADD CONSTRAINT `juega_ibfk_2` FOREIGN KEY (`id_personaje`) REFERENCES `personaje` (`cod`);

--
-- Filtros para la tabla `partida`
--
ALTER TABLE `partida`
  ADD CONSTRAINT `partida_ibfk_1` FOREIGN KEY (`anfitrion_id`) REFERENCES `miembro` (`cod`);

--
-- Filtros para la tabla `personaje`
--
ALTER TABLE `personaje`
  ADD CONSTRAINT `personaje_ibfk_1` FOREIGN KEY (`cod_miembro`) REFERENCES `miembro` (`cod`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
