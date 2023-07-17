package com.example.arraygui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DialogHelper {
    public static void showInformationDialog(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

