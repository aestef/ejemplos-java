package Paises;

/**
 * @author ANDREA MENA y JHEYSON GAONA 
 */
public class MainEjecutarPaises{
   public static void main( String args[] ){
      LecturaArchivos aplicacion = new LecturaArchivos();

      aplicacion.abrirArchivo();
      aplicacion.leer_informacion();
      aplicacion.cerrarArchivo();
   } // fin de main
}