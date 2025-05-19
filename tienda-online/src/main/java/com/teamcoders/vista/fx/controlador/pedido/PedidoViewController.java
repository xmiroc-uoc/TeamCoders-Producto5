package com.teamcoders.vista.fx.controlador.pedido;

import com.teamcoders.controlador.PedidoControlador;
import com.teamcoders.modelo.Pedido;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import java.util.Optional;

public class PedidoViewController {

  @FXML
  private TableView<Pedido> tabla;

  @FXML
  private void initialize() {
    cargarTodos();
  }

  @FXML
  private void cargarTodos() {
    tabla.setItems(FXCollections.observableArrayList(
        PedidoControlador.obtenerPedidos()));
  }

  @FXML
  private void cargarPendientes() {
    tabla.setItems(FXCollections.observableArrayList(
        PedidoControlador.obtenerPedidosPendientesDeEnvio()));
  }

  @FXML
  private void cargarEnviados() {
    tabla.setItems(FXCollections.observableArrayList(
        PedidoControlador.obtenerPedidosEnviados()));
  }

  @FXML
  private void eliminarSeleccionado() {
    Pedido p = tabla.getSelectionModel().getSelectedItem();
    if (p != null) {
      PedidoControlador.eliminarPedidoSiNoEnviado(p.getNumeroPedido());
      cargarTodos();
    }
  }

  @FXML
  private void nuevo() {
    TextInputDialog d = new TextInputDialog();
    d.setHeaderText("email,codigoArticulo,unidades");
    Optional<String> r = d.showAndWait();
    r.ifPresent(line -> {
      String[] t = line.split(",");
      if (t.length == 3) {
        PedidoControlador.añadirPedidoDesdeVista(
            t[0].trim(), t[1].trim(), Integer.parseInt(t[2].trim()));
        cargarTodos();
      }
    });
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
