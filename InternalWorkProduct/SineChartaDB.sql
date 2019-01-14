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
    primary key(Username)
    );
    

drop table if exists Personaggio;
create table Personaggio(
	Nome varchar(30),
    Cognome varchar(30),
    Età int not null,
    Nazionalità varchar(20),
    TaroccoDominante varchar(30),
    Caratteristiche int,
    Abilità varchar(50) not null,
    Risoluzione int not null,
    Ferite char(2) not null,
    Username varchar(15) not null,
    primary key(Nome,Cognome),
    foreign key(Username) references utenteRegistrato(Username) on delete cascade
    );
    
drop table if exists Storia;
create table Storia(
	Titolo varchar(50),
    Descrizione varchar(500),
    Ambientazione enum('Terre Perdute','Quarto Reich','Soviet','Sanctum Imperum'),
    Nome varchar(30),
    Cognome varchar(30),
    primary key(Titolo),
    foreign key(Nome,Cognome) references Personaggio(Nome,Cognome) on delete cascade
    );

drop table if exists Sessione;
create table Sessione(
	Numero int default 1,
    Contenuto varchar(100),
    Username varchar(15),
    primary key(Numero),
    foreign key(Username) references utenteRegistrato(Username) on delete cascade
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
    Titolo varchar(30),
    primary key(Username, Titolo),
    foreign key(Username) references utenteRegistrato(Username),
    foreign key(Titolo) references Storia(Titolo)
    );
    
drop table if exists Crea;
create table Crea(
	Username varchar(15) not null,
    Numero int,
    primary key(Username, Numero),
    foreign key(Username) references utenteRegistrato(Username),
    foreign key(Numero) references Sessione(Numero)
);


	
