/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import modelo.Cliente;
/**
 *
 * @author Wilmer
 */
public class VentaDAO {
    Connection conexionBD;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;
    
    public int GenerarVentas(Venta venta){
        int idventa;
        String sql="INSERT INTO ventas(no_factura,serie,fecha_factura,id_cliente,id_empleado,fecha_ingreso,id_pago,monto,estado) VALUES (?,?,?,?,?,?,?,?,?);";
        try{
            conexionBD=cn.getConnection();
            ps=conexionBD.prepareStatement(sql);
            ps.setInt(1, venta.getNo_factura());
            ps.setString(2, venta.getFecha_factura());
            ps.setInt(3, venta.getId_cliente());/*Estos creo que se tiene que modificar ps.setInt(3, venta.getId_cliente().getId()); pero nose como*/
            ps.setInt(4, venta.getId_empleado());
            ps.setInt(5, venta.getId_pago());
            ps.setDouble(6, venta.getMonto());
            ps.setString(7, venta.getEstado());
            r=ps.executeUpdate();
            
            sql="Select @@IDENTITY AS id_venta";
            rs=ps.executeQuery(sql);
            rs.next();
            idventa=rs.getInt("id_venta");
            rs.close();
            
            for(Carrito detalle : venta.getDetalleventas()){
                sql="INSERT INTO ventas_detalle(id_venta,id_producto,cantidad,precio_unitario) VALUES (?,?,?,?);";
                ps=conexionBD.prepareStatement(sql);
                ps.setInt(1, detalle.getId_producto());
                ps.setInt(2, idventa);
                ps.setInt(3, detalle.getExistencia());
                ps.setDouble(4, detalle.getPrecio_venta());
                r=ps.executeUpdate();
            }
        }catch(SQLException ex){
        }
        return r;
    }
}
