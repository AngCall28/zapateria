//nombre del package (model)
package com.example.zapateria.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonBackReference; // usado para desplegar objetos con relación padre-hijo
import com.fasterxml.jackson.annotation.JsonProperty; //marca objetos hijo
import jakarta.persistence.*; //gestiona datos relacionales en aplicaciones de Java empresariales


import java.util.List; //Para la coleccion ordenada que permite el acceso indexado

@Entity
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistorial;
    //VERIFICAR LÍNEA 18
    @Column(nullable = false)
    private LocalDateTime fecha;

    //VERIFICAR --historial de ventas?
    @ManyToOne
    @JoinColumn(name = "idVenta")
    private Venta venta;

    public Historial() {
    }

    public Historial(Integer idHistorial, LocalDateTime fecha) {
        this.idHistorial = idHistorial;
        this.fecha = fecha;
    }

    public Integer getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        return "Historial{" +
                "idHistorial=" + idHistorial +
                ", fecha=" + fecha +
                '}';
    }
}