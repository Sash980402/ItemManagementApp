package org.example.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.model.Item;

import java.util.ArrayList;

public class ItemManagementController {
    @FXML
    private TextField itemNameField;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TableView<Item> itemTable;
    @FXML
    private TableColumn<Item, Integer> idColumn;
    @FXML
    private TableColumn<Item, String> nameColumn;
    @FXML
    private TableColumn<Item, Integer> quantityColumn;
    @FXML
    private TableColumn<Item, Double> priceColumn;
    @FXML
    private TableColumn<Item, String> descriptionColumn;

    private final ArrayList<Item> itemList = new ArrayList<>();
    private int nextId = 1;

    @FXML
    private void initialize() {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));


        itemTable.setItems(FXCollections.observableArrayList(itemList));
    }

    @FXML
    private void addItem() {
        try {
            String name = itemNameField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());
            String description = descriptionField.getText();

            Item newItem = new Item(nextId++, name, quantity, price, description);
            itemList.add(newItem);
            itemTable.getItems().add(newItem);


            clearFields();
        } catch (NumberFormatException e) {
            showAlert("Error", "Quantity and Price must be numbers.");
        }
    }

    @FXML
    private void removeItem() {
        Item selectedItem = itemTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            itemList.remove(selectedItem);
            itemTable.getItems().remove(selectedItem);
        } else {
            showAlert("Error", "Please select an item to remove.");
        }
    }

    private void clearFields() {
        itemNameField.clear();
        quantityField.clear();
        priceField.clear();
        descriptionField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
