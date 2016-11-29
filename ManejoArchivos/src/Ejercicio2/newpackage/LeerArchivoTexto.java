package Ejercicio2.newpackage;

// Ejemplo tomado del libro 
// D EITEL , P AUL J. Y H ARVEY M. D EITEL
// CÓMO PROGRAMAR EN J AVA . Séptima edición
// fines educativos
// Prueba de la clase ArchivoTexto.
// Este programa lee un archivo de texto y muestra cada registro.
import lecturaArchivos.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

public class LeerArchivoTexto {

    private Scanner entrada;

    // permite al usuario abrir el archivo
    public void abrirArchivo() {
        try {
            entrada = new Scanner(new File("calificaciones.txt"));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrirArchivo

    // lee registro del archivo
    public void leer_informacion() {

        try // lee registros del archivo, usando el objeto Scanner
        {
            double suma = 0;
            double promedio = 0;
            String nombre = " ";
            
            double media[] = new double[4];
            int cont = 0;
            double mayor = 0;
            System.out.println("\n-----INFORMACION DE CALIFICACIONES-----\n");
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                //System.out.println(linea);
                ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split(";")));
                //System.out.println(linea_partes);
                
                for (int i = 2; i < (linea_partes.size() - 1); i++) {
                    cont = 0;
                    media[cont] = 0;
                    nombre = linea_partes.get(0);
                    media[cont] = (media[cont] + Double.parseDouble(linea_partes.get(i)) + Double.parseDouble(linea_partes.get(i + 1))) / 2;
                    suma = media[cont] + suma;
                    System.out.printf("%s tiene de promedio: %.2f\n", nombre, media[cont]);
                    if (media[cont] > mayor) {
                        mayor = media[cont];
                    }
                    cont = cont + 1;
                }

            } // fin de while
            promedio = suma / 4;
            System.out.printf("________________________________\nEl promedio general es: %.2f\n", promedio);
            System.out.printf("El promedio mayor es: %.2f\n________________________________\n", mayor);
        } // fin de try
        catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del metodo leerRegistros
    // cierra el archivo y termina la aplicación

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del metodo cerrarArchivo
} // fin de la clase LeerArchivoTexto

