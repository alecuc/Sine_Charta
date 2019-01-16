use dbSineCharta;
/*
load data local infile 'C:\\Users\\franc\\OneDrive\\Documenti\\GitHub\\Sine_Charta\\InternalWorkProduct\\utenti.sql'
into table utenteRegistrato(Username, Password, EMail, Nome, Cognome, Ruolo);

insert into Personaggio (Id ,Nome, Cognome, Età, Nazionalità, TaroccoDominante, Caratteristiche, Risoluzione, Ferite, Username) 
	values(1, "Pippo", "poppi", 12, "fisciano", "cuori", 2, 2, "i", "Raziel87");
    
insert into Abilità (identificativo, Valore, Id) 
	values("Fuoco", 2 , 1);
    
insert into Oggetti (NomeOggetto, Peso, Costo, Quantita, Id) values ("Pistola", 3, 2, 2, 1);

insert into Armi(Id, Tipo, Modello, Danno, Munizione, Ricarica, NomeOggetto) values (1, "Pistola", "Beretta-1234", 2, "si", 12, "Pistola");

insert into Storia(Titolo, Descrizione, Ambientazione, Id) values ("LaFregna","Profonda","Soviet",1 );

insert into Sessione(Numero, Contenuto, Username) values (1, "ahasdhasjkdhsadjkhasdjkas", "Raziel87");

insert into Keyword(Chiave, Descrizione, Titolo) values ("patate","incarrozza","LaFregna");

insert into Realizza(Username, Titolo) values ("Raziel87", "LaFregna");
*/

insert into èInvitato(Username, Titolo) values ("Raziel87", "LaFregna");