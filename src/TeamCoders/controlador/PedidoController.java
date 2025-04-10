
package TeamCoders.controlador;

import TeamCoders.modelo.Pedido;
import TeamCoders.vista.PedidoView;

import java.util.ArrayList;

public class PedidoController {

    private ArrayList<Pedido> listaPedidos;
    private PedidoView vista;

    public PedidoController() {
        listaPedidos = new ArrayList<>();
        vista = new PedidoView();
    }

    public void gestionarPedidos() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            switch (opcion) {
                case 1:
                    Pedido pedido = vista.pedirDatosPedido();
                    listaPedidos.add(pedido);
                    vista.mostrarMensaje("Pedido añadido correctamente.");
                    break;
                case 2:
                    vista.mostrarPedidos(listaPedidos);
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
