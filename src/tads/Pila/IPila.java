/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tads.Pila;

/**
 *
 * @author Usuario
 */
public interface IPila<T> {
    void insertar(T dato);
    T eliminar();
    T ultimoElemento();
    boolean esVacia();
 
}
