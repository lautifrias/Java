/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

import modelo.DB;
import modelo.Perro;    
import java.sql.Time;

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
        Perro p = new Perro();
        p.setNumero(520);
        p.setNombre("SiMurdiera");
        p.setTiempo(Time.valueOf("00:37:05"));
        //db.modificarPerro(p);
        
        //db.agregarPerro(p);
        //db.eliminarPerro(15);
        //System.out.println(db.obtenerPerros());
       ControladorPrincipal.mostrar();
    }
    
}
