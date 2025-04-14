package com.mycompany.proyectopokemon;

import javax.swing.*;
import java.awt.*;

public class VentanaBatallaSwing extends JFrame {

    private Entrenador jugador;
    private Entrenador cpu;
    private Pokemon pJugador;
    private Pokemon pCPU;

    private JLabel lblJugador, lblCPU, lblHPJugador, lblHPCPU;
    private JTextArea log;
    private JButton btnAtacar, btnEspecial, btnDefender;

    public VentanaBatallaSwing(Entrenador jugadorSeleccionado) {
        setTitle("Batalla Pokémon");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        this.jugador = jugadorSeleccionado;
        this.cpu = crearEntrenadorCPU();
        this.pJugador = jugador.obtenerSiguientePokemon();
        this.pCPU = cpu.obtenerSiguientePokemon();

        lblJugador = new JLabel();
        lblCPU = new JLabel();
        lblHPJugador = new JLabel();
        lblHPCPU = new JLabel();
        actualizarLabels();

        JPanel panelInfo = new JPanel(new GridLayout(2, 2));
        panelInfo.setBorder(BorderFactory.createTitledBorder("Estado"));
        panelInfo.add(lblJugador);
        panelInfo.add(lblCPU);
        panelInfo.add(lblHPJugador);
        panelInfo.add(lblHPCPU);

        btnAtacar = new JButton("Atacar");
        btnEspecial = new JButton("Ataque Especial");
        btnDefender = new JButton("Defender");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAtacar);
        panelBotones.add(btnEspecial);
        panelBotones.add(btnDefender);

        log = new JTextArea();
        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);

        add(panelInfo, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(scrollLog, BorderLayout.SOUTH);

        btnAtacar.addActionListener(e -> {
            if (pJugador.estaVivo()) {
                log.append(pJugador.atacarConTexto(pCPU) + "\n");
                resaltarDanio(lblHPCPU);
                verificarEstado();
                turnoCPU();
            }
        });

        btnEspecial.addActionListener(e -> {
            if (pJugador.estaVivo()) {
                log.append(pJugador.ataqueEspecialConTexto(pCPU) + "\n");
                resaltarDanio(lblHPCPU);
                verificarEstado();
                turnoCPU();
            }
        });

        btnDefender.addActionListener(e -> {
            pJugador.activarDefensa();
            log.append(pJugador.getNombre() + " se defendió este turno.\n");
            turnoCPU();
        });
    }

    private void turnoCPU() {
        Timer timer = new Timer(500, evt -> {
            if (pCPU == null || !pCPU.estaVivo()) return;

            String accion;
            if (Math.random() < 0.5) {
                accion = pCPU.atacarConTexto(pJugador);
            } else {
                accion = pCPU.ataqueEspecialConTexto(pJugador);
            }

            log.append(accion + "\n");
            resaltarDanio(lblHPJugador);

            pJugador.recargarTurno();
            pCPU.recargarTurno();
            verificarEstado();

            ((Timer) evt.getSource()).stop();
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void verificarEstado() {
        if (!pCPU.estaVivo()) {
            cpu.eliminarPokemonActual();
            pCPU = cpu.obtenerSiguientePokemon();
            if (pCPU == null) {
                log.append("\n¡Ganaste la batalla!\n");
                desactivarBotones();
                return;
            } else {
                log.append("\nEl CPU envía a " + pCPU.getNombre() + " a luchar.\n");
            }
        }

        if (!pJugador.estaVivo()) {
            jugador.eliminarPokemonActual();
            pJugador = jugador.obtenerSiguientePokemon();
            if (pJugador == null) {
                log.append("\nHas perdido la batalla...\n");
                desactivarBotones();
                return;
            } else {
                log.append("\nEnvías a " + pJugador.getNombre() + " a luchar.\n");
            }
        }

        actualizarLabels();
    }

    private void desactivarBotones() {
        btnAtacar.setEnabled(false);
        btnEspecial.setEnabled(false);
        btnDefender.setEnabled(false);
    }

    private void actualizarLabels() {
        lblJugador.setText("Jugador: " + (pJugador != null ? pJugador.getNombre() + " (" + pJugador.getTipo() + ")" : ""));
        lblCPU.setText("CPU: " + (pCPU != null ? pCPU.getNombre() + " (" + pCPU.getTipo() + ")" : ""));
        lblHPJugador.setText("HP: " + (pJugador != null ? pJugador.getHP() : 0));
        lblHPCPU.setText("HP: " + (pCPU != null ? pCPU.getHP() : 0));
    }

    private void resaltarDanio(JLabel label) {
        Color original = label.getForeground();
        label.setForeground(Color.RED);

        Timer timer = new Timer(300, e -> {
            label.setForeground(original);
            ((Timer) e.getSource()).stop();
        });
        timer.setRepeats(false);
        timer.start();
    }

    private Entrenador crearEntrenadorCPU() {
        Entrenador e = new Entrenador("CPU");
        e.agregarPokemon(new Pokemon("Magmar", "Fuego", 115, 70, 45, 80, 60));
        e.agregarPokemon(new Pokemon("Poliwhirl", "Agua", 190, 55, 45, 75, 65));
        e.agregarPokemon(new Pokemon("Oddish", "Agua", 190, 55, 45, 75, 65));
        e.agregarPokemon(new Pokemon("Rattata", "Normal", 150, 50, 35, 70, 60));
        return e;
    }
}