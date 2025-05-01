package com.producto4;

/**
 * Hello world!
 *
 */
/*public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}*/

import com.vista.EntradaUsuario;
import com.vista.MenuPrincipal;

public class App {

    public static void main(String[] args) {

        // Carga inicial de datos para pruebas
        // DatosIniciales.cargar();

        // Muestra el menú principal de la aplicación
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.mostrarMenuPrincipal();

        // Cierra el Scanner para liberar recursos
        EntradaUsuario.cerrarScanner();
    }
}
