//nombre del package (model)
package com.zapateriaGina.zapateriaapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference; // usado para desplegar objetos con relación padre-hijo
import com.fasterxml.jackson.annotation.JsonProperty; //marca objetos hijo
import jakarta.persistence.*; //gestiona datos relacionales en aplicaciones de Java empresariales

import java.util.List; //Para la coleccion ordenada que permite el acceso indexado

@Entity
@Table(name = "talla")
public class Talla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTalla;
    @Column(nullable = false, length = 4)
    private float medidaMX;
    //Relations


    public Talla() {
    }

    public Talla(Integer idTalla, float medidaMX) {
        this.idTalla = idTalla;
        this.medidaMX = medidaMX;
    }

    public Integer getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(Integer idTalla) {
        this.idTalla = idTalla;
    }

    public float getMedidaMX() {
        return medidaMX;
    }

    public void setMedidaMX(float medidaMX) {
        this.medidaMX = medidaMX;
    }


}
