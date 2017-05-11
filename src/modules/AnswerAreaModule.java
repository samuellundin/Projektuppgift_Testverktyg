package modules;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

public class AnswerAreaModule extends HBox {

    private Label answerLabel;
    private TextArea answerArea;

    public AnswerAreaModule() {
        answerLabel = new Label("Answer:");
        answerArea = new TextArea();
        answerArea.setMaxWidth(420);
        answerArea.setMinHeight(240);
        setSpacing(10);
        setAlignment(Pos.TOP_CENTER);
        getChildren().addAll(answerLabel, answerArea);
    }

}
