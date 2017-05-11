package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.TestService;

import java.io.IOException;
import java.time.LocalDate;

public class TestController {

    @FXML
    private TextField titleField;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private TextField timeField;
    @FXML
    private CheckBox selfCorrectingCheckBox;
    @FXML
    private CheckBox showResultCheckBox;

    @FXML
    private VBox answerFieldBox;
    @FXML
    private VBox answerLabelBox;

    public void cancelAction() {
        Stage stage = (Stage) titleField.getScene().getWindow();
        stage.close();
    }

    public void nextAction() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/question.fxml"));
            Stage stage = (Stage) titleField.getScene().getWindow();
            stage.setScene(new Scene(root, 640, 480));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void addTest() {
        String title = titleField.getText();
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();
        int time = Integer.parseInt(timeField.getText());
        boolean selfCorrecting = selfCorrectingCheckBox.isSelected();
        boolean showResult = showResultCheckBox.isSelected();
        TestService service = new TestService();
        service.addTest(title, startDate, endDate, time, selfCorrecting, showResult);
    }

    public void addAnswerAction() {
        if(answerFieldBox.getChildren().size() < 4) {
            answerLabelBox.getChildren().add(new Label("Answer:"));
            answerFieldBox.getChildren().add(new TextField());
        }
    }

    public void addQuestionAction() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/addQuestion.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add Question");
            stage.setScene(new Scene(root, 640, 480));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editQuestionAction() {
    }

    public void saveTestAction() {
    }
}
