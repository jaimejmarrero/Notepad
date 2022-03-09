module main.notepad {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.notepad to javafx.fxml;
    exports main.notepad;
}