/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class Prestamo {
    private String ISBN;
    private int Numero;
    private boolean Activo;

    public Prestamo(String ISBN, int Numero, boolean Activo) {
        this.ISBN = ISBN;
        this.Numero = Numero;
        this.Activo = Activo;
    }
    
    

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getNumero() {
        return Numero;
    }

    public boolean isActivo() {
        return Activo;
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
        final Prestamo other = (Prestamo) obj;
        if (this.Numero != other.Numero) {
            return false;
        }
        return Objects.equals(this.ISBN, other.ISBN);
    }
        

    @Override
    public String toString() {
        return "Prestamo{" + "ISBN=" + ISBN + ", Numero=" + Numero + ", Activo=" + Activo + '}';
    }
   
    
}
