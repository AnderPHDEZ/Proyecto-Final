package com.mycompany.proyectopokemon;

public class ListaDisponibles {
    private NodoPokemon cabeza;
    private int tamaño;

    public ListaDisponibles() {
        cabeza = null;
        tamaño = 0;
    }

    public void agregar(Pokemon p) {
        NodoPokemon nuevo = new NodoPokemon(p);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoPokemon actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamaño++;
    }

    public NodoPokemon getCabeza() {
        return cabeza;
    }

    public int getTamaño() {
        return tamaño;
    }
}