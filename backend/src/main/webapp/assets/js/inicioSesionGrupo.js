window.onload = inicializar;

var formAutenticacion;

function inicializar() {
    formAutenticacion = document.getElementById("form-inicio-grupo");
    formAutenticacion.addEventListener("submit", iniciarSesionGrupo, false);
    
}
function iniciarSesionGrupo(event){
    event.preventDefault();
    var email = event.target.email.value;
    var contrasena = event.target.contrasena.value;
    
   firebase.auth().signInWithEmailAndPassword(email, contrasena)
    .then(function(result){
        
        window.location.href = "gruposindex.html";
   })       
    .catch(function(error) {
        alert("Verifica tu correo o contraseña, alguno de ellos no son correctos");
  });

}

