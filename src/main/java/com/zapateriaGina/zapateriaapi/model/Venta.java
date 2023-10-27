package com.zapateriaGina.zapateriaapi.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "tblVenta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;
    @Column (nullable = false, scale = 6)
    private float montoTotal;
    private int cantidadPares;

    //Relations
    //Venta 1:1 con historial
    @OneToOne (mappedBy = "venta", cascade = CascadeType.ALL)
    Historial historial;
    //Venta n:1 con Usuario
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name= "idUsuario")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Usuario usuario;
    //Venta 1:n con Calzado
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<Calzado> calzados = new ArrayList<>();

    //Setters & Getters
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public int getCantidadPares() {
        return cantidadPares;
    }

    public void setCantidadPares(int cantidadPares) {
        this.cantidadPares = cantidadPares;
    }
    //Setter Getter externos
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    //Constructors
    public Venta(int idVenta, float montoTotal, int cantidadPares) {
        this.idVenta = idVenta;
        this.montoTotal = montoTotal;
        this.cantidadPares = cantidadPares;
    }

    public Venta() {
    }

    @Override
    public String toString(){
        return "InfoVenta{" +
                "idVenta =" + idVenta +
                ", Monto Total = " + montoTotal + '\'' +
                ", Cantidad de Pares" + cantidadPares +
                "}";
    }

}
