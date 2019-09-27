package com.xpertgroup.matriz.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrizTest {

    @Test
    public void iniciarMatriz() {
        int[][][] esperado = { { { 0,0 }, { 0,0 } },
                { { 0,0 }, { 0,0 } } };

        Matriz resultado = new Matriz(2);

        assertArrayEquals(esperado, resultado.getValoresMatriz());
    }

    @Test
    public void setMatriz() {
        int[][][] esperado = { { { 0,0 }, { 0,5 } },
                { { 0,0 }, { 0,0 } } };

        Matriz resultado = new Matriz(2);
        resultado.setMatriz(0,1, 1, 5);

        assertArrayEquals(esperado, resultado.getValoresMatriz());
    }

    @Test
    public void getValorMatriz() {

        Matriz resultado = new Matriz(2);
        resultado.setMatriz(1,0, 0, 5);
        int valorEsperado = resultado.getValorMatriz(1,0,0);

        assertEquals(5, valorEsperado);
    }
}