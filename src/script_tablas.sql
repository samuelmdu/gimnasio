CREATE DATABASE bd_gimnasio;

USE DATABASE bd_gimnasio;

CREATE TABLE t_entrenadores(
                               nombre_completo VARCHAR(30) NOT NULL,
                               correo_electronico VARCHAR(30) PRIMARY KEY,
                               fecha_nacimiento DATE NOT NULL,
                               fecha_contratacion DATE NOT NULL,
                               contrasenia VARCHAR(15)
)

CREATE TABLE t_nutricionistas(
                                 nombre_completo VARCHAR(30) NOT NULL,
                                 correo_electronico VARCHAR(30) PRIMARY KEY,
                                 fecha_nacimiento DATE NOT NULL,
                                 fecha_contratacion DATE NOT NULL,
                                 contrasenia VARCHAR(15)
)

CREATE TABLE t_recepcionistas(
                                 nombre_completo VARCHAR(30) NOT NULL,
                                 correo_electronico VARCHAR(30) PRIMARY KEY,
                                 fecha_nacimiento DATE NOT NULL,
                                 fecha_contratacion DATE NOT NULL,
                                 contrasenia VARCHAR(15)
)

CREATE TABLE t_clientes(
                           nombre_completo VARCHAR(30) NOT NULL,
                           correo_electronico VARCHAR(30) PRIMARY KEY,
                           fecha_nacimiento DATE NOT NULL,
                           peso_cliente DOUBLE,
                           altura_cliente DOUBLE,
                           contrasenia VARCHAR(15),
                           membresia_activa BOOLEAN DEFAULT FALSE
)

CREATE TABLE t_rutinas(
                          id INTEGER PRIMARY KEY,
                          fecha_inicio DATE NOT NULL,
                          fecha_cambio DATE NOT NULL,
                          objetivo VARCHAR(50),
                          grupo_muscular VARCHAR(15),
                          correo_creador VARCHAR(30),
                          correo_cliente_asignado VARCHAR(30)
)

CREATE TABLE t_planes_nutricionales(
                                       id INTEGER PRIMARY KEY,
                                       fecha_inicio DATE NOT NULL,
                                       fecha_cambio DATE NOT NULL,
                                       objetivo VARCHAR(50),
                                       paciente_imc DOUBLE,
                                       grado_obesidad VARCHAR(20),
                                       correo_creador VARCHAR(30),
                                       correo_cliente_asignado VARCHAR(30)
)

SELECT * FROM t_entrenadores;
SELECT * FROM t_nutricionistas;
SELECT * FROM t_recepcionistas;
SELECT * FROM t_clientes;
SELECT * FROM t_rutinas;
SELECT * FROM t_planes_nutricionales;

DROP TABLE t_rutinas;
DROP TABLE t_planes_nutricionales;
DROP TABLE t_clientes;
DROP TABLE t_entrenadores;
DROP TABLE t_nutricionistas;
DROP TABLE t_recepcionistas;