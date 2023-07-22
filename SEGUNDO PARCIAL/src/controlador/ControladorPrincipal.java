/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.DB;
import modelo.Perro;
import vistas.VistaPrincipal;

/**
 *
 * @author La Minera
 */
public class ControladorPrincipal {
    
    static VistaPrincipal ventana = new VistaPrincipal();
    
    public static void mostrar(){
        ventana.setVisible(true);
         DB db = new DB();
         ArrayList<Perro> perros = db.obtenerPerros();
        DefaultTableModel model = (DefaultTableModel) ventana.getjTable1().getModel();
    model.setNumRows(0);      
        for (Perro perro : perros) {
            Object[] fila = new Object[3];
             fila[0] = perro.getNumero();
            fila[1] = perro.getNombre();
            fila[2] = perro.getTiempo();
            model.addRow(fila);
        }

    }
    
    public static void botonAgregar(){
        int numero = Integer.parseInt(ventana.getTxtnumero().getText());
        String nombre = ventana.getTxtnombre().getText();
        String tiempoStr = ventana.getTxttiempo().getText();  // Obtener el tiempo ingresado
        java.sql.Time tiempo = java.sql.Time.valueOf(tiempoStr);
        
        Perro p = new Perro();
        
        DB db = new DB();
        db.agregarPerro(p);
        mostrar();
        
    }
    public static void botonEliminar(){
        int numero = Integer.parseInt(ventana.getTxtnumero().getText());
        DB db = new DB();
        db.eliminarPerro(numero);
        mostrar();
    }
    public static void botonModificar(){
        int numero = Integer.parseInt(ventana.getTxtnumero().getText());
        String nombre = ventana.getTxtnombre().getText();
        String tiempoStr = ventana.getTxttiempo().getText();  // Obtener el tiempo ingresado
        java.sql.Time tiempo = java.sql.Time.valueOf(tiempoStr);
        
        Perro p = new Perro();
         p.setTiempo(tiempo);
        p.setNombre(nombre);
        p.setNumero(numero);
        DB db = new DB();
        db.modificarPerro(p);
        mostrar();
        
    }
    
}
