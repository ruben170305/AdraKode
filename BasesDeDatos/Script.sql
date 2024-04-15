DROP TABLE juega;
DROP TABLE utiliza_personaje;
DROP TABLE partida;
DROP TABLE miembro;
DROP TABLE personaje;
CREATE TABLE personaje (
	cod INT PRIMARY KEY,
    nombre VARCHAR(50),
    personaje VARCHAR(50),
    raza VARCHAR(50),
    clase VARCHAR(50),
    expe INT
);
CREATE TABLE miembro (
	cod INT PRIMARY KEY,
    fullname VARCHAR(50),
    expediente INT,
    estudio VARCHAR(50)
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
CREATE TABLE utiliza_personaje (
	id_miembro INT,
    id_personaje INT,
    PRIMARY KEY (id_miembro, id_personaje),
    CONSTRAINT FOREIGN KEY (id_miembro) REFERENCES miembro(cod),
    CONSTRAINT FOREIGN KEY (id_personaje) REFERENCES personaje(cod)
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

INSERT INTO personaje (cod, nombre, personaje, raza, clase, expe) VALUES
(1001, 'Eldon', 'Glimmer', 'Elfo', 'Mago', 5000),
(1002, 'Mara', 'Nightshade', 'Humano', 'Ladrón', 4500),
(1003, 'Korin', 'Steelbrow', 'Enano', 'Guerrero', 5200),
(1004, 'Alya', 'Starfire', 'Elfo', 'Clerigo', 4800),
(1005, 'Borin', 'Hammerhand', 'Enano', 'Paladin', 5500);

INSERT INTO miembro (cod, fullname, expediente, estudio) VALUES
(2001, 'John Doe', 12345, 'Ciencias Computacionales'),
(2002, 'Jane Smith', 12346, 'Ingeniería de Software'),
(2003, 'Alice Johnson', 12347, 'Diseño de Sistemas'),
(2004, 'Bob Brown', 12348, 'Ciencias de la Computación'),
(2005, 'Carol White', 12349, 'Seguridad Informática');

INSERT INTO partida (cod, num_sesion, nombre, duracion, dia_hora, ambientacion, enCurso, controlador) VALUES
(3001, 10, 'Amanecer de fuego', 180, 'Martes a las 17:00', 'Fantasía medieval', true, 2001),
(3002, 15, 'Crepúsculo gélido', 150, 'Martes a las 19:00', 'Fantasía gélida', false, 2002),
(3003, 20, 'La caída de la noche', 210, 'Miercoles a las 16:00', 'Fantasía oscura', true, 2003),
(3004, 25, 'El alba dorada', 160, 'Jueves a las 21:00', 'Fantasía clásica', false, 2004),
(3005, 30, 'Sombras persistentes', 190, 'Sábado a las 20:00', 'Fantasía steampunk', true, 2005);

INSERT INTO utiliza_personaje (id_miembro, id_personaje) VALUES
(2001, 1001),
(2002, 1002),
(2003, 1003),
(2004, 1004),
(2005, 1005);

INSERT INTO juega (id_partida, id_personaje, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma) VALUES
(3001, 1001, 12, 14, 13, 18, 15, 10),
(3002, 1002, 14, 18, 12, 14, 12, 16),
(3003, 1003, 18, 12, 17, 10, 13, 8),
(3004, 1004, 10, 12, 12, 16, 18, 14),
(3005, 1005, 16, 10, 18, 10, 12, 12);
