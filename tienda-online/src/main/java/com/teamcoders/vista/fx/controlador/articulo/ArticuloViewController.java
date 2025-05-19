package com.teamcoders.vista.fx.controlador.articulo;

import com.teamcoders.controlador.ArticuloControlador;
import com.teamcoders.modelo.Articulo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ArticuloViewController {

  @FXML
  private TableView<Articulo> tabla;
  @FXML
  private TableColumn<Articulo, String> colCodigo;
  @FXML
  private TableColumn<Articulo, String> colDesc;
  @FXML
  private TableColumn<Articulo, Double> colPrecio;
  @FXML
  private TableColumn<Articulo, Double> colEnvio;
  @FXML
  private TableColumn<Articulo, Integer> colTiempo;

  @FXML
  private void initialize() {
    colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    colDesc.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    colPrecio.setCellValueFactory(new PropertyValueFactory<>("precioVenta"));
    colEnvio.setCellValueFactory(new PropertyValueFactory<>("gastosEnvio"));
    colTiempo.setCellValueFactory(new PropertyValueFactory<>("tiempoPreparacion"));

    cargar();
  }

  @FXML
  public void cargar() {
    ObservableList<Articulo> data = FXCollections.observableArrayList(
        ArticuloControlador.obtenerArticulos());
    tabla.setItems(data);
  }

  @FXML
  private void nueva() {
    NuevoArticuloDialog dlg = new NuevoArticuloDialog();

    dlg.showAndWait().ifPresent(a -> {
      ArticuloControlador.añadirArticuloDesdeVista(
          a.getCodigo(), a.getDescripcion(), a.getPrecioVenta(),
          a.getGastosEnvio(), a.getTiempoPreparacion());
      cargar();
    });
  }

  @FXML
  private void volver() {
    try {
      FXMLLoader loader = new FXMLLoader(
          getClass().getResource("/com/teamcoders/vista/fx/inicio.fxml"));
      Parent root = loader.load();
      Stage stage = (Stage) tabla.getScene().getWindow();
      stage.setTitle("Tienda Online");
      stage.setScene(new Scene(root));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
