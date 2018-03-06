package application;

import java.util.function.IntConsumer;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Text intersectionDuration;

    @FXML
    private Text intersectionSize;

    @FXML
    private TextField aSizeField;
    @FXML
    private TextField bSizeField;
    @FXML
    private ChoiceBox<String> hashListField;

    private IntersectionTester<Integer> intersectionTester;

    static private ChangeListener<String> sizeListener(TextField field, IntConsumer setSize) {
        return (observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                field.setText(oldValue);
            } else {
                try {
                    setSize.accept(Integer.parseInt(newValue));
                    field.setText(newValue);
                } catch (NumberFormatException e) {
                    field.setText(oldValue);
                }
            }
        };
    };

    @FXML
    private void initialize() {
        intersectionTester = new IntersectionTester<Integer>();
        intersectionTester.setGenerateCollection(Utils::generateRandomIntList);
        intersectionTester.setIntersection(new HashSetIntersection<Integer>());

        aSizeField.textProperty().addListener(sizeListener(aSizeField, intersectionTester::setaSize));
        bSizeField.textProperty().addListener(sizeListener(bSizeField, intersectionTester::setbSize));

        hashListField.valueProperty().addListener((Observable, oldValue, newValue) -> {
            intersectionTester.setHashListA(newValue == "list A");
        });
    }

    @FXML
    protected void onRunClick(ActionEvent event) {
        IntersectionTestResult result = intersectionTester.run();
        intersectionDuration.setText(String.format("Intersetion took: %s", result.getFormattedDuration()));
        intersectionSize.setText(String.format("Intersetion size: %d", result.getSize()));

    }

}
