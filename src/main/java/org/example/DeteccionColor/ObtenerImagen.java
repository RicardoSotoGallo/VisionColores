package org.example.DeteccionColor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;

public class ObtenerImagen {
    BufferedImage imagenReal;
    BufferedImage imagenSeleccion;
    public boolean obtenerImagenes(String direFichero){
        boolean res = false;
        try {
            File carpetaImagenes = new File(direFichero+"/Imagen");
            File carpetaRecorte = new File(direFichero+"/Seleccion");
            if(carpetaRecorte.exists() && carpetaImagenes.exists() && carpetaRecorte.isDirectory() && carpetaImagenes.isDirectory() &&
                Objects.requireNonNull(carpetaImagenes.listFiles()).length > 0 && Objects.requireNonNull(carpetaRecorte.listFiles()).length > 0){
                File direIm = Objects.requireNonNull(carpetaImagenes.listFiles())[0];
                File direRec = Objects.requireNonNull(carpetaRecorte.listFiles())[0];

                imagenReal = ImageIO.read(direIm);
                imagenSeleccion = ImageIO.read(direRec);
                res = true;

            }else{
                System.out.println("No existe la carpeta necesarias");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;

    }
}
