package com.laura.springprojects.tienda.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Pedido {
    @Id
    @GeneratedValue
    private int codigo;
    private double total;
    private Date fecha;
    @OneToMany()
    @JoinColumn(name="codigo_cliente")
    private Cliente cliente;
    @Transient
    private List<DetallePedido> detallePedidos;

    public Pedido() {
        this.cliente = new Cliente();
        this.detallePedidos = new ArrayList<DetallePedido>();
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getTotalCesta() {

        total = 0;
        for (DetallePedido detalle : this.detallePedidos) {
            total += detalle.getCantidad() * detalle.getProducto().getPrecio();
        }

        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    public double getTotal() {
        return total;
    }
}