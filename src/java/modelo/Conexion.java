/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Wilmer
 */
public class Conexion {
    public Connection conexionBD;/*Usar en vez de con*/
    private final String puerto= "3306";
    private final String bd= "dbempresa";
    private final String urlConexion = String.format("jdbc:mysql://localhost:%s/%s?serverTimezone=UTC",puerto, bd);
    private final String usuario = "usuar_empresa";
    private final String contra = "empresa1109@1212";
    private final String jdbc ="com.mysql.cj.jdbc.Driver";
    
    public void abrir_conexion(){ /*Usar en vez de getConnection*/
            try{
                Class.forName(jdbc);
                conexionBD = DriverManager.getConnection(urlConexion,usuario,contra); 
            }catch(ClassNotFoundException | SQLException ex){
                    System.out.println("Error..." + ex.getMessage());
            }
    }
    
    public void cerrar_conexion(){
        try{
            conexionBD.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexionBD = DriverManager.getConnection(urlConexion, usuario, contra);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error..." + ex.getMessage());
        }
        return conexionBD;
    }
}
