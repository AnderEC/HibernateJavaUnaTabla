create database hibernate;

use hibernate;
create table Usuario 
(
	id int,
    nombre varchar (15),
    edad int
);

alter table Usuario add primary key (id);

select * from Usuario;