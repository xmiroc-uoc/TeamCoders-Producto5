package com.teamcoders.vista.fx.articulos;

import java.io.IOException;
import com.teamcoders.controlador.ArticuloControlador;
import com.teamcoders.modelo.Articulo;
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
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

public class ArticulosMostrarController {

    @FXML private TableView<Articulo> tablaArticulos;
    @FXML private TableColumn<Articulo, String> colCodigo;
    @FXML private TableColumn<Articulo, String> colDescripcion;
    @FXML private TableColumn<Articulo, Double> colPrecioVenta;
    @FXML private TableColumn<Articulo, Double> colGastosEnvio;
    @FXML private TableColumn<Articulo, Integer> colTiempoPreparacion;

    @FXML private Button btnTodos;
    @FXML private Button btnEstandar;
    @FXML private Button btnPremium;
    @FXML private Button btnVolver;

    @FXML
    public void initialize() {
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colPrecioVenta.setCellValueFactory(new PropertyValueFactory<>("precioVenta"));
        colGastosEnvio.setCellValueFactory(new PropertyValueFactory<>("gastosEnvio"));
        colTiempoPreparacion.setCellValueFactory(new PropertyValueFactory<>("tiempoPreparacion"));

        mostrarTodos(); // carga inicial
    }

        @FXML
    private void mostrarTodos() {
        tablaArticulos.setItems(FXCollections.observableArrayList(ArticuloControlador.obtenerArticulos()));
    }

    @FXML
    private void volver(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/articulos/articulos_menu.fxml"));
            Pane root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root);
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
