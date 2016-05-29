package notesapp.view.dashboard.goalsdashboard.goal;

import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
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

    private List<String> goals = new ArrayList<>();


    /**
     * Initializes the controller class.
     */
    public void initialize() {
        addToList();

        makeCheckBox();
    }

    public void addToList() {
        goals.add("Do some very rush");
        goals.add("Yeahh");

    }


    public void makeCheckBox() {
        for (String g1 : goals) {
            CheckBox cb = new CheckBox(g1);
            goalsContainer.getChildren().add(cb);
        }

    }

}
