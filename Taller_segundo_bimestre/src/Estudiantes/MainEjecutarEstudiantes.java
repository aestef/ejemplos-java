package Estudiantes;

/**
 * @author ANDREA MENA y JHEYSON GAONA 
 */
public class MainEjecutarEstudiantes {

    public static void main(String[] args) {
        LecturaArchivos aplicacion = new LecturaArchivos();

        aplicacion.abrirArchivo();
        aplicacion.leer_informacion();
        aplicacion.cerrarArchivo();
    }
}
