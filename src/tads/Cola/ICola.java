/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tads.Cola;

/**
 *
 * @author Usuario
 */
public interface ICola<T> {
    void Adicionar(T x);
    T Frente();
    T Fondo();
    T Desencolar();
    boolean Vacia();
    boolean estaEnCola(T n);
    
}
