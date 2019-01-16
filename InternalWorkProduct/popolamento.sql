use dbSineCharta;
/*
load data local infile 'C:\\Users\\franc\\OneDrive\\Documenti\\GitHub\\Sine_Charta\\InternalWorkProduct\\utenti.sql'
into table utenteRegistrato(Username, Password, EMail, Nome, Cognome, Ruolo);

insert into utenteRegistrato (Username, Password, EMail, Nome, Cognome, Ruolo) 
	values ("Raziel", "cicico", "asldk@lisad.it", "joj","jj", "utenteGiocatore");
    
insert into Personaggio (Id ,Nome, Cognome, Età, Nazionalità, TaroccoDominante, Caratteristiche, Risoluzione, Ferite, Username) 
	values(1, "gius", "ccic", 30, "italia", "picche", 2, 2, "i", "Raziel");
 
    
insert into Abilità (identificativo, Valore, Id) 
	values("Fuoco", 2 , 1);
    
insert into Oggetti (NomeOggetto, Peso, Costo, Quantita, Id) values ("Pistola", 3, 2, 2, 1);

insert into Armi(Id, Tipo, Modello, Danno, Munizione, Ricarica, NomeOggetto) values (1, "Pistola", "Beretta-1234", 2, "si", 12, "Pistola");

insert into Storia(Titolo, Descrizione, Ambientazione, Id) values ("LaFregna","Profonda","Soviet",1 );

insert into Sessione(Numero, Contenuto, Username, Titolo) values (1, "ahasdhasjkdhsadjkhasdjkas", "Raziel87", "LaFregna");

insert into Keyword(Chiave, Descrizione, Titolo) values ("patate","incarrozza","LaFregna");

insert into Realizza(Username, Titolo) values ("Raziel87", "LaFregna");

insert into èInvitato(Username, Titolo) values ("Raziel87", "LaFregna"); 


insert into utenteRegistrato (Username, Password, EMail, Nome, Cognome, Ruolo) values ("Luigi", "1234", "luigi@live.it", "luis", "giul", "utenteGiocatore");
*/
insert into Personaggio (Id, Nome, Cognome, Età, Nazionalità, TaroccoDominante, Caratteristiche, Risoluzione, Ferite, Username) 
	values (2, "Tir", "12345", "40", "italia", "quadri", 2, 2, "*", "Luigi");

insert into Abilità (identificativo, Valore, Id) 
	values("Fire", 2 , 2);
    
insert into Oggetti (NomeOggetto, Peso, Costo, Quantita, Id) values ("Mitra", 3, 2, 2, 2);

insert into Armi(Id, Tipo, Modello, Danno, Munizione, Ricarica, NomeOggetto) values (2, "Pistola", "Beretta-1234", 2, "si", 12, "Mitra");

insert into Storia(Titolo, Descrizione, Ambientazione, Id) values ("Mammt","Profonda","Soviet",2 );
/*
insert into Sessione(Numero, Contenuto, Username, Titolo) values (2, "ahasdhasjkdhsadjkhasdjkas", "Raziel87", "LaFregna");

insert into Keyword(Chiave, Descrizione, Titolo) values ("pizza","incarrozza","LaFregna");
*/
insert into Realizza(Username, Titolo) values ("Raziel87", "Mammt");

insert into èInvitato(Username, Titolo) values ("Luigi", "Mammt"); 