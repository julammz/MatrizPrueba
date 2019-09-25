package com.xpertgroup.matriz.model;

public class Matriz extends EstructuraMatriz {

    private EstructuraMatriz estructuraMatriz;
    private int[][][] valoresMatriz;

    public Matriz(int dimensiones, int operaciones) {
        super();
        this.valoresMatriz = new int[dimensiones][dimensiones][dimensiones];
        this.estructuraMatriz = new EstructuraMatriz(dimensiones, operaciones);
    }

    public void crearMatriz(int dimensiones, int operaciones) {
        this.valoresMatriz = new int[dimensiones][dimensiones][dimensiones];
        this.estructuraMatriz = new EstructuraMatriz(dimensiones, operaciones);
    }

    public void iniciarMatriz() {

        for(int i=0;i<this.estructuraMatriz.getDimensiones();i++){
            for(int j=0;j<this.estructuraMatriz.getDimensiones();j++){
                for(int k=0;k<this.estructuraMatriz.getDimensiones();k++){
                    this.setMatriz(i,j,k,0);
                }
            }
        }

    }

    public int[][][] getValoresMatriz() {
        return valoresMatriz;
    }

    public void setMatriz(int a, int b, int c, int valor) {
        this.valoresMatriz[a][b][c] = valor;
    }

    public int getValorMatriz(int a, int b, int c) {
        return this.valoresMatriz[a][b][c];
    }



}
