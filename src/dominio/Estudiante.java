/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;
import static sun.jvm.hotspot.HelloWorld.e;

/**
 *
 * @author Usuario
 */
public class Estudiante {
    private String Nombre;
    private String Apellido;
    private int Numero;

    public Estudiante(String Nombre, String Apellido, int Numero) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Numero = Numero;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public int getNumero() {
        return Numero;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "Nombre=" + Nombre + ", Apellido=" + Apellido + ", Numero=" + Numero + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Estudiante other = (Estudiante) obj;
        return this.Numero == other.Numero;
    }

    
      
    
}
