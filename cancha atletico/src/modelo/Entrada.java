/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author La Minera
 */
public class Entrada {
    private int dni; 
    private int cantidad;
    private String sector; 
    private String socio; 
    private int total; 

    @Override
    public String toString() {
        return "Entrada{" + "dni=" + dni + ", cantidad=" + cantidad + ", sector=" + sector + ", socio=" + socio + ", total=" + total + '}';
    }

    public Entrada(int dni, int cantidad, String sector, String edad, int total) {
        this.dni = dni;
        this.cantidad = cantidad;
        this.sector = sector;
        this.socio = edad;
        this.total = total;
    }

    public Entrada() {
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String edad) {
        this.socio = edad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
    
}
