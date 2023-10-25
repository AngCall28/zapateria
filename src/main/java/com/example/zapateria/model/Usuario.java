package com.example.zapateria.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(length = 20)
    private String nivelPermiso;
    @Column(length = 20)
    private String password;
    //@OneToMany (mappedBy = "usuario", cascade = CascadeType.ALL)
    //private List<Venta> ventas = new ArrayList<>(); //REVISAR SI ES CORRECTO, sino, excluir y/o editar setter & getter

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nombre, String nivelPermiso, String password) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.nivelPermiso = nivelPermiso;
        this.password = password;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivelPermiso() {
        return nivelPermiso;
    }

    public void setNivelPermiso(String nivelPermiso) {
        this.nivelPermiso = nivelPermiso;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", nivelPermiso='" + nivelPermiso + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}