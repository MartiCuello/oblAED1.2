/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tads;

import dominio.Libro;
import java.util.Iterator;

/**
 *
 * @author Usuario
 */
public class ListaSimple<T> implements ILista<T> {
    private Nodo<T> inicio;
    private int cantidadDeElementos;

    @Override
    public void agregar(T dato) {
        if (this.esVacia()) {
            inicio = new Nodo<>(dato, inicio);
        } else {
            Nodo<T> aux = inicio;
            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
            Nodo nuevo = new Nodo(dato);
            aux.setSig(nuevo);
        }
        this.cantidadDeElementos++;
    }

    @Override
    public void eliminar(T dato) {
        if (inicio.getDato().equals(dato)) {
            inicio = inicio.getSig();
        } else {
            Nodo<T> aux = inicio;
            while (!dato.equals(aux.getSig().getDato())) {
                aux = aux.getSig();
            }
            aux.setSig(aux.getSig().getSig());
        }
        cantidadDeElementos--;
    }    

    @Override
    public T obtenerPorIndice(int indice) {
        
        if (indice < 0 || indice >= cantidadDeElementos) { // Índice fuera de rango
            return null;
        }   

        Nodo<T> aux = inicio;
        int i = 0;

        while (i < indice) {
            aux = aux.getSig();
            i++;
        }

        return aux.getDato();
        
        /*
        Nodo<T> aux = inicio;
        
        if (indice >=0 && indice <= cantidadDeElementos){
                int i = 0;
                while(i<indice){
                    aux = aux.getSig();
                    i++;
                }
            return aux.getDato();  
        }            
        return null;
        */
    }

    @Override
    public T obtener(T dato) {
        Nodo<T> aux = inicio;
        while (aux != null) {
            if (aux.getDato().equals(dato)) {
                return aux.getDato();
            }
            aux = aux.getSig();
        }
        return null;
    }

    @Override
    public boolean existe(T dato) {
        Nodo<T> aux = inicio;
        while (aux != null) {
            if (aux.getDato().equals(dato)) {
                return true;
            }
            aux = aux.getSig();
        }
        return false;
    }

    @Override
    public int largo() {
        return cantidadDeElementos;
    }

    @Override
    public boolean esVacia() {
        return cantidadDeElementos == 0;

    }
    
    public void ordenarLibrosPorISBN(ListaSimple<Libro> lista) {
        int cant = lista.largo();
        boolean desordenado = true;

        while (desordenado) {
            desordenado = false;

            for (int j = 0; j < cant - 1; j++) {
                Libro libroActual = lista.obtenerPorIndice(j);
                Libro libroSiguiente = lista.obtenerPorIndice(j + 1);

                if (debeIntercambiar(libroActual.getISBN(), libroSiguiente.getISBN())) {
                    lista.eliminar(libroActual);
                    lista.eliminar(libroSiguiente);
                    lista.agregarEnIndice(j, libroSiguiente);
                    lista.agregarEnIndice(j + 1, libroActual);
                    desordenado = true;
                }
            }
        }
    }

    private boolean debeIntercambiar(String isbn1, String isbn2) {
        int menor = Math.min(isbn1.length(), isbn2.length());

        for (int i = 0; i < menor; i++) {
            char c1 = isbn1.charAt(i);
            char c2 = isbn2.charAt(i);

            if (c1 > c2) {
                return true;
            } else if (c1 < c2) {
                return false;
            }
        }

        return isbn1.length() > isbn2.length();
    }
    
    public void agregarEnIndice(int indice, T dato) {
        if (indice < 0 || indice > cantidadDeElementos) {
            return;
        }

        Nodo<T> nuevo = new Nodo<>(dato);

        if (indice == 0) {
            nuevo.setSig(inicio);
            inicio = nuevo;
        } else {
            Nodo<T> aux = inicio;
            for (int i = 0; i < indice - 1; i++) {
                aux = aux.getSig();
            }
            nuevo.setSig(aux.getSig());
            aux.setSig(nuevo);
        }

        cantidadDeElementos++;
    }
    
    
    
    
    

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
