package com.teamcoders.vista.fx.clientes;

import com.teamcoders.controlador.ClienteControlador;
import com.teamcoders.utils.EntradaUsuario;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ClientesAnadirController {
    @FXML private TextField txtNombre;
    @FXML private TextField txtNif;
    @FXML private TextField txtDomicilio;
    @FXML private TextField txtEmail;

    @FXML private RadioButton rbtEstandar;
    @FXML private RadioButton rbtPremium;

    @FXML private TextField txtCuota;
    @FXML private Label lblCuota;

    @FXML private Button btnGuardarCliente;
    @FXML private Button btnVolverCliente;

    private ToggleGroup tgTipoCliente = new ToggleGroup();

    @FXML
    public void initialize() {
        rbtEstandar.setToggleGroup(tgTipoCliente);
        rbtPremium.setToggleGroup(tgTipoCliente);
        // Mostrar campo de cuota solo si se selecciona "Premium"
        tgTipoCliente.selectedToggleProperty().addListener((obs, oldVal, newVal) -> {
            boolean esPremium = tgTipoCliente.getSelectedToggle() == rbtPremium;
            txtCuota.setVisible(esPremium);
            lblCuota.setVisible(esPremium);
        });

        // Configuración inicial
        txtCuota.setVisible(false);
        lblCuota.setVisible(false);
        rbtEstandar.setSelected(true); // opción por defecto
    }

    @FXML
    private void handleGuardar() {
        try {
            String nombre = EntradaUsuario.validarTexto(txtNombre.getText(), "Nombre");
            String nif = EntradaUsuario.validarTexto(txtNif.getText(), "NIF");
            String domicilio = EntradaUsuario.validarTexto(txtDomicilio.getText(), "Domicilio");
            String email = EntradaUsuario.validarEmail(txtEmail.getText());

            if (rbtPremium.isSelected()) {
                int cuotaAnual = EntradaUsuario.validarEntero(txtCuota.getText(), "Cuota anual");
                ClienteControlador.añadirClientePremiumDesdeVista(nombre, domicilio, nif, email, cuotaAnual);
            } else {
                ClienteControlador.añadirClienteEstandarDesdeVista(nombre, domicilio, nif, email);
            }
            mostrarAlerta("Cliente añadido", "El cliente se ha añadido correctamente.", Alert.AlertType.INFORMATION);
            limpiarFormulario();
        } catch (IllegalArgumentException ex) {
            mostrarAlerta("Error de validación", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleVolver() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/teamcoders/vista/fx/clientes/clientes_menu.fxml"));
            Stage stage = (Stage) btnVolverCliente.getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo volver al menú de clientes.", Alert.AlertType.ERROR);
        }
    }

    private void limpiarFormulario() {
        txtNombre.clear();
        txtNif.clear();
        txtDomicilio.clear();
        txtEmail.clear();
        txtCuota.clear();
        rbtEstandar.setSelected(true);
    }

    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
