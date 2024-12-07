package edu.fiuba.algo3;
//import edu.fiuba.algo3.vistas.App;

//Importo paquetes necesarios para javafx
import edu.fiuba.algo3.modelo.Palo.Diamante;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application{
    // efecto cartas normales
    public void aplicarEfectoLevantarYBajar(ImageView cartaVista) {
        cartaVista.setOnMouseEntered(event -> {
            cartaVista.setTranslateY(-20);
            cartaVista.setEffect(new DropShadow(10, Color.BLACK));
        });
        cartaVista.setOnMouseExited(event -> {
            cartaVista.setTranslateY(0);
            cartaVista.setEffect(null);
        });
    }

    public void aplicarBrillo(ImageView cartaVista) {
        Glow glow = new Glow(0);
        cartaVista.setEffect(glow);
        cartaVista.setOnMouseClicked(event -> {
            if (glow.getLevel() == 0) {
                glow.setLevel(0.8);
            } else {
                glow.setLevel(0);
            }
            cartaVista.setEffect(glow);
        });
    }
    public void aplicarVibracion(ImageView cartaVista) {
        Timeline vibracion = new Timeline(
                new KeyFrame(Duration.ZERO, event -> {
                    cartaVista.setTranslateX(0);
                }),
                new KeyFrame(Duration.millis(50), event -> {
                    cartaVista.setTranslateX(-5);
                }),
                new KeyFrame(Duration.millis(100), event -> {
                    cartaVista.setTranslateX(5);
                }),
                new KeyFrame(Duration.millis(150), event -> {
                    cartaVista.setTranslateX(-5);
                }),
                new KeyFrame(Duration.millis(200), event -> {
                    cartaVista.setTranslateX(0);
                })
        );
        vibracion.setCycleCount(2);
        vibracion.setAutoReverse(true);
        cartaVista.setOnMouseClicked(event -> {
            vibracion.play();
        });
    }
    @Override
    public void start(Stage primaryStage) {
        //Solo cargo el background
        Image fondo = new Image(getClass().getResourceAsStream("/images/fondoMenu.jpg"));

        BackgroundImage background = new BackgroundImage(
                fondo,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO,true,true,false, true)
        );

        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(new Background(background));

        //hasta aca cree el fondo y lo agregue

        //logica de agregar las cartas al panel, junto a los botones
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

        HBox cartas = new HBox(10);
        cartas.setAlignment(Pos.CENTER);

        for(String cartaActual : nombreCartas ){
            Image carta = new Image(getClass().getResourceAsStream("/images/Cartas/" + cartaActual));
            ImageView cartaVista = new ImageView(carta);
            cartaVista.setFitHeight(180);
            cartaVista.setFitWidth(120);
            cartas.getChildren().add(cartaVista);

            aplicarEfectoLevantarYBajar(cartaVista);
        }

        VBox vbox = new VBox();
        vbox.getChildren().add(cartas);
        vbox.setSpacing(20);

        //creo los botones
        Button botonJugada = new Button("Jugar Mano");
        Button botonDescarte = new Button("Descartar");
        // le doy estilo con el css
        botonJugada.getStyleClass().add("btn-azul");
        botonDescarte.getStyleClass().add("btn-rojo");

        HBox botones = new HBox(100);
        botones.setAlignment(Pos.CENTER);
        botones.getChildren().addAll(botonJugada, botonDescarte);

        vbox.getChildren().add(botones);


        BorderPane.setAlignment(vbox, Pos.BOTTOM_CENTER);
        BorderPane.setMargin(vbox, new Insets(10,10,20,10));
        borderPane.setBottom(vbox);
        // termine tema cartas normales

        //aca creo las cartas del borde superior TAROTS y Comodines
        String[] tarots ={
                "tarotEmperatriz.png",
                "tarotSacerdotista.png"
        };

        HBox contenedorTarots = new HBox(15);
        contenedorTarots.setAlignment(Pos.CENTER);

        for(String tarotActual : tarots){
            Image tarot = new Image(getClass().getResourceAsStream("/images/tarots/"+ tarotActual));
            ImageView tarotVista = new ImageView(tarot);
            tarotVista.setFitHeight(180);
            tarotVista.setFitWidth(130);
            contenedorTarots.getChildren().add(tarotVista);

            tarotVista.setOnMouseClicked(event -> {
                aplicarBrillo(tarotVista);
            });
        }

        //aca debo agregar los comodines en el string:
        String[] cartasComodines ={
                "comodinColor.png",
                "comodinByN.png",
                "comodinColor.png"
        };
        //agrego Comodines, pueden ser hasta 5
        HBox contenedorComodines = new HBox(15);

        for( String comodinActual : cartasComodines){
            Image comodin = new Image(getClass().getResourceAsStream("/images/comodines/" + comodinActual));
            ImageView comodinVista = new ImageView(comodin);
            comodinVista.setFitHeight(180);
            comodinVista.setFitWidth(130);
            contenedorComodines.getChildren().add(comodinVista);
            comodinVista.setOnMouseClicked(event ->{
                aplicarBrillo(comodinVista);
            });
        }

        //creo el Contedor que abarca a ambos
        HBox contenedorCartasEspeciales = new HBox(200); //espacio entre las dos listas
        contenedorCartasEspeciales.setAlignment(Pos.CENTER);
        contenedorCartasEspeciales.getChildren().addAll(contenedorTarots, contenedorComodines);
        //AGREGO al borderpane en top
        borderPane.setTop(contenedorCartasEspeciales);
        BorderPane.setMargin(contenedorCartasEspeciales, new Insets(30,30,0,30));

        //Creo la escena

        Scene scene = new Scene(borderPane, 800, 600);

        //agrego Los css a la escena
        scene.getStylesheets().add(getClass().getResource("/Botones/estilosBotones.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("/estadoDelJuego.css").toExternalForm());

        //Informacion todo borde izquierdo

        VBox contenedorIzquierdo = new VBox(10);
        contenedorIzquierdo.setPadding(new Insets(15)); // Margen interno
        contenedorIzquierdo.setAlignment(Pos.TOP_CENTER); // Alinear al centro
        contenedorIzquierdo.getStyleClass().add("info-panel"); // Clase CSS principal

        // HBox para "Anota al menos"
        HBox puntosNecesarios = new HBox(10);
        puntosNecesarios.setAlignment(Pos.CENTER_LEFT); // Alineación izquierda
        puntosNecesarios.getStyleClass().add("hbox-puntos-necesarios");

        Label anotaLabel = new Label("Anota al menos:");
        Label puntajeAnotaLabel = new Label("450"); // Valor dinámico

        anotaLabel.getStyleClass().add("titulo-label"); // Sin el "."
        puntajeAnotaLabel.getStyleClass().add("puntaje-label");
        puntosNecesarios.getChildren().addAll(anotaLabel, puntajeAnotaLabel);
        contenedorIzquierdo.getChildren().add(puntosNecesarios);

        // segundo VBox
        HBox puntuacionRonda = new HBox(10);
        puntuacionRonda.setAlignment(Pos.CENTER_LEFT);
        puntuacionRonda.getStyleClass().add("hbox-puntuacion-ronda");

        Label puntuacionLabel = new Label("Puntuación ronda:");
        Label puntajeRondaLabel = new Label("0"); // Valor dinámico
        puntuacionLabel.getStyleClass().add("titulo-label");
        puntajeRondaLabel.getStyleClass().add("puntaje-label");

        puntuacionRonda.getChildren().addAll(puntuacionLabel, puntajeRondaLabel);

        // Añadir este HBox al VBox principal
        contenedorIzquierdo.getChildren().add(puntuacionRonda);

        // HBox para "Manos" y "Descartes"
        HBox manosDescartes = new HBox(20); // Espaciado entre los dos grupos
        manosDescartes.setAlignment(Pos.CENTER); // Alineación centrada
        manosDescartes.getStyleClass().add("hbox-manos-descartes");

        // Crear labels para "Manos"
        Label manosLabel = new Label("Manos:");
        Label manosValorLabel = new Label("5"); // Valor dinámico
        manosLabel.getStyleClass().add("titulo-label");
        manosValorLabel.getStyleClass().add("puntaje-label");

        // Crear labels para "Descartes"
        Label descartesLabel = new Label("Descartes:");
        Label descartesValorLabel = new Label("3"); // Valor dinámico
        descartesLabel.getStyleClass().add("titulo-label");
        descartesValorLabel.getStyleClass().add("puntaje-label");

        // Crear VBox para cada sección
        VBox manosBox = new VBox(5); // espacio
        manosBox.setAlignment(Pos.CENTER);
        manosBox.getChildren().addAll(manosLabel, manosValorLabel);

        VBox descartesBox = new VBox(5); // Espacio txt y valor
        descartesBox.setAlignment(Pos.CENTER);
        descartesBox.getChildren().addAll(descartesLabel, descartesValorLabel);

        // Añadir VBoxes al HBox
        manosDescartes.getChildren().addAll(manosBox, descartesBox);

        // Añadir este HBox al VBox principal
        contenedorIzquierdo.getChildren().add(manosDescartes);
        borderPane.setLeft(contenedorIzquierdo);

        // termineeeeeeeeeeeee parte info borde izquierdo

        //agrego la carta del mazo aca:
        HBox contenedorMazo = new HBox(10);
        contenedorMazo.setAlignment(Pos.CENTER);

        Image cartaMazo = new Image(getClass().getResourceAsStream("/images/cartaVolteada2.png"));
        ImageView cartaMazoVista = new ImageView(cartaMazo);
        cartaMazoVista.setFitHeight(200);
        cartaMazoVista.setFitWidth(150);

        // Creamos la animación de vibración
       aplicarVibracion(cartaMazoVista);
        //ending
        contenedorMazo.getChildren().add(cartaMazoVista);

        borderPane.setRight(contenedorMazo);
        BorderPane.setMargin(contenedorMazo, new Insets(30, 30, 0, 60));

        primaryStage.setTitle("BALATRO");
        primaryStage.setScene(scene);
        //agrego para que se acomode al tamaño de pantalla
        primaryStage.setMaximized(true);
        primaryStage.show();
        }
    public static void main(String[] args) {

       // App.main(args);
        launch(args);
    }
}
