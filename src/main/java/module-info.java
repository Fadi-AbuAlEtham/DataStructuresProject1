module com.datastructuresproject1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.datastructuresproject1 to javafx.fxml;
    exports com.datastructuresproject1;
}