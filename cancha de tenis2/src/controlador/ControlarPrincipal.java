/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.DB;
import modelo.Reserva;
import vistas.VistaPrincipal;
import java.sql.*;

/**
 *
 * @author La Minera
 */
public class ControlarPrincipal {
    
    static VistaPrincipal ventana = new VistaPrincipal();
    
    
    public static void mostrar() {
        ventana.setVisible(true);
        DB db = new DB();
        ArrayList<Reserva> reservas = db.obtener();
        DefaultTableModel model = (DefaultTableModel) ventana.getTxtgrilla().getModel();
        model.setNumRows(0);
        for (Reserva reserva : reservas) {
            Object[] fila = new Object[6];
            fila[0] = reserva.getDni();
            fila[1] = reserva.getNumero_cancha();
            fila[2] = reserva.getFecha();
            fila[3] = reserva.getEstadoo();
            fila[4] = reserva.getHora();

            int saldo = 1000; // tarifa base
            String horaStr = reserva.getHora().toString();  // Obtener la hora de la reserva como cadena
            java.sql.Time hora = java.sql.Time.valueOf(horaStr);  // Convertir la cadena a java.sql.Time

            // Verificar si la hora está dentro del rango de 20:00:00 a 23:00:00
            if (hora.after(java.sql.Time.valueOf("19:59:59"))
                    && hora.before(java.sql.Time.valueOf("23:59:59"))) {
                saldo += 200; // añadir cobro adicional de luz
            }
            if (reserva.getEstadoo().equals("pagado")) {
                saldo = 0;
                fila[5] = saldo;
            } else {
                fila[5] = saldo;
            }

            fila[5] = saldo;
            model.addRow(fila);
        }

    }
    
    public static void botonAgregar(){
        System.out.println("se agreego");
        String estadoo = ventana.getTxtestado().getText();
        String fecha = ventana.getTxtfecha().getText();  
        int dni = Integer.parseInt(ventana.getTxtdni().getText());
        int numero_cancha = Integer.parseInt(ventana.getTxtnumerocancha().getText());
        String horaStr = ventana.getTxthorario().getText();  // Obtener el tiempo ingresado 
        java.sql.Time hora = java.sql.Time.valueOf(horaStr);

        Reserva r = new Reserva();
        r.setDni(dni);
        r.setNumero_cancha(numero_cancha);
        r.setFecha(fecha);
        r.setEstadoo(estadoo);
        r.setHora(hora);
        
        DB db = new DB();
        db.agregarReserva(r);
        mostrar();
    }
    public static void botonModificar(){
        System.out.println("se agreego");
        String estadoo = ventana.getTxtestado().getText();
        String fecha = ventana.getTxtfecha().getText();  
        int dni = Integer.parseInt(ventana.getTxtdni().getText());
        int numero_cancha = Integer.parseInt(ventana.getTxtnumerocancha().getText());
        String horaStr = ventana.getTxthorario().getText();  // Obtener el tiempo ingresado 
        java.sql.Time hora = java.sql.Time.valueOf(horaStr);

        Reserva r = new Reserva();
        r.setDni(dni);
        r.setNumero_cancha(numero_cancha);
        r.setFecha(fecha);
        r.setEstadoo(estadoo);
        r.setHora(hora);
        
        DB db = new DB();
        db.modificarReserva(r);
         mostrar();
    }
    public static void botonEliminar(){
       int dni = Integer.parseInt(ventana.getTxtdni().getText());
       DB db = new DB();
       db.eliminarReserva(dni);
        mostrar();
    }
    
}
