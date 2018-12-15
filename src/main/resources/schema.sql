create table cliente
(
   id integer auto_increment not null,
   nome varchar(255) not null,
   idade integer,
   primary key(id)
);

create table clima
(
   id integer auto_increment not null,
   id_cliente integer not null,
   data_inclusão varchar(255),
   temperatura_minima DECIMAL,
   temperatura_maxima DECIMAL,
   ip_request varchar(255) not null,
   primary key(id)
);