/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalTime;
import java.sql.Time;

/**
 *
 * @author La Minera
 */
public class Perro {
    
    private int numero;
    private String nombre;
    private Time tiempo;

    @Override
    public String toString() {
        return "Perro{" + "numero=" + numero + ", nombre=" + nombre + ", tiempo=" + tiempo + '}';
    }

    public Perro(int numero, String nombre, Time tiempo) {
        this.numero = numero;
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    public Perro() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Time getTiempo() {
        return tiempo;
    }

    public void setTiempo(Time tiempo) {
        this.tiempo = tiempo;
    }

    
    

}
