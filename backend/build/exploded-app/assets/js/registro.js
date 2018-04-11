"use strict";

var nombre = document.getElementById("nombre");
var apPaterno = document.getElementById("apPaterno");
var apMaterno = document.getElementById("apMaterno");
var email = document.getElementById("email");
var contrasena = document.getElementById("contrasena");
var telefono = document.getElementById("telefono");
var btnSubmit = document.getElementById("btnSubmit");

var database = firebase.database("https://defvnygm.firebaseio.com/");

/*function btnClick(){
    var firebaseRef = firebase.database().ref();
    
    firebaseRef.child("nombre").set(nombre);
    firebaseRef.child("apPaterno").set(apPaterno);
    firebaseRef.child("apMaterno").set(apMaterno);
    firebaseRef.child("contrasena").set(contrasena);
    firebaseRef.child("email").set(email);
    firebaseRef.child("telefono").set(telefono);
}*/

function btnClick(nombre, apPaterno, apMaterno, contrasena, email, telefono) {
  firebase.database().ref('Usuario/' + nombre).set({
    nombre: nombre,
    apPaterno: apPaterno,
    apMaterno: apMaterno,
    contrasena: contrasena,
    email: email,
    telefono: telefono
  });
}

