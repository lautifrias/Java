/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;
import java.sql.*;
import vistas.*;
import controlador.*;
import modelo.*;

/**
 *
 * @author La Minera
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DB db = new DB();
        
       ControlarPrincipal.mostrar();
        
//        Reserva r = new Reserva();
//        r.setDni(20);
//        r.setNumero_cancha(12);
//        r.setFecha("08/02/2023");
//       r.setHora(Time.valueOf("23:00:00"));
//        r.setEstadoo("pagado");
//        
//        //db.agregarReserva(r);
//        //db.eliminarReserva(5);
//        //db.modificarReserva(r);
//        System.out.println(db.obtener());
    }
    
}
