/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;
import modelo.*;
import controlador.*;

/**
 *
 * @author La Minera
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       ControladorPrincipal.mostrar();
        
        DB db = new DB();
       
        Entrada e = new Entrada();
        e.setDni(400000);
        e.setCantidad(8);
        e.setSector("laprida");
        e.setSocio("no");
        
        //db.agregarVenta(e);
        //db.eliminarVenta(10000);
        //db.modificarVenta(e);
        //System.out.println(db.obtener());
    }
    
}
