create table USUARIOS(
	ID bigint not null AUTO_INCREMENT,
	NOMBRE varchar(30) not null,
	EMAIL varchar(30) not null,
	PASSWORD varchar(30) not null,
	PRIMARY KEY(ID)
);
