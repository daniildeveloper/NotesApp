package notesapp.view.dashboard.goalsdashboard;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import notesapp.view.dashboard.goalsdashboard.goal.GoalController;

/**
 * FXML Controller class
 *
 * @author Lama
 */
public class GoalsController {

    @FXML
    private AnchorPane goalsDashboarRootStage;

    @FXML
    private MenuButton menuButton;

    @FXML
    HBox hBox;

    @FXML
    private AnchorPane singleGoal;

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        initGoals();


    }

    public void initGoals() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GoalsController.class.getResource("goal/goal.fxml"));

//            GoalController gc = loader.getController();

            singleGoal = (AnchorPane) loader.load();


            hBox.getChildren().add(singleGoal);
        } catch (IOException ex) {
            Logger.getLogger(GoalsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
