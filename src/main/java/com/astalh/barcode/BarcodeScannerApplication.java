package com.astalh.barcode;

import com.astalh.barcode.controller.ApplicationRootController;
import com.github.sarxos.webcam.Webcam;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Tanuj on 2/12/17.
 */
public class BarcodeScannerApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/application-root.fxml"));
        Parent root = fxmlLoader.load();
        ApplicationRootController controller = fxmlLoader.getController();
        Scene scene = new Scene(root, 800, 600);primaryStage.setTitle("Barcode Scanner");
        primaryStage.setScene(scene);
        controller.init();
        primaryStage.show();
    }
}
