package org.example.employeemanagementdb;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;

public class HelloController {

    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, String> nameColumn;

    @FXML
    private TableColumn<Employee, String> typeColumn;

    @FXML
    private TableColumn<Employee, Double> salaryColumn;

    @FXML
    private TableColumn<Employee, String> hireDateColumn;

    @FXML
    private TextField nameField;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private TextField hourlyRateField;

    @FXML
    private TextField hoursWorkedField;

    @FXML
    private DatePicker hireDatePicker;

    private ObservableList<Employee> employeeList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        typeColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getType()));
        salaryColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getSalary()).asObject());
        hireDateColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getHireDate().toString()));

        employeeTable.setItems(employeeList);

        typeComboBox.setItems(FXCollections.observableArrayList("Full-time", "Part-time", "Contractor"));

        loadEmployeesFromDatabase();
    }

    private void loadEmployeesFromDatabase() {
        EmployeeData employeeData = new EmployeeData();
        employeeList.addAll(employeeData.getAllEmployees());
    }

    @FXML
    private void onAddEmployee() {
        String name = nameField.getText();
        String type = typeComboBox.getValue();
        double hourlyRate = 0.0;
        int hoursWorked = 0;

        if (hireDatePicker.getValue() == null) {
            showAlert("Invalid Input", "Please select a hire date.");
            return;
        }
        Date hireDate = Date.valueOf(hireDatePicker.getValue());

        try {
            if (!hourlyRateField.getText().isEmpty()) {
                hourlyRate = Double.parseDouble(hourlyRateField.getText());
            }
            if (!hoursWorkedField.getText().isEmpty()) {
                hoursWorked = Integer.parseInt(hoursWorkedField.getText());
            }
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter valid numeric values for Hourly Rate and Hours Worked.");
            return;
        }

        Employee newEmployee;
        switch (type) {
            case "Full-time" -> newEmployee = new FullTimeEmployee(name, hireDate);
            case "Part-time" -> newEmployee = new PartTimeEmployee(name, hourlyRate, hoursWorked, hireDate);
            case "Contractor" -> newEmployee = new Contractor(name, hourlyRate, hoursWorked, hireDate);
            default -> {
                showAlert("Error", "Employee type not recognized.");
                return;
            }
        }

        employeeList.add(newEmployee);
        EmployeeData employeeData = new EmployeeData();
        employeeData.createEmployee(newEmployee);

        clearFields();
    }

    @FXML
    private void onRemoveSelected() {
        Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {

            employeeList.remove(selectedEmployee);


            EmployeeData employeeData = new EmployeeData();
            employeeData.deleteEmployee(selectedEmployee.getId());
        } else {
            showAlert("No Selection", "Please select an employee to remove.");
        }
    }

    @FXML
    private void onSaveChanges() {
        Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            selectedEmployee.setName(nameField.getText());
            selectedEmployee.setType(typeComboBox.getValue());
            selectedEmployee.setHireDate(Date.valueOf(hireDatePicker.getValue()));

            EmployeeData employeeData = new EmployeeData();
            employeeData.updateEmployee(selectedEmployee);

            employeeTable.refresh();
        } else {
            showAlert("No Selection", "Please select an employee to edit.");
        }
    }

    private void clearFields() {
        nameField.clear();
        typeComboBox.setValue(null);
        hourlyRateField.clear();
        hoursWorkedField.clear();
        hireDatePicker.setValue(null);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
