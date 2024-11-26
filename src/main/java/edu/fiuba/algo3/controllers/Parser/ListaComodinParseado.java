package edu.fiuba.algo3.controllers.Parser;

import java.util.ArrayList;
import java.util.List;

public class ListaComodinParseado {
    private List<List<ComodinParseado>> sublistasComodines;

    public ListaComodinParseado() {
        this.sublistasComodines = new ArrayList<>();
    }

    public List<List<ComodinParseado>> getSublistasComodines() {
        return sublistasComodines;
    }

    public List<ComodinParseado> getTodosLosComodines() {
        List<ComodinParseado> todosLosComodines = new ArrayList<>();
        for (List<ComodinParseado> sublista : sublistasComodines) {
            todosLosComodines.addAll(sublista);
        }
        return todosLosComodines;
    }
}