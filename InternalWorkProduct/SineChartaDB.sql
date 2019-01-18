drop database dbSineCharta;

create database dbSineCharta;
use dbSineCharta;

drop table if exists utenteRegistrato;
create table utenteRegistrato(
	Username varchar(15) not null unique,
    Password varchar(40) not null,
    EMail varchar(30) not null unique,
    Nome varchar(50) not null,
    Cognome varchar(50) not null,
    Ruolo enum('utenteModeratore','utenteGiocatore'),
    primary key(Username)
    );
    

drop table if exists Personaggio;
create table Personaggio(
	Id int auto_increment  not null,
	Nome varchar(30),
    Cognome varchar(30),
    Età int not null default 1,
    Nazionalità varchar(20),
    TaroccoDominante varchar(30),
    Intuito int,
    Aspetto int,
    Coordinazione int,
    AffinitàOcculta int,
    Memoria int,
    Comando int,
    DestrezzaManuale int,
    DistanzaDallaMorte int,
    Percezione int,
    Creatività int,
    ForzaFisica int,
    EquilibrioMentale int,
    Volontà int,
    Socievolezza int,
    Mira int,
    Karma int,
    Risoluzione int not null,
    Ferite varchar(10),
    Username varchar(15),
    primary key(Id),
    foreign key(Username) references utenteRegistrato(Username) on delete cascade
    );
    
drop table if exists Abilità;
create table Abilità(
	Identificativo varchar(30),
    Valore int,
    Id int ,
    primary key(Identificativo),
    foreign key(Id) references Personaggio(Id) on delete cascade
	); 
drop table if exists Storia;
create table Storia(
	Titolo varchar(50),
    Descrizione varchar(500),
    Ambientazione enum('Terre Perdute','Quarto Reich','Soviet','Sanctum Imperum'),
    Id int ,
	primary key(Titolo),
    foreign key(Id) references Personaggio(Id) on delete cascade
    );

drop table if exists Sessione;
create table Sessione(
	Numero int auto_increment, 
    Contenuto varchar(100),
    Username varchar(15),
    Titolo varchar(50),
    primary key(Numero),
    foreign key(Username) references utenteRegistrato(Username) on delete cascade,
    foreign key(Titolo) references Storia(Titolo)
	);
    
drop table if exists Keyword;
create table Keyword(
	id int auto_increment,
	Chiave varchar(50),
    Descrizione varchar(500),
    Titolo varchar(50),
    primary key(id),
    foreign key(Titolo) references Storia(Titolo)
    );
    
drop table if exists Oggetti;
create table Oggetti(
	NomeOggetto varchar(30),
    Peso int not null,
    Costo int not null,
    Quantita int default 1 not null,
    Id int default 1,
    primary key(NomeOggetto),
    foreign key(Id) references Personaggio(Id) on delete cascade
);

drop table if exists Armi;
create table Armi(
	Id int auto_increment,
	Tipo enum('Pistola','Mitra','Fucile'),
    Modello varchar(15) not null,
    Danno int,
    Munizione varchar(10) not null,
    Ricarica int,
	NomeOggetto varchar(30),
    primary key(Id),
    foreign key (NomeOggetto) references Oggetti(NomeOggetto) on delete cascade
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

drop table if exists èInvitato;
create table èInvitato(
	Username varchar(15) not null,
    Titolo varchar(50),
    primary key(Username, Titolo),
    foreign key(Username) references utenteRegistrato(Username),
    foreign key(Titolo) references Storia(Titolo)
	);
 
 
 
 
