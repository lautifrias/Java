/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author La Minera
 */
public class DB {
    
    
        Connection conexion; 
        String cadenaConexion = "jdbc:mysql://localhost/carrera?ServerTimezone=UTC";
        String usuario = "root";
        String clave = "";    

        public DB(){
            try {
                conexion = DriverManager.getConnection(cadenaConexion, usuario, clave);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());;
            }
        }
        public void agregarPerro(Perro p){
             try{
                PreparedStatement s = conexion.prepareStatement(
                "INSERT INTO perro (numero, nombre, tiempo) values(?,?,?)" );
                
                s.setInt(1, p.getNumero());
                s.setString(2, p.getNombre());
                s.setTime(3, p.getTiempo());

                
                s.executeUpdate();
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
          public void eliminarPerro(int numero){
            Statement s; 
            try {
                s = conexion.createStatement();
                s.executeUpdate("DELETE FROM perro WHERE NUMERO= "+ numero);
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());    
            }
            
            
        }
    
          
          
          public void modificarPerro(Perro p){
            try{
                PreparedStatement s = conexion.prepareStatement(
                "UPDATE perro SET nombre = ?, tiempo = ? WHERE numero=?" );
                
                
                s.setString(1, p.getNombre());
                s.setTime(2, p.getTiempo());
                s.setInt(3, p.getNumero());
                
                s.executeUpdate();
                
            }catch(Exception e){
                System.out.println(e);
            }


        }
          public ArrayList<Perro> obtenerPerros(){
            ArrayList<Perro> lista = new ArrayList<>();
            
            try {
                Statement s;
                s = conexion.createStatement();
                ResultSet res = s.executeQuery("SELECT * FROM perro order by tiempo");
                while(res.next()){
                    Perro p = new Perro(
                    res.getInt("numero"),
                    res.getString("nombre"),
                     res.getTime("tiempo")
                   );
                    lista.add(p);
                    
                }
                
            } catch (Exception e) {
                System.out.println(e);    
            }            
            
            
            
            
            return lista;
        }



}
        

