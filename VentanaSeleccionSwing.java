package com.mycompany.proyectopokemon;

import javax.swing.*;
import java.awt.*;

public class VentanaSeleccionSwing extends JFrame {

    private Entrenador jugador;
    private ListaDisponibles disponibles;
    private JPanel panelSeleccionados;
    private JButton btnIniciar;

    public VentanaSeleccionSwing() {
        setTitle("Selecciona tus Pokémon");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        jugador = new Entrenador("Jugador");
        disponibles = new ListaDisponibles();
        inicializarPokemons();

        JPanel panelOpciones = new JPanel(new GridLayout(3, 3, 10, 10));
        NodoPokemon actual = disponibles.getCabeza();
        while (actual != null) {
            Pokemon p = actual.pokemon;
            JButton btn = new JButton(p.getNombre() + " (" + p.getTipo() + ")");
            btn.addActionListener(e -> seleccionarPokemon(p));
            panelOpciones.add(btn);
            actual = actual.siguiente;
        }

        panelSeleccionados = new JPanel();
        panelSeleccionados.setLayout(new BoxLayout(panelSeleccionados, BoxLayout.Y_AXIS));
        panelSeleccionados.setBorder(BorderFactory.createTitledBorder("Seleccionados"));

        btnIniciar = new JButton("Iniciar Batalla");
        btnIniciar.setEnabled(false);
        btnIniciar.addActionListener(e -> {
            this.dispose();
            SwingUtilities.invokeLater(() -> {
                VentanaBatallaSwing batalla = new VentanaBatallaSwing(jugador);
                batalla.setVisible(true);
            });
        });

        add(new JLabel("Selecciona 4 Pokémon diferentes:"), BorderLayout.NORTH);
        add(panelOpciones, BorderLayout.CENTER);

        JPanel panelDerecha = new JPanel(new BorderLayout());
        panelDerecha.add(panelSeleccionados, BorderLayout.CENTER);
        panelDerecha.add(btnIniciar, BorderLayout.SOUTH);

        add(panelDerecha, BorderLayout.EAST);
    }

    private void seleccionarPokemon(Pokemon p) {
        if (jugador.obtenerSiguientePokemon() != null && yaSeleccionado(p.getNombre())) {
            return;
        }

        if (jugador.tienePokemonVivo() && obtenerCantidadSeleccionada() < 4) {
            jugador.agregarPokemon(clonarPokemon(p));
            panelSeleccionados.add(new JLabel("- " + p.getNombre() + " (" + p.getTipo() + ")"));
            panelSeleccionados.revalidate();
            panelSeleccionados.repaint();
        }

        if (obtenerCantidadSeleccionada() == 4) {
            btnIniciar.setEnabled(true);
        }
    }

    private boolean yaSeleccionado(String nombre) {
        for (int i = 0; i < 4; i++) {
            Pokemon p = jugador.obtenerPokemon(i);
            if (p != null && p.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    private int obtenerCantidadSeleccionada() {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (jugador.obtenerPokemon(i) != null) {
                count++;
            }
        }
        return count;
    }

    private Pokemon clonarPokemon(Pokemon p) {
        return new Pokemon(p.getNombre(), p.getTipo(), p.getHP(), p.getAtaque(), p.getDefensa(), p.getAtaqueEspecial(), p.getDefensaEspecial());
    }

    private void inicializarPokemons() {
        disponibles.agregar(new Pokemon("Charmander", "Fuego", 115, 70, 45, 80, 60));
        disponibles.agregar(new Pokemon("Squirtle", "Agua", 190, 55, 45, 75, 65));
        disponibles.agregar(new Pokemon("Bulbasaur", "Normal", 150, 50, 35, 70, 60));
        disponibles.agregar(new Pokemon("Pidgey", "Normal", 150, 50, 35, 70, 60));
        disponibles.agregar(new Pokemon("Magmar", "Fuego", 115, 70, 45, 80, 60));
        disponibles.agregar(new Pokemon("Poliwhirl", "Agua", 190, 55, 45, 75, 65));
        disponibles.agregar(new Pokemon("Pikachu", "Normal", 150, 50, 35, 70, 60));
        disponibles.agregar(new Pokemon("Rattata", "Normal", 150, 50, 35, 70, 60));
        disponibles.agregar(new Pokemon("Oddish", "Agua", 190, 55, 45, 75, 65));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaSeleccionSwing ventana = new VentanaSeleccionSwing();
            ventana.setVisible(true);
        });
    }
}