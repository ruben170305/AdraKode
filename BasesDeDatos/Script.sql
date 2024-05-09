DROP TABLE juega;
DROP TABLE utiliza_personaje;
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
	cod INT PRIMARY KEY,
    nombre VARCHAR(50),
    personaje VARCHAR(50),
    raza VARCHAR(50),
    clase VARCHAR(50),
    expe INT,
	cod_miembro INT,
	CONSTRAINT FOREIGN KEY (cod_miembro) REFERENCES miembro(cod)
);
CREATE TABLE partida (
	cod INT PRIMARY KEY,
    num_sesion INT,
    nombre VARCHAR(50),
    duracion INT,
    dia VARCHAR(50),
    ambientacion VARCHAR(50),
    enCurso boolean,
    controlador INT,
    CONSTRAINT FOREIGN KEY (controlador) REFERENCES miembro(cod)
);
CREATE TABLE juega (
	id_partida INT,
    id_personaje INT,
    fuerza INT,
    destreza INT,
    constitucion INT,
    inteligencia INT,
    sabiduria INT,
    carisma INT,
    PRIMARY KEY (id_partida, id_personaje),
    CONSTRAINT FOREIGN KEY (id_partida) REFERENCES partida(cod),
    CONSTRAINT FOREIGN KEY (id_personaje) REFERENCES personaje(cod)
);

INSERT INTO miembro (cod, nombre, apellidos, pass, expediente, estudio) VALUES
(2001, 'John', 'Doe', 'pass', 12345, 'Ciencias Computacionales'),
(2002, 'Jane', 'Smith', 'pass', 12346, 'Ingeniería de Software'),
(2003, 'Alice', 'Johnson', 'pass', 12347, 'Diseño de Sistemas'),
(2004, 'Bob', 'Brown', 'pass', 12348, 'Ciencias de la Computación'),
(2005, 'Carol', 'White', 'pass', 12349, 'Seguridad Informática');

INSERT INTO personaje (cod, nombre, personaje, raza, clase, expe, cod_miembro) VALUES
(1001, 'Eldon', 'Glimmer', 'Elfo', 'Mago', 5000, 2001),
(1002, 'Mara', 'Nightshade', 'Humano', 'Ladrón', 4500, 2002),
(1003, 'Korin', 'Steelbrow', 'Enano', 'Guerrero', 5200, 2003),
(1004, 'Alya', 'Starfire', 'Elfo', 'Clerigo', 4800, 2004),
(1005, 'Borin', 'Hammerhand', 'Enano', 'Paladin', 5500, 2005);

INSERT INTO partida (cod, num_sesion, nombre, duracion, dia, ambientacion, enCurso, controlador) VALUES
(3001, 10, 'Amanecer de fuego', 180, 'Martes a las 17:00', 'Fantasía medieval', true, 2001),
(3002, 15, 'Crepúsculo gélido', 150, 'Martes a las 19:00', 'Fantasía gélida', false, 2002),
(3003, 20, 'La caída de la noche', 210, 'Miercoles a las 16:00', 'Fantasía oscura', true, 2003),
(3004, 25, 'El alba dorada', 160, 'Jueves a las 21:00', 'Fantasía clásica', false, 2004),
(3005, 30, 'Sombras persistentes', 190, 'Sábado a las 20:00', 'Fantasía steampunk', true, 2005);

INSERT INTO juega (id_partida, id_personaje, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma) VALUES
(3001, 1001, 12, 14, 13, 18, 15, 10),
(3002, 1002, 14, 18, 12, 14, 12, 16),
(3003, 1003, 18, 12, 17, 10, 13, 8),
(3004, 1004, 10, 12, 12, 16, 18, 14),
(3005, 1005, 16, 10, 18, 10, 12, 12);