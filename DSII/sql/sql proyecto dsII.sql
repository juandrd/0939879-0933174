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

DROP TABLE movilizacion CASCADE;
CREATE TABLE movilizacion (
pasajero varchar(100),
ruta varchar(100),
fecha Date
);


DROP TABLE reclamos CASCADE;
CREATE TABLE reclamos (
codigo varchar(50) PRIMARY KEY,
descripcion varchar(100),
estacion varchar(100),
pasajero varchar(100),
FOREIGN KEY(estacion) REFERENCES estaciones(nombre),
FOREIGN KEY(pasajero) REFERENCES pasajeros(identificacion));



-----Insertar Datos

----Pasajeros
INSERT INTO pasajeros VALUES ('92008547','Jorge Arturo', 'Rodriguez Perea','4589871','Calle 23 # 54-36', 'Masculino',
'jorge.arturo@correo.com','0000');

INSERT INTO pasajeros VALUES ('94587254','Daniel Felipe', 'Cordoba Dominguez','4589147','Calle 100 # 64-16', 'Masculino',
'daniel.felipe@correo.com','0000');

INSERT INTO pasajeros VALUES ('185474147','Camila Andrea', 'Grisales Gonzales','3745812','Cra 24 # 15-10', 'Femenino',
'camila.andrea@correo.com','0000');

INSERT INTO pasajeros VALUES ('87458961','Alberto Hebert', 'Ruiz Cortes','5478521','Calle 48 # 64-12', 'Masculino',
'alberto.cortes@correo.com','0000');

INSERT INTO pasajeros VALUES ('25447110','Javier Felipe', 'Londoño Trujillo','4498752','Calle 3 # 24-13', 'Masculino',
'javier.felipe@correo.com','0000');

INSERT INTO pasajeros VALUES ('72005475','Katherine', 'Sanchez Garcia','5812413','Cra 18 # 17-10', 'Femenino',
'katherine.sanchez@correo.com','0000');

INSERT INTO pasajeros VALUES ('17485324','Lorena Andrea', 'Riascos Mondragon','3214751','Cra 87 # 47-11', 'Femenino',
'lorena.andrea@correo.com','0000');


----- Tarjetas Genericas
INSERT INTO tarjetas_genericas VALUES ('T1243256',15000,'Vendido');

INSERT INTO tarjetas_genericas VALUES ('T1278498',5800,'Vendido');

INSERT INTO tarjetas_genericas VALUES ('T1874512',0,'Disponible');

INSERT INTO tarjetas_genericas VALUES ('T7411254',0,'Disponible');

INSERT INTO tarjetas_genericas VALUES ('T18232323',0,'Disponible');

INSERT INTO tarjetas_genericas VALUES ('T14734632',0,'Disponible');

INSERT INTO tarjetas_genericas VALUES ('T25478512',0,'Vendido');


-----Rutas
INSERT INTO rutas VALUES ('E21','Alamos-Universidades');


INSERT INTO rutas VALUES ('E31','Chiminangos-Universidades');


INSERT INTO rutas VALUES ('P10A','Centro-Universidades');


INSERT INTO rutas VALUES ('T57A','Nuevo Latir-Unidad Deportiva');


INSERT INTO rutas VALUES ('T47A','Andres Sanin-Capri');


INSERT INTO rutas VALUES ('T31','Chiminangos-Universidades');

INSERT INTO rutas VALUES ('T40','Andres Sanin-Centro');

INSERT INTO rutas VALUES ('A02','San Bosco-Zoologico');

INSERT INTO rutas VALUES ('A19B','Cra 100-Buitrera');

INSERT INTO rutas VALUES ('P30A','Centro-Av 6ta-Chipichape');


------Buses

INSERT INTO buses VALUES ('VCT938','Chevrolet','154785239',
'Alimentador',25,50,'A02');


INSERT INTO buses VALUES ('VCT574','Chevrolet','154875279',
'Troncal',68,130,'T31');

INSERT INTO buses VALUES ('VCT774','Chevrolet','298175274',
'Troncal',68,130,'T47A');

INSERT INTO buses VALUES ('VCT217','Chevrolet','198742119',
'Troncal',68,130,'E31');

INSERT INTO buses VALUES ('VCT444','Mazda','457415512',
'Troncal',68,130,'E21');

INSERT INTO buses VALUES ('VCB174','Chevrolet','154453578',
'Padron',42,70,'P10A');

INSERT INTO buses VALUES ('VCT334','Chevrolet','1515175279',
'Padron',42,70,'P30A');

INSERT INTO buses VALUES ('VCT854','Chevrolet','1548745519',
'Padron',42,70,'P10A');

----Tarjetas Personalizadas

INSERT INTO tarjetas_personalizadas VALUES ('TP1475214',10000,'Disponible',3);

INSERT INTO tarjetas_personalizadas VALUES ('TP1145213',10000,'Disponible',3);

INSERT INTO tarjetas_personalizadas VALUES ('TP4555214',20000,'Disponible',3);

INSERT INTO tarjetas_personalizadas VALUES ('TP1473317',15000,'Disponible',3);

INSERT INTO tarjetas_personalizadas VALUES ('TP2175214',5000,'Disponible',3);

INSERT INTO tarjetas_personalizadas VALUES ('TP1785514',20000,'Disponible',3);

INSERT INTO tarjetas_personalizadas VALUES ('TP3142141',50000,'Disponible',3);

INSERT INTO tarjetas_personalizadas VALUES ('TP8455214',5000,'Disponible',3);

INSERT INTO tarjetas_personalizadas VALUES ('TP8749914',8000,'Disponible',3);

INSERT INTO tarjetas_personalizadas VALUES ('TP1479111',50000,'Disponible',3);


-----Empleados

INSERT INTO empleados VALUES ('7412548','Carmen Luz', 'Rodriguez Trejos','2541745','Cra 8 # 37-14', 'Femenino',
'carmen.luz@correo.com',490000,'0000');

INSERT INTO empleados VALUES ('7451299','Cecilia Gabriela', 'Alzate Bohorquez','4471745','Cra 58 # 39-10', 'Femenino',
'cecilia@correo.com',590000,'0000');


INSERT INTO empleados VALUES ('776695','Juan Sebastian', 'Garcia Barona','4741145','Calle 58 # 59-01', 'Masculino',
'juan.sebastian@correo.com',1500000,'0000');


INSERT INTO empleados VALUES ('9211458','Juan Hernan', 'Jimenez Henao','4386571','Calle 74 # 91-11', 'Masculino',
'juan.hernan@correo.com',900000,'0000');

INSERT INTO empleados VALUES ('0001','Julian Andres', 'Leon Libreros','6689745','Calle 8 # 57-71', 'Masculino',
'julian.leon@correo.com',2000000,'0000');

INSERT INTO empleados VALUES ('7785195','Alfred', 'Potter Mandragoric','7411478','Cra 13 # 59-85', 'Masculino',
'alfred.potter@correo.com',1500000,'0000');




-----Tipos De Empleados

INSERT INTO directores_operativos VALUES ('0001');
INSERT INTO directores_estacion VALUES ('9211458');
INSERT INTO directores_estacion VALUES ('776695');
INSERT INTO directores_estacion VALUES ('7785195');

-----Estaciones
INSERT INTO estaciones VALUES('Villacolombia','Cra 15 con 52','776695');
INSERT INTO estaciones VALUES('El Trebol','Cra 15 con 56','776695');
INSERT INTO estaciones VALUES('Chapinero','Cra 15 con 44','776695');
INSERT INTO estaciones VALUES('San Pascual','Cra 15 con 15','9211458');
INSERT INTO estaciones VALUES('Tequendama','Calle 5 con 39','9211458');
INSERT INTO estaciones VALUES('Unidad Deportiva','Calle 5 con 50','9211458');
INSERT INTO estaciones VALUES('Univalle','Cra 100 con 13','7785195');
INSERT INTO estaciones VALUES('Universidades','Cra 100 con 16','7785195');
INSERT INTO estaciones VALUES('Buitrera','Cra 100 ','7785195');

INSERT INTO conductores VALUES ('7412548','11:00:00','18:00:00');
INSERT INTO auxiliares VALUES ('7451299','Chapinero');