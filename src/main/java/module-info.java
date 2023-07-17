module com.example.arraygui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens com.example.arraygui to javafx.fxml;
    exports com.example.arraygui;
}