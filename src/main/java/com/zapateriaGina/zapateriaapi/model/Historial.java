package com.zapateriaGina.zapateriaapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tblHistorial")
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistorial;
    @Column(length = 50)
    private String fecha;
    //Relations
    @OneToOne
    @JoinColumn(name = "IdVenta")
    private Venta venta;

    //Setters & Getters

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    //Setters Externos
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }



    //Constructors

    public Historial(int idHistorial, String fecha) {
        this.idHistorial = idHistorial;
        this.fecha = fecha;
    }

    public Historial() {
    }

    @Override
    public String toString(){
        return "Registro Historial{" +
                "idHistorial =" + idHistorial +'\'' +
                ", fecha = " + fecha +
                "}";
    }
}
