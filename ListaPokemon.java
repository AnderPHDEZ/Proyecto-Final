package com.mycompany.proyectopokemon;

public class ListaPokemon {
    private NodoPokemon cabeza;
    private int tamaño;

    public ListaPokemon() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    public boolean agregar(Pokemon pokemon) {
        if (tamaño >= 4) return false;
        NodoPokemon nuevo = new NodoPokemon(pokemon);
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
        return true;
    }

    public Pokemon obtener(int index) {
        if (index < 0 || index >= tamaño) return null;
        NodoPokemon actual = cabeza;
        for (int i = 0; i < index; i++) {
            actual = actual.siguiente;
        }
        return actual.pokemon;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void mostrar() {
        NodoPokemon actual = cabeza;
        int i = 0;
        while (actual != null) {
            System.out.println(i + ". " + actual.pokemon);
            actual = actual.siguiente;
            i++;
        }
    }

    public boolean tienePokemonVivo() {
        NodoPokemon actual = cabeza;
        while (actual != null) {
            if (actual.pokemon.estaVivo()) return true;
            actual = actual.siguiente;
        }
        return false;
    }
}