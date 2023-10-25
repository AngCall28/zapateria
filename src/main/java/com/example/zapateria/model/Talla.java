//nombre del package (model)
package com.example.zapateria.model;

import com.fasterxml.jackson.annotation.JsonBackReference; // usado para desplegar objetos con relación padre-hijo
import com.fasterxml.jackson.annotation.JsonProperty; //marca objetos hijo
import jakarta.persistence.*; //gestiona datos relacionales en aplicaciones de Java empresariales

import java.util.List; //Para la coleccion ordenada que permite el acceso indexado

@Entity
public class Talla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTalla;
    @Column(nullable = false, length = 4)
    private int medidaMX;

    public Talla() {
    }

    public Talla(Integer idTalla, int medidaMX) {
        this.idTalla = idTalla;
        this.medidaMX = medidaMX;
    }

    public Integer getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(Integer idTalla) {
        this.idTalla = idTalla;
    }

    public int getMedidaMX() {
        return medidaMX;
    }

    public void setMedidaMX(int medidaMX) {
        this.medidaMX = medidaMX;
    }


}
