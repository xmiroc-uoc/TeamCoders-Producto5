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

/**
 * Controlador JavaFX para la vista de creación de nuevos clientes.
 * 
 * Esta clase gestiona la interacción con el formulario de entrada para crear
 * tanto clientes estándar como clientes premium, y forma parte de la capa Vista
 * en la arquitectura MVC.
 */
public class ClientesAnadirController {

    // Campos de texto para los datos del cliente
    @FXML private TextField txtNombre;
    @FXML private TextField txtNif;
    @FXML private TextField txtDomicilio;
    @FXML private TextField txtEmail;

    // Botones de selección del tipo de cliente
    @FXML private RadioButton rbtEstandar;
    @FXML private RadioButton rbtPremium;

    // Campo visible solo si se selecciona cliente premium
    @FXML private TextField txtCuota;
    @FXML private Label lblCuota;

    // Botones de acción del formulario
    @FXML private Button btnGuardarCliente;
    @FXML private Button btnVolverCliente;

    // Grupo de selección para los tipos de cliente
    private ToggleGroup tgTipoCliente = new ToggleGroup();

    /**
     * Inicializa la vista asociando los componentes y estableciendo el comportamiento dinámico
     * del formulario, como mostrar u ocultar el campo de cuota anual para clientes premium.
     */
    @FXML
    public void initialize() {
        rbtEstandar.setToggleGroup(tgTipoCliente);
        rbtPremium.setToggleGroup(tgTipoCliente);

        // Listener para mostrar/ocultar la cuota según el tipo de cliente seleccionado
        tgTipoCliente.selectedToggleProperty().addListener((obs, oldVal, newVal) -> {
            boolean esPremium = tgTipoCliente.getSelectedToggle() == rbtPremium;
            txtCuota.setVisible(esPremium);
            lblCuota.setVisible(esPremium);
        });

        // Configuración inicial por defecto
        txtCuota.setVisible(false);
        lblCuota.setVisible(false);
        rbtEstandar.setSelected(true);
    }

    /**
     * Maneja la acción del botón "Guardar".
     * 
     * Realiza la validación de los campos del formulario usando la clase `EntradaUsuario`,
     * y delega la creación del cliente al controlador de dominio.
     * 
     * Muestra un mensaje informativo si se ha creado correctamente o un mensaje de error si falla.
     */
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

    /**
     * Maneja el evento del botón "Volver".
     * 
     * Permite regresar al menú principal de clientes reemplazando el contenido actual de la escena.
     */
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

    /**
     * Limpia todos los campos del formulario para permitir una nueva entrada.
     */
    private void limpiarFormulario() {
        txtNombre.clear();
        txtNif.clear();
        txtDomicilio.clear();
        txtEmail.clear();
        txtCuota.clear();
        rbtEstandar.setSelected(true);
    }

    /**
     * Muestra una alerta en pantalla con el contenido y tipo especificados.
     * 
     * @param titulo título de la ventana emergente.
     * @param contenido mensaje mostrado al usuario.
     * @param tipo tipo de alerta (informativa o de error).
     */
    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
