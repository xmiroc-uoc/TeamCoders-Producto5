package com.teamcoders.vista.fx.controlador.cliente;

import com.teamcoders.controlador.ClienteControlador;
import com.teamcoders.modelo.Cliente;
import com.teamcoders.modelo.ClienteEstandar;
import com.teamcoders.modelo.ClientePremium;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
// ------------------------  IMPORTS  ------------------------
import javafx.beans.property.SimpleStringProperty; //  ★  <- añade esto
// (el resto de imports ya los tienes)

public class ClienteViewController {

  @FXML
  private TableView<Cliente> tabla;

  @FXML
  private TableColumn<Cliente, String> colEmail;
  @FXML
  private TableColumn<Cliente, String> colNombre;
  @FXML
  private TableColumn<Cliente, String> colDomicilio;
  @FXML
  private TableColumn<Cliente, String> colNif;
  @FXML
  private TableColumn<Cliente, String> colTipo;

  @FXML
  private void initialize() {
    colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    colDomicilio.setCellValueFactory(new PropertyValueFactory<>("domicilio"));
    colNif.setCellValueFactory(new PropertyValueFactory<>("nif"));
    colTipo.setCellValueFactory(cellData -> {
      if (cellData.getValue() instanceof ClienteEstandar) {
        return new SimpleStringProperty("Estandar");
      }
      if (cellData.getValue() instanceof ClientePremium) {
        return new SimpleStringProperty("Premium");
      }
      return new SimpleStringProperty("Desconocido");
    });

    cargarTodos();
  }

  @FXML
  private void cargarTodos() {
    tabla.setItems(FXCollections.observableArrayList(ClienteControlador.obtenerClientes()));
  }

  @FXML
  private void cargarEstandar() {
    tabla.setItems(FXCollections.observableArrayList(ClienteControlador.obtenerClientesEstandar()));
  }

  @FXML
  private void cargarPremium() {
    tabla.setItems(FXCollections.observableArrayList(ClienteControlador.obtenerClientesPremium()));
  }

  @FXML
  private void volver() {
    try {
      Parent root = FXMLLoader.load(getClass().getResource("/com/teamcoders/vista/fx/inicio.fxml"));
      Stage stage = (Stage) tabla.getScene().getWindow();
      stage.setTitle("Tienda Online");
      stage.setScene(new Scene(root));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
