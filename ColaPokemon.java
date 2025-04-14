package com.mycompany.proyectopokemon;

public class ColaPokemon {
    private NodoCola frente;
    private NodoCola fin;
    private int tamaño;

    public ColaPokemon() {
        this.frente = null;
        this.fin = null;
        this.tamaño = 0;
    }

    public void encolar(Pokemon p) {
        NodoCola nuevo = new NodoCola(p);
        if (fin == null) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        tamaño++;
    }

    public Pokemon desencolar() {
        if (frente == null) return null;
        Pokemon p = frente.pokemon;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        tamaño--;
        return p;
    }

    public Pokemon peek() {
        return (frente != null) ? frente.pokemon : null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int getTamaño() {
        return tamaño;
    }
}