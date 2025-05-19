package com.teamcoders.vista.fx.controlador.pedido;

import com.teamcoders.controlador.ArticuloControlador;
import com.teamcoders.controlador.ClienteControlador;
import com.teamcoders.modelo.Articulo;
import com.teamcoders.modelo.Cliente;
import com.teamcoders.modelo.Pedido;
import javafx.util.StringConverter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import java.io.IOException;
import java.time.LocalDateTime;

public class NuevoPedidoDialog extends Dialog<Pedido> {

  @FXML
  private ChoiceBox<Cliente> cbCliente;
  @FXML
  private ChoiceBox<Articulo> cbArticulo;
  @FXML
  private TextField txtUnidades;

  public NuevoPedidoDialog() {
    try {
      FXMLLoader l = new FXMLLoader(getClass()
          .getResource("/com/teamcoders/vista/fx/pedido/NuevoPedidoDialog.fxml"));
      l.setController(this);
      setDialogPane(l.load());
    } catch (IOException e) {
      throw new RuntimeException("No puedo cargar NuevoPedidoDialog.fxml", e);
    }

    setTitle("Nuevo Pedido");

    /* ───────── Rellenar choice-boxes con datos de la BD ───────── */
    cbCliente.getItems().addAll(ClienteControlador.obtenerClientes());
    cbArticulo.getItems().addAll(ArticuloControlador.obtenerArticulos());

    /* ───────── Conversores para mostrar algo legible ───────── */
    cbCliente.setConverter(new StringConverter<>() {
      @Override
      public String toString(Cliente c) {
        return c == null ? "" : c.getEmail();
      }

      @Override
      public Cliente fromString(String s) {
        return null;
      }
    });
    cbArticulo.setConverter(new StringConverter<>() {
      @Override
      public String toString(Articulo a) {
        return a == null ? "" : a.getCodigo();
      }

      @Override
      public Articulo fromString(String s) {
        return null;
      }
    });

    /* ───────── Resultado del diálogo ───────── */
    setResultConverter(bt -> {
      if (bt.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
        try {
          int unidades = Integer.parseInt(txtUnidades.getText().trim());
          if (unidades <= 0)
            throw new NumberFormatException();
          return new Pedido(0, unidades, LocalDateTime.now(),
              cbCliente.getValue(), cbArticulo.getValue());
        } catch (Exception ex) {
          new Alert(Alert.AlertType.ERROR, "Unidades inválidas").showAndWait();
        }
      }
      return null;
    });
  }
}
