package com.xpertgroup.matriz.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xpertgroup.matriz.model.EstructuraMatriz;
import com.xpertgroup.matriz.model.Iteraciones;
import com.xpertgroup.matriz.model.Matriz;
import com.xpertgroup.matriz.model.Resultados;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


@Controller
public class SalidaEntradaDatos {

    @GetMapping("/entrada")
    public String Entrada(Resultados resultados) {
        return "entrada";
    }

    @PostMapping("/procesar")
    public String Resultado(Resultados resultados){

        final Iteraciones iteraciones = new Iteraciones(0, false);
        final EstructuraMatriz estructuraMatriz = new EstructuraMatriz();
        final Matriz matriz = new Matriz(1);
        final Operaciones operaciones = new Operaciones(iteraciones, estructuraMatriz, matriz, resultados);

        estructuraMatriz.setOperaciones(0);
        iteraciones.setIteraciones(0);
        resultados.setResultado(" ");

        List<String> instrucciones = Arrays.asList(resultados.getInstruccion().split("\\r?\\n"));


        for (String instruccion : instrucciones) {
            operaciones.Ejecucion(instruccion);

            if(iteraciones.isTerminoOperaciones()) {
                break;
            }

            System.out.println(instruccion);
        }

        return "salida";
    }

}
