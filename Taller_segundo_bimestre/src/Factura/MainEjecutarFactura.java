package Factura;

/**
 * @author ANDREA MENA y JHEYSON GAONA 
 */
public class MainEjecutarFactura {

    public static void main(String[] args) {
        CrearFactura factura = new CrearFactura();
        factura.abrir_archivo();
        factura.agregar_informacion();
        factura.cerrar_archivo();
    }

}
