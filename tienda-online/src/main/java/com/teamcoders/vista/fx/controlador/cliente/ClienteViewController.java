package com.teamcoders.vista.fx.controlador.cliente;

import com.teamcoders.controlador.ClienteControlador;
import com.teamcoders.modelo.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.util.Optional;

public class ClienteViewController {

  /* ---------- FXML ---------- */
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

  /* ---------- INIT ---------- */
  @FXML
  private void initialize() {
    colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    colDomicilio.setCellValueFactory(new PropertyValueFactory<>("domicilio"));
    colNif.setCellValueFactory(new PropertyValueFactory<>("nif"));

    colTipo.setCellValueFactory(c -> {
      if (c.getValue() instanceof ClienteEstandar)
        return new SimpleStringProperty("Estandar");
      if (c.getValue() instanceof ClientePremium)
        return new SimpleStringProperty("Premium");
      return new SimpleStringProperty("?");
    });

    cargarTodos();
  }

  /* ---------- REFRESCOS / FILTROS ---------- */
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

  /* ---------- CREAR ---------- */
  @FXML
  private void nuevo() {
    NuevoClienteDialog dlg = new NuevoClienteDialog();
    dlg.showAndWait().ifPresent(c -> {
      if (c instanceof ClientePremium p) {
        ClienteControlador.añadirClientePremiumDesdeVista(
            p.getNombre(), p.getDomicilio(), p.getNif(),
            p.getEmail(), p.getCuotaAnual());
      } else if (c instanceof ClienteEstandar e) {
        ClienteControlador.añadirClienteEstandarDesdeVista(
            e.getNombre(), e.getDomicilio(), e.getNif(), e.getEmail());
      }
      cargarTodos();
    });
  }

  /* ---------- ELIMINAR ---------- */
  @FXML
  private void eliminarSeleccionado() {
    Cliente c = tabla.getSelectionModel().getSelectedItem();
    if (c == null)
      return;

    boolean ok = ClienteControlador.eliminarClientePorEmail(c.getEmail()); // método añadido al controlador
    if (ok)
      cargarTodos();
  }

  /* ---------- VOLVER ---------- */
  @FXML
  private void volver() {
    try {
      Parent root = FXMLLoader.load(getClass().getResource("/com/teamcoders/vista/fx/inicio.fxml"));
      Stage s = (Stage) tabla.getScene().getWindow();
      s.setScene(new Scene(root));
      s.setTitle("Tienda Online");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
