package Factura;

/**
 * @author SALAS
 */
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CrearFactura {

    private Formatter salida; // objeto usado para enviar texto al archivo

    // permite al usuario abrir el archivo
    public void abrir_archivo() {
        try {
            salida = new Formatter("Factura.txt");
        } // fin de try
        catch (SecurityException securityException) {
            System.err.println(
                    "No tiene acceso de escritura a este archivo.");
            System.exit(1);
        } // fin de catch
        catch (FileNotFoundException filesNotFoundException) {
            System.err.println("Error al crear el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrir_archivo

    // agrega registros al archivo
    public void agregar_informacion() {
        Scanner entrada = new Scanner(System.in);
        //DECLARACION DE VARIABLES
        boolean otro = true;
        int opcion = 0;
        int cant = 0;
        String producto = " ";
        double precio = 0;
        double subtotal = 0;
        double iva;
        double total;

        try // envía valores al archivo
        {
            // Ingreso de datos de la factura
            System.out.println("Ingrese el nombre del cliente");
            String nombre = entrada.nextLine();
            System.out.println("Ingrese la ciudad");
            String ciudad = entrada.next();

            salida.format("\tComercial Ventas y Reventas\n"
                    + "----------------------------------------\n"
                    + "\nNombre: %s\nCiudad: %s\n"
                    + "----------------------------------------\n"
                    + "Producto\t\tCant\t\tPrecio\n", nombre, ciudad);

            while (otro) {  //Mientras se ingrese otro producto
                System.out.println("========== MENÚ DE COMPRAS  ==========");
                System.out.println(" [1] Arroz    ->  costo del kilo $2.50 ");
                System.out.println(" [2] Azucar   ->  costo del kilo $1.50 ");
                System.out.println(" [3] Aceite   ->  costo $1.30 por unidad ");
                System.out.println(" [4] Tallarines -> costo $1.50 por unidad");
                System.out.println(" [5] Sal    ->    costo del kilo  $1.00 ");
                System.out.println("** **************************** **");
                //Pide producto y cantidad
                System.out.println("Ingrese la opcion del producto");
                opcion = entrada.nextInt();
                System.out.println("Ingrese la cantidad de su producto");
                cant = entrada.nextInt();

                switch (opcion) {
                    case 1:
                        producto = "Arroz\t";
                        precio = 2.50 * cant;
                        break;
                    case 2:
                        producto = "Azucar\t";
                        precio = 1.50 * cant;
                        break;
                    case 3:
                        producto = "Aceite\t";
                        precio = 1.30 * cant;
                        break;
                    case 4:
                        producto = "Tallarines\t";
                        precio = 1.50 * cant;
                        break;
                    case 5:
                        producto = "Sal\t";
                        precio = 1.0 * cant;
                        break;
                }
                salida.format("%s\t\t %d\t\t %.2f\n", producto, cant, precio);

                subtotal = subtotal + precio;

                System.out.println("Desea ingresar más productos SI[1], NO[0]");
                int continuar = entrada.nextInt();
                if (continuar == 0) {
                    otro = false;
                }

            }
            iva = subtotal * 0.14;
            total = iva + subtotal;

            salida.format("----------------------------------------\n"
                    + "\t\t\tSubtotal: \t%.2f\n"
                    + "\t\t\tIVA:  \t%.2f\n" 
                    + "\t\t\tTOTAL:  \t%.2f\n", subtotal, iva, total);

        } // fin de try // fin de try // fin de try // fin de try // fin de try // fin de try // fin de try // fin de try
        catch (FormatterClosedException formatterClosedException) {
            System.err.println("Error al escribir en el archivo.");
            return;
        } // fin de catch
        catch (NoSuchElementException elementException) {
            System.err.println("Entrada invalida. Intente de nuevo.");
            entrada.nextLine(); // descarta la entrada para que el usuario intente de nuevo
        } // fin de catch

        // fin de while
    } // fin del método agregarRegistros

    // cierra el arrchivo
    public void cerrar_archivo() {
        if (salida != null) {
            salida.close();
        }
    } // fin del método cerrarArchivo
} // fin de la clase ArchivoTexto
