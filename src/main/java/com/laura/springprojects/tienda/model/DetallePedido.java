package com.laura.springprojects.tienda.model;

public class DetallePedido {
    private int codigo;
    private Producto producto;
    private int cantidad;
    
    public DetallePedido() {
    }

    public DetallePedido(int codigo) {
        this.codigo = codigo;
    }

    public DetallePedido(int codigo, Producto producto, int cantidad) {
        this.codigo = codigo;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DetallePedido other = (DetallePedido) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }
}
