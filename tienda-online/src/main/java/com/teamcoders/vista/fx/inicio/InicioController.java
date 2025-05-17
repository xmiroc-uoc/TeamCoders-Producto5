package com.teamcoders.vista.fx.inicio;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Controlador correspondiente a la vista inicial de la aplicación.
 * 
 * Gestiona la navegación hacia los distintos módulos principales:
 * clientes, artículos y pedidos. Forma parte de la capa Vista en la
 * arquitectura basada en el patrón MVC.
 * 
 * Proporciona también un mecanismo para mostrar mensajes informativos
 * si alguna funcionalidad no está habilitada.
 */
public class InicioController {

    /**
     * Navega hacia el menú de gestión de clientes reemplazando el contenido
     * actual de la escena sin alterar el estado del Stage.
     *
     * @param event evento que dispara la navegación.
     */
    @FXML
    public void irAGestionClientes(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/clientes/clientes_menu.fxml"));
            Pane root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root); // Mantiene ventana maximizada
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Navega hacia el menú de gestión de artículos.
     *
     * @param event evento que dispara la navegación.
     */
    @FXML
    public void irAGestionArticulos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/articulos/articulos_menu.fxml"));
            Pane root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Navega hacia el menú de gestión de pedidos.
     *
     * @param event evento que dispara la navegación.
     */
    @FXML
    public void irAGestionPedidos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/pedidos/pedidos_menu.fxml"));
            Pane root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
