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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

public class ClientesMostrarController {

    @FXML private TableView<Cliente> tablaClientes;
    @FXML private TableColumn<Cliente, String> colNombre;
    @FXML private TableColumn<Cliente, String> colDomicilio;
    @FXML private TableColumn<Cliente, String> colNif;
    @FXML private TableColumn<Cliente, String> colEmail;
    @FXML private TableColumn<Cliente, String> colTipo;
    @FXML private TableColumn<Cliente, String> colCuota;

    @FXML private Button btnTodos;
    @FXML private Button btnEstandar;
    @FXML private Button btnPremium;
    @FXML private Button btnVolver;

    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDomicilio.setCellValueFactory(new PropertyValueFactory<>("domicilio"));
        colNif.setCellValueFactory(new PropertyValueFactory<>("nif"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTipo.setCellValueFactory(cellData -> {
            Cliente cliente = cellData.getValue();
            String tipo = cliente instanceof ClientePremium ? "Premium" : "Estandar";
            return new SimpleStringProperty(tipo);
        });
        colCuota.setCellValueFactory(cellData -> {
            Cliente cliente = cellData.getValue();
            if (cliente instanceof ClientePremium) {
                int cuota = ((ClientePremium) cliente).getCuotaAnual();
                return new SimpleStringProperty(String.valueOf(cuota));
            } else {
                return new SimpleStringProperty(""); // Vacío si no tiene cuota
            }
        });

        mostrarTodos(); // carga inicial
    }

        @FXML
    private void mostrarTodos() {
        tablaClientes.setItems(FXCollections.observableArrayList(ClienteControlador.obtenerClientes()));
    }

    @FXML
    private void mostrarEstandar() {
        List<Cliente> estandar = ClienteControlador.obtenerClientes().stream()
                .filter(c -> c instanceof ClienteEstandar)
                .collect(Collectors.toList());
        tablaClientes.setItems(FXCollections.observableArrayList(estandar));
    }

    @FXML
    private void mostrarPremium() {
        List<Cliente> premium = ClienteControlador.obtenerClientes().stream()
                .filter(c -> c instanceof ClientePremium)
                .collect(Collectors.toList());
        tablaClientes.setItems(FXCollections.observableArrayList(premium));
    }

    @FXML
    private void volver(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/teamcoders/vista/fx/clientes/clientes_menu.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo volver al menú de clientes.");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
