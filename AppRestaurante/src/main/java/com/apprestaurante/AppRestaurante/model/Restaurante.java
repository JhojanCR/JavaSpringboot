package com.apprestaurante.AppRestaurante.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Restaurante {
    private Long id;
    private String nombreDelNegocio;
    private String paginaWeb;
    private String correo;
    private String telefono;

    @Id
    public Long getId(){
        return  id;
    }

    public  void setId(Long id){
        this.id = id;
    }

    public String getNombreDelNegocio(){
        return nombreDelNegocio;
    }

    public void setNombreDelNegocio(String nombreDelNegocio){
        this.nombreDelNegocio = nombreDelNegocio;
    }

    public String getPaginaWeb(){
        return  paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb){
        this.paginaWeb = paginaWeb;
    }

    public String getCorreo(){
        return  correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getTelefono(){
        return  telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

}
