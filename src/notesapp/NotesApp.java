package notesapp;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import notesapp.controller.Workspace;
import notesapp.view.MainViewController;

/**
 * Main app for application
 *
 * @author Lama
 */
public class NotesApp extends Application {

    /**
     * primary stage - main window
     */
    private Stage primaryStage;

    /**
     * BorderPane with main window
     */
    private BorderPane rootPane;

    /**
     * Dashboard - working space - goals etc.
     */
    private AnchorPane dashboard;

    /**
     * workspace - where we save us files
     */
    private Workspace workspace;

    /**
     * contains configuration
     */
    public Conf configuration = Conf.getInstance();

    public static String db = "app.db";

    /**
     * Init root layout
     */
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NotesApp.class.getResource("view/MainView.fxml"));
            MainViewController controller = loader.getController();

            rootPane = (BorderPane) loader.load();

            Scene scene = new Scene(rootPane);

            primaryStage.setScene(scene);

            primaryStage.show();

        } catch (IOException e) {
        }
    }

    /**
     * add dashboard or workspace to window
     */
    public void showDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NotesApp.class.getResource("view/dashboard/dashboard.fxml"));

            //load pane
            dashboard = loader.load();
            rootPane.setCenter(dashboard);
        } catch (IOException ex) {
        }

    }

    /**
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("NotesApp");
        this.primaryStage.setOnCloseRequest((WindowEvent event) -> {
            MainViewController c = new MainViewController();
            c.exitApp();
        });
        configuration.initDB();
//        configuration.workspaceInDB();

        initRootLayout();

        showDashboard();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public NotesApp() {

    }

    /**
     * return workspace
     *
     * @return Workspace
     */
    public Workspace getWorkspace() {
        return workspace;
    }

    /**
     * set workspace
     *
     * @param workspace
     */
    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

}
