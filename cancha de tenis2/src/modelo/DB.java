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
        String cadenaConexion = "jdbc:mysql://localhost/tenis?ServerTimezone=UTC";
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
        
        
    public void agregarReserva(Reserva r) {
        try {
            PreparedStatement s = conexion.prepareStatement(
                    "INSERT INTO reserva (dni, numero_cancha, fecha, hora, estadoo) values(?,?,?,?,?)");

            s.setInt(1, r.getDni());
            s.setInt(2, r.getNumero_cancha());
            s.setString(3, r.getFecha());
            s.setTime(4, r.getHora());
            s.setString(5, r.getEstadoo());

            s.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void eliminarReserva(int dni) {
        Statement s;
        try {
            s = conexion.createStatement();
            s.executeUpdate("DELETE FROM reserva WHERE DNI= " + dni);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void modificarReserva(Reserva r) {
        try {
            PreparedStatement s = conexion.prepareStatement(
                    //dni, numero_cancha, fecha, hora, estadoo
                    "UPDATE reserva SET estadoo = ?, hora = ?, fecha = ? , numero_cancha = ? WHERE dni =?");

            s.setInt(5, r.getDni());
            s.setInt(4, r.getNumero_cancha());
            s.setString(3, r.getFecha());
            s.setTime(2, r.getHora());
            s.setString(1, r.getEstadoo());
           

            s.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    
    	    public ArrayList<Reserva> obtener() {
        ArrayList<Reserva> lista = new ArrayList<>();

        try {
            Statement s;
            s = conexion.createStatement();
            ResultSet res = s.executeQuery("SELECT * FROM reserva order by numero_cancha");
            while (res.next()) {
                Reserva r = new Reserva(
                        res.getInt("dni"),
                        res.getInt("numero_cancha"),
                        res.getString("fecha"),
                        res.getTime("hora"),
                        res.getString("estadoo")
                );
                lista.add(r);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return lista;
    }
    
}
