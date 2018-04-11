window.onload = inicializar;

var formAutenticacion;


function inicializar() {
    formAutenticacion = document.getElementById("form-inicio");
    formAutenticacion.addEventListener("submit", autentificar, false);
    
}

function autentificar(event){
    event.preventDefault();
    var email = event.target.email.value;
    var contrasena = event.target.contrasena.value;
    
   firebase.auth().signInWithEmailAndPassword(email, contrasena)
    .then(function(result){
        /*alert("Autenticacion correcta");*/
        window.location.href = "fsdadhnzeajdzdgxfgnjxhnzadmin.html";
   })       
    .catch(function(error) {
        alert("No se ha realizado la autenticacion correcta");
  });

}





