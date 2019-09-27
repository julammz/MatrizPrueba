package com.xpertgroup.matriz.controller;

import com.xpertgroup.matriz.model.EstructuraMatriz;
import com.xpertgroup.matriz.model.Iteraciones;
import com.xpertgroup.matriz.model.Matriz;
import com.xpertgroup.matriz.model.Resultados;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperacionesTest {

    @Test
    public void ejecucion() {

        int[][][] esperado = { { { 0,0 }, { 0,0 } }, { { 0,0 }, { 0,0 } } };

        final Matriz matriz = new Matriz(2);

        matriz.setMatriz(0,0, 0, 5);
        matriz.setMatriz(1,1, 1, 5);

        Resultados resultados = new Resultados();
        resultados.setResultado("");

        final Iteraciones iteraciones = new Iteraciones(1, false);
        final EstructuraMatriz estructuraMatriz = new EstructuraMatriz();
        final Operaciones operaciones = new Operaciones(iteraciones, estructuraMatriz, matriz, resultados);

        operaciones.Ejecucion("QUERY 1 1 1 2 2 2");

        assertEquals(" <br> 10", resultados.getResultado());

    }
}