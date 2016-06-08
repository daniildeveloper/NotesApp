package notesapp.view.dashboard;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import notesapp.view.dashboard.goalsdashboard.GoalsController;

/**
 * FXML Controller class
 *
 * Controll all what in dashboard happen
 *
 * @author Lama
 */
public class DashboardController {

    /**
     * Tab where goals display
     */
    @FXML
    private Tab goals;

    @FXML
    AnchorPane goalsTabAnchorPane;

    /**
     * main view for goals
     */
    @FXML
    private AnchorPane goalsTabDashboard;

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        showGoalsDashboard();

    }

    public void showGoalsDashboard() {
//        goals = new Tab();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DashboardController.class.getResource("goalsdashboard/goals.fxml"));
        GoalsController controller = loader.getController();

        try {
            goalsTabDashboard = (AnchorPane) loader.load();
            goalsTabAnchorPane.getChildren().add(goalsTabDashboard);
        } catch (IOException ex) {

        }

    }

}
