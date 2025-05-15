package com.teamcoders.vista.fx.clientes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientesController {

    @FXML
    public void anadirCliente(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Clientes");
        alert.setHeaderText(null);
        alert.setContentText("Aquí se añadira un cliente.");
        alert.showAndWait();
    }

    @FXML
    public void mostrarTodosLosClientes(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/clientes/clientes_mostrarTodos.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("Mostrar Todos los Clientes");
        stage.setScene(scene);
        stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void mostrarClientesEstandar(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Clientes");
        alert.setHeaderText(null);
        alert.setContentText("Aquí se mostrarán todos los clientes estándar.");
        alert.showAndWait();
    }

    @FXML
    public void mostrarClientesPremium(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Clientes");
        alert.setHeaderText(null);
        alert.setContentText("Aquí se mostrarán todos los clientes premium.");
        alert.showAndWait();
    }

    @FXML
    public void volverInicio(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/inicio/inicio.fxml"));
            Pane root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
