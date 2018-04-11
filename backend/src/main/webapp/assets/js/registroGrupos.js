window.onload = inicializar;

var formGrupos;
var refGrupos;
var tbodyTablaGrupos;
var CREATE = "Añadir Grupo";
var UPDATE = "Modificar Grupo";
var modo = CREATE;
var refGrupoAEditar;

function inicializar() {
    formGrupos = document.getElementById("form-grupos");
    formGrupos.addEventListener("submit", enviarGrupoFirebase, false);
    tbodyTablaGrupos = document.getElementById("tbody-tabla-grupos");
    refGrupos = firebase.database().ref().child("grupos");

    mostrarGruposDeFirebase();
}

function enviarGrupoFirebase(event) {
    switch (modo) {
        case CREATE:
            refGrupos.push({
                nombre: event.target.nombre.value,
                apPaterno: event.target.apPaterno.value,
                apMaterno: event.target.apMaterno.value,
                telefono: event.target.telefono.value,
                email: event.target.email.value,
                contrasena: event.target.contrasena.value,
                nombreg: event.target.nombreg.value,
                /*archivo: event.target.archivo.value,*/
                /*genero: event.target.genero.value,*/
                descripcion: event.target.descripcion.value
            });
            alert("Grupo exitosamente registrado");
            break;
        case UPDATE:
            refGrupoAEditar.update({
                nombre: event.target.nombre.value,
                apPaterno: event.target.apPaterno.value,
                apMaterno: event.target.apMaterno.value,
                telefono: event.target.telefono.value,
                email: event.target.email.value,
                contrasena: event.target.contrasena.value,
                nombreg: event.target.nombreg.value,
                /*archivo: event.target.archivo.value,*/
                /*genero: event.target.genero.value,*/
                descripcion: event.target.descripcion.value
            });
            modo = CREATE;
            document.getElementById("enviar-info").value = CREATE;
            break;
    }

    formGrupos.reset();
}

function borrarGruposDeFirebase() {
    var keyDeGrupoABorrar = this.getAttribute("nombre");
    var refGrupoABorrar = refGrupos.child(keyDeGrupoABorrar);
    refGrupoABorrar.remove();
}

function mostrarGruposDeFirebase() {
    refGrupos.on("value", function (snap) {
        var datos = snap.val();
        var filasAMostrar = "";
        for (var key in datos) {
            filasAMostrar += "<tr>" +
                    "<td>" + datos[key].nombre + "</td>" +
                    "<td>" + datos[key].apPaterno + "</td>" +
                    "<td>" + datos[key].apMaterno + "</td>" +
                    "<td>" + datos[key].telefono + "</td>" +
                    "<td>" + datos[key].email + "</td>" +
                    "<td>" + datos[key].nombreg + "</td>" +
                    '<td>' +
                    '<button class="borrar button special icon fa-dribbble" genero="' + key + '">' +
                    '</button>' +
                    '</td>' +
                    "</tr>";
        }
        tbodyTablaGrupos.innerHTML = filasAMostrar;
        if (filasAMostrar != "") {
            var elementosEditables = document.getElementsByClassName("editar");
            for (var i = 0; i < elementosEditables.length; i++) {
                elementosEditables[i].addEventListener("click", editarGruposDeFirebase, false);
            }
            var elementosBorrables = document.getElementsByClassName("borrar");
            for (var i = 0; i < elementosBorrables.length; i++) {
                elementosBorrables[i].addEventListener("click", borrarGruposDeFirebase, false);
            }
        }
    });
}




