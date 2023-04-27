module addressbook {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens addressbook to javafx.fxml;
    exports addressbook;
}
