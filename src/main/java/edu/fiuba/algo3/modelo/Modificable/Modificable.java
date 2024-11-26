package edu.fiuba.algo3.modelo.Modificable;

import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

public interface Modificable {
    void aplicarModificacion(Puntaje valor);
    boolean esIgual(Modificable otroModificable);

}