package com.teamcoders.vista.fx.clientes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controlador del menú de gestión de clientes.
 *
 * Esta clase pertenece a la capa Vista del patrón MVC y gestiona la navegación
 * entre las diferentes funcionalidades del módulo de clientes: añadir cliente,
 * mostrar clientes, y volver a la vista de inicio.
 */
public class ClientesMenuController {

    /**
     * Navega a la vista para añadir un nuevo cliente.
     * 
     * Reemplaza el contenido actual de la escena por el definido en `clientes_anadir.fxml`,
     * manteniendo el `Stage` y su estado de maximización.
     *
     * @param event evento que dispara la acción, asociado a un botón en la interfaz.
     */
   @FXML
    private void anadirCliente(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/clientes/clientes_anadir.fxml"));
            Pane root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root); // Mantiene ventana maximizada
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Navega a la vista que muestra todos los clientes registrados.
     * 
     * Carga el archivo `clientes_mostrar.fxml` y lo establece como raíz de la escena actual.
     *
     * @param event evento que activa la acción desde el menú de clientes.
     */
    @FXML
    public void mostrarClientes(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/clientes/clientes_mostrar.fxml"));
            Pane root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Vuelve a la vista de inicio desde el menú de clientes.
     *
     * Esta acción se utiliza para regresar al punto de partida de la aplicación
     * sin cerrar la ventana ni modificar su tamaño.
     *
     * @param event evento de acción desde la interfaz gráfica.
     */
    @FXML
    public void volverInicio(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/inicio/inicio.fxml"));
            Pane root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
