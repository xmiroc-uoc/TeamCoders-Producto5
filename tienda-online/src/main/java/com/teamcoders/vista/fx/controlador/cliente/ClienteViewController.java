package com.teamcoders.vista.fx.controlador.cliente;

import com.teamcoders.controlador.ClienteControlador;
import com.teamcoders.modelo.Cliente;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ClienteViewController {

  @FXML
  private TableView<Cliente> tabla;

  @FXML
  private void initialize() {
    cargarTodos();
  }

  @FXML
  private void cargarTodos() {
    tabla.setItems(FXCollections.observableArrayList(
        ClienteControlador.obtenerClientes()));
  }

  @FXML
  private void cargarEstandar() {
    tabla.setItems(FXCollections.observableArrayList(
        ClienteControlador.obtenerClientesEstandar()));
  }

  @FXML
  private void cargarPremium() {
    tabla.setItems(FXCollections.observableArrayList(
        ClienteControlador.obtenerClientesPremium()));
  }

  @FXML
  private void volver() {
    try {
      Parent root = FXMLLoader.load(
          getClass().getResource("/com/teamcoders/vista/fx/inicio.fxml"));
      Stage stage = (Stage) tabla.getScene().getWindow();
      stage.setTitle("Tienda Online");
      stage.setScene(new Scene(root));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
