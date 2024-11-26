package edu.fiuba.algo3.controllers.Factory;

import edu.fiuba.algo3.controllers.Parser.ComodinParseado;
import edu.fiuba.algo3.controllers.Parser.ParserComodin;
import edu.fiuba.algo3.modelo.Prooveedor.ProveedorDeComodines;
import edu.fiuba.algo3.modelo.comodin.Comodin;

import java.util.List;

public class FactoryDeComodines implements ProveedorDeComodines {
    private String ruta;
    public FactoryDeComodines(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public List<Comodin> generarComodines() {
        List<ComodinParseado> fakeComodin = ParserComodin.convertirDeJsonAFakeComodin(this.ruta);
        List<Comodin> comodines = ParserComodin.parsearDeFakeComodinAComodin(fakeComodin);
        return comodines;
    }
}
