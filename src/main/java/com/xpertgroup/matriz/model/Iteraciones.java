package com.xpertgroup.matriz.model;

public class Iteraciones {

    private int iteraciones;
    private boolean terminoOperaciones;

    public Iteraciones() {
    }

    public Iteraciones(int iteraciones, boolean terminoOperaciones) {
        this.iteraciones = iteraciones;
        this.terminoOperaciones = terminoOperaciones;
    }

    public int getIteraciones() {
        return iteraciones;
    }

    public void setIteraciones(int iteraciones) {
        this.iteraciones = iteraciones;
    }

    public boolean isTerminoOperaciones() {
        return terminoOperaciones;
    }

    public void setTerminoOperaciones(boolean terminoOperaciones) {
        this.terminoOperaciones = terminoOperaciones;
    }
}
