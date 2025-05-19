package com.teamcoders.vista.fx.controlador.articulo;

import com.teamcoders.modelo.Articulo;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.util.Optional;

public class NuevoArticuloDialog extends Dialog<Articulo> {

  private final TextField tfCodigo = new TextField();
  private final TextField tfDesc = new TextField();
  private final TextField tfPrecio = new TextField();
  private final TextField tfEnvio = new TextField();
  private final TextField tfTiempo = new TextField();

  public NuevoArticuloDialog() {
    setTitle("Nuevo Artículo");
    setHeaderText("Introduce los datos del artículo");
    ButtonType ok = new ButtonType("Crear", ButtonBar.ButtonData.OK_DONE);
    getDialogPane().getButtonTypes().addAll(ok, ButtonType.CANCEL);

    GridPane g = new GridPane();
    g.setHgap(10);
    g.setVgap(10);
    g.setPadding(new Insets(20));
    g.addRow(0, new Label("Código"), tfCodigo);
    g.addRow(1, new Label("Descripción"), tfDesc);
    g.addRow(2, new Label("Precio"), tfPrecio);
    g.addRow(3, new Label("Gastos envío"), tfEnvio);
    g.addRow(4, new Label("Tiempo prep."), tfTiempo);
    getDialogPane().setContent(g);

    setResultConverter(btn -> {
      if (btn == ok) {
        try {
          return new Articulo(
              tfCodigo.getText().trim(),
              Integer.parseInt(tfTiempo.getText()),
              Double.parseDouble(tfEnvio.getText()),
              Double.parseDouble(tfPrecio.getText()),
              tfDesc.getText().trim());
        } catch (NumberFormatException ex) {
          /* valores erróneos -> null */ }
      }
      return null;
    });
  }

  @Override
  public Optional<Articulo> showAndWait() {
    return super.showAndWait();
  }
}
