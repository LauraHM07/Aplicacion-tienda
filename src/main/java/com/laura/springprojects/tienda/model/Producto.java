package com.laura.springprojects.tienda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.laura.springprojects.tienda.utils.ImageUtil;

@Entity
public class Producto {
    @Id
    @GeneratedValue
    private int codigo;
    private String nombre;
    private String descripcion;
    private Double precio;
    @Lob
    @Column(length = 100000)
    private byte[] foto;

    public Producto() {
    }

    public Producto(int codigo) {
        this.codigo = codigo;
    }

    public Producto(int codigo, String nombre, String descripcion, Double precio, byte[] foto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.foto = foto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(double d) {
        this.precio = d;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] image) {
        this.foto = image;
    }

    public String getImageView() {
        return ImageUtil.getImgData(this.foto);
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
        Producto other = (Producto) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }
}