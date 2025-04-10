
package TeamCoders.controlador;

import TeamCoders.modelo.Articulo;
import TeamCoders.vista.ArticuloView;

import java.util.ArrayList;

public class ArticuloController {

    private ArrayList<Articulo> listaArticulos;
    private ArticuloView vista;

    public ArticuloController() {
        listaArticulos = new ArrayList<>();
        vista = new ArticuloView();
    }

    public void gestionarArticulos() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            switch (opcion) {
                case 1:
                    Articulo articulo = vista.pedirDatosArticulo();
                    listaArticulos.add(articulo);
                    vista.mostrarMensaje("Articulo añadido correctamente.");
                    break;
                case 2:
                    vista.mostrarArticulos(listaArticulos);
                    break;
                case 0:
                    vista.mostrarMensaje("Volviendo al menú principal...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
