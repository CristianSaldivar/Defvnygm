window.onload = inicializar;

var user = firebase.auth().currentUser;
var credential;

// Prompt the user to re-provide their sign-in credentials

user.reauthenticate(credential).then(function() {
    
   //window.location.href = "inicio.html";
}, function(error) {
  alert("No se ha realizado la autenticacion correcta");
});


