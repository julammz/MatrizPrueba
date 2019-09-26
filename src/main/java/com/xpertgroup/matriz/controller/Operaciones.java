package com.xpertgroup.matriz.controller;


import com.xpertgroup.matriz.model.EstructuraMatriz;
import com.xpertgroup.matriz.model.Iteraciones;
import com.xpertgroup.matriz.model.Matriz;
import com.xpertgroup.matriz.model.Resultados;

public class Operaciones {

    private Iteraciones iteraciones;
    private Matriz matriz;
    private Resultados resultadoMatriz;
    private EstructuraMatriz estructuraMatriz;
    private int operacionesEjecutadas = 1;
    private int iteracionesEjecutadas = 1;



    public Operaciones(Iteraciones iteraciones, EstructuraMatriz estructuraMatriz, Matriz matriz, Resultados resultadoMatriz) {
        this.iteraciones = iteraciones;
        this.estructuraMatriz = estructuraMatriz;
        this.matriz = matriz;
        this.resultadoMatriz = resultadoMatriz;
    }

    public void Ejecucion(String entrada){

        int opcion;
        int resultadoTemp;
        int iteracionesTemp = 0;
        String textoTemp = "";

        int[] parametros = this.procesarEntrada(entrada);

        opcion = parametros.length;
        System.out.println("Opcion que ejecuta: " + opcion);


        if(iteraciones.getIteraciones()==0){
            iteraciones.setIteraciones(parametros[0]);
            System.out.println("Iteraciones: " + parametros[0]);
            return;
        }
        else if(this.iteracionesEjecutadas>this.iteraciones.getIteraciones()&&this.iteraciones.getIteraciones()!=0) {
            this.iteraciones.setTerminoOperaciones(true);
            return;
        }
        else if(this.operacionesEjecutadas>this.estructuraMatriz.getOperaciones()&&this.estructuraMatriz.getOperaciones()!=0&&opcion!=2) {
            System.out.println("Terminaron las operaciones");
            this.iteracionesEjecutadas++;
            this.operacionesEjecutadas=0;
            return;
        }


        switch(opcion){
            case 2:
                this.matriz = new Matriz(parametros[0]);
                this.matriz.iniciarMatriz(parametros[0]);
                this.estructuraMatriz.setOperaciones(parametros[1]);
                System.out.println("Se crea matriz:" + parametros[0] + " " + parametros[1]);
                break;

            case 4:
                this.UpdateMatriz(this.matriz, parametros[0],parametros[1],parametros[2],parametros[3]);
                System.out.println("Actualizacion matriz:" + parametros[0] + " " + parametros[1] + " " + parametros[2] + " " + parametros[3]);
                this.operacionesEjecutadas++;
                break;

            case 6:
                resultadoTemp = this.QueryMatriz(this.matriz, parametros[0],parametros[1],parametros[2],parametros[3],parametros[4],parametros[5]);
                textoTemp = this.resultadoMatriz.getResultado() + " <br> " + resultadoTemp;
                this.resultadoMatriz.setResultado(textoTemp);
                this.operacionesEjecutadas++;
                System.out.println("Ejecuta consulta matriz:" + parametros[0] + " " + parametros[1] + " " + parametros[2] + " " + parametros[3] + " " + parametros[4] + " " + parametros[5]);
                break;
        }

    }

    private void UpdateMatriz(Matriz matriz, int m, int n, int o, int valor){
        m--;
        n--;
        o--;

        matriz.setMatriz(m, n, o, valor);
    }

    private int QueryMatriz(Matriz matriz, int posInim, int posInin, int posInio, int posFinm, int posFinn, int posFino){

        int resultado = 0;
        posInim--;
        posInin--;
        posInio--;

        for(int i=posInim;i<posFinm;i++){
            for(int j=posInin;j<posFinn;j++){
                for(int k=posInio;k<posFino;k++){
                    resultado+= matriz.getValorMatriz(i,j,k);
                }
            }
        }

        return resultado;
    }


    private int[] procesarEntrada(String entrada){

        int[] resultado = null;
        String arr[]=entrada.split(" ");

        if(arr.length==1 && iteraciones.getIteraciones()==0){
            resultado = new int[1];
            resultado[0] = Integer.parseInt(arr[0]);
        }
        else if(arr.length==2 && iteraciones.getIteraciones()!=0){
            resultado = new int[2];
            resultado[0] = Integer.parseInt(arr[0]);
            resultado[1] = Integer.parseInt(arr[1]);
        }
        else if(arr[0].equals("UPDATE")){
            resultado = new int[4];
            resultado[0] = Integer.parseInt(arr[1]);
            resultado[1] = Integer.parseInt(arr[2]);
            resultado[2] = Integer.parseInt(arr[3]);
            resultado[3] = Integer.parseInt(arr[4]);
        }
        else if(arr[0].equals("QUERY")){
            resultado = new int[6];
            resultado[0] = Integer.parseInt(arr[1]);
            resultado[1] = Integer.parseInt(arr[2]);
            resultado[2] = Integer.parseInt(arr[3]);
            resultado[3] = Integer.parseInt(arr[4]);
            resultado[4] = Integer.parseInt(arr[5]);
            resultado[5] = Integer.parseInt(arr[6]);
        }

        return resultado;
    }

}

