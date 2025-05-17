package com.teamcoders.vista.fx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación JavaFX.
 * 
 * Esta clase representa el punto de entrada de la interfaz gráfica de usuario (GUI)
 * para la aplicación de gestión de tienda online desarrollada por TeamCoders.
 * 
 * Su responsabilidad principal es cargar la vista inicial desde el archivo FXML
 * correspondiente y mostrar la ventana principal maximizada.
 *
 * Forma parte de la arquitectura basada en el patrón MVC, donde actúa como punto
 * de lanzamiento de la capa de vista.
 */
public class MainFX extends Application{

    /**
     * Método que inicializa la aplicación JavaFX.
     * 
     * Carga la vista inicial definida en el archivo `inicio.fxml`, establece el título
     * de la ventana y la presenta en pantalla maximizando su tamaño.
     *
     * @param stage el contenedor primario de la escena JavaFX.
     * @throws IOException si ocurre un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Cargar la vista principal desde el archivo FXML
        FXMLLoader fxmlLoader = new FXMLLoader(MainFX.class.getResource("inicio/inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Configurar y mostrar la ventana principal
        stage.setTitle("Tienda Online");
        stage.setScene(scene);
        stage.setMaximized(true); // Maximizar solo al iniciar
        stage.show();
    }

    /**
     * Método main que lanza la aplicación.
     * 
     * Este método es invocado por la máquina virtual Java al ejecutar el programa
     * y es responsable de iniciar el ciclo de vida de JavaFX.
     *
     * @param args argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        launch(args);
    }
}
