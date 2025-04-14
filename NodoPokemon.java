package com.mycompany.proyectopokemon;

public class NodoPokemon {
    Pokemon pokemon;
    NodoPokemon siguiente;

    public NodoPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
        this.siguiente = null;
    }
}