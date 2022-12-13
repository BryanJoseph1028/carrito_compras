/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ProductoDAO;
import modelo.Producto;
import modelo.Carrito;
import modelo.Cliente;
import modelo.Fecha;
import modelo.Pago;
import modelo.Venta;
import modelo.VentaDAO;
/*import modelo.Empleado;*/

/**
 *
 * @author Wilmer
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ProductoDAO pdao = new ProductoDAO();
    Producto p=new Producto();
    List<Producto> productos = new ArrayList<>();
    
    List<Carrito> listaCarrito=new ArrayList<>();
    int item;
    double totalPagar=0.0;
    int cantidad = 1;
    
    int idp;
    Carrito car;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String accion=request.getParameter("accion");
       productos=pdao.listar();
       switch(accion){           
                case "Comprar":
                    totalPagar=0.0;
                    idp=Integer.parseInt(request.getParameter("id_producto"));
                    p=pdao.listraId_producto(idp);
                    item=item+1;
                    car=new Carrito();
                    car.setItem(item);
                    car.setId_producto(p.getId_producto());
                    car.setProducto(p.getProducto());
                    car.setDescripcion(p.getDescripcion());
                    car.setImagen(p.getImagen());
                    car.setPrecio_venta(p.getPrecio_venta());
                    car.setExistencia(cantidad);/*Puede que tenga que hacer algo haci cantidad-p.getExistencia() */
                    car.setSub_total(cantidad*p.getPrecio_venta());
                    listaCarrito.add(car);
                    for(int i=0;i<listaCarrito.size();i++){
                        totalPagar=totalPagar+listaCarrito.get(i).getSub_total();/*El i puede que cambie, habra que revisar*/
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("carrito", listaCarrito);
                    request.setAttribute("contador", listaCarrito.size());
                    request.getRequestDispatcher("carrito_compras.jsp").forward(request, response);
                    break;
                case "AgregarCarrito":
                    int pos = 0;
                    cantidad = 1;
                    idp=Integer.parseInt(request.getParameter("id_producto"));
                    p=pdao.listraId_producto(idp);
                    if(listaCarrito.size()>0){
                        for(int i =0; i< listaCarrito.size();i++){
                            if(idp==listaCarrito.get(i).getId_producto()){/*Ese "i" puede que lo tenga que cambiar*/
                                pos=i;
                            }
                            if(idp==listaCarrito.get(pos).getId_producto()){
                                cantidad=listaCarrito.get(pos).getExistencia()+cantidad;
                                double subtotal=listaCarrito.get(pos).getPrecio_venta()*cantidad;
                                listaCarrito.get(pos).setExistencia(cantidad);
                                listaCarrito.get(pos).setSub_total(subtotal);
                            }else{
                                item=item+1;
                                car=new Carrito();
                                car.setItem(item);
                                car.setId_producto(p.getId_producto());
                                car.setProducto(p.getProducto());
                                car.setDescripcion(p.getDescripcion());
                                car.setImagen(p.getImagen());
                                car.setPrecio_venta(p.getPrecio_venta());
                                car.setExistencia(cantidad);/*Puede que tenga que hacer algo haci cantidad-p.getExistencia() */
                                car.setSub_total(cantidad*p.getPrecio_venta());
                                listaCarrito.add(car);
                            }
                        }
                    }else{
                        item=item+1;
                        car=new Carrito();
                        car.setItem(item);
                        car.setId_producto(p.getId_producto());
                        car.setProducto(p.getProducto());
                        car.setDescripcion(p.getDescripcion());
                        car.setImagen(p.getImagen());
                        car.setPrecio_venta(p.getPrecio_venta());
                        car.setExistencia(cantidad);/*Puede que tenga que hacer algo haci cantidad-p.getExistencia() */
                        car.setSub_total(cantidad*p.getPrecio_venta());
                        listaCarrito.add(car);
                    }
                    
                    request.setAttribute("contador", listaCarrito.size());
                    request.getRequestDispatcher("Controlador?accion=carrito").forward(request, response);
                    break;
                case "Delete":
                    int idproducto=Integer.parseInt(request.getParameter("id_pro"));
                    for (int i = 0; i < listaCarrito.size(); i++){
                        if(listaCarrito.get(i).getId_producto()==idproducto){
                            listaCarrito.remove(i);
                        }
                    }
                    break;
                case "ActualizarCantidad":
                    int idpro=Integer.parseInt(request.getParameter("idpro"));
                    int cant=Integer.parseInt(request.getParameter("Cantidad"));
                    for(int i = 0; i < listaCarrito.size(); i++){
                        if(listaCarrito.get(i).getId_producto()==idpro){
                            listaCarrito.get(i).setExistencia(cant);
                            double st=listaCarrito.get(i).getPrecio_venta()*cant;
                            listaCarrito.get(i).setSub_total(st);
                        }
                    }
                    break;
                case "Carrito":
                    totalPagar=0.0;
                    request.setAttribute("carrito", listaCarrito);
                    for(int i=0;i<listaCarrito.size();i++){
                        totalPagar=totalPagar+listaCarrito.get(i).getSub_total();/*El i puede que cambie, habra que revisar*/
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.getRequestDispatcher("carrito_compras.jsp").forward(request, response);
                    break;
                case "Nuevo":
                    listaCarrito = new ArrayList<>();
                    request.getRequestDispatcher("Controlador?accion=carrito").forward(request, response);
                    break;
                case "GenerarCompra":
                    Cliente cliente = new Cliente();
                    cliente.setId(1);
                    VentaDAO dao=new VentaDAO();
                    /*Empleado empleado = new Empleado();*/
                    //Pago pago=new Pago();
                    Venta venta = new Venta(1, "B", Fecha.FechaBD(), 1, 1, "2020-11-02 17:27:55", 1, totalPagar, "Cancelado", listaCarrito);
                    int res=dao.GenerarVentas(venta);
                    if(res!=0&&totalPagar>0){
                        request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                    }else{
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                    break;
                default:
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("index.jsp").forward(request, response);/*Si funcion, cambiar index.jsp por el nombre que le valla a poner*/
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
