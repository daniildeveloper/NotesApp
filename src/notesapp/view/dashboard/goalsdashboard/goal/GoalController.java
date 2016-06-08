package notesapp.view.dashboard.goalsdashboard.goal;

import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Lama
 */
public class GoalController {

    @FXML
    AnchorPane rootSingleGoal;

    @FXML
    private Label day;

    @FXML
    private VBox goalsContainer;

    @FXML
    private Button addGoalButton;

    @FXML
    private boolean isOnDashboard = false;

    private List<String> goals = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        addToList();

        makeCheckBox();
    }

    /**
     * add goals to list
     *
     * TODO: this function must add all from daily json to list
     */
    public void addToList() {
        goals.add("Do some very rush");
        goals.add("Yeahh");

    }

    /**
     * generate checkbox
     */
    public void makeCheckBox() {
        if (!goals.isEmpty()) {
            for (String g1 : goals) {
                CheckBox cb = new CheckBox(g1);
                cb.setStyle("-fx-text-fill: #307CF2;-fx-padding: 3px;");

                goalsContainer.getChildren().add(cb);
            }

        }
    }

    /**
     * create goal
     *
     * @param text
     */
    public void createGoalfromList(String text) {
        CheckBox checkBox = new CheckBox(text);
        //checkBox.setOnAction(value);

        //all checked goals are did
        if (checkBox.selectedProperty().getValue() == true) {
            checkBox.setStyle("");
        }
        goalsContainer.getChildren().add(checkBox);

        checkBox.setStyle("-fx-text-fill: #307CF2;-fx-padding: 3px;");
    }

    /**
     * add single goal to list
     *
     * @param text
     */
    public void addGoalToList(String text) {
        goals.add(text);
    }

    /**
     * for rerendering
     */
    private void removeCheckBoxesAndInputs() {
        goalsContainer.getChildren().clear();
        isOnDashboard = false;
    }

    /**
     * make an InputField for adding new goals
     */
    @FXML
    private void createInputField() {

        TextField textField = new TextField("");
        textField.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ENTER && !"".equals(textField.getText())) {
                addGoalToList(textField.getText());
                removeCheckBoxesAndInputs();
                makeCheckBox();
            }
        });

        if (!isOnDashboard) {
            goalsContainer.getChildren().add(textField);
            isOnDashboard = true;
        }
    }
}
