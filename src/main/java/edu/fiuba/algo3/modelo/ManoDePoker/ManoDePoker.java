package edu.fiuba.algo3.modelo.ManoDePoker;

import edu.fiuba.algo3.modelo.Modificable.Modificable;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.ArrayList;
import java.util.Objects;


public abstract class ManoDePoker implements Modificable {
    protected String nombre;
    protected Puntaje puntaje;
    protected double probabilidad;

    public void jugar(ArrayList<Carta> cartas){
        for (Carta carta : cartas){
            this.puntaje.sumarValorDeUnPuntaje(carta.obtenerPuntaje());
        }

    }

    public int calcularPuntaje(){
        return this.puntaje.calcularPuntaje();
    }

    public Puntaje devolverPuntaje(){
        return this.puntaje;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        ManoDePoker otraManoDePoker = (ManoDePoker) obj;
        return(Objects.equals(nombre,otraManoDePoker.nombre));
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre);
    }

    /*tanto carta como mano de poker tienen puntaje, por lo tanto ellos son los modificables
    * el puntaje que se modifica debería estar implementado dentro de cada uno de ellos*/
    public void aplicarModificacion(Puntaje puntaje){
        this.puntaje = puntaje; //se lo pongo en manoDePoker para respetar el encapsulamiento

    }

    public boolean esIgual(Modificable otroModificable){
        return this.equals(otroModificable);
    }

}

