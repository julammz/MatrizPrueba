package com.xpertgroup.matriz.model;

public class EstructuraMatriz {

    private int dimensiones;
    private int operaciones;


    public EstructuraMatriz(int dimensiones, int operaciones) {
        this.dimensiones = dimensiones;
        this.operaciones = operaciones;
    }

    public EstructuraMatriz() {

    }

    public int getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(int dimensiones) {
        this.dimensiones = dimensiones;
    }

    public int getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(int operaciones) {
        this.operaciones = operaciones;
    }
}
