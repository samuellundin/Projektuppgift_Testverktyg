package modules;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class AnswerFieldModule extends HBox {

    private Label answerLabel;
    private TextField answerField;
    private CheckBox correctCheck;

    public AnswerFieldModule() {
        answerLabel = new Label("Answer:");
        answerLabel.setPadding(new Insets(0, 0, 0, 46));
        answerField = new TextField();
        answerField.setMinWidth(420);
        correctCheck = new CheckBox();
        setSpacing(10);
        setAlignment(Pos.CENTER);
        getChildren().addAll(answerLabel, answerField, correctCheck);
    }
}
