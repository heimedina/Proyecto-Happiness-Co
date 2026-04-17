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

--Insertamos eventos (tres proximos y tres del historial, considerando la fecha actual como 28-02-2026)
INSERT INTO eventos (fecha, titulo, ubicacion, descripcion) VALUES
('2026-01-01', 'Concierto Año Nuevo', 'Madrid', 'Gran concierto de apertura de año'),
('2026-01-12', 'Obra de Teatro Clásica', 'Zaragoza', 'Representación teatral clásica'),
('2026-01-24', 'Exposición Arte Moderno', 'Gijón', 'Arte moderno internacional'),
('2026-06-05', 'Festival Indie', 'Madrid', 'Festival de música indie'),
('2026-06-15', 'Cine al aire libre', 'Oviedo', 'Proyección nocturna'),
('2026-06-25', 'Exposición Fotográfica', 'Gijón', 'Fotografía contemporánea');

--Insertamos usuarios
INSERT INTO usuarios (nombre, email, password) VALUES
('Ana Lopez', 'analopez@gmail.com', '12Ana34'),
('Carlos Perez', 'carlos.perez@gmail.com', '123CarPez4'),
('Maria Garcia', 'maria_garcia@gmail.com', 'MariaG1234');

--Insertamos galerias (solo eventos históricos)
INSERT INTO galerias (titulo, id_evento) VALUES
('Galeria Año Nuevo', 1),
('Galeria Teatro', 2),
('Galeria Arte', 3);

--Insertamos imagenes de las galerias
INSERT INTO imagenesGalerias (titulo, imagen, id_galeria) VALUES
('Imagen1', 'img1.jpg', 1),
('Imagen2', 'img2.jpg', 1),
('Imagen3', 'img3.jpg', 1),
('Imagen4', 'img4.jpg', 2),
('Imagen5', 'img5.jpg', 2),
('Imagen6', 'img6.jpg', 2),
('Imagen7', 'img7.jpg', 3),
('Imagen8', 'img8.jpg', 3),
('Imagen9', 'img9.jpg', 3);

--Insertamos favoritos. Cada usuario: mínimo 3 eventos, al menos 2 históricos
INSERT INTO favoritos VALUES
(1,1),(1,2),(1,4),
(2,2),(2,3),(2,5),
(3,1),(3,3),(3,6);

--Crear vistas

--galerías anteriores al 28-02-2026.
create view GaleriasAnteriores 
as
select g.id, g.id_evento, g.titulo, e.fecha, e.descripcion, e.ubicacion
from dbo.galerias g
inner join dbo.eventos e
on g.id_evento = e.id
WHERE e.fecha < '2026-02-28';

--eventos favoritos del usuario 1.
CREATE VIEW FavoritosUsuario1 
AS
select f.id_usuario, f.id_evento, u.nombre, u.email
from dbo.favoritos f
inner join dbo.usuarios u
on f.id_usuario = u.id and f.id_usuario = 1;

--Imagenes de la galería del evento del 12-01-2026 (usar su id para crear la vista, no la fecha).
create view ImagenesGaleriaEvento12Enero
as
select g.id_evento, g.titulo, ig.id_galeria, ig.imagen, ig.titulo as TituloImagen
from dbo.imagenesGalerias ig
inner join dbo.galerias g on ig.id_galeria = g.id
and g.id_evento = 2;

--eventos favoritos del usuario 2 posteriores al 28-02-2026
create view EventosFavoritosUsuario2
as
select *
from dbo.favoritos f
inner join dbo.eventos e on e.id = f.id_evento
and f.id_usuario = 2 and e.fecha > '2026-02-28';


--eventos favoritos del usuario 2 posteriores al 28-02-2026
create view EventosFavoritosConDatosUsuario2
as
select u.id, u.nombre, u.email, f.id_evento, e.fecha, e.titulo, e.ubicacion, e.descripcion
from dbo.usuarios u
inner join dbo.favoritos f 
on u.id = f.id_usuario
inner join dbo.eventos e
on e.id = f.id_evento
and u.id = 2 and e.fecha > '2026-02-28';
