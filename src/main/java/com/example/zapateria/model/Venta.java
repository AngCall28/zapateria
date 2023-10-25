package com.example.zapateria.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    @Column(scale = 2)
    private float montoTotal;

    @Column(nullable = false, length = 100)
    private int cantidadPares;
    //REVISAR SI FUNCIONA CON MERGE AL ELIMINAR O SE QUITA LA NOTACIÓN CASCADE
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "VentaCalzado",
            joinColumns = @JoinColumn(name = "idVenta", referencedColumnName = "idVenta"),
            inverseJoinColumns = @JoinColumn(name = "idCalzado", referencedColumnName = "idCalzado")
    )
    private List<Calzado> calzados;

    public Venta() {

    }

    public Venta(float montoTotal, int cantidadPares) {
        this.montoTotal = montoTotal;
        this.cantidadPares = cantidadPares;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
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

    public List<Calzado> getCalzados() {
        return calzados;
    }

    public void setCalzados(List<Calzado> calzados) {
        this.calzados = calzados;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", montoTotal=" + montoTotal +
                ", cantidadPares=" + cantidadPares +
                '}';
    }
}

