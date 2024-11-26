package edu.fiuba.algo3.controllers.Factory;

import edu.fiuba.algo3.modelo.comodin.Activacion;
import edu.fiuba.algo3.modelo.comodin.ActivacionDescarte;
import edu.fiuba.algo3.modelo.comodin.ActivacionSiempre;

public class FactoryDeActivacion {
    public FactoryDeActivacion(){}

    public static Activacion generarActivacion(String activacion) {
        Activacion activacionGenerada;
        if(activacion.equals("Descarte")){
            activacionGenerada = new ActivacionDescarte();
        }else if(activacion.equals("Siempre")){
            activacionGenerada = new ActivacionSiempre();
        } else if (activacion.containskey()) {
            
        }
    }
}
