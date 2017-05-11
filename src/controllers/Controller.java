package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    public void addTestAction() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/test.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 640, 480));
            stage.setTitle("Add Test");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editTestAction() {
    }

    public void gradeTestAction() {
    }

    public void shareTestAction() {
    }

    public void addUserAction() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/user.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 400, 400));
            stage.setTitle("Add User");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editUserAction() {
    }

    public void addGroupAction() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/addGroup.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 750, 600));
            stage.setTitle("Add group");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void editGroupAction() {
    }

    public void takeTestAction() {
    }

    public void showResultAction() {
    }

    public void settingsAction() {
    }

    public void logoutAction() {
    }

}
