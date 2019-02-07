drop database dbSineCharta;

create database dbSineCharta;
use dbSineCharta;

drop table if exists utenteRegistrato;
create table utenteRegistrato(
	Username varchar(15) binary not null unique,
    Password varchar(40) not null,
    EMail varchar(30) not null unique,
    Nome varchar(50) not null,
    Cognome varchar(50) not null,
    Ruolo enum('utenteModeratore','utenteGiocatore'),
    primary key(Username)
    );
    
drop table if exists Storia;
create table Storia(
	IdStory int auto_increment,
	Titolo varchar(50),
    Descrizione varchar(500),
    Ambientazione enum('Terre Perdute','Quarto Reich','Soviet','Sanctum Imperum'),
	primary key(IdStory)
    );
    
drop table if exists Personaggio;
create table Personaggio(
	Nome varchar(30),
    Cognome varchar(30),
    Eta int,
    Nazionalita varchar(20),
    TaroccoDominante varchar(30),
    Intuito int,
    Aspetto int,
    Coordinazione int,
    AffinitaOcculta int,
    Memoria int,
    Comando int,
    DestrezzaManuale int,
    DistanzaDallaMorte int,
    Percezione int,
    Creatività int,
    ForzaFisica int,
    EquilibrioMentale int,
    Volonta int,
    Socievolezza int,
    Mira int,
    Karma int,
    Risoluzione int,
    Salute int,
    FeriteTesta varchar(5),
    FeriteTorso varchar(5),
    FeriteBraccia varchar(5),
    FeriteGambe varchar(5),
    Username varchar(15) binary not null,
    IdStory int,
    primary key(Username,IdStory),
    foreign key(Username) references utenteRegistrato(Username) on delete cascade,
    foreign key(IdStory) references Storia(IdStory) on delete cascade
    );
    
drop table if exists Sessione;
create table Sessione(
	Numero int auto_increment, 
    Contenuto varchar(100),
    Username varchar(15) binary not null ,
    IdStory int,
    primary key(Numero,Username, IdStory),
    foreign key(Username) references utenteRegistrato(Username) on delete cascade,
    foreign key(IdStory) references Storia(IdStory) on delete cascade
	);
    
drop table if exists Abilita;
create table Abilità(
	Nome varchar(30),
    Valore int,
    Username varchar(15) binary not null,
    IdStory int,
    primary key(Nome),
    foreign key(Username) references Personaggio(Username) on delete cascade,
    foreign key(IdStory) references Personaggio(IdStory) on delete cascade
	); 



drop table if exists Keyword;
create table Keyword(
	idKeyword int auto_increment,
	Chiave varchar(50),
    Descrizione varchar(500),
    Numero int,
    primary key(idKeyword),
    foreign key(Numero) references Sessione(Numero) on delete cascade
    );
    
drop table if exists Oggetti;
create table Oggetti(
	IdOggetto int auto_increment,
    NomeOggetto varchar(30),
    Peso int not null,
    Costo int not null,
    Quantita int default 1 not null,
    Username varchar(15) binary not null,
    IdStory int,
    primary key(IdOggetto),
    foreign key(Username) references Personaggio(Username) on delete cascade,
    foreign key(IdStory) references Personaggio(IdStory) on delete cascade
);


drop table if exists ha;
create table ha(
	Username varchar(15) binary not null ,
    IdStory int,
    flag int,
    primary key (Username, IdStory),
    foreign key(Username) references utenteRegistrato(Username) on delete cascade,
    foreign key(IdStory) references Storia(IdStory) on delete cascade
    );
    


