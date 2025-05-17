package com.teamcoders.vista.fx.inicio;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InicioController {
    @FXML
    private void onGestionClientes(ActionEvent event) {
        mostrarMensaje("Gestión de Clientes no implementada todavía.");
    }

    @FXML
    private void onGestionArticulos(ActionEvent event) {
        mostrarMensaje("Gestión de Artículos no implementada todavía.");
    }

    @FXML
    private void onGestionPedidos(ActionEvent event) {
        mostrarMensaje("Gestión de Pedidos no implementada todavía.");
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Función no disponible");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    public void irAGestionClientes(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/clientes/clientes_menu.fxml"));
            Pane root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root); // Cambia solo el contenido de la escena, manteniendo maximización
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void irAGestionArticulos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/articulos/articulos_menu.fxml"));
            Pane root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root); // Cambia solo el contenido de la escena, manteniendo maximización
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void irAGestionPedidos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/pedidos/pedidos_menu.fxml"));
            Pane root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root); // Cambia solo el contenido de la escena, manteniendo maximización
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
