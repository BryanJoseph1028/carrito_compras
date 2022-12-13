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

/**
 *
 * @author Wilmer
 */
public class ProductoDAO {
    Connection conexionBD;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public Producto listraId_producto(int id_producto){
        String sql="select * from productos where id_producto="+id_producto;
        Producto p=new Producto();
        try{
            conexionBD=cn.getConnection();
            ps=conexionBD.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setId_producto(rs.getInt(1));
                p.setProducto(rs.getString(2));
                p.setDescripcion(rs.getString(4));
                p.setImagen(rs.getString(5));
                p.setPrecio_venta(rs.getFloat(7));
                p.setExistencia(rs.getInt(8));
            }
        }catch(SQLException ex){
        }
        return p;
    }
    
    public List listar(){
     List<Producto>productos= new ArrayList();
     String sql="select * from productos;";
     try{
          conexionBD=cn.getConnection();
          ps=conexionBD.prepareStatement(sql);
          rs=ps.executeQuery();
          while(rs.next()){
              Producto p=new Producto();
              p.setId_producto(rs.getInt(1));
              p.setProducto(rs.getString(2));
              p.setDescripcion(rs.getString(4));
              p.setImagen(rs.getString(5));
              p.setPrecio_venta(rs.getFloat(7));
              p.setExistencia(rs.getInt(8));
              productos.add(p);
          }
     }catch(SQLException ex){
         System.out.println(ex.getMessage());
     }
     return productos;
    }
}
