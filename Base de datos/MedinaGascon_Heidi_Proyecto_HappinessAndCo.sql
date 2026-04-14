-- Crea Base de datos nueva llamada Happiness_AndCo
USE master;
GO

DROP DATABASE IF EXISTS Happiness_AndCo;
GO
--Crear la Base de datos
CREATE DATABASE Happiness_AndCo;
GO

use Happiness_AndCo;
go

--Borrar tablas si ya existen
DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS eventos;
DROP TABLE IF EXISTS galerias;
DROP TABLE IF EXISTS imagenesGalerias;
DROP TABLE IF EXISTS favoritos;

--Crear la tabla Usuarios
CREATE TABLE usuarios (
    id INT identity(1,1) PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);

CREATE TABLE eventos (
    id INT identity(1,1) PRIMARY KEY,
    fecha DATE,
    titulo VARCHAR(200),
    ubicacion VARCHAR(200),
    descripcion VARCHAR(200)
);

CREATE TABLE galerias (
    id INT identity(1,1) PRIMARY KEY,
    titulo VARCHAR(200),
    id_evento INT,
    --restricciones
    constraint FK_galerias_eventos FOREIGN KEY (id_evento) REFERENCES eventos(id)
    on delete cascade -- Si se borra o actualiza eventos, se actualiza la tabla galerias en cascada
    on update cascade
);

CREATE TABLE imagenesGalerias (
    id INT identity(1,1) PRIMARY KEY,
    titulo VARCHAR(200),
    imagen VARCHAR(300),
    id_galeria INT,
    --restricciones
    constraint FK_imagenesGalerias_galerias FOREIGN KEY (id_galeria) REFERENCES galerias(id)
    on delete cascade -- Si se borra o actualiza galerias, se actualiza la tabla imagenesGalerias en cascada
    on update cascade
);

CREATE TABLE favoritos (
    id_usuario INT,
    id_evento INT,
    PRIMARY KEY (id_usuario, id_evento),
    constraint FK_favoritos_usuarios FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    constraint FK_favoritos_eventos FOREIGN KEY (id_evento) REFERENCES eventos(id)
    on delete cascade
    on update cascade
);