package edu.fiuba.algo3.entrega_2.parserRonda;
import com.google.gson.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class parserRonda {
    String filePath;
    public static List<Ronda> parseRondas(String filePath)  throws IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));

        Gson gson = new GsonBuilder()
                     .registerTypeAdapter(Object.class, new ActivacionAdapter())
                     .create();

        Juego juego = gson.fromJson(jsonString, Juego.class);

        return juego.getRondas();
    }
}
