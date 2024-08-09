package com.apprestaurante.AppRestaurante.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Restaurante {

    @Id
    private Long id;

    private String nombreDelNegocio;
    private String paginaWeb;  // Verifica que este nombre sea consistente
    private String correo;
    private String telefono;

    // Constructor por defecto (necesario para JPA)
    public Restaurante() {
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreDelNegocio() {
        return nombreDelNegocio;
    }

    public void setNombreDelNegocio(String nombreDelNegocio) {
        this.nombreDelNegocio = nombreDelNegocio;
    }

    public String getPaginaWeb() {  // Asegúrate de que el nombre del método sea correcto
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {  // Asegúrate de que el tipo coincida
        this.paginaWeb = paginaWeb;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}


