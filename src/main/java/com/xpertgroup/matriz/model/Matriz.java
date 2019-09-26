package com.xpertgroup.matriz.model;

public class Matriz {

    private int[][][] valoresMatriz;

    public Matriz(int dimensiones) {
        super();
        this.valoresMatriz = new int[dimensiones][dimensiones][dimensiones];
    }

    /*public void crearMatriz(int dimensiones, int operaciones) {
        this.valoresMatriz = new int[dimensiones][dimensiones][dimensiones];
        this.estructuraMatriz = new EstructuraMatriz(dimensiones, operaciones);
    }*/

    public void iniciarMatriz(int dimensiones) {

        for(int i=0;i<dimensiones;i++){
            for(int j=0;j<dimensiones;j++){
                for(int k=0;k<dimensiones;k++){
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
