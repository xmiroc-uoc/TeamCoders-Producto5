package com.teamcoders.vista.fx.articulos;

import com.teamcoders.controlador.ArticuloControlador;
import com.teamcoders.utils.EntradaUsuario;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ArticulosAnadirController {
    @FXML private TextField txtCodigo;
    @FXML private TextField txtDescripcion;
    @FXML private TextField txtPrecioVenta;
    @FXML private TextField txtGastosEnvio;
    @FXML private TextField txtTiempoPreparacion;

    @FXML private RadioButton rbtEstandar;
    @FXML private RadioButton rbtPremium;

    @FXML private TextField txtCuota;
    @FXML private Label lblCuota;

    @FXML private Button btnGuardarArticulo;
    @FXML private Button btnVolverArticulo;

    @FXML
    private void handleGuardar() {
        try {
            String codigo = EntradaUsuario.validarTexto(txtCodigo.getText(), "Codigo");
            String descripcion = EntradaUsuario.validarTexto(txtDescripcion.getText(), "Descripcion");
            Double precioVenta = EntradaUsuario.validarDouble(txtPrecioVenta.getText(), "Precio venta");
            Double gastosEnvio = EntradaUsuario.validarDouble(txtGastosEnvio.getText(), "Gastos envio");
            Integer tiempoPreparacion = EntradaUsuario.validarEntero(txtTiempoPreparacion.getText(), "Tiempo preparacion");

            ArticuloControlador.añadirArticuloDesdeVista(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion);
            
            mostrarAlerta("Articulo añadido", "El articulo se ha añadido correctamente.", Alert.AlertType.INFORMATION);
            limpiarFormulario();
        } catch (IllegalArgumentException ex) {
            mostrarAlerta("Error de validación", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleVolver() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/teamcoders/vista/fx/articulos/articulos_menu.fxml"));
            Stage stage = (Stage) btnVolverArticulo.getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo volver al menú de articulos.", Alert.AlertType.ERROR);
        }
    }

    private void limpiarFormulario() {
        txtCodigo.clear();
        txtDescripcion.clear();
        txtPrecioVenta.clear();
        txtGastosEnvio.clear();
        txtTiempoPreparacion.clear();
    }

    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
