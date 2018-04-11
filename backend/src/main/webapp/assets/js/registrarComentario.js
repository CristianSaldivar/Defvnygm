window.onload = inicializar;

var formComentarios;
var refComentarios;
var tbodyTablaCoementarios;
var CREATE = "Añadir Comentario";
var modo = CREATE;
var refComentarioAEditar;

function inicializar(){
    formComentarios = document.getElementById("form-comentarios");
    formComentarios.addEventListener("submit", enviarComentarioFirebase, false);
    tbodyTablaCoementarios = document.getElementById("tbody-tabla-comentarios");
    refComentarios = firebase.database().ref().child("comentarios");
}

function enviarComentarioFirebase(event) {
    switch (modo){
        case CREATE:
                refComentarios.push({
                   nombre: event.target.nombre.value,
                   email: event.target.email.value,
                   comentario: event.target.comentario.value
                });
              modo = CREATE;
             document.getElementById("enviar-coment").value = CREATE;
             break;
    }
    
    formComentarios.reset();
}


