//nombre del package (model)

package com.zapateriaGina.zapateriaapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference; // usado para desplegar objetos con relación padre-hijo
import com.fasterxml.jackson.annotation.JsonProperty; //marca objetos hijo
import jakarta.persistence.*; //gestiona datos relacionales en aplicaciones de Java empresariales

import java.util.List; //Para la coleccion ordenada que permite el acceso indexado

@Entity
@Table(name = "calzado")
public class Calzado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCalzado;
    @Column(nullable = false, length = 200)
    private String marca;
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

    //Relations
    //Calzado n:1 Ventas
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idVenta")
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    private Venta venta;
    //
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "idTalla")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Talla talla;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "idProveedor")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Proveedores proveedores;

    public Calzado() {
    }

    public Calzado(String marca, String modelo, String color, float precioCosto, float precioMayoreo, float precioPublico) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precioCosto = precioCosto;
        this.precioMayoreo = precioMayoreo;
        this.precioPublico = precioPublico;
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
        return modelo;}

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

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    @Override
    public String toString() {
        return "Calzado{" +
                "idCalzado=" + idCalzado +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", precioCosto=" + precioCosto +
                ", precioMayoreo=" + precioMayoreo +
                ", precioPublico=" + precioPublico +
                '}';
    }
}

