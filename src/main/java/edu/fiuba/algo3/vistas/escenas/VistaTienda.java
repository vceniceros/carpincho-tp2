package edu.fiuba.algo3.vistas.escenas;

import edu.fiuba.algo3.modelo.Palo.Corazon;
import edu.fiuba.algo3.modelo.Palo.Diamante;
import edu.fiuba.algo3.modelo.Palo.Pica;
import edu.fiuba.algo3.modelo.Palo.Trebol;
import edu.fiuba.algo3.modelo.ronda.Tienda;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class VistaTienda extends Scene{
    private Stage stage;

    public VistaTienda(Stage stage, double width, double height, Tienda tienda) {
        super(new Pane(), width, height);
        this.stage = stage;
        Pane root = (Pane) this.getRoot();

        BackgroundImage imagenFondo = new BackgroundImage(
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/backgroundShop.jpg"))),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
        );
        Background fondo = new Background(imagenFondo);
        root.setBackground(fondo);

        Text textoTituloSuperior = new Text("SHOP");
        textoTituloSuperior.setStyle("-fx-font-size: 70px; -fx-font-weight: bold; -fx-fill: white;");

        Font fontCreepster = Font.loadFont(getClass().getResourceAsStream("/fonts/bokor.ttf"), 36);
        if (fontCreepster == null) {
            System.out.println("No se pudo cargar la fuente, usando la fuente predeterminada.");
            fontCreepster = Font.font("Arial", 36);  // Fuente de respaldo
        }
        textoTituloSuperior.setFont(fontCreepster);

        HBox contenedorTitulo = new HBox();
        contenedorTitulo.setAlignment(Pos.CENTER);
        contenedorTitulo.getChildren().addAll(textoTituloSuperior);
        contenedorTitulo.setPadding(new Insets(0, 0, 0, 20));  // Top, Right, Bottom, Left (más espacio a la izquierda)

        List<Carta> cartas = tienda.obtenerCartas();
        List<Tarot> tarots = tienda.obtenerTarots();
        List<Comodin> comodins = tienda.obtenerComodines();

        FlowPane contenedorCartas = new FlowPane();
        contenedorCartas.setOrientation(Orientation.HORIZONTAL);
        contenedorCartas.setPrefHeight(180);  // Establecer altura fija para el contenedor


        FlowPane contenedorTarots = new FlowPane();
        contenedorTarots.setOrientation(Orientation.HORIZONTAL);
        contenedorTarots.setPrefHeight(180);  // Establecer altura fija para el contenedor


        FlowPane contenedorComodines = new FlowPane();
        contenedorComodines.setOrientation(Orientation.HORIZONTAL);
        contenedorComodines.setPrefHeight(150);  // Establecer altura fija para el contenedor

        // Aca empiezo a tocar
        VBox panelDetalles = new VBox();
        panelDetalles.setAlignment(Pos.CENTER);
        panelDetalles.setSpacing(10);
        panelDetalles.setStyle("-fx-background-color: rgba(0, 0, 0, 0.8); -fx-padding: 20px; -fx-border-color: white; -fx-border-width: 2px;");
        panelDetalles.setVisible(false); // Ocultarlo inicialmente
        root.getChildren().add(panelDetalles);

        for (Carta carta : cartas) {
            Button botonCarta = new Button();
            botonCarta.setGraphic(new ImageView(obtenerImagenCarta(carta)));
            botonCarta.setStyle("-fx-background-color: transparent;");
            ImageView imagenCarta = (ImageView) botonCarta.getGraphic();
            imagenCarta.setFitWidth(80);
            imagenCarta.setFitHeight(120);

            botonCarta.setOnMouseEntered(event -> {
                imagenCarta.setFitWidth(100);
                imagenCarta.setFitHeight(140);
            });
            botonCarta.setOnMouseExited(event -> {
                imagenCarta.setFitWidth(80);
                imagenCarta.setFitHeight(120);
            });

            // Mostrar detalles de la carta al hacer click
            botonCarta.setOnMouseClicked(event -> {
                mostrarDetallesCarta(carta, panelDetalles, event.getSceneX(), event.getSceneY());
            });
            contenedorCartas.getChildren().add(botonCarta);
        }

        for (Tarot tarot : tarots) {
            Button botonTarot= new Button();
            botonTarot.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/tarot.jpg")))));
            botonTarot.setStyle("-fx-background-color: transparent;");
            ImageView imagenCarta = (ImageView) botonTarot.getGraphic();
            imagenCarta.setFitWidth(80);
            imagenCarta.setFitHeight(120);
            botonTarot.setOnMouseEntered(event -> {
                imagenCarta.setFitWidth(100);
                imagenCarta.setFitHeight(140);
            });
            botonTarot.setOnMouseExited(event -> {
                imagenCarta.setFitWidth(80);
                imagenCarta.setFitHeight(120);
            });
            botonTarot.setOnMouseClicked(event -> mostrarDetallesCarta(tarot, panelDetalles, event.getSceneX(),event.getSceneY()));
            contenedorTarots.getChildren().add(botonTarot);
        }

        for (Comodin comodin : comodins) {
            Button botonComodin= new Button();
            botonComodin.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/comodin.jpg")))));
            botonComodin.setStyle("-fx-background-color: transparent;");
            ImageView imagenCarta = (ImageView) botonComodin.getGraphic();
            imagenCarta.setFitWidth(80);
            imagenCarta.setFitHeight(120);
            botonComodin.setOnMouseEntered(event -> {
                imagenCarta.setFitWidth(100);
                imagenCarta.setFitHeight(140);
            });
            botonComodin.setOnMouseExited(event -> {
                imagenCarta.setFitWidth(80);
                imagenCarta.setFitHeight(120);
            });
            botonComodin.setOnMouseClicked(event -> mostrarDetallesCarta(comodin, panelDetalles, event.getX(), event.getY()));
            contenedorComodines.getChildren().add(botonComodin);
        }

        VBox contenedorCartasTarotsComodines = new VBox();
        contenedorCartasTarotsComodines.setAlignment(Pos.TOP_CENTER);

        Label textoCartaNormal = new Label("Normales: ");
        textoCartaNormal.setStyle("-fx-background-color: violet; -fx-text-fill: black; -fx-padding: 5px; -fx-border-color: black; -fx-border-width: 1px;");
        Label textoCartaTarot = new Label(" Tarots: ");
        textoCartaTarot.setStyle("-fx-background-color: violet; -fx-text-fill: black; -fx-padding: 5px; -fx-border-color: black; -fx-border-width: 1px;");
        Label textoComodin = new Label("Comodines: ");
        textoComodin.setStyle("-fx-background-color: violet; -fx-text-fill: black; -fx-padding: 5px; -fx-border-color: black; -fx-border-width: 1px;");
        contenedorCartasTarotsComodines.getChildren().addAll(
                textoCartaNormal, contenedorCartas,
                textoCartaTarot, contenedorTarots,
                textoComodin, contenedorComodines
        );

        VBox contenedorPrincipal = new VBox(20);
        contenedorPrincipal.setAlignment(Pos.TOP_CENTER);
        contenedorPrincipal.getChildren().addAll(contenedorTitulo, contenedorCartasTarotsComodines);

        root.getChildren().add(contenedorPrincipal);
    }

    private Image obtenerImagenCarta(Carta carta) {
        String palo = compararPalos(carta);
        String valor = carta.obtenerNombre();
        String rutaImagen = "/images/Cartas/" + palo + "/" + valor + ".jpg";
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream(rutaImagen)));
    }


    private String compararPalos(Carta carta){
        Map<String, Carta> palos = new HashMap<>();

        Carta corazon = new Carta(new Corazon(), 2, 2, 1);
        Carta pica = new Carta(new Pica(), 3, 3, 1);
        Carta trebol = new Carta(new Trebol(), 2, 2, 1);
        Carta diamante = new Carta(new Diamante(), 3, 3, 1);

        palos.put("corazones", corazon);
        palos.put("picas", pica);
        palos.put("trebol", trebol);
        palos.put("diamantes", diamante);

        for (Map.Entry<String, Carta> entry : palos.entrySet()) {
            if (carta.sonMismoPalo(entry.getValue())) {
                return entry.getKey();
            }
        }
        return "Palo desconocido";
    }

    private void mostrarDetallesCarta(Object carta, VBox panelDetalles, double x, double y) {
        panelDetalles.getChildren().clear();
        panelDetalles.setVisible(true);
        panelDetalles.setStyle("-fx-background-color: rgba(1, 1, 1, 0.8); -fx-border-color: white; -fx-border-width: 2; -fx-padding: 20;");

        // Dimensiones y posición del panel
        panelDetalles.setPrefWidth(375);
        panelDetalles.setPrefHeight(250);
        //panelDetalles.setLayoutX(stage.getWidth() - 320);  // Posición fija al costado derecho
        //panelDetalles.setLayoutY((stage.getHeight() - 200) / 2);  // Centrado verticalmente

        panelDetalles.setLayoutX((stage.getWidth() - panelDetalles.getPrefWidth()) / 2);  // Centrado horizontalmente
        panelDetalles.setLayoutY((stage.getHeight() - panelDetalles.getPrefHeight()) / 2);  // Centrado verticalmente
        panelDetalles.setAlignment(Pos.CENTER);

        Label titulo = new Label("Detalles de la carta:");
        titulo.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 25px;");
        titulo.setLayoutY(10);

        Label descripcion = new Label(obtenerDescripcionCarta(carta));
        descripcion.setWrapText(true);
        descripcion.setPrefWidth(260);
        descripcion.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 16px;");

        panelDetalles.getChildren().addAll(titulo, descripcion);
        //String detalles = "Nombre: " + carta.toString() + "\nDescripción: " + obtenerDescripcionCarta(carta);
        //System.out.println(detalles);
    }

    private String obtenerDescripcionCarta(Object carta) {
        if (carta instanceof Carta) {
            return "No tiene descripción";
        } else if (carta instanceof Tarot) {
            return "Descripción del tarot: " + ((Tarot) carta).getDescripcion();
        } else if (carta instanceof Comodin) {
            return "Descripción del comodín: " + ((Comodin) carta).getDescripcion();
        }
        return "Descripción no disponible";
    }

}
