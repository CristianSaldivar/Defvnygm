window.onload = inicializar;

var formGeneros;
var refGeneros;
var tbodyTablaGeneros;
var CREATE = "Añadir Genero";
var UPDATE = "Modificar Genero";
var modo = CREATE;
var refGeneroAEditar;

function inicializar(){
    formGeneros = document.getElementById("form-generos");
    formGeneros.addEventListener("submit", agregarGenero, false);
    tbodyTablaGeneros = document.getElementById("tbody-tabla-generos");
    refGeneros = firebase.database().ref().child("generos");
    
    mostrarGenerosDeFirebase();
}

function agregarGenero(event) {
    event.preventDefault();
    switch (modo){
        case CREATE:
                refGeneros.push({
                   genero: event.target.genero.value,
                   descripcion: event.target.descripcion.value
                });
             break;
        case UPDATE:
                refGeneroAEditar.update({
                   genero: event.target.genero.value,
                   descripcion: event.target.descripcion.value
                });
             modo = CREATE;
             document.getElementById("enviar-genero").value = CREATE;
             break;
    }
    
    formGeneros.reset();
}

function mostrarGenerosDeFirebase() {
    refGeneros.on("value", function (snap) {
        var datos = snap.val();
        var filasAMostrar = "";
        for (var key in datos){
            filasAMostrar += "<tr>" +
                                "<td>" + datos[key].genero + "</td>" +
                                "<td>" + datos[key].descripcion + "</td>" +
                                "<td>" +
                                 
                                    '<button  class="editar button special icon fa-edit" genero="' + key + '">' + 
                                    '</button>' + 
                                "</td>" +
                                '<td>' +
                                    '<button class="borrar button special icon fa-dribbble" genero="' + key + '">'+ 
                                    '</button>' +
                                '</td>' +
                             "</tr>";
        }
        tbodyTablaGeneros.innerHTML = filasAMostrar;
        if(filasAMostrar != ""){
           var elementosEditables = document.getElementsByClassName("editar");
            for (var i = 0;i < elementosEditables.length; i++){
                elementosEditables[i].addEventListener("click", editarGenerosDeFirebase,false);
            }
            var elementosBorrables = document.getElementsByClassName("borrar");
            for (var i = 0;i < elementosBorrables.length; i++){
                elementosBorrables[i].addEventListener("click", borrarGenerosDeFirebase,false);
            }
        }
    });
}
function editarGenerosDeFirebase(){
     var keyDeGeneroAEditar = this.getAttribute("genero"); 
     refGeneroAEditar = refGeneros.child(keyDeGeneroAEditar);
     refGeneroAEditar.once("value",function(snap){
        var datos = snap.val();
        document.getElementById("genero").value = datos.genero;
        document.getElementById("descripcion").value = datos.descripcion;
     });
     document.getElementById("enviar-genero").value = UPDATE;
     modo = UPDATE;
     
}
function borrarGenerosDeFirebase(){
     var keyDeGeneroABorrar = this.getAttribute("genero");
     var refGeneroABorrar = refGeneros.child(keyDeGeneroABorrar);
     refGeneroABorrar.remove();
}


