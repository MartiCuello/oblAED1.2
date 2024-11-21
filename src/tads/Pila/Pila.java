/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tads.Pila;

/**
 *
 * @author Usuario
 */
public class Pila<T> implements IPila<T> {

    private Nodo<T> inicio;
    
    @Override
    public void insertar(T dato) {
      inicio = new Nodo<>(dato, inicio);  
    }

    @Override
    public T eliminar() {
        T aux = inicio.getDato();
        inicio = inicio.getSig();       
        return  aux;
    }

    @Override
    public T ultimoElemento() {
        return inicio.getDato();
    }

    @Override
    public boolean esVacia() {
        return inicio == null;
    }
    
}
