import vista.EntradaUsuario;
import vista.MenuPrincipal;

public class Main {

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