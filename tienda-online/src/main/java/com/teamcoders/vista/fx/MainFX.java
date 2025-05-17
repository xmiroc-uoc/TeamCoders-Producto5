package com.teamcoders.vista.fx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainFX.class.getResource("inicio/inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Tienda Online");
        stage.setScene(scene);
        stage.setMaximized(true); // Maximizar solo al iniciar
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
