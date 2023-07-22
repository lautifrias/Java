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
        String cadenaConexion = "jdbc:mysql://localhost/atletico?ServerTimezone=UTC";
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
        
        
        
            public void agregarVenta(Entrada e) {
        try {
            PreparedStatement s = conexion.prepareStatement(
                    "INSERT INTO entrada (dni, cantidad, sector, socio) values(?,?,?,?)");

            s.setInt(1, e.getDni());
            s.setInt(2, e.getCantidad());
            s.setString(3, e.getSector());
            s.setString(4, e.getSocio());
            s.executeUpdate();

        } catch(Exception g){
            System.out.println(g);
        }
    }
            
            
                public void eliminarVenta(int dni) {
        Statement s;
        try {
            s = conexion.createStatement();
            s.executeUpdate("DELETE FROM entrada WHERE DNI= " + dni);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
  
    public void modificarVenta(Entrada e) {
        try {
            PreparedStatement s = conexion.prepareStatement(
                    //dni, numero_cancha, fecha, hora, estadoo
                    "UPDATE entrada SET socio = ?, sector = ?, cantidad = ? WHERE dni =?");

            s.setInt(4, e.getDni());
            s.setInt(3, e.getCantidad());
            s.setString(2, e.getSector());
            s.setString(1, e.getSocio());

            s.executeUpdate();

        } catch (Exception g) {
            System.out.println(g);
        }

    }

    public ArrayList<Entrada> obtener() {
        ArrayList<Entrada> lista = new ArrayList<>();
        
        try {
            Statement s;
            s = conexion.createStatement();
            ResultSet res = s.executeQuery("SELECT * FROM entrada order by dni");
            while (res.next()) {
                Entrada r = new Entrada(
                        res.getInt("dni"),
                        res.getInt("cantidad"),
                        res.getString("sector"),
                        res.getString("socio"),
                        res.getInt("total")
                );
                lista.add(r);
                
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return lista;
    }
    
    
    

            public void modificarTotal(Entrada e) {
            try {
                PreparedStatement s = conexion.prepareStatement(
                        //dni, numero_cancha, fecha, hora, estadoo
                        "UPDATE entrada SET total = ? WHERE dni =?");

                s.setInt(2, e.getDni());
                s.setInt(1, e.getTotal());

                s.executeUpdate();

            } catch (Exception g) {
                System.out.println(g);
            }

        }
}
