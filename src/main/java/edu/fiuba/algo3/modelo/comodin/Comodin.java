package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.activacion.Activacion;
import edu.fiuba.algo3.modelo.efectos.Efecto;

public class Comodin {
    private Efecto efecto;
    private String descripcion;
    private String nombre;
    private Activacion activacion;

    public Comodin(String nombre, String descripcion,Efecto efecto, Activacion activacion) {
        this.efecto = efecto;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.activacion = activacion;
    }
    public Puntaje aplicarA(ManoDePoker mano) {
        Puntaje puntajeMano = mano.devolverPuntaje();
        Puntaje puntajeModificado;
        if (!activacion.esActivable(mano)) {
            puntajeModificado = puntajeMano;
        }else {
            puntajeModificado = efecto.aplicarEfecto(puntajeMano);
        }
        return puntajeModificado;
    }

}


