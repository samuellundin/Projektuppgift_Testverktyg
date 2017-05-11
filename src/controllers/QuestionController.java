package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import modules.AnswerAreaModule;
import modules.AnswerFieldModule;

import java.net.URL;
import java.util.ResourceBundle;

public class QuestionController implements Initializable {

    @FXML
    private ComboBox<String> typeComboBox;
    @FXML
    private VBox answerBox;
    @FXML
    private Button addQuestionButton;

    private int answerCount = 0;

    public void addAnswer() {
        if(answerCount < 5) {
            answerBox.getChildren().add(new AnswerFieldModule());
            answerCount++;
        }
    }

    public void saveQuestion() {

    }

    public void removeAnswer() {
        if(answerCount > 0) {
            answerCount--;
            answerBox.getChildren().remove(answerCount);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeComboBox.setItems(FXCollections.observableArrayList("Single Choice", "Multiple Choice", "Ranking", "Text"));
        typeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals(typeComboBox.getItems().get(3))) {
                answerBox.getChildren().clear();
                answerCount = 0;
                addQuestionButton.setOnAction(e -> {
                    if(answerCount < 1) {
                        answerBox.getChildren().add(new AnswerAreaModule());
                        answerCount++;
                    }
                });
            } else {
                if (!newValue.equals(typeComboBox.getItems().get(3))) {
                    answerBox.getChildren().clear();
                    answerCount = 0;
                }
                addQuestionButton.setOnAction(e -> {
                    if(answerCount < 5) {
                        answerBox.getChildren().add(new AnswerFieldModule());
                        answerCount++;
                    }
                });
            }
        });
    }

}
