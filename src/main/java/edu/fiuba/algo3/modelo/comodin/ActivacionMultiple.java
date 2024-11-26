package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.ArrayList;
import java.util.List;

public class ActivacionMultiple implements Activacion {
    List<Activacion> activaciones;

    public ActivacionMultiple(List<Activacion> activaciones) {
        this.activaciones = activaciones;
    }

    public boolean esActivable(ManoDePoker mano) {
        boolean esActivable = true;
        for (Activacion activacion : this.activaciones) {
            if (!activacion.esActivable(mano)) {
                esActivable = false;
            }
        }
        return esActivable;
    }
}

