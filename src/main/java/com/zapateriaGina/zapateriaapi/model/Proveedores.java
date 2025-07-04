//nombre del package (model)
package com.zapateriaGina.zapateriaapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference; // usado para desplegar objetos con relación padre-hijo
import com.fasterxml.jackson.annotation.JsonProperty; //marca objetos hijo
import jakarta.persistence.*; //gestiona datos relacionales en aplicaciones de Java empresariales

import java.util.List;

@Entity
@Table(name = "proveedores")
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;
    @Column(nullable = false, length = 200)
    private String nombreProveedor;
    @Column(nullable = false, length = 200)
    private String nombrePaginaWeb;
    @Column(nullable = false, length = 50)
    private String numTelefono;
    @Column(nullable = false, length = 32)
    private String nombreMarca;

    public Proveedores() {
    }

    public Proveedores(Integer idProveedor, String nombreProveedor, String nombrePaginaWeb, String numTelefono, String nombreMarca) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.nombrePaginaWeb = nombrePaginaWeb;
        this.numTelefono = numTelefono;
        this.nombreMarca = nombreMarca;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNombrePaginaWeb() {
        return nombrePaginaWeb;
    }

    public void setNombrePaginaWeb(String nombrePaginaWeb) {
        this.nombrePaginaWeb = nombrePaginaWeb;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }


}
