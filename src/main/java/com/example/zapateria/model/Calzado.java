/*
//nombre del package (model)

package com.example.zapateria.model;

import com.fasterxml.jackson.annotation.JsonBackReference; // usado para desplegar objetos con relación padre-hijo
import com.fasterxml.jackson.annotation.JsonProperty; //marca objetos hijo
import jakarta.persistence.*; //gestiona datos relacionales en aplicaciones de Java empresariales

import java.util.List; //Para la coleccion ordenada que permite el acceso indexado

@Entity
public class Calzado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCalzado;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "idUsuario")
    //private Usuario marca;
    @Column(nullable = false, length = 200)
    private String modelo;
    @Column(nullable = false, length = 50)
    private String color;
    @Column(nullable = false, length = 32)
    private float precioCosto;
    @Column(nullable = false, length = 32)
    private float precioMayoreo;
    @Column(nullable = false, length = 32)
    private float precioPublico;

    public Calzado() {
    }

    public Integer getIdCalzado() {
        return idCalzado;
    }

    public void setIdCalzado(Integer idCalzado) {
        this.idCalzado = idCalzado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(float precioCosto) {
        this.precioCosto = precioCosto;
    }

    public float getPrecioMayoreo() {
        return precioMayoreo;
    }

    public void setPrecioMayoreo(float precioMayoreo) {
        this.precioMayoreo = precioMayoreo;
    }

    public float getPrecioPublico() {
        return precioPublico;
    }

    public void setPrecioPublico(float precioPublico) {
        this.precioPublico = precioPublico;
    }


}
        */
