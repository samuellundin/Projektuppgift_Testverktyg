package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by johan on 2017-05-10.
 */
public class GroupController {

    @FXML
    private TextField groupNameField;

    public void cancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) groupNameField.getScene().getWindow();
        stage.close();
    }

    public void save(ActionEvent actionEvent) {

    }
}
