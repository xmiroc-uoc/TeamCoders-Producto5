package com.teamcoders.vista.fx.clientes;

import com.teamcoders.controlador.ClienteControlador;
import com.teamcoders.modelo.Cliente;
import com.teamcoders.modelo.ClientePremium;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;

public class ClientesMostrarTodosController {

    @FXML
    private TableView<Cliente> tablaClientes;

    @FXML
    private TableColumn<Cliente, String> colNombre;

    @FXML
    private TableColumn<Cliente, String> colDomicilio;

    @FXML
    private TableColumn<Cliente, String> colNif;

    @FXML
    private TableColumn<Cliente, String> colEmail;

    @FXML
    private TableColumn<Cliente, String> colTipo;

    @FXML
    private TableColumn<Cliente, String> colCuota;

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

        cargarClientes();
    }

    private void cargarClientes() {
        tablaClientes.setItems(FXCollections.observableArrayList(ClienteControlador.obtenerClientes()));
    }
}
