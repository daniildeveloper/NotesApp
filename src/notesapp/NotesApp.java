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
 *
 * @author Lama
 */
public class NotesApp extends Application {

    private Stage primaryStage;

    private BorderPane rootPane;

    private AnchorPane dashboard;

    private Workspace workspace;

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NotesApp.class.getResource("view/MainView.fxml"));
            MainViewController controller = loader.getController();
//            controller.setMainApp(this);

            rootPane = (BorderPane) loader.load();

            Scene scene = new Scene(rootPane);

            primaryStage.setScene(scene);

            primaryStage.show();

        } catch (IOException e) {
        }
    }

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

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("NotesApp");
        this.primaryStage.setOnCloseRequest((WindowEvent event) -> {
            MainViewController c = new MainViewController();
            c.exitApp();
        });

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

    public Workspace getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

}
