package com.teamcoders.vista.fx.controlador.pedido;

import com.teamcoders.controlador.PedidoControlador;
import com.teamcoders.modelo.Pedido;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.SimpleStringProperty;

public class PedidoViewController {

  @FXML
  private TableView<Pedido> tabla;
  @FXML
  private TableColumn<Pedido, Integer> colNum;
  @FXML
  private TableColumn<Pedido, String> colCli;
  @FXML
  private TableColumn<Pedido, String> colArt;
  @FXML
  private TableColumn<Pedido, String> colFecha;
  @FXML
  private TableColumn<Pedido, Integer> colUni;
  @FXML
  private TableColumn<Pedido, String> colEstado;
  @FXML
  private TextField txtNumero; // del FXML

  /* ───────── INIT ───────── */
  @FXML
  private void initialize() {

    colNum.setCellValueFactory(new PropertyValueFactory<>("numeroPedido"));
    colCli.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getCliente().getEmail()));
    colArt.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getArticulo().getCodigo()));
    colFecha.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getFechaPedido()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));
    colUni.setCellValueFactory(new PropertyValueFactory<>("unidades"));
    colEstado.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().cancelable() ? "Pendiente" : "Enviado"));

    cargarTodos();
  }

  /* ───────── FILTROS ───────── */
  @FXML
  private void cargarTodos() {
    tabla.setItems(FXCollections.observableArrayList(PedidoControlador.obtenerPedidos()));
  }

  @FXML
  private void buscarPedido() {
    String txt = txtNumero.getText().trim();
    if (txt.isBlank()) { // vacía = quita filtro
      cargarTodos();
      return;
    }
    try {
      int num = Integer.parseInt(txt);
      tabla.setItems(FXCollections.observableArrayList(
          PedidoControlador.obtenerPedidos().stream()
              .filter(p -> p.getNumeroPedido() == num)
              .toList()));
    } catch (NumberFormatException e) {
      new Alert(Alert.AlertType.WARNING,
          "Introduce un número de pedido válido").showAndWait();
    }
  }

  @FXML
  private void cargarPendientes() {
    tabla.setItems(FXCollections.observableArrayList(PedidoControlador.obtenerPedidosPendientesDeEnvio()));
  }

  @FXML
  private void cargarEnviados() {
    tabla.setItems(FXCollections.observableArrayList(PedidoControlador.obtenerPedidosEnviados()));
  }

  /* ───────── NUEVO ───────── */
  @FXML
  private void nuevo() {
    NuevoPedidoDialog dlg = new NuevoPedidoDialog();
    dlg.showAndWait().ifPresent(p -> {
      // Guardar en BD mediante el controlador de dominio
      PedidoControlador.añadirPedidoDesdeVista(
          p.getCliente().getEmail(),
          p.getArticulo().getCodigo(),
          p.getUnidades());
      cargarTodos();
    });
  }

  /* ───────── ELIMINAR ───────── */
  @FXML
  private void eliminarSeleccionado() {
    Pedido sel = tabla.getSelectionModel().getSelectedItem();
    if (sel != null && PedidoControlador.eliminarPedidoSiNoEnviado(sel.getNumeroPedido())) {
      cargarTodos();
    }
  }

  /* ───────── REFRESCAR & VOLVER ───────── */
  @FXML
  private void refrescar() {
    cargarTodos();
  }

  @FXML
  private void volver() {
    try {
      Parent root = FXMLLoader.load(
          getClass().getResource("/com/teamcoders/vista/fx/inicio.fxml"));
      Stage st = (Stage) tabla.getScene().getWindow();
      st.setTitle("Tienda Online");
      st.setScene(new Scene(root));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
