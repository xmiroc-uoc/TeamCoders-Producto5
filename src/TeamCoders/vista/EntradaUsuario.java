package vista;

import java.util.Scanner;

/**
 * Clase utilitaria encargada de gestionar las entradas por teclado del usuario.
 * Ofrece métodos estáticos para leer textos, números y confirmar opciones.
 */
public class EntradaUsuario {
    // Scanner estático compartido por todos los métodos para capturar entrada del usuario
    private static final Scanner inputScanner = new Scanner(System.in);

    /**
     * Solicita al usuario una cadena de texto.
     * @param mensaje Mensaje mostrado al usuario.
     * @return Texto introducido por el usuario.
     */
    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return inputScanner.nextLine();
    }

    /**
     * Solicita al usuario un número entero.
     * @param mensaje Mensaje mostrado al usuario.
     * @return Número entero introducido por el usuario.
     */
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

    /**
     * Solicita al usuario un número entero dentro de un rango definido.
     * @param mensaje Mensaje mostrado al usuario.
     * @param min Valor mínimo aceptado.
     * @param max Valor máximo aceptado.
     * @return Número entero dentro del rango.
     */
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

    /**
     * Solicita al usuario un número decimal.
     * @param mensaje Mensaje mostrado al usuario.
     * @return Número decimal introducido por el usuario.
     */
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

    /**
     * Solicita al usuario un número decimal dentro de un rango definido.
     * @param mensaje Mensaje mostrado al usuario.
     * @param min Valor mínimo aceptado.
     * @param max Valor máximo aceptado.
     * @return Número decimal dentro del rango.
     */
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

    /**
     * Solicita una confirmación textual entre opciones válidas.
     * @param mensaje Mensaje mostrado al usuario.
     * @param opcionesValidas Opciones que se consideran válidas.
     * @return Opción elegida por el usuario.
     */
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

    /**
     * Cierra el Scanner utilizado para la entrada de datos.
     * Debe llamarse al finalizar el programa.
     */
    public static void cerrarScanner() {
        inputScanner.close();
    }
}
