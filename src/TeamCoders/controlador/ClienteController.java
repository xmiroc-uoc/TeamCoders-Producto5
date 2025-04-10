
package TeamCoders.controlador;

import TeamCoders.modelo.Cliente;
import TeamCoders.vista.ClienteView;

import java.util.ArrayList;

public class ClienteController {

    private ArrayList<Cliente> listaClientes;
    private ClienteView vista;

    public ClienteController() {
        listaClientes = new ArrayList<>();
        vista = new ClienteView();
    }

    public void gestionarClientes() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            switch (opcion) {
                case 1:
                    Cliente cliente = vista.pedirDatosCliente();
                    listaClientes.add(cliente);
                    vista.mostrarMensaje("Cliente añadido correctamente.");
                    break;
                case 2:
                    vista.mostrarClientes(listaClientes);
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
