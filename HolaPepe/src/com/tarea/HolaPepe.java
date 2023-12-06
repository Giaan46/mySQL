package com.tarea;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HolaPepe {

    public static void main(String[] args) {


        String contenidoFichero = "pepe";
        String nombreFichero = "fichero_pepe";

    try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nombreFichero))){
        bufferedWriter.write(contenidoFichero);
        System.out.println("Se escribio en el archivo correctamente ");
        }catch (IOException ioe){
        System.out.println("Error al escribir el archivo " + ioe.getMessage());
    }
}
}