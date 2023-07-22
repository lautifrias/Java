/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeCellEditor;
import modelo.DB;
import modelo.Venta;
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
        ArrayList<Venta> productos = db.obtenerVenta();
        DefaultTableModel model = (DefaultTableModel) ventana.getGrilla().getModel();
        model.setNumRows(0);
        double total = 0;
        for (Venta producto : productos) {
            Object[] fila = new Object[5];
            fila[0] = producto.getCodigo();
            fila[1] = producto.getProducto();
            fila[2] = producto.getPrecio();
            fila[3] = producto.getCantidad();
            int subtotal = producto.getPrecio() * producto.getCantidad();
            fila[4] = subtotal;
            total = total + subtotal;
              model.addRow(fila);
        }
        
         ventana.getTxttotal().setText(String.valueOf(total));
         
      
        

    }
    public void total(){
        DB db = new DB();
        ArrayList<Venta> productos = db.obtenerVenta();
        DefaultTableModel model = (DefaultTableModel) ventana.getGrilla().getModel();
        model.setNumRows(0);
        for (Venta producto : productos) {
            Object[] fila = new Object[5];
            fila[0] = producto.getCodigo();
            fila[1] = producto.getProducto();
            fila[2] = producto.getPrecio();
            fila[3] = producto.getCantidad();
            int subtotal = producto.getPrecio() * producto.getCantidad();
            fila[4] = subtotal;
              model.addRow(fila);
        }
        double total = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            double subtotal = (int) model.getValueAt(i, 4);
            total += subtotal;
        }
        
    }
    
    public static void  botonAgregarProducto(){
        //int codigo = Integer.parseInt(ventana.getTxtcodigo().getText());
        String producto = ventana.getTxtproducto().getText();
        int precio = Integer.parseInt(ventana.getTxtprecio().getText());
        int cantidad = Integer.parseInt(ventana.getTxtcantidad().getText());

        Venta v = new Venta();
        v.setPrecio(precio);
        v.setCantidad(cantidad);
        v.setProducto(producto);

        DB db = new DB();
        db.agregarVenta(v);
        
        mostrar();
    }
    
    public static void  botonModificarProducto(){
        int codigo = Integer.parseInt(ventana.getTxtcodigo().getText());
        String producto = ventana.getTxtproducto().getText();
        int precio = Integer.parseInt(ventana.getTxtprecio().getText());
        int cantidad = Integer.parseInt(ventana.getTxtcantidad().getText());
        
        Venta p = new Venta();
        p.setCodigo(codigo);
        p.setProducto(producto);
        p.setCantidad(cantidad);
        p.setPrecio(precio);
        DB db = new DB();
        db.modificarVenta(p);
        mostrar();

    }
    
    public static void  botonEliminarProducto(){
       int codigo = Integer.parseInt(ventana.getTxtcodigo().getText());
        DB db = new DB();
        db.eliminarVenta(codigo);
        mostrar();
    }
}
