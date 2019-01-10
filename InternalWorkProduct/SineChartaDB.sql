drop database sinecharta;

create database sinecharta;
use sinecharta;

drop table if exists utenteRegistrato;
create table utenteRegistrato(
	Username varchar(15) not null,
    Password varchar(15) not null,
    EMail varchar(30) not null,
    Nome varchar(50) not null,
    Cognome varchar(50) not null,
    Ruolo enum('utenteModeratore','utenteGiocatore'),
    primary key(username)
    );
    

drop table if exists Personaggio;
create table Personaggio(
	Nome varchar(30),
    Cognome varchar(30),
    Età int not null,
    Nazionalità varchar(20),
    TaroccoDominante varchar(30),
    Caratteristiche int,
    Abilità varchar(50),
    Risoluzione int,
    Ferite char(2),
    primary key(Nome,Cognome)
    );
    
drop table if exists Storia;
create table Storia(
	Titolo varchar(50),
    Descrizione varchar(500),
    Nome varchar(30),
    Cognome varchar(30),
    primary key(Nome),
    foreign key(Nome,Cognome) references Personaggio(Nome,Cognome) on delete cascade
    );

drop table if exists Sessione;
create table Sessione(
	Numero int default 1,
    Contenuto varchar(1000),
    Username varchar(15),
    primary key(Numero),
    foreign key(Username) references utenteRegistrato(Username) on delete cascade
	);
    
drop table if exists Keyword;
create table Keyword(
	Chiave varchar(20) not null,
    descrizione varchar(1000),
    Numero int default 1,
    primary key(Chiave),
    foreign key(Numero) references Sessione(Numero) on delete cascade
);

drop table if exists Nemico;
create table Nemico(
	Nome varchar(30),
    Attacco varchar(30),
    Speciali varchar(30),
    primary key(Nome)
);

drop table if exists Oggetti;
create table Oggetti(
	Nom varchar(30),
    Peso int not null,
    Costo int not null,
    Nome varchar(30),
    Cognome varchar(30),
    primary key(Nome),
    foreign key(Nome,Cognome) references Personaggio(Nome,Cognome) on delete cascade
);

drop table if exists Armi;
create table Armi(
	Tipo enum('Pistola','Mitra','Fucile'),
    Modello varchar(15) not null,
    Danno int,
    Abilità int,
    Munizione varchar(10) not null,
    Ricarica int
);

drop table if exists Realizza;
create table Realizza(
	Username varchar(15) not null,
    Nome varchar(30),
    primary key(Username, Nome),
    foreign key(Username) references utenteRegistrato(Username),
    foreign key(Nome) references Storia(Nome)
    );
    
drop table if exists Crea;
create table Crea(
	Username varchar(15) not null,
    Numero varchar(30),
    primary key(Username, Numero),
    foreign key(Username) references utenteRegistrato(Username),
    foreign key(Numero) references Sessione(Numero)
);


	
