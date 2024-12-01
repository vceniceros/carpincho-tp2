module edu.fiuba.algo {
    requires javafx.controls;
    requires json.simple;
    requires junit;
    requires com.google.gson;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.vistas;
    opens edu.fiuba.algo3.controllers.Parser to com.google.gson;
    opens edu.fiuba.algo3.controllers.Factory to com.google.gson;
    opens edu.fiuba.algo3.controllers.Parseados to com.google.gson;
}
