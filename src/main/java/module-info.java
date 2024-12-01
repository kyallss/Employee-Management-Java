module org.example.employeemanagementdb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.example.employeemanagementdb to javafx.fxml;
    exports org.example.employeemanagementdb;
}