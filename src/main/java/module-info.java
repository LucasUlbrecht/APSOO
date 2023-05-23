module g6.project {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;
    requires mysql.connector.java;

    opens g6.project to javafx.fxml;
    exports g6.project;
}
