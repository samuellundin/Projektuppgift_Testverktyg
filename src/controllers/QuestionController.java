package controllers;

import entities.Answer;
import entities.Question;
import entities.Test;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import modules.TextAnswerField;
import modules.CheckAnswerField;
import modules.RadioAnswerField;
import modules.RankAnswerField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class QuestionController implements Initializable {

    @FXML
    private TextField questionField;
    @FXML
    private ComboBox<String> typeComboBox;
    @FXML
    private TextField pointField;
    @FXML
    private VBox answerBox;
    @FXML
    private Button addAnswerButton;

    private int answerCount = 0;

    private List<Question> questionList;
    private int questionCount = 0;
    private int questionType;
    private ToggleGroup toggleGroup;

    private Test test;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeComboBox.getItems().addAll("Single Choice", "Multiple Choice", "Ranking", "Text");
        typeComboBox.setPromptText("Select type...");
        typeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            questionType = typeComboBox.getSelectionModel().getSelectedIndex();
            answerBox.getChildren().clear();
            answerCount = 0;
        });

        questionList = new ArrayList<>();
        toggleGroup = new ToggleGroup();
    }


    public void saveTestAction() {

    }

    public void addAnswerAction() {
        if(answerCount < 4) {
            switch (questionType) {
                case 0:
                    answerCount++;
                    RadioAnswerField radioField = new RadioAnswerField();
                    radioField.setRadioGroup(toggleGroup);
                    radioField.setAnswerCount(answerCount);
                    answerBox.getChildren().add(radioField);
                    break;
                case 1:
                    answerCount++;
                    CheckAnswerField checkField = new CheckAnswerField();
                    checkField.setAnswerCount(answerCount);
                    answerBox.getChildren().add(checkField);
                    break;
                case 2:
                    answerCount++;
                    RankAnswerField rankField = new RankAnswerField();
                    rankField.setAnswerCount(answerCount);
                    answerBox.getChildren().add(rankField);
                    break;
                case 3:
                    if(answerCount < 1) {
                        answerCount++;
                        TextAnswerField textField = new TextAnswerField();
                        answerBox.getChildren().add(textField);
                        break;
                    }
            }
        }
    }

    public void removeAnswerAction() {
        if(answerCount > 1) {
            answerCount--;
            answerBox.getChildren().remove(answerCount);
        }
    }

    public void nextQuestionAction() {
        if(validation()) {
            String questionText = questionField.getText();
            int type = typeComboBox.getSelectionModel().getSelectedIndex();
            int points = Integer.parseInt(pointField.getText());
            List<Answer> answerList = new ArrayList<>();
            for(int i = 0; i < answerCount; i++) {
                CheckAnswerField answerField = (CheckAnswerField) answerBox.getChildren().get(i);
                Answer answer = new Answer();
                answer.setAnswer(answerField.getText());
                if(answerField.isCorrect()) {
                    answer.setPoints(points);
                } else {
                    answer.setPoints(0);
                }
                answer.setOrder(i);
                answerList.add(answer);
            }
            Question question = new Question();
            question.setQuestion(questionText);
            question.setType(type);
            question.setPoints(points);
            question.setOrder(questionCount);
            question.setAnswerList(answerList);
            questionList.add(question);
            test.setQuestionList(questionList);
            reset();
        }
    }

    private boolean validation() {
        return questionField.getText().length() > 0 && typeComboBox.getSelectionModel().getSelectedIndex() > -1 && pointField.getText().length() > 0;
    }

    private void reset() {
        questionField.clear();
        pointField.clear();
        typeComboBox.getSelectionModel().clearSelection();
        answerBox.getChildren().clear();
        answerCount = 0;
    }

    private void addRadioAnswerField() {

    }

    private void addCheckAnswerField() {

    }
    private void addRankAnswerField() {

    }
    private void addTextAnswerField() {
        if(answerCount < 1) {

        }
    }
    public void setTest(Test test) {
        this.test = test;
    }
}
