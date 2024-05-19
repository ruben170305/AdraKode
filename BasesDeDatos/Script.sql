DROP TABLE juega;
-- DROP TABLE utiliza_personaje;
DROP TABLE partida;
DROP TABLE personaje;
DROP TABLE miembro;
CREATE TABLE miembro (
	cod INT PRIMARY KEY,
    nombre VARCHAR(50),
    apellidos VARCHAR(50),
    pass VARCHAR(50),
    expediente INT,
    estudio VARCHAR(50)
);
CREATE TABLE personaje (
	cod INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    personaje VARCHAR(50),
    raza VARCHAR(50),
    clase VARCHAR(50),
    expe INT,
    fuerza INT,
    destreza INT,
    constitucion INT,
    inteligencia INT,
    sabiduria INT,
    carisma INT,
	cod_miembro INT,
	CONSTRAINT FOREIGN KEY (cod_miembro) REFERENCES miembro(cod)
);
CREATE TABLE partida (
	partida_id INT AUTO_INCREMENT PRIMARY KEY,
    num_sesion INT,
    nombre VARCHAR(50),
    duracion INT,
	dificultad int(11),
    fecha VARCHAR(50),
    numero_jugadores int(11),
    ambientacion VARCHAR(50),
    en_curso boolean,
    anfitrion_id INT,
    CONSTRAINT FOREIGN KEY (anfitrion_id) REFERENCES miembro(cod)
);
CREATE TABLE juega (
	id_partida INT,
    id_personaje INT,
    PRIMARY KEY (id_partida, id_personaje),
    CONSTRAINT FOREIGN KEY (id_partida) REFERENCES partida(partida_id),
    CONSTRAINT FOREIGN KEY (id_personaje) REFERENCES personaje(cod)
);

INSERT INTO miembro (cod, nombre, apellidos, pass, expediente, estudio) VALUES
(2001, 'John', 'Doe', 'pass', 12345, 'Ciencias Computacionales'),
(2002, 'Jane', 'Smith', 'pass', 12346, 'Ingeniería de Software'),
(2003, 'Alice', 'Johnson', 'pass', 12347, 'Diseño de Sistemas'),
(2004, 'Bob', 'Brown', 'pass', 12348, 'Ciencias de la Computación'),
(2005, 'Carol', 'White', 'pass', 12349, 'Seguridad Informática');

INSERT INTO personaje (nombre, personaje, raza, clase, expe, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma, cod_miembro) VALUES
('Eldon', 'Glimmer', 'Elfo', 'Mago', 10, 12, 14, 13, 18, 15, 10, 2001),
('Mara', 'Nightshade', 'Humano', 'Ladrón', 20, 14, 18, 12, 14, 12, 16, 2002),
('Korin', 'Steelbrow', 'Enano', 'Guerrero', 30, 18, 12, 17, 10, 13, 8, 2003),
('Alya', 'Starfire', 'Elfo', 'Clerigo', 10, 10, 12, 12, 16, 18, 14, 2004),
('Borin', 'Hammerhand', 'Enano', 'Paladin', 15, 16, 10, 18, 10, 12, 12, 2005);

INSERT INTO partida (`partida_id`, `num_sesion`, `nombre`, `duracion`, `dificultad`, `fecha`, `numero_jugadores`, `ambientacion`, `en_curso`, `anfitrion_id`) VALUES
(3001, 10, 'Amanecer de fuego', 180, 0, 'Martes a las 17:00', 4, 'Fantasía medieval', 1, 2001),
(3002, 15, 'Crepúsculo gélido', 150, 0, 'Martes a las 19:00', 4, 'Fantasía gélida', 0, 2002),
(3003, 20, 'La caída de la noche', 210, 0, 'Miercoles a las 16:00', 4, 'Fantasía oscura', 1, 2003),
(3004, 25, 'El alba dorada', 160, 0, 'Jueves a las 21:00', 4, 'Fantasía clásica', 0, 2004),
(3005, 30, 'Sombras persistentes', 190, 0, 'Sábado a las 20:00', 4, 'Fantasía steampunk', 1, 2005);
