package org.example.DeteccionColor;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArbolColores {
    File carpetaEntrenar;
    ObtenerImagen lector;
    HashMap<ColorRgb , ConteoColores> conteoImagen;
    public ArbolColores(String direImagenes){
        try {
            carpetaEntrenar = new File(direImagenes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void crearDatos(float erro){
        lector = new ObtenerImagen();
        boolean correcto = lector.obtenerImagenes(carpetaEntrenar.getPath());
        int ancho , alto;
        if(correcto){
            conteoImagen = new HashMap<>();
            ancho = lector.imagenReal.getWidth();
            alto = lector.imagenReal.getHeight();
            for(int y = 0 ; y < lector.imagenReal.getHeight();y++){
                for(int x = 0 ; x < lector.imagenReal.getWidth();x++){
                    int pixel = lector.imagenReal.getRGB(x,y);
                    int pixelSen = lector.imagenSeleccion.getRGB(x,y);
                    int azulSen = pixelSen & 0xff;
                    int rojo = (pixel >> 16) & 0xff;
                    int verde = (pixel >> 8) & 0xff;
                    int azul = pixel & 0xff;
                    ColorRgb color = new ColorRgb(rojo,verde,azul);
                    if(!conteoImagen.containsKey(color)){
                        conteoImagen.put(color , new ConteoColores());
                    }
                    if(azulSen > 120){
                        conteoImagen.get(color).sumaPosi(1);
                    }else{
                        conteoImagen.get(color).sumaNega(1);
                    }

                    //System.out.println("Pixel (" + x + "," + y + "): R=" + rojo + " G=" + verde + " B=" + azul);

                }
            }
            //Vale ya hemos cogido lo que necesitamos ahora vamos a quitar los piexeles random

            float totalPixelASuperar = ancho*alto*erro/100;
            List<ColorRgb> coloresAEliminar = new ArrayList<>();
            for(ColorRgb color : conteoImagen.keySet()){
                int p  = conteoImagen.get(color).getPositivo();
                int n  = conteoImagen.get(color).getNegativo();
                if(Math.abs(p-n) < totalPixelASuperar){
                    coloresAEliminar.add(color);
                }
            }
            for( ColorRgb color :  coloresAEliminar){
                conteoImagen.remove(color);
            }
            for(ColorRgb color : conteoImagen.keySet()){
                int p  = conteoImagen.get(color).getPositivo();
                int n  = conteoImagen.get(color).getNegativo();
                System.out.println(color.toHexa() +" -> "+conteoImagen.get(color));
            }
        }
    }
}
