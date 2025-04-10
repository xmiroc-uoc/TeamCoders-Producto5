package vista;

import java.util.Scanner;

public class EntradaUsuario {
    private static final Scanner inputScanner = new Scanner(System.in);

    // Leer texto libre
    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return inputScanner.nextLine();
    }

    // Leer entero sin validación de rango
    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.println(mensaje);
                return Integer.parseInt(inputScanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente con un número entero. ");
            }
        }
    }

    // Leer entero con rango
    public static int leerEnteroRango(String mensaje, int min, int max) {
        while (true) {
            int valor = leerEntero(mensaje);
            if (valor >= min && valor <= max) {
                return valor;
            } else {
                System.out.println("El número debe estar entre " + min + " y " + max + ".");
            }
        }
    }

    // Leer deciaml sin validación rango
    public static double leerDecimal(String mensaje) {
        while (true) {
            try {
                System.out.println(mensaje);
                return Double.parseDouble(inputScanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente con un número decimal.");
            }
        }
    }

    // Leer deciaml con rango
    public static double leerDecimalRango(String mensaje, double min, double max) {
        while (true) {
            double valor = leerDecimal(mensaje);
            if (valor >= min && valor <= max) {
                return valor;
            } else {
                System.out.println("El número debe estar entre " + min + " y " + max + ".");
            }
        }
    }

    // Confirmación tipo S/N u otra opción válida
    public static String leerConfirmacion(String mensaje, String... opcionesValidas) {
        while (true) {
            System.out.println(mensaje);
            String entrada = inputScanner.nextLine().trim().toUpperCase();
            for (String opcion : opcionesValidas) {
                if (entrada.equals(opcion)) {
                    return entrada;
                }
            }
            System.out.println("Opción no válida. Opciones permitidas: " + String.join("/", opcionesValidas));
        }
    }

    // Cerrar el Scanner al finalizar el programa
    public static void cerrarScanner() {
        inputScanner.close();
    }
}
