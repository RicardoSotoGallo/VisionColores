package org.example;

import org.example.DeteccionColor.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        Vamos a reacer la vision
        Para ello esto lo vamos a trasformar en una libreria
        Necesito hacer varias cosas
        1.- leer el codigo de gradiente
        2.- rehacer la logica fuzzy
        Ahora quiero que por cada color apunte los 0 y los 1 de cada color y apunte cuantas veces aparece
        Para buscar en la logica fuzzy vamos a coger todos los colores que aparecen como 1 o como 0
        Nos vamos a apuntar los cambios y lo vamos a poner en un arbol de decisiones.
        Siendo los primeros intervalos los valores mas aparecidos.

        Luego entrenaremos el perceptron. Pero creo que el perceptron no hara falta la verdad pero lo entrenaremos igualmente
        3.- crear el arbol de decisiones
        4.- comprobar que el percetron este bien
        5.- miramos como funciona una libreria

         */


        /*arbol.obtenerTodaRaizes(0f);
        BufferedImage entrada;
        try {
            File archivo = new File("src/ImagenEntrenamiento/Frieren/Imagen/img.png");
            entrada = ImageIO.read(archivo);
            //arbol.analizarUnaSeleccion(entrada , "src/ImagenEntrenamiento/Frieren/Ficheros" , "DosColores");
            arbol.analizarTodoSeleccion(entrada , "src/ImagenEntrenamiento/Frieren/Ficheros");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        arbol.guardarDatos();*/
        ArbolColores arbol = new ArbolColores("src/ImagenEntrenamiento/Wikipedia");
        arbol.obtenerTodaRaizes(0);
        arbol.guardarDatos();
        //arbol.obtenerDatos();

        //arbol.diccionarioRaices.get("Rosa").showArbol("");

        BufferedImage entrada;
        try {
            File archivo = new File("src/ImagenEntrenamiento/Wikipedia/Ficheros/imgTest.png");
            entrada = ImageIO.read(archivo);
            //arbol.analizarUnaSeleccion(entrada , "src/ImagenEntrenamiento/Frieren/Ficheros" , "DosColores");
            arbol.analizarTodoSeleccion(entrada , "src/ImagenEntrenamiento/Wikipedia/Ficheros");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}