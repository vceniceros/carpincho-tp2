package edu.fiuba.algo3;
//import edu.fiuba.algo3.vistas.App;

//Importo paquetes necesarios para javafx
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage) {
        // Nombres de las cartas (deben coincidir con los archivos en la carpeta de recursos).
        String[] nombreCartas = {
                "kDiamantes.jpg",
                "dosCorazon.jpg",
                "cincoCorazon.jpg",
                "qCorazon.jpg",
                "kTrebol.jpg",
                "ochoTrebol.jpg",
                "seisTrebol.jpg",
                "jDiamantes.jpg"
        };

        // Contenedor principal.
        BorderPane root = new BorderPane();

        // VBox para la información del jugador.
        VBox playerInfo = new VBox(10);
        playerInfo.setStyle("-fx-background-color: #2B2B2B; -fx-padding: 10;");
        playerInfo.setAlignment(Pos.TOP_CENTER);

        // Etiqueta de puntuación.
        Label scoreLabel = new Label("Puntos Necesarios: 200");
        scoreLabel.setTextFill(Color.WHITE); // Cambia el color del texto a blanco.
        scoreLabel.setFont(new Font("Arial", 16));

        // Etiqueta del número de ronda.
        Label roundLabel = new Label("Ronda: 4 / 12");
        roundLabel.setTextFill(Color.WHITE);
        roundLabel.setFont(new Font("Arial", 16));

        // Botón de opciones.
        Button optionsButton = new Button("Descartar");
        optionsButton.setStyle("-fx-background-color: #FF6600; -fx-text-fill: white;");

        // Agregar etiquetas y botón al VBox.
        playerInfo.getChildren().addAll(scoreLabel, roundLabel, optionsButton);

        // HBox para las cartas activas.
        HBox activeCards = new HBox(10);
        activeCards.setAlignment(Pos.CENTER); // Centra el contenido horizontalmente.
        activeCards.setStyle("-fx-background-color: #4A148C; -fx-padding: 10;");

        for (String nombreCarta : nombreCartas) {
            try {
                // Cargar la imagen de la carta desde la carpeta de recursos.
                Image cardImage = new Image(getClass().getResourceAsStream("/images/Cartas/" + nombreCarta));
                ImageView cardView = new ImageView(cardImage);

                // Ajustar las dimensiones de las cartas.
                cardView.setFitWidth(100); // Ajusta el ancho de la carta a 100 píxeles.
                cardView.setPreserveRatio(true); // Mantiene la proporción de la imagen.

                // Evento para levantar la carta cuando el mouse pasa sobre ella.
                cardView.setOnMouseEntered(event -> {
                    cardView.setTranslateY(-20); // Mueve la carta hacia arriba 20 píxeles.
                    cardView.setEffect(new DropShadow(10, Color.BLACK)); // Agrega un efecto de sombra.
                });

                // Evento para devolver la carta a su posición original cuando el mouse se retira.
                cardView.setOnMouseExited(event -> {
                    cardView.setTranslateY(0); // Devuelve la carta a su posición original.
                    cardView.setEffect(null); // Elimina el efecto de sombra.
                });

                // Agregar la carta al contenedor de cartas.
                activeCards.getChildren().add(cardView);
            } catch (Exception e) {
                System.out.println("No se pudo cargar la carta: " + nombreCarta);
                e.printStackTrace();
            }
        }

        // Colocar el VBox en la parte superior y las cartas en el centro.
        root.setTop(playerInfo);
        root.setCenter(activeCards);

        // Configuración de la escena.
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Balatro");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {

       // App.main(args);
        launch(args);
    }
}
