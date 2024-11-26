package edu.fiuba.algo3.controllers.Parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.fiuba.algo3.controllers.Factory.FactoryDeActivacion;
import edu.fiuba.algo3.modelo.comodin.Activacion;
import edu.fiuba.algo3.modelo.comodin.Comodin;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ParserComodin {
    public static List<ComodinParseado> convertirDeJsonAFakeComodin(String ruta) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(ruta)) {
            Type comodinesType = new TypeToken<ListaComodinParseado>() {
            }.getType();
            ListaComodinParseado listaComodinParseado = gson.fromJson(reader, comodinesType);
            return listaComodinParseado.getTodosLosComodines();
        } catch (IOException e) {
            throw new ErrorAlParsearJson();
        }

    }

    public static List<Comodin> parsearDeFakeComodinAComodin(List<ComodinParseado> fakeComodin) {
        List<Comodin> comodines = new ArrayList<>();

        for (ComodinParseado comodin : fakeComodin) {
            String nombre = comodin.getNombre();
            String descripcion = comodin.getDescripcion();
            Activacion activacion = FactoryDeActivacion.generarActivacion(comodin.getActivacion());
        }

    }
}
