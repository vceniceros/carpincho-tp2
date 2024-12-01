package edu.fiuba.algo3;
//import edu.fiuba.algo3.vistas.App;

//Importo paquetes necesarios para javafx
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application{
    // Método para alternar el efecto de sombra al hacer click
    private void toggleDropShadowEffect(ImageView imageView) {
        // Verificar si ya hay un efecto aplicado
        if (imageView.getEffect() == null) {
            // Si no tiene efecto, aplicar la sombra
            DropShadow shadow = new DropShadow();
            shadow.setOffsetX(10);  // Desplazamiento en X (derecha)
            shadow.setOffsetY(10);  // Desplazamiento en Y (abajo)
            shadow.setColor(Color.BLACK);  // Color de la sombra
            shadow.setRadius(15);  // Difuminado de la sombra
            //shadow.setOpacity(0.7);  // Opacidad de la sombra
            imageView.setEffect(shadow); // Aplicar la sombra
        } else {
            // Si ya tiene un efecto, quitarlo
            imageView.setEffect(null);  // Eliminar el efecto de sombra
        }
    }
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Seleccione una carta");
        label.setStyle("-fx-font-size: 15px;");

        Label cantRondas = new Label("Cantidad rondas: 8");
        Label cantPuntaje = new Label("Puntaje minimo: 50");
        Label cantDescartes = new Label("Descartes restantes: 3");
        Button botonDescarte = new Button("Descartar");//.addEventHandler(); //eventhadler
        Button botonSeleccionar = new Button("Seleccionar");

        //creo el fondo

        Image fondo = new Image(getClass().getResourceAsStream("/images/fondoPoker.jpg"));
        // Crear las imágenes
        Image carta1 = new Image(getClass().getResourceAsStream("/images/Cartas/qCorazon.jpg"));
        Image carta2 = new Image(getClass().getResourceAsStream("/images/Cartas/diezPica.jpg"));
        Image carta3 = new Image(getClass().getResourceAsStream("/images/Cartas/diezCorazon.jpg"));
        Image carta4 = new Image(getClass().getResourceAsStream("/images/nuevePica.png"));
        Image carta5 = new Image(getClass().getResourceAsStream("/images/Cartas/seisPica.jpg")); // seisPica
        Image carta6 = new Image(getClass().getResourceAsStream("/images/cincoPica.png"));
        Image carta7 = new Image(getClass().getResourceAsStream("/images/tresDiamante.png"));
        Image carta8 = new Image(getClass().getResourceAsStream("/images/asTrebol.png"));
       //ImagecartaReverso = new Image(getClass().getResourceAsStream("/images/carta reverso.jpg"));
        // creo el fondo para la imagen
        BackgroundSize bgSize = new BackgroundSize(
                100,   // Ancho en porcentaje (100% del contenedor)
                100,   // Alto en porcentaje (100% del contenedor)
                true,  // Ancho en porcentaje
                true,  // Alto en porcentaje
                true,  // Usar "contain"
                false  // No usar "cover"
        );
        BackgroundImage backgroundImage = new BackgroundImage(fondo,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bgSize);

        // Crear los ImageView
        ImageView imageView1 = new ImageView(carta1);
        imageView1.setFitWidth(150);
        imageView1.setPreserveRatio(true);

        ImageView imageView2 = new ImageView(carta2);
        imageView2.setFitWidth(150);
        imageView2.setPreserveRatio(true);

        ImageView imageView3 = new ImageView(carta3);
        imageView3.setFitWidth(150);
        imageView3.setPreserveRatio(true);

        ImageView imageView4 = new ImageView(carta4);
        imageView4.setFitWidth(150);
        imageView4.setPreserveRatio(true);

        ImageView imageView5 = new ImageView(carta5);
        imageView5.setFitWidth(150);
        imageView5.setPreserveRatio(true);

        ImageView imageView6 = new ImageView(carta6);
        imageView6.setFitWidth(150);
        imageView6.setPreserveRatio(true);

        ImageView imageView7 = new ImageView(carta7);
        imageView7.setFitWidth(150);
        imageView7.setPreserveRatio(true);

        ImageView imageView8 = new ImageView(carta8);
        imageView8.setFitWidth(150);
        imageView8.setPreserveRatio(true);
        /*
        ImageView imageView9 = new ImageView(cartaReverso);
        imageView9.setFitWidth(150);
        imageView9.setPreserveRatio(true);*/
        // Crear un GridPane y colocar las imágenes en las celdas
        GridPane grid = new GridPane();
        grid.setVgap(10);  // Espacio entre las filas
        grid.setHgap(10);  // Espacio entre las columnas
        grid.setBackground(new Background(backgroundImage));
        // Colocar las imágenes en la cuadrícula (fila, col)
        grid.add(imageView1,0,3);  // Fila 0, Columna 0
        grid.add(imageView2,1,3);  // Fila 0, Columna 1
        grid.add(imageView3,2,3);
        grid.add(imageView4,3,3);
        grid.add(imageView5,4,3);
        grid.add(imageView6,5,3);
        grid.add(imageView7,6,3);
        grid.add(imageView8,7,3);

        grid.add(label,4,10);
        grid.add(botonDescarte, 1,5);
        grid.add(botonSeleccionar, 1, 6);
        grid.add(cantPuntaje, 7,4);
        grid.add(cantRondas, 7,5);
        grid.add(cantDescartes,7,6);

        imageView1.setOnMouseClicked(event -> {
            label.setText(" Puntos: 10 y multiplicador: x1 ");
            toggleDropShadowEffect(imageView1);
        });
        imageView2.setOnMouseClicked(event -> {
            label.setText(" Puntos: 10 y multiplicador: x1 ");
            toggleDropShadowEffect(imageView2);
        });
        imageView3.setOnMouseClicked(event -> {
            label.setText(" Puntos: 10 y multiplicador: x1 ");
            toggleDropShadowEffect(imageView3);
        });
        imageView4.setOnMouseClicked(event -> {
            label.setText(" Puntos: 9 y multiplicador: x1 ");
            toggleDropShadowEffect(imageView4);
        });
        imageView5.setOnMouseClicked(event -> {
            label.setText(" Puntos: 6 y multiplicador: x1 ");
            toggleDropShadowEffect(imageView5);
        });
        imageView6.setOnMouseClicked(event -> {
            label.setText(" Puntos: 5 y multiplicador: x1 ");
            toggleDropShadowEffect(imageView6);
        });
        imageView7.setOnMouseClicked(event -> {
            label.setText(" Puntos: 3 y multiplicador: x1 ");
            toggleDropShadowEffect(imageView7);
        });
        imageView8.setOnMouseClicked(event -> {
            label.setText(" Puntos: 10 y multiplicador: x1 ");
            toggleDropShadowEffect(imageView8);
        });

        // Crear la escena
        Scene scene = new Scene(grid, 1440, 720);
        //scene.setFill(Color.GREEN); // Aca cambio el fondo al color que quiera.

        // Configurar la ventana
        primaryStage.setTitle("Balatro");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {

       // App.main(args);
        launch(args);
    }
}
