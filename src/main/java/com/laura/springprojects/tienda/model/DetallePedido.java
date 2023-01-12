package com.laura.springprojects.tienda.model;

public class DetallePedido {

    private int codigo;
    private Producto producto;
    private int cantidad;
    private double subtotal;
    
    public DetallePedido() {
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double d) {
        this.subtotal = d;
    }


    public int getCodigo() {
        return codigo;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}