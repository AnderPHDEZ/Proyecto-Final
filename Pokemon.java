package com.mycompany.proyectopokemon;

public class Pokemon {
    private String nombre;
    private String tipo;
    private int hp;
    private int ataque;
    private int defensa;
    private int ataqueEspecial;
    private int defensaEspecial;
    private int recargaEspecial;
    private boolean especialListo;
    private boolean defendiendo = false;

    public Pokemon(String nombre, String tipo, int hp, int ataque, int defensa, int ataqueEspecial, int defensaEspecial) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.recargaEspecial = 0;
        this.especialListo = true;
    }

    public void recibirDano(int dano) {
        if (defendiendo) {
            dano /= 2;
            defendiendo = false;
        }
        this.hp -= dano;
        if (this.hp < 0) this.hp = 0;
    }

    public boolean estaVivo() {
        return this.hp > 0;
    }

    public String atacarConTexto(Pokemon oponente) {
        if (!ataqueExitoso()) return this.nombre + " falló el ataque.";
        int dano = calcularDano(this.ataque, oponente.defensa);
        oponente.recibirDano(dano);
        return this.nombre + " atacó a " + oponente.nombre + " causando " + dano + " de daño.";
    }

    public String ataqueEspecialConTexto(Pokemon oponente) {
        if (!especialListo) return this.nombre + " aún no puede usar su ataque especial.";
        if (!ataqueExitoso()) {
            especialListo = false;
            recargaEspecial = 2;
            return this.nombre + " falló el ataque especial.";
        }
        int bonificacion = calcularBonificacion(this.tipo, oponente.tipo);
        int dano = calcularDano(this.ataqueEspecial + bonificacion, oponente.defensaEspecial);
        oponente.recibirDano(dano);
        especialListo = false;
        recargaEspecial = 2;
        return this.nombre + " usó ataque especial contra " + oponente.nombre + " causando " + dano + " de daño.";
    }

    public void activarDefensa() {
        this.defendiendo = true;
    }

    public void recargarTurno() {
        if (!especialListo) {
            recargaEspecial--;
            if (recargaEspecial <= 0) {
                especialListo = true;
            }
        }
    }

    private int calcularDano(int ataque, int defensa) {
        int dano = ataque - defensa;
        return dano > 0 ? dano : 0;
    }

    private int calcularBonificacion(String tipoAtacante, String tipoOponente) {
        if (tipoAtacante.equals("Fuego") && tipoOponente.equals("Normal")) return 5;
        if (tipoAtacante.equals("Agua") && tipoOponente.equals("Fuego")) return 10;
        if (tipoAtacante.equals("Normal") && tipoOponente.equals("Agua")) return 5;
        return 0;
    }

    private boolean ataqueExitoso() {
        double probabilidad = Math.random(); // válido, no usa java.util
        return probabilidad < 0.8;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getHP() { return hp; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getAtaqueEspecial() { return ataqueEspecial; }
    public int getDefensaEspecial() { return defensaEspecial; }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - HP: " + hp;
    }
}