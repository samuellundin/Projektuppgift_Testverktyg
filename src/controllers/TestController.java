package controllers;

import entities.Test;
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
        String title = titleField.getText();
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();
        int time = Integer.parseInt(timeField.getText());
        boolean selfCorrecting = selfCorrectingCheckBox.isSelected();
        boolean showResult = showResultCheckBox.isSelected();

        Test test = new Test();
        test.setTitle(title);
        test.setStartDate(startDate);
        test.setEndDate(endDate);
        test.setTime(time);
        test.setSelfCorrecting(selfCorrecting);
        test.setShowResult(showResult);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/question.fxml"));
            Parent root = fxmlLoader.load();
            QuestionController questionController = fxmlLoader.getController();
            questionController.setTest(test);
            Stage stage = (Stage) titleField.getScene().getWindow();
            stage.setTitle("Add Question");
            stage.setScene(new Scene(root, 640, 480));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addAnswerAction() {
        if(answerFieldBox.getChildren().size() < 4) {
            answerLabelBox.getChildren().add(new Label("Answer:"));
            answerFieldBox.getChildren().add(new TextField());
        }
    }

    public void saveTestAction() {
    }

}
