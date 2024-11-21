/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tads.ListaDoble;

/**
 *
 * @author Usuario
 */
public class ListaDoble<T> implements IListaDoble<T> {

    public Nodo<T> cabeza;
    public Nodo<T> cola;
    int cantidad;
    
    public ListaDoble() {
        this.cantidad = 0;
        this.cabeza = null;       
        this.cola = null;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }

    public Nodo<T> getCola() {
        return cola;
    }

    public void setCola(Nodo<T> cola) {
        this.cola = cola;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
         
    @Override
    public void agregar(T dato) {
        Nodo<T> aux = new Nodo<>(dato);
        if (this.esVacia()) {
            cabeza = aux;
            cola = aux;
        } else {
            cola.setSiguiente(aux);
            aux.setAnterior(cola);
            cola = aux; // 
        }
    cantidad++;
    }
    
    @Override
    public void borrarElemento(T dato) {
    if (cabeza == null) {
        return;
    }

    if (cabeza.getDato().equals(dato)) {
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);
        }
    } else {
        Nodo<T> aux = cabeza;
        while (aux.getSiguiente() != null && !aux.getSiguiente().getDato().equals(dato)) {
            aux = aux.getSiguiente();
        }

        if (aux.getSiguiente() == null) {
            return;
        }

        Nodo<T> nodoAEliminar = aux.getSiguiente();
        Nodo<T> nodoSiguiente = nodoAEliminar.getSiguiente();

        aux.setSiguiente(nodoSiguiente);
        if (nodoSiguiente != null) {
            nodoSiguiente.setAnterior(aux);
        } else {
            cola = aux;
        }
    }

    cantidad--;   
}

    @Override
    public int largo() {
        return cantidad;
    }

    @Override
    public boolean existeElemento(T dato) {
      return obtenerElemento(dato) != null;
    }

    @Override
    public boolean esVacia() {
        return cantidad == 0;   
    }

    @Override
    public T obtenerElemento(T dato) {
         Nodo<T> aux = cabeza;

        while (aux != null) {
            if (aux.dato.equals(dato)) {
                return aux.getDato();
            }   
            aux = aux.siguiente;
        }
    return null;       
    }
    
    @Override
    public T obtenerPorIndice(int indice) {
        Nodo<T> aux = cabeza;

        if (indice >= 0 && indice < cantidad) {
            int i = 0;
            while (i < indice) {
                aux = aux.getSiguiente();
                i++;
            }
            return aux.getDato();
        }   
        return null;
    }

}
