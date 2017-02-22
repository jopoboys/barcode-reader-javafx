package com.astalh.barcode;

import com.astalh.barcode.controller.ApplicationRootController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Tanuj on 2/12/17.
 */
public class BarcodeScannerApplication extends Application {

    private static Logger logger = LoggerFactory.getLogger(BarcodeScannerApplication.class);

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        try {
            logger.info("Staring Application : Barcode Scanner");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/application-root.fxml"));
            Parent root = fxmlLoader.load();
            ApplicationRootController controller = fxmlLoader.getController();
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setTitle("Barcode Scanner");
            primaryStage.getIcons().add(new Image(getClass().getClassLoader().getResource("icons/barcode.png").toExternalForm()));
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setOnCloseRequest(event -> {
                if (controller != null) {
                    controller.onClose();
                }
            });
            controller.init();
            controller.setParentStage(primaryStage);
            primaryStage.show();
        }catch (Exception ex){
            logger.error("Exception while starting application :", ex);
        }
    }
}
