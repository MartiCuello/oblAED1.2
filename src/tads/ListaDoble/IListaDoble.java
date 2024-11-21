/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tads.ListaDoble;

/**
 *
 * @author Usuario
 */
public interface IListaDoble<T> {
    
    public void agregar(T dato);
    
    public void borrarElemento(T dato);
    
    public int largo();
    
    public boolean existeElemento(T dato);
    
    public boolean esVacia();
    
    public T obtenerElemento(T dato);
    
    public T obtenerPorIndice(int indice);
}
