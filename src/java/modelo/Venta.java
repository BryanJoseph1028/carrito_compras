/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author Wilmer
 */
public class Venta {
    private int id;
    private int no_factura;
    private String serie;
    private String fecha_factura;
    private int id_cliente;
    private int id_empleado;
    private String fecha_ingreso;
    private int id_pago;
    private Double monto;
    private String estado;
    
    private List<Carrito>detalleventas;

    public Venta(){}
    public Venta(int no_factura, String serie, String fecha_factura, int id_cliente, int id_empleado, String fecha_ingreso, int id_pago, Double monto, String estado, List<Carrito> detalleventas) {
        this.no_factura = no_factura;
        this.serie = serie;
        this.fecha_factura = fecha_factura;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.fecha_ingreso = fecha_ingreso;
        this.id_pago = id_pago;
        this.monto = monto;
        this.estado = estado;
        this.detalleventas = detalleventas;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNo_factura() {
        return no_factura;
    }

    public void setNo_factura(int no_factura) {
        this.no_factura = no_factura;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(String fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Carrito> getDetalleventas() {
        return detalleventas;
    }

    public void setDetalleventas(List<Carrito> detalleventas) {
        this.detalleventas = detalleventas;
    }
    
    
    
}
