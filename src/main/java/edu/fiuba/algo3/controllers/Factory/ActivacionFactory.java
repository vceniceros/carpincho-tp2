package edu.fiuba.algo3.controllers.Factory;

import edu.fiuba.algo3.modelo.activacion.Activacion;
import edu.fiuba.algo3.modelo.activacion.ActivacionDescarte;
import edu.fiuba.algo3.modelo.activacion.ActivacionSiempre;

import java.util.Map;

public class ActivacionFactory {
    public static Activacion crearActivacion(Object activacion) {
        if (activacion instanceof String) {
            return crearActivacionDesdeString((String) activacion);
        } else if (activacion instanceof Map) {
            Map<String, String> activacionMap = (Map<String, String>) activacion;
            return crearActivacionDesdeMap(activacionMap);
        } else {
            throw new IllegalArgumentException("Tipo de activación no soportado: " + activacion.getClass().getName());
        }
    }

    public static Activacion crearActivacionDesdeString(String tipo) {
        switch (tipo) {
            case "Descarte":
                return new ActivacionDescarte();
            case "Siempre":
                return new ActivacionSiempre();
            default:
                throw new IllegalArgumentException("Tipo de activación desconocido: " + tipo);
        }
    }

    private static Activacion crearActivacionDesdeMap(Map<String, String> activacionMap) {
        if (activacionMap.containsKey("Mano Jugada")) {
            String valor = activacionMap.get("Mano Jugada");
            //  return new ActivacionManoDePoker(valor);
            return new ActivacionDescarte();

        }
        if (activacionMap.containsKey("1 en")) {
            String valor = activacionMap.get("1 en");
            // return new ActivacionManoDePoker(valor);
            return new ActivacionDescarte();

        }
        throw new IllegalArgumentException("No se encontró un tipo válido de activación en el mapa");
    }
}
