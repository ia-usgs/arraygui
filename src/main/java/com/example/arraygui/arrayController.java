package com.example.arraygui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class arrayController {
    private ArrayListManager arrayManager;

    @FXML
    private Button btnDoAction;

    @FXML
    private ListView<Integer> lst1Array;

    @FXML
    private ListView<Integer> lst2Array;

    @FXML
    private RadioButton rdb1Action;

    @FXML
    private RadioButton rdb2Action;

    @FXML
    private RadioButton rdb3Action;

    @FXML
    private RadioButton rdb4Action;

    @FXML
    private RadioButton rdb5Action;

    @FXML
    private RadioButton rdb6Action;

    @FXML
    private TextField txtIndex;

    @FXML
    private TextField txtSearchNbr;

    public void initialize() {
        arrayManager = new ArrayListManager(20);
        arrayManager.populateRandomNumbers(20);

        ToggleGroup actions = new ToggleGroup();
        rdb1Action.setToggleGroup(actions);
        rdb2Action.setToggleGroup(actions);
        rdb3Action.setToggleGroup(actions);
        rdb4Action.setToggleGroup(actions);
        rdb5Action.setToggleGroup(actions);
        rdb6Action.setToggleGroup(actions);

        lst1Array.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    void performAction(ActionEvent event) {
        if (rdb1Action.isSelected()) {
            displayArray();
        } else if (rdb2Action.isSelected()) {
            add();
        } else if (rdb3Action.isSelected()) {
            delete();
        } else if (rdb4Action.isSelected()) {
            sort();
        } else if (rdb5Action.isSelected()) {
            displaySize();
        } else if (rdb6Action.isSelected()) {
            search();
        }
    }

    private void displayArray() {
        lst1Array.getItems().setAll(arrayManager.getArray());
        lst2Array.getItems().clear();
    }

    private void add() {
        if (!txtIndex.getText().isEmpty() && !txtSearchNbr.getText().isEmpty()) {
            int pos = Integer.parseInt(txtIndex.getText());
            if (pos >= 0 && pos <= arrayManager.getSize()) {
                String[] elements = txtSearchNbr.getText().split(",");
                for (String element : elements) {
                    int num = Integer.parseInt(element);
                    arrayManager.addNumber(pos, num);
                    pos++;
                }
                displayArray();
            }
        }

        txtIndex.clear();
        txtSearchNbr.clear();
    }

    private void delete() {
        if (!txtIndex.getText().isEmpty()) {
            int pos = Integer.parseInt(txtIndex.getText());
            if (pos >= 0 && pos < arrayManager.getSize()) {
                arrayManager.deleteNumber(pos);
                displayArray();
            }
        }

        txtIndex.clear();
    }

    private void sort() {
        lst1Array.getItems().setAll(arrayManager.getArray());
        lst2Array.getItems().setAll(arrayManager.getSortedArray());
    }

    private void displaySize() {
        int size = arrayManager.getSize();
        DialogHelper.showInformationDialog("Array Info", "Array size: " + size);
    }

    private void search() {
        if (!txtSearchNbr.getText().isEmpty()) {
            lst1Array.getItems().setAll(arrayManager.getArray());
            lst1Array.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            int searchNumber = Integer.parseInt(txtSearchNbr.getText());
            arrayManager.searchNumber(searchNumber, lst1Array.getSelectionModel());
        }

        txtSearchNbr.clear();
    }
}
