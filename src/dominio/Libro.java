/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;
import tads.Cola.Cola;
import tads.ListaSimple;
import tads.Pila.Pila;

/**
 *
 * @author Usuario
 */
public class Libro {
    private String Nombre;
    private String ISBN;
    private String Categoria;
    private int Cantidad;
    private Cola<Reserva> Reserva;

    public Libro(String Nombre, String ISBN, String Categoria, int Cantidad) {
        this.Nombre = Nombre;
        this.ISBN = ISBN;
        this.Categoria = Categoria;
        this.Cantidad = Cantidad;
        this.Reserva = new Cola<>();
        
    }

    public Cola<Reserva> getReserva() {
        return Reserva;
    }

    public void setReserva(Cola<Reserva> Reserva) {
        this.Reserva = Reserva;
    }
    
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
     
    public String getNombre() {
        return Nombre;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getCategoria() {
        return Categoria;
    }

    public int getCantidad() {
        return Cantidad;
    }

    @Override
    public String toString() {
        return "Libro{" + "Nombre=" + Nombre + ", ISBN=" + ISBN + ", Categoria=" + Categoria + ", Cantidad=" + Cantidad + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        return Objects.equals(this.ISBN, other.ISBN);
    }

    
   
    
    
}
