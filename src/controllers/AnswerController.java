package controllers;

import entities.Answer;
import entities.Question;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import modules.TextAnswerField;
import modules.CheckAnswerField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AnswerController implements Initializable {

    @FXML
    private TextField questionField;
    @FXML
    private ComboBox<String> typeComboBox;
    @FXML
    private VBox answerBox;
    @FXML
    private TextField answerField;
    @FXML
    private Button addQuestionButton;

    private ObservableList<Question> questionData;
    private int answerCount = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeComboBox.setItems(FXCollections.observableArrayList("Single Choice", "Multiple Choice", "Ranking", "Text"));
        typeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals(typeComboBox.getItems().get(3))) {
                answerBox.getChildren().clear();
                answerCount = 0;
                addQuestionButton.setOnAction(e -> {
                    if(answerCount < 1) {
                        answerBox.getChildren().add(new TextAnswerField());
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
                        answerBox.getChildren().add(new CheckAnswerField());
                        answerCount++;
                    }
                });
            }
        });
    }

    public void addAnswer() {
        if(answerCount < 5) {
            answerBox.getChildren().add(new CheckAnswerField());
            answerCount++;
        }
    }

    public void removeAnswer() {
        if(answerCount > 0) {
            answerCount--;
            answerBox.getChildren().remove(answerCount);
        }
    }

    public void saveQuestion() {
        String questionName = questionField.getText();
        char type = (char) typeComboBox.getSelectionModel().getSelectedIndex();
        List<Answer> answerList = FXCollections.observableArrayList();

        for (Node node : answerBox.getChildren()) {
            if (node instanceof TextField) {
                Answer answer = new Answer();
                answer.setAnswer(((TextField) node).getText());
                answerList.add(answer);
            }
        }
        for(int i = 0; i < answerBox.getChildren().size(); i++) {

        }

        Question question = new Question();
        question.setQuestion(questionName);
        question.setType(type);

        questionData.add(question);
    }

    public void setQuestionData(ObservableList<Question> questionData) {
        this.questionData = questionData;
    }

}
