/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author La Minera
 */
public class Empleado {
    private int id; 
    private String nombre;
    private String apellido;
    private int ingreso; 
    private int egreso; 

    public Empleado(int id, String nombre, String apellido, int ingreso, int egreso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ingreso = ingreso;
        this.egreso = egreso;
    }

    
    
    public Empleado(int ingreso, int egreso) {
        this.ingreso = ingreso;
        this.egreso = egreso;
    }

    public Empleado(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Empleado() {
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", ingreso=" + ingreso + ", egreso=" + egreso + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIngreso() {
        return ingreso;
    }

    public void setIngreso(int ingreso) {
        this.ingreso = ingreso;
    }

    public int getEgreso() {
        return egreso;
    }

    public void setEgreso(int egreso) {
        this.egreso = egreso;
    }
    
    
}
