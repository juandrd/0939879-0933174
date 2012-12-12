-----PROYECTO DESARROLLO DE SOFTWARE II
-----Juan David Rengifo 0939879
-----Cristian Dario Loaiza 0933174

-----CREACION DE TABLAS

DROP TABLE tarjetas_personalizadas CASCADE;
CREATE TABLE tarjetas_personalizadas (
pin_tarjeta varchar(100) PRIMARY KEY,
nro_pasajes int,
estado varchar(10),
adelanto_disponible int);


DROP TABLE tarjetas_genericas CASCADE;
CREATE TABLE tarjetas_genericas (
pin_tarjeta varchar(100) PRIMARY KEY,
nro_pasajes int,
estado varchar(10));


DROP TABLE pasajeros CASCADE;
CREATE TABLE pasajeros (
identificacion varchar(100) PRIMARY KEY,
nombres varchar(100),
apellidos varchar(100),
telefono varchar(10),
direccion varchar(50),
genero varchar(10),
email varchar(50),
password varchar(15));


DROP TABLE pasajeros_personalizadas CASCADE;
CREATE TABLE pasajeros_personalizadas (
identificacion varchar(100),
pin_tarjeta varchar(100),
PRIMARY KEY(identificacion , pin_tarjeta),
FOREIGN KEY(identificacion) REFERENCES pasajeros(identificacion),
FOREIGN KEY(pin_tarjeta) REFERENCES tarjetas_personalizadas(pin_tarjeta));


DROP TABLE empleados CASCADE;
CREATE TABLE empleados (
identificacion varchar(100) PRIMARY KEY,
nombres varchar(100),
apellidos varchar(100),
telefono varchar(10),
direccion varchar(50),
genero varchar(10),
email varchar(50),
salario int,
password varchar(15));


DROP TABLE directores_operativos CASCADE;
CREATE TABLE directores_operativos (
identificacion varchar(100) PRIMARY KEY,
FOREIGN KEY(identificacion) REFERENCES empleados(identificacion)
);


DROP TABLE directores_estacion CASCADE;
CREATE TABLE directores_estacion (
identificacion varchar(100) PRIMARY KEY,
FOREIGN KEY(identificacion) REFERENCES empleados(identificacion)
);


DROP TABLE estaciones CASCADE;
CREATE TABLE estaciones (
nombre varchar(100) PRIMARY KEY,
ubicacion varchar(50),
director varchar(100),
FOREIGN KEY(director) REFERENCES directores_estacion(identificacion));


DROP TABLE auxiliares CASCADE;
CREATE TABLE auxiliares (
identificacion varchar(100) PRIMARY KEY,
estacion varchar(100),
FOREIGN KEY(identificacion) REFERENCES empleados(identificacion),
FOREIGN KEY(estacion) REFERENCES estaciones(nombre));


DROP TABLE rutas CASCADE;
CREATE TABLE rutas (
nombre varchar(20) PRIMARY KEY,
descripcion varchar(100));


DROP TABLE buses CASCADE;
CREATE TABLE buses (
placa varchar(20) PRIMARY KEY,
marca varchar(20),
nro_chasis varchar(50),
tipo varchar(15),
nro_asientos int,
capacidad int,
ruta varchar(20),
FOREIGN KEY(ruta) REFERENCES rutas(nombre));


DROP TABLE conductores CASCADE;
CREATE TABLE conductores (
identificacion varchar(100) PRIMARY KEY,
hora_entrada Time,
hora_salida Time);


DROP TABLE turnos CASCADE;
CREATE TABLE turnos (
conductor varchar(100),
bus varchar(20),
hora_inicio Time,
hora_fin Time,
PRIMARY KEY(conductor, bus, hora_inicio),
FOREIGN KEY(conductor) REFERENCES conductores(identificacion),
FOREIGN KEY(bus) REFERENCES buses(placa));


DROP TABLE reclamos CASCADE;
CREATE TABLE reclamos (
codigo varchar(50) PRIMARY KEY,
descripcion varchar(100),
estacion varchar(100),
pasajero varchar(100),
FOREIGN KEY(estacion) REFERENCES estaciones(nombre),
FOREIGN KEY(pasajero) REFERENCES pasajeros(identificacion));
