/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.DB;
import modelo.Empleado;
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
        ArrayList<Empleado> empleados = db.obtenerEmpleados();
        DefaultTableModel model = (DefaultTableModel) ventana.getGrilla().getModel();
        model.setNumRows(0);
        for (Empleado empleado : empleados) {
            Object[] fila = new Object[6];
            fila[0] = empleado.getId();
            fila[1] = empleado.getNombre();
            fila[2] = empleado.getApellido();
            fila[3] = empleado.getIngreso();
            fila[4] = empleado.getEgreso();
            int horasTrabajadas = empleado.getEgreso() - empleado.getIngreso();
            fila[5] = horasTrabajadas;
            model.addRow(fila);
        }
       
        

        
        
    }
    
    public static void botonAgregar(){
        System.out.println("se ejecuto boton agregar");
        String nombre = ventana.getTxtnombre().getText();
        String apellido = ventana.getTxtapellido().getText();
        int ingreso = Integer.parseInt(ventana.getTxtentrada().getText());
        int egreso = Integer.parseInt(ventana.getTxtsalida().getText());
        
        Empleado emp = new Empleado();
        emp.setNombre(nombre);
        emp.setApellido(apellido);
        emp.setIngreso(ingreso);
        emp.setEgreso(egreso);
        DB db = new DB();
        db.agregarEmpleado(emp);
        mostrar();
        
        
                
        
    }
    
    public static void botonModificar(){
           int id = Integer.parseInt(ventana.getTxtid().getText());
        String nombre = ventana.getTxtnombre().getText();
        String apellido = ventana.getTxtapellido().getText();
        int entrada = Integer.parseInt(ventana.getTxtentrada().getText());
        int egreso = Integer.parseInt(ventana.getTxtsalida().getText());
        Empleado emp = new Empleado();
        emp.setId(id);
        emp.setNombre(nombre);
        emp.setApellido(apellido);
        emp.setIngreso(entrada);
        emp.setEgreso(egreso);
        DB db = new DB();
        db.añadirHorario(emp);
        mostrar();
    }
    public static void botonCalcularHoras(){
        
    }
    

    
}
