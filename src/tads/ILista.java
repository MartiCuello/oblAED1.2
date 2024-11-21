/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tads;

/**
 *
 * @author Usuario
 */
public interface ILista<T> extends Iterable<T>{

    void agregar(T dato);
    
   // void agregar(int indice, T dato);
    
    void eliminar(T dato);

    T obtenerPorIndice(int indice);
    
    T obtener(T dato);
    
    boolean existe(T dato);

    int largo();

    boolean esVacia();

  
}
