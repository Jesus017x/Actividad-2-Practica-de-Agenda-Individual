package com.example.appagenda;

import java.util.Date;

public class EstudiantesListados {
    private int foto;
    private String nombre;
    private String info;
    private String sexo;
    private Date fecha;
    private String direccion;

    public EstudiantesListados(){

    }

    public EstudiantesListados(int foto, String nombre, String info, String sexo, Date fecha, String direccion) {
        this.foto = foto;
        this.nombre = nombre;
        this.info = info;
        this.sexo = sexo;
        this.fecha = fecha;
        this.direccion = direccion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
