package com.teamcoders.vista.fx.inicio;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/clientes/clientes.fxml"));
            Pane root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
