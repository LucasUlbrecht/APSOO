module g6.project {
    requires javafx.controls;
    requires javafx.fxml;


    opens g6.project to javafx.fxml;
    exports g6.project;
}
