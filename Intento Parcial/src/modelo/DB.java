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
        String cadenaConexion = "jdbc:mysql://localhost/parcial?ServerTimezone=UTC";
        String usuario = "root";
        String clave = "";
        
        public DB(){
            try {
                conexion = DriverManager.getConnection(cadenaConexion, usuario, clave);
                System.out.println("hola");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());;
            }
        }
        
        
        public void agregarEmpleado(Empleado emp){
            try{
                PreparedStatement s = conexion.prepareStatement(
                "INSERT INTO empelado (nombre, apellido, ingreso, egreso) values(?,?,?,?)" );
                
                
                s.setString(1, emp.getNombre());
                s.setString(2, emp.getApellido());
                s.setInt(3, emp.getIngreso());
                s.setInt(4, emp.getEgreso());
                
                s.executeUpdate();
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        
        
        
    public void añadirHorario(Empleado emp) {
        try {
            PreparedStatement s = conexion.prepareStatement(
                    "UPDATE empelado SET ingreso = ?, egreso = ? WHERE ID =?");
            s.setInt(1, emp.getIngreso());
            s.setInt(2, emp.getEgreso());
            s.setInt(3, emp.getId());

            s.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<Empleado> obtenerEmpleados(){
            ArrayList<Empleado> lista = new ArrayList<>();
            
            try {
                Statement s;
                s = conexion.createStatement();
                ResultSet res = s.executeQuery("SELECT * FROM empelado order by id");   
                while(res.next()){
                    Empleado emp = new Empleado(
                    res.getInt("id"),
                    res.getString("nombre"),
                    res.getString("apellido"),
                    res.getInt("ingreso"),
                    res.getInt("egreso")
                   );
                    lista.add(emp); 
                }
                
            } catch (Exception e) {
                System.out.println(e);    
            }            
  
            return lista;
        }


}
