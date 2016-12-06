package EdadEstudiantes;

/**
 * @author SALAS
 */
public class MainEjecutarEdadEstudiantes {

    public static void main(String[] args) {
        LecturaArchivos aplicacion = new LecturaArchivos();
        aplicacion.abrirArchivo();
        aplicacion.leer_informacion();
        aplicacion.cerrarArchivo();
    }
}
