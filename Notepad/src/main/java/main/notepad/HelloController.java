package main.notepad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.*;
import java.util.Scanner;

public class HelloController {
    @FXML
    public TextArea textInput;

    @FXML
    public MenuBar menuBar;

    final FileChooser fc = new FileChooser();

    public void onOpenClick(ActionEvent actionEvent) {
        Window wx = ((MenuItem)actionEvent.getTarget()).getParentPopup().getOwnerWindow();
        File pickedFile = fc.showOpenDialog(wx);
        if(pickedFile == null) return;

        StringBuilder readString = new StringBuilder();
        try (Scanner sx = new Scanner(pickedFile)) {
            while(sx.hasNext()) {
                readString.append(sx.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        textInput.setText(readString.toString());
    }

    public void onSaveClick(ActionEvent actionEvent) throws IOException {
        Window wx = ((MenuItem)actionEvent.getTarget()).getParentPopup().getOwnerWindow();
        File pickedFile = fc.showSaveDialog(wx);
        if(pickedFile == null) return;

        BufferedWriter bw = new BufferedWriter(new FileWriter(pickedFile));
        bw.write(textInput.getText());
        bw.close();
    }
}