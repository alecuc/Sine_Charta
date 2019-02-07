function validateRegistration(formRegistration) {

	//Define registration regExp validators
	var usrValidator = /^(\w+[_\.\-]*\w*){4,}$/;
	var pswValidator = /^[a-zA-Z 0-9 \@\._\!\?\-]{8,}$/;
	var nameValidator = /^[a-zA-Z]+([\s\-]?[A-Za-z]+)*$/;
	var surnameValidator = /^[A-Za-z]+([\s\'\-]?[A-Za-z]+)*$/;
	var mailValidator = /^\w+([\._\-]?\w+)*@\w+([\.\-]?\w+)*(\.\w+)+$/;

	//Save all matches in a variable
	var usrIsOK = formRegistration.username.value.match(usrValidator);
	var pswIsOK = formRegistration.password.value.match(pswValidator);
	var pswConf = formRegistration.passConfirm.value;
	var nameIsOK = formRegistration.name.value.match(nameValidator);
	var surnameIsOK = formRegistration.surname.value.match(surnameValidator);
	var mailIsOK = formRegistration.email.value.match(mailValidator);

	if (!usrIsOK) { //Check username
		alert('Lo username deve contenere lettere, numeri o i caratteri "_", "." "-"  e deve essere lungo almeno 5');
		document.getElementById("username").focus(); //Set focus
		return false; //Negate access
	} else

		if (!pswIsOK) { //Check password
			alert("La password deve contenere almeno 8 caratteri tra lettere, numeri e simboli");
			document.getElementById("password").value="";
			document.getElementById("passConfirm").value="";
			document.getElementById("password").focus(); //Set focus
			return false; //Negate access
		} else

			if (formRegistration.passConfirm.value != formRegistration.password.value) { //Check password
				alert("Le password inserite non corrispondono");
				document.getElementById("password").value="";
				document.getElementById("passConfirm").value="";
				document.getElementById("password").focus(); //Set focus
				return false; //Negate access
			} else	  

				if (!nameIsOK) { //Check name
					alert("Il nome non può terminare con uno spazio oppure un apostrofo\ne non può contenere numeri o simboli");
					document.getElementById("name").focus(); //Set focus
					return false; //Negate access
				} else

					if (!surnameIsOK) { //Check surname
						alert("Il cognome non può terminare con uno spazio oppure un apostrofo\ne non può contenere numeri o simboli");
						document.getElementById("surname").focus(); //Set focus
						return false; //Negate access
					} else

						if (!mailIsOK) { //Check email
							alert("Inserisci email valida")
							document.getElementById("email").focus(); //Set focus
							return false; //Negate access
						} else

							return true; //Grant access
}