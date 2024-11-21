module edu.fiuba.algo {
    requires javafx.controls;
    requires json.simple;
    requires junit;
    requires com.google.gson;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.vistas;
    opens edu.fiuba.algo3.entrega_2.Parser to com.google.gson;
    opens edu.fiuba.algo3.entrega_2.parserRonda to com.google.gson;
    opens edu.fiuba.algo3.entrega_1.Mazo to org.mockito.Mockito;


}
