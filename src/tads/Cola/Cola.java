/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tads.Cola;

/**
 *
 * @author Usuario
 */
public class Cola<T> implements ICola<T>{

    private Nodo<T> frente;
    private Nodo<T> fondo;
    
    public Cola() {
        frente = null;
        fondo = null;
    }
    
    @Override
    public void Adicionar(T x) 
    {
        Nodo<T> nuevo = new Nodo(x);
        if (Vacia()) {
            frente = nuevo;
            fondo = nuevo;
        } else {
            fondo.setSig(nuevo);
            fondo = nuevo;
        }
    }
    
    @Override
    public T Frente()
    {
        return frente.getDato();
    }
    
    @Override
    public T Fondo()
    {
        return fondo.getDato();
    }
    
    @Override
    public T Desencolar() {
        if (Vacia()) {
            return null;
        }

        Nodo<T> cursor = frente;
        frente = frente.getSig();

        if (frente == null) {
            fondo = null;
        }

        return cursor.getDato();
    }

    
    @Override
    public boolean estaEnCola(T n) {
        Nodo<T> aux = frente;
        while (aux != null) {
            if (aux.getDato().equals(n)) {
                return true;
            }
            aux = aux.getSig();
        }
        return false;
    }

        
    @Override
    public boolean Vacia() 
    {
        return (frente == null);
    }
}
