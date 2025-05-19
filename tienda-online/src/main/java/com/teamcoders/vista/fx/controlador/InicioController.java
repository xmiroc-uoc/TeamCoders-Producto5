package com.teamcoders.vista.fx.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InicioController {

  @FXML
  private Button botonClientes; // --> lo usamos para sacar la ventana actual

  private void cambiarEscena(String rutaFXML, String tituloVentana) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
      Parent root = loader.load();

      Stage stage = (Stage) botonClientes.getScene().getWindow();
      stage.setTitle(tituloVentana);
      stage.setScene(new Scene(root));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void abrirClientes() {
    cambiarEscena("/com/teamcoders/vista/fx/cliente/ClienteView.fxml", "Clientes");
  }

  @FXML
  private void abrirArticulos() {
    cambiarEscena("/com/teamcoders/vista/fx/articulo/ArticuloView.fxml", "Artículos");
  }

  @FXML
  private void abrirPedidos() {
    cambiarEscena("/com/teamcoders/vista/fx/pedido/PedidoView.fxml", "Pedidos");
  }
}
