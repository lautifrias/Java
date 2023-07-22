/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;

/**
 *
 * @author La Minera
 */
public class Reserva {
    
    private int dni;
    private int numero_cancha;
    private String fecha; 
    private Time hora;
    private String estadoo; 

    public Reserva() {
    }

    public Reserva(int dni, int numero_cancha, String fecha, Time hora, String estadoo) {
        this.dni = dni;
        this.numero_cancha = numero_cancha;
        this.fecha = fecha;
        this.hora = hora;
        this.estadoo = estadoo;
    }

    @Override
    public String toString() {
        return "Reserva{" + "dni=" + dni + ", numero_cancha=" + numero_cancha + ", fecha=" + fecha + ", hora=" + hora + ", estadoo=" + estadoo + '}';
    }

    
    
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getNumero_cancha() {
        return numero_cancha;
    }

    public void setNumero_cancha(int numero_cancha) {
        this.numero_cancha = numero_cancha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getEstadoo() {
        return estadoo;
    }

    public void setEstadoo(String estadoo) {
        this.estadoo = estadoo;
    }
    
    
    
}
