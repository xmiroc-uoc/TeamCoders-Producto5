package com.teamcoders.vista.fx.articulos;

import com.teamcoders.controlador.ArticuloControlador;
import com.teamcoders.utils.EntradaUsuario;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controlador de la vista para añadir nuevos artículos a la tienda online.
 * 
 * Esta clase permite al usuario introducir información detallada sobre un artículo
 * y validarla antes de delegar su almacenamiento en el controlador de dominio.
 * Forma parte de la capa Vista dentro del patrón MVC.
 */
public class ArticulosAnadirController {

    // Campos del formulario para los atributos del artículo
    @FXML private TextField txtCodigo;
    @FXML private TextField txtDescripcion;
    @FXML private TextField txtPrecioVenta;
    @FXML private TextField txtGastosEnvio;
    @FXML private TextField txtTiempoPreparacion;

    // Botones de acción
    @FXML private Button btnGuardarArticulo;
    @FXML private Button btnVolverArticulo;

    /**
     * Maneja la acción del botón "Guardar".
     * 
     * Realiza la validación de los campos de entrada mediante la clase `EntradaUsuario`
     * y, si son válidos, crea un nuevo artículo a través del controlador de dominio.
     * Muestra un mensaje de confirmación o error según corresponda.
     */
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

    /**
     * Maneja la acción del botón "Volver".
     * 
     * Permite regresar al menú de gestión de artículos reemplazando la vista actual,
     * sin cerrar el `Stage` principal de la aplicación.
     */
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

    /**
     * Limpia los campos del formulario para permitir una nueva entrada de datos.
     */
    private void limpiarFormulario() {
        txtCodigo.clear();
        txtDescripcion.clear();
        txtPrecioVenta.clear();
        txtGastosEnvio.clear();
        txtTiempoPreparacion.clear();
    }

    /**
     * Muestra un mensaje de alerta informativa o de error en la interfaz.
     *
     * @param titulo título de la alerta.
     * @param contenido mensaje detallado a mostrar.
     * @param tipo tipo de alerta: información o error.
     */
    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
