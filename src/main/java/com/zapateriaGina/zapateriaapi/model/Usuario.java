package com.zapateriaGina.zapateriaapi.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column (nullable = false)
    private int nivelPermiso;
    @Column (nullable = false, length = 100)
    private String password;

    //Relations
    @OneToMany (mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Venta> ventas = new ArrayList<>();

    //Setters & Getters

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelPermiso() {
        return nivelPermiso;
    }

    public void setNivelPermiso(int nivelPermiso) {
        this.nivelPermiso = nivelPermiso;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //Setters Externos
    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    //Constructors

    public Usuario(int idUsuario, String nombre, int nivelPermiso, String password) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.nivelPermiso = nivelPermiso;
        this.password = password;
    }

    public Usuario() {
    }

    @Override
    public String toString(){
        return "Usuario{" +
                "idUsuario =" + idUsuario +
                ", nombre = " + nombre + '\'' +
                ", nivelPermiso" + nivelPermiso + '\'' +
                //Honestamente esto (las password) no se deben almacenar asi, sin embargo se seguira con la practica
                // ignorando los problemas de seguridad que esto implicaria
                ", pass = " + password +
                "}";
    }
}
