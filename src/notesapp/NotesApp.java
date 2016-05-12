package notesapp;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Lama
 */
public class NotesApp extends Application {

    private Stage primaryStage;

    private BorderPane rootPane;

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NotesApp.class.getResource("view/MainView.fxml"));
            System.out.println(loader.getLocation());

            rootPane = (BorderPane) loader.load();

            Scene scene = new Scene(rootPane);

            primaryStage.setScene(scene);

            primaryStage.show();

        } catch (IOException e) {
        }
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("NotesApp");

        initRootLayout();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
