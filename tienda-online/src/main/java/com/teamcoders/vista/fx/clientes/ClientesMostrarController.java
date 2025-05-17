package com.teamcoders.vista.fx.clientes;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.teamcoders.controlador.ClienteControlador;
import com.teamcoders.modelo.Cliente;
import com.teamcoders.modelo.ClienteEstandar;
import com.teamcoders.modelo.ClientePremium;

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
 * Controlador JavaFX responsable de la visualización de los clientes registrados.
 * 
 * Esta clase carga la tabla con todos los clientes y permite filtrarlos por tipo (estándar o premium).
 * También facilita la navegación de vuelta al menú principal de clientes.
 * Forma parte de la capa Vista dentro del patrón MVC.
 */
public class ClientesMostrarController {

    // Elementos de la tabla de clientes:
    // Incluyen el nombre, domicilio, NIF, email, tipo (Estándar o Premium),
    // y la cuota anual (solo visible para clientes Premium).
    @FXML private TableView<Cliente> tablaClientes;
    @FXML private TableColumn<Cliente, String> colNombre;
    @FXML private TableColumn<Cliente, String> colDomicilio;
    @FXML private TableColumn<Cliente, String> colNif;
    @FXML private TableColumn<Cliente, String> colEmail;
    @FXML private TableColumn<Cliente, String> colTipo;
    @FXML private TableColumn<Cliente, String> colCuota;

    // Botones de acción disponibles en la vista:
    // permiten filtrar por tipo de cliente y volver al menú principal.
    @FXML private Button btnTodos;
    @FXML private Button btnEstandar;
    @FXML private Button btnPremium;
    @FXML private Button btnVolver;

    /**
     * Inicializa la tabla con la configuración de las columnas.
     * Define cómo se deben obtener y representar los datos desde los objetos Cliente.
     */
    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDomicilio.setCellValueFactory(new PropertyValueFactory<>("domicilio"));
        colNif.setCellValueFactory(new PropertyValueFactory<>("nif"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Determina el tipo de cliente según su instancia
        colTipo.setCellValueFactory(cellData -> {
            Cliente cliente = cellData.getValue();
            String tipo = cliente instanceof ClientePremium ? "Premium" : "Estandar";
            return new SimpleStringProperty(tipo);
        });

        // Muestra la cuota anual solo si el cliente es premium
        colCuota.setCellValueFactory(cellData -> {
            Cliente cliente = cellData.getValue();
            if (cliente instanceof ClientePremium) {
                int cuota = ((ClientePremium) cliente).getCuotaAnual();
                return new SimpleStringProperty(String.valueOf(cuota));
            } else {
                return new SimpleStringProperty(""); // Vacío si no tiene cuota
            }
        });

        mostrarTodos(); // Carga inicial con todos los clientes
    }

    /**
     * Muestra todos los clientes disponibles en la tabla sin filtros.
     */
    @FXML
    private void mostrarTodos() {
        tablaClientes.setItems(FXCollections.observableArrayList(ClienteControlador.obtenerClientes()));
    }

    /**
     * Filtra y muestra únicamente los clientes del tipo estándar.
     */
    @FXML
    private void mostrarEstandar() {
        List<Cliente> estandar = ClienteControlador.obtenerClientes().stream()
                .filter(c -> c instanceof ClienteEstandar)
                .collect(Collectors.toList());
        tablaClientes.setItems(FXCollections.observableArrayList(estandar));
    }

    /**
     * Filtra y muestra únicamente los clientes del tipo premium.
     */
    @FXML
    private void mostrarPremium() {
        List<Cliente> premium = ClienteControlador.obtenerClientes().stream()
                .filter(c -> c instanceof ClientePremium)
                .collect(Collectors.toList());
        tablaClientes.setItems(FXCollections.observableArrayList(premium));
    }

    /**
     * Acción asociada al botón de volver al menú de gestión de clientes.
     *
     * @param event evento generado por el botón "Volver".
     */
    @FXML
    private void volver(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/clientes/clientes_menu.fxml"));
            Pane root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo volver al menú de clientes.");
        }
    }

    /**
     * Muestra una alerta de error con un mensaje personalizado.
     *
     * @param titulo título del cuadro de diálogo.
     * @param mensaje contenido del mensaje de error.
     */
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
