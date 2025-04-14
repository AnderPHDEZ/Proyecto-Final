package com.mycompany.proyectopokemon;

public class NodoCola {
    Pokemon pokemon;
    NodoCola siguiente;

    public NodoCola(Pokemon pokemon) {
        this.pokemon = pokemon;
        this.siguiente = null;
    }
}