DROP SCHEMA RETO5;
CREATE SCHEMA RETO5;
USE RETO5;

DROP TABLE IF EXISTS bicicletas;
CREATE TABLE bicicletas (
    fabricante 		VARCHAR(15) PRIMARY KEY,
    precio_unitario INT NOT NULL,
    ano INT NOT NULL
);
INSERT INTO bicicletas VALUES ("Cannondale", 1200000, 2020);
INSERT INTO bicicletas VALUES ("Trek", 1450000, 2019);
INSERT INTO bicicletas VALUES ("Yeti", 2000000, 2020);
INSERT INTO bicicletas VALUES ("Fuji", 950000, 2021);
INSERT INTO bicicletas VALUES ("Bmc", 950000, 2018);

DROP TABLE IF EXISTS clientes;
CREATE TABLE clientes (
	alias VARCHAR(12) PRIMARY KEY,
    nombre VARCHAR(12) NOT NULL,
    apellido VARCHAR(12) NOT NULL,
    email VARCHAR(30) NULL,
    celular CHAR(12) NULL,
    contrasena INT NULL,
    fecha_nacimiento DATE NULL
);
INSERT INTO clientes VALUES ('lucky', 'Pedro', 'Perez', 'lucky@gmail.com', '3178561234', 12345678, '1980-01-15');
INSERT INTO clientes VALUES ('malopez', 'Maria', 'Lopez', 'malopez@hotmail.com', '3198246234', 11112222, '1990-02-12');
INSERT INTO clientes VALUES ('diva', 'Ana', 'Diaz', 'diva@gmail.com', '3146464676', 87654321, '1986-04-20');
INSERT INTO clientes VALUES ('dreamer', 'Luis', 'Rojas', 'dreamer@gmail.com', '3111112222', 46464646, '1990-05-28');
INSERT INTO clientes VALUES ('ninja', 'Andres', 'Cruz', 'ninja@hotmail.com', '3123219876', 98653265, '1993-01-05');
INSERT INTO clientes VALUES ('neon', 'Nelson', 'Ruiz', 'neon@hotmail.com', '3123219876', 98246234, '1994-10-20');
INSERT INTO clientes VALUES ('rose', 'Claudia', 'Mendez', 'rose@gmail.com', '3123219876', 98215463, '1997-07-02');
INSERT INTO clientes VALUES ('green', 'Jorge', 'Rodriguez', 'green@hotmail.com', '3198215463', 78561234, '1992-06-20');

DROP TABLE IF EXISTS fabricanes;
CREATE TABLE fabricantes (
	proveedor_del_motor VARCHAR(20) PRIMARY KEY,
    proveedor_dirección VARCHAR(30) NOT NULL,
    proveedor_teléfono 	VARCHAR(30) NOT NULL
);
INSERT INTO fabricantes VALUES ("Auteco", "calle 7 No. 45-17", "05713224459");
INSERT INTO fabricantes VALUES ("Hitachi", "calle 19 No. 108-26", "05714223344");
INSERT INTO fabricantes VALUES ("Bosch", "carrera 68 No. 26-45", "05715678798");
INSERT INTO fabricantes VALUES ("Teco", "calle 77 No. 68-33", "05712213243");
INSERT INTO fabricantes VALUES ("General Electric", "calle 29 No. 26-12", "05717239919");

DROP TABLE IF EXISTS motocicletas_electricas;
CREATE TABLE motocicletas_electricas (
	fabricante VARCHAR(20) PRIMARY KEY,
    precio_unitario INT NOT NULL,
    autonomia VARCHAR(20) NOT NULL,
    proveedor_del_motor_fk VARCHAR(20) NOT NULL,
    FOREIGN KEY(proveedor_del_motor_fk) REFERENCES fabricantes(proveedor_del_motor)
);
INSERT INTO motocicletas_electricas VALUES ("Starker", 4200000, "18 horas", "Auteco");
INSERT INTO motocicletas_electricas VALUES ("Lucky Lion", 5600000, "14 horas", "Hitachi");
INSERT INTO motocicletas_electricas VALUES ("Be Electric", 4600000, "26 horas", "Auteco");
INSERT INTO motocicletas_electricas VALUES ("Aima", 8000000, "36 horas", "Bosch");
INSERT INTO motocicletas_electricas VALUES ("Mec de Colombia", 5900000, "20 horas", "Teco");
INSERT INTO motocicletas_electricas VALUES ("Atom Electric", 4500000, "12 horas", "General Electric");

DROP TABLE IF EXISTS intención_de_compra;
CREATE TABLE intención_de_compra(
	codigo INT AUTO_INCREMENT PRIMARY KEY,
    alias_fk VARCHAR(12) NOT NULL,
    fabricante_bici_fk VARCHAR(15) NULL,
    fabricante_moto_fk VARCHAR(20) NULL,
    fecha TIMESTAMP NOT NULL,
    FOREIGN KEY(fabricante_bici_fk) REFERENCES bicicletas(fabricante),
    FOREIGN KEY(fabricante_moto_fk) REFERENCES motocicletas_electricas(fabricante)
);
INSERT INTO intención_de_compra(alias_fk, fabricante_bici_fk, fecha)
VALUES ("lucky", "Cannondale", '2017-10-25 20:00:00');
INSERT INTO intención_de_compra(alias_fk, fabricante_bici_fk, fecha)
VALUES ("lucky", "Trek", '2019-03-15 18:30:00');
INSERT INTO intención_de_compra(alias_fk, fabricante_moto_fk, fecha)
VALUES ("lucky", "Starker", '2019-05-20 20:30:00');
INSERT INTO intención_de_compra(alias_fk, fabricante_bici_fk, fecha)
VALUES ("malopez", "Cannondale", '2018-05-20 20:30:00');
INSERT INTO intención_de_compra(alias_fk, fabricante_moto_fk, fecha)
VALUES ("malopez", "Starker", '2020-01-20 20:30:00');
INSERT INTO intención_de_compra(alias_fk, fabricante_bici_fk, fecha)
VALUES ("diva", "Yeti", '2019-05-20 20:30:00');
INSERT INTO intención_de_compra(alias_fk, fabricante_bici_fk, fecha)
VALUES ("diva", "Fuji", '2018-06-22 21:30:00');
INSERT INTO intención_de_compra(alias_fk, fabricante_moto_fk, fecha)
VALUES ("diva", "Lucky Lion", '2020-03-17 15:30:20');
INSERT INTO intención_de_compra(alias_fk, fabricante_moto_fk, fecha)
VALUES ("dreamer", "Lucky Lion", '2020-03-17 15:30:20');
INSERT INTO intención_de_compra(alias_fk, fabricante_moto_fk, fecha)
VALUES ("dreamer", "Be Electric", '2020-04-10 18:30:20');
INSERT INTO intención_de_compra(alias_fk, fabricante_moto_fk, fecha)
VALUES ("ninja", "Aima", '2020-02-17 20:30:20');
INSERT INTO intención_de_compra(alias_fk, fabricante_moto_fk, fecha)
VALUES ("ninja", "Starker", '2020-02-20 16:30:20');
INSERT INTO intención_de_compra(alias_fk, fabricante_moto_fk, fecha)
VALUES ("ninja", "Mec de Colombia", '2020-03-27 18:30:20');
INSERT INTO intención_de_compra(alias_fk, fabricante_moto_fk, fecha)
VALUES ("rose", "Atom Electric", '2020-03-20 21:30:20');
INSERT INTO intención_de_compra(alias_fk, fabricante_bici_fk, fecha)
VALUES ("green", "Yeti", '2020-01-10 17:30:20');
INSERT INTO intención_de_compra(alias_fk, fabricante_bici_fk, fecha)
VALUES ("green", "Trek", '2020-02-15 20:30:20');
INSERT INTO intención_de_compra(alias_fk, fabricante_bici_fk, fecha)
VALUES ("green", "Bmc", '2020-03-17 18:30:20');