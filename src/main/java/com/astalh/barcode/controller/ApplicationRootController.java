package com.astalh.barcode.controller;

import com.astalh.barcode.common.WebCamInfo;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingNode;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Tanuj on 2/12/17.
 */
public class ApplicationRootController implements Initializable{

    /** UI Controls **/
    public AnchorPane mainContainer;

    ObservableList<WebCamInfo> options = FXCollections.observableArrayList();
    private Webcam defaultWebcam = null;
    private WebcamPanel defaultWebcamPanel = null;
    private final SwingNode defaultWebcamPanelNode = new SwingNode();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void creatDefaultWebcamPanel(final SwingNode swingNode) {
        SwingUtilities.invokeLater(() -> {
            if(defaultWebcamPanel != null) {
                swingNode.setContent(defaultWebcamPanel);
            }
        });
    }


    public void init(){
        Task<Webcam> getWebcamTask = new Task<Webcam>() {
            @Override
            protected Webcam call() throws Exception {
                return Webcam.getDefault();
            }
        };

        getWebcamTask.setOnSucceeded(event -> {
            defaultWebcam = getWebcamTask.getValue();
            defaultWebcamPanel = new WebcamPanel(defaultWebcam);
            Platform.runLater(() -> {
                creatDefaultWebcamPanel(defaultWebcamPanelNode);
                mainContainer.getChildren().clear();
                mainContainer.getChildren().add(defaultWebcamPanelNode);
            });
        });

        new Thread(getWebcamTask).start();

    }
}
