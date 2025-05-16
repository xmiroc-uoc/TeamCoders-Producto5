package com.teamcoders.utils;

import java.util.Scanner;

/**
 * Clase auxiliar para gestionar la entrada de datos del usuario desde consola
 * y validar datos introducidos desde interfaces gráficas (JavaFX).
 */
public class EntradaUsuario {
    // Scanner estático compartido por todos los métodos para capturar entrada del
    // usuario
    private static final Scanner inputScanner = new Scanner(System.in);

    /**
     * Solicita al usuario una cadena de texto desde consola.
     * 
     * @param mensaje Mensaje mostrado al usuario.
     * @return Texto introducido por el usuario.
     */
    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return inputScanner.nextLine();
    }

    /**
     * Solicita al usuario un número entero desde consola.
     * 
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
     * 
     * @param mensaje Mensaje mostrado al usuario.
     * @param min     Valor mínimo aceptado.
     * @param max     Valor máximo aceptado.
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
     * 
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
     * 
     * @param mensaje Mensaje mostrado al usuario.
     * @param min     Valor mínimo aceptado.
     * @param max     Valor máximo aceptado.
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
     * 
     * @param mensaje         Mensaje mostrado al usuario.
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

    // ------------- Métodos para validación desde JavaFX -------------

    /**
     * Valida que un texto no esté vacío.
     *
     * @param valor Texto a validar.
     * @param campo Nombre del campo (para mostrar en el mensaje de error).
     * @return El texto validado sin espacios iniciales ni finales.
     * @throws IllegalArgumentException si el valor es nulo o está vacío.
     */
    public static String validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo '" + campo + "' no puede estar vacío.");
        }
        return valor.trim();
    }

    /**
     * Valida que el texto introducido sea un email con formato válido.
     *
     * @param valor Texto a validar.
     * @return El email validado sin espacios.
     * @throws IllegalArgumentException si el email no tiene un formato válido.
     */
    public static String validarEmail(String valor) {
        if (valor == null || !valor.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("El email introducido no es válido.");
        }
        return valor.trim();
    }

    /**
     * Valida que el texto introducido se pueda convertir en un número entero.
     *
     * @param valor Texto a validar.
     * @param campo Nombre del campo (para mostrar en el mensaje de error).
     * @return El número entero equivalente al texto introducido.
     * @throws IllegalArgumentException si el valor no es un número entero válido.
     */
    public static int validarEntero(String valor, String campo) {
        try {
            return Integer.parseInt(valor.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("El campo '" + campo + "' debe ser un número entero válido.");
        }
    }

    /**
     * Valida que el texto introducido se pueda convertir en un número decimal.
     *
     * @param valor Texto a validar.
     * @param campo Nombre del campo (para mostrar en el mensaje de error).
     * @return El número decimal equivalente al texto introducido.
     * @throws IllegalArgumentException si el valor no es un número válido.
     */
    public static double validarDouble(String valor, String campo) {
        try {
            return Double.parseDouble(valor.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("El campo '" + campo + "' debe ser un número válido.");
        }
    }
}
