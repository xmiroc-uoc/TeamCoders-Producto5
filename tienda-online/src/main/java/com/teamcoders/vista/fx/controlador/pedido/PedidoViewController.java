package com.teamcoders.vista.fx.controlador.pedido;

import com.teamcoders.controlador.PedidoControlador;
import com.teamcoders.modelo.Pedido;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class PedidoViewController {

  /* ---------- FXML ---------- */
  @FXML
  private TableView<Pedido> tabla;
  @FXML
  private TableColumn<Pedido, Integer> colNum;
  @FXML
  private TableColumn<Pedido, String> colEmail;
  @FXML
  private TableColumn<Pedido, String> colArt;
  @FXML
  private TableColumn<Pedido, String> colFecha;
  @FXML
  private TableColumn<Pedido, Integer> colUnid;
  @FXML
  private TableColumn<Pedido, String> colEstado;

  private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  /* ---------- INIT ---------- */
  @FXML
  private void initialize() {
    colNum.setCellValueFactory(new PropertyValueFactory<>("numeroPedido"));
    colUnid.setCellValueFactory(new PropertyValueFactory<>("unidades"));

    colEmail.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCliente().getEmail()));
    colArt.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getArticulo().getCodigo()));
    colFecha.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFechaPedido().format(fmt)));
    colEstado.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().cancelable() ? "Pendiente" : "Enviado"));

    cargarTodos();
  }

  /* ---------- REFRESCOS ---------- */
  @FXML
  private void cargarTodos() {
    tabla.setItems(FXCollections.observableArrayList(PedidoControlador.obtenerPedidos()));
  }

  @FXML
  private void cargarPendientes() {
    tabla.setItems(FXCollections.observableArrayList(PedidoControlador.obtenerPedidosPendientesDeEnvio()));
  }

  @FXML
  private void cargarEnviados() {
    tabla.setItems(FXCollections.observableArrayList(PedidoControlador.obtenerPedidosEnviados()));
  }

  /* ---------- NUEVO ---------- */
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

  /* ---------- ELIMINAR ---------- */
  @FXML
  private void eliminarSeleccionado() {
    Pedido p = tabla.getSelectionModel().getSelectedItem();
    if (p != null && PedidoControlador.eliminarPedidoSiNoEnviado(p.getNumeroPedido())) {
      cargarTodos();
    }
  }

  /* ---------- VOLVER ---------- */
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
