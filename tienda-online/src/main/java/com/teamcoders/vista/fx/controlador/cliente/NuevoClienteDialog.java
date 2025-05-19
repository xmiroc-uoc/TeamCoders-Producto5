package com.teamcoders.vista.fx.controlador.cliente;

import com.teamcoders.modelo.Cliente;
import com.teamcoders.modelo.ClienteEstandar;
import com.teamcoders.modelo.ClientePremium;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import java.io.IOException;

public class NuevoClienteDialog extends Dialog<Cliente> {

  @FXML
  private TextField txtNombre, txtDom, txtNif, txtEmail, txtCuota;
  @FXML
  private ChoiceBox<String> cbTipo;

  public NuevoClienteDialog() {

    try {
      // ① FXML que está en resources/com/teamcoders/vista/fx/cliente
      FXMLLoader loader = new FXMLLoader(
          getClass().getResource("/com/teamcoders/vista/fx/cliente/NuevoClienteDialog.fxml"));
      loader.setController(this);
      setDialogPane(loader.load());
    } catch (IOException e) {
      throw new RuntimeException("No puedo cargar el diálogo", e);
    }

    setTitle("Nuevo Cliente");

    cbTipo.getItems().addAll("Estandar", "Premium");
    cbTipo.getSelectionModel().selectFirst();
    txtCuota.setDisable(true);

    // Habilitar / deshabilitar la cuota según tipo
    cbTipo.getSelectionModel().selectedItemProperty()
        .addListener((obs, o, n) -> txtCuota.setDisable(!"Premium".equals(n)));

    // Conversor de resultado
    setResultConverter(btn -> {
      if (btn.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
        String nom = txtNombre.getText().trim();
        String dom = txtDom.getText().trim();
        String nif = txtNif.getText().trim();
        String mail = txtEmail.getText().trim();

        if ("Premium".equals(cbTipo.getValue())) {
          int cuota = Integer.parseInt(txtCuota.getText().trim());
          return new ClientePremium(nom, dom, nif, mail, cuota);
        }
        return new ClienteEstandar(nom, dom, nif, mail);
      }
      return null;
    });
  }
}
