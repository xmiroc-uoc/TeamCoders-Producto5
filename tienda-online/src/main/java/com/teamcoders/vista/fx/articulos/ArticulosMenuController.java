package com.teamcoders.vista.fx.articulos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controlador del menú de gestión de artículos.
 *
 * Permite la navegación entre las distintas vistas del módulo de artículos:
 * añadir un nuevo artículo, visualizar los artículos registrados o volver
 * a la vista de inicio. Pertenece a la capa Vista en el patrón MVC.
 */
public class ArticulosMenuController {

    /**
     * Acción asociada al botón "Añadir Artículo".
     * 
     * Carga la vista `articulos_anadir.fxml` para introducir un nuevo artículo.
     * 
     * @param event evento generado al pulsar el botón correspondiente.
     */
   @FXML
    private void anadirArticulo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/articulos/articulos_anadir.fxml"));
            Pane root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root); // Mantiene el mismo Stage maximizado
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Acción asociada al botón "Mostrar Artículos".
     * 
     * Carga la vista `articulos_mostrar.fxml` que contiene la tabla con los
     * artículos disponibles en el sistema.
     * 
     * @param event evento generado al pulsar el botón correspondiente.
     */
    @FXML
    public void mostrarArticulos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/articulos/articulos_mostrar.fxml"));
            Pane root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Acción asociada al botón "Volver".
     * 
     * Permite regresar desde el menú de artículos a la vista de inicio general
     * de la aplicación, conservando el estado del `Stage`.
     * 
     * @param event evento generado por la acción del usuario.
     */
    @FXML
    public void volverInicio(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/inicio/inicio.fxml"));
            Pane root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
