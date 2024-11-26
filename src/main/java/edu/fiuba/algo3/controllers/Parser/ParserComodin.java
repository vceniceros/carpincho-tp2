package edu.fiuba.algo3.controllers.Parser;
import com.google.gson.*;
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
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Object.class, new ActivacionAdapter())
                .create();
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

        for (ComodinParseado comodinFake : fakeComodin) {
            String nombre = comodinFake.getNombre();
            String descripcion = comodinFake.getDescripcion();
            Activacion activacion = FactoryDeActivacion.generarActivacion(comodinFake.getActivacion());
            EfectoParseado efectoParseado = comodinFake.getEfecto();
            Comodin comodin = new Comodin(nombre, descripcion, efectoParseado.getPuntos(), efectoParseado.getMultiplicador(), activacion);
            comodines.add(comodin);
        }
        return comodines;
    }
}
