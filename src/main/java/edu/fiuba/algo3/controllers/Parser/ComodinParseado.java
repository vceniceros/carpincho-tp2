package edu.fiuba.algo3.controllers.Parser;

public class ComodinParseado {
    private String nombre;
    private String descripcion;
    private String activacion;
    private EfectoParseado efecto;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getActivacion() {
        return activacion;
    }

    public void setActivacion(String activacion) {
        this.activacion = activacion;
    }

    public EfectoParseado getEfecto() {
        return efecto;
    }

    public void setEfecto(EfectoParseado efecto) {
        this.efecto = efecto;
    }

}
