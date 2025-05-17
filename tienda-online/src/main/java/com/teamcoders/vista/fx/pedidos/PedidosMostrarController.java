package com.teamcoders.vista.fx.pedidos;

import java.io.IOException;
import com.teamcoders.controlador.PedidoControlador;
import com.teamcoders.modelo.Pedido;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

/**
 * Controlador JavaFX responsable de la visualización de pedidos.
 *
 * Muestra todos los pedidos registrados, con opción de filtrado por estado
 * (enviados o pendientes de envío). Permite también regresar al menú principal
 * del módulo de pedidos. Pertenece a la capa Vista en el patrón MVC.
 */
public class PedidosMostrarController {

    // Tabla de pedidos y sus columnas: incluyen campos clave y relaciones
    @FXML private TableView<Pedido> tablaPedidos;
    @FXML private TableColumn<Pedido, String> colNumeroPedido;
    @FXML private TableColumn<Pedido, String> colUnidades;
    @FXML private TableColumn<Pedido, String> colFechaPedido;
    @FXML private TableColumn<Pedido, String> colClienteNombre;
    @FXML private TableColumn<Pedido, String> colArticuloDescripcion;
    @FXML private TableColumn<Pedido, String> colPrecioTotal;

    // Botón de retorno al menú de pedidos
    @FXML private Button btnVolver;

    /**
     * Inicializa la tabla de pedidos y configura sus columnas.
     * Define cómo se extrae cada dato del objeto Pedido para mostrarse en la interfaz.
     * Se cargan todos los pedidos por defecto.
     */
    @FXML
    public void initialize() {
        colNumeroPedido.setCellValueFactory(new PropertyValueFactory<>("numeroPedido"));
        colUnidades.setCellValueFactory(new PropertyValueFactory<>("unidades"));
        colFechaPedido.setCellValueFactory(cellData ->
            new SimpleStringProperty(cellData.getValue().getFechaPedido().toString()));
        colClienteNombre.setCellValueFactory(cellData ->
            new SimpleStringProperty(cellData.getValue().getCliente().getNombre()));
        colArticuloDescripcion.setCellValueFactory(cellData ->
            new SimpleStringProperty(cellData.getValue().getArticulo().getDescripcion()));
        colPrecioTotal.setCellValueFactory(cellData ->
            new SimpleStringProperty(String.format("%.2f", cellData.getValue().precioPedido())));

        mostrarTodosLosPedidos(); // carga inicial
    }

    /**
     * Carga todos los pedidos registrados en el sistema, sin aplicar filtros.
     */
    @FXML
    private void mostrarTodosLosPedidos() {
        tablaPedidos.setItems(FXCollections.observableArrayList(PedidoControlador.obtenerPedidos()));
    }

    /**
     * Muestra únicamente los pedidos marcados como enviados.
     */
    @FXML
    private void mostrarPedidosEnviados() {
        tablaPedidos.setItems(FXCollections.observableArrayList(PedidoControlador.obtenerPedidosEnviados()));
    }

    /**
     * Muestra únicamente los pedidos que aún están pendientes de envío.
     */
    @FXML
    private void mostrarPedidosPendientesDeEnvio() {
        tablaPedidos.setItems(FXCollections.observableArrayList(PedidoControlador.obtenerPedidosPendientesDeEnvio()));
    }

    /**
     * Acción asociada al botón "Volver".
     * 
     * Permite regresar al menú del módulo de pedidos.
     *
     * @param event evento generado al pulsar el botón correspondiente.
     */
    @FXML
    private void volver(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/pedidos/pedidos_menu.fxml"));
            Pane root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo volver al menú de clientes.");
        }
    }

    /**
     * Muestra una alerta de error con el mensaje proporcionado.
     *
     * @param titulo título de la ventana de alerta.
     * @param mensaje mensaje detallado a mostrar.
     */
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
