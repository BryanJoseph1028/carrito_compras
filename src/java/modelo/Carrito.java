/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Wilmer
 */
public class Carrito {
    int item, id_producto,existencia;
    String producto,descripcion,imagen;
    double precio_venta,sub_total;

    public Carrito(){}
    public Carrito(int item, int id_producto, int existencia, String producto, String descripcion, String imagen, double precio_venta, double sub_total) {
        this.item = item;
        this.id_producto = id_producto;
        this.existencia = existencia;
        this.producto = producto;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio_venta = precio_venta;
        this.sub_total = sub_total;
    }

    
    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }

   

    
    
}
