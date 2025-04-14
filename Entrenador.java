package com.mycompany.proyectopokemon;

public class Entrenador {
    private String nombre;
    private ListaPokemon pokedex;
    private ColaPokemon colaBatalla;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokedex = new ListaPokemon();
        this.colaBatalla = new ColaPokemon();
    }

    public void agregarPokemon(Pokemon p) {
        if (!pokedex.agregar(p)) {
            System.out.println("No se pueden agregar más de 4 Pokémon.");
        } else {
            colaBatalla.encolar(p);
        }
    }

    public Pokemon obtenerSiguientePokemon() {
        return colaBatalla.peek();
    }

    public void eliminarPokemonActual() {
        colaBatalla.desencolar();
    }

    public boolean tienePokemonVivo() {
        return colaBatalla.getTamaño() > 0;
    }

    public void mostrarPokedex() {
        pokedex.mostrar();
    }

    public String getNombre() {
        return nombre;
    }

    public Pokemon obtenerPokemon(int index) {
        return pokedex.obtener(index);
    }
}