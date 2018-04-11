package com.defvnygm.feliz.defvnygmv1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FormUsuario extends AppCompatActivity {

    private EditText input_nombre, input_apPaterno,input_apMaterno,input_correo,input_telefono,input_direccion;
    private ProgressBar circular_progress;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    private List<Usuario> list_usuarios = new ArrayList<>();

    private Usuario selectedUsuario; //hold user when we select item in listview

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_usuario1);

       /* //Add toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        //Control
        circular_progress = (ProgressBar)findViewById(R.id.circular_progress);
        input_nombre = (EditText)findViewById(R.id.nombre);
        input_apPaterno = (EditText)findViewById(R.id.apPaterno);
        input_apMaterno = (EditText)findViewById(R.id.apMaterno);
        input_correo = (EditText)findViewById(R.id.correo);
        input_telefono = (EditText)findViewById(R.id.telefono);
        input_direccion = (EditText)findViewById(R.id.direccion);

        //FirebaseDatabase
        initFirebase();
        addEventFirebaseListener();
    }

    private void initFirebase() {
        FirebaseApp.initializeApp(this);
        mFirebaseDatabase = mFirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference();
    }

    private void addEventFirebaseListener() {
       /* //Progressing
        circular_progress.setVisibility(View.INVISIBLE);*/

        /*mDatabaseReference.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(list_users.size() > 0){
                    list_users.clear();
                    for(DataSnapshot postSnapshot:dataSnapshot.getChildren()){
                        User user = postSnapshot.getValue(User.class);
                        list_users.add(user);
                    }
                    ListViewAdapter adapter = new ListViewAdapter(MainActivity.this,list_users);
                    list_data.setAdapter(adapter);

                    circular_progress.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_save){
            agregarUsuario();
        }/*else if(item.getItemId() == R.id.menu_save){
            Usuario usuario = new Usuario(selectedUsuario.getUid(),input_nombre.getText().toString(),input_apPaterno.getText().toString(),input_apMaterno.getText().toString(),input_correo.getText().toString(),input_telefono.getText().toString(),input_direccion.getText().toString());
            updateUsuario(usuario);
        }*//*
        else if(item.getItemId() == R.id.menu_remove){
            deleteUsuario(selectedUsuario);
        }*/
        return true;
    }

    private void updateUsuario(Usuario usuario) {
        mDatabaseReference.child("usuarios").child(usuario.getUid()).child("nombre").setValue(usuario.getNombre());
        mDatabaseReference.child("usuarios").child(usuario.getUid()).child("apPaterno").setValue(usuario.getApPaterno());
        mDatabaseReference.child("usuarios").child(usuario.getUid()).child("apMaterno").setValue(usuario.getApMaterno());
        mDatabaseReference.child("usuarios").child(usuario.getUid()).child("correo").setValue(usuario.getCorreo());
        mDatabaseReference.child("usuarios").child(usuario.getUid()).child("telefono").setValue(usuario.getTelefono());
        mDatabaseReference.child("usuarios").child(usuario.getUid()).child("direccion").setValue(usuario.getDireccion());
        clearEditText();
    }

    private void agregarUsuario(){
        Usuario usuario = new Usuario(UUID.randomUUID().toString(),input_nombre.getText().toString(),input_apPaterno.getText().toString(),
                input_apMaterno.getText().toString(),input_correo.getText().toString(),input_telefono.getText().toString(),input_direccion.getText().toString());
        mDatabaseReference.child("usuarios").child(usuario.getUid()).setValue(usuario);
        clearEditText();
    }

    private void clearEditText(){
        input_nombre.setText("");
        input_apPaterno.setText("");
        input_apMaterno.setText("");
        input_correo.setText("");
        input_telefono.setText("");
        input_direccion.setText("");
    }
    public void onClick(View view){
        finish();
    }
}
