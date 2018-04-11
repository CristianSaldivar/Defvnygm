window.onload = inicializar;
var btnCerrar;
function inicializar(){
    btnCerrar = document.getElementById("menu");
    btnCerrar.addEventListener("submit", cerrarSesion, false);
}
function cerrarSesion(){
  firebase.auth().signOut().then(function() {
    window.location.href = "index.html";
}, function(error) {
    alert('Algo salio mal');
});

}


