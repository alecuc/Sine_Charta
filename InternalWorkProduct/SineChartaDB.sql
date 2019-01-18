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
    
drop table if exists Storia;
create table Storia(
	Id int auto_increment,
	Titolo varchar(50),
    Descrizione varchar(500),
    Ambientazione enum('Terre Perdute','Quarto Reich','Soviet','Sanctum Imperum'),
	primary key(Id)
    );
    
drop table if exists Personaggio;
create table Personaggio(
	Id int auto_increment,
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
    Salute int,
    FeriteTesta varchar(5),
    FeriteTorso varchar(5),
    FeriteBraccia varchar(5),
    FeriteGambe varchar(5),
    Username varchar(15),
    Ide int,
    primary key(Id),
    foreign key(Username) references utenteRegistrato(Username) on delete cascade,
    foreign key(Ide) references Storia(Id) on delete cascade
    );
    
 drop table if exists Mazzo;
 create table Mazzo(
	Tipo enum('Poker','Tarocco'),
    num_rimaste int,
	Username varchar(15), 
    primary key(Tipo),
    foreign key (Username) references utenteRegistrato(Username)
	);

drop table if exists CartaDaPoker;
create table CartaDaPoker(
	Valore int auto_increment,
    Descrizione varchar(30),
    Tipo enum('Poker','Tarocco'),
    primary key (Valore),
    foreign key (Tipo) references Mazzo(Tipo)
    );    

drop table if exists Tarocco;
create table Tarocco(
	Numero int auto_increment,
    Descrizione varchar(100),
    Descrizione_Dominante varchar(100),
    Valore_Cuori int,
    Valore_Quadri int,
    Valore_Fiori int,
    Valore_Picche int,
    Tipo enum('Poker','Tarocco'),
    primary key (Numero),
    foreign key (Tipo) references Mazzo(Tipo)
    );    


drop table if exists Abilità;
create table Abilità(
	Identificativo varchar(30),
    Valore int,
    Id int ,
    primary key(Identificativo),
    foreign key(Id) references Personaggio(Id) on delete cascade
	); 


drop table if exists Sessione;
create table Sessione(
	Numero int auto_increment, 
    Contenuto varchar(100),
    Username varchar(15),
    Id int,
    primary key(Numero),
    foreign key(Username) references utenteRegistrato(Username) on delete cascade,
    foreign key(Id) references Storia(Id) on delete cascade
	);
    
drop table if exists Keyword;
create table Keyword(
	id int auto_increment,
	Chiave varchar(50),
    Descrizione varchar(500),
    Ide int,
    primary key(id),
    foreign key(Ide) references Storia(Id) on delete cascade
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
	Id int,
    primary key(Username, Id),
    foreign key(Username) references utenteRegistrato(Username),
    foreign key(Id) references Storia(Id) on delete cascade
    );
    
drop table if exists Crea;
create table Crea(
	Username varchar(15) not null,
    Numero int,
    primary key(Username, Numero),
    foreign key(Username) references utenteRegistrato(Username),
    foreign key(Numero) references Sessione(Numero) on delete cascade
);

drop table if exists èInvitato;
create table èInvitato(
	Username varchar(15) not null,
    Id int,
    primary key(Username, Id),
    foreign key(Username) references utenteRegistrato(Username),
    foreign key(Id) references Storia(Id) on delete cascade
	);
 
 
 
 
