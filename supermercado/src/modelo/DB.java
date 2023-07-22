/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import vistas.VistaPrincipal;
/**
 *
 * @author La Minera
 */
public class DB {
    
     Connection conexion; 
        String cadenaConexion = "jdbc:mysql://localhost/supermercado?ServerTimezone=UTC";
        String usuario = "root";
        String clave = "";
        
        public DB(){
            try {
                conexion = DriverManager.getConnection(cadenaConexion, usuario, clave);
                System.out.println("conectado");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());;
            }
        }
        
        
        public void agregarVenta(Venta v){
            try{
                PreparedStatement s = conexion.prepareStatement(
                "INSERT INTO caja (producto, precio, cantidad) values(?,?,?)" );
                
                
                s.setString(1, v.getProducto());
                s.setInt(2, v.getPrecio());
                s.setInt(3, v.getCantidad());
                
                s.executeUpdate();
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        
        public void eliminarVenta(int codigo){
            Statement s; 
            try {
                s = conexion.createStatement();
                s.executeUpdate("DELETE FROM caja WHERE codigo= "+ codigo);
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());    
            }
            
            
        }
        
        public void modificarVenta(Venta v){
            try{
                PreparedStatement s = conexion.prepareStatement(
                "UPDATE caja SET producto = ?, precio = ?, cantidad = ? WHERE codigo=?" );
                
                
                s.setString(1, v.getProducto());
                s.setInt(2, v.getPrecio());
                s.setInt(3, v.getCantidad());
                s.setInt(4, v.getCodigo());
                
                s.executeUpdate();
                
            }catch(Exception e){
                System.out.println(e);
            }


        }
        
        
        public ArrayList<Venta> obtenerVenta(){
            ArrayList<Venta> lista = new ArrayList<>();
            
            try {
                Statement s;
                s = conexion.createStatement();
                ResultSet res = s.executeQuery("SELECT * FROM caja order by codigo");
                while(res.next()){
                    Venta v = new Venta(
                    res.getInt("codigo"),
                    res.getString("producto"),
                    res.getInt("precio"),
                            res.getInt("cantidad")
                   );
                    lista.add(v);
                    
                }
                
            } catch (Exception e) {
                System.out.println(e);    
            }            
            
            
            
            
            return lista;
        }
        
    }

    

