CREATE SCHEMA RETO5;
USE RETO5;

DROP TABLE IF EXISTS Bicicleta;
CREATE TABLE Bicicleta (
    Fabricante 		VARCHAR(15) PRIMARY KEY,
    Precio_unitario int NOT NULL,
    Año 			INT NOT NULL
);
INSERT INTO Bicicleta VALUES ("Cannondale", 1200000, 2020);
INSERT INTO Bicicleta VALUES ("Trek", 1450000, 2019);
INSERT INTO Bicicleta VALUES ("Yeti", 2000000, 2020);
INSERT INTO Bicicleta VALUES ("Fuji", 950000, 2021);
INSERT INTO Bicicleta VALUES ("Bmc", 950000, 2018);

SELECT * FROM Bicicleta;

DROP TABLE IF EXISTS Clientes;
CREATE TABLE Clientes (
	Alias 				VARCHAR(12) PRIMARY KEY,
    Nombre 				VARCHAR(12) NOT NULL,
    Apellido 			VARCHAR(12) NOT NULL,
    Email 				VARCHAR(30) NULL,
    Celular 			BIGINT NULL,
    Contraseña 			CHAR(8) NULL,
    Fecha_nacimiento 	DATE NULL
);
iNSERT INTO Clientes VALUES ("lucky", "Pedro", "Perez");
iNSERT INTO Clientes VALUES ("malopez", "Maria", "Lopez");
iNSERT INTO Clientes VALUES ("diva", "Ana", "Diaz");
iNSERT INTO Clientes VALUES ("dreamer", "Luis", "Rojas");
iNSERT INTO Clientes VALUES ("ninja", "Andres", "Cruz");
iNSERT INTO Clientes VALUES ("neon", "Nelson", "Ruiz");
iNSERT INTO Clientes VALUES ("rose", "Claudia", "Mendez");
iNSERT INTO Clientes VALUES ("green", "Jorge", "Rodriguez");

DROP TABLE IF EXISTS Fabricanes;
CREATE TABLE Fabricantes (
	Proveedor_del_motor VARCHAR(20) PRIMARY KEY,
    Prov_dirección 		VARCHAR(30) NOT NULL,
    Prov_teléfono 		VARCHAR(30) NOT NULL
);
INSERT INTO Fabricantes VALUES ("Auteco", "calle 7 No. 45-17", "05713224459");
INSERT INTO Fabricantes VALUES ("Hitachi", "calle 19 No. 108-26", "05714223344");
INSERT INTO Fabricantes VALUES ("Bosch", "carrera 68 No. 26-45", "05715678798");
INSERT INTO Fabricantes VALUES ("Teco", "calle 77 No. 68-33", "05712213243");
INSERT INTO Fabricantes VALUES ("General Electric", "calle 29 No. 26-12", "05717239919");

SELECT * FROM Fabricantes;

DROP TABLE IF EXISTS Motocicletas_Eléctricas;
CREATE TABLE Motocicletas_Eléctricas (
	Fabricante 							VARCHAR(20) PRIMARY KEY,
    Precio_unitario 					INT NOT NULL,
    Autonomía 							VARCHAR(20) NOT NULL,
    Proveedor_del_motor_fk  			VARCHAR(20) NOT NULL,
    FOREIGN KEY(Proveedor_del_motor_fk) REFERENCES Fabricantes(Proveedor_del_motor)
);
INSERT INTO Motocicletas_Eléctricas VALUES ("Starker", 4200000, "18 horas", "Auteco");
INSERT INTO Motocicletas_Eléctricas VALUES ("Lucky Lion", 5600000, "14 horas", "Hitachi");
INSERT INTO Motocicletas_Eléctricas VALUES ("Be Electric", 4600000, "26 horas", "Auteco");
INSERT INTO Motocicletas_Eléctricas VALUES ("Aima", 8000000, "36 horas", "Bosch");
INSERT INTO Motocicletas_Eléctricas VALUES ("Mec de Colombia", 5900000, "20 horas", "Teco");
INSERT INTO Motocicletas_Eléctricas VALUES ("Atom Electric", 4500000, "12 horas", "General Electric");

SELECT * FROM Motocicletas_Eléctricas;

DROP TABLE IF EXISTS Intención_de_compra;
CREATE TABLE Intención_de_compra(
	Codigo 							INT auto_increment PRIMARY KEY,
    Alias_fk 						VARCHAR(12) NOT NULL,
    Fabricante_Bici_fk 				VARCHAR(15) NULL,
    Fabricante_Moto_fk 				VARCHAR(20) NULL,
    Fecha 							TIMESTAMP NOT NULL,
    FOREIGN KEY(Fabricante_Bici_fk) REFERENCES Bicicleta(Fabricante),
    FOREIGN KEY(Fabricante_Moto_fk) REFERENCES Motocicletas_Eléctricas(Fabricante)
);
INSERT INTO Intención_de_compra(Alias_fk, Fabricante_Bici_fk, Fecha)
VALUES ("lucky", "Cannondale", '2017-10-25 20:00:00');
INSERT INTO Intención_de_compra(Alias_fk, Fabricante_Bici_fk, Fecha)
VALUES ("lucky", "Trek", '2019-03-15 18:30:00');
INSERT INTO Intención_de_compra(Alias_fk, Fabricante_Moto_fk, Fecha)
VALUES ("lucky", "Starker", '2019-05-20 20:30:00');
INSERT INTO Intención_de_compra(Alias_fk, Fabricante_Bici_fk, Fecha)
VALUES ("malopez", "Cannondale", '2018-05-20 20:30:00');
INSERT INTO Intención_de_compra(Alias_fk, Fabricante_Moto_fk, Fecha)
VALUES ("malopez", "Starker", '2020-01-20 20:30:00');
INSERT INTO Intención_de_compra(Alias_fk, Fabricante_Bici_fk, Fecha)
VALUES ("diva", "Yeti", '2019-05-20 20:30:00');
INSERT INTO Intención_de_compra(Alias_fk, Fabricante_Bici_fk, Fecha)
VALUES ("diva", "Fuji", '2018-06-22 21:30:00');
INSERT INTO Intención_de_compra(Alias_fk, Fabricante_Moto_fk, Fecha)
VALUES ("diva", "Lucky Lion", '2020-03-17 15:30:20');
INSERT INTO Intención_de_compra(Alias_fk, Fabricante_Moto_fk, Fecha)
VALUES ("dreamer", "Lucky Lion", '2020-03-17 15:30:20');
INSERT INTO Intención_de_compra(Alias_fk, Fabricante_Moto_fk, Fecha)
VALUES ("dreamer", "Be Electric", '2020-04-10 18:30:20');
INSERT INTO Intención_de_compra(Alias_fk, Fabricante_Moto_fk, Fecha)
VALUES ("ninja", "Aima", '2020-02-17 20:30:20');
INSERT INTO Intención_de_compra(Alias_fk, Fabricante_Moto_fk, Fecha)
VALUES ("ninja", "Starker", '2020-02-20 16:30:20');
INSERT INTO Intención_de_compra(Alias_fk, Fabricante_Moto_fk, Fecha)
VALUES ("ninja", "Mec de Colombia", '2020-03-27 18:30:20');
INSERT INTO Intención_de_compra(Alias_fk, Fabricante_Moto_fk, Fecha)
VALUES ("rose", "Atom Electric", '2020-03-20 21:30:20');
INSERT INTO Intención_de_compra(Alias_fk, Fabricante_Bici_fk, Fecha)
VALUES ("green", "Yeti", '2020-01-10 17:30:20');
INSERT INTO Intención_de_compra(Alias_fk, Fabricante_Bici_fk, Fecha)
VALUES ("green", "Trek", '2020-02-15 20:30:20');
INSERT INTO Intención_de_compra(Alias_fk, Fabricante_Bici_fk, Fecha)
VALUES ("green", "Bmc", '2020-03-17 18:30:20');

SELECT * FROM Intención_de_compra;