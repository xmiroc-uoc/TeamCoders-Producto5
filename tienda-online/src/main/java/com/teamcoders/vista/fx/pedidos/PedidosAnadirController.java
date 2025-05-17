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

/**
 * Controlador para la vista de añadir pedidos.
 *
 * Permite introducir un nuevo pedido validando los datos de entrada,
 * y delega su creación al controlador de dominio. Forma parte de la
 * capa Vista en el patrón de diseño MVC.
 */
public class PedidosAnadirController {

    // Campos de entrada del formulario de pedido:
    // Email del cliente, código del artículo y cantidad de unidades.
    @FXML private TextField txtEmailCliente;
    @FXML private TextField txtCodigoArticulo;
    @FXML private TextField txtUnidades;

    // Botones de acción disponibles en la vista
    @FXML private Button btnGuardarPedido;
    @FXML private Button btnVolverPedido;

    /**
     * Acción asociada al botón "Guardar".
     * 
     * Valida los datos introducidos por el usuario (email, artículo, unidades)
     * y si son correctos, crea el pedido mediante el controlador de dominio.
     * 
     * Muestra una alerta informativa si el pedido fue añadido, o una de error
     * en caso de validación fallida.
     */
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

    /**
     * Acción asociada al botón "Volver".
     * 
     * Permite regresar al menú principal del módulo de pedidos reemplazando
     * la vista actual sin cerrar la ventana principal.
     */
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

    /**
     * Limpia todos los campos del formulario, permitiendo una nueva entrada.
     */
    private void limpiarFormulario() {
        txtEmailCliente.clear();
        txtCodigoArticulo.clear();
        txtUnidades.clear();
    }

    /**
     * Muestra una alerta al usuario con el título, mensaje y tipo especificados.
     *
     * @param titulo título del cuadro de diálogo.
     * @param contenido mensaje informativo o de error.
     * @param tipo tipo de alerta (información o error).
     */
    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
