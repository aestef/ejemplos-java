package EdadEstudiantes;

/**
 * @author SALAS
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class LecturaArchivos {

    private Scanner entrada;

    // permite al usuario abrir el archivo
    public void abrirArchivo() {
        try {
            entrada = new Scanner(new File("estudiantes.txt"));
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
            CrearArchivos c = new CrearArchivos();
            c.abrir_archivo();
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                //System.out.println(linea);
                ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split("\\|")));
                //System.out.println(linea_partes);
                int edadNac = Integer.parseInt(linea_partes.get(2));
                int anioActual = 2016;
                int edadActual = anioActual - edadNac;
                System.out.printf("%s|%s|%d\n", linea_partes.get(0), linea_partes.get(1), edadActual);
                c.agregar_informacion(linea_partes.get(0), linea_partes.get(1), edadActual);
            } // fin de while
            c.cerrar_archivo();
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
}