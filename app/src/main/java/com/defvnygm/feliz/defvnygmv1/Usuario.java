package com.defvnygm.feliz.defvnygmv1;

import android.support.annotation.Size;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by feliz on 25/07/2017.
 */

public class Usuario {

    @NotNull
    private String uid;
    @NotNull @Size(min = 1, max = 30)
    private String nombre;
    @NotNull @Size(min = 1, max = 30)
    private String apPaterno;
    @NotNull @Size(min = 1, max = 30)
    private String apMaterno;
    @NotNull @Size(min = 1, max = 50)
    private String correo;
    @NotNull @Size(min = 1, max = 10)
    private String telefono;
    @NotNull @Size(min = 1, max = 300)
    private String direccion;

    public Usuario() {
    }

    public Usuario(@NotNull String uid, @NotNull String nombre, @NotNull String apPaterno, @NotNull String apMaterno, @NotNull String correo, @NotNull String telefono, @NotNull String direccion) {
        this.uid = uid;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    @NotNull
    public String getUid() {
        return uid;
    }

    public void setUid(@NotNull String uid) {
        this.uid = uid;
    }

    @NotNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NotNull String nombre) {
        this.nombre = nombre;
    }

    @NotNull
    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(@NotNull String apPaterno) {
        this.apPaterno = apPaterno;
    }

    @NotNull
    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(@NotNull String apMaterno) {
        this.apMaterno = apMaterno;
    }

    @NotNull
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(@NotNull String correo) {
        this.correo = correo;
    }

    @NotNull
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NotNull String telefono) {
        this.telefono = telefono;
    }

    @NotNull
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(@NotNull String direccion) {
        this.direccion = direccion;
    }

    public static boolean isEmailValid(String correo) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = correo;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
}
