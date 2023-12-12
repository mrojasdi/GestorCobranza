package view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class GestorCobranzaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;
        boolean autenticado = false;

        while (!salir) {
            if (!autenticado) {
                System.out.println("Bienvenido al Sistema de Gestión de Cobranza");
                System.out.println("1. Ingresar al sistema");
                System.out.println("2. Salir del sistema");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine();  // Consumir la nueva línea después de la entrada numérica

                switch (opcion) {
                    case 1:
                        autenticado = ingresarAlSistema(scanner);
                        if (autenticado) {
                            opcionesDespuesDeAutenticacion(scanner);
                        }
                        break;
                    case 2:
                        salir = true;
                        System.out.println("Saliendo del sistema. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                        break;
                }
            } else {
                opcionesDespuesDeAutenticacion(scanner);
            }
        }

        scanner.close();
    }

    private static boolean ingresarAlSistema(Scanner scanner) {
        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        // Lógica para autenticar al usuario basado en el archivo CSV
        boolean autenticado = autenticarDesdeCSV(usuario, contrasena);

        if (!autenticado) {
            System.out.println("Autenticación fallida. Regresando al menú principal.");
        } else {
            System.out.println("Autenticación exitosa. Puedes comenzar a utilizar el sistema.");
        }

        return autenticado;
    }

    private static boolean autenticarDesdeCSV(String usuario, String contrasena) {
        // Lógica para leer el archivo CSV y autenticar al usuario
        // Aquí debes implementar la lectura del archivo CSV y la comparación de usuarios y contraseñas.
        // Puedes usar bibliotecas como OpenCSV para facilitar la lectura del archivo.

        // Ejemplo básico de autenticación:
        // Supongamos que el archivo CSV tiene el formato "usuario,contrasena"
        String rutaArchivoCSV = "C:\\Users\\mroja\\eclipse-jee-workspace\\GestorCobranza\\usuarios.csv";  // Reemplaza con la ruta real de tu archivo CSV

        // Aquí deberías leer el archivo CSV, comparar los datos y devolver true si la autenticación es exitosa.
        // Por ahora, simplemente devolvemos true para el ejemplo.
        return true;
    }

    private static void opcionesDespuesDeAutenticacion(Scanner scanner) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\nOpciones disponibles:");
            System.out.println("1. Ver lista de Promesas de Pago vencidas");
            System.out.println("2. Registrar Nueva Promesa");
            System.out.println("3. Salir del Sistema");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea después de la entrada numérica

            switch (opcion) {
                case 1:
                    mostrarPromesasVencidas();
                    break;
                case 2:
                    // Menú para registrar una nueva promesa de pago
                    registrarNuevaPromesa(scanner);
                    break;
                case 3:
                    salir = true;
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
    }

    private static void mostrarPromesasVencidas() {
        String rutaArchivoVencidas = "C:\\Users\\mroja\\eclipse-jee-workspace\\GestorCobranza\\CarteraPTPvencidas.csv";  // Reemplaza con la ruta real del archivo CSV de promesas vencidas

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoVencidas))) {
            System.out.println("\nLista de Promesas de Pago Vencidas:");

            String linea;
            while ((linea = br.readLine()) != null) {
                // Supongamos que el formato del archivo CSV de promesas vencidas es "cliente,fecha,cantidad"
                String[] partes = linea.split(",");
                String cliente = partes[0];
                String fecha = partes[1];
                String cantidad = partes[2];

                System.out.println("Cliente: " + cliente + ", Fecha: " + fecha + ", Cantidad: " + cantidad);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de promesas vencidas: " + e.getMessage());
        }
    }

    private static void registrarNuevaPromesa(Scanner scanner) {
        String cliente;
        String fecha;
        String cantidad;

        System.out.print("Ingrese el nombre del cliente: ");
        cliente = scanner.nextLine();

        System.out.print("Ingrese la nueva fecha de pago: ");
        fecha = scanner.nextLine();

        System.out.print("Ingrese la cantidad a pagar: ");
        cantidad = scanner.nextLine();

        // Aquí puedes realizar validaciones adicionales si es necesario

        // Lógica para escribir la nueva promesa en el archivo CSV
        escribirNuevaPromesaEnCSV(cliente, fecha, cantidad);
    }

    private static void escribirNuevaPromesaEnCSV(String cliente, String fecha, String cantidad) {
        String rutaArchivoCSV = "C:\\Users\\mroja\\eclipse-jee-workspace\\GestorCobranza\\PTPnuevas.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivoCSV, true))) {
            // Formato del archivo CSV: "cliente,fecha,cantidad"
            bw.write(cliente + "," + fecha + "," + cantidad);
            bw.newLine();
            System.out.println("Nueva promesa de pago registrada con éxito.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
}
