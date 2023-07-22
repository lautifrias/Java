/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author La Minera
 */
public class Venta {
    private int codigo;
    private String producto; 
    private int cantidad; 
    private int precio; 

    
    public Venta(int codigo, String producto, int cantidad, int precio) {
        this.codigo = codigo;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Venta() {
    }

    @Override
    public String toString() {
        return "Venta{" +"codigo" + codigo + "producto=" + producto + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    
}
