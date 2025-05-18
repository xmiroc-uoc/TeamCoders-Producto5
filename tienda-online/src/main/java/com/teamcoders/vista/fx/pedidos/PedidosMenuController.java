package com.teamcoders.vista.fx.pedidos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controlador del menú principal del módulo de pedidos.
 * 
 * Esta clase permite navegar entre las distintas funcionalidades disponibles para
 * la gestión de pedidos: añadir un nuevo pedido, mostrar los pedidos existentes
 * o volver a la vista de inicio.
 *
 * Pertenece a la capa Vista del patrón de diseño MVC.
 */
public class PedidosMenuController {

    /**
     * Acción asociada al botón "Añadir Pedido".
     * 
     * Carga la vista `pedidos_anadir.fxml` en el `Stage` actual, permitiendo
     * registrar un nuevo pedido.
     * 
     * @param event evento de acción generado al pulsar el botón correspondiente.
     */
   @FXML
    private void anadirPedido(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/pedidos/pedidos_anadir.fxml"));
            Pane root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Acción asociada al botón "Mostrar Pedidos".
     * 
     * Carga la vista `pedidos_mostrar.fxml`, que contiene una tabla con los pedidos
     * almacenados en el sistema. El contenido de la escena es reemplazado sin alterar
     * el estado de la ventana.
     * 
     * @param event evento generado por el usuario.
     */
    @FXML
    public void mostrarPedidos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/pedidos/pedidos_mostrar.fxml"));
            Pane root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Acción asociada al botón "Eliminar Pedido".
     * 
     * Carga la vista `pedidos_eliminar.fxml`, que contiene una tabla con los pedidos
     * almacenados en el sistema. El contenido de la escena es reemplazado sin alterar
     * el estado de la ventana.
     * 
     * @param event evento generado por el usuario.
     */
    @FXML
    public void eliminarPedido(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/pedidos/pedidos_eliminar.fxml"));
            Pane root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Acción asociada al botón "Volver".
     * 
     * Permite regresar a la vista de inicio de la aplicación desde el menú
     * de pedidos, sin cerrar la ventana principal ni modificar su tamaño.
     * 
     * @param event evento generado por el usuario al pulsar el botón.
     */
    @FXML
    public void volverInicio(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/inicio/inicio.fxml"));
            Pane root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root); // Cambia solo el contenido de la escena, manteniendo maximización
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
