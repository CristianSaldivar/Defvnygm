package com.defvnygm.feliz.defvnygmv1;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by feliz on 21/07/2017.
 */

public class GrupoVo implements Serializable{

    private String nombre;
    private String info;
    private String descripcion;
    private int imagenId;
    private int imagenDetalle;

    public GrupoVo() {

    }

    public GrupoVo(String nombre, String info, String descripcion, int imagenId, int imagenDetalle) {
        this.nombre = nombre;
        this.info = info;
        this.descripcion = descripcion;
        this.imagenId = imagenId;
        this.imagenDetalle = imagenDetalle;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagenDetalle() {
        return imagenDetalle;
    }

    public void setImagenDetalle(int imagenDetalle) {
        this.imagenDetalle = imagenDetalle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }

    private int obtenerAncho(Bitmap imagenId){
        int anchoNuevo;
        int anchoActual=imagenId.getWidth();

        if(anchoActual>=1100){
            anchoNuevo=(anchoActual*30)/100;
        } else {
            anchoNuevo=anchoActual;
        }
        return anchoNuevo;
    }

    private int obtenerAlto(Bitmap imagenId){
        int altoNuevo;
        int altoActual=imagenId.getHeight();

        if(imagenId.getWidth()>=1100){
            altoNuevo=(altoActual*30)/100;
        } else {
            altoNuevo=altoActual;
        }
        return altoNuevo;
    }
}
