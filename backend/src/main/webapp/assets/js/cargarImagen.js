window.onload = inicializar;

var carga = document.getElementById("carga");
var cargarBoton = document.getElementById("cargarBoton");


cargarBoton.addEventListener('change', function(e){
    //Obtener archivo
    var file = e.target.files[0];
    //Crear referencia del storage
    var storageRef = firebase.storage().ref('ImagenesGrupo/' + file.name);
    //Subir archivo
    var task = storageRef.put(file); 
    //Barra de progreso
    task.on('state_changed',
       function progress(snapshot){
           var percentage = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
           carga.value = percentage;
       },
       
       function error(err){
           
       },
       
       function complete(){
           
       }
    );
});



