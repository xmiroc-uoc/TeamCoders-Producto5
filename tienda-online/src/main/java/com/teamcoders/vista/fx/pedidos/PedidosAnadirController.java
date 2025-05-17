package com.teamcoders.vista.fx.pedidos;

import com.teamcoders.controlador.PedidoControlador;
import com.teamcoders.utils.EntradaUsuario;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PedidosAnadirController {
    @FXML private TextField txtEmailCliente;
    @FXML private TextField txtCodigoArticulo;
    @FXML private TextField txtUnidades;

    @FXML private Button btnGuardarPedido;
    @FXML private Button btnVolverPedido;

    @FXML
    private void handleGuardar() {
        try {
            String clienteEmail = EntradaUsuario.validarEmail(txtEmailCliente.getText());
            String articuloCodigo = EntradaUsuario.validarTexto(txtCodigoArticulo.getText(), "Descripcion");
            Integer cantidad = EntradaUsuario.validarEntero(txtUnidades.getText(), "Precio venta");
            
            PedidoControlador.añadirPedidoDesdeVista(clienteEmail, articuloCodigo, cantidad);
            
            mostrarAlerta("Peiddos añadido", "El pedidos se ha añadido correctamente.", Alert.AlertType.INFORMATION);
            limpiarFormulario();
        } catch (IllegalArgumentException ex) {
            mostrarAlerta("Error de validación", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleVolver() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/teamcoders/vista/fx/pedidos/pedidos_menu.fxml"));
            Stage stage = (Stage) btnVolverPedido.getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo volver al menú de pedidos.", Alert.AlertType.ERROR);
        }
    }

    private void limpiarFormulario() {
        txtEmailCliente.clear();
        txtCodigoArticulo.clear();
        txtUnidades.clear();
    }

    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
