/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.DB;
import modelo.Entrada;
import vistas.VistaPrincipal;

/**
 *
 * @author La Minera
 */
public class ControladorPrincipal {
    
     static VistaPrincipal ventana = new VistaPrincipal();
    
    
    public static void mostrar() {
        
        ventana.setVisible(true);
        DB db = new DB();
        ArrayList<Entrada> entradas = db.obtener();
        DefaultTableModel model = (DefaultTableModel) ventana.getGrilla().getModel();
        model.setNumRows(0);
         Entrada e = new Entrada();
        for (Entrada entrada : entradas) {
            Object[] fila = new Object[5];
            fila[0] = entrada.getDni();
            fila[1] = entrada.getCantidad();
            fila[2] = entrada.getSector();
            fila[3] = entrada.getSocio();
            int total = calcularTotal(entrada);
            fila[4] = total;
            model.addRow(fila);

            e.setDni(entrada.getDni());
            e.setTotal(total);
            db.modificarTotal(e);
        }
        

    }
    
    public static int calcularTotal(Entrada entrada) {
    int total = 0;
    if (entrada.getSector().equals("laprida") && entrada.getSocio().equals("no")) {
        total = 3500 * entrada.getCantidad();
    }
    if (entrada.getSector().equals("laprida") && entrada.getSocio().equals("si")) {
        total = 2100 * entrada.getCantidad();
    }
    if (entrada.getSector().equals("1-2") && entrada.getSocio().equals("si")) {
        total = 3600 * entrada.getCantidad();
    } 
    if (entrada.getSector().equals("1-2") && entrada.getSocio().equals("no")) {
        total = 6000 * entrada.getCantidad();
    }
    if (entrada.getSector().equals("345") && entrada.getSocio().equals("no")) {
        total = 5300 * entrada.getCantidad();
    }
    if (entrada.getSector().equals("345") && entrada.getSocio().equals("si")) {
        total = 3200 * entrada.getCantidad();
    }
    if (entrada.getSector().equals("menores") && entrada.getSocio().equals("no")) {
        total = 1000 * entrada.getCantidad();
    }
    if (entrada.getSector().equals("menores") && entrada.getSocio().equals("si")) {
        total = 600 * entrada.getCantidad();
    }
    return total;
}
    public static void botonAgregar(){
        System.out.println("se agreego");
        
        String sector = ventana.getTxtsector().getText();   
        String socio = ventana.getTxtsocio().getText();
        int dni = Integer.parseInt(ventana.getTxtdni().getText());
        int cantidad = Integer.parseInt(ventana.getTxtcantidad().getText());

         Entrada e = new Entrada();
        
        e.setDni(dni);
        e.setCantidad(cantidad);
        e.setSector(sector);
        e.setSocio(socio);
        
        DB db = new DB();
        db.agregarVenta(e);
        mostrar();
    }
    public static void botonModificar(){
        String sector = ventana.getTxtsector().getText();   
        String socio = ventana.getTxtsocio().getText();
        int dni = Integer.parseInt(ventana.getTxtdni().getText());
        int cantidad = Integer.parseInt(ventana.getTxtcantidad().getText());

         Entrada e = new Entrada();
        
        e.setDni(dni);
        e.setCantidad(cantidad);
        e.setSector(sector);
        e.setSocio(socio);
        
        DB db = new DB();
   
        db.modificarVenta(e);
         mostrar();
    }
    public static void botonEliminar(){
       int dni = Integer.parseInt(ventana.getTxtdni().getText());
       DB db = new DB();
       db.eliminarVenta(dni);
        mostrar();
    }
    

}
