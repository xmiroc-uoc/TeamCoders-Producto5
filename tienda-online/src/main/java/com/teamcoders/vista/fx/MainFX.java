package com.teamcoders.vista.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/teamcoders/vista/fx/inicio.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Tienda Online - Interfaz Gráfica");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
