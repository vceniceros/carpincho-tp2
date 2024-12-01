package edu.fiuba.algo3.modelo.MazoDeComodines;

import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.comodin.Comodin;

import java.util.ArrayList;

public class MazoDeComodines {
    private ArrayList<Comodin> comodines;
    private int capacidadMaxima = 5; //no pueden haber mas de 5 comodines


    public MazoDeComodines(){
        this.comodines = new ArrayList<Comodin>();
    }

    public void seleccionar(Comodin comodin){
        this.comodines.add(comodin);
    }

    //va comodin por comodin y los aplica
    public void aplicarA(ManoDePoker mano){
        for(Comodin comodin : this.comodines){
            comodin.aplicarA(mano);
        }
    }
    /*


    a este mazo lo va a tener el jugador, se instancia cuando se instancia el jugador, solo va a haber uno de comodines/
     */
}
