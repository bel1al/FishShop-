module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.fishshop to javafx.fxml;
    exports org.fishshop;
}