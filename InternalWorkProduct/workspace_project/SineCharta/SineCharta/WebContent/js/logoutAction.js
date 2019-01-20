function confermaLogout(){
	var reallyLogout=confirm("Do you really want to log out?");
	if(reallyLogout){
		location.href="index.jsp";
	}
}
var el = document.getElementById("logout");
if (el.addEventListener) {
	el.addEventListener("click", logoutfunction, false);
} else {
	el.attachEvent('onclick', logoutfunction);
}  
