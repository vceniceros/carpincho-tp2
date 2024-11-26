package edu.fiuba.algo3.modelo.Balatro;

import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.ronda.Ronda;

import java.util.ArrayList;

public class Balatro {
    private boolean rondaGanada = true;
    private ArrayList<Ronda> rondas;
    private Mazo mazoDeCartas;
    public Balatro(ArrayList<Ronda> rondas, Mazo mazoDeCartas){
        this.rondas = rondas;
        this.mazoDeCartas = mazoDeCartas;
    }

    public boolean jugar(){
        while(verificarRondaAnteriorGanada()){
            if(this.rondas.isEmpty()){
                return true;
            }
            Ronda rondaActual = rondas.get(0);
            this.rondaGanada = rondaActual.jugar(this.mazoDeCartas);
            this.rondas.remove(rondaActual);
        }
        return false;
    }

    private boolean verificarRondaAnteriorGanada(){
        return this.rondaGanada;
    }
}
